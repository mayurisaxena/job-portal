package com.ntu.ip.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ntu.ip.dto.CandidateDto;
import com.ntu.ip.service.CandidateService;
import com.ntu.ip.util.Constants;

@WebServlet(urlPatterns = "/CandidateSearch.do")
public class CandidateSearchController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3032196866960519955L;

	private CandidateService candidateService = new CandidateService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String skills = (String) request.getSession().getAttribute("skills");

		request.getSession().removeAttribute("skills");
		if (skills == null || skills.length() == 0) {
			skills = request.getParameter("skills");
		}
		List<CandidateDto> candidateList = new ArrayList<>();
		if (skills != null && skills.length() > 0) {
			candidateList.addAll(candidateService.getCandidatesBySkill(skills));
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jsonArray = gson.toJson(candidateList);
			int total = (int) ((candidateList.size() / Constants.MAX_ROWS_PER_PAGE) + 0.5);
			jsonArray = "{\"page\":1,\"total\":\"" + total + "\",\"records\":" + candidateList.size() + ",\"rows\":"
					+ jsonArray + "}";
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jsonArray);
		} else {

		}

	}

}

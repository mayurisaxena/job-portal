package com.ntu.ip.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ntu.ip.dto.JobDto;
import com.ntu.ip.service.JobService;

@WebServlet(urlPatterns = "/jobSearch.do")
public class JobSearchController extends HttpServlet {

	private static final String SKILLS2 = "skills";
	/**
	 * 
	 */
	private static final long serialVersionUID = -8341782287640462738L;
	private JobService jobService = new JobService();
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute(SKILLS2, request.getParameter(SKILLS2));
		request.getRequestDispatcher("/WEB-INF/search.jsp").forward(
				request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String skills = (String) request.getSession().getAttribute(SKILLS2);
		List<JobDto> jobList = new ArrayList<>();
		if(skills == null){
			jobList.addAll(jobService.getLatestJobs());
		}
		List<JobDto> jobsBySkills = jobService.getJobsBySkills(skills);
		if (jobsBySkills != null)
			jobList.addAll(jobsBySkills);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonArray = gson.toJson(jobList);
		jsonArray = "{\"page\":1,\"total\":\"2\",\"records\":" + jobList.size() + ",\"rows\":" + jsonArray + "}";
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonArray);
		
	}

}

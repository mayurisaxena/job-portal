package com.ntu.ip.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntu.ip.model.Candidate;
import com.ntu.ip.service.CandidateService;

@WebServlet(urlPatterns = "/candidateAdd.do")
public class CandidateController extends HttpServlet {
	
	private static final String CANDIDATE = "Candidate";

	/**
	 * 
	 */
	private static final long serialVersionUID = 2991764684355449276L;
	
	private CandidateService candidateService = new CandidateService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Candidate.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Candidate candidate = new Candidate();
		candidate.setFirstName(request.getParameter("firstname"));
		candidate.setUserName(request.getParameter("email"));
		candidate.setUsrPwd(request.getParameter("password1"));
		candidate.setAddress(request.getParameter("Address"));
		candidate.setContactNo(request.getParameter("number"));
		candidate.setQualification(request.getParameter("qualification"));
		candidate.setRole(CANDIDATE);
		candidateService.save(candidate);
		response.setStatus(1);
	}

}

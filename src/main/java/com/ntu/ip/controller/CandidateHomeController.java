package com.ntu.ip.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntu.ip.service.CandidateService;

@WebServlet(urlPatterns = "/candidateHome.do")
public class CandidateHomeController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8157627858596638743L;
	private CandidateService candidateService = new CandidateService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/CandidateHome.jsp").forward(request, response);
	}
	
}

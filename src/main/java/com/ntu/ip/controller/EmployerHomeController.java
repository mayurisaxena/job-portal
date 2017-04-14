package com.ntu.ip.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Employerhome.do")
public class EmployerHomeController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 33518204110182032L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/EmployerHome.jsp").forward(request, response);
	}
}

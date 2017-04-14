package com.ntu.ip.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntu.ip.model.Employer;
import com.ntu.ip.service.EmployerService;

@WebServlet(urlPatterns = "/employerAdd.do")
public class EmployerController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4720060139357905574L;

	private static final String EMPLOYER = "Employer";

	private EmployerService employerService = new EmployerService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/employee.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employer employer = new Employer();
		employer.setAlias(request.getParameter("aliasname"));
		employer.setUserName(request.getParameter("email"));
		employer.setRole(EMPLOYER);
		employer.setUsrPwd(request.getParameter("password"));
		employer.setCompanyName(request.getParameter("company"));
		employer.setContactNo(request.getParameter("number"));
		employer.setAddress(request.getParameter("Address"));
		employerService.save(employer);
		response.setStatus(1);
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

	}

}

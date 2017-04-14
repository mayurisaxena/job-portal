package com.ntu.ip.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntu.ip.model.User;
import com.ntu.ip.service.LoginService;

@WebServlet(urlPatterns = "/login.do")
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5153085872314798881L;
	private LoginService userValidationService = new LoginService();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("email");
		String password = request.getParameter("password1");
		User user = userValidationService.isUserValid(name, password);

		if (user != null) {
			if (user.getRole().equals("Candidate")) {
				request.getSession().setAttribute("userRole", "candidate");
				request.getSession().setAttribute("userId", user.getId());
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/WEB-INF/views/CandidateHome.jsp").forward(
						request, response);
			} else {
				request.getSession().setAttribute("userRole", "employer");
				request.getSession().setAttribute("userId", user.getId());
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/WEB-INF/views/EmployerHome.jsp").forward(
						request, response);
			}
			
		} else {
			request.setAttribute("errorMessage", "Invalid Credentials!");
			request.getRequestDispatcher("/WEB-INF/home.jsp").forward(
					request, response);
		}
	}

}

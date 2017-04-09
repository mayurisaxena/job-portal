package com.ntu.ip.jobs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jobs.do")
public class JobsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3810191809855997591L;
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/jobs.jsp").forward(
				request, response);
	}

}

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
import com.ntu.ip.model.Job;
import com.ntu.ip.service.JobService;

@WebServlet(urlPatterns = "/jobSearch.do")
public class JobSearchController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8341782287640462738L;
	private JobService jobService = new JobService();
	
//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("/WEB-INF/views/jobs.jsp").forward(
//				request, response);
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String skills = request.getParameter("skills");
		List<Job> jobList = new ArrayList<>();
		if(skills == null){
			jobList.addAll(jobService.getLatestJobs());
		}
		List<Job> jobsBySkills = jobService.getJobsBySkills(skills);
		if (jobsBySkills != null)
			jobList.addAll(jobsBySkills);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonArray = gson.toJson(jobList);
		jsonArray = "{\"page\":1,\"total\":\"2\",\"records\":" + jobList.size() + ",\"rows\":" + jsonArray + "}";

		response.getWriter().print(jsonArray);
	}

}
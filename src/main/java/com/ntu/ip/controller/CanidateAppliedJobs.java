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

@WebServlet(urlPatterns = "/canJobSearch.do")
public class CanidateAppliedJobs extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -342266446909036812L;
	/**
	 * 
	 */
	private JobService jobService = new JobService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String candidateId = request.getAttribute("candidateId").toString();
		List<Job> jobList = new ArrayList<>();
		List<Job> jobsBySkills = jobService.getJobsByCandidate(candidateId);
		if (jobsBySkills != null)
			jobList.addAll(jobsBySkills);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonArray = gson.toJson(jobList);
		jsonArray = "{\"page\":1,\"total\":\"2\",\"records\":" + jobList.size() + ",\"rows\":" + jsonArray + "}";

		response.getWriter().print(jsonArray);
	}

}

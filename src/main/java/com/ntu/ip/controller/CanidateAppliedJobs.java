package com.ntu.ip.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ntu.ip.dto.JobDto;
import com.ntu.ip.model.Candidate;
import com.ntu.ip.model.Job;
import com.ntu.ip.service.CandidateService;

@WebServlet(urlPatterns = "/canApplications.do")
public class CanidateAppliedJobs extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -342266446909036812L;
	/**
	 * 
	 */
	private CandidateService candidateService = new CandidateService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/CanApplications.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String candidateId = request.getSession().getAttribute("userId").toString();
		
		Candidate candidate = candidateService.getCandidateById(Integer.parseInt(candidateId));
		Set<Job> jobs = candidate.getAppliedJobs();
		List<JobDto> jobsList = new ArrayList<JobDto>();
		for (Job job:jobs) {
			JobDto jd = new JobDto(job);
			jobsList.add(jd);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonArray = gson.toJson(jobsList);
		jsonArray = "{\"page\":1,\"total\":\"2\",\"records\":" + jobsList.size() + ",\"rows\":" + jsonArray + "}";

		response.getWriter().print(jsonArray);
	}

}

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
import com.ntu.ip.service.JobService;


@WebServlet(urlPatterns = "/applyJob.do")
public class ApplyJob extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1730419570667838136L;
	
	private JobService jobService = new JobService();
	private CandidateService candidateService = new CandidateService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/CanApplications.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String candidateId = request.getSession().getAttribute("userId").toString();
		String jobIdS = (String) request.getParameter("jobId");
		Candidate candidate = candidateService.getCandidateById(Integer.parseInt(candidateId));
		Set<Job> jobs = candidate.getAppliedJobs();
		Job job = jobService.getJobById(jobIdS);
		jobs.add(job);
		candidate.setAppliedJobs(jobs);
		candidateService.save(candidate);
		request.getRequestDispatcher("/WEB-INF/views/CanApplications.jsp").forward(request, response);
	}

}

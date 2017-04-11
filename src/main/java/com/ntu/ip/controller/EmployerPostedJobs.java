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
import com.ntu.ip.dto.JobDto;
import com.ntu.ip.service.JobService;
import com.ntu.ip.util.Constants;

@WebServlet(urlPatterns = "/empJobSearch.do")
public class EmployerPostedJobs extends HttpServlet {

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
		Object empIdAttri = request.getSession().getAttribute("userId");
		String employeeId = empIdAttri == null ? "" : empIdAttri.toString();
		List<JobDto> jobList = new ArrayList<>();
		List<JobDto> jobsByEmp = jobService.getJobsByEmployer(employeeId);
		if (jobsByEmp != null)
			jobList.addAll(jobsByEmp);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonArray = gson.toJson(jobList);
		int total = (int) ((jobList.size() / Constants.MAX_ROWS_PER_PAGE) + 0.5);
		jsonArray = "{\"page\":1,\"total\":\""+total+"\",\"records\":" + jobList.size() + ",\"rows\":" + jsonArray + "}";

		response.getWriter().print(jsonArray);
	}

}

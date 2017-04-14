package com.ntu.ip.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntu.ip.model.Employer;
import com.ntu.ip.model.Job;
import com.ntu.ip.model.Skill;
import com.ntu.ip.service.EmployerService;
import com.ntu.ip.service.JobService;
import com.ntu.ip.service.SkillService;

@WebServlet(urlPatterns = "/JobAdd.do")
public class JobAddController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4720060139357905574L;

	private JobService jobService = new JobService();
	private SkillService skillService = new SkillService();
	private EmployerService employerService = new EmployerService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/employee.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Job job = new Job();
		job.setDescription(request.getParameter("jobdesc"));
		job.setPostedDate(new Date());
		String skillsStr = request.getParameter("jobskills");
		Set<Skill> skills = skillService.getAndAddNewSkillSet(skillsStr.split(","));
		job.setSkills(skills);
		job.setTitle(request.getParameter("jobtitle"));
		Object empIdAttri = request.getSession().getAttribute("userId");
		String employeeId = empIdAttri == null ? "" : empIdAttri.toString();
		Employer employer = employerService.getById(employeeId);
		job.setEmployer(employer);
		jobService.save(job);
		response.setStatus(1);
		request.getRequestDispatcher("/WEB-INF/views/EmployerHome.jsp").forward(request, response);
	}

}

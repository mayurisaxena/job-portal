package com.ntu.ip.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javassist.expr.Instanceof;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntu.ip.model.Candidate;
import com.ntu.ip.model.Skill;
import com.ntu.ip.model.User;
import com.ntu.ip.service.CandidateService;
import com.ntu.ip.service.SkillService;

@WebServlet(urlPatterns = "/candidateUpdate.do")
public class CandidateUpdateController extends HttpServlet {
	
	private static final String CANDIDATE = "Candidate";

	/**
	 * 
	 */
	private static final long serialVersionUID = 2991764684355449276L;
	
	private CandidateService candidateService = new CandidateService();
	private SkillService skillService = new SkillService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Candidate candidate = candidateService.getCandidateById((Integer)request.getSession().getAttribute("userId"));
		request.setAttribute("firstname",candidate.getUserName());
		request.setAttribute("qualification",candidate.getQualification());
		request.setAttribute("description",candidate.getDescription());
		String skill = "";
		for (Skill sk: candidate.getSkills()) {
			skill = sk.getSkillName()+","+skill;
		}
		request.setAttribute("skills",skill);
		request.getRequestDispatcher("/WEB-INF/views/CanProfileEdit.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Candidate candidate = candidateService.getCandidateById((Integer)request.getSession().getAttribute("userId"));
		candidate.setFirstName(request.getParameter("firstname"));
		candidate.setQualification(request.getParameter("qualification"));
		candidate.setDescription(request.getParameter("description"));
		String[] skillStr = request.getParameter("skills").split(",");
		List<Skill> skillList = skillService.getAndAddNewSkills(skillStr);
		Set<Skill> skillSet = new HashSet<>(skillList);
		candidate.setSkills(skillSet);
		//TODO  add description
		//candidate.setDescription(request.getParameter("description"));
		candidate.setRole(CANDIDATE);
		candidateService.save(candidate);
		response.setStatus(1);
	}

}

package com.ntu.ip.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ntu.ip.dao.CandidateDao;
import com.ntu.ip.dao.EmployerDao;
import com.ntu.ip.dao.JobDao;
import com.ntu.ip.dao.SkillDao;
import com.ntu.ip.model.Candidate;
import com.ntu.ip.model.Employer;
import com.ntu.ip.model.Job;
import com.ntu.ip.model.Skill;

public class InitService {

	private CandidateDao candidateDao = new CandidateDao();
	private EmployerDao employerDao = new EmployerDao();
	private JobDao jobDao = new JobDao();
	private SkillDao skillDao = new SkillDao();
	private Set<Skill> skils = new HashSet<>();

	public Candidate createCandidate(String userName, String firstname, String role, String pwd, String lastName,
			String address, String description) {
		Candidate emp = new Candidate();
		emp.setFirstName(firstname);
		emp.setUsrPwd(pwd);
		emp.setRole(role);
		emp.setUserName(userName);
		emp.setAddress(address);
		emp.setDescription(description);
		emp.setLastName(lastName);
		return emp;
	}

	public void createJobs() {

		skils.add(new Skill("Java"));
		skils.add(new Skill("Scala"));
		skils.add(new Skill(".Net"));
		skillDao.save(skils);
		List<Job> jobs = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			jobs.add(createJob("Job" + i, skils));
		}
		jobDao.save(jobs);
	}

	public Job createJob(String description, Set<Skill> skills) {
		Job job = new Job();
		job.setDescription(description);
		job.setSkills(skills);
		return job;
	}

	public Employer createEmployer(String userName, String firstName, String role, String pwd, String address,
			String companyName, String description) {
		Employer emp = new Employer();
		//emp.setFirstName(firstName);
		emp.setUsrPwd(pwd);
		emp.setRole(role);
		emp.setUserName(userName);
		emp.setAddress(address);
		emp.setDescription(description);
		emp.setCompanyName(companyName);
		return emp;
	}
}

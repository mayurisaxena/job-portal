package com.ntu.ip.service;

import java.util.Arrays;
import java.util.List;

import com.ntu.ip.dao.JobDao;
import com.ntu.ip.model.Job;

public class JobService {

	private JobDao jobDao = new JobDao();

	
	public List<Job> getJobsBySkills(String skills) {
		List<String> skillsList = Arrays.asList(skills.split(","));
		return jobDao.getJobsBySkills(skillsList);
	}
	
	public List<Job> getJobsByCandidate(String candidateId){
		return jobDao.getJobsByCandidate(candidateId);
	}
	
	public List<Job> getJobsByEmployer(String employerId){
		return jobDao.getJobsByEmployer(employerId);
	}
	
	public List<Job> getLatestJobs(){
		return jobDao.getLatestJobList();
	}

}

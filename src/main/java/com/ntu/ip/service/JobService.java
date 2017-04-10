package com.ntu.ip.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ntu.ip.dao.JobDao;
import com.ntu.ip.dto.JobDto;
import com.ntu.ip.model.Job;

public class JobService {

	private JobDao jobDao = new JobDao();

	public List<JobDto> getJobsBySkills(String skills) {
		List<String> skillsList = Arrays.asList(skills.split(","));
		List<JobDto> jobDto = new ArrayList<>();
		List jobsBySkills = jobDao.getJobsBySkills(skillsList);
		for (Object job : jobsBySkills) {
			Object[] objr = (Object[]) job;
			jobDto.add(new JobDto((Job) objr[0]));
		}
		return jobDto;
	}

	public List<Job> getJobsByCandidate(String candidateId) {
		return jobDao.getJobsByCandidate(candidateId);
	}

	public List<Job> getJobsByEmployer(String employerId) {
		return jobDao.getJobsByEmployer(employerId);
	}

	public List<JobDto> getLatestJobs() {
		List<JobDto> jobDto = jobDao.getLatestJobList().stream().map(e -> new JobDto(e)).collect(Collectors.toList());
		return jobDto;
	}
	
	public Job getJobById(String id){
		return jobDao.getById(Integer.parseInt(id));
	}

}

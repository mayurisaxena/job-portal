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

	public List<JobDto> getJobsBySkills(String skills, String candidateId) {
		int cid = candidateId == null ? -1 : Integer.parseInt(candidateId);
		List<String> skillsList = Arrays.asList(skills.split(","));
		List<JobDto> jobDto = new ArrayList<>();
		List jobsBySkills = jobDao.getJobsBySkills(skillsList);
		for (Object jobR : jobsBySkills) {
			Object[] objr = (Object[]) jobR;
			Job job = (Job) objr[0];
			JobDto dtoJob = new JobDto(job);
			dtoJob.setShowApply(!job.hasAppliedForTheJob(cid));
			jobDto.add(dtoJob);
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

	public Job getJobById(String id) {
		return jobDao.getById(Integer.parseInt(id));
	}

}

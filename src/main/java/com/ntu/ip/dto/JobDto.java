package com.ntu.ip.dto;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import com.ntu.ip.model.Employer;
import com.ntu.ip.model.Job;
import com.ntu.ip.model.Skill;

public class JobDto {

	private int jobId;
	private String title;
	private String description;
	private String skills;
	private String postedDate;
	private String employer;
	private boolean showApply = false;

	public boolean isShowApply() {
		return showApply;
	}

	public void setShowApply(boolean showApply) {
		this.showApply = showApply;
	}

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public JobDto(Job job) {
		this.jobId = job.getId();
		this.title = job.getTitle();
		this.description = job.getDescription();
		Set<String> skillset = new HashSet<>();
		Set<Skill> skills = job.getSkills();
		for (Skill skill : skills) {
			skillset.add(skill.getSkillName().toUpperCase());
		}
		this.skills = skillset.stream().map(e -> e + ", ").reduce("", String::concat);
		this.postedDate = dateFormat.format(job.getPostedDate());
		Employer employer = job.getEmployer();
		this.employer = employer == null ? "" : employer.getAlias();
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

}

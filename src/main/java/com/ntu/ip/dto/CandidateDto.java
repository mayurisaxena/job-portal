package com.ntu.ip.dto;

import com.ntu.ip.model.Candidate;

public class CandidateDto {
	
	private int id;
	
	private String skills;
	
	private String education;
	
	private String contactNo;

	public CandidateDto(Candidate can) {
		this.id = can.getId();
		this.skills = can.getSkills().stream().map(e->e.getSkillName()).reduce("", String::concat);
		this.education = can.getQualification();
		this.contactNo = can.getContactNo();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	

}

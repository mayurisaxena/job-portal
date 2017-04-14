package com.ntu.ip.dto;

import java.util.HashSet;
import java.util.Set;

import com.ntu.ip.model.Candidate;
import com.ntu.ip.model.Skill;

public class CandidateDto {

	private int id;

	private String skills;

	private String education;

	private String contactNo;

	private String displayName;

	public CandidateDto(Candidate can) {
		this.id = can.getId();
		Set<String> skillset = new HashSet<>();
		Set<Skill> skills = can.getSkills();
		for (Skill skill : skills) {
			skillset.add(skill.getSkillName().toUpperCase());
		}
		this.skills = skillset.stream().map(e -> e + ", ").reduce("", String::concat);
		this.education = can.getQualification();
		this.contactNo = can.getContactNo();
		this.displayName = can.getFirstName();
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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}

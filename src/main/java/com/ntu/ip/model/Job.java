package com.ntu.ip.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Job_Id", columnDefinition = "INTEGER")
	private int id;
	
	@Column(name = "Job_Title", columnDefinition = "VARCHAR(100)")
	private String title;

	@Column(name = "Description", columnDefinition = "VARCHAR(200)")
	private String description;

	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Job_Skill", joinColumns = { @JoinColumn(name = "Job_Id") }, inverseJoinColumns = {
			@JoinColumn(name = "Skill_Id") })
	private Set<Skill> skills;

	@ManyToOne()
	@JoinColumn(name = "Employer_Id")
	private Employer employer;

	@ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "Candidate_Job", joinColumns = { @JoinColumn(name = "Job_Id") }, inverseJoinColumns = {
			@JoinColumn(name = "Candidate_Id") })
	private Set<Candidate> appliedCandidates;
	
	@Column(name="Posted_Date", columnDefinition="DATE")
	private Date postedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

}
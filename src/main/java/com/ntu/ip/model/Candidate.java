package com.ntu.ip.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Candidate")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "Candidate_Id") ),
		@AttributeOverride(name = "firstName", column = @Column(name = "FirstName") ) })
public class Candidate extends User {

	public Candidate() {
	}

	@Column(name = "lastName", columnDefinition = "VARCHAR(50)")
	private String lastName;

	@Column(name = "dob", columnDefinition = "DATE")
	private Date dob;
	
	@Column(name = "FirstName", columnDefinition = "VARCHAR(50)")
	private String firstName;

	@Column(name = "ContactNumber", columnDefinition = "VARCHAR(50)")
	private String contactNumber;

	@Column(name = "Address", columnDefinition = "VARCHAR(300)")
	private String address;

	@Column(name = "HEQ", columnDefinition = "VARCHAR(100)")
	private String heq;

	@Column(name = "CurrentLocation", columnDefinition = "VARCHAR(100)")
	private String currentLocation;

	@Column(name = "Description", columnDefinition = "VARCHAR(1500)")
	private String description;
	
	@Column(name = "Qualification", columnDefinition = "VARCHAR(100)")
	private String qualification;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Candidate_Skill", joinColumns = { @JoinColumn(name = "Candidate_Id") }, inverseJoinColumns = {
			@JoinColumn(name = "Skill_Id") })
	private Set<Skill> skills;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Candidate_Job", joinColumns = { @JoinColumn(name = "Candidate_Id") }, inverseJoinColumns = {
			@JoinColumn(name = "Job_Id") })
	private List<Job> appliedJobs;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHeq() {
		return heq;
	}

	public void setHeq(String heq) {
		this.heq = heq;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

}

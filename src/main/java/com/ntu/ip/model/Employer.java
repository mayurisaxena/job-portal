package com.ntu.ip.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employer")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "Employer_Id") ),
	@AttributeOverride(name = "firstName", column = @Column(name = "FirstName") ) })
public class Employer extends User{

	@Column(name="Address", columnDefinition="VARCHAR(250)")
	private String address;
	
	@Column(name="CompanyName", columnDefinition="VARCHAR(250)")
	private String companyName;
	
	@Column(name="Alias", columnDefinition="VARCHAR(20)")
	private String alias;
	
	@Column(name="Description", columnDefinition="VARCHAR(500)")
	private String description;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="employer")
	private List<Job> myJobs;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Job> getMyJobs() {
		return myJobs;
	}

	public void setMyJobs(List<Job> myJobs) {
		this.myJobs = myJobs;
	}
	
	
	
}

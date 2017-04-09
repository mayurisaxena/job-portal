package com.ntu.ip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "User")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

	public User() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "Id", columnDefinition = "INT")
	private int id;

	@Column(name = "UserName", columnDefinition = "VARCHAR(100)")
	private String userName;

	@Column(name = "Role", columnDefinition = "VARCHAR(50)")
	private String role;
	
	@Column(name="Usr_Pwd", columnDefinition = "VARCHAR(100)")
	private String usrPwd;
	
	@Column(name="ContactNo", columnDefinition="VARCHAR(50)")
	private String contactNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsrPwd() {
		return usrPwd;
	}

	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}

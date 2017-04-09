package com.ntu.ip.service;

import com.ntu.ip.dao.EmployerDao;
import com.ntu.ip.model.Employer;

public class EmployerService {
	
	private EmployerDao employerDao = new EmployerDao();
	
	public void save(Employer employer){
		employerDao.save(employer);
	}

}

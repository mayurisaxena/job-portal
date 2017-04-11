package com.ntu.ip.service;

import com.ntu.ip.dao.EmployerDao;
import com.ntu.ip.model.Employer;

public class EmployerService {
	
	private EmployerDao employerDao = new EmployerDao();
	
	public void save(Employer employer){
		employerDao.save(employer);
	}
	
	public Employer getById(String ids){
		int id = ids == null ? -1 : Integer.parseInt(ids);
		return employerDao.getById(id);
	}

}

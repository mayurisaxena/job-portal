package com.ntu.ip.service;

import com.ntu.ip.dao.UserDao;

public class LoginService {

	private UserDao userDao = new UserDao();

	
	public boolean isUserValid(String user, String password) {
		return userDao.validuser(user, password);
	}
	
	public void createNewUser(){
		
	}

}

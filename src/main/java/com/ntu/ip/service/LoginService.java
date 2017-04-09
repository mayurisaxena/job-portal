package com.ntu.ip.service;

import com.ntu.ip.dao.UserDao;
import com.ntu.ip.model.User;

public class LoginService {

	private UserDao userDao = new UserDao();

	
	public User isUserValid(String user, String password) {
		return userDao.validuser(user, password);
	}
	
	public void createNewUser(){
		
	}

}

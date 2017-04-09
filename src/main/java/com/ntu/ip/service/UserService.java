package com.ntu.ip.service;

import org.hibernate.HibernateException;

import com.ntu.ip.dao.CandidateDao;
import com.ntu.ip.dao.EmployerDao;
import com.ntu.ip.model.Candidate;
import com.ntu.ip.model.Employer;
import com.ntu.ip.model.User;

public class UserService {

	private CandidateDao candidateDao = new CandidateDao();
	
	private EmployerDao employerDao = new EmployerDao();

	public boolean createNewUser(User user) throws Exception {
		
		try {
			if(user.getRole().equals("CANDIDATE")){
				candidateDao.save((Candidate) user);
			}else if(user.getRole().equals("EMPLOYER")){
				employerDao.save((Employer)user);
			}else{
				throw new Exception("Invalid User type");
			}
		} catch (HibernateException e) {
			throw new Exception("error occured while saving the user");
		}
		return true;

	}
	
	public void initCreate(){
		Candidate c1 = new Candidate();
		c1.setUserName("udarajag@gmail.com");
		c1.setDescription("I am a software engineer.");
		c1.setFirstName("Udara");
		c1.setLastName("Perera");
	}

}

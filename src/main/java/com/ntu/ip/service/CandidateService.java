package com.ntu.ip.service;

import com.ntu.ip.dao.CandidateDao;
import com.ntu.ip.model.Candidate;

public class CandidateService {
	
	private CandidateDao candidateDao = new CandidateDao();
	
	public void save(Candidate candidate){
		candidateDao.save(candidate);
	}
	
	public Candidate getCandidateById(String id){
		return candidateDao.getCandidateById(Integer.parseInt(id));
	}

}

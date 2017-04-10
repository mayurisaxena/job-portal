package com.ntu.ip.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ntu.ip.dao.CandidateDao;
import com.ntu.ip.dto.CandidateDto;
import com.ntu.ip.model.Candidate;

public class CandidateService {
	
	private CandidateDao candidateDao = new CandidateDao();
	
	public void save(Candidate candidate){
		candidateDao.save(candidate);
	}
	
	public void update(Candidate candidate){
		candidateDao.update(candidate);
	}
	
	public Candidate getCandidateById(Integer id){
		return candidateDao.getById(id);
	}
	
	public List<CandidateDto> getCandidatesBySkill(String skills){
		List<String> skillsList = Arrays.asList(skills.split(","));
		List<CandidateDto> candidateDto = new ArrayList<>();
		List canBySkills = candidateDao.getCandidatesBySkills(skillsList);
		for (Object can : canBySkills) {
			Object[] objr = (Object[]) can;
			candidateDto.add(new CandidateDto((Candidate) objr[0]));
		}
		return candidateDto;
	}

}

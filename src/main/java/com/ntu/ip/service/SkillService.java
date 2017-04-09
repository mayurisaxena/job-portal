package com.ntu.ip.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ntu.ip.dao.JobDao;
import com.ntu.ip.dao.SkillDao;
import com.ntu.ip.model.Employer;
import com.ntu.ip.model.Skill;

public class SkillService {

	private SkillDao skillDao = new SkillDao();
	
	public void save(Skill skill){
		skillDao.save(skill);
	}
	
	public List<Skill> getAndAddNewSkills(String[] skills) {
		if (skills == null || skills.length == 0)
			return null;
		List<String> skillList = new ArrayList<String>();
		for (String str:skills) {
			skillList.add(str.trim());
		}
		List<Skill> skillsOld = skillDao.getSkills(skillList);
		if (skillsOld != null) {
			for (Skill sk: skillsOld) {
				skillList.remove(sk.getSkillName());
			}
		}
		for (String sk: skillList) {
			Skill newSk = new Skill();
			newSk.setSkillName(sk.trim());
			save(newSk);
		}
		if (skillList != null && skillList.size()>0)
			skillsOld.addAll(skillDao.getSkills(skillList));
		return skillsOld;
	}
}

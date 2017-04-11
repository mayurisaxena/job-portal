package com.ntu.ip.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ntu.ip.model.Skill;

public class SkillDao extends AbstractDao<Skill> {

	public List<Skill> getSkills(List<String> skills) {
		Session session = getNewSession();
		String sql = "from Skill sk where sk.skillName in (:skills)";
		Query query = session.createQuery(sql);
		query.setParameterList("skills", skills);
		return getSkills(query, session);
	}
	
	@SuppressWarnings("unchecked")
	private List<Skill> getSkills(Query query, Session session) {
		Transaction tx = null;
		List<Skill> skillList = null;
		try {
			tx = session.beginTransaction();
			skillList = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return skillList;

	}
}

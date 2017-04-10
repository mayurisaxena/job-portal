package com.ntu.ip.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ntu.ip.model.Candidate;

public class CandidateDao extends AbstractDao<Candidate>{

	public Candidate getCandidateById(int id) {
		Transaction tx = null;
		Session session = getNewSession();
		Candidate candidate = null;
		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Candidate.class);
			criteria.add(Restrictions.eq("id", id));
			candidate = (Candidate) criteria.uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return candidate;
	}
	
	public List<Candidate> getCandidatesBySkills(List<String> skills){
		Session session = getNewSession();
		String sql = "from Candidate cd inner join cd.skills sk where sk.skillName in (:skills)";
		Query query = session.createQuery(sql);
		query.setParameterList("skills", skills);
		return getList(query, session);
	}

}

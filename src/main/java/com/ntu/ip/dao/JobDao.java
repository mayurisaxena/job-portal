package com.ntu.ip.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ntu.ip.model.Job;

public class JobDao extends AbstractDao<Job> {

	public List<Job> getJobsBySkills(List<String> skills) {
		Session session = getNewSession();
		String sql = "from Job jb inner join jb.skills sk where sk.skillName in (:skills)";
		Query query = session.createQuery(sql);
		query.setParameterList("skills", skills);
		return getJobs(query, session);
	}

	@SuppressWarnings("unchecked")
	private List<Job> getJobs(Query query, Session session) {
		Transaction tx = null;
		List<Job> jobList = null;
		try {
			tx = session.beginTransaction();
			jobList = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobList;

	}

	public List<Job> getJobsByCandidate(String candidateId) {
		String sql = "from Job jb inner join jb.candidate can where can.id = (:canId)";
		Session session = getNewSession();
		Query query = session.createQuery(sql);
		query.setParameter("canId", candidateId);
		return getJobs(query, session);
	}
	
	public List<Job> getJobsByEmployer(String employerId) {
		String sql = "from Job jb inner join jb.employer emp where emp.id = (:empId)";
		Session session = getNewSession();
		Query query = session.createQuery(sql);
		query.setParameter("empId", employerId);
		return getJobs(query, session);
	}
	
	public List<Job> getLatestJobList(){
		String sql = "from Job jb order by jb.postedDate desc";
		Session session = getNewSession();
		Query query = session.createQuery(sql);
		query.setMaxResults(50);
		return getJobs(query, session);
	}
	
	public Job getJobById(int id){
		Transaction tx = null;
		Session session = getNewSession();
		Job job = null;
		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Job.class);
			criteria.add(Restrictions.eq("id", id));
			job = (Job) criteria.uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return job;
	}
}

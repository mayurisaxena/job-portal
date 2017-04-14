package com.ntu.ip.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class AbstractDao<T> {

	private SessionFactory sessionFactory;

	private Class<T> classType;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		super();
		this.sessionFactory = SessionFactoryHelper.getSessionFactory();
		this.classType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Transaction tx = null;
		Session session = getNewSession();
		List<T> list = null;
		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(classType);
			list = criteria.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public T getById(int id){
		Transaction tx = null;
		Session session = getNewSession();
		T t = null;
		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(classType);
			criteria.add(Restrictions.eq("id", id));
			t = (T) criteria.uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return t;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getList(Query query, Session session) {
		Transaction tx = null;
		List<T> list = null;
		try {
			tx = session.beginTransaction();
			list = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;

	}

	public void save(T t) {
		Transaction tx = null;
		Session session = getNewSession();
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(t);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void save(Set<T> entities) {
		Transaction tx = null;
		Session session = getNewSession();
		try {
			tx = session.beginTransaction();
			for (T t : entities) {
				session.saveOrUpdate(t);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void update(T t){
		Transaction tx = null;
		Session session = getNewSession();
		try {
			tx = session.beginTransaction();
			session.update(t);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
				e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void save(List<T> entities) {
		Transaction tx = null;
		Session session = getNewSession();
		try {
			tx = session.beginTransaction();
			for (T t : entities) {
				session.saveOrUpdate(t);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public Session getNewSession() {
		return this.sessionFactory.openSession();
	}

}

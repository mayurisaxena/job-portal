package com.ntu.ip.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ntu.ip.model.User;

public class UserDao extends AbstractDao<User> {

	@SuppressWarnings("unchecked")
	public User validuser(String userName, String pwd) {
		Transaction tx = null;
		List<User> list =null;
		Session session = getNewSession();
		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("userName", userName)).add(Restrictions.eq("usrPwd", pwd));
			criteria.setMaxResults(1);
			list = criteria.list();
			tx.commit();
			if (list != null) {
				User user = list.get(0);
				return user;
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}

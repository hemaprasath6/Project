package com.niit.UserDAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.User;
import com.niit.UserDAO.UserDAO;

@Repository()
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	//At the time of  instance, pass sessionfactory 
	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<User> list() {
		String hql ="from user";
		
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	//if the id is valid it will return domain obj
	//else it will return null
	@Transactional
	public User get(String id) {
		
		return (User) sessionFactory.getCurrentSession().get(User.class,id);
	}

	
	@Transactional
	public User validate(String id, String password) {
		String hql = "from user where id='" +id+ "and password" +password+ "'";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (User)query.uniqueResult();
	}
	@Transactional
	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {
		e.printStackTrace();
		return false;
		}
		return true;
	}
	@Transactional
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			e.printStackTrace();
		return false;
		}
		return true;
	}

}

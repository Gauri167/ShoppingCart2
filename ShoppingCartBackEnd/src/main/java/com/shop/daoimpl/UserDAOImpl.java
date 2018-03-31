package com.shop.daoimpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.UserDAO;
import com.shop.domain.User;



@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	private static final Logger log=LoggerFactory.getLogger(UserDAOImpl.class);
	
    @Autowired
	private SessionFactory sessionFactory;
    
    @Autowired
    private User user;
    
	public boolean save(User user) {
		
		log.debug("Starting of SAVE Method");
		
		try {
			user.setRole('C');
			user.setRegisterDate(new Date());
		sessionFactory.getCurrentSession().save(user);
		log.debug("Ending of SAVE Method");
			return true;
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			log.error("error occured in save method"+e.getMessage());
			return false;
		}
	}
    
	public boolean update(User user) {
		
		log.debug("Starting of Update Method");
		try {
			
	     sessionFactory.getCurrentSession().update(user);
	     log.debug("Ending of Update Method");
	     return true;
	    } 
	catch (HibernateException e) {
		e.printStackTrace();
		log.error("error occured in update method"+e.getMessage());
		return false;}
	}

	public boolean delete(String emailId) {
		
		log.debug("Starting of DELETE Method");
		
    	try {
		user=get(emailId);
		if(user==null)
			{return false;}
			sessionFactory.getCurrentSession().delete(user);
			log.debug("Ending of DELETE Method");
			return true;
    	}
	 catch (HibernateException e) {
		e.printStackTrace();
		log.error("error occured in delete method"+e.getMessage());
		return false;
	  }
	 }

	public User get(String emailId) {
		
		log.debug("Starting of GET Method");
		
		try {
			log.debug("Ending of GET Method");
		return sessionFactory.getCurrentSession().get(User.class,emailId);}
		catch (HibernateException e) {
			e.printStackTrace();
			log.error("error occured in get method"+e.getMessage());
			return null;
		  }
	}

	@SuppressWarnings("deprecation")
	public User validate(String emailId, String password) {
		
		log.debug("Starting of SAVE Method");
		log.info("user "+emailId+" trying to login");
		
	 user= (User) sessionFactory.getCurrentSession().createCriteria(User.class).
				add(Restrictions.eq("emailId",emailId)).
				add(Restrictions.eq("password",password)).uniqueResult();
	 log.debug("Ending of VALIDATE Method");
	 return user;
	}
	
	
	@SuppressWarnings("unchecked")
	
	public List<User> userlist() {
		
		log.debug("Starting of UserList Method");
		Session session=sessionFactory.openSession();
		log.debug("Ending of UserList Method");
		return session.createQuery("from User").list();
	}

}

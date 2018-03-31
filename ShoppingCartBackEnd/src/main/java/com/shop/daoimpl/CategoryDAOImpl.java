package com.shop.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.CategoryDAO;
import com.shop.domain.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	private static final Logger log=LoggerFactory.getLogger(CategoryDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Category category;
	
	public boolean save(Category category) {
		
		log.debug("Starting of SAVE Method");
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			log.debug("Ending of SAVE Method");
			return true;
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			log.error("error occured in save method"+e.getMessage());
			return false;
		}
	}
	
	public boolean delete(String id) {
		
		log.debug("Starting of delete Method");
		
		try {
			category=get(id);
			if(category==null)
			{  return false;  }
			sessionFactory.getCurrentSession().delete(category);
			log.debug("Ending of delete Method");
			return true;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			log.error("error occured in delete method"+e.getMessage());
			return false;
		}
		
	}
	
	public Category get(String id) {
		
		log.debug("Starting of get Method");
		
		try {
			log.debug("Ending of get Method");
			return sessionFactory.getCurrentSession().get(Category.class,id);
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			log.error("error occured in get method"+e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Category> categorylist() {
		
		log.debug("Starting of categoryList Method");
		Session session=sessionFactory.openSession();
		log.debug("ending of categoryList Method");
		return session.createQuery("from Category").list();
	}

	

}

package com.shop.daoimpl;

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

import com.shop.dao.CartDAO;
import com.shop.domain.Cart;

@Transactional
@Repository("cartDAO")
public class CartDAOImpl implements CartDAO{
	
	private static final Logger log=LoggerFactory.getLogger(CartDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Cart cart;
	
	public boolean save(Cart cart) {
		
		log.debug("Starting of SAVE Method");
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
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
			cart=get(id);
			if(cart==null)
			{  return false;  }
			sessionFactory.getCurrentSession().delete(cart);
			log.debug("Ending of delete Method");
			return true;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			log.error("error occured in delete method"+e.getMessage());
			return false;
		}
		
	}
	
	public Cart get(String id) {
		
		log.debug("Starting of get Method");
		
		try {
			log.debug("Ending of get Method");
			return sessionFactory.getCurrentSession().get(Cart.class,id);
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			log.error("error occured in get method"+e.getMessage());
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Cart> cartlist(String emailId) {
		
		log.debug("Starting of cartList Method");
		Session session=sessionFactory.openSession();
		log.debug("ending of cartList Method");
		return session.createCriteria(Cart.class).add(Restrictions.eq("emailId",emailId)).list();
	}

	

}

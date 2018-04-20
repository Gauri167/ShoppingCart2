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

import com.shop.dao.OrderDAO;
import com.shop.domain.Order;

@Transactional
@Repository("orderDAO")//
public class OrderDAOImpl implements OrderDAO {
	
	private static final Logger log=LoggerFactory.getLogger(OrderDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private Order order;

	@Override
	public boolean confirmOrder(Order order) {
		
		log.debug("Starting of SAVE Method");
		
		try {
			order.setOrderDate(new Date());
			sessionFactory.getCurrentSession().save(order);
			log.debug("End of Save Method");
			return true;
		} catch (HibernateException e) {
			log.error("Error occured in Save Method");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean cancelOrder(int id) {
		log.debug("Starting of CancelOrder Method");
		try {
			order=get(id);
			if(order==null)
				{return false;}
			else sessionFactory.getCurrentSession().delete(order);
			log.debug("End of CancelOrder Method");
			return true;
		} catch (HibernateException e) {
            log.error("end of CancelOrder Method");
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Order> getOrderDetails(String emailId) {
		log.debug("Starting of getOrderDetails Method");
		Session session=sessionFactory.openSession();
		log.debug("End of getOrderDetails Method");
		return session.createCriteria(Order.class).add(Restrictions.eq("emailId", emailId)).list();
	}

	@Override
	public Order get(int id) {
		log.debug("Starting of get Method");
		try {
			log.debug("end of get Method");
			return sessionFactory.getCurrentSession().get(Order.class,id);
		} catch (HibernateException e) {
			log.error("error occoured in get method");
			e.printStackTrace();
			return null;
		}
		
	}
	
	

}

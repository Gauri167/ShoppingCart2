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

import com.shop.dao.SupplierDAO;
import com.shop.domain.Supplier;

@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO{

	private static final Logger log=LoggerFactory.getLogger(SupplierDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Supplier supplier;
	public boolean save(Supplier supplier) {
		try {
			
			log.debug("Starting of SAVE Method");
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			log.debug("ending of SAVE Method");
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
			supplier=get(id);
			if(supplier==null)
			{  return false;  }
			sessionFactory.getCurrentSession().delete(supplier);
			log.debug("ending of delete Method");
			return true;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			log.error("error occured in delete method"+e.getMessage());
			return false;
		}
		
	}
	
	public Supplier get(String id) {
		
		log.debug("Starting of get Method");
		try {
			log.debug("ending of get Method");
			return sessionFactory.getCurrentSession().get(Supplier.class,id);
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			log.error("error occured in get method"+e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> supplierlist() {
		
		log.debug("Starting of supplierList Method");
		Session session=sessionFactory.openSession();
		log.debug("ending of supplierList Method");
		return session.createQuery("from Supplier").list();
	}

	
	

}

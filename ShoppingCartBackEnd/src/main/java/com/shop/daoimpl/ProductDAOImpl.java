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

import com.shop.dao.ProductDAO;
import com.shop.domain.Category;
import com.shop.domain.Product;
import com.shop.domain.Supplier;
@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{
	
	private static final Logger log=LoggerFactory.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Product product;
	public boolean save(Product product) {
		
		log.debug("Starting of SAVE Method");
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
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
			product=get(id);
			if(product==null)
			{  return false;  }
			sessionFactory.getCurrentSession().delete(product);
			log.debug("Ending of delete Method");
			return true;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			log.error("error occured in delete method"+e.getMessage());
			return false;
		}
		
	}
	
	public Product get(String id) {
		
		log.debug("Starting of get Method");
		
		try {
			log.debug("Ending of delete Method");
			return sessionFactory.getCurrentSession().get(Product.class,id);
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			log.error("error occured in get method"+e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> productlist() {
		log.debug("Starting of productList Method");
		Session session=sessionFactory.openSession();
		log.debug("Ending of ProductList Method");
		return session.createQuery("from Product").list();
	}

	public Product getCategory(Category category) {
		
		// slt missed 
		// to be completed
		return null;
	}

	public Product getSupplier(Supplier supplier) {
		
		//slt missed
		//to be completed
		return null;
	}

	

}

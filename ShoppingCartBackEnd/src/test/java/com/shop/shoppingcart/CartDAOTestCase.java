package com.shop.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.dao.CartDAO;
import com.shop.domain.Cart;

public class CartDAOTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CartDAO cartDAO;

	@Autowired
	private static Cart cart;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.shop");
		context.refresh();
		cartDAO=(CartDAO) context.getBean("CartDAO");
		cart=(Cart) context.getBean("Cart");
	}
	

	public void saveCartTestCase()
	{
		cart.setEmailId("abcd@gmail.com");
		cart.setPrice(2000);
		cart.setProductName("Shoes");
		cart.setQuantity(1);
		boolean status=cartDAO.save(cart);
		assertTrue("saveCartTestCase",status);
	}

}

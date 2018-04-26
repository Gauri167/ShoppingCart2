package com.shop.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.dao.OrderDAO;
import com.shop.domain.Order;

public class OrderDAOTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static OrderDAO orderDAO;
	
	@Autowired
	private static Order order;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.shop");
		context.refresh();
		order=(Order) context.getBean("order");
		orderDAO=(OrderDAO) context.getBean("orderDAO");
	}
	
	public void saveOrderTestCase()
	{
		order.setAddress("Lucknow");
		order.setAmount(5000);
		order.setEmailId("abcd@gmail.com");
		order.setMobile("1234567");
		order.setProductName("Bag");
		order.setProductPrice("5000");
		order.setQuantity(1);
		boolean status=orderDAO.confirmOrder(order);
		assertTrue("Confirm order test case",status);
	}
	
	
	public void deleteOrderTestCase()
	{
		
		boolean status=orderDAO.cancelOrder(42);
		assertTrue("Delete Order Test Case",status);
	}
}

package com.shop.dao;

import java.util.List;

import com.shop.domain.Order;

public interface OrderDAO {
	
	public boolean confirmOrder(Order order);
	
	public boolean cancelOrder(String id);
	
	public Order get(String id);
	
	public List<Order> getOrderDetails(String emailId);

}

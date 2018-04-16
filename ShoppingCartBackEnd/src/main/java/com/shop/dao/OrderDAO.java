package com.shop.dao;

import java.util.List;

import com.shop.domain.Order;

public interface OrderDAO {
	
	public boolean confirmOrder(Order order);
	
	public boolean cancelOrder(int id);
	
	public Order get(int id);
	
	public List<Order> getOrderDetails(String emailId);

}

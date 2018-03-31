package com.shop.dao;

import java.util.List;

import com.shop.domain.Cart;

public interface CartDAO {

	// to save new cart
		public boolean save(Cart cart);
		//to delete cart
		public boolean delete(String id);
		//to get cart
		public Cart get(String id);
		//to get all carts added by a particular user
		public List<Cart> cartlist(String emailId);
}

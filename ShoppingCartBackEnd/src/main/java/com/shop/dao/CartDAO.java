package com.shop.dao;

import java.util.List;

import com.shop.domain.Cart;

public interface CartDAO {

	// to save new cart
		public boolean save(Cart cart);
		//to update cart
		public boolean update(Cart cart);
		//to delete cart
		public boolean delete(int id);
		//to get cart
		public Cart get(int id);
		//to get all carts added by a particular user
		public List<Cart> cartlist(String emailId);
}

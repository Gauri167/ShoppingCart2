package com.shop.dao;

import java.util.List;

import com.shop.domain.Product;

public interface ProductDAO {

	// to save a new product
	public boolean save(Product product);
	// to delete a product
	public boolean delete(String id);
	// to get a product
	public Product get(String id);
	// to get all products
	public List<Product> productlist();
}

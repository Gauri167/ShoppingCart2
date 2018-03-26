package com.shop.dao;

import java.util.List;

import com.shop.domain.Supplier;

public interface SupplierDAO {

	//to save new supplier
	public boolean save(Supplier supplier);
	//to delete a supplier
	public boolean delete(String id);
	//to get a supplier
	public Supplier get(String id);
	//to get all suppliers
	public List<Supplier> supplierlist();
	
}

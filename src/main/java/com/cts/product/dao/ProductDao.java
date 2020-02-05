package com.cts.product.dao;

import java.util.List;

import com.cts.product.model.Product;

public interface ProductDao {
	
	int saveProduct(Product prod);
	
	List<Product> findAll();
	
	List<Product> findByName(String productName);
	
	Product findById(int prodId);
	
	List<Product> findByPriceRange(double price1, double price2);
	
	List<Product> findByIdRange(int id1, int id2);
	
	int deleteById(int pId);
	
	int updateNameById(int id, String name);

}

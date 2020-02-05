package com.cts.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.product.dao.ProductDao;
import com.cts.product.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;
	
	public int saveProduct(Product prod) {
		return dao.saveProduct(prod);
	}
	
	public List<Product> findAll() 
	{

		return dao.findAll();
	}

	public List<Product> findByName(String productName) {
		return dao.findByName(productName);
	}

	// display product By id:
	public Product findById(int prodId) {
		return dao.findById(prodId);
	}

	public List<Product> findByPriceRange(double price1, double price2) {
		return dao.findByPriceRange(price1, price2);
	}

	public List<Product> findByIdRange(int id1, int id2) {
				return dao.findByIdRange(id1, id2);
	}

	public int deleteById(int pId) {
		return dao.deleteById(pId);
	}

	public int updateNameById(int id, String name) {
		return dao.updateNameById(id, name);
	}

	

}

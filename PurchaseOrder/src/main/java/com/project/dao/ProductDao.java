package com.project.dao;

import java.util.List;

import com.project.model.Products;

public interface ProductDao {
	
	public boolean addProduct(Products productObj);
	
	public List<Products> viewAllProducts();
	
	public boolean deleteProduct(Products productObj);
	
	public Products getProductByName(String productName);
	
	public Products getProductById(int productId);
	
	public boolean updateProduct(Products productObj);

}
package com.project.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ProductDao;
import com.project.model.Products;
import com.project.service.ProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public boolean addProduct(Products productObj) {
		return productDao.addProduct(productObj);
	}

	@Override
	public List<Products> viewAllProducts() {
		return productDao.viewAllProducts();
	}

	@Override
	public boolean deleteProduct(Products productObj) {
		return productDao.deleteProduct(productObj);
	}

	@Override
	public Products getProductByName(String productName) {
		return productDao.getProductByName(productName);
	}

	@Override
	public boolean updateProduct(Products productObj) {
		return productDao.updateProduct(productObj);
	}

	@Override
	public Products getProductById(int productId) {
		return productDao.getProductById(productId);

	}

}

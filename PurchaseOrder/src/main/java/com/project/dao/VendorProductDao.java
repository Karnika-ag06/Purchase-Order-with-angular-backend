  
package com.project.dao;

import java.util.List;

import com.project.model.Products;
import com.project.model.VendorProduct;

public interface VendorProductDao {
	
	public Products getProductById(int pId) ;
	public List<Products> getAllProducts(int id);
	public boolean add(VendorProduct vObj);
	public VendorProduct checkProductForVendor(int vendorId,int productId);


}
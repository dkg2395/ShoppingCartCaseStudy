package com.durgesh.service;

import java.util.List;

import com.durgesh.model.Product;

public interface IProductService {
	
Product saveProduct(Product product);
	
	List<Product> getAllProduct();
	
	void deleteProduct(Integer id);

}

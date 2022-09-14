package com.durgesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgesh.model.Product;
import com.durgesh.repo.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);;
	}

}

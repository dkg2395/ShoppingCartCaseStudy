package com.durgesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durgesh.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	

}

package com.durgesh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durgesh.model.CartItems;

public interface CartItemsRepository extends JpaRepository<CartItems, Integer>{

		List<CartItems> findByUsername(String userName);

}

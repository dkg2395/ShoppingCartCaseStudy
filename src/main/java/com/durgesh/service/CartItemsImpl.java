package com.durgesh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgesh.model.CartItems;
import com.durgesh.model.Product;
import com.durgesh.repo.CartItemsRepository;
import com.durgesh.repo.ProductRepository;

@Service
public class CartItemsImpl implements ICartItems {
	
	@Autowired
	private CartItemsRepository cartItemsRepository;
	
	@Autowired
	private ProductRepository  productRepository;

	
	@Override
	public void addToCart(Integer carId, CartItems cartItems) {
		Product existProduct = productRepository.findById(carId).orElse(null);
		cartItems.setProduct(existProduct);

        cartItems.setSubTotal(existProduct.getPrice());
       

        cartItemsRepository.save(cartItems);
	}
	
	public List<CartItems> myCart(String userName){

	    List<CartItems> cartItems = new ArrayList<>();
	   cartItemsRepository.findByUsername(userName).forEach(cartItems::add);
	   

	    return cartItems;
	}

	@Override
	public void removeFromCart(Integer id) {
		 cartItemsRepository.deleteById(id);
		
	}
	
	
	
}

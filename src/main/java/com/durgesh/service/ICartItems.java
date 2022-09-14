package com.durgesh.service;

import java.util.List;

import com.durgesh.model.CartItems;

public interface ICartItems {

	List<CartItems> myCart(String userName);

	void addToCart(Integer carId, CartItems cartItems);

	void removeFromCart(Integer id);

}

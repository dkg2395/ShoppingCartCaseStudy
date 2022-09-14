package com.durgesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.model.CartItems;
import com.durgesh.service.ICartItems;

@RestController
@RequestMapping("/CartItems/v1")
public class CartItemsController {

	
	@Autowired
	private ICartItems iCartItems;
	
	@PostMapping("/addToCart/{id}")

	public ResponseEntity<CartItems> addToCart(@PathVariable("id") Integer id, @RequestBody CartItems cartItems){
		
		iCartItems.addToCart(id, cartItems);
		
		//Product product=new Product();
		
		
		return new ResponseEntity<CartItems>(HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/myCart")
	
	public ResponseEntity<List<CartItems>> getByUsername(@RequestParam("username") String username){
		
		List<CartItems> myCart = iCartItems.myCart(username);
		
		return new ResponseEntity<List<CartItems>>(myCart ,HttpStatus.CREATED);
		
	}
	
@DeleteMapping("/removeFromCart")
	
	public ResponseEntity<String>removeFromCart(@RequestParam("id") Integer id){
		
		iCartItems.removeFromCart(id);
		
		return new ResponseEntity<String>("Product id "+id+" removed successfully" ,HttpStatus.OK);
		
	}
}

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
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.model.Product;
import com.durgesh.service.IProductService;

@RestController
@RequestMapping("/product/v1")
public class ProductController {
	
	@Autowired
	private IProductService iProductService;
	
	@PostMapping("/saveProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product p
			){
		
		Product saveProduct = iProductService.saveProduct(p);
		
		return new ResponseEntity<Product>(saveProduct,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/AllProduct")
	public ResponseEntity<List<Product>> getAllProduct(){
		
		List<Product> allProduct = iProductService.getAllProduct();
		
		return new ResponseEntity<List<Product>>(allProduct,HttpStatus.OK);
		
	}
	

	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id){
		
		 iProductService.deleteProduct(id);
		
		return new ResponseEntity<String>("Product id "+id+" is deleted successfully",HttpStatus.OK);
		
	}
	
	
	

}

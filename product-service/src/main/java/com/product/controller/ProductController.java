package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.repository.ProductRepository;


@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRep;
	
	@GetMapping("/product")
	public List<Product> getProduct(){
	return productRep.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/product")
	public void addProduct(@RequestBody Product p) {
		productRep.save(p);
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable String id) {
		return productRep.findById(id).orElse(null);
	}
	
	@GetMapping("/product/name/{productName}")
	public List<Product> findProductByName( @PathVariable String productName ){
	return productRep.findProductByName( productName );
	}
	
	@GetMapping("/product/category/{category}")
	public List<Product> findProductByCategory(@PathVariable String category) {
		return productRep.findAll(category);
	}
	
	@GetMapping("/product/type/{productType}")
	public List<Product> findProductByType(@PathVariable String productType) {
		return productRep.findAll1(productType);
	}
	
	
	@PutMapping("/product/update/{id}")
	public String updateProduct(@RequestBody Product p, @PathVariable String id) {
		p.setProductId(id);
		productRep.save(p);
		return ("Updated the Product");
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/product/delete/{id}")
		public String deleteProduct( @PathVariable String id ) {
		productRep.deleteById( id );
		return ("Deleted Successfully");
	}
	
}

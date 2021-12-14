package com.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.product.model.Product;

public interface ProductRepository extends MongoRepository <Product,String>{

	@Query("{ 'productName' : ?0 }")
	List<Product> findProductByName(String productName);

	@Query("{ 'category' : ?0 }")
	List<Product> findAll(String category);
	
	@Query("{ 'productType' : ?0 }")
	List<Product> findAll1(String productType);

}

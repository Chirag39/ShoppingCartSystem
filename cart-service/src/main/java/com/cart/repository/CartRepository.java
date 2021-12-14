package com.cart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cart.model.Cart;

public interface CartRepository extends MongoRepository <Cart,String>{

}

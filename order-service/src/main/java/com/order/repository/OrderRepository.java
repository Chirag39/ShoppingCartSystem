package com.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.order.entity.Order;

public interface OrderRepository extends MongoRepository <Order,String> {

}

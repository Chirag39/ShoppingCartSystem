package com.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.order.entity.Wallet;


public interface WalletRepository extends MongoRepository <Wallet,String>{

}

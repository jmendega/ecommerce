package com.springboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.models.Cart;

public interface CartRepository extends MongoRepository<Cart, String>  {
  
  List<Cart>findByClientName(String clientName);
}

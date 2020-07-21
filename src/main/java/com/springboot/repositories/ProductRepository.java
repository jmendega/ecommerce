package com.springboot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springboot.models.Product;


public interface ProductRepository extends MongoRepository<Product, String>{

  void save(Optional<Product> product);

  @Query("{ 'name': ?0}")
  Optional<Product> findByName(String name);
  
  @Query("{ 'category': ?0}")
  List<Product> findByCategory(String category);
}

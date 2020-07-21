package com.springboot.services;

import java.util.List;
import java.util.Optional;

import com.springboot.models.Product;

public interface ProductService {
  public Product create (Product product);
  public Optional<Product> update (String id, Product product) throws Exception;
  public Optional<Product> delete (String id) throws Exception;
  public Optional<Product> findById(String id);
  public Optional<Product> findByName(String name);
  public List<Product> findByCategory(String category);
  public List<Product> findAll();
}

package com.springboot.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.models.Product;
import com.springboot.repositories.ProductRepository;
import com.springboot.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
  
  @Autowired
  ProductRepository productRepository;
  
  @Override
  public Product create(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Optional<Product> update(String id, Product product) throws Exception {
    Optional<Product> prd = productRepository.findById(id);
    if(prd.isPresent()) {
      product.setId(id);
      productRepository.save(product);
    }else
      throw new Exception("No existe el id " + id);
	return prd;
  }

  @Override
  public Optional<Product> delete(String id) throws Exception {
    Optional<Product> prd = productRepository.findById(id);
    if(prd.isPresent()) {
      productRepository.deleteById(id);
    }
    else
        throw new Exception("No existe el id " + id);
	return prd;
    
  }

  @Override
  public Optional<Product> findById(String id) {
    // TODO Auto-generated method stub
    return productRepository.findById(id);
  }
  
  @Override
  public Optional<Product> findByName(String name) {
    // TODO Auto-generated method stub
    return productRepository.findByName(name);
  }
  
  @Override
  public List<Product> findByCategory(String category) {
    // TODO Auto-generated method stub
    return productRepository.findByCategory(category);
  }

  @Override
  public List<Product> findAll() {
    // TODO Auto-generated method stub
    return productRepository.findAll();
  }

}

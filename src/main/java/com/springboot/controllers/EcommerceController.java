package com.springboot.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.models.Cart;
import com.springboot.models.Product;
import com.springboot.services.impl.CartServiceImpl;
import com.springboot.services.impl.ProductServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class EcommerceController {
  
  /* Product */
  @Autowired
  private ProductServiceImpl productService;
  
  @RequestMapping(value = "/product", method = RequestMethod.POST)
  public Product createProduct(@Valid @RequestBody Product product) {
    log.info("createProduct -> {} ", product);
    return productService.create(product);
  }
  
  @RequestMapping(value = "/product/id/{id}", method = RequestMethod.GET)
  public Optional<Product> findById(@PathVariable String id) {
    log.info("findById -> {} ", id);
    return productService.findById(id);
  }
  
  @RequestMapping(value = "/product/name/{name}", method = RequestMethod.GET)
  public Optional<Product> findByName(@PathVariable String name) {
    log.info("findByName -> {} ", name);
    return productService.findByName(name);
  }
  
  @RequestMapping(value = "/product", method = RequestMethod.GET)
  public List<Product> findByCategory(@RequestParam(defaultValue = "") String category) {
    log.info("findByCategory -> {} ", category);
    return productService.findByCategory(category);
  }
  
  @RequestMapping(value = "/product/all", method = RequestMethod.GET)
  public List<Product> getAllProducts() {
    return productService.findAll();
  }
  
  @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
  public Optional<Product> updateProduct(@PathVariable String id, @RequestBody Product product) throws Exception {
	log.info("updateProduct -> {} -> {}", id, product);
	return productService.update(id, product);
  }
  
  @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
  public Optional<Product>  deleteProduct(@PathVariable String id) throws Exception {
	log.info("deleteProduct -> {} ", id);
    return productService.delete(id);
  }
  
  /* Cart */
  @Autowired
  private CartServiceImpl cartService;
  
  @RequestMapping(value = "/cart", method = RequestMethod.POST)
  public Cart createCart(@Valid @RequestBody Cart cart) {
    log.info("createCart -> {} ", cart);
    return cartService.create(cart);
  }
  
  @RequestMapping(value = "/cart", method = RequestMethod.GET)
  public List<Cart> findByClientName(@RequestParam(defaultValue = "") String clientName) {
    log.info("findByClientName -> {} ", clientName);
    return cartService.findByClientName(clientName);
  }
  
  @RequestMapping(value = "/cart/all", method = RequestMethod.GET)
  public List<Cart> getAllCarts() {
    return cartService.findAll();
  }
}

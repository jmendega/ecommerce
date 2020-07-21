package com.springboot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.models.Cart;
import com.springboot.repositories.CartRepository;
import com.springboot.services.CartService;

@Service
public class CartServiceImpl implements CartService{
  
  @Autowired
  private CartRepository cartRegistry;
  
  @Override
  public Cart create(Cart cart) {
    // TODO Auto-generated method stub
    return cartRegistry.save(cart);
  }

  @Override
  public List<Cart> findByClientName(String clientName) {
    // TODO Auto-generated method stub
    return cartRegistry.findByClientName(clientName);
  }

  @Override
  public List<Cart> findAll() {
    // TODO Auto-generated method stub
    return cartRegistry.findAll();
  }

}

package com.springboot.services;

import java.util.List;

import com.springboot.models.Cart;

public interface CartService {
  public Cart create (Cart cart);
  public List<Cart> findByClientName(String clientName);
  public List<Cart> findAll();
}

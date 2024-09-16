package com.ecommerce.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.ecommerce.ecommerce.model.Cart;
import com.ecommerce.ecommerce.services.CartServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/cart")
public class cart_controller {

    @Autowired
    private CartServices cartService;

    // Add product to cart
    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestParam String userId, 
                                                  @RequestParam Long productId,
                                                  @RequestParam int quantity) {
        Cart cart = cartService.addProductToCart(userId, productId, quantity);
        return ResponseEntity.ok(cart);
    }

    // Remove product from cart
    @DeleteMapping("/remove")
    public ResponseEntity<Cart> removeFromCart(@RequestParam String userId, 
                                                       @RequestParam Long productId) {
        Cart cart = cartService.removeProductFromCart(userId, productId);
        return ResponseEntity.ok(cart);
    }

    // View cart contents
    @GetMapping("/view")
    public ResponseEntity<Cart> viewCart(@RequestParam String userId) {
        Cart cart = cartService.getCart(userId);
        return ResponseEntity.ok(cart);
    }
}


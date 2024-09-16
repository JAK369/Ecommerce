package com.ecommerce.ecommerce.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.model.Cart;
import com.ecommerce.ecommerce.model.CartItem;
import com.ecommerce.ecommerce.repository.cart_repo;

@Service
public class CartServices {
    
    @Autowired
    private cart_repo cartRepository;
    
    
    public Cart addProductToCart(String userId, Long productId, int quantity) {
        Cart cart = cartRepository.findByUserId(userId)
                          .orElse(new Cart());
        cart.setUserId(userId);
        
        Optional<CartItem> existingItem = cart.getItems().stream()
                    .filter(item -> item.getProductId().equals(productId))
                    .findFirst();
                    
        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(existingItem.get().getQuantity() + quantity);
        } else {
            CartItem newItem = new CartItem();
            newItem.setProductId(productId);
            newItem.setQuantity(quantity);
            cart.getItems().add(newItem);
        }
        
        return cartRepository.save(cart);
    }
    
    public Cart removeProductFromCart(String userId, Long productId) {
        Cart cart = cartRepository.findByUserId(userId)
                          .orElseThrow(() -> new RuntimeException("Cart not found"));
                          
        cart.getItems().removeIf(item -> item.getProductId().equals(productId));
        return cartRepository.save(cart);
    }
    
    public Cart getCart(String userId) {
        return cartRepository.findByUserId(userId)
                 .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

}

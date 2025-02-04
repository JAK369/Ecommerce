package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Cart;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface cart_repo extends JpaRepository<Cart,Integer>{

    Optional<Cart> findByUserId(String userId);


}
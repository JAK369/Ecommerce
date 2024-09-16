package com.ecommerce.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.model.Products;
import com.ecommerce.ecommerce.repository.products_repo;

@Service
public class ProductService {

        @Autowired
        products_repo repo;

        public List<Products> getAllProducts() {
            return repo.findAll();
        }

        public void addProduct(Products product) {
            repo.save(product);
            
        }



}

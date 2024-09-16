package com.ecommerce.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.model.Products;
import com.ecommerce.ecommerce.repository.products_repo;
import com.ecommerce.ecommerce.services.ProductService;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class products_controller {

    @Autowired
    ProductService service;


    @PostMapping("/addProducts")
    public Products addProduct(@RequestBody Products product) {
        
         service.addProduct(product);

         return product;
        
    }

    /*
     * deekteProd(){@GetMapping("path/")
     public String getMethodName(int id) {
         return new String();
     }
     }
     */
    

   
    @GetMapping("/getAll")
   public List<Products> geProducts(){
        return service.getAllProducts();
   }
       
    
}

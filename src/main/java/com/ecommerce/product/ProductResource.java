package com.ecommerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductResource {
    
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<Object> getProducts(){
        return ResponseEntity.ok().body(productService.getProducts());
    }

    @PostMapping()
    public ResponseEntity<Object> createProduct(@Valid @RequestBody ProductModel productJson){
        return ResponseEntity.ok().body(productService.createProduct(productJson));
    }
}

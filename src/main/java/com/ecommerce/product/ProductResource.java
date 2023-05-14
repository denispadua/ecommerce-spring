package com.ecommerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.utils.ResponseHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductResource {
    
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<Object> getProducts(){
        return ResponseHandler.response(productService.getProducts(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> createProduct(@Valid @RequestBody ProductModel productJson){
        return ResponseHandler.response(productService.createProduct(productJson), HttpStatus.CREATED);
    }
}

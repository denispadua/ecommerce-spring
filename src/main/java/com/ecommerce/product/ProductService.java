package com.ecommerce.product;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public ProductModel createProduct(ProductModel productJson){
        ProductModel newProduct = new ProductModel();
        BeanUtils.copyProperties(productJson, newProduct);
        return productRepository.insert(newProduct);
    }

    public List<ProductModel> getProducts(){
        return productRepository.findAll();
    }

    public ProductModel getProductById(String id){
        return productRepository.findItemById(id);
    }

    public void deleteProductById(String id){
        productRepository.deleteById(id);
    }
}

package com.ecommerce.product;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<ProductModel, String>{
    
    @Query("{_id:'?0'}")
    ProductModel findItemById(String id);

    @Query("{name:'?0'}")
    ProductModel findItemByName(String name);
    
    List<ProductModel> findAll();
}

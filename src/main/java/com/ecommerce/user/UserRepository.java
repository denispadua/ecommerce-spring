package com.ecommerce.user;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface UserRepository extends MongoRepository<UserModel, String> {
    
    @Query("{_id:'?0'}")
    UserModel findItemById(String id);
    
    List<UserModel> findAll();
    
    public long count();

}

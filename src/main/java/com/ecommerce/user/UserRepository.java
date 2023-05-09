package com.ecommerce.user;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface UserRepository extends MongoRepository<UserModel, String> {
    
    @Query("{name:'?0'}")
    UserModel findItemByName(String name);
    
    List<UserModel> findAll();
    
    public long count();

}

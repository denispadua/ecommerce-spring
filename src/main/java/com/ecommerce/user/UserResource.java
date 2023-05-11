package com.ecommerce.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping(value="/user", produces=MediaType.APPLICATION_JSON_VALUE)
public class UserResource {

    @Autowired
    UserRepository userRepository;
   
    @GetMapping()
    public ResponseEntity<Object> getUsers(){
        List<UserModel> lsUser = userRepository.findAll();
        return UserResponseHander.userResponse(lsUser);
    }
    
    @PostMapping()
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserModel jsonUser){
        UserModel user = new UserModel();
        BeanUtils.copyProperties(jsonUser, user);
        UserModel result = userRepository.insert(user);
        return UserResponseHander.userResponse(result);
    }
}
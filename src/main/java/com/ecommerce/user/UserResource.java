package com.ecommerce.user;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.utils.ResponseHandler;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping(value="/user", produces=MediaType.APPLICATION_JSON_VALUE)
public class UserResource {

    @Autowired
    private UserService userService;
   
    @GetMapping()
    public ResponseEntity<Object> getUsers(){
        return ResponseHandler.response(userService.getUsers(), HttpStatus.OK);
    }
    
    @PostMapping()
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserModel jsonUser){
        return ResponseHandler.response(userService.createUser(jsonUser), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable String id){
        return ResponseHandler.response(userService.getUserById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable String id){
        userService.deleteUserById(id);
        return "Deletado com sucesso";
    }
}
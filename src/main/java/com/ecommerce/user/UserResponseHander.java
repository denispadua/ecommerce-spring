package com.ecommerce.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class UserResponseHander {
    
    public static ResponseEntity<Object> userResponse(List<UserModel> lsUser){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", lsUser);
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    public static ResponseEntity<Object> userResponse(UserModel user){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", user);
        return new ResponseEntity<Object>(map, HttpStatus.CREATED);
    }
}

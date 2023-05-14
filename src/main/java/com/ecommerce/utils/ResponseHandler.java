package com.ecommerce.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseHandler {
    
    public static <T> ResponseEntity<Object> response(List<T> lsUser, HttpStatus status){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", lsUser);
        return new ResponseEntity<Object>(map, status);
    }

    public static <T> ResponseEntity<Object> response(T user, HttpStatus status){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", user);
        return new ResponseEntity<Object>(map, status);
    }
}
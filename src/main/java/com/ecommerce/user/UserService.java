package com.ecommerce.user;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public UserModel createUser(UserModel jsonUser){
        UserModel newUser = new UserModel();
        BeanUtils.copyProperties(jsonUser, newUser);
        return userRepository.insert(newUser);
    }

    public List<UserModel> getUsers(){
        return userRepository.findAll();
    }

    public UserModel getUserById(String id){
        return userRepository.findItemById(id);
    }

    public void deleteUserById(String id){
        userRepository.deleteById(id);
    }
}

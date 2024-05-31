package com.example.budget_management.Service;

import com.example.budget_management.Entity.User;
import com.example.budget_management.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public  User  updateUserCategory(int id, String category) {
        User user = this.getUserById(id);
        if(user != null){
            user.category = category;
            user = this.saveUser(user);
        }
        return user;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }


    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

}

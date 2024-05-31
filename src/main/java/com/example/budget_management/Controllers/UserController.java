package com.example.budget_management.Controllers;

import com.example.budget_management.Entity.User;
import com.example.budget_management.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Service service;

    @GetMapping
    public List<User> getAllUsers(){
        return service.getAllUser();
    }
    @GetMapping("/{id}")
    public  User getUserById(@PathVariable int id){
        return service.getUserById(id);
    }

    @PostMapping
    public  User createUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @PostMapping
    public User updateUserCategory(@PathVariable int id, @PathVariable String category){
        User user = service.getUserById(id);
        if(user!=null){
            user.category = category;
            user= this.createUser(user);
        }
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteUser(id);
    }



}

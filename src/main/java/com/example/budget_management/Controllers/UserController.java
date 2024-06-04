package com.example.budget_management.Controllers;

import com.example.budget_management.DTO.UserRequest;
import com.example.budget_management.Entity.User;
import com.example.budget_management.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5500")
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
        return service.createUser(user);
    }


    @PutMapping("/{id}")
    public User updateUserCategory(@PathVariable int id, @RequestBody UserRequest request){
        System.out.println("This is request " + request);
     return service.updateUserCategory(id,request.getCategory());
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteUser(id);
    }

}

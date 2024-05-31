package com.example.budget_management.Repositories;

import com.example.budget_management.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer > {

    // now JpaRepository help to do simple CRUD operation on User Entity.
    // it act as interface between service and the dataBase

}

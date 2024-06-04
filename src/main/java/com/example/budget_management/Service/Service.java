package com.example.budget_management.Service;

import com.example.budget_management.Entity.User;
import com.example.budget_management.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {

        user = saveMoneyFlow(user);
        user = setTimeAndDate(user);
        return saveUser(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUserCategory(int id, String category) {
        User user = this.getUserById(id);
        if (user != null) {
            user.category = category;
            user = this.saveUser(user);
        }
        return user;
    }


    public User saveUser(User user) {
        return userRepository.save(user);
    }


    // Tracking money flow
    public User saveMoneyFlow(User user) {
        if (user.amount >= 0) {
            user.moneyFlow = "received";
        } else {
            user.moneyFlow = "spent";
        }
        return user;
    }


    // setting the time of payment or withdrowl
    public User setTimeAndDate(User user) {
        Instant instant = Instant.now();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        LocalDate date = zonedDateTime.toLocalDate();
        LocalTime time = zonedDateTime.toLocalTime();

        // Convert LocalDate and LocalTime to String format
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String dateString = date.format(dateFormatter);
        String timeString = time.format(timeFormatter);


        user.date = dateString;
        user.time = timeString;
        return user;
    }


    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

}

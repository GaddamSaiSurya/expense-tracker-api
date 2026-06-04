package com.example.expenseTracker.controller;

import com.example.expenseTracker.entity.User;
import com.example.expenseTracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public void addUser(@RequestBody @Valid User user){
        userService.addUser(user);
    }
}

package com.example.expenseTracker.service;

import com.example.expenseTracker.entity.User;
import com.example.expenseTracker.exception.EmailAlreadyExistsException;
import com.example.expenseTracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        if(userRepository.existsByEmail(user.getEmail())){
            throw new EmailAlreadyExistsException(user.getEmail());
        }

        userRepository.save(user);
    }
}

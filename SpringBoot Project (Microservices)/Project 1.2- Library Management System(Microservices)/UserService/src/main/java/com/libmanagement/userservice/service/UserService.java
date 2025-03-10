package com.libmanagement.userservice.service;

import com.libmanagement.userservice.model.User;
import com.libmanagement.userservice.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String USER_TOPIC = "user-events";

    public User saveUser(User user) {
        User savedUser = userRepository.save(user);

        // Ensure getEmail() is working properly
        if (savedUser != null && savedUser.getEmail() != null) {
            kafkaTemplate.send(USER_TOPIC, "New user created: " + savedUser.getEmail());
            System.out.println("User created successfully with email: " + savedUser.getEmail());
        } else {
            System.out.println("Error: Email is null for saved user.");
        }

        return savedUser;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}

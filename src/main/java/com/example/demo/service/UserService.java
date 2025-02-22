package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
      @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);  
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            user.setUserRole(updatedUser.getUserRole());  // Updated to String
            user.setSocialMediaLinks(updatedUser.getSocialMediaLinks());  // Updated to String
            user.setPreferences(updatedUser.getPreferences());
            return userRepository.save(user);
        }).orElse(null);  // Returns null if user not found
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public List<User> getUsersByRole(String role) {
        return userRepository.findUsersByRole(role);
    }
}

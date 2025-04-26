package com.untitle.myproject.controller;

import com.untitle.myproject.entity.User;
import com.untitle.myproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  // Create a new user
  @PostMapping
  public User createUser(@RequestBody User user) {
    return userRepository.save(user);
  }

  // Get all users
  @GetMapping
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  // Get user by ID
  @GetMapping("/{id}")
  public Optional<User> getUser(@PathVariable Long id) {
    return userRepository.findById(id);
  }

  // Update a user
  @PutMapping("/{id}")
  public User updateUser(@PathVariable Long id, @RequestBody User user) {
    Optional<User> existingUser = userRepository.findById(id);
    if (existingUser.isPresent()) {
      User updatedUser = existingUser.get();
      updatedUser.setName(user.getName());
      updatedUser.setEmail(user.getEmail());
      updatedUser.setPassword(user.getPassword());
      return userRepository.save(updatedUser);
    }
    return null; // Or throw an exception if you want
  }

  // Delete a user
  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Long id) {
    userRepository.deleteById(id);
  }
}

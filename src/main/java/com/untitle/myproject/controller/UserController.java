package com.untitle.myproject.controller;

import com.untitle.myproject.entity.User;
import com.untitle.myproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  // POST - Save user
  @PostMapping
  public User createUser(@RequestBody User user) {
    return userRepository.save(user);
  }

  // GET - List users
  @GetMapping
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}

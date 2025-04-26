package com.untitle.myproject.controller;

import com.untitle.myproject.entity.User;
import com.untitle.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  // Create user
  @PostMapping
  public User createUser(@RequestBody User user) {
    return userService.saveUser(user);
  }

  // Get all users
  @GetMapping
  public List<User> getUsers() {
    return userService.getAllUsers();
  }
}

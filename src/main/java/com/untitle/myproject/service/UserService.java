package com.untitle.myproject.service;

import com.untitle.myproject.entity.User;
import com.untitle.myproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  // Create new user
  public User saveUser(User user) {
    return userRepository.save(user);
  }

  // Get all users
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}

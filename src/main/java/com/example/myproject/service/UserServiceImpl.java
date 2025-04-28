package com.example.myproject.service;

import com.example.myproject.entity.User;
import com.example.myproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUserById(Long id) {
    return userRepository.findById(id)
        .orElse(null);
  }

  @Override
  public User updateUser(Long id, User user) {
    Optional<User> existingUserOpt = userRepository.findById(id);
    if (existingUserOpt.isPresent()) {
      User existingUser = existingUserOpt.get();
      existingUser.setName(user.getName());
      existingUser.setEmail(user.getEmail());
      existingUser.setPassword(user.getPassword());
      return userRepository.save(existingUser);
    } else {
      return null;
    }
  }

  @Override
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}

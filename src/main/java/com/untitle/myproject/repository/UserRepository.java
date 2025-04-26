package com.untitle.myproject.repository;

import com.untitle.myproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  // No need to write any method — CRUD ready!
}

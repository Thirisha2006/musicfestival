package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
     @Query("SELECT u FROM User u WHERE u.userRole = :role")
    List<User> findUsersByRole(@Param("role") String role);
}
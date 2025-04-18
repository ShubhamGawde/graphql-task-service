package com.taskmanagement.taskservice.repository;

import com.taskmanagement.taskservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

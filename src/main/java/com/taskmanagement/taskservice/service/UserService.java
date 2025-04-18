package com.taskmanagement.taskservice.service;

import com.taskmanagement.taskservice.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUser();

    User getUserById(Long id);

    User updateUser(Long id, User user);

    String deleteUser(Long id);



}

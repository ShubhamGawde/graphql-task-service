package com.taskmanagement.taskservice.service;

import com.taskmanagement.taskservice.customexception.UserNotFoundException;
import com.taskmanagement.taskservice.model.User;
import com.taskmanagement.taskservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * @param user
     * @return user
     */
    @Override
    public User createUser(User user) {
        String username = user.getEmail().substring(0,user.getEmail().indexOf("@"));
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    /**
     * @return list
     */
    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public User getUserById(Long id) {
        return this.userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }

    /**
     * @param id
     * @param user
     */
    @Override
    public User updateUser(Long id, User user) {
        return userRepository.findById(id)
                .map(existing -> {
                    existing.setUsername(user.getUsername());
                    existing.setFullName(user.getFullName());
                    return userRepository.save(existing);
                })
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    /**
     * @param id
     */
    @Override
    public String deleteUser(Long id) {
    User user =
        this.userRepository
            .findById(id)
            .orElseThrow(() -> new UserNotFoundException("User not found"));
        this.userRepository.delete(user);
        return "user deleted successfully";

    }
}

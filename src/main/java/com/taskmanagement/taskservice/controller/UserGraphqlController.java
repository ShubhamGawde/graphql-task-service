package com.taskmanagement.taskservice.controller;

import com.taskmanagement.taskservice.dto.CreateUserInput;
import com.taskmanagement.taskservice.dto.UpdateUserIntput;
import com.taskmanagement.taskservice.model.User;
import com.taskmanagement.taskservice.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserGraphqlController {

    @Autowired
    private UserService userService;


    @MutationMapping("createUser")
    public User createUser(@Argument CreateUserInput userInput){

        User user = new User();
        user.setFullName(userInput.getFullName());
        user.setEmail(userInput.getEmail());
        user.setPassword(userInput.getPassword());
        user.setRole(userInput.getRole());

        return this.userService.createUser(user);
    }

    @MutationMapping("updateUser")
    public User updateUser(@Argument("id") Long uId, @Argument("input") UpdateUserIntput userInput){
        User user = new User();
        user.setFullName(userInput.getFullName());
        user.setUsername(userInput.getUsername());


        return this.userService.updateUser(uId, user);
    }

    @QueryMapping("getUserById")
    public User getUserById(@Argument("id")  Long uId){
        return this.userService.getUserById(uId);
    }

    @QueryMapping("getAllUsers")
    public List<User> getAllUsers(){
        return this.userService.getAllUser();
    }

    @MutationMapping("deleteUser")
    public String deleteUser(@Argument("id") Long uId){
        return this.userService.deleteUser(uId);
    }

}

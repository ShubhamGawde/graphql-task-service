package com.taskmanagement.taskservice.dto;

import com.taskmanagement.taskservice.model.Role;
import lombok.Data;

@Data
public class CreateUserInput {

    private String fullName;

    private String email;

    private String password;

    private Role role;
}

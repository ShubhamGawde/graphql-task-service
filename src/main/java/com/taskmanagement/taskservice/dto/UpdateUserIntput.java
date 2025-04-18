package com.taskmanagement.taskservice.dto;

import com.taskmanagement.taskservice.model.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UpdateUserIntput {

    private String fullName;

    private String username;
}

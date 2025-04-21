package com.taskmanagement.taskservice.dto;

import com.taskmanagement.taskservice.model.TaskPriority;
import com.taskmanagement.taskservice.model.TaskStatus;
import lombok.Data;

@Data
public class TaskInput {
    private String title = "";
    private String description = "";
    private TaskStatus status = TaskStatus.TODO;
    private TaskPriority priority = TaskPriority.NONE;
    private String dueDate = null;
    private Long createdBy = Long.MIN_VALUE;
    private Long assignedUserId = Long.MIN_VALUE;
}

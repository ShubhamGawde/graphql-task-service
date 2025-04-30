package com.taskmanagement.taskservice.controller;

import com.taskmanagement.taskservice.dto.TaskInput;
import com.taskmanagement.taskservice.model.Task;
import com.taskmanagement.taskservice.model.User;
import com.taskmanagement.taskservice.service.TaskService;
import com.taskmanagement.taskservice.service.UserService;
import com.taskmanagement.taskservice.utilities.Utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TaskGraphqlController {

  @Autowired private TaskService taskService;

  @Autowired private UserService userService;

  @QueryMapping
  public Task getTaskById(@Argument("id") Integer tId) {
    return this.taskService.getTaskById(tId);
  }

  @QueryMapping
  public List<Task> getAllTasks() {
    return this.taskService.getAllTask();
  }

  @MutationMapping("createTask")
  public Task createTask(@Argument("taskInput") TaskInput taskInput) {
    User assignedUser =
        !Utils.nullOrEmptyOrZero(taskInput.getAssignedUserId())
            ? this.userService.getUserById(taskInput.getAssignedUserId())
            : null;

    User createdBy =
        !Utils.nullOrEmptyOrZero(taskInput.getCreatedBy())
            ? this.userService.getUserById(taskInput.getCreatedBy())
            : null;

   LocalDate dueDate = LocalDate.parse(taskInput.getDueDate(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));

    Task task = new Task();
    task.setTitle(taskInput.getTitle());
    task.setDescription(taskInput.getDescription());
    task.setStatus(taskInput.getStatus());
    task.setPriority(taskInput.getPriority());
    task.setCreatedBy(createdBy);
    task.setAssignedUser(assignedUser);
    task.setDueDate(dueDate);

    return this.taskService.createTask(task);
  }

  @MutationMapping
  public String deleteTask(@Argument("id") Integer tId){
    return this.taskService.deleteTask(tId);
  }

  @MutationMapping
    public Task updateTask(@Argument("id") Integer tId, @Argument("taskInput") TaskInput taskInput){

      User assignedUser =
              !Utils.nullOrEmptyOrZero(taskInput.getAssignedUserId())
                      ? this.userService.getUserById(taskInput.getAssignedUserId())
                      : null;

      User createdBy =
              !Utils.nullOrEmptyOrZero(taskInput.getCreatedBy())
                      ? this.userService.getUserById(taskInput.getCreatedBy())
                      : null;

      LocalDate dueDate = LocalDate.parse(taskInput.getDueDate(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));

      Task task = new Task();
      task.setTitle(taskInput.getTitle());
      task.setDescription(taskInput.getDescription());
      task.setStatus(taskInput.getStatus());
      task.setPriority(taskInput.getPriority());
      task.setCreatedBy(createdBy);
      task.setAssignedUser(assignedUser);
      task.setDueDate(dueDate);

      return this.taskService.updateTask(tId, task);
  }
}

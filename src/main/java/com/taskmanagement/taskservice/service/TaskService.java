package com.taskmanagement.taskservice.service;

import com.taskmanagement.taskservice.model.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    Task updateTask(Integer tId, Task task);

    List<Task> getAllTask();

    Task getTaskById(Integer tId);

    String deleteTask(Integer tId);


}

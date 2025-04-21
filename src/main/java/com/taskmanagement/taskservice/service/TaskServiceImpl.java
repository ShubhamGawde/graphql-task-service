package com.taskmanagement.taskservice.service;

import com.taskmanagement.taskservice.customexception.TaskNotFoundException;
import com.taskmanagement.taskservice.model.Task;
import com.taskmanagement.taskservice.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;

  public TaskServiceImpl(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  /**
   * @param task
   * @return
   */
  @Override
  public Task createTask(Task task) {
    return this.taskRepository.save(task);
  }

  /**
   * @param tId
   * @param task
   * @return
   */
  @Override
  public Task updateTask(Integer tId, Task task) {
    return this.taskRepository
        .findById(tId)
        .map(
            existing -> {
              existing.setStatus(task.getStatus());
              existing.setPriority(task.getPriority());
              existing.setDescription(task.getDescription());
              existing.setTitle(task.getTitle());
              existing.setDueDate(task.getDueDate());
              existing.setCreatedBy(task.getCreatedBy());
              return this.taskRepository.save(existing);
            })
        .orElseThrow(() -> new TaskNotFoundException("Task not found"));
  }

  /**
   * @return
   */
  @Override
  public List<Task> getAllTask() {
    return this.taskRepository.findAll();
  }

  /**
   * @param tId
   * @return
   */
  @Override
  public Task getTaskById(Integer tId) {
    return this.taskRepository
        .findById(tId)
        .orElseThrow(() -> new TaskNotFoundException("Task not found"));
  }

  /**
   * @param tId
   * @return
   */
  @Override
  public String deleteTask(Integer tId) {
    Task task =
        this.taskRepository
            .findById(tId)
            .orElseThrow(() -> new TaskNotFoundException("Task not found"));
    this.taskRepository.delete(task);
    return "Task deleted successfully";
  }
}

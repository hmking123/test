package com.example.project_management_app.service;

import com.example.project_management_app.model.Task;
import com.example.project_management_app.model.TaskStatus;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task createTask(Task task);

    Task updateTask(Long id, Task task);

    Optional<Task> getTaskById(Long id);

    List<Task> getAllTasks();

    void deleteTask(Long id);

    List<Task> getTasksByAssignedUser(Long userId);

    List<Task> getTasksByProject(Long projectId);

    List<Task> getTasksByStatus(TaskStatus status);

    List<Task> searchTasksByName(String name);
}

package com.example.project_management_app.service;

import com.example.project_management_app.model.Task;
import com.example.project_management_app.model.TaskStatus;
import com.example.project_management_app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getTasksByAssignedUser(Long userId) {
        return taskRepository.findByAssignedToId(userId);
    }

    @Override
    public List<Task> getTasksByProject(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    @Override
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public List<Task> searchTasksByName(String name) {
        return taskRepository.findByNameContainingIgnoreCase(name);
    }
}

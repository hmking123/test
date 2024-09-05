package com.example.project_management_app.repository;

import com.example.project_management_app.model.Task;
import com.example.project_management_app.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Trouver les tâches assignées à un utilisateur spécifique
    List<Task> findByAssignedToId(Long userId);

    // Trouver les tâches associées à un projet spécifique
    List<Task> findByProjectId(Long projectId);

    // Trouver les tâches par statut
    List<Task> findByStatus(TaskStatus status);

    // Trouver les tâches par nom (recherche partielle)
    List<Task> findByNameContainingIgnoreCase(String name);
}

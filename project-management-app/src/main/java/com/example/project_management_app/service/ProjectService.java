package com.example.project_management_app.service;

import com.example.project_management_app.model.Project;
import com.example.project_management_app.model.User;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> findAll();
    Optional<Project> findById(Long id);
    List<Project> findByAdminId(Long adminId);
    List<Project> findByMemberId(Long memberId);
    List<Project> findByName(String name);
    Project save(Project project);
    Project update(Project project);
    void deleteById(Long id);
    void addMemberToProject(Long projectId, Long userId);
    void removeMemberFromProject(Long projectId, Long userId);
}


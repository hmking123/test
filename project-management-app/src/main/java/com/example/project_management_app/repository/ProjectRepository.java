package com.example.project_management_app.repository;

import com.example.project_management_app.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByAdminId(Long adminId);
    List<Project> findByMembersId(Long memberId);
    List<Project> findByNameContainingIgnoreCase(String name);
}

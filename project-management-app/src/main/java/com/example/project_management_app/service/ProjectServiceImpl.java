package com.example.project_management_app.service.impl;

import com.example.project_management_app.model.Project;
import com.example.project_management_app.model.User;
import com.example.project_management_app.repository.ProjectRepository;
import com.example.project_management_app.repository.UserRepository;
import com.example.project_management_app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public List<Project> findByAdminId(Long adminId) {
        return projectRepository.findByAdminId(adminId);
    }

    @Override
    public List<Project> findByMemberId(Long memberId) {
        return projectRepository.findByMembersId(memberId);
    }

    @Override
    public List<Project> findByName(String name) {
        return projectRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    @Transactional
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    @Transactional
    public Project update(Project project) {
        return projectRepository.save(project);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addMemberToProject(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        project.addMember(user);
        projectRepository.save(project);
    }

    @Override
    @Transactional
    public void removeMemberFromProject(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        project.removeMember(user);
        projectRepository.save(project);
    }
}

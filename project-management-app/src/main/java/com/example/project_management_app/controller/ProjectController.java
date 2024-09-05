package com.example.project_management_app.controller;

import com.example.project_management_app.model.Project;
import com.example.project_management_app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return projectService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<Project>> getProjectsByAdminId(@PathVariable Long adminId) {
        return ResponseEntity.ok(projectService.findByAdminId(adminId));
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<Project>> getProjectsByMemberId(@PathVariable Long memberId) {
        return ResponseEntity.ok(projectService.findByMemberId(memberId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Project>> searchProjectsByName(@RequestParam String name) {
        return ResponseEntity.ok(projectService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.save(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
        if (!projectService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        project.setId(id);
        return ResponseEntity.ok(projectService.update(project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        if (!projectService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        projectService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{projectId}/members/{userId}")
    public ResponseEntity<Void> addMemberToProject(@PathVariable Long projectId, @PathVariable Long userId) {
        projectService.addMemberToProject(projectId, userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{projectId}/members/{userId}")
    public ResponseEntity<Void> removeMemberFromProject(@PathVariable Long projectId, @PathVariable Long userId) {
        projectService.removeMemberFromProject(projectId, userId);
        return ResponseEntity.ok().build();
    }
}


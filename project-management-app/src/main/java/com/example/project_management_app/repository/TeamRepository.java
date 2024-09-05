package com.example.project_management_app.repository;

import com.example.project_management_app.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findByProjectId(Long projectId);

    Team findByChefDeProjetId(Long chefDeProjetId);
}

package com.example.project_management_app.service;

import com.example.project_management_app.model.Team;
import java.util.List;
import java.util.Optional;

public interface TeamService {

    Team createTeam(Team team);

    Team updateTeam(Long id, Team team);

    Optional<Team> getTeamById(Long id);

    List<Team> getTeamsByProjectId(Long projectId);

    Optional<Team> getTeamByChefDeProjetId(Long chefDeProjetId);

    List<Team> getAllTeams();

    void deleteTeam(Long id);
}

package com.example.project_management_app.service;

import com.example.project_management_app.model.Team;
import com.example.project_management_app.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Long id, Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    @Override
    public List<Team> getTeamsByProjectId(Long projectId) {
        return teamRepository.findByProjectId(projectId);
    }

    @Override
    public Optional<Team> getTeamByChefDeProjetId(Long chefDeProjetId) {
        return Optional.ofNullable(teamRepository.findByChefDeProjetId(chefDeProjetId));
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}

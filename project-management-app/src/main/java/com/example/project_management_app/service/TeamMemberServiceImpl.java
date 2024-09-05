package com.example.project_management_app.service;

import com.example.project_management_app.model.TeamMember;
import com.example.project_management_app.repository.TeamMemberRepository;
import com.example.project_management_app.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Override
    public TeamMember addTeamMember(TeamMember teamMember) {
        return teamMemberRepository.save(teamMember);
    }

    @Override
    public Optional<TeamMember> getTeamMemberById(Long id) {
        return teamMemberRepository.findById(id);
    }

    @Override
    public List<TeamMember> getMembersByTeamId(Long teamId) {
        return teamMemberRepository.findByTeamId(teamId);
    }

    @Override
    public List<TeamMember> getMembersByUserId(Long userId) {
        return teamMemberRepository.findByUserId(userId);
    }

    @Override
    public Optional<TeamMember> getTeamMemberByTeamIdAndUserId(Long teamId, Long userId) {
        return teamMemberRepository.findByTeamIdAndUserId(teamId, userId);
    }

    @Override
    public void removeTeamMember(Long id) {
        teamMemberRepository.deleteById(id);
    }
}

package com.example.project_management_app.service;

import com.example.project_management_app.model.TeamMember;

import java.util.List;
import java.util.Optional;

public interface TeamMemberService {

    TeamMember addTeamMember(TeamMember teamMember);

    Optional<TeamMember> getTeamMemberById(Long id);

    List<TeamMember> getMembersByTeamId(Long teamId);

    List<TeamMember> getMembersByUserId(Long userId);

    Optional<TeamMember> getTeamMemberByTeamIdAndUserId(Long teamId, Long userId);

    void removeTeamMember(Long id);
}

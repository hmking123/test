package com.example.project_management_app.controller;

import com.example.project_management_app.model.TeamMember;
import com.example.project_management_app.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/team-members")
public class TeamMemberController {

    @Autowired
    private TeamMemberService teamMemberService;

    // Ajouter un nouveau membre à une équipe
    @PostMapping
    public ResponseEntity<TeamMember> addTeamMember(@RequestBody TeamMember teamMember) {
        TeamMember newTeamMember = teamMemberService.addTeamMember(teamMember);
        return new ResponseEntity<>(newTeamMember, HttpStatus.CREATED);
    }

    // Récupérer un membre d'équipe par son ID
    @GetMapping("/{id}")
    public ResponseEntity<TeamMember> getTeamMemberById(@PathVariable Long id) {
        Optional<TeamMember> teamMember = teamMemberService.getTeamMemberById(id);
        return teamMember.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Récupérer tous les membres d'une équipe par l'ID de l'équipe
    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<TeamMember>> getMembersByTeamId(@PathVariable Long teamId) {
        List<TeamMember> members = teamMemberService.getMembersByTeamId(teamId);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    // Récupérer tous les membres d'équipe associés à un utilisateur spécifique
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TeamMember>> getMembersByUserId(@PathVariable Long userId) {
        List<TeamMember> members = teamMemberService.getMembersByUserId(userId);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    // Récupérer un membre d'équipe par l'ID de l'équipe et l'ID de l'utilisateur
    @GetMapping("/team/{teamId}/user/{userId}")
    public ResponseEntity<TeamMember> getTeamMemberByTeamIdAndUserId(@PathVariable Long teamId,
                                                                     @PathVariable Long userId) {
        Optional<TeamMember> teamMember = teamMemberService.getTeamMemberByTeamIdAndUserId(teamId, userId);
        return teamMember.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Supprimer un membre d'équipe par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeTeamMember(@PathVariable Long id) {
        teamMemberService.removeTeamMember(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

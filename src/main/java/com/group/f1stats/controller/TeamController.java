// Author: Izhan Akhtar - 421009836
// Entity: Team
package com.group.f1stats.controller;

import com.group.f1stats.model.Team;
import com.group.f1stats.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    // GET all teams
    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    // GET team by ID
    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        Optional<Team> team = teamService.getTeamById(id);
        return team.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET search by name
    @GetMapping("/search")
    public List<Team> searchTeams(@RequestParam String name) {
        return teamService.searchTeamsByName(name);
    }

    // POST create new team
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        Team created = teamService.createTeam(team);
        return ResponseEntity.status(201).body(created);
    }

    // PUT full update
    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody Team team) {
        Team updated = teamService.updateTeam(id, team);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}
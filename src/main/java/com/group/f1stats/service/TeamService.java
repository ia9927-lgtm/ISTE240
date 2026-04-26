// Author: Izhan Akhtar - 421009836
// Entity: Team
package com.group.f1stats.service;

import com.group.f1stats.model.Team;
import com.group.f1stats.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public List<Team> searchTeamsByName(String name) {
        return teamRepository.findByNameContaining(name);
    }

    @Transactional
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Transactional
    public Team updateTeam(Long id, Team updatedTeam) {
        Optional<Team> existing = teamRepository.findById(id);
        if (existing.isPresent()) {
            Team team = existing.get();
            team.setName(updatedTeam.getName());
            team.setNationality(updatedTeam.getNationality());
            team.setPrincipal(updatedTeam.getPrincipal());
            team.setChampionships(updatedTeam.getChampionships());
            return teamRepository.save(team);
        }
        return null;
    }

    @Transactional
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    @Transactional
    public void updatePrincipal(Long id, String principal) {
        teamRepository.updatePrincipalById(id, principal);
    }
}
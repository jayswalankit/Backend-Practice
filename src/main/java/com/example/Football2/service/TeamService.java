package com.example.Football2.service;

import com.example.Football2.model.Team;
import com.example.Football2.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team addOrUpdateTeam(Team team) {
        Optional<Team> existingTeam = teamRepository.findByTeamNameIgnoreCase(team.getTeamName());
        existingTeam.ifPresent(t -> team.setId(t.getId())); // preserve ID for update
        return teamRepository.save(team);
    }

    public Team getTeamByName(String teamName) {
        return teamRepository.findByTeamNameIgnoreCase(teamName).orElse(null);
    }

    public String deleteTeam(String teamName) {
        Optional<Team> team = teamRepository.findByTeamNameIgnoreCase(teamName);
        if (team.isPresent()) {
            teamRepository.deleteByTeamNameIgnoreCase(teamName);
            return "Team deleted successfully!";
        }
        return "Team not found!";
    }
}

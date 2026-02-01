package com.example.Football2.controller;

import com.example.Football2.model.Team;
import com.example.Football2.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/detail")
    public Team getTeamDetail(@RequestParam String teamName) {
        return teamService.getTeamByName(teamName);
    }

    @PostMapping("/")
    public Team addTeam(@RequestBody Team team) {
        return teamService.addOrUpdateTeam(team);
    }

    @PutMapping("/")
    public Team updateTeam(@RequestBody Team team) {
        return teamService.addOrUpdateTeam(team);
    }

    @DeleteMapping("/")
    public String deleteTeam(@RequestParam String teamName) {
        return teamService.deleteTeam(teamName);
    }
    // wow
}

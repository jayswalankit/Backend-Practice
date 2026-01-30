package com.example.Football2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "teams")
public class Team {

    @Id
    private String id; // MongoDB unique ID

    private String teamName;
    private String captainName;
    private List<String> players;

    public Team() {}

    public Team(String teamName, String captainName, List<String> players) {
        this.teamName = teamName;
        this.captainName = captainName;
        this.players = players;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public String getCaptainName() { return captainName; }
    public void setCaptainName(String captainName) { this.captainName = captainName; }

    public List<String> getPlayers() { return players; }
    public void setPlayers(List<String> players) { this.players = players; }
}

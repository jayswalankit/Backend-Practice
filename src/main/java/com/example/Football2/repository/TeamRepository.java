package com.example.Football2.repository;

import com.example.Football2.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {
    Optional<Team> findByTeamNameIgnoreCase(String teamName);
    void deleteByTeamNameIgnoreCase(String teamName);
}

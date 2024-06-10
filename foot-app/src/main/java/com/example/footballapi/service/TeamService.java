package com.example.footballapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.footballapi.model.Player;
import com.example.footballapi.model.Team;
import com.example.footballapi.repository.TeamRepository;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team createTeam(String name, String acronym, double budget) {
        Team team = new Team();
        team.setName(name);
        team.setAcronym(acronym);
        team.setBudget(budget);
        team.setPlayers(new ArrayList<>());
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, String name, String acronym, double budget) {
        Team team = teamRepository.findById(id).orElse(null);
        if (team != null) {
            team.setName(name);
            team.setAcronym(acronym);
            team.setBudget(budget);
            return teamRepository.save(team);
        }
        return null;
    }

    public Player addPlayerToTeam(Long teamId, String name, String position) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new IllegalArgumentException("Team not found"));
        Player player = new Player();
        player.setName(name);
        player.setPosition(position);
        team.getPlayers().add(player);
        teamRepository.save(team);
        return player;
    }
}
package com.example.footballapi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.footballapi.model.Team;
import com.example.footballapi.repository.TeamRepository;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, Team updatedTeam) {
        Team team = teamRepository.findById(id).orElse(null);
        if (team != null) {
        	team.setId(updatedTeam.getId());
            team.setName(updatedTeam.getName());
            team.setAcronym(updatedTeam.getAcronym());
            team.setBudget(updatedTeam.getBudget());
            team.setPlayers(updatedTeam.getPlayers());
            return teamRepository.save(team);
        }
        return null;
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

	public Page<Team> getTeams(Pageable pageable) {
        return teamRepository.findAll(pageable);
    }
}
package com.example.footballapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.footballapi.model.Player;
import com.example.footballapi.repository.PlayerRepository;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player updatedPlayer) {
        Player player = playerRepository.findById(id).orElse(null);
        if (player != null) {
            player.setName(updatedPlayer.getName());
            player.setPosition(updatedPlayer.getPosition());
            return playerRepository.save(player);
        }
        return null;
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
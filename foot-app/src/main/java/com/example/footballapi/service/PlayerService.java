package com.example.footballapi.service;

import org.springframework.stereotype.Service;

import com.example.footballapi.model.Player;
import com.example.footballapi.repository.PlayerRepository;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(String name, String position) {
        Player player = new Player();
        player.setName(name);
        player.setPosition(position);
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, String name, String position) {
        Player player = playerRepository.findById(id).orElse(null);
        if (player != null) {
            player.setName(name);
            player.setPosition(position);
            return playerRepository.save(player);
        }
        return null;
    }
}
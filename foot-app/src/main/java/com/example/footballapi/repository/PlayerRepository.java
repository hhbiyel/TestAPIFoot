package com.example.footballapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.footballapi.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
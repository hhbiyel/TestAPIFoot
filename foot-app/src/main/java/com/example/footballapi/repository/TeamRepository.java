package com.example.footballapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.footballapi.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
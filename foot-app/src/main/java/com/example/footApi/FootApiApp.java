package com.example.footApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.footballapi.model.Player;
import com.example.footballapi.model.Team;

@SpringBootApplication
public class FootApiApp {

    public static void main(String[] args) {
        SpringApplication.run(FootApiApp.class, args);

     // Créer les players
        Player player1 = new Player("John Doe", "Forward");
        Player player2 = new Player("Jane Smith", "Midfielder");
        Player player3 = new Player("Bob Johnson", "Defender");

        // Créer l'équipe
        Team team1 = new Team("Acme FC", "ACF", null, 2000000.0);

        // Ajouter les players à la liste
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        // Affecter la liste de players à l'équipe
        team1.setPlayers(players);

        System.out.println("Player: " + player1.getName());
        System.out.println("Team: " + team1.getName() + " (" + team1.getPlayers().toString() + ")" + team1.getBudget());
    }

}
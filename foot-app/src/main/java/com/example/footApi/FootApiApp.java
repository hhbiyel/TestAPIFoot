package com.example.footApi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FootApiApp {

    public static void main(String[] args) {
        SpringApplication.run(FootApiApp.class, args);

     // Connexion à la base de données
        String url = "jdbc:postgresql://localhost:5432/football_db";
        String username = "postgres";
        String password = "1995";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Vérifier si le schéma "football_schema" existe déjà
            if (!schemaExists(connection, "football_schema")) {
                // Exécution du script SQL pour créer le schéma et les tables
                executeSqlScript(connection, "src/main/resources/create_schema_and_tables.sql");
                System.out.println("Schéma et tables créés avec succès !");
            } else {
                System.out.println("Schéma 'football_schema' existe déjà.");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
//        // Créer les players
//        Player player1 = new Player("John Doe", "Forward");
//        Player player2 = new Player("Jane Smith", "Midfielder");
//        Player player3 = new Player("Bob Johnson", "Defender");
//
//        // Créer l'équipe
//        Team team1 = new Team("Acme FC", "ACF", null, 2000000.0);
//
//        // Ajouter les players à la liste
//        List<Player> players = new ArrayList<>();
//        players.add(player1);
//        players.add(player2);
//        players.add(player3);
//
//        // Affecter la liste de players à l'équipe
//        team1.setPlayers(players);
//
//        System.out.println("Player: " + player1.getName());
//        System.out.println("Team: " + team1.getName() + " (" + team1.getPlayers().toString() + ")" + team1.getBudget());
    }
    private static boolean schemaExists(Connection connection, String schemaName) throws SQLException {
        DatabaseMetaData metadata = connection.getMetaData();
        try (ResultSet resultSet = metadata.getSchemas()) {
            while (resultSet.next()) {
                if (resultSet.getString("TABLE_SCHEM").equalsIgnoreCase(schemaName)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void executeSqlScript(Connection connection, String scriptPath) throws IOException, SQLException {
        try (BufferedReader reader = new BufferedReader(new FileReader(scriptPath))) {
            StringBuilder scriptBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                scriptBuilder.append(line).append("\n");
            }

            String script = scriptBuilder.toString();
            Statement statement = connection.createStatement();
            statement.execute(script);
        }
    }

}
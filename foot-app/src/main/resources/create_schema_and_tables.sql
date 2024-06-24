-- Création du schéma
CREATE SCHEMA football_schema;

-- Création de la table "Player"
CREATE TABLE football_schema.Player (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    position VARCHAR(50) NOT NULL
);

-- Création de la table "Team"
CREATE TABLE football_schema.Team (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    acronym VARCHAR(10) NOT NULL,
    budget NUMERIC(12,2),
    player_id INTEGER,
    FOREIGN KEY (player_id) REFERENCES football_schema.Player(id)
);
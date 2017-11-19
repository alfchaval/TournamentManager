package com.example.alfonso.tournamentmanager.db.repository;

import com.example.alfonso.tournamentmanager.pojo.Player;

import java.util.ArrayList;

/**
 * @author Alfonso Chamorro Valle
 * Repositorio de Jugadores
 */

public class PlayerRepository {

    /* Declaración */
    private ArrayList<Player> players;
    private static PlayerRepository userRepository;

    public PlayerRepository() {
        this.players = new ArrayList<>();
        initialize();
    }

    /**
     * El método ha de ser privado para garantizar que solo hay una instancia de Repository
     */
    private void initialize() {
        savePlayer(new Player(1, "Jose", "Pepe", "666111111"));
        savePlayer(new Player(2, "Antonio", "Tony", "666222222"));
        savePlayer(new Player(3, "Anabel", "etrse3", "666333333"));
        savePlayer(new Player(4, "Alejandro Guzmán", "Alex", "666444444"));
        savePlayer(new Player(5, "Juan Miguel", "Torse", "666555555"));
        savePlayer(new Player(6, "Daniel", "Donny", "666666666"));
        savePlayer(new Player(7, "Rebeca", "Rebe", "666777777"));
        savePlayer(new Player(8, "Nuria", "Nuria", "666888888"));
    }

    /* Métodos */
    public static PlayerRepository getInstance() {
        if(userRepository == null) {
            userRepository = new PlayerRepository();
        }
        return userRepository;
    }

    /**
     * Método que añade una dependencia
     * @param player
     */
    public void savePlayer(Player player) {
        players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public boolean playerExist(Player player) {
        return false;
    }

}
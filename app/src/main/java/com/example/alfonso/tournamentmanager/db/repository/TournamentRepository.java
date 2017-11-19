package com.example.alfonso.tournamentmanager.db.repository;

import com.example.alfonso.tournamentmanager.pojo.Tournament;

import java.util.ArrayList;

/**
 * @author Alfonso Chamorro Valle
 * Repositorio de Torneos
 */

public class TournamentRepository {

    /* Declaración */
    private ArrayList<Tournament> tournaments;
    private static TournamentRepository userRepository;

    public TournamentRepository() {
        this.tournaments = new ArrayList<>();
        initialize();
    }

    /**
     * El método ha de ser privado para garantizar que solo hay una instancia de Repository
     */
    private void initialize() {

        PlayerRepository playerRepository = PlayerRepository.getInstance();

        addTournament(new Tournament(0, "Torneo 1", playerRepository.getPlayers().get(0)));
        addTournament(new Tournament(1, "Torneo 2", playerRepository.getPlayers().get(1)));
        addTournament(new Tournament(2, "Torneo 3", playerRepository.getPlayers().get(2)));
        addTournament(new Tournament(3, "Torneo 4", playerRepository.getPlayers().get(3)));
        addTournament(new Tournament(4, "Torneo 5", playerRepository.getPlayers().get(4)));

    }

    /* Métodos */
    public static TournamentRepository getInstance() {
        if(userRepository == null) {
            userRepository = new TournamentRepository();
        }
        return userRepository;
    }

    /**
     * Método que añade una dependencia
     * @param tournament
     */
    public void addTournament(Tournament tournament) {
        tournaments.add(tournament);
    }

    public ArrayList<Tournament> getTournaments() {
        return tournaments;
    }

    public boolean tournamentExist(Tournament tournament) {
        return false;
    }

}
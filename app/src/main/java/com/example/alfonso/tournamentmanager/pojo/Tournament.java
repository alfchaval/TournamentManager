package com.example.alfonso.tournamentmanager.pojo;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * @Author Alfonso Chamorro Valle
 */

public class Tournament {

    int _id;
    String _name;
    Player _organizer;
    Player[] _players;
    Player[] _officials;
    Round[] _rounds;

    public Tournament(int _id, String _name, Player _organizer) {
        this._id = _id;
        this._name = _name;
        this._organizer = _organizer;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public Player get_organizer() {
        return _organizer;
    }

    public void set_organizer(Player _organizer) {
        this._organizer = _organizer;
    }

    public Player[] get_players() {
        return _players;
    }

    public void set_players(Player[] _players) {
        this._players = _players;
    }

    public Player[] get_officials() {
        return _officials;
    }

    public void set_officials(Player[] _officials) {
        this._officials = _officials;
    }

    public Round[] get_rounds() {
        return _rounds;
    }

    public void set_rounds(Round[] _rounds) {
        this._rounds = _rounds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return ((Tournament) o)._id == this._id;
    }

    public static class TournamentOrderByName implements Comparator<Tournament> {

        @Override
        public int compare(Tournament t1, Tournament t2) {
            return t1._name.compareTo(t2._name);
        }
    }

    public static class TournamentOrderByOrganizer implements Comparator<Tournament> {

        @Override
        public int compare(Tournament t1, Tournament t2) {
            return t1._organizer.compareTo(t2._organizer);
        }
    }
}

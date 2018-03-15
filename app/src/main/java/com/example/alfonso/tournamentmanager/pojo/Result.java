package com.example.alfonso.tournamentmanager.pojo;

/**
 * @Author Alfonso Chamorro Valle
 */

public class Result {

    private Player[] _players;

    private int[] _points;

    public Result (Player[] _players) {
        this._players = _players;
        this._points = new int[_players.length];
    }

    public Player[] get_players() {
        return _players;
    }

    public void set_players(Player[] _players) {
        this._players = _players;
    }

    public Player get_player(int n) {
        return _players[n];
    }

    public boolean set_player(int n, Player _player) {
        if(n >= 0 && n < this._players.length) {
            this._players[n] = _player;
            return true;
        }
        return false;
    }

    public int[] get_points() {
        return _points;
    }

    public void set_points(int[] _points) {
        this._points = _points;
    }

    public int get_points(int n) {
        return _points[n];
    }

    public boolean set_points(int n, int _points) {
        if(n >= 0 && n < this._points.length) {
            this._points[n] = _points;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        boolean res = true;
        if(this._players.length != result.get_players().length) {
            res = false;
        } else {
            int index = 0;
            while(res && index < this._players.length) {
                if(this._players[index] != result.get_player(index)) {
                    res = false;
                }
                if(this._points[index] != result.get_points(index)) {
                    res = false;
                }
                index++;
            }
        }
        return res;
    }
}

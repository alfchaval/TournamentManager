package com.example.alfonso.tournamentmanager.pojo;

/**
 * @Author Alfonso Chamorro Valle
 */

public class Match {

    private Player _player1;
    private Player _player2;
    private int _result;

    public Match(Player _player1, Player _player2) {
        this._player1 = _player1;
        this._player2 = _player2;
        this._result = 0;
    }

    public Match(Player _player1, Player _player2, int _result) {
        this._player1 = _player1;
        this._player2 = _player2;
        this._result = _result;
    }


    public Player get_player1() {
        return _player1;
    }

    public void set_player1(Player _player1) {
        this._player1 = _player1;
    }

    public Player get_player2() {
        return _player2;
    }

    public void set_player2(Player _player2) {
        this._player2 = _player2;
    }

    public int get_result() {
        return _result;
    }

    public void set_result(int _result) {
        this._result = _result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return (match._player1 == this._player1 && match._player2 == this._player2 && match._result == this._result) ||
                (match._player1 == this._player2 && match._player2 == this._player1 && match._result == this._result);
    }
}

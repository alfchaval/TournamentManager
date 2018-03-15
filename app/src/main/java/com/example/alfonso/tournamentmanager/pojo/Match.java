package com.example.alfonso.tournamentmanager.pojo;

/**
 * @Author Alfonso Chamorro Valle
 */

public class Match {

    private Player[] _players;
    private Result _result;

    public Match(Player[] _players) {
        this._players = _players;
        this._result = new Result(this._players);
    }

    public Match(Player _player1, Player _player2) {
        this._players = new Player[]{_player1, _player2};
        this._result = new Result(this._players);
    }

    public Player get_player1() {
        return _players[0];
    }

    public void set_player1(Player _player1) {
        this._players[0] = _player1;
        this._result.get_players()[0] = _player1;
    }

    public Player get_player2() {
        return _players[1];
    }

    public void set_player2(Player _player2) {
        this._players[1] = _player2;
        this._result.get_players()[1] = _player2;
    }

    public Result get_result() {
        return _result;
    }

    public void set_result(Result _result) {
        //Check that it is a valid result before set it.
        boolean isValid = true;
        Player[] playersInResult = this._result.get_players();
        if(playersInResult.length != this._players.length) {
            isValid = false;
        } else {
            int index = 0;
            while(isValid && index < this._players.length) {
                if(this._players[index] != playersInResult[index]) {
                    isValid = false;
                }
                index++;
            }
        }
        //Set the result if is valid
        if(isValid) {
            this._result = _result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return (match._result == match._result);
    }
}

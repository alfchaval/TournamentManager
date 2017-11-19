package com.example.alfonso.tournamentmanager.pojo;

/**
 * @Author Alfonso Chamorro Valle
 */

public class Round {

    private Match[] _matches;

    public Round(Match[] _matches) {
        this._matches = _matches;
    }

    public Round(int numMatches) {
        this._matches = new Match[numMatches];
    }

    public Match[] get_matches() {
        return _matches;
    }

    public void set_matches(Match[] _matches) {
        this._matches = _matches;
    }
}

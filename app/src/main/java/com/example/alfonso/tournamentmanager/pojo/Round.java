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

    public Match get_match(int n) {
        return _matches[n];
    }

    public void set_matches(Match[] _matches) {
        this._matches = _matches;
    }

    public void set_match(int n, Match _match) {
        this._matches[n] = _match;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        boolean res = true;
        if(this._matches.length != round._matches.length) {
            res = false;
        } else {
            int index = 0;
            while(res && index < this._matches.length) {
                if(this._matches[index] != round._matches[index]) {
                    res = false;
                }
                index++;
            }
        }
        return res;
    }
}
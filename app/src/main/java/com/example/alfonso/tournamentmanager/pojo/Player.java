package com.example.alfonso.tournamentmanager.pojo;

import android.support.annotation.NonNull;

/**
 * @Author Alfonso Chamorro Valle
 */

public class Player implements Comparable{
    private int _id;
    private String _name;
    private String _nickname;
    private String _telephone;

    public Player(int _id, String _name, String _nickname, String _telephone) {
        this._id = _id;
        this._name = _name;
        this._nickname = _nickname;
        this._telephone = _telephone;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_nickname() {
        return _nickname;
    }

    public void set_nickname(String _nickname) {
        this._nickname = _nickname;
    }

    public String get_telephone() {
        return _telephone;
    }

    public void set_telephone(String _telephone) {
        this._telephone = _telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return ((Player) o)._id == this._id;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return _name.compareTo(((Player)o)._name);
    }
}

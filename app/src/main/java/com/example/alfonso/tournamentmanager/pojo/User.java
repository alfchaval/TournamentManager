package com.example.alfonso.tournamentmanager.pojo;

/**
 * @Author Alfonso Chamorro Valle
 */

public class User {
    private String _user;
    private String _password;
    private String _name;

    public User(String _user, String _password, String _name) {
        this._user = _user;
        this._password = _password;
        this._name = _name;
    }

    public String get_user() {
        return _user;
    }

    public void set_user(String _user) {
        this._user = _user;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return ((User) o)._user == this._user;
    }
}

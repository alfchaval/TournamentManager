package com.example.alfonso.tournamentmanager.db.repository;

import com.example.alfonso.tournamentmanager.pojo.User;

import java.util.ArrayList;

/**
 * @author Alfonso Chamorro Valle
 * Repositorio de Usuarios
 */

public class UserRepository {

    /* Declaración */
    private ArrayList<User> Users;
    private static UserRepository userRepository;

    public UserRepository() {
        this.Users = new ArrayList<>();
        initialize();
    }

    /**
     * El método ha de ser privado para garantizar que solo hay una instancia de Repository
     */
    private void initialize() {
        saveUser(new User("alfchaval", "Aa1...", "Alfonso Chamorro"));
        saveUser(new User("usuario", "ContraseñaEjemplo1", "Alfonso Chamorro"));
    }

    /* Métodos */
    public static UserRepository getInstance() {
        if(userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    /**
     * Método que añade una dependencia
     * @param User
     */
    public void saveUser(User User) {
        Users.add(User);
    }

    public ArrayList<User> getUsers() {
        return Users;
    }

    public boolean userExist(User user) {
        return false;
    }

}
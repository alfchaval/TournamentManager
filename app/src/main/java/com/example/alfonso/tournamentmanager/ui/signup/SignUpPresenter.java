package com.example.alfonso.tournamentmanager.ui.signup;

/**
 * @author Alfonso Chamorro Valle
 * Interfaz del presentador del Login
 */

public interface SignUpPresenter {

    void validateCredentials(String user, String password, String password2);

    void onDestroy();
}

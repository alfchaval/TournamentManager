package com.example.alfonso.tournamentmanager.ui.signup;

/**
 * Contiene los métodos necesarios para la comunicación entre el presentador y la vista
 * @Author Alfonso Chamorro
 */

public interface SignUpView {

    void signUpAndEnter();

    void setUserEmptyError();

    void setPasswordEmptyError();

    void setPasswordDifferentError();

    void setPasswordError();
}

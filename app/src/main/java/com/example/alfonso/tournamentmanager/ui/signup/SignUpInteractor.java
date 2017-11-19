package com.example.alfonso.tournamentmanager.ui.signup;

/**
 * @author Alfonso Chamorro Valle
 * Interfaz del interactor dle Login
 */

public interface SignUpInteractor {

    void validateCredentials(String user, String password, String password2, OnSignUpFinishedListener onSighUpFinishedListener);

    interface OnSignUpFinishedListener {
        void onUserEmptyError();
        void onPasswordEmptyError();
        void onPasswordDifferentError();
        void onPasswordError();
        void onSuccess();
    }

}

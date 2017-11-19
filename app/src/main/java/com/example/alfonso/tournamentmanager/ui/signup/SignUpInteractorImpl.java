package com.example.alfonso.tournamentmanager.ui.signup;

import android.text.TextUtils;
import android.util.Log;

import com.example.alfonso.tournamentmanager.ui.utils.CommonUtils;

/**
 * @author Alfonso Chamorro Valle
 * Interactor del Login
 */

public class SignUpInteractorImpl implements SignUpInteractor {

    @Override
    public void validateCredentials(String user, String password, String password2, OnSignUpFinishedListener listener) {

        if(TextUtils.isEmpty(user)) {
            listener.onUserEmptyError();
        }
        else if(TextUtils.isEmpty(password)) {
            listener.onPasswordEmptyError();
        }
        else if(!CommonUtils.isPasswordValid(password) || !CommonUtils.isPasswordValid(password2)) {
            listener.onPasswordError();
        }
        /*
        else if(password != password2) {
            listener.onPasswordDifferentError();
        }
        */
        else {
            listener.onSuccess();
        }
    }
}

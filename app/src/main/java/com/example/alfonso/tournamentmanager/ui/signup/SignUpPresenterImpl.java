package com.example.alfonso.tournamentmanager.ui.signup;

import com.example.alfonso.tournamentmanager.ui.login.LoginView;

/**
 * @author Alfonso Chamorro Valle
 * Presentador del Login
 */

public class SignUpPresenterImpl implements SignUpPresenter, SignUpInteractor.OnSignUpFinishedListener {

    private SignUpView signupView;
    private SignUpInteractor signupInteractor;

    public SignUpPresenterImpl(SignUpView signupView) {
        this.signupView = signupView;
        this.signupInteractor = new SignUpInteractorImpl();
    }

    @Override
    public void validateCredentials(String user, String password, String password2) {
        signupInteractor.validateCredentials(user, password, password2, this);
    }

    @Override
    public void onUserEmptyError() {
        signupView.setUserEmptyError();
    }

    @Override
    public void onPasswordEmptyError() {
        signupView.setPasswordEmptyError();
    }

    @Override
    public void onPasswordDifferentError() {
        signupView.setPasswordDifferentError();
    }

    @Override
    public void onPasswordError() {
        signupView.setPasswordError();
    }

    @Override
    public void onDestroy() {
        this.signupView = null;
        this.signupInteractor = null;
    }

    @Override
    public void onSuccess() {
        signupView.signUpAndEnter();
    }
}

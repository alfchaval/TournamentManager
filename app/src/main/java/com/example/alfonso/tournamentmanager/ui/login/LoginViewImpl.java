package com.example.alfonso.tournamentmanager.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alfonso.tournamentmanager.ui.base.BaseActivity;
import com.example.alfonso.tournamentmanager.ui.main.MainActivity;
import com.example.alfonso.tournamentmanager.R;
import com.example.alfonso.tournamentmanager.ui.signup.SignUpViewImpl;

/**
 * @author Alfonso Chamorro Valle
 * Login de la aplicación
 */

public class LoginViewImpl extends BaseActivity implements LoginView {

    EditText edtUser, edtPassword;
    CheckBox chkRemember;
    TextView txvSignUp;
    LoginPresenter loginPresenter;
    Button btnSignIn;

    public static final String PREFERENCES = "PREFERENCES";
    public static final String USER = "USER";
    public static final String PASSWORD = "PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences preferences = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
        loginPresenter = new LoginPresenterImpl(this);

        edtUser = (EditText)findViewById(R.id.edtUser);
        edtUser.setText(preferences.getString(USER, ""));
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        edtPassword.setText(preferences.getString(PASSWORD, ""));
        chkRemember = (CheckBox)findViewById(R.id.chkRemember);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.validateCredentials(edtUser.getText().toString(), edtPassword.getText().toString());
            }
        });
        txvSignUp = (TextView) findViewById(R.id.txvSignUp);
        txvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginViewImpl.this, SignUpViewImpl.class));
            }
        });
    }

    @Override
    public void navigateToHome() {
        if(chkRemember.isChecked()) {
            SharedPreferences.Editor editor = getSharedPreferences(PREFERENCES, MODE_PRIVATE).edit();
            editor.putString(USER, edtUser.getText().toString());
            editor.putString(PASSWORD, edtPassword.getText().toString());
            editor.commit();
        }
        Intent intent = new Intent(LoginViewImpl.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void setUserEmptyError() {
        onError(R.string.errorUserEmpty);
        Snackbar.make(findViewById(android.R.id.content), R.string.errorUserEmpty, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordEmptyError() {
        onError(R.string.errorPasswordEmpty);
        Snackbar.make(findViewById(android.R.id.content), R.string.errorPasswordEmpty, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        onError(R.string.errorPassword);
        Snackbar.make(findViewById(android.R.id.content), R.string.errorPassword, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }
}

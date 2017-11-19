package com.example.alfonso.tournamentmanager.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alfonso.tournamentmanager.R;
import com.example.alfonso.tournamentmanager.db.repository.UserRepository;
import com.example.alfonso.tournamentmanager.pojo.User;
import com.example.alfonso.tournamentmanager.ui.base.BaseActivity;
import com.example.alfonso.tournamentmanager.ui.main.MainActivity;

/**
 * @author Alfonso Chamorro Valle
 */

public class SignUpViewImpl extends BaseActivity implements SignUpView {

    EditText edtUser, edtPassword, edtRepeatPassword;
    Button btnSignUp;
    SignUpPresenter signUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signUpPresenter = new SignUpPresenterImpl(this) {
        };

        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
        edtRepeatPassword = findViewById(R.id.edtRepeatPassword);

        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpPresenter.validateCredentials(edtUser.getText().toString(), edtPassword.getText().toString(), edtRepeatPassword.toString());
            }
        });
    }

    @Override
    public void signUpAndEnter() {
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.saveUser(new User(edtUser.getText().toString(), edtPassword.getText().toString(), edtUser.getText().toString()));
        Intent intent = new Intent(SignUpViewImpl.this, MainActivity.class);
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
    public void setPasswordDifferentError() {
        onError(R.string.errorDifferentPassword);
        Snackbar.make(findViewById(android.R.id.content), R.string.errorDifferentPassword, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        onError(R.string.errorPassword);
        Snackbar.make(findViewById(android.R.id.content), R.string.errorPassword, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        signUpPresenter.onDestroy();
    }
}

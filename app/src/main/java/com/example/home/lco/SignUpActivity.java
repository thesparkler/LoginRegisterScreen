package com.example.home.lco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText userName, userEmail, userPassword, userConPass;
    private Button btnSignUp;
    private TextView txtLogin;
    private String name, email, pwd, con_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initializeWidgets();

        btnSignUp.setOnClickListener(this);

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });


    }

    private void initializeWidgets(){
        userName = (EditText)findViewById(R.id.ed_name);
        userEmail = (EditText)findViewById(R.id.ed_email);
        userPassword = (EditText)findViewById(R.id.ed_pass);
        userConPass = (EditText)findViewById(R.id.con_pass);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);
        txtLogin = (TextView)findViewById(R.id.tv_login);
    }


    @Override
    public void onClick(View v) {
        validation();
    }



    private void validation(){
        name = userName.getText().toString();
        email = userEmail.getText().toString();
        pwd = userPassword.getText().toString();
        con_pwd = userConPass.getText().toString();

        if(name.isEmpty() || email.isEmpty() || pwd.isEmpty() || con_pwd.isEmpty()){
            Toast.makeText(this, getString(R.string.register_error), Toast.LENGTH_LONG).show();

            return;
        }
    }
}

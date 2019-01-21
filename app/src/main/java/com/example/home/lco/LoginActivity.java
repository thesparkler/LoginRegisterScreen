package com.example.home.lco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText userEmail, userPassword;
    private Button btnSignup;
    private TextView txtSignup;
    private String txt_email, txt_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeWidgets();

        btnSignup.setOnClickListener(this);

        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
    }

    private void initializeWidgets()
    {
        userEmail = (EditText)findViewById(R.id.editText_email);
        userPassword = (EditText)findViewById(R.id.editText_pass);
        btnSignup = (Button)findViewById(R.id.btnLogin);
        txtSignup = (TextView)findViewById(R.id.tv_login);
    }

    @Override
    public void onClick(View v) {
        validation();
    }


    private void validation()
    {
        txt_email = userEmail.getText().toString();
        txt_pass = userPassword.getText().toString();

        if(txt_email.isEmpty() || txt_pass.isEmpty()){
            Toast.makeText(this, getString(R.string.register_error), Toast.LENGTH_LONG).show();

            return;
        }
    }
}

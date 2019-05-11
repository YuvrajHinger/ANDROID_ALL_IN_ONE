package com.example.aio;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    private EditText emailLogin;
    private EditText passwordLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_layout);
        emailLogin = (EditText)findViewById(R.id.adminEmailLogin);
        passwordLogin = (EditText)findViewById(R.id.adminPasswordLogin);
    }

    public void loginAdmin(View view){
        String email = emailLogin.getText().toString();
        String password = passwordLogin.getText().toString();
        if(email.matches("AIO") && password.matches("AIO")){
            emailLogin.setText("");
            passwordLogin.setText("");
            Intent intent = new Intent(AdminLogin.this, DataBaseView.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(AdminLogin.this,
                    "INVALID ENTRY", Toast.LENGTH_LONG).show();
        }
    }
}

package com.example.aio;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Member;

public class MemberLogin extends AppCompatActivity {
    private EditText emailLogin;
    private EditText passwordLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_layout);
        emailLogin = (EditText) findViewById(R.id.emailLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);
    }

    public void loginMember(View view){
        SQLDatabase db = new SQLDatabase(this);
        String emailId = emailLogin.getText().toString();
        String password = passwordLogin.getText().toString();
        AOIMember member  = db.loginMember(emailId,password);
        if(member != null) {
            emailLogin.setText("");
            passwordLogin.setText("");
            Intent intent = new Intent(MemberLogin.this, MemberView.class);
            intent.putExtra("USER",member.getEmail_id());
            startActivity(intent);
        }
        else {
            Toast.makeText(MemberLogin.this,
                    "Invalid Entry", Toast.LENGTH_LONG).show();
        }
    }

    public void registerMember(View view){
        Intent intent = new Intent(MemberLogin.this, MemberRegister.class);
        startActivity(intent);
    }
}

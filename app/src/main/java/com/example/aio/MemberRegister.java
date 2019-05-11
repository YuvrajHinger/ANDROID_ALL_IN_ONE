package com.example.aio;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Member;

public class MemberRegister extends AppCompatActivity {
    private EditText emailRegister;
    private EditText passwordRegister;
    private EditText confirmPasswordRegiter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        emailRegister =(EditText)findViewById(R.id.emailRegister);
        passwordRegister=(EditText)findViewById(R.id.passwordRegister);
        confirmPasswordRegiter=(EditText)findViewById(R.id.confirmPasswordRegister);
    }

    public void registerMember(View view){
        SQLDatabase db = new SQLDatabase(this);
        String emailId = emailRegister.getText().toString();
        String password = passwordRegister.getText().toString();
        String confirmPassword = confirmPasswordRegiter.getText().toString();
        if(password.matches(confirmPassword)){
            if(emailId!= null && passwordRegister != null){
                AOIMember member = new AOIMember(emailId,password);
                db.registerMember(member);
                emailRegister.setText("");
                passwordRegister.setText("");
                confirmPasswordRegiter.setText("");
                Intent intent = new Intent(MemberRegister.this, MemberView.class);
                intent.putExtra("USER",member.getEmail_id());
                startActivity(intent);
            }
            else{
                Toast.makeText(MemberRegister.this,
                        "REGISTRATION PROBLEM OCCUR", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(MemberRegister.this,
                    "PASSWORD NOT MATCH", Toast.LENGTH_LONG).show();
            passwordRegister.setText("");
            confirmPasswordRegiter.setText("");
        }
    }
}

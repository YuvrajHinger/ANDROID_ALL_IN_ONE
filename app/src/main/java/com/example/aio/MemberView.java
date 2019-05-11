package com.example.aio;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MemberView extends AppCompatActivity {
    private TextView memberName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memberview_layout);
        memberName = (TextView) findViewById(R.id.memberName);
        memberName.setText("WELCOME "+getIntent().getStringExtra("USER"));
    }

    public void update_data(View view){
        Toast.makeText(MemberView.this,
                "UPDATE SOON", Toast.LENGTH_LONG).show();
    }
    public void delete_data(View view){
        Toast.makeText(MemberView.this,
                "UPDATE SOON", Toast.LENGTH_LONG).show();
    }
    public void logout_data(View view){
        Intent intent = new Intent(MemberView.this, MainActivity.class);
        startActivity(intent);
    }
}

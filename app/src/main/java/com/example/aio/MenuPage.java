package com.example.aio;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.lang.reflect.Member;

public class MenuPage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
    }

    public void helloMethod(View view){
        Intent intent = new Intent(MenuPage.this,HelloWorld.class);
        startActivity(intent);
    }

    public void cardMethod(View view){
        Intent intent = new Intent(MenuPage.this,SimpleCard.class);
        startActivity(intent);
    }

    public void  activitySwitch(View view){
        Intent intent = new Intent(MenuPage.this, MemberLogin.class);
        startActivity(intent);
    }

    public void adminView(View view){
        Intent intent = new Intent(MenuPage.this, AdminLogin.class);
        startActivity(intent);
    }

    public void registerMember(View view){
        Intent intent = new Intent(MenuPage.this, MemberRegister.class);
        startActivity(intent);
    }
}

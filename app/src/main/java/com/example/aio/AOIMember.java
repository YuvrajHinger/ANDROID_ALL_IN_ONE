package com.example.aio;

public class AOIMember {
    String email_id;
    String password;
    AOIMember(String email_id,String password){
        this.email_id = email_id;
        this.password = password;
    }
    public String getEmail_id(){ return this.email_id; }
    public String getPassword(){
        return this.password;
    }
}

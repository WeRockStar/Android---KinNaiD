package com.example.kotchaphanmuangsan.kinnaid;

import android.app.Activity;
import android.os.Bundle;

import db.userSource;


public class login extends Activity {

    userSource user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        user = new userSource(getApplicationContext());
        user.open(); //open db user

    }
}

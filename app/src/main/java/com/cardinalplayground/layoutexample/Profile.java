package com.cardinalplayground.layoutexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    TextView profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //hook
        profile = findViewById(R.id.txtProfile);

        Intent intent = getIntent(); //for fetching the intent passed from previous activity
        String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", 0); //key and default value 0
        profile.setText(profile.getText() + " : " + username + " : " + age );

    }
}
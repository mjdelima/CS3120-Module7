package com.cardinalplayground.layoutexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnClear, btnIntent;
    EditText inpUsername, inpPassword, inpWebsite, inpPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook
        btnLogin = findViewById(R.id.btnLogin);
        btnClear = findViewById(R.id.btnClear);
        btnIntent = findViewById(R.id.btnIntent);
        inpUsername = findViewById(R.id.inpUsername);
        inpPassword = findViewById(R.id.inpPassword);
        inpWebsite = findViewById(R.id.inpWebsite);
        inpPhone = findViewById(R.id.inpPhone);


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inpUsername.setText("");
                inpPassword.setText("");
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username, password = "";

                username = inpUsername.getText().toString();
                password = inpPassword.getText().toString();

                if(username.equals("") || password.equals("")){
                    Toast.makeText(MainActivity.this, "Please input your username" +
                            " and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, Profile.class);
                intent.putExtra("username", username);
                intent.putExtra("age", 25); //sample Integer Value
                startActivity(intent);
                finish();


            }
        });

        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String website = inpWebsite.getText().toString();
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + website)));

                String phone = inpPhone.getText().toString();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + phone)));




            }
        });

    }
}
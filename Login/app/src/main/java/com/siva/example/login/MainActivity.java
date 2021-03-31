package com.siva.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText r,p;
    Button l,re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.lg);
        r = findViewById(R.id.rn);
        p = findViewById(R.id.pwd);
        l = findViewById(R.id.login);
        re = findViewById(R.id.register);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInsideActivity();

            }
        });
    }
        public void openInsideActivity()
    {
        Intent i1 = new Intent(MainActivity.this, loginpage.class);
        startActivity(i1);


        }


    }


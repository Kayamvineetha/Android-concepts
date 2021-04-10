package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MyDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBase= Room.databaseBuilder(this,
                MyDataBase.class,"MyDataBase")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

    }

    public void insertdata(View view) {
        //Intent i=new Intent(this,InsertActivity.class);
        Intent i=new Intent(this,InsertActivity.class);
        startActivity(i);
    }
}

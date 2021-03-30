package com.example.activitylifecycles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=findViewById(R.id.text);
        textview.append("onCreate() \n");
        Log.i("MainActivity","onCreate()");
        Toast.makeText(this,"App is Created",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        textview.append("onStart() \n");
        Log.i("MainActivity","onStart()");
        Toast.makeText(this,"App is Started",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        textview.append("onResume() \n");
        Log.i("MainActivity","onResume()");
        Toast.makeText(this,"App is Resumed",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        textview.append("onPause() \n");
        Log.i("MainActivity","onPause()");
        Toast.makeText(this,"App is Paused",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        textview.append("onStop() \n");
        Log.i("MainActivity","onStop()");
        Toast.makeText(this,"App is Stoped",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        textview.append("onRestart() \n");
        Log.i("MainActivity","onRestart()");
        Toast.makeText(this,"App is Restarted",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        textview.append("onDestroy() \n");
        Log.i("MainActivity","onDestroy()");
        Toast.makeText(this,"App is Destroyed",Toast.LENGTH_SHORT).show();
    }
}
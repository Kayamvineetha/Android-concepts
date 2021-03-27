package com.example.registrationpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.registrationpage.databinding.ActivityDetailsBinding;

public class DetailsActivity<AppCompatActivity> extends AppCompatActivity {
    ActivityDetailsBinding detailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        detailsBinding.tvDetails.setVisibility(View.VISIBLE);
        Intent i=getIntent();
        String n=i.getStringExtra("myname");
        String e=i.getStringExtra("myemail");
        String p=i.getStringExtra("mypassword");
        String m=i.getStringExtra("mynumber");
        String a=i.getStringExtra("myaddress");
        String g=i.getStringExtra("mygender");
        detailsBinding.tvDetails.append("name"+n+"\n"+
                "Password:"+p+"\n"+
                "email:"+e+"\n"+
                "number:"+m+"\n"+
                "address:"+a+"\n"+
                "gender:"+g+"\n");
    }
}
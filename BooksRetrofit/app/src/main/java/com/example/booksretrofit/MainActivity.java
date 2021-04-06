package com.example.booksretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    TextView title,author,desc;


    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=findViewById(R.id.tv_title);
        author=findViewById(R.id.tv_author);
        desc=findViewById(R.id.tv_description);
        /*RetrofitInstance.getRetrofit().create(EndpointInterface.class);*/
        BookInterface bi= Retrofitbook.getRetrofit2().create(BookInterface.class);
        Call<String> c=bi.getData();
        c.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("ding",response.body());
                Toast.makeText(MainActivity.this,""+response.body(),Toast.LENGTH_SHORT).show();
                try {
                    JSONArray rootArray=new JSONArray(response.body());
                    JSONObject rootobj=rootArray.getJSONObject(1);
                    JSONObject rootobj1=rootArray.getJSONObject(1);//obj,array,obj,obj
                    String res_title=rootobj.getString("title");
                    title.setText("Title:"+res_title);
                    String res_author=rootobj.getString("authors");
                    title.setText("Author:"+res_author);
                    String res_descpr=rootobj.getString("description");
                    title.setText("Description:"+res_descpr);



                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed to load",Toast.LENGTH_SHORT).show();

            }
        });

    }
}

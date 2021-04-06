package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView date,country,confirmed,active,recovered,death;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog=new ProgressDialog(this);
        dialog.setTitle("DataFetching....");
        dialog.setMessage("Please wait....");
        dialog.show();

        date=findViewById(R.id.tv_date);
        country=findViewById(R.id.tv_country);
        confirmed=findViewById(R.id.tv_confirmed);
        active=findViewById(R.id.tv_active);
        recovered=findViewById(R.id.tv_recovered);
        death=findViewById(R.id.tv_deaths);
        EndpointInterface ei=RetrofitInstance.getRetrofit().create(EndpointInterface.class);
        Call<String> c=ei.getData();
        c.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                dialog.cancel();
                //Log.i("ding",response.body());
               // Toast.makeText(MainActivity.this,""+response.body(),Toast.LENGTH_SHORT).show();

                try {
                    JSONArray rootArray=new JSONArray(response.body());
                    JSONObject rootobj=rootArray.getJSONObject(rootArray.length()-1);
                    String res_country=rootobj.getString("Country");
                    String res_date=rootobj.getString("Date");
                    String res_activecases=rootobj.getString("Active");
                    String res_recovercases=rootobj.getString("Recovered");
                    String res_confirmed=rootobj.getString("Confirmed");
                    String res_deaths=rootobj.getString("Deaths");
                    country.setText("Country:"+res_country);
                    date.setText("Date:"+properDateFormat(res_date));
                    active.setText("Active:"+res_activecases);
                    recovered.setText("Recovered:"+res_recovercases);
                    confirmed.setText("Confirmed:"+res_confirmed);
                    death.setText("Deaths:"+res_deaths);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                }



            private String properDateFormat(String res_date){
                String inputPattern="yy-mm-dd";
                String outputPattern="dd-mm-yy";
                SimpleDateFormat inputDate=new SimpleDateFormat(inputPattern);
                SimpleDateFormat outputDate=new SimpleDateFormat(outputPattern);
                Date d=null;
                String str=null;
                try {
                    d=inputDate.parse(res_date);
                    str=outputDate.format(d);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return  str;

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed to load",Toast.LENGTH_SHORT).show();

            }
        });


    }
}

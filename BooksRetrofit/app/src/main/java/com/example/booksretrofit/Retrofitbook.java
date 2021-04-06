package com.example.booksretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Retrofitbook {
    static Retrofit retrofit;
    public  static final String URL="https://www.googleapis.com/";
    public static  Retrofit getRetrofit2(){
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

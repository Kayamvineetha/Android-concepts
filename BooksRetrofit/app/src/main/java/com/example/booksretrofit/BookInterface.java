package com.example.booksretrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BookInterface {


    @GET("books/v1/volumes?q=twostates")
    Call<String> getData();

}

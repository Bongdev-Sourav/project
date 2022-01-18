package com.example.project;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

   public   static  String BASE_URL="https://jsonplaceholder.typicode.com/";
    public  static Retrofit retrofit=null;

    public  static  ApiInterface getRetrofitClient(){

        Gson gson=new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }


    return  retrofit.create(ApiInterface.class);
    }



}

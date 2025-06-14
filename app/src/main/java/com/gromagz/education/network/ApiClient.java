package com.gromagz.education.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit=null;
//    public  static final String BASEURL="https://dev.smartcookie.in/";
     public static final String BASEURL = "http://192.168.56.1/Gromagz/internship_portal/";

    public  static Retrofit getRetrofit() {
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }
        return retrofit;
    }

}

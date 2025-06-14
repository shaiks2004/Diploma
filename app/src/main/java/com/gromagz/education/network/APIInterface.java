package com.gromagz.education.network;

import com.gromagz.education.Models.internship_model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("get_internship.php")
    Call<List<internship_model>>get_internship();
//    @FormUrlEncoded
//    @POST("add_internship.php")
//    Call<ResponseBody>add_internship( @Field("title") String title,
//                                      @Field("company") String company,
//                                      @Field("lastDate") String lastDate,
//                                      @Field("eligibility") String eligibility,
//                                      @Field("amount") String amount
//    );


}

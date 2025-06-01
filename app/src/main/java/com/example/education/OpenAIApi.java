package com.example.education;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface OpenAIApi {

    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer sk-bpm-RBLetiLW_mAw6wtguSc-vVjZcSbjmyApl0FXpLT3BlbkFJlUOJ83mjAsAZlsRC6cXmDw19kE8Wlqq-drNM5alasA"
    })
    @POST("v1/chat/completions")
    Call<OpenAIResponse> getResponse(@Body OpenAIRequest request);
}

package com.novel.crackerrank_prototype.service;

import com.novel.crackerrank_prototype.entity.SubmissionCode;
import com.novel.crackerrank_prototype.entity.Token;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DewaInterface{
    @GET("submissions/{token}")
    Call<SubmissionCode> getSubmission(@Path("token") String token);

    @POST("submissions")
    Call<Token> postSubmission(@Query("base64_encoded") String base64,
                               @Query("fields") String fields,
                               @Body RequestBody jsonCode);
}

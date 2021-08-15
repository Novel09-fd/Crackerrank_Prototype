package com.novel.crackerrank_prototype.service;

import com.novel.crackerrank_prototype.entity.Soal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SoalInterface {
    @GET("ujian/")
    Call<ArrayList<Soal>> getAll();

    @GET("ujian/solved")
    Call<ArrayList<Soal>> getSolvedSoal();

    @POST("ujian/solved")
    Call<String> postSolvedSoal(Soal soal);
}

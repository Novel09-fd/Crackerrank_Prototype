package com.novel.crackerrank_prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.novel.crackerrank_prototype.adapter.AdapterSoal;
import com.novel.crackerrank_prototype.entity.Soal;
import com.novel.crackerrank_prototype.service.ApiClient;
import com.novel.crackerrank_prototype.service.SoalInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    AdapterSoal adapterSoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_soal);
        SoalInterface soalInterface = ApiClient.getRetrofitSoal().create(SoalInterface.class);
        Call<ArrayList<Soal>> call = soalInterface.getAll();

        call.enqueue(new Callback<ArrayList<Soal>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Soal>> call, @NonNull Response<ArrayList<Soal>> response) {
                adapterSoal = new AdapterSoal(MainActivity.this, response.body());

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL, false);

                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapterSoal);
            }

            @Override
            public void onFailure(Call<ArrayList<Soal>> call, Throwable t) {

            }
        });
    }
}
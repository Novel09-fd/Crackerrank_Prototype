package com.novel.crackerrank_prototype.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.novel.crackerrank_prototype.DetailSoal;
import com.novel.crackerrank_prototype.R;
import com.novel.crackerrank_prototype.entity.Soal;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdapterSoal extends RecyclerView.Adapter<AdapterSoal.MyViewHolder> {

    private final ArrayList<Soal> list;
    private final Context context;

    public AdapterSoal( Context context,ArrayList<Soal> list) {
        this.list = list;
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.item_soal,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_judul.setText(list.get(position).getNamaSoal());
        holder.tv_level.setText(list.get(position).getLevelSoal());
        holder.tv_kategori.setText(list.get(position).getKategoriSoal());

        if (list.get(position).isSolved()) {
            holder.btn_start.setEnabled(false);
        } else {
            holder.btn_start.setOnClickListener(v -> {
                Intent bukaSoal = new Intent(context, DetailSoal.class);
                bukaSoal.putExtra("soal", list.get(position));
                context.startActivity(bukaSoal);
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_judul , tv_level , tv_kategori ;
        Button btn_start ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_judul = itemView.findViewById(R.id.tv_judul);
            tv_level = itemView.findViewById(R.id.tv_level);
            tv_kategori = itemView.findViewById(R.id.tv_kategori);
            btn_start = itemView.findViewById(R.id.btn_start);
        }
    }
}

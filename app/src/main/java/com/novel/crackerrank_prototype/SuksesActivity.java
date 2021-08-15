package com.novel.crackerrank_prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SuksesActivity extends AppCompatActivity {

    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sukses);

        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(v -> {
            Intent intent = new Intent(SuksesActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
package com.novel.crackerrank_prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Base64;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.novel.crackerrank_prototype.codeview.CodeView;
import com.novel.crackerrank_prototype.entity.Code;
import com.novel.crackerrank_prototype.entity.Soal;
import com.novel.crackerrank_prototype.entity.SubmissionCode;
import com.novel.crackerrank_prototype.entity.Token;
import com.novel.crackerrank_prototype.service.ApiClient;
import com.novel.crackerrank_prototype.service.DewaInterface;
import com.novel.crackerrank_prototype.service.SoalInterface;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSoal extends AppCompatActivity {
    CodeView edt_Code;
    TextView tv_IsiSoal, tv_JudulSoalActivity;
    Soal soal;
    Code code;
    Button btn_submit;
    String x = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_soal);

        edt_Code = findViewById(R.id.edit_codeView);
        btn_submit = findViewById(R.id.btn_submit);
        tv_JudulSoalActivity = findViewById(R.id.txt_judul_atas);

        soal = getIntent().getParcelableExtra("soal");


        byte[] data = Base64.decode(soal.getTemplateJawaban(), Base64.DEFAULT);
        String templateJawaban = new String(data, StandardCharsets.UTF_8);

        tv_JudulSoalActivity.setText(soal.getNamaSoal());
        tv_IsiSoal.setText(Html.fromHtml(soal.getIsiSoal()));
        edt_Code.setText(templateJawaban);


        btn_submit.setOnClickListener(v -> {
            // Encode code
            String codeResult = Objects.requireNonNull(edt_Code.getText()).toString();
            byte[] codeData = codeResult.getBytes(StandardCharsets.UTF_8);
            String base64 = Base64.encodeToString(codeData, Base64.DEFAULT);

            code = new Code(62,base64,"");

            Gson gson = new Gson();
            String json = gson.toJson(code);

            RequestBody jsonCode = RequestBody.create(MediaType.parse("text/plain"), json);
            DewaInterface dewaInterface = ApiClient.getRetrofit().create(DewaInterface.class);
            Call<Token> call = dewaInterface.postSubmission("true", "*", jsonCode);

            call.enqueue(new Callback<Token>() {
                @Override
                public void onResponse(@NonNull Call<Token> call, @NonNull Response<Token> response) {
                    assert response.body() != null;
                    Toast.makeText(DetailSoal.this, response.body().getToken(), Toast.LENGTH_SHORT).show();

                    checkToken(response.body().getToken());
                }

                @Override
                public void onFailure(@NonNull Call<Token> call, @NonNull Throwable t) {
                    Toast.makeText(DetailSoal.this, "Submission Error", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    private void checkToken(String token) {
        DewaInterface dewaInterface = ApiClient.getRetrofit().create(DewaInterface.class);
        Call<SubmissionCode> call = dewaInterface.getSubmission(token);

        call.enqueue(new Callback<SubmissionCode>() {
            @Override
            public void onResponse(@NonNull Call<SubmissionCode> call, @NonNull Response<SubmissionCode> response) {
                assert response.body() != null;

                if (response.body().getStatus().getId() == 3) {

                    if (response.body().getStdout().equals(soal.getJawabanSoal())) {
                        soal.setSubmissionToken(token);
                        soal.setSolved(true);
                        Toast.makeText(DetailSoal.this, solved(soal), Toast.LENGTH_SHORT).show();
                        Intent solvedIntent = new Intent(DetailSoal.this, SuksesActivity.class);
                        startActivity(solvedIntent);
                        finish();
                    }

                    else {
                        AlertDialog.Builder dialog = new AlertDialog.Builder(DetailSoal.this);
                        dialog.setTitle("Output salah");
                        dialog.setMessage("Output Anda adalah\n" +
                                response.body().getStdout() + "\n" +
                                "Output yang benar adalah\n" +
                                soal.getJawabanSoal());
                        dialog.setPositiveButton("TryAgain",
                                (dialogInterface, i) ->
                                        Toast.makeText(getApplicationContext(),
                                                "TryAgain",
                                                Toast.LENGTH_LONG).show());
                        AlertDialog alertDialog = dialog.create();
                        alertDialog.show();
                    }
                }

                else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(DetailSoal.this);
                    dialog.setTitle(response.body().getStatus().getDescription());
                    dialog.setMessage(response.body().getCompileOutput());
                    dialog.setPositiveButton("TryAgain",
                            (dialogInterface, i) ->
                                    Toast.makeText(getApplicationContext(),
                                            "TryAgain",
                                            Toast.LENGTH_LONG).show());
                    AlertDialog alertDialog = dialog.create();
                    alertDialog.show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<SubmissionCode> call, @NonNull Throwable t) {
                Toast.makeText(DetailSoal.this, "Erorr Fetching", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String solved(Soal soal) {
        SoalInterface soalInterface = ApiClient.getRetrofitSoal().create(SoalInterface.class);
        Call<String> call = soalInterface.postSolvedSoal(soal);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                x = response.body();
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                x = "Erorr when solve";
            }
        });
        return x;


    }
}
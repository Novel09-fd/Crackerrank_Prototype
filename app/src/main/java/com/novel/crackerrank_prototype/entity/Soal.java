package com.novel.crackerrank_prototype.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Soal implements Parcelable {
    @SerializedName("id")
    private long id;
    @SerializedName("namaSoal")
    private String namaSoal;
    @SerializedName("levelSoal")
    private String levelSoal;
    @SerializedName("kategoriSoal")
    private String kategoriSoal;
    @SerializedName("isiSoal")
    private String isiSoal;
    @SerializedName("templateJawaban")
    private String templateJawaban;
    @SerializedName("jawabanSoal")
    private String jawabanSoal;
    @SerializedName("submissionToken")
    private String submissionToken;
    @SerializedName("solved")
    private boolean solved;

    public Soal(long id, String namaSoal, String levelSoal, String kategoriSoal, String isiSoal, String templateJawaban, String jawabanSoal, String submissionToken, boolean solved) {
        this.id = id;
        this.namaSoal = namaSoal;
        this.levelSoal = levelSoal;
        this.kategoriSoal = kategoriSoal;
        this.isiSoal = isiSoal;
        this.templateJawaban = templateJawaban;
        this.jawabanSoal = jawabanSoal;
        this.submissionToken = submissionToken;
        this.solved = solved;
    }

    public Soal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaSoal() {
        return namaSoal;
    }

    public void setNamaSoal(String namaSoal) {
        this.namaSoal = namaSoal;
    }

    public String getLevelSoal() {
        return levelSoal;
    }

    public void setLevelSoal(String levelSoal) {
        this.levelSoal = levelSoal;
    }

    public String getKategoriSoal() {
        return kategoriSoal;
    }

    public void setKategoriSoal(String kategoriSoal) {
        this.kategoriSoal = kategoriSoal;
    }

    public String getIsiSoal() {
        return isiSoal;
    }

    public void setIsiSoal(String isiSoal) {
        this.isiSoal = isiSoal;
    }

    public String getTemplateJawaban() {
        return templateJawaban;
    }

    public void setTemplateJawaban(String templateJawaban) {
        this.templateJawaban = templateJawaban;
    }

    public String getJawabanSoal() {
        return jawabanSoal;
    }

    public void setJawabanSoal(String jawabanSoal) {
        this.jawabanSoal = jawabanSoal;
    }

    public String getSubmissionToken() {
        return submissionToken;
    }

    public void setSubmissionToken(String submissionToken) {
        this.submissionToken = submissionToken;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.namaSoal);
        dest.writeString(this.levelSoal);
        dest.writeString(this.kategoriSoal);
        dest.writeString(this.isiSoal);
        dest.writeString(this.templateJawaban);
        dest.writeString(this.jawabanSoal);
        dest.writeString(this.submissionToken);
        dest.writeByte(this.solved ? (byte) 1 : (byte) 0);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readLong();
        this.namaSoal = source.readString();
        this.levelSoal = source.readString();
        this.kategoriSoal = source.readString();
        this.isiSoal = source.readString();
        this.templateJawaban = source.readString();
        this.jawabanSoal = source.readString();
        this.submissionToken = source.readString();
        this.solved = source.readByte() != 0;
    }

    public Soal(Parcel in) {
        this.id = in.readLong();
        this.namaSoal = in.readString();
        this.levelSoal = in.readString();
        this.kategoriSoal = in.readString();
        this.isiSoal = in.readString();
        this.templateJawaban = in.readString();
        this.jawabanSoal = in.readString();
        this.submissionToken = in.readString();
        this.solved = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Soal> CREATOR = new Parcelable.Creator<Soal>() {
        @Override
        public Soal createFromParcel(Parcel source) {

            return new Soal(source);
        }

        @Override
        public Soal[] newArray(int size) {

            return new Soal[size];
        }
    };
}


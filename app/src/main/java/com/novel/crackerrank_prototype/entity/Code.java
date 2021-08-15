package com.novel.crackerrank_prototype.entity;


import com.google.gson.annotations.SerializedName;

public class Code {
    @SerializedName("language_id")
    private long language_id;
    @SerializedName("source_code")
    private String source_code;
    @SerializedName("stdin")
    private String stdin;

    public Code(long language_id, String source_code, String stdin) {
        this.language_id = language_id;
        this.source_code = source_code;
        this.stdin = stdin;
    }

    public Code() {
    }

    public long getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(long language_id) {
        this.language_id = language_id;
    }

    public String getSource_code() {
        return source_code;
    }

    public void setSource_code(String source_code) {
        this.source_code = source_code;
    }

    public String getStdin() {
        return stdin;
    }

    public void setStdin(String stdin) {
        this.stdin = stdin;
    }
}


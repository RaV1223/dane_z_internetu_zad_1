package com.example.dane_z_internetu_zad_1;

import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("date")
    private String date;

    @SerializedName("author")
    private String author;

    @SerializedName("content")
    private String content;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}

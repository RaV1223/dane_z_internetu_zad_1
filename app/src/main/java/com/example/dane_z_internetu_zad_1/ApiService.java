package com.example.dane_z_internetu_zad_1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("5TP/")
    Call<List<Message>> getMessages();
}

package com.example.dane_z_internetu_zad_1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchMessages();
    }

    private void fetchMessages() {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        Call<List<Message>> call = apiService.getMessages();

        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Message> messages = response.body();
                    Log.d(TAG, "Dane pobrane: " + messages.size() + " wiadomości.");
                    messageAdapter = new MessageAdapter(messages);
                    recyclerView.setAdapter(messageAdapter);
                } else {
                    Log.e(TAG, "Błąd odpowiedzi serwera: " + response.code());
                }
            }


            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Log.e(TAG, "Błąd sieci: " + t.getMessage());
            }
        });
    }
}

package com.example.getnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Article> recyclerModelsDataArrayList = new ArrayList<>();
    private Adapter adapter;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        progressBar = findViewById(R.id.pb);
        recyclerModelsDataArrayList = new ArrayList<>();

        adapter = new Adapter(recyclerModelsDataArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        fetchdata();
    }

    private void fetchdata() {

        RestClient.getInstance().getNewsApiService()
                .fetchEverything("eb131b16f3804d84b3dbf4073d938458", "2021-05-08", "Apple").enqueue(new MyCallBack<RecyclerModel>() {
            @Override
            public void success(RecyclerModel data) {
                // on successful we are hiding our progressbar.
                progressBar.setVisibility(View.GONE);
                recyclerModelsDataArrayList.addAll(data.articles);
                adapter.notifyDataSetChanged();
            }
        });
    }
}

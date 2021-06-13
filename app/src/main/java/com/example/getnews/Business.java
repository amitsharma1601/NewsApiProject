package com.example.getnews;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Business extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int pos = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Business(int pos){
        this.pos = pos;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private RecyclerView recycler2;
    private ArrayList<Article> recyclerModelsDataArrayList = new ArrayList<>();
    private Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //  return inflater.inflate(R.layout.fragment_business, container, false);
        View view = inflater.inflate(R.layout.fragment_business, container, false);
        recycler2 = view.findViewById(R.id.recycler2);


        recyclerModelsDataArrayList = new ArrayList<>();

        adapter = new Adapter(getContext(), recyclerModelsDataArrayList);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler2.setLayoutManager(llm);
        recycler2.setAdapter(adapter);

        fetchdata();
        return view;

    }

    private void fetchdata() {
        switch (pos){
            case 0:
                fetchCNN();
                break;

            case 1:
                fetchHealth();
                break;

            case 2:
                fetchSports();
                break;
            case 3:
                fetchBusiness();
                break;
            case 4:
                fetchEntertainment();
                break;
        }


    }


    private void fetchBusiness(){

        RestClient.getInstance().getNewsApiService()
                .fetchbusiness("NewsAPI", "everything").enqueue(new MyCallBack<RecyclerModel>() {
            @Override
            public void success(RecyclerModel data) {
                // on successful we are hiding our progressbar.

                recyclerModelsDataArrayList.addAll(data.articles);
                adapter.notifyDataSetChanged();
            }
        });

    }
    private void fetchCNN(){

        RestClient.getInstance().getNewsApiService()
                .fetchEverything("NewsAPI", "everything").enqueue(new MyCallBack<RecyclerModel>() {
            @Override
            public void success(RecyclerModel data) {
                // on successful we are hiding our progressbar.

                recyclerModelsDataArrayList.addAll(data.articles);
                adapter.notifyDataSetChanged();
            }
        });

    }
    private void fetchHealth(){
        RestClient.getInstance().getNewsApiService()
                .fetchEverythingBBC("NewsAPI", "everything").enqueue(new MyCallBack<RecyclerModel>() {
            @Override
            public void success(RecyclerModel data) {
                // on successful we are hiding our progressbar.

                recyclerModelsDataArrayList.addAll(data.articles);
                adapter.notifyDataSetChanged();
            }
        });
    }
    private void fetchSports(){

        RestClient.getInstance().getNewsApiService()
                .fetchsports("NewsAPI", "everything").enqueue(new MyCallBack<RecyclerModel>() {
            @Override
            public void success(RecyclerModel data) {
                // on successful we are hiding our progressbar.

                recyclerModelsDataArrayList.addAll(data.articles);
                adapter.notifyDataSetChanged();
            }
        });

    }
    private void fetchEntertainment(){

        RestClient.getInstance().getNewsApiService()
                .fetchentertainment("NewsAPI", "everything").enqueue(new MyCallBack<RecyclerModel>() {
            @Override
            public void success(RecyclerModel data) {
                // on successful we are hiding our progressbar.

                recyclerModelsDataArrayList.addAll(data.articles);
                adapter.notifyDataSetChanged();
            }
        });

    }
}
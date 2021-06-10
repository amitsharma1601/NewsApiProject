package com.example.getnews;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SportsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SportsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SportsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SportsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SportsFragment newInstance(String param1, String param2) {
        SportsFragment fragment = new SportsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
        private RecyclerView recycler1;
        private ArrayList<Article> recyclerModelsDataArrayList = new ArrayList<>();
        private Adapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_sports, container, false);
        View view= inflater.inflate(R.layout.fragment_sports, container, false);
        recycler1= view.findViewById(R.id.recycler_sports);


        recyclerModelsDataArrayList = new ArrayList<>();

        adapter = new Adapter(getContext(),recyclerModelsDataArrayList);
        LinearLayoutManager llm=new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler1.setLayoutManager(llm);
        recycler1.setAdapter(adapter);

        fetchdata();
        return view;
    }
    private void fetchdata() {

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
}

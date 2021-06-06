package com.example.getnews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.RecyclerViewHolder> {
    private ArrayList<Article> recyclerModelsDataArrayList;
    private static final int MAX_BITMAP_SIZE = 100 * 1024 * 1024;



    public Adapter(ArrayList<Article> recyclerModelsDataArrayList) {
        this.recyclerModelsDataArrayList = recyclerModelsDataArrayList;
    }




    @NonNull
    @Override
    public Adapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.RecyclerViewHolder holder, int position) {
        Article modal =  recyclerModelsDataArrayList.get(position);
        holder.t2.setText(modal.author);
        holder.t3.setText(modal.title);
        holder.t4.setText(modal.content);
        try {
            Picasso.get().load(modal.urlToImage).fit().into(holder.id1);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return recyclerModelsDataArrayList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView t1,t2,t3,t4;
        private ImageView id1;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            t1= itemView.findViewById(R.id.t1);
            t2= itemView.findViewById(R.id.t2);
            t3= itemView.findViewById(R.id.t3);
            t4= itemView.findViewById(R.id.t4);
            id1= itemView.findViewById(R.id.id1);
        }
    }
}

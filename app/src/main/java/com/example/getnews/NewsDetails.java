package com.example.getnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsDetails extends AppCompatActivity {
    String t2,t3,t4,thumbnail;
    public ArrayList<Article> articles;

    TextView Author,Content,Title;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        Author=findViewById(R.id.Author);
        Content=findViewById(R.id.Content);
        Title=findViewById(R.id.Title);
        image=findViewById(R.id.image);

        if(getIntent().getStringExtra("author")=="null"){
            t2="**";
        }else {
            t2 = getIntent().getStringExtra("author");
        }

        t3 = getIntent().getStringExtra("title");
        t4 = getIntent().getStringExtra("content");
        if(getIntent().getStringExtra("thumbnail")=="null"){
           thumbnail="**";
        }else {
            thumbnail =getIntent().getStringExtra("thumbnail");
        }

        Log.i("image",""+thumbnail);

        Author.setText(t2);
        Title.setText(t3);
        Content.setText(t4);
        Picasso.get().load(thumbnail).into(image);


    }
}
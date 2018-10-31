package com.ngalocompany.responsi.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ngalocompany.responsi.R;

public class TayangSekarang2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tayang_sekarang2);

        getSupportActionBar().hide();

        String vote_count = getIntent().getExtras().getString("tayangsekarang_vote_count");
        String id = getIntent().getExtras().getString("tayangsekarang_id");
        String title = getIntent().getExtras().getString("tayangsekarang_title");
        String vote_average = getIntent().getExtras().getString("tayangsekarang_vote_average");
        String overview = getIntent().getExtras().getString("tayangsekarang_overview");
        String postr_path = getIntent().getExtras().getString("tayangsekarang_poster_path");


        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_vote_count = findViewById(R.id.aa_kedua);
        TextView tv_id = findViewById(R.id.aa_keempat);
        TextView tv_title = findViewById(R.id.aa_pertama);
        TextView tv_vote_average = findViewById(R.id.aa_ketiga);
        TextView tv_overview = findViewById(R.id.aa_kelima);
        ImageView img = findViewById(R.id.aa_gambar);

        tv_title.setText(title);
        tv_vote_count.setText(vote_average);
        tv_vote_average.setText(vote_average);
        tv_id.setText(id);
        tv_overview.setText(overview);

        collapsingToolbarLayout.setTitle(title);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading).error(R.drawable.loading);

        Glide.with(this).load(postr_path).apply(requestOptions).into(img);


    }
}

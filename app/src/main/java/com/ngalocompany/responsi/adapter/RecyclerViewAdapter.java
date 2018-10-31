package com.ngalocompany.responsi.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ngalocompany.responsi.activities.TayangSekarang2Activity;
import com.ngalocompany.responsi.model.TayangSekarang;
import com.ngalocompany.responsi.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<TayangSekarang> mData;
    RequestOptions option;


    public RecyclerViewAdapter(Context mContext, List<TayangSekarang> mData) {
        this.mContext = mContext;
        this.mData = mData;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading).error(R.drawable.loading);
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view =inflater.inflate(R.layout.tayang_sekarang,parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext,TayangSekarang2Activity.class);
                i.putExtra("tayangsekarang_title",mData.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("tayangsekarang_vote_count",mData.get(viewHolder.getAdapterPosition()).getVote_count());
                i.putExtra("tayangsekarang_vote_average",mData.get(viewHolder.getAdapterPosition()).getVote_average());
                i.putExtra("tayangsekarang_id",mData.get(viewHolder.getAdapterPosition()).getId());
                i.putExtra("tayangsekarang_overview",mData.get(viewHolder.getAdapterPosition()).getOverview());
                i.putExtra("tayangsekarang_poster_path",mData.get(viewHolder.getAdapterPosition()).getPoster_path());

                mContext.startActivity(i);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {

        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tv_vote_count.setText(mData.get(position).getVote_count());
        holder.tv_average.setText(mData.get(position).getVote_average());
        holder.tv_id.setText(mData.get(position).getId());
        holder.tv_overview.setText(mData.get(position).getOverview());

        Glide.with(mContext).load(mData.get(position).getPoster_path()).apply(option).into(holder.poster_path);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title;
        TextView tv_vote_count;
        TextView tv_average;
        TextView tv_id;
        TextView tv_overview;
        ImageView poster_path;
        LinearLayout view_container;


        public MyViewHolder( View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_title = itemView.findViewById(R.id.pertama);
            tv_vote_count = itemView.findViewById(R.id.kedua);
            tv_average = itemView.findViewById(R.id.ketiga);
            tv_id = itemView.findViewById(R.id.keempat);
            tv_overview = itemView.findViewById(R.id.kelima);
            poster_path = itemView.findViewById(R.id.gambar);
        }
    }

}

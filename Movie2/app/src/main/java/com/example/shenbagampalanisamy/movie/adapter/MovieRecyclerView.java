package com.example.shenbagampalanisamy.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shenbagampalanisamy.movie.R;

import com.example.shenbagampalanisamy.movie.activites.MovieDetailActivity;
import com.example.shenbagampalanisamy.movie.models.Movie;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.List;
public class MovieRecyclerView extends RecyclerView.Adapter<MovieRecyclerView.ViewHolder> {

    Context context;
    List<Movie> movies;
    public MovieRecyclerView(Context context, List<Movie> movies) {
        this.context=context;
        this.movies=movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie=movies.get(position);
        holder.tvTitle.setText(movie.getTitle());
        holder.tvOverview.setText(movie.getOverview());
        Picasso.with(getContext()).load(movie.getPosterPath()).resize(300,300).into(holder.ivMovieImage);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public Context getContext() {
        return context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.ivMovieImage)
        ImageView ivMovieImage;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvOverview)
        TextView tvOverview;
        @BindView(R.id.cvMovie)
        CardView cvmovie;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Movie movie=movies.get(getAdapterPosition());
            Intent intent=new Intent(getContext(), MovieDetailActivity.class);
           intent.putExtra("MOVIE", movie);
           getContext().startActivity(intent);
        }
    }
}

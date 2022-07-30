package com.example.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.application.Film;
import com.example.application.FilmDelegate;
import com.example.application.R;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    private Context context;
    private FilmDelegate delegate;

    public FilmAdapter(ArrayList<Film> listFilm, Context context, FilmDelegate delegate) {

        this.listFilm = listFilm;
        this.context=context;
        this.delegate=delegate;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {

            super(view);

            copertina = view.findViewById(R.id.imageViewTrailer);
            leftArrow = view.findViewById(R.id.leftArrow);
            rightArrow = view.findViewById(R.id.rightArrow);
            dettagli = view.findViewById(R.id.buttonDetails);
            watchparty = view.findViewById(R.id.lobbyButton);
        }

        ImageView copertina;
        ImageView leftArrow;
        ImageView rightArrow;
        Button dettagli;
        Button watchparty;
    }

    @NonNull
    @Override
    public FilmAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_film, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.ViewHolder holder, int position) {

        Film film = listFilm.get(position);

        Glide.with(context).load(film.getImage()).into(holder.copertina);

        holder.leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onLeftClick(position);
            }
        });

        holder.rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onRightClick(position);
            }
        });

        holder.dettagli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.seeDettagli(film.getId());
            }
        });

        holder.watchparty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listFilm.size();
    }

    private ArrayList<Film> listFilm;
}

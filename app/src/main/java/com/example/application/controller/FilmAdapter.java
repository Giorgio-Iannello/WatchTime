package com.example.application.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.application.Film;
import com.example.application.FilmDelegate;
import com.example.application.MainActivity;
import com.example.application.R;
import com.example.application.PerTeDelegate;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    public FilmAdapter(ArrayList<Film> listFilm, Context context, FilmDelegate delegate, int tipo) {

        this.listFilm = listFilm;
        this.context = context;
        this.delegate = delegate;
        this.tipo = 1;
    }

    public FilmAdapter(ArrayList<Film> listFilm1, Context context, PerTeDelegate delegate, int tipo) {

        this.listFilm = listFilm1;
        this.context=context;
        this.delegatePerTe = delegate;
        this.tipo = 0;
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

        Glide.with(context).load(listFilm.get(position).getImage()).into(holder.copertina);

        holder.leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tipo == 1) {
                    delegate.onLeftClick(position);
                }else {
                    delegatePerTe.onLeftClickPerTe(position);
                }
            }
        });

        holder.rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tipo == 1) {
                delegate.onRightClick(position);
                }else {
                    delegatePerTe.onRightClickPerTe(position);
                }
            }
        });

        holder.dettagli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tipo==1)
                {
                    delegate.seeDettagli(position);
                }
                else
                {
                    delegatePerTe.dettagliPerTe(position);
                }
            }
        });

        holder.watchparty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.hasWatchParty=true;
                if (listFilm.get(position).getTitolo().equals("Spider-Man") && tipo == 1) {
                    delegate.watchParty();
                } else if (listFilm.get(position).getTitolo().equals("Spider-Man") && tipo == 0) {
                    delegatePerTe.watchpartyPerTe();
                }else {
                    Toast.makeText(v.getContext(), "Fai parte già di un watchparty: Spider-man", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFilm.size();
    }

    private ArrayList<Film> listFilm;
    private Context context;
    private FilmDelegate delegate;
    private PerTeDelegate delegatePerTe;
    private int tipo;
}

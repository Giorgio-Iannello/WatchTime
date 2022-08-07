package com.example.application.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.Film;
import com.example.application.R;
import com.example.application.ui.bookmark.BookmarkDelegate;

import java.util.ArrayList;

public class FilmSavedAdapter extends RecyclerView.Adapter<FilmSavedAdapter.ViewHolder> {

    public FilmSavedAdapter(ArrayList<Film> listFilm, Context context, BookmarkDelegate delegate) {
        this.listFilm = listFilm;
        this.context = context;
        this.delegate=delegate;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {

            super(view);

            copertina = view.findViewById(R.id.imageViewCopertina);
            salvato = view.findViewById(R.id.imageViewSaved);
            titolo = view.findViewById(R.id.textViewTitolo);
        }

        ImageView copertina;
        ImageView salvato;
        TextView titolo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_film_saved, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            holder.copertina.setImageResource(listFilm.get(position).getImage());
            holder.titolo.setText(listFilm.get(position).getTitolo());

        holder.salvato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.deleteItem(position);
                notifyDataSetChanged();
            }
        });

        holder.copertina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putSerializable("film", listFilm.get(position));

                Navigation.findNavController(v).navigate(R.id.detailsFragment, bundle);
            }
        });
    }


        @Override
        public int getItemCount() {
            return listFilm.size();
        }

        private ArrayList<Film> listFilm;
        private Context context;
        private BookmarkDelegate delegate;
}


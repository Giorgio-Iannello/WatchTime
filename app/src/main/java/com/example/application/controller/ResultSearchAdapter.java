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

import java.util.ArrayList;
import java.util.NavigableMap;


public class ResultSearchAdapter extends RecyclerView.Adapter<ResultSearchAdapter.ViewHolder>
{
    @SuppressLint("NotifyDataSetChanged")
    public void clearVett()
    {
        listFilm.clear();
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void changeVett(ArrayList<Film> listFilm)
    {
        this.listFilm=listFilm;
        notifyDataSetChanged();
    }
    public ResultSearchAdapter (ArrayList<Film> listFilm, Context context,View view)
    {
        this.view=view;
        this.listFilm = listFilm;
        this.context = context;
    }

    @NonNull
    @Override
    public ResultSearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_result_research, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultSearchAdapter.ViewHolder holder, int position) {
        Film f=listFilm.get(position);
        holder.titolo.setText(f.getTitolo());
        holder.foto.setImageResource(f.getImage());
        holder.itemView.setOnClickListener(v -> {
            Bundle bundle=new Bundle();
            bundle.putSerializable("film",f);
            Navigation.findNavController(view).navigate(R.id.detailsFragment,bundle);
        });
    }

    @Override
    public int getItemCount() {
        return listFilm.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView foto;
        TextView titolo;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            foto=itemView.findViewById(R.id.imageViewResult);
            titolo=itemView.findViewById(R.id.textView4);
        }
    }

    private ArrayList<Film> listFilm;
    private Context context;
    private View view;
}

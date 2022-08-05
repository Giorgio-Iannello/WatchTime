package com.example.application.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.application.R;

import java.util.ArrayList;

public class CommentiDetailsAdapter extends RecyclerView.Adapter<CommentiDetailsAdapter.ViewHolder>
{
    private ArrayList<String> vettCommenti;
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView textView;
        public ViewHolder(View view)
        {
            super(view);
            textView=view.findViewById(R.id.textViewCommentoItem);
        }
        public TextView getTextView() {
            return textView;
        }
    }

    public CommentiDetailsAdapter(ArrayList<String> vettCommenti)
    {
        this.vettCommenti = vettCommenti;
    }
    public void changeVett(ArrayList<String> vettCommenti)
    {
        this.vettCommenti = vettCommenti;
        notifyAll();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_commento, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position)
    {
        viewHolder.getTextView().setText(vettCommenti.get(position));
    }

    @Override
    public int getItemCount()
    {
        return vettCommenti.size();
    }
}

package com.example.application.ui.searchbar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.application.Film;
import com.example.application.R;
import com.example.application.ui.home.HomeFragment;
import com.example.application.controller.ResultSearchAdapter;

import java.util.ArrayList;
import java.util.Locale;

public class SearchFragment extends Fragment
{
    private ArrayList<Film> filterFilm(String text)
    {
        ArrayList<Film> newList=new ArrayList<>();
        for(Film f:listFilm)
        {
            if(f.getTitolo().toLowerCase(Locale.ROOT).contains(text))
                newList.add(f);
        }
        return newList;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }
    private ArrayList<Film> listFilm;
    private EditText searchBar;
    private RecyclerView recyclerView;
    private ResultSearchAdapter adapter;
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.list);
        searchBar = view.findViewById(R.id.editTextResearch);
        listFilm=HomeFragment.listFilm;
        adapter = new ResultSearchAdapter(new ArrayList<>(), requireContext(),view);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);

        searchBar.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count)
            {
                if(s.length()>2)
                {
                    ArrayList<Film> filter=filterFilm(s.toString());
                    if(filter.size()>0)
                    {
                        adapter.changeVett(filter);
                    }
                    else
                    {
                        adapter.clearVett();
                    }
                }
                else
                    adapter.clearVett();
            }
        });
    }
}
package com.example.application.ui.bookmark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.application.Film;
import com.example.application.R;
import com.example.application.controller.FilmSavedAdapter;

import java.util.ArrayList;

public class BookmarkFragment extends Fragment implements BookmarkDelegate {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bookmark, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewFilm = view.findViewById(R.id.recyclerViewFilmSaved);

        FilmSavedAdapter adapter = new FilmSavedAdapter(listFilm, getContext(),this);
        GridLayoutManager linearLayoutManager
                = new GridLayoutManager(requireContext(),2);
        recyclerViewFilm.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewFilm.getContext(),
                linearLayoutManager.getOrientation());
        recyclerViewFilm.addItemDecoration(dividerItemDecoration);
        recyclerViewFilm.setAdapter(adapter);

    }

    public static ArrayList<Film> listFilm = new ArrayList<>();
    private RecyclerView recyclerViewFilm;

    @Override
    public void deleteItem(int position)
    {
        listFilm.remove(position);
    }
}
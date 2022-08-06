package com.example.application.ui.home;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.Film;
import com.example.application.FilmDelegate;
import com.example.application.R;
import com.example.application.PerTeDelegate;
import com.example.application.controller.FilmAdapter;
import com.example.application.ui.bookmark.BookmarkFragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements FilmDelegate, PerTeDelegate {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        listFilm = new ArrayList<>();
        listFilm1 = new ArrayList<>();

        Film film = new Film(1, R.drawable.spider_man, "Spider-Man", "Con l'identità di Spider-Man rivelata, Peter chiede aiuto al Dottor Strange. " +
                "Qualcosa va storto e il multiverso diventa la più grande minaccia. Ora lui deve scoprire cosa significa" +
                " veramente essere l’Uomo Ragno.", "2021 - 2h 28min", "ZBPAGbR6AHM");

        Film film2 = new Film(2, R.drawable.the_wolf_of_wall_street, "The Wolf of Wall Street", "New York, anni 80. Eccessi e corruzione segnano la curva " +
                "discendente della brillante carriera di Jordan Belfort, " +
                "un ambizioso broker in grado di guadagnare migliaia di dollari al " +
                "minuto e di spenderne altrettanti in droga e futilità.", "2013 - 3h", "hzG93_Mo-ys");

        Film film3 = new Film(3, R.drawable.interstellar, "Interstellar", "In un futuro non precisato, un drastico cambiamento climatico colpisce duramente l'agricoltura. " +
                "Il granturco è l'unica coltivazione ancora in grado di crescere ed un gruppo di scienziati è intenzionato ad " +
                "attraversare lo spazio per trovare nuovi luoghi adatti a coltivarlo.", "2014 - 2h 49min", "EIVMVIr3q3Y");

        Film film4 = new Film(4, R.drawable.la_fabbrica_di_cioccolato, "La Fabbrica Di Cioccolato", "Cinque biglietti d'oro sono nascosti in altrettante tavolette di cioccolato." +
                " I fortunati bambini che riescono a trovarli possono varcare i cancelli della Fabbrica di Cioccolato del signor Wonka ed entrare " +
                "così in contatto con il suo magico mondo di dolci e bontà. " +
                "Trai tanti bambini che sperano di avere una possibilità di vincere c'è il piccolo Charlie." , "2005 - 1h 55min", "2CA9C3QDkEo");

        listFilm.add(film);
        listFilm.add(film2);
        listFilm.add(film3);
        listFilm.add(film4);

        listFilm1.add(film);
        listFilm1.add(film2);
        listFilm1.add(film3);
        listFilm1.add(film4);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        this.view = view;

        FilmAdapter adapter;
        FilmAdapter adapter1;

        tendenze = view.findViewById(R.id.recyclerViewTendenze);
        perTe = view.findViewById(R.id.recyclerViewPerTe);

        adapter = new FilmAdapter(listFilm, requireContext(), (FilmDelegate) this, 1);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        tendenze.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(tendenze.getContext(),
                layoutManager.getOrientation());
        tendenze.addItemDecoration(dividerItemDecoration);
        tendenze.setAdapter(adapter);

        adapter1 = new FilmAdapter(listFilm1, requireContext(), (PerTeDelegate) this, 0);
        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        perTe.setLayoutManager(layoutManager1);
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(perTe.getContext(),
                layoutManager.getOrientation());
        perTe.addItemDecoration(dividerItemDecoration1);
        perTe.setAdapter(adapter1);
    }

    @Override
    public void onLeftClick(int position)
    {

        int newPos;

        if (position == 0) {
            newPos = listFilm.size() - 1;
        }else {
            newPos = position - 1;
        }

        tendenze.scrollToPosition(newPos);
    }

    @Override
    public void onRightClick(int position)
    {
        int newPos;

        if (position == listFilm.size() - 1) {
            newPos = 0;
        }else {
            newPos = position + 1;
        }

        tendenze.scrollToPosition(newPos);
    }

    @Override
    public void seeDettagli(int position) {

        Bundle bundle=new Bundle();
        bundle.putSerializable("film", listFilm.get(position));

        Navigation.findNavController(view).navigate(R.id.detailsFragment, bundle);
    }

    @SuppressLint("ResourceType")
    @Override
    public void watchParty() {

        Navigation.findNavController(view).navigate(R.id.navigation_watch_party);
    }


    @Override
    public void onLeftClickPerTe(int position) {

        int newPos;

        if (position == 0) {
            newPos = listFilm1.size() - 1;
        }else {
            newPos = position - 1;
        }

        perTe.scrollToPosition(newPos);
    }

    @Override
    public void onRightClickPerTe(int position) {

        int newPos;

        if (position == listFilm1.size() - 1) {
            newPos = 0;
        }else {
            newPos = position + 1;
        }

        perTe.scrollToPosition(newPos);
    }

    @Override
    public void dettagliPerTe(int position)
    {
        Bundle bundle=new Bundle();
        bundle.putSerializable("film", listFilm.get(position));
        Navigation.findNavController(view).navigate(R.id.detailsFragment, bundle);
    }

    @Override
    public void watchpartyPerTe() {

        Navigation.findNavController(view).navigate(R.id.navigation_watch_party);
    }

    private View view;
    private RecyclerView tendenze;
    private RecyclerView perTe;
    public static ArrayList<Film> listFilm;
    public static ArrayList<Film> listFilm1;
}
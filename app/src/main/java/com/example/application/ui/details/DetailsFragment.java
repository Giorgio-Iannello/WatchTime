package com.example.application.ui.details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.application.Film;
import com.example.application.R;
import com.example.application.controller.CommentiDetailsAdapter;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class DetailsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_details, container, false);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            titolo = view.findViewById(R.id.textViewTitle);
            durata = view.findViewById(R.id.textViewDuration);
            copertina = view.findViewById(R.id.imageViewFilm);
            descrizione = view.findViewById(R.id.textViewDescription);
            recyclerView = view.findViewById(R.id.listCommenti);
            inputCommento = view.findViewById(R.id.editTextComment);
            btnInvio = view.findViewById(R.id.buttonSend);
            idVideo = view.findViewById(R.id.trailer);

            Bundle bundle = getArguments();
            if (bundle != null) {
                Film film = (Film) bundle.getSerializable("film");
                titolo.setText(film.getTitolo());
                durata.setText(film.getDurata());
                copertina.setImageResource(film.getImage());
                descrizione.setText(film.getDescrizione());
                idVideo.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                        youTubePlayer.cueVideo(film.getIdVideo(), 0);
                    }
                });
                ArrayList<String> vettCommenti = new ArrayList<>();
                vettCommenti.add("Davvero un capolavoro, complimenti.");
                vettCommenti.add("Sono rimasto deluso da quest'ultimo capitolo, mi aspettavo di meglio...");
                vettCommenti.add("Miglior Spider-Man mai uscito fin’ora. Consiglio vivamente la visone!");

                adapter = new CommentiDetailsAdapter(vettCommenti);
                LinearLayoutManager layoutManager
                        = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(layoutManager);
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                        layoutManager.getOrientation());
                recyclerView.addItemDecoration(dividerItemDecoration);
                recyclerView.setAdapter(adapter);

                btnInvio.setOnClickListener(v -> {
                    String text = inputCommento.getText().toString().trim();
                    if (text.length() > 0) {
                        inputCommento.setText("");
                        vettCommenti.add(text);
                        adapter.changeVett(vettCommenti);
                    }
                });
            } else {
                Navigation.findNavController(view).popBackStack();
            }
        }

        private TextView titolo;
        private TextView durata;
        private ImageView copertina;
        private TextView descrizione;
        private YouTubePlayerView idVideo;
        private RecyclerView recyclerView;
        private CommentiDetailsAdapter adapter;
        private EditText inputCommento;
        private Button btnInvio;
    }


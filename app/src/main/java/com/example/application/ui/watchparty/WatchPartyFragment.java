package com.example.application.ui.watchparty;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.application.MainActivity;
import com.example.application.R;
import com.google.android.material.button.MaterialButton;

public class WatchPartyFragment extends Fragment {
    private void modeExit() {
        exitText.setVisibility(View.VISIBLE);
        chat.setVisibility(View.INVISIBLE);
        stanza.setVisibility(View.INVISIBLE);
        esci.setVisibility(View.INVISIBLE);
        text.setVisibility(View.INVISIBLE);
        send.setVisibility(View.INVISIBLE);
        testo.setVisibility(View.INVISIBLE);
        scrollView.setVisibility(View.INVISIBLE);
    }

    private void modeMain() {
        exitText.setVisibility(View.INVISIBLE);
        chat.setVisibility(View.VISIBLE);
        stanza.setVisibility(View.VISIBLE);
        esci.setVisibility(View.VISIBLE);
        stanza.setBackgroundColor(getResources().getColor(R.color.background_app_color));
        chat.setBackgroundColor(getResources().getColor(R.color.blue));
        text.setVisibility(View.VISIBLE);
        send.setVisibility(View.VISIBLE);
        testo.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.INVISIBLE);
    }

    private void userMode() {
        exitText.setVisibility(View.INVISIBLE);
        chat.setVisibility(View.VISIBLE);
        stanza.setVisibility(View.VISIBLE);
        stanza.setBackgroundColor(getResources().getColor(R.color.blue));
        chat.setBackgroundColor(getResources().getColor(R.color.background_app_color));
        esci.setVisibility(View.VISIBLE);
        text.setVisibility(View.INVISIBLE);
        send.setVisibility(View.INVISIBLE);
        testo.setVisibility(View.INVISIBLE);
        scrollView.setVisibility(View.VISIBLE);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        chat = view.findViewById(R.id.chatButton);
        stanza = view.findViewById(R.id.lobbyButton);
        esci = view.findViewById(R.id.imageViewEsci);
        text = view.findViewById(R.id.editTextTextPersonName2);
        send = view.findViewById(R.id.imageViewSend);
        testo = view.findViewById(R.id.editTextChat);
        exitText=view.findViewById(R.id.textView5);
        scrollView=view.findViewById(R.id.scrollView3);

            if (MainActivity.hasWatchParty) {
                modeMain();
                send.setOnClickListener(view1 -> {
                    String newMess = testo.getText().toString().trim();

                    if (newMess.length() > 0) {
                        text.append("\n" + newMess);
                    }
                });

                chat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        modeMain();
                    }
                });

                stanza.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userMode();
                    }
                });

                esci.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                        builder.setTitle("Conferma uscita")
                                .setMessage("Sei sicuro di voler abbandonare il party?")
                                .setPositiveButton("Conferma", (dialog, id) -> {
                                    MainActivity.hasWatchParty = false;
                                    modeExit();
                                })
                                .setNegativeButton("Annulla", (dialog, id) -> {
                                });
                        builder.create().show();
                    }
                });
            }
            else
            {
                modeExit();
            }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_watchparty, container, false);
    }

    private MaterialButton chat;
    private MaterialButton stanza;
    private ImageView esci;
    private TextView text;
    private ImageView send;
    private EditText testo;
    private TextView exitText;
    private ScrollView scrollView;
}
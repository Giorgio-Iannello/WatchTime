package com.example.application.ui.watchparty;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.application.MainActivity;
import com.example.application.R;

public class WatchPartyFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(!MainActivity.hasWatchParty)
        {
            Navigation.findNavController(view).navigate(R.id.exitWatchParty);
        }
        else
        {
            chat = view.findViewById(R.id.chatButton);
            stanza = view.findViewById(R.id.lobbyButton);
            esci = view.findViewById(R.id.imageViewEsci);
            text=view.findViewById(R.id.editTextTextPersonName2);
            send=view.findViewById(R.id.imageViewSend);
            testo=view.findViewById(R.id.editTextChat);
            mess="Azione davvero incredibile!";
            text.setText(mess);

            send.setOnClickListener(view1 -> {
                String newMess=testo.getText().toString().trim();
                if (newMess.length()>0) {
                    mess+="\n"+newMess;
                }
                text.setText(mess);
                testo.setText("");
            });

            chat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(v).navigate(R.id.navigation_watch_party);
                }
            });

            stanza.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(v).navigate(R.id.watchPartyMembers);
                }
            });

            esci.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                    builder.setTitle("Conferma uscita")
                            .setMessage("Sei sicuro di voler abbandonare il party?")
                            .setPositiveButton("Conferma", (dialog, id) -> {
                                MainActivity.hasWatchParty=false;
                                Navigation.findNavController(v).navigate(R.id.exitWatchParty);
                            })
                            .setNegativeButton("Annulla", (dialog, id) -> {
                            });
                    builder.create().show();
                }
            });
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_watchparty, container, false);
    }

    private Button chat;
    private Button stanza;
    private ImageView esci;
    private TextView text;
    private ImageView send;
    private EditText testo;
    private String mess;
}
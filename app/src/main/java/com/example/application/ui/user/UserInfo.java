package com.example.application.ui.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.application.R;

public class UserInfo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        username = view.findViewById(R.id.editTextTextUsername);
        email = view.findViewById(R.id.editTextTextEmail);
        password = view.findViewById(R.id.editTextPassword);
        modifica = view.findViewById(R.id.button);

        modifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!username.getText().toString().equals("") || !email.getText().toString().equals("") || !password.getText().toString().equals("")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                    builder.setTitle("Conferma modifiche")
                            .setMessage("Sei sicuro di voler modificare?")
                            .setPositiveButton("Conferma", (dialog, id) -> {
                                Toast.makeText(requireContext(), "Modifiche salvate", Toast.LENGTH_SHORT).show();
                                Navigation.findNavController(view).navigate(R.id.navigation_user);
                            })
                            .setNegativeButton("Annulla", (dialog, id) -> {
                            });
                    builder.create().show();
                }
            }
        });
    }

    private EditText username;
    private EditText email;
    private EditText password;
    private Button modifica;
}

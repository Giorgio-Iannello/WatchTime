package com.example.application.ui.user;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.application.Login;
import com.example.application.MainActivity;
import com.example.application.R;


public class UserFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_profile, container, false);
    }

    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        modifica = view.findViewById(R.id.buttonModify);
        esci = view.findViewById(R.id.buttonLogOut);

        modifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Navigation.findNavController(v).navigate(R.id.userInfo);
            }
        });

        esci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                builder.setTitle("Conferma uscita")
                        .setMessage("Sei sicuro di voler uscire?")
                        .setPositiveButton("Conferma", (dialog, id) -> {

                            SharedPreferences sharedPreferences = requireContext().getSharedPreferences("info", MODE_PRIVATE);
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.remove("email");
                            edit.remove("psw");
                            edit.apply();

                            Intent intent = new Intent(requireContext(), Login.class);
                            startActivity(intent);
                        })
                        .setNegativeButton("Annulla", (dialog, id) -> {
                        });
                builder.create().show();
            }
        });
    }

    private Button modifica;
    private Button esci;
}
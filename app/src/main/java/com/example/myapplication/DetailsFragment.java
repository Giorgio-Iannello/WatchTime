package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.application.R;
import com.example.controller.CommentiDetailsAdapter;

import java.util.ArrayList;

public class DetailsFragment extends Fragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }
    private RecyclerView recyclerView;
    private CommentiDetailsAdapter adapter;
    private EditText inputCommento;
    private Button btnInvio;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.listCommenti);
        inputCommento=view.findViewById(R.id.editTextComment);
        btnInvio=view.findViewById(R.id.buttonSend);
        ArrayList<String> vettCommenti=new ArrayList<>();
        vettCommenti.add("Fighissimo madonna");
        vettCommenti.add("Fa cagare....");
        adapter=new CommentiDetailsAdapter(vettCommenti);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);

        btnInvio.setOnClickListener(v -> {
            String text=inputCommento.getText().toString().trim();
            if(text.length()>0)
            {
                inputCommento.setText("");
                vettCommenti.add(text);
                adapter.changeVett(vettCommenti);
            }
            else
            {
                Toast.makeText(requireContext(),"AAAAA", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
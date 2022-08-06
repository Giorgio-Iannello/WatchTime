package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = "gruppo7";
        password = "gruppo7";
        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        showPs = findViewById(R.id.spuntaPw);
        rememberMe = findViewById(R.id.spuntaRC);

        SharedPreferences sharedPreferences = getSharedPreferences("info", MODE_PRIVATE);

        String email = sharedPreferences.getString("email", "");
        String psw = sharedPreferences.getString("psw", "");

        if (email.length() > 0 && psw.length() > 0) {

            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
    }

    public void clickReg(View view) {

        Intent reg = new Intent(Login.this, Registrazione.class);
        startActivity(reg);
    }

    public void cLickAccedi(View view) {

        if (!usernameET.getText().toString().equals(username) || !passwordET.getText().toString().equals(password)){
            Toast toast = Toast.makeText(this, "Non sei registrato!", Toast. LENGTH_LONG);
            toast.show();
        }
        else{

            SharedPreferences sharedPreferences = getSharedPreferences("info", MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("email", usernameET.getText().toString());
            edit.putString("psw", passwordET.getText().toString());
            edit.apply();

            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }

    }

    public void clickMP(View view) {

        if (showPs.isChecked()){
            passwordET.setInputType( InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }
        else{
            passwordET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        }
        passwordET.setSelection(passwordET.getText().length());
    }


    private EditText usernameET, passwordET;
    private String username, password;
    private CheckBox rememberMe, showPs;
}
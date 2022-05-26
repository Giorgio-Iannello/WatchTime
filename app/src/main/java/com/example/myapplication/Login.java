package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
        EditText usernameET, passwordET;
        String username, password;
        CheckBox spuntaPw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        username = "gruppo7";
        password = "gruppo7";
        usernameET = (EditText) findViewById(R.id.usernameET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        spuntaPw = (CheckBox) findViewById(R.id.spuntaPw);

    }

    public void clickReg(View view) {

        Intent reg = new Intent(Login.this, Registrazione.class);

        startActivity(reg);


    }

    public void cLickAccedi(View view) {

        if(!usernameET.getText().toString().equals(username) || !passwordET.getText().toString().equals(password)){
            Toast toast = Toast.makeText(this, "Non sei registrato!", Toast. LENGTH_LONG);
            toast.show();


        }
        else{

        }

    }

    public void clickMP(View view) {

        if (spuntaPw.isChecked()){
            passwordET.setInputType( InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }
        else{
            passwordET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        }
        passwordET.setSelection(passwordET.getText().length());
    }
}
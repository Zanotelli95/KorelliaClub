package com.korellia.korelliaclubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class inicio extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        mAuth = FirebaseAuth.getInstance();
    }


    //con onstart el usuario ingresa a la app directamente si ya ha iniciado sesion correctamente antes
    protected void onStart(){
        super.onStart();

        if (mAuth.getCurrentUser() != null){

            startActivity(new Intent(inicio.this, MainActivity.class));
            finish();

        }
    }

    public void registrarse(View view){
        Intent registrarse = new Intent(inicio.this, registro.class);
        startActivity(registrarse);

    }

    public void iniciarsesion(View view){
        Intent iniciarsesion = new Intent(inicio.this, iniciarsesion.class);
        startActivity(iniciarsesion);

    }


}
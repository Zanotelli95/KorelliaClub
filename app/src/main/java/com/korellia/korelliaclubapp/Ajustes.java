package com.korellia.korelliaclubapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Ajustes extends AppCompatActivity {
    TextView preguntas;
    TextView privacidad;
    TextView terminos;
    TextView facebook;
    TextView twitter, instagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        Toolbar toolbar = findViewById(R.id.toolbarajustes);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ajustes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        preguntas = (TextView) findViewById(R.id.textViewpreguntasfrecuentes);
        privacidad = (TextView) findViewById(R.id.textViewpoliticasdeprivacidad);
        terminos = (TextView)  findViewById(R.id.textViewterminosycondiciones);
        facebook = (TextView) findViewById(R.id.textViewfacebook);
        twitter = (TextView) findViewById(R.id.textViewtwitter);
        instagram = (TextView) findViewById(R.id.insta);

        preguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://korellia.com/preguntasfrecuentes");
            }
        });

        privacidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://korellia.com/politicas");
            }
        });

        terminos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://korellia.com/terminos");
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.facebook.com/KorelliaLatam");
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://twitter.com/KorelliaLatam");
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.instagram.com/korellialatam/");
            }
        });


    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

}
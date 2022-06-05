package com.korellia.korelliaclubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

public class disciplinas extends AppCompatActivity {


    DatabaseReference mRootReference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas);


        mRootReference = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();


        //genera los valores de las medidas por default
        Map<String, Object> medidas = new HashMap<>();
        String id = mAuth.getCurrentUser().getUid();
        //brazo relajado
        medidas.put("/Medida Brazo Relajado/ Noviembre 2021", "0");
        medidas.put("/Medida Brazo Relajado/ Diciembre 2021", "0");
        medidas.put("/Medida Brazo Relajado/ Enero 2022", "0");
        medidas.put("/Medida Brazo Relajado/ Febrero 2022", "0");
        medidas.put("/Medida Brazo Relajado/ Marzo 2022", "0");
        medidas.put("/Medida Brazo Relajado/ Abril 2022", "0");

        //brazo contraido
        medidas.put("/Medida Brazo Contraido/ Noviembre 2021", "0");
        medidas.put("/Medida Brazo Contraido/ Diciembre 2021", "0");
        medidas.put("/Medida Brazo Contraido/ Enero 2022", "0");
        medidas.put("/Medida Brazo Contraido/ Febrero 2022", "0");
        medidas.put("/Medida Brazo Contraido/ Marzo 2022", "0");
        medidas.put("/Medida Brazo Contraido/ Abril 2022", "0");

        //torax
        medidas.put("/Medida Torax/ Noviembre 2021", "0");
        medidas.put("/Medida Torax/ Diciembre 2021", "0");
        medidas.put("/Medida Torax/ Enero 2022", "0");
        medidas.put("/Medida Torax/ Febrero 2022", "0");
        medidas.put("/Medida Torax/ Marzo 2022", "0");
        medidas.put("/Medida Torax/ Abril 2022", "0");

        //umbilical
        medidas.put("/Medida Umbilical/ Noviembre 2021", "0");
        medidas.put("/Medida Umbilical/ Diciembre 2021", "0");
        medidas.put("/Medida Umbilical/ Enero 2022", "0");
        medidas.put("/Medida Umbilical/ Febrero 2022", "0");
        medidas.put("/Medida Umbilical/ Marzo 2022", "0");
        medidas.put("/Medida Umbilical/ Abril 2022", "0");

        //cintura
        medidas.put("/Medida Cintura/ Noviembre 2021", "0");
        medidas.put("/Medida Cintura/ Diciembre 2021", "0");
        medidas.put("/Medida Cintura/ Enero 2022", "0");
        medidas.put("/Medida Cintura/ Febrero 2022", "0");
        medidas.put("/Medida Cintura/ Marzo 2022", "0");
        medidas.put("/Medida Cintura/ Abril 2022", "0");

        //cadera/gluteos
        medidas.put("/Medida Cadera-Gluteos/ Noviembre 2021", "0");
        medidas.put("/Medida Cadera-Gluteos/ Diciembre 2021", "0");
        medidas.put("/Medida Cadera-Gluteos/ Enero 2022", "0");
        medidas.put("/Medida Cadera-Gluteos/ Febrero 2022", "0");
        medidas.put("/Medida Cadera-Gluteos/ Marzo 2022", "0");

        //muslo
        medidas.put("/Medida Muslo/ Noviembre 2021", "0");
        medidas.put("/Medida Muslo/ Diciembre 2021", "0");
        medidas.put("/Medida Muslo/ Enero 2022", "0");
        medidas.put("/Medida Muslo/ Febrero 2022", "0");
        medidas.put("/Medida Muslo/ Marzo 2022", "0");
        medidas.put("/Medida Muslo/ Abril 2022", "0");

        //muslo medio
        medidas.put("/Medida Muslo Medio/ Noviembre 2021", "0");
        medidas.put("/Medida Muslo Medio/ Diciembre 2021", "0");
        medidas.put("/Medida Muslo Medio/ Enero 2022", "0");
        medidas.put("/Medida Muslo Medio/ Febrero 2022", "0");
        medidas.put("/Medida Muslo Medio/ Marzo 2022", "0");
        medidas.put("/Medida Muslo Medio/ Abril 2022", "0");


        //pantorrillas
        medidas.put("/Medida Pantorrillas/ Noviembre 2021", "0");
        medidas.put("/Medida Pantorrillas/ Diciembre 2021", "0");
        medidas.put("/Medida Pantorrillas/ Enero 2022", "0");
        medidas.put("/Medida Pantorrillas/ Febrero 2022", "0");
        medidas.put("/Medida Pantorrillas/ Marzo 2022", "0");
        medidas.put("/Medida Pantorrillas/ Abril 2022", "0");

        //kilogramos
        medidas.put("Peso Corporal/ Noviembre 2021", "0");
        medidas.put("Peso Corporal/ Diciembre 2021", "0");
        medidas.put("Peso Corporal/ Enero 2022", "0");
        medidas.put("Peso Corporal/ Febrero 2022", "0");
        medidas.put("Peso Corporal/ Marzo 2022", "0");
        medidas.put("Peso Corporal/ Abril 2022", "0");

        medidas.put("puntaje medidas","true");
        medidas.put("preferencia medidas","centimetros");


        mRootReference.child("Users").child(id).updateChildren(medidas);


    }



    public void pesas(View view) {

        Intent preguntas20 = new Intent(disciplinas.this, preguntas1.class);

        String id = mAuth.getCurrentUser().getUid();


        Map<String, Object> disciplina = new HashMap<>();
        disciplina.put("disciplina", "Entrenamiento de pesas / Culturismo / Fitness");


        mRootReference.child("Users").child(id).updateChildren(disciplina);


        startActivity(preguntas20);
        finish();
    }


    @Override
    public void onBackPressed() {

    }




}


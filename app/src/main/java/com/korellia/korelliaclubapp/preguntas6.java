package com.korellia.korelliaclubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class preguntas6 extends AppCompatActivity {
    RadioButton r31, r38, r39, r40, r41, r42;
    DatabaseReference mRootReference;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas6);

        r31 = (RadioButton)  findViewById(R.id.radioButton31);
        r38 = (RadioButton)  findViewById(R.id.radioButton38);
        r39 = (RadioButton)  findViewById(R.id.radioButton39);
        r40 = (RadioButton)  findViewById(R.id.radioButton40);
        r41 = (RadioButton)  findViewById(R.id.radioButton41);
        r42 = (RadioButton)  findViewById(R.id.radioButton42);

        mRootReference = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();



    }

    public void preguntas60 (View view){
        if (view.getId()==R.id.button26 && r31.isChecked() || r38.isChecked() || r39.isChecked() || r40.isChecked() || r41.isChecked() || r42.isChecked()){
            Intent preguntas60 = new Intent(preguntas6.this, generador.class);


            startActivity(preguntas60);

        }
        else {
            String presiona="Llena todos los campos";
            Toast.makeText(getApplicationContext(),presiona,Toast.LENGTH_SHORT).show();
        }


        String frecuenciaanterior = "";

        if (r31.isChecked()==true){
            frecuenciaanterior+="1 vez por semana";
        }

        if (r38.isChecked()==true){
            frecuenciaanterior+="1 a 2 veces por semana";
        }

        if (r39.isChecked()==true){
            frecuenciaanterior+="2 veces por semana";
        }

        if (r40.isChecked()==true){
            frecuenciaanterior+="2 a 3 veces por semana";
        }

        if (r41.isChecked()==true){
            frecuenciaanterior+="3 veces por semana";
        }

        if (r42.isChecked()==true){
            frecuenciaanterior+="nunca he entrenado";
        }






        String id = mAuth.getCurrentUser().getUid();

        Map<String, Object> preguntas6 = new HashMap<>();
        preguntas6.put("frecuencia de entrenamiento anterior", frecuenciaanterior);
        //finish();



        mRootReference.child("Users").child(id).updateChildren(preguntas6);

    }
    public void onDestroy(){
        super.onDestroy();
    }

}
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

public class preguntas5 extends AppCompatActivity {


    RadioButton r29, r30, r32, r33, r34, r35, r36, r37, r45;
    DatabaseReference mRootReference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas5);
        r29 = (RadioButton)  findViewById(R.id.radioButton29);
        r30 = (RadioButton)  findViewById(R.id.radioButton30);
        r32 = (RadioButton)  findViewById(R.id.radioButton32);
        r33 = (RadioButton)  findViewById(R.id.radioButton33);
        r34 = (RadioButton)  findViewById(R.id.radioButton34);
        r35 = (RadioButton)  findViewById(R.id.radioButton35);
        r36 = (RadioButton)  findViewById(R.id.radioButton36);
        r37 = (RadioButton)  findViewById(R.id.radioButton37);
        r45 = (RadioButton)  findViewById(R.id.radioButton45);

        mRootReference = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();

    }


    public void preguntas50 (View view){
        if (view.getId()==R.id.button25 && r29.isChecked() || r30.isChecked() || r45.isChecked()){


            if (  r32.isChecked() || r33.isChecked() || r34.isChecked() || r35.isChecked() ||
                    r36.isChecked() || r37.isChecked()) {

                Intent preguntas50 = new Intent(preguntas5.this, preguntas6.class);
                startActivity(preguntas50);

            }
            else {
                String presiona="Llena todos los campos";
                Toast.makeText(getApplicationContext(),presiona,Toast.LENGTH_SHORT).show();
            }
        }
        else {
            String presiona="Llena todos los campos";
            Toast.makeText(getApplicationContext(),presiona,Toast.LENGTH_SHORT).show();
        }

        String objetivo = "";
        String dolormuscular = "";

        if (r29.isChecked()==true){
            objetivo+="desarrollar masa muscular ";
        }

        if (r30.isChecked()==true){
            objetivo+="definir mi musculatura y bajar peso";
        }

        if (r45.isChecked()==true){
            objetivo+="mantenimiento";
        }

        if (r32.isChecked()==true){
            dolormuscular+="se presenta dolor hasta por 3 dias";
        }

        if (r33.isChecked()==true){
            dolormuscular+="se presenta dolor hasta por 2 dias";
        }

        if (r34.isChecked()==true){
            dolormuscular+="se presenta dolor de 1 a 2 días";
        }

        if (r35.isChecked()==true){
            dolormuscular+="raramente se presenta dolor por más de un día";
        }

        if (r36.isChecked()==true){
            dolormuscular+="menos de 1 día";
        }

        if (r37.isChecked()==true){
            dolormuscular+="nunca he entrenado";
        }




        String id = mAuth.getCurrentUser().getUid();

        Map<String, Object> preguntas5 = new HashMap<>();
        preguntas5.put("objetivo", objetivo);
        preguntas5.put("capacidad de recuperación", dolormuscular);



        mRootReference.child("Users").child(id).updateChildren(preguntas5);



    }
    public void onDestroy(){
        super.onDestroy();
    }

}
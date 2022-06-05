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

public class preguntas2 extends AppCompatActivity {
    RadioButton r5, r6, r7, r8, r9, r10, r11, r12;
    DatabaseReference mRootReference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas2);

        r5 = (RadioButton)  findViewById(R.id.radioButton5);
        r6 = (RadioButton)  findViewById(R.id.radioButton6);
        r7 = (RadioButton)  findViewById(R.id.radioButton7);
        r8 = (RadioButton)  findViewById(R.id.radioButton8);
        r9 = (RadioButton)  findViewById(R.id.radioButton9);
        r10 = (RadioButton)  findViewById(R.id.radioButton10);
        r11 = (RadioButton)  findViewById(R.id.radioButton11);
        r12 = (RadioButton)  findViewById(R.id.radioButton12);

        mRootReference = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();


    }

    public void preguntas20 (View view){

        if (view.getId()==R.id.button20 && r5.isChecked() || r6.isChecked() || r7.isChecked() || r8.isChecked() ||
                r9.isChecked()){

            if (r10.isChecked() || r11.isChecked() || r12.isChecked()){
                Intent preguntas20 = new Intent(preguntas2.this, preguntas3.class);
                startActivity(preguntas20);
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


        String años = "";
        String horasdesueño = "";

        if (r5.isChecked()==true){
            años+="nunca he entrenado";
        }

        if (r6.isChecked()==true){
            años+="menos de 4 años";
        }

        if (r7.isChecked()==true){
            años+="de 4 a 8 años";
        }

        if (r8.isChecked()==true){
            años+="de 8 a 12 años";
        }

        if (r9.isChecked()==true){
            años+="más de 12 años";
        }

        if (r10.isChecked()==true){
            horasdesueño+="menos de 5 horas";
        }

        if (r11.isChecked()==true){
            horasdesueño+="de 5 a 7 horas";
        }

        if (r12.isChecked()==true){
            horasdesueño+="más de 7 horas";
        }

        String id = mAuth.getCurrentUser().getUid();

        Map<String, Object> preguntas2 = new HashMap<>();
        preguntas2.put("años de entrenamiento", años);
        preguntas2.put("horas de sueño", horasdesueño);



        mRootReference.child("Users").child(id).updateChildren(preguntas2);




    }
    public void onDestroy(){
        super.onDestroy();
    }


}
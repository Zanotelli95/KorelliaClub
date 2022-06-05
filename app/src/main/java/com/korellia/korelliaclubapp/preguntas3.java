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

public class preguntas3 extends AppCompatActivity {
    RadioButton r13, r14, r15, r16, r17, r18, r19, r20, r21;

    DatabaseReference mRootReference;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas3);

        r13 = (RadioButton)  findViewById(R.id.radioButton13);
        r14 = (RadioButton)  findViewById(R.id.radioButton14);
        r15 = (RadioButton)  findViewById(R.id.radioButton15);
        r16 = (RadioButton)  findViewById(R.id.radioButton16);
        r17 = (RadioButton)  findViewById(R.id.radioButton17);
        r18 = (RadioButton)  findViewById(R.id.radioButton18);
        r19 = (RadioButton)  findViewById(R.id.radioButton19);
        r20 = (RadioButton)  findViewById(R.id.radioButton20);
        r21 = (RadioButton)  findViewById(R.id.radioButton21);

        mRootReference = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();
    }

    public void preguntas30 (View view){
        if (view.getId()==R.id.button23 && r13.isChecked() || r14.isChecked() || r15.isChecked() || r16.isChecked() || r17.isChecked() || r18.isChecked() || r19.isChecked()){

            if ( r20.isChecked() || r21.isChecked()) {
                Intent preguntas30 = new Intent(preguntas3.this, preguntas4.class);
                startActivity(preguntas30);
            }
            else {
                String presiona="Llena todos los campos";
                Toast.makeText(getApplicationContext(),presiona,Toast.LENGTH_SHORT).show();


            }

        }else {
            String presiona="Llena todos los campos";
            Toast.makeText(getApplicationContext(),presiona,Toast.LENGTH_SHORT).show();
        }


        String objetivosnutricionales = "";
        String actividades = "";

        if (r13.isChecked()==true){
            objetivosnutricionales+="Planeo ganar mucho peso corporal";
        }

        if (r14.isChecked()==true){
            objetivosnutricionales+="Planeo ganar un peso corporal moderado";
        }

        if (r15.isChecked()==true){
            objetivosnutricionales+="Planeo ganar poco peso corporal";
        }

        if (r16.isChecked()==true){
            objetivosnutricionales+="Planeo mantener mi peso corporal";
        }

        if (r17.isChecked()==true){
            objetivosnutricionales+="Planeo bajar poco peso corporal";
        }

        if (r18.isChecked()==true){
            objetivosnutricionales+="Planeo bajar un peso corporal moderado";
        }

        if (r19.isChecked()==true){
            objetivosnutricionales+="Planeo bajar mucho peso corporal";
        }

        if (r20.isChecked()==true){
            actividades+="si";
        }

        if (r21.isChecked()==true){
            actividades+="no";
        }


        String id = mAuth.getCurrentUser().getUid();


        Map<String, Object> preguntas3 = new HashMap<>();
        preguntas3.put("objetivos nutricionales", objetivosnutricionales);
        preguntas3.put("actividades extras", actividades);




        mRootReference.child("Users").child(id).updateChildren(preguntas3);


    }
    public void onDestroy(){
        super.onDestroy();
    }

}
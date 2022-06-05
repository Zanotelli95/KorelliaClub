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

public class preguntas4 extends AppCompatActivity {
    RadioButton r22, r23, r24, r25, r26, r27, r28;
    DatabaseReference mRootReference;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas4);

        r22 = (RadioButton)  findViewById(R.id.radioButton22);
        r23 = (RadioButton)  findViewById(R.id.radioButton23);
        r24 = (RadioButton)  findViewById(R.id.radioButton24);
        r25 = (RadioButton)  findViewById(R.id.radioButton25);
        r26 = (RadioButton)  findViewById(R.id.radioButton26);
        r27 = (RadioButton)  findViewById(R.id.radioButton27);
        r28 = (RadioButton)  findViewById(R.id.radioButton28);

        mRootReference = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();
    }

    public void preguntas40 (View view){
        if (view.getId()==R.id.button24 && r22.isChecked() || r23.isChecked() || r24.isChecked() || r25.isChecked()){

            if (r26.isChecked() || r27.isChecked() || r28.isChecked()) {

                Intent preguntas40 = new Intent(preguntas4.this, preguntas5.class);
                startActivity(preguntas40);
            }else {
                String presiona="Llena todos los campos";
                Toast.makeText(getApplicationContext(),presiona,Toast.LENGTH_SHORT).show();
            }

        }


        else {
            String presiona="Llena todos los campos";
            Toast.makeText(getApplicationContext(),presiona,Toast.LENGTH_SHORT).show();
        }

        String estresfisico = "";
        String estresmental = "";

        if (r22.isChecked()==true){
            estresfisico+="alto";
        }

        if (r23.isChecked()==true){
            estresfisico+="bajo";
        }

        if (r24.isChecked()==true){
            estresfisico+="regular";
        }

        if (r25.isChecked()==true){
            estresfisico+="nulo";
        }

        if (r26.isChecked()==true){
            estresmental+="alto";
        }

        if (r27.isChecked()==true){
            estresmental+="regular";
        }

        if (r28.isChecked()==true){
            estresmental+="bajo";
        }




        String id = mAuth.getCurrentUser().getUid();

        Map<String, Object> preguntas4 = new HashMap<>();
        preguntas4.put("estrés físico", estresfisico);
        preguntas4.put("estrés mental", estresmental);



        mRootReference.child("Users").child(id).updateChildren(preguntas4);

    }
    public void onDestroy(){
        super.onDestroy();
    }

}
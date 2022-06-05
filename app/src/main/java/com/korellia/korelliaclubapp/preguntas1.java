package com.korellia.korelliaclubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class preguntas1 extends AppCompatActivity {


    RadioButton r1, r2, r3, r4;
    EditText kilogramosedit, centimetrosedit;

    DatabaseReference mRootReference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas1);

        r1 = (RadioButton)  findViewById(R.id.radioButton);
        r2 = (RadioButton)  findViewById(R.id.radioButton2);
        r3 = (RadioButton)  findViewById(R.id.radioButton3);
        r4 = (RadioButton)  findViewById(R.id.radioButton4);

        kilogramosedit = (EditText) findViewById(R.id.kilogramos);
        centimetrosedit = (EditText) findViewById(R.id.centimetros);

        mRootReference = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();


    }




    public void preguntas (View view){

        if (view.getId()==R.id.button17 && r1.isChecked() || r2.isChecked() || r3.isChecked() || r4.isChecked() &&
                !kilogramosedit.getText().toString().isEmpty() && !centimetrosedit.getText().toString().isEmpty()){
            validar();
            Intent preguntas = new Intent(preguntas1.this, preguntas2.class);
            startActivity(preguntas);

        }


        else {
            String presiona="Llena todos los campos";
            Toast.makeText(getApplicationContext(),presiona,Toast.LENGTH_SHORT).show();
        }
    }



    public void validar (){
        String cad="";

        if (r1.isChecked()==true){
            cad+="3";
        }

        if (r2.isChecked()==true){
            cad+="4";
        }

        if (r3.isChecked()==true){
            cad+="5";
        }

        if (r4.isChecked()==true){
            cad+="6";
        }

        String id = mAuth.getCurrentUser().getUid();
        String kg = kilogramosedit.getText().toString();
        String cm = centimetrosedit.getText().toString();


        Map<String, Object> preguntas1 = new HashMap<>();
        preguntas1.put("dias", cad);
        preguntas1.put("kilogramos", kg);
        preguntas1.put("centimetros", cm);


        mRootReference.child("Users").child(id).updateChildren(preguntas1);


    }

    @Override
    public void onBackPressed() {

    }
    public void onDestroy(){
        super.onDestroy();
    }

}
package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class nuevobloque extends AppCompatActivity {

   private RadioButton r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r13, r15;
    private EditText kilogramosedit;

    private   DatabaseReference mRootReference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevobloque);


        r1 = (RadioButton)  findViewById(R.id.radioButton62);
        r2 = (RadioButton)  findViewById(R.id.radioButton63);
        r3 = (RadioButton)  findViewById(R.id.radioButton64);
        r4 = (RadioButton)  findViewById(R.id.radioButton65);

        r6 = (RadioButton)  findViewById(R.id.radioButton67);
        r7 = (RadioButton)  findViewById(R.id.radioButton68);
        r8 = (RadioButton)  findViewById(R.id.radioButton69);

        r9 = (RadioButton)  findViewById(R.id.radioButton66);
        r10 = (RadioButton)  findViewById(R.id.radioButton70);
        r11 = (RadioButton)  findViewById(R.id.radioButton71);
        r12 = (RadioButton)  findViewById(R.id.radioButton72);
        r13 = (RadioButton)  findViewById(R.id.radioButton73);
        r14 = (RadioButton)  findViewById(R.id.radioButton74);
        r15 = (RadioButton)  findViewById(R.id.radioButton75);

        mAuth = FirebaseAuth.getInstance();
        kilogramosedit = (EditText) findViewById(R.id.kg2);



        mRootReference = FirebaseDatabase.getInstance().getReference();


    }



    public void finalizarbloque(View view) {

        if (view.getId()==R.id.button21 && r1.isChecked() || r2.isChecked() || r3.isChecked() || r4.isChecked() &&
                r6.isChecked() || r7.isChecked() || r8.isChecked()){

            if ( r9.isChecked() || r10.isChecked() || r11.isChecked() || r12.isChecked() || r13.isChecked() || r14.isChecked() || r15.isChecked() &&
                    !kilogramosedit.getText().toString().isEmpty()){

                validar();



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


    }

    private void validar() {
        String id = mAuth.getCurrentUser().getUid();

        mRootReference.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String dia="";

                if (r1.isChecked()==true) {
                    dia = "3";
                }
                if (r2.isChecked()==true) {
                    dia = "4";
                }
                if (r3.isChecked()==true) {
                    dia = "5";
                }
                if (r4.isChecked()==true) {
                    dia = "6";
                }

                String obj ="";

                if (r6.isChecked()==true) {
                    obj = "Desarrollar masa muscular";
                }
                if (r7.isChecked()==true) {
                    obj = "Definir mi musculatura y bajar de peso";
                }
                if (r8.isChecked()==true) {
                    obj = "Mantenimiento";
                }

                String objnutri ="";

                if (r9.isChecked()==true) {
                    objnutri = "Planeo ganar mucho peso corporal";
                }
                if (r10.isChecked()==true) {
                    objnutri = "Planeo ganar un peso corporal moderado";
                }
                if (r11.isChecked()==true) {
                    objnutri = "Planeo ganar poco peso corporal";
                }
                if (r12.isChecked()==true) {
                    objnutri = "Planeo mantener mi peso corporal";
                }
                if (r13.isChecked()==true) {
                    objnutri = "Planeo bajar poco peso corporal";
                }
                if (r14.isChecked()==true) {
                    objnutri = "Planeo bajar un peso corporal moderado";
                }
                if (r15.isChecked()==true) {
                    objnutri = "Planeo bajar mucho peso corporal";
                }


                String id = mAuth.getCurrentUser().getUid();
                String kg =  kilogramosedit.getText().toString();

                Map<String, Object> actualizacion = new HashMap<>();

                actualizacion.put("dias", dia);
                actualizacion.put("objetivo", obj);
                actualizacion.put("kilogramos", kg);
                actualizacion.put("objetivos nutricionales", objnutri);



                mRootReference.child("Users").child(id).updateChildren(actualizacion);


                Intent preguntas = new Intent(nuevobloque.this, generadorsecundario.class);
                startActivity(preguntas);

                finish();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    @Override
    public void onBackPressed() {

    }
   


}
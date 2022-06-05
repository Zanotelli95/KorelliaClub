package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class entrenamientofinalizado extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamientofinalizado);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void onBackPressed() {
    }

    public void salir(View view) {
        String id = mAuth.getCurrentUser().getUid();
        String valor2 = getIntent().getExtras().getString("actual");
        String entreno3dia1entreno = getIntent().getExtras().getString("entreno?");

        boolean botonpresionado = true;

        if (botonpresionado == true){
            int entrenofint = 1;
            int actualint = Integer.parseInt(valor2);
            int suma = entrenofint + actualint;

        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        Intent intent = new Intent(entrenamientofinalizado.this, MainActivity.class);
                            Map<String, Object> pesoejercicios = new HashMap<>();
                            pesoejercicios.put("diasentrenados", suma);
                            mDatabase.child("Users").child(id).updateChildren(pesoejercicios);

                            switch (entreno3dia1entreno){
                                case "si":
                                    Map<String, Object> actualizar = new HashMap<>();
                                    actualizar.put("diaactual1", "true");
                                    mDatabase.child("Users").child(id).updateChildren(actualizar);
                                    break;

                                case "sidia2":
                                    Map<String, Object> actualizar2 = new HashMap<>();
                                    actualizar2.put("diaactual2", "true");
                                    mDatabase.child("Users").child(id).updateChildren(actualizar2);
                                    break;

                                case "sidia3":
                                    Map<String, Object> actualizar3 = new HashMap<>();
                                    actualizar3.put("diaactual3", "true");
                                    mDatabase.child("Users").child(id).updateChildren(actualizar3);

                                    break;

                                case "sidia4":
                                    Map<String, Object> actualizar4 = new HashMap<>();
                                    actualizar4.put("diaactual4", "true");
                                    mDatabase.child("Users").child(id).updateChildren(actualizar4);
                                    break;

                                case "sidia5":
                                    Map<String, Object> actualizar5 = new HashMap<>();
                                    actualizar5.put("diaactual5", "true");
                                    mDatabase.child("Users").child(id).updateChildren(actualizar5);
                                    break;

                                case "sidia6":
                                    Map<String, Object> actualizar6 = new HashMap<>();
                                    actualizar6.put("diaactual6", "true");
                                    mDatabase.child("Users").child(id).updateChildren(actualizar6);
                                    break;
                            }
                            startActivity(intent);
                            finish();
                        }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        }
    }

}
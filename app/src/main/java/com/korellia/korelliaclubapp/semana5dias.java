package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class semana5dias extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semana5dias);

        Toolbar toolbar = findViewById(R.id.toolbarsemana5dias);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mi semana");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();


    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calentamientossemana5 (View view){

        Intent dia1 = new Intent(semana5dias.this, calentamiento.class);
        startActivity(dia1);

    }

    public void dia1 (View view){


        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {


                String diaactual1 = datasnapshot.child("diaactual1").getValue().toString();
                String genero = datasnapshot.child("sexo").getValue().toString();


                if (diaactual1.equals("false")){

                    if (genero.equals("Masculino")){
                        Intent dia1 = new Intent(semana5dias.this, entreno5dialunes.class);

                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia1.putExtra("actual",de);
                            startActivity(dia1);


                        }

                    } else {

                        Intent dia1 = new Intent(semana5dias.this, entreno5dialunesmujer.class);

                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia1.putExtra("actual",de);
                            startActivity(dia1);


                        }

                    }




                }
                else {
                    Toast.makeText(semana5dias.this, "Ya realizaste este entrenamiento. Completa tu semana.", Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void dia2 (View view){


        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {


                String diaactual1 = datasnapshot.child("diaactual2").getValue().toString();
                String genero = datasnapshot.child("sexo").getValue().toString();




                if (diaactual1.equals("false")){

                    if (genero.equals("Masculino")){

                        Intent dia1 = new Intent(semana5dias.this, entreno5diamartes.class);

                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia1.putExtra("actual",de);
                            startActivity(dia1);


                        }

                    } else {

                        Intent dia1 = new Intent(semana5dias.this, entreno5diamartesmujer.class);

                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia1.putExtra("actual",de);
                            startActivity(dia1);


                        }

                    }




                }
                else {
                    Toast.makeText(semana5dias.this, "Ya realizaste este entrenamiento. Completa tu semana.", Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void dia3 (View view){


        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {


                String diaactual1 = datasnapshot.child("diaactual3").getValue().toString();
                String genero = datasnapshot.child("sexo").getValue().toString();


                if (diaactual1.equals("false")){
                    if (genero.equals("Masculino")){
                        Intent dia1 = new Intent(semana5dias.this, entreno5diamiercoles.class);

                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia1.putExtra("actual",de);
                            startActivity(dia1);


                        }

                    } else {
                        Intent dia1 = new Intent(semana5dias.this, entreno5diamiercolesmujer.class);

                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia1.putExtra("actual",de);
                            startActivity(dia1);


                        }


                    }





                }
                else {
                    Toast.makeText(semana5dias.this, "Ya realizaste este entrenamiento. Completa tu semana.", Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void dia4 (View view){


        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {


                String diaactual1 = datasnapshot.child("diaactual4").getValue().toString();
                String genero = datasnapshot.child("sexo").getValue().toString();


                if (diaactual1.equals("false")){
                    if (genero.equals("Masculino")){

                        Intent dia1 = new Intent(semana5dias.this, entreno5diaviernes.class);

                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia1.putExtra("actual",de);
                            startActivity(dia1);


                        }
                    } else {
                        Intent dia1 = new Intent(semana5dias.this, entreno5diajuevesmujer.class);

                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia1.putExtra("actual",de);
                            startActivity(dia1);


                        }


                    }





                }
                else {
                    Toast.makeText(semana5dias.this, "Ya realizaste este entrenamiento. Completa tu semana.", Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void dia5 (View view){


        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {


                String diaactual1 = datasnapshot.child("diaactual5").getValue().toString();
                String genero = datasnapshot.child("sexo").getValue().toString();




                if (diaactual1.equals("false")){

                    if (genero.equals("Masculino")){


                        Intent dia1 = new Intent(semana5dias.this, entreno5diasabado.class);

                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia1.putExtra("actual",de);
                            startActivity(dia1);


                        }

                    } else {
                        Intent dia1 = new Intent(semana5dias.this, entreno5diaviernesmujer.class);

                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia1.putExtra("actual",de);
                            startActivity(dia1);


                        }

                    }



                }
                else {
                    Toast.makeText(semana5dias.this, "Ya realizaste este entrenamiento. Completa tu semana.", Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void responder3 (View view){

        Intent responder = new Intent(semana5dias.this, finsemana.class);
        startActivity(responder);
        finish();
    }
}
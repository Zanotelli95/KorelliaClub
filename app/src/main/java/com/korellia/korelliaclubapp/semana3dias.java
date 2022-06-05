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

public class semana3dias extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semana3dias);

        Toolbar toolbar = findViewById(R.id.toolbarsemana3dias);
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


    public void calentamientos (View view){

        Intent dia1 = new Intent(semana3dias.this, calentamiento.class);
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

                        Intent dia1 = new Intent(semana3dias.this, entreno3dia1.class);

                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia1.putExtra("actual",de);
                            startActivity(dia1);


                        }


                    } else {

                        Intent dia1 = new Intent(semana3dias.this, entreno3dia1mujer.class);

                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia1.putExtra("actual",de);
                            startActivity(dia1);


                        }

                        

                    }




                }
                else {
                    Toast.makeText(semana3dias.this, "Ya realizaste este entrenamiento. Completa tu semana.", Toast.LENGTH_SHORT).show();
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

                        Intent dia2 = new Intent(semana3dias.this, entreno3dia2.class);
                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia2.putExtra("actual",de);
                            startActivity(dia2);


                        }
                    } else {

                        Intent dia2 = new Intent(semana3dias.this, entreno3dia2mujer.class);
                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia2.putExtra("actual",de);
                            startActivity(dia2);

                        }




                    }



                }else {
                    Toast.makeText(semana3dias.this, "Ya realizaste este entrenamiento. Completa tu semana.", Toast.LENGTH_SHORT).show();
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

                String diaactual3 = datasnapshot.child("diaactual3").getValue().toString();
                String genero = datasnapshot.child("sexo").getValue().toString();


                if (diaactual3.equals("false")){

                    if (genero.equals("Masculino")){


                        Intent dia3 = new Intent(semana3dias.this, entreno3dia3.class);




                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia3.putExtra("actual",de);
                            startActivity(dia3);


                        }

                    }


                    else {


                        Intent dia3 = new Intent(semana3dias.this, entreno3dia3mujer.class);




                        boolean botonpresionado = true;

                        if (botonpresionado == true){

                            String de = datasnapshot.child("diasentrenados").getValue().toString();
                            dia3.putExtra("actual",de);
                            startActivity(dia3);


                        }
                    }



                }
                else {
                    Toast.makeText(semana3dias.this, "Ya realizaste este entrenamiento. Completa tu semana.", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    public void responder (View view){



            Intent responder = new Intent(semana3dias.this, finsemana.class);
            startActivity(responder);
            finish();



    }

  //  public void onDestroy() { super.onDestroy(); }

}
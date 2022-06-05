package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class nutricion extends AppCompatActivity {

    TextView objetivonutricional, caloriasm, caloriasfinales;
    TextView respuestaproteinaporcentaje, respuestaporcentajecarbs, respuestaporcentajegrasas;
    TextView respuestaproteinasgramos, respuestagramoscarbs, respuestagramosgrasas;
    DatabaseReference mDatabase;
    FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_nutricion);

        Toolbar toolbar = findViewById(R.id.toolbarnutricion);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mi nutrición");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        respuestaproteinaporcentaje = (TextView) findViewById(R.id.respuestaporcentajeproteinas);
        respuestaporcentajecarbs = (TextView) findViewById(R.id.respuestaporcentajecarbohidratos);
        respuestaporcentajegrasas = (TextView) findViewById(R.id.respuestaprocentajegrasas);

        respuestaproteinasgramos = (TextView) findViewById(R.id.textView194);
        respuestagramoscarbs = (TextView) findViewById(R.id.textView196);
        respuestagramosgrasas = (TextView) findViewById(R.id.textView198);

        objetivonutricional =  (TextView) findViewById(R.id.textView191);
        caloriasm =  (TextView) findViewById(R.id.textView200);
        caloriasfinales =  (TextView) findViewById(R.id.textView189);
        mAuth = FirebaseAuth.getInstance();
        String id = mAuth.getCurrentUser().getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String objetivo = datasnapshot.child("objetivos nutricionales").getValue().toString();
                String caloriasmantenimiento = datasnapshot.child("calorias de mantenimiento").getValue().toString();
                String caloriasfin = datasnapshot.child("calorias totales").getValue().toString();
                objetivonutricional.setText(objetivo);
                caloriasm.setText(caloriasmantenimiento);
                caloriasfinales.setText(caloriasfin);

                // gramos

                String porcentajeproteinas = "30";
                String porcentajecarbs = "50";
                String porcentajegrasas = "20";

                String total = caloriasfin;
                float gramostotal = Float.parseFloat(total);
                float proteinasgramos = ((gramostotal * 30) / 100) / 4;
                String totalproteinas = Integer.toString((int) proteinasgramos);

                float carbsgramos = ((gramostotal * 50) / 100) / 4;
                String totalcarbs = Integer.toString((int) carbsgramos);

                float grasasgramos = ((gramostotal * 20) / 100) / 9;
                String totalgrasas = Integer.toString((int) grasasgramos);


                respuestaproteinasgramos.setText(totalproteinas);
                respuestagramoscarbs.setText(totalcarbs);
                respuestagramosgrasas.setText(totalgrasas);

                // porcentaje


                respuestaproteinaporcentaje.setText(porcentajeproteinas + " %");
                respuestaporcentajecarbs.setText(porcentajecarbs + " %");
                respuestaporcentajegrasas.setText(porcentajegrasas + " %");


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });











    } //fin del on create

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
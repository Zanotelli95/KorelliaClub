package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class calentamiento extends AppCompatActivity {

    ImageView calentamiento1, calentamiento2, calentamiento3, calentamiento4;
    TextView nombrec1, nombrec2, nombrec3, nombrec4;
    TextView descripcionc1, descripcionc2, descripcionc3, descripcionc4;

    private String ejercicioseleccionado1, ejercicioseleccionado2, ejercicioseleccionado3, ejercicioseleccionado4;

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calentamiento);

        Toolbar toolbar = findViewById(R.id.toolbarcalentamiento);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Calentamiento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      mDatabase = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();
        String id = mAuth.getCurrentUser().getUid();


        calentamiento1 = (ImageView) findViewById(R.id.imageViewcalentamiento1);
        calentamiento2 = (ImageView) findViewById(R.id.imageViewcalentamiento2);
        calentamiento3 = (ImageView) findViewById(R.id.imageViewcalentamiento3);
        calentamiento4 = (ImageView) findViewById(R.id.imageViewcalentamiento4);


        nombrec1 = (TextView) findViewById(R.id.textViewcalentamiento1);
        nombrec2 = (TextView) findViewById(R.id.textViewcalentamiento2);
        nombrec3 = (TextView) findViewById(R.id.textViewcalentamiento3);
        nombrec4 = (TextView) findViewById(R.id.textViewcalentamiento4);


        descripcionc1 = (TextView) findViewById(R.id.textViewdescripcioncalentamiento1);
        descripcionc2 = (TextView) findViewById(R.id.textViewdescripcioncalentamiento2);
        descripcionc3 = (TextView) findViewById(R.id.textViewdescripcioncalentamiento3);
        descripcionc4 = (TextView) findViewById(R.id.textViewdescripcioncalentamiento4);


        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                if (datasnapshot.exists()) {

                    String ejercicio1 = datasnapshot.child("calentamiento/ ejercicio primario").getValue().toString();
                    nombrec1.setText(ejercicio1);
                    ejercicioseleccionado1 = ejercicio1;

                    String ejercicio2 = datasnapshot.child("calentamiento/ ejercicio secundario").getValue().toString();
                    nombrec2.setText(ejercicio2);
                    ejercicioseleccionado2 = ejercicio2;

                    String ejercicio3 = datasnapshot.child("calentamiento/ ejercicio tercero").getValue().toString();
                    nombrec3.setText(ejercicio3);
                    ejercicioseleccionado3 = ejercicio3;

                    String ejercicio4 = datasnapshot.child("calentamiento/ ejercicio cuarto").getValue().toString();
                    nombrec4.setText(ejercicio4);
                    ejercicioseleccionado4 = ejercicio4;

                }


                //torso

                if (ejercicioseleccionado1.equals("Bird dogs")) {
                    String duracion = "1 x 10 Reps por lado";
                    descripcionc1.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbird%20dogs%2F20211210_111108.jpg?alt=media&token=3213739f-bfc0-4a4f-9426-324cb2c94c36")
                            .fit().centerCrop()
                            .into(calentamiento1);
                }

                if (ejercicioseleccionado1.equals("Dead bugs")) {
                    String duracion = "1 x 10 a 15 Reps por lado";
                    descripcionc1.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fdead%20bugs%2Fdead2.jpg?alt=media&token=7490789c-854c-435a-8c4e-5c31609af78f")
                            .fit().centerCrop()
                            .into(calentamiento1);
                }


                if (ejercicioseleccionado1.equals("Db Cuban press")) {
                    String duracion = "1 x 10 a 15 Reps con peso ligero";
                    descripcionc1.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fcuban%20press%2F20211210_111532.jpg?alt=media&token=c26970f7-9d71-41c7-8fda-631312678a8c")
                            .fit().centerCrop()
                            .into(calentamiento1);
                }

                if (ejercicioseleccionado1.equals("Rotación externa de hombro con mancuernas pegado al cuerpo")) {
                    String duracion = "1 x 10 a 20 Reps por lado";
                    descripcionc1.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20externa%20de%20hombro%20con%20mancuerna%20pegado%20al%20cuerpo%2FIMG_0321.jpg?alt=media&token=3f9e4fda-ae04-4ccc-ab03-920cf317227d")
                            .fit().centerCrop()
                            .into(calentamiento1);
                }

                if (ejercicioseleccionado1.equals("Rotación externa de hombro con cable pegado al cuerpo")) {
                    String duracion = "1 x 10 a 20 Reps por lado";
                    descripcionc1.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fcable%20shoulder%20extensions%2F20211210_112233.jpg?alt=media&token=5650b9b9-b746-41ac-9a92-7a59b8b402b6")
                            .fit().centerCrop()
                            .into(calentamiento1);
                }

                if (ejercicioseleccionado1.equals("Aducciones de hombro")) {
                    String duracion = "1 x 10 a 20 Reps por lado";
                    descripcionc1.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Faducciones%20de%20hombro%2F20210131_102756.jpg?alt=media&token=92b87167-04fe-432a-bd7e-c5039b37137e")
                            .fit().centerCrop()
                            .into(calentamiento1);
                }

                if (ejercicioseleccionado1.equals("Rotación de hombros con brazos extendidos")) {
                    String duracion = "1 x 15 segundos";
                    descripcionc1.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20hombro%20con%20brazos%20extendidos%2F20210131_102918.jpg?alt=media&token=76dcffbd-da68-4f50-83fd-d175aa408177")
                            .fit().centerCrop()
                            .into(calentamiento1);
                }

                if (ejercicioseleccionado1.equals("Rotación de hombro")) {
                    String duracion = "1 x 15 Segundos por lado";
                    descripcionc1.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20hombro%2F20210131_102731.jpg?alt=media&token=f2567083-f710-487a-861c-0fe72e6be6ef")
                            .fit().centerCrop()
                            .into(calentamiento1);
                }

                if (ejercicioseleccionado1.equals("Rotación de muñecas")) {
                    String duracion = "1 x 15 Segundos por lado";
                    descripcionc1.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20mu%C3%B1ecas%2F20211210_111932(0).jpg?alt=media&token=d2f871ca-d0c8-43b5-8d49-e65b3e9e2e57")
                            .fit().centerCrop()
                            .into(calentamiento1);
                }


                //torso

                if (ejercicioseleccionado3.equals("Bird dogs")) {
                    String duracion = "1 x 10 Reps por lado";
                    descripcionc3.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbird%20dogs%2F20211210_111108.jpg?alt=media&token=3213739f-bfc0-4a4f-9426-324cb2c94c36")
                            .fit().centerCrop()
                            .into(calentamiento3);
                }

                if (ejercicioseleccionado3.equals("Dead bugs")) {
                    String duracion = "1 x 10 a 15 Reps por lado";
                    descripcionc3.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fdead%20bugs%2Fdead2.jpg?alt=media&token=7490789c-854c-435a-8c4e-5c31609af78f")
                            .fit().centerCrop()
                            .into(calentamiento3);
                }


                if (ejercicioseleccionado3.equals("Db Cuban press")) {
                    String duracion = "1 x 10 a 15 Reps con peso ligero";
                    descripcionc3.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fcuban%20press%2F20211210_111532.jpg?alt=media&token=c26970f7-9d71-41c7-8fda-631312678a8c")
                            .fit().centerCrop()
                            .into(calentamiento3);
                }

                if (ejercicioseleccionado3.equals("Rotación externa de hombro con mancuernas pegado al cuerpo")) {
                    String duracion = "1 x 10 a 20 Reps por lado";
                    descripcionc3.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20externa%20de%20hombro%20con%20mancuerna%20pegado%20al%20cuerpo%2FIMG_0321.jpg?alt=media&token=3f9e4fda-ae04-4ccc-ab03-920cf317227d")
                            .fit().centerCrop()
                            .into(calentamiento3);
                }

                if (ejercicioseleccionado3.equals("Rotación externa de hombro con cable pegado al cuerpo")) {
                    String duracion = "1 x 10 a 20 Reps por lado";
                    descripcionc3.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fcable%20shoulder%20extensions%2F20211210_112233.jpg?alt=media&token=5650b9b9-b746-41ac-9a92-7a59b8b402b6")
                            .fit().centerCrop()
                            .into(calentamiento3);
                }

                if (ejercicioseleccionado3.equals("Aducciones de hombro")) {
                    String duracion = "1 x 10 a 20 Reps por lado";
                    descripcionc3.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Faducciones%20de%20hombro%2F20210131_102756.jpg?alt=media&token=92b87167-04fe-432a-bd7e-c5039b37137e")
                            .fit().centerCrop()
                            .into(calentamiento3);
                }

                if (ejercicioseleccionado3.equals("Rotación de hombros con brazos extendidos")) {
                    String duracion = "1 x 15 segundos";
                    descripcionc3.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20hombro%20con%20brazos%20extendidos%2F20210131_102918.jpg?alt=media&token=76dcffbd-da68-4f50-83fd-d175aa408177")
                            .fit().centerCrop()
                            .into(calentamiento3);
                }

                if (ejercicioseleccionado3.equals("Rotación de hombro")) {
                    String duracion = "1 x 15 Segundos por lado";
                    descripcionc3.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20hombro%2F20210131_102731.jpg?alt=media&token=f2567083-f710-487a-861c-0fe72e6be6ef")
                            .fit().centerCrop()
                            .into(calentamiento3);
                }

                if (ejercicioseleccionado3.equals("Rotación de muñecas")) {
                    String duracion = "1 x 15 Segundos por lado";
                    descripcionc3.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20mu%C3%B1ecas%2F20211210_111932(0).jpg?alt=media&token=d2f871ca-d0c8-43b5-8d49-e65b3e9e2e57")
                            .fit().centerCrop()
                            .into(calentamiento3);
                }



//tren inferior


                if (ejercicioseleccionado2.equals("Goblet squat")) {
                    String duracion = "1 x 10 a 20 Reps";
                    descripcionc2.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgoblet%20squat%2F20211210_111428.jpg?alt=media&token=a8cb7d1d-d535-4868-b03b-f443a1e70a87")
                            .fit().centerCrop()
                            .into(calentamiento2);
                }


                if (ejercicioseleccionado2.equals("Tall Kneeling Glute Activation")) {
                    String duracion = "1 x 10 a 20 Reps";
                    descripcionc2.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Ftall%20kneeling%20glute%20activation%2F20211210_111815.jpg?alt=media&token=f846794f-17fa-42ef-8929-1b346311e242")
                            .fit().centerCrop()
                            .into(calentamiento2);
                }

                if (ejercicioseleccionado2.equals("Mountain climber stretch dynamic")) {
                    String duracion = "1 x 10 Reps por lado";
                    descripcionc2.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fmountain%20climber%20stretch%20dynamic%2F20211210_112013.jpg?alt=media&token=d78da0f9-e228-48c0-8d9a-bda3ee2b1e62")
                            .fit().centerCrop()
                            .into(calentamiento2);
                }

                if (ejercicioseleccionado2.equals("Balanceo de pierna")) {
                    String duracion = "1 x 10 a 15 Reps por lado";
                    descripcionc2.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbalanceo%20de%20pierna%2F20210131_102221.jpg?alt=media&token=5c18296d-d556-443d-a5a7-16624b046cf0")
                            .fit().centerCrop()
                            .into(calentamiento2);
                }

                if (ejercicioseleccionado2.equals("Desplantes sin peso")) {
                    String duracion = "1 x 10 a 15 Reps por lado";
                    descripcionc2.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fdesplantes%20sin%20peso%2F20210131_102449.jpg?alt=media&token=695a261f-d094-4fbb-8d2a-e56acdb81ca0")
                            .fit().centerCrop()
                            .into(calentamiento2);
                }

                if (ejercicioseleccionado2.equals("Gatos-Camello")) {
                    String duracion = "1 x 10 a 15 Reps";
                    descripcionc2.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgatos-camello%2F20210131_102558.jpg?alt=media&token=a3063a35-0d14-4724-9e3a-c96fa06cab8f")
                            .fit().centerCrop()
                            .into(calentamiento2);
                }

                if (ejercicioseleccionado2.equals("Rotación de tobillos")) {
                    String duracion = "1 x 15 Segundos por lado";
                    descripcionc2.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20tobillos%2F20210131_102140.jpg?alt=media&token=7dc133bd-5039-49f4-b5e7-48116afdd70b")
                            .fit().centerCrop()
                            .into(calentamiento2);
                }

                if (ejercicioseleccionado2.equals("Elevación de piernas acostado")) {
                    String duracion = "1 x 10 a 15 Reps por lado";
                    descripcionc2.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Felevaci%C3%B3n%20de%20pierna%20acostado%2F20210131_102358.jpg?alt=media&token=f3e31cc9-f9d1-4819-af22-a3e6858adc84")
                            .fit().centerCrop()
                            .into(calentamiento2);
                }


                if (ejercicioseleccionado2.equals("Puentes acostado")) {
                    String duracion = "1 x 15 a 20 Reps";
                    descripcionc2.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fpuentes%20acostado%2F20210131_102317.jpg?alt=media&token=288e0826-6acd-4163-b93b-c7003416c68e")
                            .fit().centerCrop()
                            .into(calentamiento2);
                }



//tren inferior


                if (ejercicioseleccionado4.equals("Goblet squat")) {
                    String duracion = "1 x 10 a 20 Reps";
                    descripcionc4.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgoblet%20squat%2F20211210_111428.jpg?alt=media&token=a8cb7d1d-d535-4868-b03b-f443a1e70a87")
                            .fit().centerCrop()
                            .into(calentamiento4);
                }


                if (ejercicioseleccionado4.equals("Tall Kneeling Glute Activation")) {
                    String duracion = "1 x 10 a 20 Reps";
                    descripcionc4.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Ftall%20kneeling%20glute%20activation%2F20211210_111815.jpg?alt=media&token=f846794f-17fa-42ef-8929-1b346311e242")
                            .fit().centerCrop()
                            .into(calentamiento4);
                }

                if (ejercicioseleccionado4.equals("Mountain climber stretch dynamic")) {
                    String duracion = "1 x 10 Reps por lado";
                    descripcionc4.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fmountain%20climber%20stretch%20dynamic%2F20211210_112013.jpg?alt=media&token=d78da0f9-e228-48c0-8d9a-bda3ee2b1e62")
                            .fit().centerCrop()
                            .into(calentamiento4);
                }

                if (ejercicioseleccionado4.equals("Balanceo de pierna")) {
                    String duracion = "1 x 10 a 15 Reps por lado";
                    descripcionc4.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbalanceo%20de%20pierna%2F20210131_102221.jpg?alt=media&token=5c18296d-d556-443d-a5a7-16624b046cf0")
                            .fit().centerCrop()
                            .into(calentamiento4);
                }

                if (ejercicioseleccionado4.equals("Desplantes sin peso")) {
                    String duracion = "1 x 10 a 15 Reps por lado";
                    descripcionc4.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fdesplantes%20sin%20peso%2F20210131_102449.jpg?alt=media&token=695a261f-d094-4fbb-8d2a-e56acdb81ca0")
                            .fit().centerCrop()
                            .into(calentamiento4);
                }

                if (ejercicioseleccionado4.equals("Gatos-Camello")) {
                    String duracion = "1 x 10 a 15 Reps";
                    descripcionc4.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgatos-camello%2F20210131_102558.jpg?alt=media&token=a3063a35-0d14-4724-9e3a-c96fa06cab8f")
                            .fit().centerCrop()
                            .into(calentamiento4);
                }

                if (ejercicioseleccionado4.equals("Rotación de tobillos")) {
                    String duracion = "1 x 15 Segundos por lado";
                    descripcionc4.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20tobillos%2F20210131_102140.jpg?alt=media&token=7dc133bd-5039-49f4-b5e7-48116afdd70b")
                            .fit().centerCrop()
                            .into(calentamiento4);
                }

                if (ejercicioseleccionado4.equals("Elevación de piernas acostado")) {
                    String duracion = "1 x 10 a 15 Reps por lado";
                    descripcionc4.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Felevaci%C3%B3n%20de%20pierna%20acostado%2F20210131_102358.jpg?alt=media&token=f3e31cc9-f9d1-4819-af22-a3e6858adc84")
                            .fit().centerCrop()
                            .into(calentamiento4);
                }


                if (ejercicioseleccionado4.equals("Puentes acostado")) {
                    String duracion = "1 x 15 a 20 Reps";
                    descripcionc4.setText(duracion);
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fpuentes%20acostado%2F20210131_102317.jpg?alt=media&token=288e0826-6acd-4163-b93b-c7003416c68e")
                            .fit().centerCrop()
                            .into(calentamiento4);
                }


















            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }




    public void calentamientoopcion1(View view) {


        Intent intent = new Intent(calentamiento.this, bibliotecadeejercicios.class);

        startActivity(intent);
        finish();

    }


    public void calentamientoopcion2(View view) {
        Intent intent = new Intent(calentamiento.this, bibliotecadeejercicios.class);

        startActivity(intent);
        finish();


    }

    public void calentamientoopcion3(View view) {
        Intent intent = new Intent(calentamiento.this, bibliotecadeejercicios.class);

        startActivity(intent);
        finish();

    }

    public void calentamientoopcion4(View view) {
        Intent intent = new Intent(calentamiento.this, bibliotecadeejercicios.class);

        startActivity(intent);
        finish();

    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
            //    onDestroy();
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onDestroy() { super.onDestroy(); }

}
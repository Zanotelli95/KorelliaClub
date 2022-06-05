package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class entreno6diamartes extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private EditText pesoespalda, pesobiceps,  pesolateral, pesotrapecios,  pesolateral2, pesolateral3;
    private String ejercicioseleccionadoespalda, ejercicioseleccionadobiceps,
          ejercicioseleccionadolateral,  ejercicioseleccionadotraps;
    private TextView rer1, rer2, rer3, rer4, rer5, rer6, rer7, rer8, rer9, rer10, rer11, rer12, rer13, rer14;
    private String  ejercicioseleccionadolateral2, ejercicioseleccionadolateral3;
    private TextView fechacompleta;
    private TextView seriesespalda, seriesbiceps, serieslateral, seriestraps;
    private Spinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8, spinner9, spinner10, spinner11, spinner12, spinner13, spinner14;
    private  TextView ejercicioespalda, repeticionesespalda, ejerciciobiceps, repeticionesbiceps, ejerciciolateral, repeticioneslateral, ejerciciotrapecios, repeticionestrapecios;
    private ImageView  imagenlaterales, imagenlaterales2, imagenlaterales3,
            imagenespalda, imagenbiceps, imagentrapecios;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private TextView ejercicioespalda2, ejercicioespalda3, ejercicioespalda4, ejerciciobiceps2, repeticionesbiceps3, repeticionesbiceps4,
            repeticionesespalda2, repeticionesespalda3, repeticionesespalda4, repeticioneslateral2, repeticioneslateral3,
            ejerciciobiceps3, ejerciciobiceps4, ejerciciolateral2, ejerciciolateral3, ejerciciotrapecios2 ,ejerciciotrapecios3;
    private TextView seriesespalda2, seriesbiceps3, seriesespalda3, seriesespalda4, seriesbiceps4, seriesbiceps2, serieslateral2, serieslateral3, seriestraps2,
            seriestraps3, repeticionestrapecios2, repeticionestrapecios3, repeticionesbiceps2;
    private ImageView imagentrapecios3, imagenbiceps4, imagentrapecios2,imagenbiceps2, imagenbiceps3, imagenespalda2, imagenespalda3, imagenespalda4;
    private EditText pesoespalda2, pesoespalda3, pesoespalda4, pesobiceps2, pesobiceps3, pesobiceps4, pesotrapecios2;
    private EditText pesotrapecios3;
    private String ejercicioseleccionadobiceps2, ejercicioseleccionadobiceps3, ejercicioseleccionadobiceps4;
    private String ejercicioseleccionadoespalda2, ejercicioseleccionadoespalda3, ejercicioseleccionadoespalda4, ejercicioseleccionadotraps2, ejercicioseleccionadotraps3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_entreno6diamartes);

        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this,"ca-app-pub-7204318393811470/3163516125", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("TAG", loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });

        fechacompleta = (TextView) findViewById(R.id.textView280);
        Date date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("d MMM yyyy");
        String sfecha = fecha.format(date);
        fechacompleta.setText(sfecha);


        Toolbar toolbar = findViewById(R.id.toolbarentreno6diamartes);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Entrenamiento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        spinner1 = (Spinner) findViewById(R.id.spinner1m2);
        spinner2 = (Spinner) findViewById(R.id.spinner2m2);
        spinner3 = (Spinner) findViewById(R.id.spinner3m2);
        spinner4 = (Spinner) findViewById(R.id.spinner4m2);

        spinner5 = (Spinner) findViewById(R.id.spinner5m2);
        spinner6 = (Spinner) findViewById(R.id.spinner6m2);
        spinner7 = (Spinner) findViewById(R.id.spinner7m2);
        spinner8 = (Spinner) findViewById(R.id.spinner8m2);

        spinner9 = (Spinner) findViewById(R.id.spinner9m2);
        spinner10 = (Spinner) findViewById(R.id.spinner10m2);
        spinner11 = (Spinner) findViewById(R.id.spinner11m2);

        spinner12 = (Spinner) findViewById(R.id.spinner12m2);
        spinner13 = (Spinner) findViewById(R.id.spinner13m2);
        spinner14 = (Spinner) findViewById(R.id.spinner14m2);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner1.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner2.setAdapter(adapter2);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner3.setAdapter(adapter3);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner4.setAdapter(adapter4);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner5.setAdapter(adapter5);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner6.setAdapter(adapter6);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner7.setAdapter(adapter7);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner8.setAdapter(adapter8);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner9.setAdapter(adapter9);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner10.setAdapter(adapter10);
        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner11.setAdapter(adapter11);
        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner12.setAdapter(adapter12);
        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner13.setAdapter(adapter13);
        ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner14.setAdapter(adapter14);


        rer1 = findViewById(R.id.rere1espaldaentreno6diamartes);
        rer2 = findViewById(R.id.rer2espaldaentreno6diamartes);
        rer3 = findViewById(R.id.rer3espaldaentreno6diamartes);
        rer4 = findViewById(R.id.rer4espaldaentreno6diamartes);

        rer5 = findViewById(R.id.rer1bicepsentreno6diamartes);
        rer6 = findViewById(R.id.rer2bicepsentreno6diamartes);
        rer7 = findViewById(R.id.rer3bicepsentreno6diamartes);
        rer8 = findViewById(R.id.rer4bicepsentreno6diamartes);

        rer9 = findViewById(R.id.rer1lateralentreno6diamartes);
        rer10 = findViewById(R.id.rer2lateralentreno6diamartes);
        rer11 = findViewById(R.id.rer3lateralentreno6diamartes);

        rer12 = findViewById(R.id.rer1trapsentreno6diamartes);
        rer13 = findViewById(R.id.rer2trapsentreno6diamartes);
        rer14 = findViewById(R.id.rer3trapsentreno6diamartes);


        //espalda 4
        ejercicioespalda = (TextView) findViewById(R.id.nombreespaldaentreno6diamartes);
        repeticionesespalda = (TextView) findViewById(R.id.repes1espaldaentreno6diamartes);
        imagenespalda = (ImageView) findViewById(R.id.imagen1espaldaentreno6diamartes);
        pesoespalda = (EditText) findViewById(R.id.peso1espaldaentreno6diamartes);
        seriesespalda = (TextView) findViewById(R.id.series1espaldaentreno6diamartes);

        ejercicioespalda2 = (TextView) findViewById(R.id.nombre2espaldaentreno6diamartes);
        repeticionesespalda2 = (TextView) findViewById(R.id.repes2espaldaentreno6diamartes);
        imagenespalda2 = (ImageView) findViewById(R.id.imagen2espaldaentreno6diamartes);
        pesoespalda2 = (EditText) findViewById(R.id.peso2espaldaentreno6diamartes);
        seriesespalda2 = (TextView) findViewById(R.id.series2espaldaentreno6diamartes);

        ejercicioespalda3 = (TextView) findViewById(R.id.nombre3espaldaentreno6diamartes);
        repeticionesespalda3 = (TextView) findViewById(R.id.repes3espaldaentreno6diamartes);
        imagenespalda3 = (ImageView) findViewById(R.id.imagen3espaldaentreno6diamartes);
        pesoespalda3 = (EditText) findViewById(R.id.peso3espaldaentreno6diamartes);
        seriesespalda3 = (TextView) findViewById(R.id.series3espaldaentreno6diamartes);

        ejercicioespalda4 = (TextView) findViewById(R.id.nombre4espaldaentreno6diamartes);
        repeticionesespalda4 = (TextView) findViewById(R.id.repes4espaldaentreno6diamartes);
        imagenespalda4 = (ImageView) findViewById(R.id.imagen4espaldaentreno6diamartes);
        pesoespalda4 = (EditText) findViewById(R.id.peso4espaldaentreno6diamartes);
        seriesespalda4 = (TextView) findViewById(R.id.series4espaldaentreno6diamartes);


        //biceps 4
        ejerciciobiceps = (TextView) findViewById(R.id.nombre1bicepsentreno6diamartes);
        repeticionesbiceps = (TextView) findViewById(R.id.repes1bicepsentreno6diamartes);
        imagenbiceps = (ImageView) findViewById(R.id.imagen1bicepsentreno6diamartes);
        pesobiceps = (EditText) findViewById(R.id.peso1bicepsentreno6diamartes);
        seriesbiceps = (TextView) findViewById(R.id.series1bicepsentreno6diamartes);

        ejerciciobiceps2 = (TextView) findViewById(R.id.nombre2bicepsentreno6diamartes);
        repeticionesbiceps2 = (TextView) findViewById(R.id.repes2bicepsentreno6diamartes);
        imagenbiceps2 = (ImageView) findViewById(R.id.imagen2bicepsentreno6diamartes);
        pesobiceps2 = (EditText) findViewById(R.id.peso2bicepsentreno6diamartes);
        seriesbiceps2 = (TextView) findViewById(R.id.series2bicepsentreno6diamartes);

        ejerciciobiceps3 = (TextView) findViewById(R.id.nombre3bicepsentreno6diamartes);
        repeticionesbiceps3 = (TextView) findViewById(R.id.repes3bicepsentreno6diamartes);
        imagenbiceps3 = (ImageView) findViewById(R.id.imagen3bicepsentreno6diamartes);
        pesobiceps3 = (EditText) findViewById(R.id.peso3bicepsentreno6diamartes);
        seriesbiceps3 = (TextView) findViewById(R.id.series3bicepsentreno6diamartes);

        ejerciciobiceps4 = (TextView) findViewById(R.id.nombre4bicepsentreno6diamartes);
        repeticionesbiceps4 = (TextView) findViewById(R.id.repes4bicepsentreno6diamartes);
        imagenbiceps4 = (ImageView) findViewById(R.id.imagen4bicepsentreno6diamartes);
        pesobiceps4 = (EditText) findViewById(R.id.peso4bicepsentreno6diamartes);
        seriesbiceps4 = (TextView) findViewById(R.id.series4bicepsentreno6diamartes);


        //laterales 3
        ejerciciolateral = (TextView) findViewById(R.id.nombre1lateralentreno6diamartes);
        repeticioneslateral = (TextView) findViewById(R.id.repes1lateralentreno6diamartes);
        imagenlaterales = (ImageView) findViewById(R.id.imagen1lateralentreno6diamartes);
        pesolateral = (EditText) findViewById(R.id.peso1lateralentreno6diamartes);
        serieslateral = (TextView) findViewById(R.id.series1lateralentreno6diamartes);

        ejerciciolateral2 = (TextView) findViewById(R.id.nombre2lateralentreno6diamartes);
        repeticioneslateral2 = (TextView) findViewById(R.id.repes2lateralentreno6diamartes);
        imagenlaterales2 = (ImageView) findViewById(R.id.imagen2lateralentreno6diamartes);
        pesolateral2 = (EditText) findViewById(R.id.peso2lateralentreno6diamartes);
        serieslateral2 = (TextView) findViewById(R.id.series2lateralentreno6diamartes);

        ejerciciolateral3 = (TextView) findViewById(R.id.nombre3lateralentreno6diamartes);
        repeticioneslateral3 = (TextView) findViewById(R.id.repes3lateralentreno6diamartes);
        imagenlaterales3 = (ImageView) findViewById(R.id.imagen3lateralentreno6diamartes);
        pesolateral3 = (EditText) findViewById(R.id.peso3lateralentreno6diamartes);
        serieslateral3 = (TextView) findViewById(R.id.series3lateralentreno6diamartes);



        //trapecios 3
        ejerciciotrapecios = (TextView) findViewById(R.id.nombre1trapsentreno6diamartes);
        repeticionestrapecios = (TextView) findViewById(R.id.repes1trapsentreno6diamartes);
        imagentrapecios = (ImageView) findViewById(R.id.imagen1trapsentreno6diamartes);
        pesotrapecios = (EditText) findViewById(R.id.peso1trapsentreno6diamartes);
        seriestraps = (TextView) findViewById(R.id.series1trapsentreno6diamartes);

        ejerciciotrapecios2 = (TextView) findViewById(R.id.nombre2trapsentreno6diamartes);
        repeticionestrapecios2 = (TextView) findViewById(R.id.repes2trapsentreno6diamartes);
        imagentrapecios2 = (ImageView) findViewById(R.id.imagen2trapsentreno6diamartes);
        pesotrapecios2 = (EditText) findViewById(R.id.peso2trapsentreno6diamartes);
        seriestraps2 = (TextView) findViewById(R.id.series2trapsentreno6diamartes);

        ejerciciotrapecios3 = (TextView) findViewById(R.id.nombre3trapsentreno6diamartes);
        repeticionestrapecios3 = (TextView) findViewById(R.id.repes3entreno6diamartes);
        imagentrapecios3 = (ImageView) findViewById(R.id.imagen3trapsentreno6diamartes);
        pesotrapecios3 = (EditText) findViewById(R.id.peso3trapsentreno6diamartes);
        seriestraps3 = (TextView) findViewById(R.id.series3trapsentreno6diamartes);








        mAuth = FirebaseAuth.getInstance();

        //logicadelentrenamiento(ejercicios)





        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();





        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                if (datasnapshot.exists()) {

                    String ejercicio = datasnapshot.child("espalda/ ejercicio primario").getValue().toString();
                    ejercicioespalda.setText(ejercicio);
                    ejercicioseleccionadoespalda = ejercicio;

                    String ejercicio2 = datasnapshot.child("espalda/ ejercicio secundario").getValue().toString();
                    ejercicioespalda2.setText(ejercicio2);
                    ejercicioseleccionadoespalda2 = ejercicio2;

                    String ejercicio3 = datasnapshot.child("espalda/ ejercicio tercero").getValue().toString();
                    ejercicioespalda3.setText(ejercicio3);
                    ejercicioseleccionadoespalda3 = ejercicio3;

                    String stringejerciciofemoral= datasnapshot.child("espalda/ ejercicio cuarto").getValue().toString();
                    ejercicioespalda4.setText(stringejerciciofemoral);
                    ejercicioseleccionadoespalda4 = stringejerciciofemoral;



                    String stringejerciciotriceps = datasnapshot.child("biceps/ ejercicio primario").getValue().toString();
                    ejerciciobiceps.setText(stringejerciciotriceps);
                    ejercicioseleccionadobiceps = stringejerciciotriceps;

                    String stringejerciciofemoral3 = datasnapshot.child("biceps/ ejercicio secundario").getValue().toString();
                    ejerciciobiceps2.setText(stringejerciciofemoral3);
                    ejercicioseleccionadobiceps2 = stringejerciciofemoral3;

                    String stringejerciciobiceps = datasnapshot.child("biceps/ ejercicio tercero").getValue().toString();
                    ejerciciobiceps3.setText(stringejerciciobiceps);
                    ejercicioseleccionadobiceps3 = stringejerciciobiceps;

                    String stringejerciciobiceps2 = datasnapshot.child("biceps/ ejercicio cuarto").getValue().toString();
                    ejerciciobiceps4.setText(stringejerciciobiceps2);
                    ejercicioseleccionadobiceps4 = stringejerciciobiceps2;




                    String stringejerciciotricepsf = datasnapshot.child("deltoides laterales y posteriores/ ejercicio primario").getValue().toString();
                    ejerciciolateral.setText(stringejerciciotricepsf);
                    ejercicioseleccionadolateral = stringejerciciotricepsf;

                    String stringejerciciotriceps2 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio secundario").getValue().toString();
                    ejerciciolateral2.setText(stringejerciciotriceps2);
                    ejercicioseleccionadolateral2 = stringejerciciotriceps2;

                    String stringejerciciofrontal = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();
                    ejerciciolateral3.setText(stringejerciciofrontal);
                    ejercicioseleccionadolateral3 = stringejerciciofrontal;



                    String stringejerciciofrontal2 = datasnapshot.child("trapecios/ ejercicio primario").getValue().toString();
                    ejerciciotrapecios.setText(stringejerciciofrontal2);
                    ejercicioseleccionadotraps = stringejerciciofrontal2;

                    String stringejerciciotraps = datasnapshot.child("trapecios/ ejercicio secundario").getValue().toString();
                    ejerciciotrapecios2.setText(stringejerciciotraps);
                    ejercicioseleccionadotraps2 = stringejerciciotraps;

                    String stringejerciciotraps2 = datasnapshot.child("trapecios/ ejercicio tercero").getValue().toString();
                    ejerciciotrapecios3.setText(stringejerciciotraps2);
                    ejercicioseleccionadotraps3 = stringejerciciotraps2;


                }




                //espalda
                if (ejercicioseleccionadoespalda.equals("Dominadas")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fdominadas%2F20210206_111212.jpg?alt=media&token=f386a2a6-3d86-49fe-9a54-2a3af7aed772")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }


                if (ejercicioseleccionadoespalda.equals("Hiperextensiones de espalda baja")) {
                    int reps = 15;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fhiperextensiones%20de%20espalda%20en%20banco%2F20210220_122848(0).jpg?alt=media&token=73814040-ec25-4e37-bc37-c216e04fb912")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }

                if (ejercicioseleccionadoespalda.equals("Jalón frontal con agarre abierto")) {
                    int reps = 12;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20agarre%20abierto%2F20210309_114753.jpg?alt=media&token=22e93bd8-14bc-4d0c-9334-d6632177cd8c")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }


                if (ejercicioseleccionadoespalda.equals("Jalon frontal con triangulo")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20triangulo%2F20210306_115552.jpg?alt=media&token=1a46beab-baac-4b4e-a7d5-7d65b3bd9181")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }


                if (ejercicioseleccionadoespalda.equals("Pullover con cuerda")) {
                    int reps = 15;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20cuerda%2F20210309_192655.jpg?alt=media&token=65077967-f462-4761-84a2-5065cb8ad567")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }



                if (ejercicioseleccionadoespalda.equals("Remo a 1 mano con polea baja")) {
                    int reps = 12;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20a%201%20mano%20con%20polea%20baja%2F20210219_121002.jpg?alt=media&token=125ecf30-7f66-4de6-8b17-199e18fb905a")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }

                if (ejercicioseleccionadoespalda.equals("Remo con mancuerna a 1 brazo")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20con%20mancuerna%20a%201%20brazo%2F20210131_111215.jpg?alt=media&token=639b0747-09be-465c-aa49-2694c36d87bf")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }

                if (ejercicioseleccionadoespalda.equals("Remo en máquina agarre en pronación")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20agarre%20en%20pronacion%2F20210205_114828.jpg?alt=media&token=1e436109-0721-4bee-93fd-7af17dd3e4fd")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }


                if (ejercicioseleccionadoespalda.equals("Remo en máquina hammer")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20hammer%2F20210203_115946.jpg?alt=media&token=ccd18a99-b86b-4e61-8832-5f068da3cd93")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }

                if (ejercicioseleccionadoespalda.equals("Remo sentado en polea con triangulo")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20sentado%20en%20polea%20con%20triangulo%2F20210205_113845.jpg?alt=media&token=b7fe38d0-55b9-4ea5-b954-d4eb9fcf6f9b")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }

                if (ejercicioseleccionadoespalda.equals("Jalon frontal con agarre cerrado")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20cerrado%20con%20polea%20alta%2FIMG_0361.jpg?alt=media&token=b87f8de8-fb4f-4715-ae41-b44d1e772386")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }

                if (ejercicioseleccionadoespalda.equals("Pullover con mancuerna")) {
                    int reps = 6;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20mancuerna%2F20211215_111957.jpg?alt=media&token=42236c89-fe5b-428c-a8c3-dfd90a38eab8")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }


                if (ejercicioseleccionadoespalda.equals("Peso muerto convencional")) {
                    int reps = 6;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpeso%20muerto%20convencional%2F20211215_113104.jpg?alt=media&token=31966e27-2675-4af8-982d-7a6357c5719f")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }

                if (ejercicioseleccionadoespalda.equals("Remo horizontal con barra")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20con%20barra%2F20211211_140452.jpg?alt=media&token=11a3cc3d-6295-4816-afb5-92c40c947a5e")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }

                if (ejercicioseleccionadoespalda.equals("Remo horizontal con smith")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20en%20smith%2F20211211_135827.jpg?alt=media&token=4224d3f7-5719-40c8-88b4-f60630d7ddc9")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }


                if (ejercicioseleccionadoespalda.equals("Remo pendlay")) {
                    int reps = 6;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20pendlay%2F20211211_140328.jpg?alt=media&token=aa816af9-2105-42a3-9b2b-2a225a057a70")
                            .fit().centerCrop()
                            .into(imagenespalda);
                }







                //espalda
                if (ejercicioseleccionadoespalda2.equals("Dominadas")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fdominadas%2F20210206_111212.jpg?alt=media&token=f386a2a6-3d86-49fe-9a54-2a3af7aed772")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }


                if (ejercicioseleccionadoespalda2.equals("Hiperextensiones de espalda baja")) {
                    int reps = 15;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fhiperextensiones%20de%20espalda%20en%20banco%2F20210220_122848(0).jpg?alt=media&token=73814040-ec25-4e37-bc37-c216e04fb912")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }

                if (ejercicioseleccionadoespalda2.equals("Jalón frontal con agarre abierto")) {
                    int reps = 12;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20agarre%20abierto%2F20210309_114753.jpg?alt=media&token=22e93bd8-14bc-4d0c-9334-d6632177cd8c")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }


                if (ejercicioseleccionadoespalda2.equals("Jalon frontal con triangulo")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20triangulo%2F20210306_115552.jpg?alt=media&token=1a46beab-baac-4b4e-a7d5-7d65b3bd9181")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }


                if (ejercicioseleccionadoespalda2.equals("Pullover con cuerda")) {
                    int reps = 15;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20cuerda%2F20210309_192655.jpg?alt=media&token=65077967-f462-4761-84a2-5065cb8ad567")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }



                if (ejercicioseleccionadoespalda2.equals("Remo a 1 mano con polea baja")) {
                    int reps = 12;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20a%201%20mano%20con%20polea%20baja%2F20210219_121002.jpg?alt=media&token=125ecf30-7f66-4de6-8b17-199e18fb905a")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }

                if (ejercicioseleccionadoespalda2.equals("Remo con mancuerna a 1 brazo")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20con%20mancuerna%20a%201%20brazo%2F20210131_111215.jpg?alt=media&token=639b0747-09be-465c-aa49-2694c36d87bf")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }

                if (ejercicioseleccionadoespalda2.equals("Remo en máquina agarre en pronación")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20agarre%20en%20pronacion%2F20210205_114828.jpg?alt=media&token=1e436109-0721-4bee-93fd-7af17dd3e4fd")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }


                if (ejercicioseleccionadoespalda2.equals("Remo en máquina hammer")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20hammer%2F20210203_115946.jpg?alt=media&token=ccd18a99-b86b-4e61-8832-5f068da3cd93")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }

                if (ejercicioseleccionadoespalda2.equals("Remo sentado en polea con triangulo")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20sentado%20en%20polea%20con%20triangulo%2F20210205_113845.jpg?alt=media&token=b7fe38d0-55b9-4ea5-b954-d4eb9fcf6f9b")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }

                if (ejercicioseleccionadoespalda2.equals("Jalon frontal con agarre cerrado")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20cerrado%20con%20polea%20alta%2FIMG_0361.jpg?alt=media&token=b87f8de8-fb4f-4715-ae41-b44d1e772386")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }

                if (ejercicioseleccionadoespalda2.equals("Pullover con mancuerna")) {
                    int reps = 6;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20mancuerna%2F20211215_111957.jpg?alt=media&token=42236c89-fe5b-428c-a8c3-dfd90a38eab8")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }


                if (ejercicioseleccionadoespalda2.equals("Peso muerto convencional")) {
                    int reps = 6;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpeso%20muerto%20convencional%2F20211215_113104.jpg?alt=media&token=31966e27-2675-4af8-982d-7a6357c5719f")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }

                if (ejercicioseleccionadoespalda2.equals("Remo horizontal con barra")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20con%20barra%2F20211211_140452.jpg?alt=media&token=11a3cc3d-6295-4816-afb5-92c40c947a5e")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }

                if (ejercicioseleccionadoespalda2.equals("Remo horizontal con smith")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20en%20smith%2F20211211_135827.jpg?alt=media&token=4224d3f7-5719-40c8-88b4-f60630d7ddc9")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }


                if (ejercicioseleccionadoespalda2.equals("Remo pendlay")) {
                    int reps = 6;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda2.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20pendlay%2F20211211_140328.jpg?alt=media&token=aa816af9-2105-42a3-9b2b-2a225a057a70")
                            .fit().centerCrop()
                            .into(imagenespalda2);
                }




                //espalda
                if (ejercicioseleccionadoespalda3.equals("Dominadas")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fdominadas%2F20210206_111212.jpg?alt=media&token=f386a2a6-3d86-49fe-9a54-2a3af7aed772")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }


                if (ejercicioseleccionadoespalda3.equals("Hiperextensiones de espalda baja")) {
                    int reps = 15;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fhiperextensiones%20de%20espalda%20en%20banco%2F20210220_122848(0).jpg?alt=media&token=73814040-ec25-4e37-bc37-c216e04fb912")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }

                if (ejercicioseleccionadoespalda3.equals("Jalón frontal con agarre abierto")) {
                    int reps = 12;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20agarre%20abierto%2F20210309_114753.jpg?alt=media&token=22e93bd8-14bc-4d0c-9334-d6632177cd8c")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }


                if (ejercicioseleccionadoespalda3.equals("Jalon frontal con triangulo")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20triangulo%2F20210306_115552.jpg?alt=media&token=1a46beab-baac-4b4e-a7d5-7d65b3bd9181")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }


                if (ejercicioseleccionadoespalda3.equals("Pullover con cuerda")) {
                    int reps = 15;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20cuerda%2F20210309_192655.jpg?alt=media&token=65077967-f462-4761-84a2-5065cb8ad567")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }



                if (ejercicioseleccionadoespalda3.equals("Remo a 1 mano con polea baja")) {
                    int reps = 12;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20a%201%20mano%20con%20polea%20baja%2F20210219_121002.jpg?alt=media&token=125ecf30-7f66-4de6-8b17-199e18fb905a")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }

                if (ejercicioseleccionadoespalda3.equals("Remo con mancuerna a 1 brazo")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20con%20mancuerna%20a%201%20brazo%2F20210131_111215.jpg?alt=media&token=639b0747-09be-465c-aa49-2694c36d87bf")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }

                if (ejercicioseleccionadoespalda3.equals("Remo en máquina agarre en pronación")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20agarre%20en%20pronacion%2F20210205_114828.jpg?alt=media&token=1e436109-0721-4bee-93fd-7af17dd3e4fd")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }


                if (ejercicioseleccionadoespalda3.equals("Remo en máquina hammer")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20hammer%2F20210203_115946.jpg?alt=media&token=ccd18a99-b86b-4e61-8832-5f068da3cd93")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }

                if (ejercicioseleccionadoespalda3.equals("Remo sentado en polea con triangulo")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20sentado%20en%20polea%20con%20triangulo%2F20210205_113845.jpg?alt=media&token=b7fe38d0-55b9-4ea5-b954-d4eb9fcf6f9b")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }

                if (ejercicioseleccionadoespalda3.equals("Jalon frontal con agarre cerrado")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20cerrado%20con%20polea%20alta%2FIMG_0361.jpg?alt=media&token=b87f8de8-fb4f-4715-ae41-b44d1e772386")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }

                if (ejercicioseleccionadoespalda3.equals("Pullover con mancuerna")) {
                    int reps = 6;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20mancuerna%2F20211215_111957.jpg?alt=media&token=42236c89-fe5b-428c-a8c3-dfd90a38eab8")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }


                if (ejercicioseleccionadoespalda3.equals("Peso muerto convencional")) {
                    int reps = 6;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpeso%20muerto%20convencional%2F20211215_113104.jpg?alt=media&token=31966e27-2675-4af8-982d-7a6357c5719f")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }

                if (ejercicioseleccionadoespalda3.equals("Remo horizontal con barra")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20con%20barra%2F20211211_140452.jpg?alt=media&token=11a3cc3d-6295-4816-afb5-92c40c947a5e")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }

                if (ejercicioseleccionadoespalda3.equals("Remo horizontal con smith")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20en%20smith%2F20211211_135827.jpg?alt=media&token=4224d3f7-5719-40c8-88b4-f60630d7ddc9")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }


                if (ejercicioseleccionadoespalda3.equals("Remo pendlay")) {
                    int reps = 6;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda3.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20pendlay%2F20211211_140328.jpg?alt=media&token=aa816af9-2105-42a3-9b2b-2a225a057a70")
                            .fit().centerCrop()
                            .into(imagenespalda3);
                }


                //espalda
                if (ejercicioseleccionadoespalda4.equals("Dominadas")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fdominadas%2F20210206_111212.jpg?alt=media&token=f386a2a6-3d86-49fe-9a54-2a3af7aed772")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }


                if (ejercicioseleccionadoespalda4.equals("Hiperextensiones de espalda baja")) {
                    int reps = 15;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fhiperextensiones%20de%20espalda%20en%20banco%2F20210220_122848(0).jpg?alt=media&token=73814040-ec25-4e37-bc37-c216e04fb912")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }

                if (ejercicioseleccionadoespalda4.equals("Jalón frontal con agarre abierto")) {
                    int reps = 12;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20agarre%20abierto%2F20210309_114753.jpg?alt=media&token=22e93bd8-14bc-4d0c-9334-d6632177cd8c")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }


                if (ejercicioseleccionadoespalda4.equals("Jalon frontal con triangulo")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20triangulo%2F20210306_115552.jpg?alt=media&token=1a46beab-baac-4b4e-a7d5-7d65b3bd9181")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }


                if (ejercicioseleccionadoespalda4.equals("Pullover con cuerda")) {
                    int reps = 15;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20cuerda%2F20210309_192655.jpg?alt=media&token=65077967-f462-4761-84a2-5065cb8ad567")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }



                if (ejercicioseleccionadoespalda4.equals("Remo a 1 mano con polea baja")) {
                    int reps = 12;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20a%201%20mano%20con%20polea%20baja%2F20210219_121002.jpg?alt=media&token=125ecf30-7f66-4de6-8b17-199e18fb905a")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }

                if (ejercicioseleccionadoespalda4.equals("Remo con mancuerna a 1 brazo")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20con%20mancuerna%20a%201%20brazo%2F20210131_111215.jpg?alt=media&token=639b0747-09be-465c-aa49-2694c36d87bf")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }

                if (ejercicioseleccionadoespalda4.equals("Remo en máquina agarre en pronación")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20agarre%20en%20pronacion%2F20210205_114828.jpg?alt=media&token=1e436109-0721-4bee-93fd-7af17dd3e4fd")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }


                if (ejercicioseleccionadoespalda4.equals("Remo en máquina hammer")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20hammer%2F20210203_115946.jpg?alt=media&token=ccd18a99-b86b-4e61-8832-5f068da3cd93")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }

                if (ejercicioseleccionadoespalda4.equals("Remo sentado en polea con triangulo")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20sentado%20en%20polea%20con%20triangulo%2F20210205_113845.jpg?alt=media&token=b7fe38d0-55b9-4ea5-b954-d4eb9fcf6f9b")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }

                if (ejercicioseleccionadoespalda4.equals("Jalon frontal con agarre cerrado")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20cerrado%20con%20polea%20alta%2FIMG_0361.jpg?alt=media&token=b87f8de8-fb4f-4715-ae41-b44d1e772386")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }

                if (ejercicioseleccionadoespalda4.equals("Pullover con mancuerna")) {
                    int reps = 6;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20mancuerna%2F20211215_111957.jpg?alt=media&token=42236c89-fe5b-428c-a8c3-dfd90a38eab8")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }


                if (ejercicioseleccionadoespalda4.equals("Peso muerto convencional")) {
                    int reps = 6;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpeso%20muerto%20convencional%2F20211215_113104.jpg?alt=media&token=31966e27-2675-4af8-982d-7a6357c5719f")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }

                if (ejercicioseleccionadoespalda4.equals("Remo horizontal con barra")) {
                    int reps = 8;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20con%20barra%2F20211211_140452.jpg?alt=media&token=11a3cc3d-6295-4816-afb5-92c40c947a5e")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }

                if (ejercicioseleccionadoespalda4.equals("Remo horizontal con smith")) {
                    int reps = 10;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20en%20smith%2F20211211_135827.jpg?alt=media&token=4224d3f7-5719-40c8-88b4-f60630d7ddc9")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }


                if (ejercicioseleccionadoespalda4.equals("Remo pendlay")) {
                    int reps = 6;
                    String repesespalda = Integer.toString(reps);
                    repeticionesespalda4.setText(repesespalda + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20pendlay%2F20211211_140328.jpg?alt=media&token=aa816af9-2105-42a3-9b2b-2a225a057a70")
                            .fit().centerCrop()
                            .into(imagenespalda4);
                }


                //biceps

                if (ejercicioseleccionadobiceps.equals("Curl concentrado a 1 brazo recargado en muslo")) {
                    int reps = 8;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20concentrado%20a%201%20brazo%20recargado%20en%20muslo%2F20210303_114507.jpg?alt=media&token=41766ccc-48e4-421e-be45-fa82beba8257")
                            .fit().centerCrop()
                            .into(imagenbiceps);
                }

                if (ejercicioseleccionadobiceps.equals("Curl de biceps a 90° con barra")) {
                    int reps = 10;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%2090%C2%B0%20con%20barra%2F20210224_120224.jpg?alt=media&token=39ce1ea5-bc73-4803-ae87-8bc35fa2ea5e")
                            .fit().centerCrop()
                            .into(imagenbiceps);
                }

                if (ejercicioseleccionadobiceps.equals("Curl de biceps acostado en banco inclinado")) {
                    int reps = 6;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20acostado%20en%20banco%20inclinado%2F20210131_105859.jpg?alt=media&token=4b0b61b2-fc8f-4a1c-90d7-c1613c4c7a8b")
                            .fit().centerCrop()
                            .into(imagenbiceps);
                }

                if (ejercicioseleccionadobiceps.equals("Curl de biceps alternado")) {
                    int reps = 8;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20alternado%2F20210131_105406.jpg?alt=media&token=70a4cc94-6c7c-4b29-9f3c-c4048898d032")
                            .fit().centerCrop()
                            .into(imagenbiceps);
                }

                if (ejercicioseleccionadobiceps.equals("Curl de biceps con barra z")) {
                    int reps = 10;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20barra%20z%2F20210131_103247.jpg?alt=media&token=204b5b72-eb11-4d57-8c8e-55642943fb8f")
                            .fit().centerCrop()
                            .into(imagenbiceps);
                }

                if (ejercicioseleccionadobiceps.equals("Curl de biceps con polea maneral recto")) {
                    int reps = 12;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20polea%20maneral%20recto%2F20210203_120717.jpg?alt=media&token=98a90865-53c5-4df4-8551-872e6ac66849")
                            .fit().centerCrop()
                            .into(imagenbiceps);
                }

                if (ejercicioseleccionadobiceps.equals("Curl de biceps en máquina")) {
                    int reps = 15;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20maquina%2F20210131_104013.jpg?alt=media&token=1c5845cd-1d67-4647-b2a1-80bd06bfb7fb")
                            .fit().centerCrop()
                            .into(imagenbiceps);
                }

                if (ejercicioseleccionadobiceps.equals("Curl de bíceps en predicador con mancuernas")) {
                    int reps = 8;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20predicador%20con%20mancuernas%2F20210306_112834.jpg?alt=media&token=c968f4fa-a132-4861-b6f3-5ebe1cea2882")
                            .fit().centerCrop()
                            .into(imagenbiceps);
                }

                if (ejercicioseleccionadobiceps.equals("Curl martillo con cuerda")) {
                    int reps = 12;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20cuerda%2F20210131_104948.jpg?alt=media&token=067d2853-afc8-4153-a2ea-ced6d9e7440a")
                            .fit().centerCrop()
                            .into(imagenbiceps);
                }

                if (ejercicioseleccionadobiceps.equals("Curl martillo con mancuernas")) {
                    int reps = 6;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20mancuernas%2F20210131_105535.jpg?alt=media&token=755313e9-1b5f-4978-a93e-0877a2014486")
                            .fit().centerCrop()
                            .into(imagenbiceps);
                }

                if (ejercicioseleccionadobiceps.equals("Curl predicador con barra z")) {
                    int reps = 10;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20predicador%20con%20barra%20z%2F20210303_120224.jpg?alt=media&token=39a615fc-fcdc-4f23-a676-1b417cf439c9")
                            .fit().centerCrop()
                            .into(imagenbiceps);
                }

                if (ejercicioseleccionadobiceps.equals("Curl spider con barra")) {
                    int reps = 12;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20barra%2F20210310_114726.jpg?alt=media&token=5a07fa45-3597-492c-bc24-d5b0d4f26bf3")
                            .fit().centerCrop()
                            .into(imagenbiceps);
                }

                if (ejercicioseleccionadobiceps.equals("Curl spider con mancuernas")) {
                    int reps = 15;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20mancuernas%2F20210303_113056.jpg?alt=media&token=5345fbf5-cd74-41b4-a2b3-53c8376ceb27")
                            .fit().centerCrop()
                            .into(imagenbiceps);
                }

                if (ejercicioseleccionadobiceps.equals("Curl martillo con barra romana")) {
                    int reps = 6;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20barra%20romana%2F20211211_134608.jpg?alt=media&token=91705f79-5119-4d58-bcac-e567f618b390")
                            .fit().centerCrop()
                            .into(imagenbiceps);
                }

                if (ejercicioseleccionadobiceps.equals("Curl de biceps con polea altura media a 1 brazo")) {
                    int reps = 15;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%201%20brazo%20con%20polea%20altura%20media%2F20211215_111010.jpg?alt=media&token=1fedfb25-dd3f-46f6-b7e7-ae210f38900f")
                            .fit().centerCrop()
                            .into(imagenbiceps);
                }

                //biceps

                if (ejercicioseleccionadobiceps2.equals("Curl concentrado a 1 brazo recargado en muslo")) {
                    int reps = 8;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps2.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20concentrado%20a%201%20brazo%20recargado%20en%20muslo%2F20210303_114507.jpg?alt=media&token=41766ccc-48e4-421e-be45-fa82beba8257")
                            .fit().centerCrop()
                            .into(imagenbiceps2);
                }

                if (ejercicioseleccionadobiceps2.equals("Curl de biceps a 90° con barra")) {
                    int reps = 10;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps2.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%2090%C2%B0%20con%20barra%2F20210224_120224.jpg?alt=media&token=39ce1ea5-bc73-4803-ae87-8bc35fa2ea5e")
                            .fit().centerCrop()
                            .into(imagenbiceps2);
                }

                if (ejercicioseleccionadobiceps2.equals("Curl de biceps acostado en banco inclinado")) {
                    int reps = 6;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps2.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20acostado%20en%20banco%20inclinado%2F20210131_105859.jpg?alt=media&token=4b0b61b2-fc8f-4a1c-90d7-c1613c4c7a8b")
                            .fit().centerCrop()
                            .into(imagenbiceps2);
                }

                if (ejercicioseleccionadobiceps2.equals("Curl de biceps alternado")) {
                    int reps = 8;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps2.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20alternado%2F20210131_105406.jpg?alt=media&token=70a4cc94-6c7c-4b29-9f3c-c4048898d032")
                            .fit().centerCrop()
                            .into(imagenbiceps2);
                }

                if (ejercicioseleccionadobiceps2.equals("Curl de biceps con barra z")) {
                    int reps = 10;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps2.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20barra%20z%2F20210131_103247.jpg?alt=media&token=204b5b72-eb11-4d57-8c8e-55642943fb8f")
                            .fit().centerCrop()
                            .into(imagenbiceps2);
                }

                if (ejercicioseleccionadobiceps2.equals("Curl de biceps con polea maneral recto")) {
                    int reps = 12;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps2.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20polea%20maneral%20recto%2F20210203_120717.jpg?alt=media&token=98a90865-53c5-4df4-8551-872e6ac66849")
                            .fit().centerCrop()
                            .into(imagenbiceps2);
                }

                if (ejercicioseleccionadobiceps2.equals("Curl de biceps en máquina")) {
                    int reps = 15;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps2.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20maquina%2F20210131_104013.jpg?alt=media&token=1c5845cd-1d67-4647-b2a1-80bd06bfb7fb")
                            .fit().centerCrop()
                            .into(imagenbiceps2);
                }

                if (ejercicioseleccionadobiceps2.equals("Curl de bíceps en predicador con mancuernas")) {
                    int reps = 8;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps2.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20predicador%20con%20mancuernas%2F20210306_112834.jpg?alt=media&token=c968f4fa-a132-4861-b6f3-5ebe1cea2882")
                            .fit().centerCrop()
                            .into(imagenbiceps2);
                }

                if (ejercicioseleccionadobiceps2.equals("Curl martillo con cuerda")) {
                    int reps = 12;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps2.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20cuerda%2F20210131_104948.jpg?alt=media&token=067d2853-afc8-4153-a2ea-ced6d9e7440a")
                            .fit().centerCrop()
                            .into(imagenbiceps2);
                }

                if (ejercicioseleccionadobiceps2.equals("Curl martillo con mancuernas")) {
                    int reps = 6;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps2.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20mancuernas%2F20210131_105535.jpg?alt=media&token=755313e9-1b5f-4978-a93e-0877a2014486")
                            .fit().centerCrop()
                            .into(imagenbiceps2);
                }

                if (ejercicioseleccionadobiceps2.equals("Curl predicador con barra z")) {
                    int reps = 10;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps2.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20predicador%20con%20barra%20z%2F20210303_120224.jpg?alt=media&token=39a615fc-fcdc-4f23-a676-1b417cf439c9")
                            .fit().centerCrop()
                            .into(imagenbiceps2);
                }

                if (ejercicioseleccionadobiceps2.equals("Curl spider con barra")) {
                    int reps = 12;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps2.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20barra%2F20210310_114726.jpg?alt=media&token=5a07fa45-3597-492c-bc24-d5b0d4f26bf3")
                            .fit().centerCrop()
                            .into(imagenbiceps2);
                }

                if (ejercicioseleccionadobiceps2.equals("Curl spider con mancuernas")) {
                    int reps = 15;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps2.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20mancuernas%2F20210303_113056.jpg?alt=media&token=5345fbf5-cd74-41b4-a2b3-53c8376ceb27")
                            .fit().centerCrop()
                            .into(imagenbiceps2);
                }

                if (ejercicioseleccionadobiceps2.equals("Curl martillo con barra romana")) {
                    int reps = 6;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps2.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20barra%20romana%2F20211211_134608.jpg?alt=media&token=91705f79-5119-4d58-bcac-e567f618b390")
                            .fit().centerCrop()
                            .into(imagenbiceps2);
                }

                if (ejercicioseleccionadobiceps2.equals("Curl de biceps con polea altura media a 1 brazo")) {
                    int reps = 15;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps2.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%201%20brazo%20con%20polea%20altura%20media%2F20211215_111010.jpg?alt=media&token=1fedfb25-dd3f-46f6-b7e7-ae210f38900f")
                            .fit().centerCrop()
                            .into(imagenbiceps2);
                }


                //biceps

                if (ejercicioseleccionadobiceps3.equals("Curl concentrado a 1 brazo recargado en muslo")) {
                    int reps = 8;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps3.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20concentrado%20a%201%20brazo%20recargado%20en%20muslo%2F20210303_114507.jpg?alt=media&token=41766ccc-48e4-421e-be45-fa82beba8257")
                            .fit().centerCrop()
                            .into(imagenbiceps3);
                }

                if (ejercicioseleccionadobiceps3.equals("Curl de biceps a 90° con barra")) {
                    int reps = 10;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps3.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%2090%C2%B0%20con%20barra%2F20210224_120224.jpg?alt=media&token=39ce1ea5-bc73-4803-ae87-8bc35fa2ea5e")
                            .fit().centerCrop()
                            .into(imagenbiceps3);
                }

                if (ejercicioseleccionadobiceps3.equals("Curl de biceps acostado en banco inclinado")) {
                    int reps = 6;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps3.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20acostado%20en%20banco%20inclinado%2F20210131_105859.jpg?alt=media&token=4b0b61b2-fc8f-4a1c-90d7-c1613c4c7a8b")
                            .fit().centerCrop()
                            .into(imagenbiceps3);
                }

                if (ejercicioseleccionadobiceps3.equals("Curl de biceps alternado")) {
                    int reps = 8;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps3.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20alternado%2F20210131_105406.jpg?alt=media&token=70a4cc94-6c7c-4b29-9f3c-c4048898d032")
                            .fit().centerCrop()
                            .into(imagenbiceps3);
                }

                if (ejercicioseleccionadobiceps3.equals("Curl de biceps con barra z")) {
                    int reps = 10;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps3.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20barra%20z%2F20210131_103247.jpg?alt=media&token=204b5b72-eb11-4d57-8c8e-55642943fb8f")
                            .fit().centerCrop()
                            .into(imagenbiceps3);
                }

                if (ejercicioseleccionadobiceps3.equals("Curl de biceps con polea maneral recto")) {
                    int reps = 12;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps3.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20polea%20maneral%20recto%2F20210203_120717.jpg?alt=media&token=98a90865-53c5-4df4-8551-872e6ac66849")
                            .fit().centerCrop()
                            .into(imagenbiceps3);
                }

                if (ejercicioseleccionadobiceps3.equals("Curl de biceps en máquina")) {
                    int reps = 15;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps3.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20maquina%2F20210131_104013.jpg?alt=media&token=1c5845cd-1d67-4647-b2a1-80bd06bfb7fb")
                            .fit().centerCrop()
                            .into(imagenbiceps3);
                }

                if (ejercicioseleccionadobiceps3.equals("Curl de bíceps en predicador con mancuernas")) {
                    int reps = 8;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps3.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20predicador%20con%20mancuernas%2F20210306_112834.jpg?alt=media&token=c968f4fa-a132-4861-b6f3-5ebe1cea2882")
                            .fit().centerCrop()
                            .into(imagenbiceps3);
                }

                if (ejercicioseleccionadobiceps3.equals("Curl martillo con cuerda")) {
                    int reps = 12;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps3.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20cuerda%2F20210131_104948.jpg?alt=media&token=067d2853-afc8-4153-a2ea-ced6d9e7440a")
                            .fit().centerCrop()
                            .into(imagenbiceps3);
                }

                if (ejercicioseleccionadobiceps3.equals("Curl martillo con mancuernas")) {
                    int reps = 6;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps3.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20mancuernas%2F20210131_105535.jpg?alt=media&token=755313e9-1b5f-4978-a93e-0877a2014486")
                            .fit().centerCrop()
                            .into(imagenbiceps3);
                }

                if (ejercicioseleccionadobiceps3.equals("Curl predicador con barra z")) {
                    int reps = 10;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps3.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20predicador%20con%20barra%20z%2F20210303_120224.jpg?alt=media&token=39a615fc-fcdc-4f23-a676-1b417cf439c9")
                            .fit().centerCrop()
                            .into(imagenbiceps3);
                }

                if (ejercicioseleccionadobiceps3.equals("Curl spider con barra")) {
                    int reps = 12;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps3.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20barra%2F20210310_114726.jpg?alt=media&token=5a07fa45-3597-492c-bc24-d5b0d4f26bf3")
                            .fit().centerCrop()
                            .into(imagenbiceps3);
                }

                if (ejercicioseleccionadobiceps3.equals("Curl spider con mancuernas")) {
                    int reps = 15;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps3.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20mancuernas%2F20210303_113056.jpg?alt=media&token=5345fbf5-cd74-41b4-a2b3-53c8376ceb27")
                            .fit().centerCrop()
                            .into(imagenbiceps3);
                }

                if (ejercicioseleccionadobiceps3.equals("Curl martillo con barra romana")) {
                    int reps = 6;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps3.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20barra%20romana%2F20211211_134608.jpg?alt=media&token=91705f79-5119-4d58-bcac-e567f618b390")
                            .fit().centerCrop()
                            .into(imagenbiceps3);
                }

                if (ejercicioseleccionadobiceps3.equals("Curl de biceps con polea altura media a 1 brazo")) {
                    int reps = 15;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps3.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%201%20brazo%20con%20polea%20altura%20media%2F20211215_111010.jpg?alt=media&token=1fedfb25-dd3f-46f6-b7e7-ae210f38900f")
                            .fit().centerCrop()
                            .into(imagenbiceps3);
                }

                //biceps

                if (ejercicioseleccionadobiceps4.equals("Curl concentrado a 1 brazo recargado en muslo")) {
                    int reps = 8;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps4.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20concentrado%20a%201%20brazo%20recargado%20en%20muslo%2F20210303_114507.jpg?alt=media&token=41766ccc-48e4-421e-be45-fa82beba8257")
                            .fit().centerCrop()
                            .into(imagenbiceps4);
                }

                if (ejercicioseleccionadobiceps4.equals("Curl de biceps a 90° con barra")) {
                    int reps = 10;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps4.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%2090%C2%B0%20con%20barra%2F20210224_120224.jpg?alt=media&token=39ce1ea5-bc73-4803-ae87-8bc35fa2ea5e")
                            .fit().centerCrop()
                            .into(imagenbiceps4);
                }

                if (ejercicioseleccionadobiceps4.equals("Curl de biceps acostado en banco inclinado")) {
                    int reps = 6;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps4.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20acostado%20en%20banco%20inclinado%2F20210131_105859.jpg?alt=media&token=4b0b61b2-fc8f-4a1c-90d7-c1613c4c7a8b")
                            .fit().centerCrop()
                            .into(imagenbiceps4);
                }

                if (ejercicioseleccionadobiceps4.equals("Curl de biceps alternado")) {
                    int reps = 8;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps4.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20alternado%2F20210131_105406.jpg?alt=media&token=70a4cc94-6c7c-4b29-9f3c-c4048898d032")
                            .fit().centerCrop()
                            .into(imagenbiceps4);
                }

                if (ejercicioseleccionadobiceps4.equals("Curl de biceps con barra z")) {
                    int reps = 10;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps4.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20barra%20z%2F20210131_103247.jpg?alt=media&token=204b5b72-eb11-4d57-8c8e-55642943fb8f")
                            .fit().centerCrop()
                            .into(imagenbiceps4);
                }

                if (ejercicioseleccionadobiceps4.equals("Curl de biceps con polea maneral recto")) {
                    int reps = 12;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps4.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20polea%20maneral%20recto%2F20210203_120717.jpg?alt=media&token=98a90865-53c5-4df4-8551-872e6ac66849")
                            .fit().centerCrop()
                            .into(imagenbiceps4);
                }

                if (ejercicioseleccionadobiceps4.equals("Curl de biceps en máquina")) {
                    int reps = 15;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps4.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20maquina%2F20210131_104013.jpg?alt=media&token=1c5845cd-1d67-4647-b2a1-80bd06bfb7fb")
                            .fit().centerCrop()
                            .into(imagenbiceps4);
                }

                if (ejercicioseleccionadobiceps4.equals("Curl de bíceps en predicador con mancuernas")) {
                    int reps = 8;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps4.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20predicador%20con%20mancuernas%2F20210306_112834.jpg?alt=media&token=c968f4fa-a132-4861-b6f3-5ebe1cea2882")
                            .fit().centerCrop()
                            .into(imagenbiceps4);
                }

                if (ejercicioseleccionadobiceps4.equals("Curl martillo con cuerda")) {
                    int reps = 12;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps4.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20cuerda%2F20210131_104948.jpg?alt=media&token=067d2853-afc8-4153-a2ea-ced6d9e7440a")
                            .fit().centerCrop()
                            .into(imagenbiceps4);
                }

                if (ejercicioseleccionadobiceps4.equals("Curl martillo con mancuernas")) {
                    int reps = 6;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps4.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20mancuernas%2F20210131_105535.jpg?alt=media&token=755313e9-1b5f-4978-a93e-0877a2014486")
                            .fit().centerCrop()
                            .into(imagenbiceps4);
                }

                if (ejercicioseleccionadobiceps4.equals("Curl predicador con barra z")) {
                    int reps = 10;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps4.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20predicador%20con%20barra%20z%2F20210303_120224.jpg?alt=media&token=39a615fc-fcdc-4f23-a676-1b417cf439c9")
                            .fit().centerCrop()
                            .into(imagenbiceps4);
                }

                if (ejercicioseleccionadobiceps4.equals("Curl spider con barra")) {
                    int reps = 12;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps4.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20barra%2F20210310_114726.jpg?alt=media&token=5a07fa45-3597-492c-bc24-d5b0d4f26bf3")
                            .fit().centerCrop()
                            .into(imagenbiceps4);
                }

                if (ejercicioseleccionadobiceps4.equals("Curl spider con mancuernas")) {
                    int reps = 15;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps4.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20mancuernas%2F20210303_113056.jpg?alt=media&token=5345fbf5-cd74-41b4-a2b3-53c8376ceb27")
                            .fit().centerCrop()
                            .into(imagenbiceps4);
                }

                if (ejercicioseleccionadobiceps4.equals("Curl martillo con barra romana")) {
                    int reps = 6;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps4.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20barra%20romana%2F20211211_134608.jpg?alt=media&token=91705f79-5119-4d58-bcac-e567f618b390")
                            .fit().centerCrop()
                            .into(imagenbiceps4);
                }

                if (ejercicioseleccionadobiceps4.equals("Curl de biceps con polea altura media a 1 brazo")) {
                    int reps = 15;
                    String repesbiceps = Integer.toString(reps);
                    repeticionesbiceps4.setText(repesbiceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%201%20brazo%20con%20polea%20altura%20media%2F20211215_111010.jpg?alt=media&token=1fedfb25-dd3f-46f6-b7e7-ae210f38900f")
                            .fit().centerCrop()
                            .into(imagenbiceps4);
                }


                //laterales
                if ( ejercicioseleccionadolateral.equals("Elevaciones laterales con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaciones%20laterales%20con%20mancuernas%2F20210131_105249.jpg?alt=media&token=2ffa2e63-ca3c-4b91-900d-2a3b938a3932")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }


                if ( ejercicioseleccionadolateral.equals("Elevación lateral con polea baja")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20polea%20baja%2F20210313_121731.jpg?alt=media&token=5248be4d-3506-4e15-8134-f5f4e06e2c8a")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejercicioseleccionadolateral.equals("Flys invertidos en peck deck")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20en%20peck%20deck%2Fflye3.jpg?alt=media&token=6c84d085-2518-4319-8e27-444114709d9f")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejercicioseleccionadolateral.equals("Remo al mentón con barra")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20barra%2Frem2.jpg?alt=media&token=d9843316-dd2f-43a3-a8a1-7f7168069624")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejercicioseleccionadolateral.equals("Remo al mentón con polea baja")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem3.jpg.jpg?alt=media&token=b302e29e-81ff-429f-9daa-56c84b18ce6d")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejercicioseleccionadolateral.equals("Elevación lateral con polea baja por detrás")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115743.jpg?alt=media&token=d75af285-55fc-499e-84cc-c13f86539e5c")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejercicioseleccionadolateral.equals("Elevación lateral con mancuernas acostado en banco inclinado de perfil")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120233.jpg?alt=media&token=a40ae582-7b39-4ccd-927b-d64da79c55b8")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejercicioseleccionadolateral.equals("Elevación lateral con mancuerna a 45°")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112606.jpg?alt=media&token=224d744f-9b85-4ea0-b50a-333667af2f9a")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejercicioseleccionadolateral.equals("Flys cruzados con poleas")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejercicioseleccionadolateral.equals("Flys agachado con mancuernas")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20agachados%2F20211210_120455.jpg?alt=media&token=3b398377-2569-4d55-9062-fb9e2011eaf5")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejercicioseleccionadolateral.equals("Facepull con cuerda")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120826.jpg?alt=media&token=dad7d426-1561-4435-aac6-7c7cf954eb73")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejercicioseleccionadolateral.equals("Remo al mentón con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20mancuernas%2F20211210_120546.jpg?alt=media&token=c2160078-997f-46da-8464-35955cd1f23e")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }


                //laterales
                if ( ejercicioseleccionadolateral2.equals("Elevaciones laterales con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaciones%20laterales%20con%20mancuernas%2F20210131_105249.jpg?alt=media&token=2ffa2e63-ca3c-4b91-900d-2a3b938a3932")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }


                if ( ejercicioseleccionadolateral2.equals("Elevación lateral con polea baja")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20polea%20baja%2F20210313_121731.jpg?alt=media&token=5248be4d-3506-4e15-8134-f5f4e06e2c8a")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if ( ejercicioseleccionadolateral2.equals("Flys invertidos en peck deck")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20en%20peck%20deck%2Fflye3.jpg?alt=media&token=6c84d085-2518-4319-8e27-444114709d9f")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if ( ejercicioseleccionadolateral2.equals("Remo al mentón con barra")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20barra%2Frem2.jpg?alt=media&token=d9843316-dd2f-43a3-a8a1-7f7168069624")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if ( ejercicioseleccionadolateral2.equals("Remo al mentón con polea baja")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem3.jpg.jpg?alt=media&token=b302e29e-81ff-429f-9daa-56c84b18ce6d")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if ( ejercicioseleccionadolateral2.equals("Elevación lateral con polea baja por detrás")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115743.jpg?alt=media&token=d75af285-55fc-499e-84cc-c13f86539e5c")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if ( ejercicioseleccionadolateral2.equals("Elevación lateral con mancuernas acostado en banco inclinado de perfil")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120233.jpg?alt=media&token=a40ae582-7b39-4ccd-927b-d64da79c55b8")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if ( ejercicioseleccionadolateral2.equals("Elevación lateral con mancuerna a 45°")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112606.jpg?alt=media&token=224d744f-9b85-4ea0-b50a-333667af2f9a")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if ( ejercicioseleccionadolateral2.equals("Flys cruzados con poleas")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if ( ejercicioseleccionadolateral2.equals("Flys agachado con mancuernas")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20agachados%2F20211210_120455.jpg?alt=media&token=3b398377-2569-4d55-9062-fb9e2011eaf5")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if ( ejercicioseleccionadolateral2.equals("Facepull con cuerda")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120826.jpg?alt=media&token=dad7d426-1561-4435-aac6-7c7cf954eb73")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if ( ejercicioseleccionadolateral2.equals("Remo al mentón con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20mancuernas%2F20211210_120546.jpg?alt=media&token=c2160078-997f-46da-8464-35955cd1f23e")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                //laterales
                if ( ejercicioseleccionadolateral3.equals("Elevaciones laterales con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaciones%20laterales%20con%20mancuernas%2F20210131_105249.jpg?alt=media&token=2ffa2e63-ca3c-4b91-900d-2a3b938a3932")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }


                if ( ejercicioseleccionadolateral3.equals("Elevación lateral con polea baja")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20polea%20baja%2F20210313_121731.jpg?alt=media&token=5248be4d-3506-4e15-8134-f5f4e06e2c8a")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if ( ejercicioseleccionadolateral3.equals("Flys invertidos en peck deck")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20en%20peck%20deck%2Fflye3.jpg?alt=media&token=6c84d085-2518-4319-8e27-444114709d9f")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if ( ejercicioseleccionadolateral3.equals("Remo al mentón con barra")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20barra%2Frem2.jpg?alt=media&token=d9843316-dd2f-43a3-a8a1-7f7168069624")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if ( ejercicioseleccionadolateral3.equals("Remo al mentón con polea baja")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem3.jpg.jpg?alt=media&token=b302e29e-81ff-429f-9daa-56c84b18ce6d")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if ( ejercicioseleccionadolateral3.equals("Elevación lateral con polea baja por detrás")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115743.jpg?alt=media&token=d75af285-55fc-499e-84cc-c13f86539e5c")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if ( ejercicioseleccionadolateral3.equals("Elevación lateral con mancuernas acostado en banco inclinado de perfil")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120233.jpg?alt=media&token=a40ae582-7b39-4ccd-927b-d64da79c55b8")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if ( ejercicioseleccionadolateral3.equals("Elevación lateral con mancuerna a 45°")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112606.jpg?alt=media&token=224d744f-9b85-4ea0-b50a-333667af2f9a")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if ( ejercicioseleccionadolateral3.equals("Flys cruzados con poleas")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if ( ejercicioseleccionadolateral3.equals("Flys agachado con mancuernas")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20agachados%2F20211210_120455.jpg?alt=media&token=3b398377-2569-4d55-9062-fb9e2011eaf5")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if ( ejercicioseleccionadolateral3.equals("Facepull con cuerda")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120826.jpg?alt=media&token=dad7d426-1561-4435-aac6-7c7cf954eb73")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if ( ejercicioseleccionadolateral3.equals("Remo al mentón con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20mancuernas%2F20211210_120546.jpg?alt=media&token=c2160078-997f-46da-8464-35955cd1f23e")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                //trapecios
                if ( ejercicioseleccionadotraps.equals("Encogimiento de hombros con mancuernas")) {
                    int reps = 12;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios.setText(repestraps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20mancuernas%2F20211210_121543.jpg?alt=media&token=8a1dbf84-71f0-4805-9c3c-8105245f1334")
                            .fit().centerCrop()
                            .into(imagentrapecios);
                }

                if ( ejercicioseleccionadotraps.equals("Encogimiento de hombros en smith por delante")) {
                    int reps = 10;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios.setText(repestraps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%2F20210313_122556.jpg?alt=media&token=b4c8eda0-ddeb-4106-b317-aef34b5cfb21")
                            .fit().centerCrop()
                            .into(imagentrapecios);
                }

                if ( ejercicioseleccionadotraps.equals("Encogimiento de hombros con barra por detrás")) {
                    int reps = 8;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios.setText(repestraps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20barra%20por%20detr%C3%A1s%2F20211210_121425.jpg?alt=media&token=a0c3e606-31d7-43d1-92b2-0667fdc3c141")
                            .fit().centerCrop()
                            .into(imagentrapecios);
                }

                if ( ejercicioseleccionadotraps.equals("Encogimiento de hombros con barra por delante")) {
                    int reps = 6;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios.setText(repestraps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombro%20con%20barra%20por%20delante%2F20211210_121406.jpg?alt=media&token=dda7a570-7923-4536-9e04-90f6ae75c125")
                            .fit().centerCrop()
                            .into(imagentrapecios);
                }

                if ( ejercicioseleccionadotraps.equals("Encogimiento de hombros con smith por detrás")) {
                    int reps = 10;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios.setText(repestraps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%20por%20detr%C3%A1s%2F20211210_121229.jpg?alt=media&token=0212d310-f21b-4e7f-a4d0-885e467c52ff")
                            .fit().centerCrop()
                            .into(imagentrapecios);
                }

                if ( ejercicioseleccionadotraps.equals("Paseo del granjero")) {
                    int reps = 20;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios.setText(repestraps + " Seg");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fpaseo%20del%20granjero%2F20211210_121740.jpg?alt=media&token=b6ce6f51-a478-4317-8363-44c56ba6483b")
                            .fit().centerCrop()
                            .into(imagentrapecios);
                }

                //trapecios
                if ( ejercicioseleccionadotraps2.equals("Encogimiento de hombros con mancuernas")) {
                    int reps = 12;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios2.setText(repestraps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20mancuernas%2F20211210_121543.jpg?alt=media&token=8a1dbf84-71f0-4805-9c3c-8105245f1334")
                            .fit().centerCrop()
                            .into(imagentrapecios2);
                }

                if ( ejercicioseleccionadotraps2.equals("Encogimiento de hombros en smith por delante")) {
                    int reps = 10;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios2.setText(repestraps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%2F20210313_122556.jpg?alt=media&token=b4c8eda0-ddeb-4106-b317-aef34b5cfb21")
                            .fit().centerCrop()
                            .into(imagentrapecios2);
                }

                if ( ejercicioseleccionadotraps2.equals("Encogimiento de hombros con barra por detrás")) {
                    int reps = 8;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios2.setText(repestraps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20barra%20por%20detr%C3%A1s%2F20211210_121425.jpg?alt=media&token=a0c3e606-31d7-43d1-92b2-0667fdc3c141")
                            .fit().centerCrop()
                            .into(imagentrapecios2);
                }

                if ( ejercicioseleccionadotraps2.equals("Encogimiento de hombros con barra por delante")) {
                    int reps = 6;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios2.setText(repestraps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombro%20con%20barra%20por%20delante%2F20211210_121406.jpg?alt=media&token=dda7a570-7923-4536-9e04-90f6ae75c125")
                            .fit().centerCrop()
                            .into(imagentrapecios2);
                }

                if ( ejercicioseleccionadotraps2.equals("Encogimiento de hombros con smith por detrás")) {
                    int reps = 10;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios2.setText(repestraps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%20por%20detr%C3%A1s%2F20211210_121229.jpg?alt=media&token=0212d310-f21b-4e7f-a4d0-885e467c52ff")
                            .fit().centerCrop()
                            .into(imagentrapecios2);
                }

                if ( ejercicioseleccionadotraps2.equals("Paseo del granjero")) {
                    int reps = 20;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios2.setText(repestraps + " Seg");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fpaseo%20del%20granjero%2F20211210_121740.jpg?alt=media&token=b6ce6f51-a478-4317-8363-44c56ba6483b")
                            .fit().centerCrop()
                            .into(imagentrapecios2);
                }


                //trapecios
                if ( ejercicioseleccionadotraps3.equals("Encogimiento de hombros con mancuernas")) {
                    int reps = 12;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios3.setText(repestraps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20mancuernas%2F20211210_121543.jpg?alt=media&token=8a1dbf84-71f0-4805-9c3c-8105245f1334")
                            .fit().centerCrop()
                            .into(imagentrapecios3);
                }

                if ( ejercicioseleccionadotraps3.equals("Encogimiento de hombros en smith por delante")) {
                    int reps = 10;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios3.setText(repestraps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%2F20210313_122556.jpg?alt=media&token=b4c8eda0-ddeb-4106-b317-aef34b5cfb21")
                            .fit().centerCrop()
                            .into(imagentrapecios3);
                }

                if ( ejercicioseleccionadotraps3.equals("Encogimiento de hombros con barra por detrás")) {
                    int reps = 8;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios3.setText(repestraps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20barra%20por%20detr%C3%A1s%2F20211210_121425.jpg?alt=media&token=a0c3e606-31d7-43d1-92b2-0667fdc3c141")
                            .fit().centerCrop()
                            .into(imagentrapecios3);
                }

                if ( ejercicioseleccionadotraps3.equals("Encogimiento de hombros con barra por delante")) {
                    int reps = 6;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios3.setText(repestraps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombro%20con%20barra%20por%20delante%2F20211210_121406.jpg?alt=media&token=dda7a570-7923-4536-9e04-90f6ae75c125")
                            .fit().centerCrop()
                            .into(imagentrapecios3);
                }

                if ( ejercicioseleccionadotraps3.equals("Encogimiento de hombros con smith por detrás")) {
                    int reps = 10;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios3.setText(repestraps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%20por%20detr%C3%A1s%2F20211210_121229.jpg?alt=media&token=0212d310-f21b-4e7f-a4d0-885e467c52ff")
                            .fit().centerCrop()
                            .into(imagentrapecios3);
                }

                if ( ejercicioseleccionadotraps3.equals("Paseo del granjero")) {
                    int reps = 20;
                    String repestraps = Integer.toString(reps);
                    repeticionestrapecios3.setText(repestraps + " Seg");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fpaseo%20del%20granjero%2F20211210_121740.jpg?alt=media&token=b6ce6f51-a478-4317-8363-44c56ba6483b")
                            .fit().centerCrop()
                            .into(imagentrapecios3);
                }






//-------------------------------------------------------------------------------------------------------------------------------------------------------------
                //RER

                String RER1 = datasnapshot.child("progresosrer").getValue().toString();
                int rer1int = Integer.parseInt(RER1);

                String ejercicioespalda = datasnapshot.child("espalda/ ejercicio primario").getValue().toString();
                String ejercicioespalda2 = datasnapshot.child("espalda/ ejercicio secundario").getValue().toString();
                String ejercicioespalda3 = datasnapshot.child("espalda/ ejercicio tercero").getValue().toString();
                String ejercicioespalda4 = datasnapshot.child("espalda/ ejercicio cuarto").getValue().toString();

                String ejerciciobiceps = datasnapshot.child("biceps/ ejercicio primario").getValue().toString();
                String ejerciciobiceps2 = datasnapshot.child("biceps/ ejercicio secundario").getValue().toString();
                String ejerciciobiceps3 = datasnapshot.child("biceps/ ejercicio tercero").getValue().toString();
                String ejerciciobiceps4 = datasnapshot.child("biceps/ ejercicio cuarto").getValue().toString();

                String ejerciciolateral = datasnapshot.child("deltoides laterales y posteriores/ ejercicio primario").getValue().toString();
                String ejerciciolateral2 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio secundario").getValue().toString();
                String ejerciciolateral3 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();


                String ejerciciotrapecios = datasnapshot.child("trapecios/ ejercicio primario").getValue().toString();
                String ejerciciotrapecios2 = datasnapshot.child("trapecios/ ejercicio secundario").getValue().toString();
                String ejerciciotrapecios3 = datasnapshot.child("trapecios/ ejercicio tercero").getValue().toString();




                //RER INICIAL 3 - 4 Y 2 - 3
                if(rer1int >= 18) {


                    //deltoides laterales
                    switch(ejerciciolateral){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer9.setText("3 - 4 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Facepull con cuerda":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer9.setText("2 - 3 RER");
                            break;

                    }

                    //deltoides laterales
                    switch(ejerciciolateral2){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer10.setText("3 - 4 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Facepull con cuerda":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer10.setText("2 - 3 RER");
                            break;

                    }

                    //deltoides laterales
                    switch(ejerciciolateral3){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer11.setText("3 - 4 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Facepull con cuerda":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer11.setText("2 - 3 RER");
                            break;

                    }





                    //TRAPECIOS
                    switch(ejerciciotrapecios){
                        //ejercicios compuestos
                        case "Encogimiento de hombros con mancuernas":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Encogimiento de hombros en smith por delante":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Encogimiento de hombros con barra por delante":
                            rer12.setText("3 - 4 RER");
                            break;



                        //ejercicios csimples
                        case "Paseo del granjero":
                            rer12.setText("-");
                            break;

                        case "Encogiminto de hombros con barra por detrás":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Encogimiento de hombros con smith por detrás":
                            rer12.setText("2 - 3 RER");
                            break;


                    }



                    //TRAPECIOS
                    switch(ejerciciotrapecios2){
                        //ejercicios compuestos
                        case "Encogimiento de hombros con mancuernas":
                            rer13.setText("3 - 4 RER");
                            break;

                        case "Encogimiento de hombros en smith por delante":
                            rer13.setText("3 - 4 RER");
                            break;

                        case "Encogimiento de hombros con barra por delante":
                            rer13.setText("3 - 4 RER");
                            break;



                        //ejercicios csimples
                        case "Paseo del granjero":
                            rer13.setText("-");
                            break;

                        case "Encogiminto de hombros con barra por detrás":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Encogimiento de hombros con smith por detrás":
                            rer13.setText("2 - 3 RER");
                            break;


                    }

                    //TRAPECIOS
                    switch(ejerciciotrapecios3){
                        //ejercicios compuestos
                        case "Encogimiento de hombros con mancuernas":
                            rer14.setText("3 - 4 RER");
                            break;

                        case "Encogimiento de hombros en smith por delante":
                            rer14.setText("3 - 4 RER");
                            break;

                        case "Encogimiento de hombros con barra por delante":
                            rer14.setText("3 - 4 RER");
                            break;



                        //ejercicios csimples
                        case "Paseo del granjero":
                            rer14.setText("-");
                            break;

                        case "Encogiminto de hombros con barra por detrás":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Encogimiento de hombros con smith por detrás":
                            rer14.setText("2 - 3 RER");
                            break;


                    }




                    //BICEPS
                    switch(ejerciciobiceps){
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer5.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl spider con barra":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer5.setText("2 - 3 RER");
                            break;


                    }

                    //BICEPS
                    switch(ejerciciobiceps2){
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer6.setText("3 - 4 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer6.setText("3 - 4 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer6.setText("3 - 4 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer6.setText("3 - 4 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer6.setText("3 - 4 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer6.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl spider con barra":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer6.setText("2 - 3 RER");
                            break;


                    }


                    //BICEPS
                    switch(ejerciciobiceps3){
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer7.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl spider con barra":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer7.setText("2 - 3 RER");
                            break;


                    }

                    //BICEPS
                    switch(ejerciciobiceps4){
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer8.setText("3 - 4 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer8.setText("3 - 4 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer8.setText("3 - 4 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer8.setText("3 - 4 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer8.setText("3 - 4 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer8.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl spider con barra":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer8.setText("2 - 3 RER");
                            break;


                    }



                    //espalda
                    switch(ejercicioespalda){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Remo pendlay":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Dominadas":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer1.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer1.setText("2 - 3 RER");
                            break;


                    }

                    //espalda
                    switch(ejercicioespalda2){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Remo pendlay":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Dominadas":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer2.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer2.setText("2 - 3 RER");
                            break;


                    }

                    //espalda
                    switch(ejercicioespalda3){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Remo pendlay":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Dominadas":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer3.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer3.setText("2 - 3 RER");
                            break;


                    }

//espalda
                    switch(ejercicioespalda4){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Remo pendlay":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Dominadas":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer4.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer4.setText("2 - 3 RER");
                            break;


                    }



                }


                // RER FINAL  1 - 2 Y 0 - 1

                if (rer1int <= 12){


                    //deltoides laterales
                    switch(ejerciciolateral){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer9.setText("1 - 2 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Facepull con cuerda":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer9.setText("0 - 1 RER");
                            break;

                    }

                    //deltoides laterales
                    switch(ejerciciolateral2){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer10.setText("1 - 2 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Facepull con cuerda":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer10.setText("0 - 1 RER");
                            break;

                    }

                    //deltoides laterales
                    switch(ejerciciolateral3){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer11.setText("1 - 2 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Facepull con cuerda":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer11.setText("0 - 1 RER");
                            break;

                    }





                    //TRAPECIOS
                    switch(ejerciciotrapecios){
                        //ejercicios compuestos
                        case "Encogimiento de hombros con mancuernas":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Encogimiento de hombros en smith por delante":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Encogimiento de hombros con barra por delante":
                            rer12.setText("1 - 2 RER");
                            break;



                        //ejercicios csimples
                        case "Paseo del granjero":
                            rer12.setText("-");
                            break;

                        case "Encogiminto de hombros con barra por detrás":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Encogimiento de hombros con smith por detrás":
                            rer12.setText("0 - 1 RER");
                            break;


                    }



                    //TRAPECIOS
                    switch(ejerciciotrapecios2){
                        //ejercicios compuestos
                        case "Encogimiento de hombros con mancuernas":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Encogimiento de hombros en smith por delante":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Encogimiento de hombros con barra por delante":
                            rer13.setText("1 - 2 RER");
                            break;



                        //ejercicios csimples
                        case "Paseo del granjero":
                            rer13.setText("-");
                            break;

                        case "Encogiminto de hombros con barra por detrás":
                            rer13.setText("0 - 1 RER");
                            break;

                        case "Encogimiento de hombros con smith por detrás":
                            rer13.setText("0 - 1 RER");
                            break;


                    }

                    //TRAPECIOS
                    switch(ejerciciotrapecios3){
                        //ejercicios compuestos
                        case "Encogimiento de hombros con mancuernas":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Encogimiento de hombros en smith por delante":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Encogimiento de hombros con barra por delante":
                            rer14.setText("1 - 2 RER");
                            break;



                        //ejercicios csimples
                        case "Paseo del granjero":
                            rer14.setText("-");
                            break;

                        case "Encogiminto de hombros con barra por detrás":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Encogimiento de hombros con smith por detrás":
                            rer14.setText("0 - 1 RER");
                            break;


                    }




                    //BICEPS
                    switch(ejerciciobiceps){
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer5.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl spider con barra":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer5.setText("0 - 1 RER");
                            break;


                    }

                    //BICEPS
                    switch(ejerciciobiceps2){
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer6.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl spider con barra":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer6.setText("0 - 1 RER");
                            break;


                    }


                    //BICEPS
                    switch(ejerciciobiceps3){
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer7.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl spider con barra":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer7.setText("0 - 1 RER");
                            break;


                    }

                    //BICEPS
                    switch(ejerciciobiceps4){
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer8.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Curl spider con barra":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer8.setText("0 - 1 RER");
                            break;


                    }



                    //espalda
                    switch(ejercicioespalda){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Remo pendlay":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Dominadas":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer1.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer1.setText("0 - 1 RER");
                            break;


                    }

                    //espalda
                    switch(ejercicioespalda2){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Remo pendlay":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Dominadas":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer2.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer2.setText("0 - 1 RER");
                            break;


                    }

                    //espalda
                    switch(ejercicioespalda3){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Remo pendlay":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Dominadas":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer3.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer3.setText("0 - 1 RER");
                            break;


                    }

//espalda
                    switch(ejercicioespalda4){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Remo pendlay":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Dominadas":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer4.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer4.setText("0 - 1 RER");
                            break;


                    }



                }

                // RER MEDIO 2 - 3  Y 1 - 2

                if (rer1int>13 && rer1int<=17){


                    //deltoides laterales
                    switch(ejerciciolateral){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer9.setText("2 - 3 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Facepull con cuerda":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer9.setText("1 - 2 RER");
                            break;

                    }

                    //deltoides laterales
                    switch(ejerciciolateral2){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer10.setText("2 - 3 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Facepull con cuerda":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer10.setText("1 - 2 RER");
                            break;

                    }

                    //deltoides laterales
                    switch(ejerciciolateral3){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer11.setText("2 - 3 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Facepull con cuerda":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer11.setText("1 - 2 RER");
                            break;

                    }





                    //TRAPECIOS
                    switch(ejerciciotrapecios){
                        //ejercicios compuestos
                        case "Encogimiento de hombros con mancuernas":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Encogimiento de hombros en smith por delante":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Encogimiento de hombros con barra por delante":
                            rer12.setText("2 - 3 RER");
                            break;



                        //ejercicios csimples
                        case "Paseo del granjero":
                            rer12.setText("-");
                            break;

                        case "Encogiminto de hombros con barra por detrás":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Encogimiento de hombros con smith por detrás":
                            rer12.setText("1 - 2 RER");
                            break;


                    }



                    //TRAPECIOS
                    switch(ejerciciotrapecios2){
                        //ejercicios compuestos
                        case "Encogimiento de hombros con mancuernas":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Encogimiento de hombros en smith por delante":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Encogimiento de hombros con barra por delante":
                            rer13.setText("2 - 3 RER");
                            break;



                        //ejercicios csimples
                        case "Paseo del granjero":
                            rer13.setText("-");
                            break;

                        case "Encogiminto de hombros con barra por detrás":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Encogimiento de hombros con smith por detrás":
                            rer13.setText("1 - 2 RER");
                            break;


                    }

                    //TRAPECIOS
                    switch(ejerciciotrapecios3){
                        //ejercicios compuestos
                        case "Encogimiento de hombros con mancuernas":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Encogimiento de hombros en smith por delante":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Encogimiento de hombros con barra por delante":
                            rer14.setText("2 - 3 RER");
                            break;



                        //ejercicios csimples
                        case "Paseo del granjero":
                            rer14.setText("-");
                            break;

                        case "Encogiminto de hombros con barra por detrás":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Encogimiento de hombros con smith por detrás":
                            rer14.setText("1 - 2 RER");
                            break;


                    }




                    //BICEPS
                    switch(ejerciciobiceps){
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer5.setText("2 - 3 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl spider con barra":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer5.setText("1 - 2 RER");
                            break;


                    }

                    //BICEPS
                    switch(ejerciciobiceps2){
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer6.setText("2 - 3 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl spider con barra":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer6.setText("1 - 2 RER");
                            break;


                    }


                    //BICEPS
                    switch(ejerciciobiceps3){
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer7.setText("2 - 3 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Curl spider con barra":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer7.setText("1 - 2 RER");
                            break;


                    }

                    //BICEPS
                    switch(ejerciciobiceps4){
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer8.setText("2 - 3 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl spider con barra":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer8.setText("1 - 2 RER");
                            break;


                    }



                    //espalda
                    switch(ejercicioespalda){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Remo pendlay":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Dominadas":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer1.setText("2 - 3 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer1.setText("1 - 2 RER");
                            break;


                    }

                    //espalda
                    switch(ejercicioespalda2){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Remo pendlay":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Dominadas":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer2.setText("2 - 3 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer2.setText("1 - 2 RER");
                            break;


                    }

                    //espalda
                    switch(ejercicioespalda3){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Remo pendlay":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Dominadas":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer3.setText("2 - 3 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer3.setText("1 - 2 RER");
                            break;


                    }

//espalda
                    switch(ejercicioespalda4){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Remo pendlay":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Dominadas":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer4.setText("2 - 3 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer4.setText("1 - 2 RER");
                            break;


                    }






                }



//-------------------------------------------------------------------------------------------------------------------------------------------------------------

                //SERIES



                String slateral = datasnapshot.child("series espalda").getValue().toString();
                Double slat = Double.parseDouble(slateral);
                Double slateraldividido = slat / 2;
                Double slateralf = Math.ceil(slateraldividido);
                Double slateralf1 = slateralf / 4;
                Double slateralf2 = slateralf / 4;
                Double slateralf3 = slateralf / 4;
                Double slateralf4 = slateralf / 4;
                int slateralint = (int) Math.ceil(slateralf1);
                int slateralint2 = (int) Math.ceil(slateralf2);
                int slateralint3 = (int) Math.round(slateralf3);
                if (slateralint3 == 1){
                    slateralint3++;
                }
                int slateralint4 = (int) Math.floor(slateralf4);
                if (slateralint4 == 1){
                    slateralint4++;
                }
                String seriesfinallateral = String.valueOf(slateralint);
                String seriesfinallateral2 = String.valueOf(slateralint2);
                String seriesfinallateral3 = String.valueOf(slateralint3);
                String seriesfinallateral4 = String.valueOf(slateralint4);
                seriesespalda.setText(seriesfinallateral + " Series");
                seriesespalda2.setText(seriesfinallateral2 + " Series");
                seriesespalda3.setText(seriesfinallateral3 + " Series");
                seriesespalda4.setText(seriesfinallateral4 + " Series");


                String scuadriceps = datasnapshot.child("series biceps").getValue().toString();
                Double scuad = Double.parseDouble(scuadriceps);
                Double scuaddividido = scuad / 2;
                Double scuadf = Math.ceil(scuaddividido);
                Double scuadf1 = scuadf / 4;
                Double scuadf2 = scuadf / 4;
                Double scuadf3 = scuadf / 4;
                Double scuadf4 = scuadf / 4;
                int scuadint = (int) Math.ceil(scuadf1);
                int scuadint2 = (int) Math.ceil(scuadf2);
                int scuadint3 = (int) Math.round(scuadf3);
                if (scuadint3 == 1){
                    scuadint3++;
                }
                int scuadint4 = (int) Math.floor(scuadf4);
                if (scuadint4 == 1){
                    scuadint4++;
                }
                String seriesfinalcuad = String.valueOf(scuadint);
                String seriesfinalcuad2 = String.valueOf(scuadint2);
                String seriesfinalcuad3 = String.valueOf(scuadint3);
                String seriesfinalcuad4 = String.valueOf(scuadint4);
                seriesbiceps.setText(seriesfinalcuad + " Series");
                seriesbiceps2.setText(seriesfinalcuad2 + " Series");
                seriesbiceps3.setText(seriesfinalcuad3 + " Series");
                seriesbiceps4.setText(seriesfinalcuad4 + " Series");


                String sfemorales = datasnapshot.child("series deltoides laterales y posteriores").getValue().toString();
                Double sfem = Double.parseDouble(sfemorales);
                Double sfemdividido = sfem / 2;
                Double sfemoralesf = Math.ceil(sfemdividido);
                Double sfemoralesf1 = sfemoralesf / 3;
                Double sfemoralesf2 = sfemoralesf / 3;
                Double sfemoralesf3 = sfemoralesf / 3;
                int sfemoralesint = (int) Math.ceil(sfemoralesf1);
                int sfemoralesint2 = (int) Math.round(sfemoralesf2);
                if (sfemoralesint2 == 1){
                    sfemoralesint2++;
                }
                int sfemoralesint3 = (int) Math.floor(sfemoralesf3);
                if (sfemoralesint3 == 1){
                    sfemoralesint3++;
                }
                String seriesfinalfemorales = String.valueOf(sfemoralesint);
                String seriesfinalfemorales2 = String.valueOf(sfemoralesint2);
                String seriesfinalfemorales3 = String.valueOf(sfemoralesint3);
                serieslateral.setText(seriesfinalfemorales + " Series");
                serieslateral2.setText(seriesfinalfemorales2 + " Series");
                serieslateral3.setText(seriesfinalfemorales3 + " Series");


                String sgluteos = datasnapshot.child("series trapecios").getValue().toString();
                Double sgl = Double.parseDouble(sgluteos);
                Double sgluteosdividido = sgl / 2;
                Double sgluteosf = Math.ceil(sgluteosdividido);
                Double sgluteosf1 = sgluteosf / 3;
                Double sgluteosf2 = sgluteosf / 3;
                Double sgluteosf3 = sgluteosf / 3;
                int sgluteosint = (int) Math.round(sgluteosf1);
                if (sgluteosint == 1){
                    sgluteosint++;
                }
                int sgluteosint2 = (int) Math.round(sgluteosf2);
                if (sgluteosint2 == 1){
                    sgluteosint2++;
                }
                int sgluteosint3 = (int) Math.round(sgluteosf3);
                if (sgluteosint3 == 1){
                    sgluteosint3++;
                }
                String seriesgluteosfinal = String.valueOf(sgluteosint);
                String seriesgluteosfinal2 = String.valueOf(sgluteosint2);
                String seriesgluteosfinal3 = String.valueOf(sgluteosint3);
                seriestraps.setText(seriesgluteosfinal + " Series");
                seriestraps2.setText(seriesgluteosfinal2 + " Series");
                seriestraps3.setText(seriesgluteosfinal3 + " Series");





                String stringpesoiniciallateral = datasnapshot.child("Historial espalda/ 6 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesoespalda.setText(stringpesoiniciallateral);

                String stringpesoiniciallateral2 = datasnapshot.child("Historial espalda/ 6 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesoespalda2.setText(stringpesoiniciallateral2);

                String stringpesoiniciallateral3 = datasnapshot.child("Historial espalda/ 6 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesoespalda3.setText(stringpesoiniciallateral3);

                String stringpesoinicialcuadriceps = datasnapshot.child("Historial espalda/ 6 dias/ cuarto ejercicio/ dia 1").getValue().toString();
                pesoespalda4.setText(stringpesoinicialcuadriceps);



                String stringpesoinicialcuadriceps2 = datasnapshot.child("Historial biceps/ 6 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesobiceps.setText(stringpesoinicialcuadriceps2);

                String stringpesoinicialcuadriceps3 = datasnapshot.child("Historial biceps/ 6 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesobiceps2.setText(stringpesoinicialcuadriceps3);

                String stringpesoinicialfemoral = datasnapshot.child("Historial biceps/ 6 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesobiceps3.setText(stringpesoinicialfemoral);

                String stringpesoinicialfemoral2 = datasnapshot.child("Historial biceps/ 6 dias/ cuarto ejercicio/ dia 1").getValue().toString();
                pesobiceps4.setText(stringpesoinicialfemoral2);



                String stringpesoinicialfemoral3 = datasnapshot.child("Historial deltoides laterales y posteriores/ 6 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesolateral.setText(stringpesoinicialfemoral3);

                String stringpesoinicialpantorrillas = datasnapshot.child("Historial deltoides laterales y posteriores/ 6 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesolateral2.setText(stringpesoinicialpantorrillas);

                String stringpesoinicialpantorrillas2 = datasnapshot.child("Historial deltoides laterales y posteriores/ 6 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesolateral3.setText(stringpesoinicialpantorrillas2);



                String stringpesoinicialgluteos = datasnapshot.child("Historial trapecios/ 6 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesotrapecios.setText(stringpesoinicialgluteos);

                String stringpesoinicialgluteos2 = datasnapshot.child("Historial trapecios/ 6 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesotrapecios2.setText(stringpesoinicialgluteos2);

                String stringpesoinicialabdomen = datasnapshot.child("Historial trapecios/ 6 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesotrapecios3.setText(stringpesoinicialabdomen);




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





















        //permite dejar puesto el peso ingresado en el edit text
        pesoespalda.addTextChangedListener(new TextWatcher() {
                                               @Override
                                               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {




                                               }

                                               @Override
                                               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void afterTextChanged(Editable editable) {
                                                   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesoespalda.getContext());
                                                   preferences.edit().putString("editText",editable.toString()).commit();



                                               }
                                           }
        );


        //permite dejar puesto el peso ingresado en el edit text
        pesoespalda2.addTextChangedListener(new TextWatcher() {
                                                @Override
                                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void afterTextChanged(Editable editable) {
                                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesoespalda2.getContext());
                                                    preferences.edit().putString("editText",editable.toString()).commit();



                                                }
                                            }
        );


        //permite dejar puesto el peso ingresado en el edit text
        pesoespalda3.addTextChangedListener(new TextWatcher() {
                                                @Override
                                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void afterTextChanged(Editable editable) {
                                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesoespalda3.getContext());
                                                    preferences.edit().putString("editText",editable.toString()).commit();



                                                }
                                            }
        );



        //permite dejar puesto el peso ingresado en el edit text
        pesoespalda4.addTextChangedListener(new TextWatcher() {
                                                @Override
                                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void afterTextChanged(Editable editable) {
                                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesoespalda4.getContext());
                                                    preferences.edit().putString("editText",editable.toString()).commit();



                                                }
                                            }
        );



        //permite dejar puesto el peso ingresado en el edit text
        pesobiceps.addTextChangedListener(new TextWatcher() {
                                              @Override
                                              public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                              }

                                              @Override
                                              public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                              }

                                              @Override
                                              public void afterTextChanged(Editable editable) {
                                                  SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesobiceps.getContext());
                                                  preferences.edit().putString("editText",editable.toString()).commit();



                                              }
                                          }
        );



        //permite dejar puesto el peso ingresado en el edit text
        pesobiceps2.addTextChangedListener(new TextWatcher() {
                                               @Override
                                               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void afterTextChanged(Editable editable) {
                                                   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesobiceps2.getContext());
                                                   preferences.edit().putString("editText",editable.toString()).commit();



                                               }
                                           }
        );


        //permite dejar puesto el peso ingresado en el edit text
        pesobiceps3.addTextChangedListener(new TextWatcher() {
                                               @Override
                                               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void afterTextChanged(Editable editable) {
                                                   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesobiceps3.getContext());
                                                   preferences.edit().putString("editText",editable.toString()).commit();



                                               }
                                           }
        );



        //permite dejar puesto el peso ingresado en el edit text
        pesobiceps4.addTextChangedListener(new TextWatcher() {
                                               @Override
                                               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void afterTextChanged(Editable editable) {
                                                   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesobiceps4.getContext());
                                                   preferences.edit().putString("editText",editable.toString()).commit();



                                               }
                                           }
        );




        //permite dejar puesto el peso ingresado en el edit text
        pesolateral.addTextChangedListener(new TextWatcher() {
                                               @Override
                                               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void afterTextChanged(Editable editable) {
                                                   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesolateral.getContext());
                                                   preferences.edit().putString("editText",editable.toString()).commit();



                                               }
                                           }
        );


        //permite dejar puesto el peso ingresado en el edit text
        pesolateral2.addTextChangedListener(new TextWatcher() {
                                                @Override
                                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void afterTextChanged(Editable editable) {
                                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesolateral2.getContext());
                                                    preferences.edit().putString("editText",editable.toString()).commit();



                                                }
                                            }
        );


        //permite dejar puesto el peso ingresado en el edit text
        pesolateral3.addTextChangedListener(new TextWatcher() {
                                                @Override
                                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void afterTextChanged(Editable editable) {
                                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesolateral3.getContext());
                                                    preferences.edit().putString("editText",editable.toString()).commit();



                                                }
                                            }
        );


        //permite dejar puesto el peso ingresado en el edit text
        pesotrapecios.addTextChangedListener(new TextWatcher() {
                                                 @Override
                                                 public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                 }

                                                 @Override
                                                 public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                 }

                                                 @Override
                                                 public void afterTextChanged(Editable editable) {
                                                     SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesotrapecios.getContext());
                                                     preferences.edit().putString("editText",editable.toString()).commit();



                                                 }
                                             }
        );


        //permite dejar puesto el peso ingresado en el edit text
        pesotrapecios2.addTextChangedListener(new TextWatcher() {
                                                  @Override
                                                  public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                  }

                                                  @Override
                                                  public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                  }

                                                  @Override
                                                  public void afterTextChanged(Editable editable) {
                                                      SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesotrapecios2.getContext());
                                                      preferences.edit().putString("editText",editable.toString()).commit();



                                                  }
                                              }
        );


        //permite dejar puesto el peso ingresado en el edit text
        pesotrapecios3.addTextChangedListener(new TextWatcher() {
                                                  @Override
                                                  public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                  }

                                                  @Override
                                                  public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                  }

                                                  @Override
                                                  public void afterTextChanged(Editable editable) {
                                                      SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesotrapecios3.getContext());
                                                      preferences.edit().putString("editText",editable.toString()).commit();



                                                  }
                                              }
        );








    }


    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void buttonfindelentrenamientoentreno6diamartes (View view) {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        // Called when fullscreen content is dismissed.
                        Log.d("TAG", "The ad was dismissed.");
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        // Called when fullscreen content failed to show.
                        Log.d("TAG", "The ad failed to show.");
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        // Called when fullscreen content is shown.
                        // Make sure to set your reference to null so you don't
                        // show it a second time.
                        mInterstitialAd = null;
                        Log.d("TAG", "The ad was shown.");
                    }
                });


                if (mInterstitialAd != null) {
                    mInterstitialAd.show(entreno6diamartes.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }

            }
        }, 1000);



        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();

        String datoejercicio1 = pesoespalda.getText().toString();
        String datoejercicio1_2 = pesoespalda2.getText().toString();
        String datoejercicio1_3 = pesoespalda3.getText().toString();
        String datoejercicio1_4 = pesoespalda4.getText().toString();

        String datoejercicio2 = pesobiceps.getText().toString();
        String datoejercicio2_2 = pesobiceps2.getText().toString();
        String datoejercicio2_3 = pesobiceps3.getText().toString();
        String datoejercicio2_4 = pesobiceps4.getText().toString();

        String datoejercicio3 = pesolateral.getText().toString();
        String datoejercicio3_2 = pesolateral2.getText().toString();
        String datoejercicio3_3 = pesolateral3.getText().toString();

        String datoejercicio4 = pesotrapecios.getText().toString();
        String datoejercicio4_2 = pesotrapecios2.getText().toString();
        String datoejercicio4_3 = pesotrapecios3.getText().toString();



        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                Map<String, Object> pesoactualizandose2 = new HashMap<>();
                pesoactualizandose2.put("Historial espalda/ 6 dias/ primer ejercicio/ dia 1", datoejercicio1);
                pesoactualizandose2.put("Historial espalda/ 6 dias/ segundo ejercicio/ dia 1", datoejercicio1_2);
                pesoactualizandose2.put("Historial espalda/ 6 dias/ tercer ejercicio/ dia 1", datoejercicio1_3);
                pesoactualizandose2.put("Historial espalda/ 6 dias/ cuarto ejercicio/ dia 1", datoejercicio1_4);

                pesoactualizandose2.put("Historial biceps/ 6 dias/ primer ejercicio/ dia 1", datoejercicio2);
                pesoactualizandose2.put("Historial biceps/ 6 dias/ segundo ejercicio/ dia 1", datoejercicio2_2);
                pesoactualizandose2.put("Historial biceps/ 6 dias/ tercer ejercicio/ dia 1", datoejercicio2_3);
                pesoactualizandose2.put("Historial biceps/ 6 dias/ cuarto ejercicio/ dia 1", datoejercicio2_4);

                pesoactualizandose2.put("Historial deltoides laterlaes y posteriores/ 6 dias/ primer ejercicio/ dia 1", datoejercicio3);
                pesoactualizandose2.put("Historial deltoides laterales y posteriores/ 6 dias/ segundo ejercicio/ dia 1", datoejercicio3_2);
                pesoactualizandose2.put("Historial deltoides laterales y posteriores/ 6 dias/ tercer ejercicio/ dia 1", datoejercicio3_3);

                pesoactualizandose2.put("Historial trapecios/ 6 dias/ primer ejercicio/ dia 1", datoejercicio4);
                pesoactualizandose2.put("Historial trapecios/ 6 dias/ segundo ejercicio/ dia 1", datoejercicio4_2);
                pesoactualizandose2.put("Historial trapecios/ 6 dias/ tercer ejercicio/ dia 1", datoejercicio4_3);





                mDatabase.child("Users").child(id).updateChildren(pesoactualizandose2);


                //si se modifica el datachange en algun otro momento envia a esta pantalla, por lo cual se condiciona el envio
                boolean botonpresionado = true;

                if (botonpresionado == true){



                    Intent findelentrenamiento = new Intent(entreno6diamartes.this, entrenamientofinalizado.class);

                    String valor2 = getIntent().getExtras().getString("actual");
                    findelentrenamiento.putExtra("actual", valor2);
                    findelentrenamiento.putExtra("entreno?", "sidia2");

                    startActivity(findelentrenamiento);
                    finish();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });







        //4 4 3 3

        //   Toast.makeText(this, "Gracias por entrenar con Korellia Club. Tu entrenamiento ha sido guardado.", Toast.LENGTH_SHORT).show();





    }

    public void ejercicio1 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("espalda/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartes.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void ejercicio1parte2 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("espalda/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartes.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    public void ejercicio1parte3 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("espalda/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartes.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void ejercicio1parte4 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("espalda/ ejercicio cuarto").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartes.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }




    public void ejercicio2 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("biceps/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartes.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    public void ejercicio2parte2 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("biceps/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartes.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    public void ejercicio2parte3 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("biceps/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartes.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    public void ejercicio2parte4 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("biceps/ ejercicio cuarto").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartes.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }




    public void ejercicio3 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("deltoides laterales y posteriores/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartes.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void ejercicio3parte2 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("deltoides laterales y posteriores/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartes.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    public void ejercicio3parte3 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartes.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }




    public void ejercicio4 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("trapecios/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartes.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void ejercicio4parte2 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("trapecios/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartes.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    public void ejercicio4parte3 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("trapecios/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartes.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }




}
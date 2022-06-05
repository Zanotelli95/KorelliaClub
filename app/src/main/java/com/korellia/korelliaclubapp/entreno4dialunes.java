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

public class entreno4dialunes extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private EditText peso1, peso2, peso3,   pesotrapecios2, pesofrontal2, pesoespalda, pesoespalda2, pesoespalda3, pesobiceps, pesobiceps2, pesotriceps, pesotriceps2, pesofrontal, pesotrapecios;
    private String ejercicioseleccionado, ejercicioseleccionadoespalda, ejercicioseleccionadobiceps, ejercicioseleccionadotriceps, ejercicioseleccionadofrontal,
            ejercicioseleccionadotraps;
    private TextView rer1, rer2, rer3, rer4, rer5, rer6, rer7, rer8, rer9, rer10, rer11, rer12, rer13, rer14;
    private TextView fechacompleta;
    private TextView seriespectoral, seriespectoral2, seriespectoral3, seriesespalda, seriesespalda2, seriesespalda3, seriesbiceps, seriesbiceps2, seriestriceps, seriestriceps2,
            seriesfrontal, seriestraps;
    private Spinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8, spinner9, spinner10, spinner11, spinner12, spinner13, spinner14;
    private  TextView ejerciciopectoral, repeticionespectoral2, repeticionespectoral3, ejerciciopectoral2, ejerciciopectoral3, repeticionespectoral, ejercicioespalda, ejercicioespalda2,
            ejercicioespalda3, repeticionesespalda2, repeticionesespalda3, repeticionesespalda, ejerciciobiceps, ejerciciobiceps2, repeticionesbiceps, repeticionesbiceps2, ejerciciotriceps,
            repeticionestriceps,  repeticionestriceps2, ejerciciofrontal,
            repeticionesfrontal, ejerciciotriceps2, ejerciciotrapecios, repeticionestrapecios;
    private ImageView imagenpectoral, imagentrapecios2, imagenfrontal2, imagenpectoral2, imagenpectoral3, imagenespalda, imagenespalda2, imagenespalda3, imagenbiceps, imagenbiceps2,
            imagentriceps, imagentriceps2,  imagenfrontal, imagentrapecios;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private TextView ejerciciofrontal2,  repeticionesfrontal2,  seriesfrontal2, seriestraps2,  ejerciciotrapecios2;
    private TextView repeticionestrapecios2;
    private String ejercicioseleccionado2,  ejercicioseleccionadoespalda2,  ejercicioseleccionadoespalda3, ejercicioseleccionado3,
            ejercicioseleccionadotraps2,  ejercicioseleccionadobiceps2,  ejercicioseleccionadofrontal2, ejercicioseleccionadotriceps2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_entreno4dialunes);


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

        fechacompleta = (TextView) findViewById(R.id.textView273);
        Date date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("d MMM yyyy");
        String sfecha = fecha.format(date);
        fechacompleta.setText(sfecha);


        Toolbar toolbar = findViewById(R.id.toolbarentreno4dialunes);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Entrenamiento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        spinner1= (Spinner) findViewById(R.id.spinner1);
        spinner2= (Spinner) findViewById(R.id.spinner2);
        spinner3= (Spinner) findViewById(R.id.spinner3);
        spinner4= (Spinner) findViewById(R.id.spinner4);
        spinner5= (Spinner) findViewById(R.id.spinner5);
        spinner6= (Spinner) findViewById(R.id.spinner6);
        spinner7= (Spinner) findViewById(R.id.spinner7);
        spinner8= (Spinner) findViewById(R.id.spinner8);
        spinner9= (Spinner) findViewById(R.id.spinner9);
        spinner10= (Spinner) findViewById(R.id.spinner10);
        spinner11= (Spinner) findViewById(R.id.spinner11);
        spinner12= (Spinner) findViewById(R.id.spinner12);
        spinner13= (Spinner) findViewById(R.id.spinner13);
        spinner14= (Spinner) findViewById(R.id.spinner14);


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



        rer1 = findViewById(R.id.buttonrer1a);
        rer2 = findViewById(R.id.buttonrer2a);
        rer3 = findViewById(R.id.buttonrer3a);

        rer4 = findViewById(R.id.buttonrer4a);
        rer5 = findViewById(R.id.buttonrer5a);
        rer6 = findViewById(R.id.buttonrer6a);

        rer7 = findViewById(R.id.buttonrer7a);
        rer8 = findViewById(R.id.buttonrer8a);

        rer9 = findViewById(R.id.buttonrer9a);
        rer10 = findViewById(R.id.buttonrer10a);

        rer11 = findViewById(R.id.buttonrer11a);
        rer12 = findViewById(R.id.buttonrer12a);

        rer13 = findViewById(R.id.buttonrer13a);
        rer14 = findViewById(R.id.buttonrer14a);



        //pectoral 3
        ejerciciopectoral = (TextView) findViewById(R.id.textView219);
        repeticionespectoral = (TextView) findViewById(R.id.textView221);
        imagenpectoral = (ImageView) findViewById(R.id.imageView11);
        peso1 = (EditText) findViewById(R.id.textView222);
        seriespectoral = (TextView) findViewById(R.id.textView220);


        ejerciciopectoral2 = (TextView) findViewById(R.id.textView219pectoral2);
        repeticionespectoral2 = (TextView) findViewById(R.id.textView221pec2);
        imagenpectoral2 = (ImageView) findViewById(R.id.imageView11imagen2);
        peso2 = (EditText) findViewById(R.id.textView222pec2);
        seriespectoral2 = (TextView) findViewById(R.id.textView220pec2);


        ejerciciopectoral3 = (TextView) findViewById(R.id.textView219pectoral3);
        repeticionespectoral3 = (TextView) findViewById(R.id.textView221pec3);
        imagenpectoral3 = (ImageView) findViewById(R.id.imageView11imagen3);
        peso3 = (EditText) findViewById(R.id.textView222pec3);
        seriespectoral3 = (TextView) findViewById(R.id.textView220pec3);


        //espalda 3
        ejercicioespalda = (TextView) findViewById(R.id.textView219espalda1);
        repeticionesespalda = (TextView) findViewById(R.id.textView221espalda1);
        imagenespalda = (ImageView) findViewById(R.id.imageView11espalda1);
        pesoespalda = (EditText) findViewById(R.id.textView222espalda1);
        seriesespalda = (TextView) findViewById(R.id.textView220espalda1);

        ejercicioespalda2 = (TextView) findViewById(R.id.textView219espalda2);
        repeticionesespalda2 = (TextView) findViewById(R.id.textView221espalda2);
        imagenespalda2 = (ImageView) findViewById(R.id.imageView11espalda2);
        pesoespalda2 = (EditText) findViewById(R.id.textView222espalda2);
        seriesespalda2 = (TextView) findViewById(R.id.textView220espalda2);

        ejercicioespalda3 = (TextView) findViewById(R.id.textView219espalda3);
        repeticionesespalda3 = (TextView) findViewById(R.id.textView221espalda3);
        imagenespalda3 = (ImageView) findViewById(R.id.imageView11espalda3);
        pesoespalda3 = (EditText) findViewById(R.id.textView222espalda3);
        seriesespalda3 = (TextView) findViewById(R.id.textView220espalda3);


        //biceps 2
        ejerciciobiceps = (TextView) findViewById(R.id.textView219biceps1);
        repeticionesbiceps = (TextView) findViewById(R.id.textView221biceps1);
        imagenbiceps = (ImageView) findViewById(R.id.imageView11biceps1);
        pesobiceps = (EditText) findViewById(R.id.textView222biceps1);
        seriesbiceps = (TextView) findViewById(R.id.textView220biceps1);

        ejerciciobiceps2 = (TextView) findViewById(R.id.textView219biceps2);
        repeticionesbiceps2 = (TextView) findViewById(R.id.textView221biceps2);
        imagenbiceps2 = (ImageView) findViewById(R.id.imageView11biceps2);
        pesobiceps2 = (EditText) findViewById(R.id.textView222biceps2);
        seriesbiceps2 = (TextView) findViewById(R.id.textView220biceps2);



        //triceps 2
        ejerciciotriceps = (TextView) findViewById(R.id.nombreejerciciotriceps1);
        repeticionestriceps = (TextView) findViewById(R.id.textView221triceps1);
        imagentriceps = (ImageView) findViewById(R.id.imageView11triceps1);
        pesotriceps = (EditText) findViewById(R.id.textView222triceps1);
        seriestriceps = (TextView) findViewById(R.id.textView220triceps1);


        ejerciciotriceps2 = (TextView) findViewById(R.id.textView219triceps2);
        repeticionestriceps2 = (TextView) findViewById(R.id.textView221triecps2);
        imagentriceps2 = (ImageView) findViewById(R.id.imageView11triceps2);
        pesotriceps2 = (EditText) findViewById(R.id.textView222triceps2);
        seriestriceps2 = (TextView) findViewById(R.id.textView220triceps2);




        //frontales 2
        ejerciciofrontal = (TextView) findViewById(R.id.textView219frontal1);
        repeticionesfrontal = (TextView) findViewById(R.id.textView221frontal1);
        imagenfrontal = (ImageView) findViewById(R.id.imageView11frontal1);
        pesofrontal = (EditText) findViewById(R.id.textView222frontal1);
        seriesfrontal= (TextView) findViewById(R.id.textView220frontal1);

        ejerciciofrontal2 = (TextView) findViewById(R.id.textView219frontal2);
        repeticionesfrontal2 = (TextView) findViewById(R.id.textView221frontal2);
        imagenfrontal2 = (ImageView) findViewById(R.id.imageView11frontal2);
        pesofrontal2 = (EditText) findViewById(R.id.textView222frontal2);
        seriesfrontal2 = (TextView) findViewById(R.id.textView220frontal2);





        //trapecios 2

        ejerciciotrapecios = (TextView) findViewById(R.id.textView219traps1);
        repeticionestrapecios = (TextView) findViewById(R.id.textView221traps1);
        imagentrapecios = (ImageView) findViewById(R.id.imageView11traps1);
        pesotrapecios = (EditText) findViewById(R.id.textView222traps1);
        seriestraps = (TextView) findViewById(R.id.textView220traps1);


        ejerciciotrapecios2 = (TextView) findViewById(R.id.textView219traps2);
        repeticionestrapecios2 = (TextView) findViewById(R.id.textView221traps2);
        imagentrapecios2 = (ImageView) findViewById(R.id.imageView11traps2);
        pesotrapecios2 = (EditText) findViewById(R.id.textView222traps2);
        seriestraps2 = (TextView) findViewById(R.id.textView220traps2);






        mAuth = FirebaseAuth.getInstance();

        //logicadelentrenamiento(ejercicios)





        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();


        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if (datasnapshot.exists()) {

                    String ejercicio = datasnapshot.child("pectoral/ ejercicio primario").getValue().toString();
                    ejerciciopectoral.setText(ejercicio);
                    ejercicioseleccionado = ejercicio;

                    String ejercicio2 = datasnapshot.child("pectoral/ ejercicio secundario").getValue().toString();
                    ejerciciopectoral2.setText(ejercicio2);
                    ejercicioseleccionado2 = ejercicio2;

                    String ejercicio3 = datasnapshot.child("pectoral/ ejercicio tercero").getValue().toString();
                    ejerciciopectoral3.setText(ejercicio3);
                    ejercicioseleccionado3 = ejercicio3;


                    String stringejercicioespalda = datasnapshot.child("espalda/ ejercicio primario").getValue().toString();
                    ejercicioespalda.setText(stringejercicioespalda);
                    ejercicioseleccionadoespalda = stringejercicioespalda;

                    String stringejercicioespalda2 = datasnapshot.child("espalda/ ejercicio secundario").getValue().toString();
                    ejercicioespalda2.setText(stringejercicioespalda2);
                    ejercicioseleccionadoespalda2 = stringejercicioespalda2;

                    String stringejercicioespalda3 = datasnapshot.child("espalda/ ejercicio tercero").getValue().toString();
                    ejercicioespalda3.setText(stringejercicioespalda3);
                    ejercicioseleccionadoespalda3 = stringejercicioespalda3;


                    String stringejerciciobiceps = datasnapshot.child("biceps/ ejercicio primario").getValue().toString();
                    ejerciciobiceps.setText(stringejerciciobiceps);
                    ejercicioseleccionadobiceps = stringejerciciobiceps;

                    String stringejerciciobiceps2 = datasnapshot.child("biceps/ ejercicio secundario").getValue().toString();
                    ejerciciobiceps2.setText(stringejerciciobiceps2);
                    ejercicioseleccionadobiceps2 = stringejerciciobiceps2;


                    String stringejerciciotriceps = datasnapshot.child("triceps/ ejercicio primario").getValue().toString();
                    ejerciciotriceps.setText(stringejerciciotriceps);
                    ejercicioseleccionadotriceps = stringejerciciotriceps;

                    String stringejerciciotriceps2 = datasnapshot.child("triceps/ ejercicio secundario").getValue().toString();
                    ejerciciotriceps2.setText(stringejerciciotriceps2);
                    ejercicioseleccionadotriceps2 = stringejerciciotriceps2;


                    String stringejerciciofrontal = datasnapshot.child("deltoide frontal/ ejercicio primario").getValue().toString();
                    ejerciciofrontal.setText(stringejerciciofrontal);
                    ejercicioseleccionadofrontal = stringejerciciofrontal;

                    String stringejerciciofrontal2 = datasnapshot.child("deltoide frontal/ ejercicio secundario").getValue().toString();
                    ejerciciofrontal2.setText(stringejerciciofrontal2);
                    ejercicioseleccionadofrontal2 = stringejerciciofrontal2;


                    String stringejerciciotraps = datasnapshot.child("trapecios/ ejercicio primario").getValue().toString();
                    ejerciciotrapecios.setText(stringejerciciotraps);
                    ejercicioseleccionadotraps = stringejerciciotraps;

                    String stringejerciciotraps2 = datasnapshot.child("trapecios/ ejercicio secundario").getValue().toString();
                    ejerciciotrapecios2.setText(stringejerciciotraps2);
                    ejercicioseleccionadotraps2 = stringejerciciotraps2;


                }

                //pectorales
                if (ejercicioseleccionado.equals("Press con mancuernas en banco inclinado")) {
                    int reps = 10;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20inclinado%2F20210131_110514.jpg?alt=media&token=11b4850c-6470-4e95-90a5-deb17964ffb6")
                            .fit().centerCrop()
                            .into(imagenpectoral);

                }

                if (ejercicioseleccionado.equals("Aperturas con mancuernas en banco plano")) {
                    int reps = 12;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20plano%2F20210131_110935.jpg?alt=media&token=2fed102e-3ac9-4e3d-a8a8-f0800ae5e909")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }

                if (ejercicioseleccionado.equals("Press con mancuernas en banco plano")) {
                    int reps = 10;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20plano%2F20210131_110730.jpg?alt=media&token=d104a7b6-223b-4e2b-b26c-81b371a15dac")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }

                if (ejercicioseleccionado.equals("Press de pectorales en máquina hammer")) {
                    int reps = 10;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20de%20pectorales%20en%20maquina%20hammer%2F20210205_112023.jpg?alt=media&token=59f3486d-abb5-49e6-8319-3081f3789efa")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }

                if (ejercicioseleccionado.equals("Press inclinado con barra")) {
                    int reps = 6;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20con%20barra%2F20210306_111438.jpg?alt=media&token=66760c33-7ecf-44ef-95d2-c63525c3df3c")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }

                if (ejercicioseleccionado.equals("Press de pectorales en maquina")) {
                    int reps = 10;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20en%20maquina%2F20210306_114640.jpg?alt=media&token=592af745-5d25-4185-806f-5d1b5613a52b")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }

                if (ejercicioseleccionado.equals("Aperturas con mancuernas en banco inclinado")) {
                    int reps = 12;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20inclinado%2F20211210_114004.jpg?alt=media&token=25ecdbcf-9c21-4995-bb73-ce3fde443e07")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }

                if (ejercicioseleccionado.equals("Aperturas en crossover (polea a nivel medio)")) {
                    int reps = 15;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20nivel%20medio%2F20211210_114518.jpg?alt=media&token=6f45c63c-7da2-4b58-bf98-6fc55cd9529b")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }

                if (ejercicioseleccionado.equals("Aperturas en crossover (polea a nivel bajo)")) {
                    int reps = 15;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20baja%2F20211210_114549.jpg?alt=media&token=88dddd71-9d58-4421-bd9f-4f9115b30a2d")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }

                if (ejercicioseleccionado.equals("Aperturas en crossover (polea a nivel alto)")) {
                    int reps = 15;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20alta%2F20211210_114340.jpg?alt=media&token=47c7cc8f-c5b2-4eeb-8c17-1c367ee0d571")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }

                if (ejercicioseleccionado.equals("Fondos")) {
                    int reps = 10;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Ffondos%2F20211210_114650.jpg?alt=media&token=48053b12-28ba-4b01-bc3e-bc70b798e5a3")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }

                if (ejercicioseleccionado.equals("Press inclinado en smith")) {
                    int reps = 8;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20en%20smith%2F20211210_114936.jpg?alt=media&token=c7657baa-792e-47e0-8582-63cce1afb5f6")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }

                if (ejercicioseleccionado.equals("Press horizontal con barra")) {
                    int reps = 6;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20con%20barra%2F20211211_133124.jpg?alt=media&token=4d662706-8d37-4cc3-aab8-26862f028dab")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }

                if (ejercicioseleccionado.equals("Lagartijas")) {
                    int reps = 12;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Flagartijas%2F20211210_115202.jpg?alt=media&token=26209733-4ac6-41f1-8e6c-13b47862dba5")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }

                if (ejercicioseleccionado.equals("Press plano en smith")) {
                    int reps = 8;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20plano%20en%20smith%2F20211210_115046.jpg?alt=media&token=a9b0d2be-ec51-4eab-b881-bc522bd339f5")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }

                if (ejercicioseleccionado.equals("Aperturas en peck deck")) {
                    int reps = 15;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20en%20peck%20deck%2F20211210_115417.jpg?alt=media&token=8de8c9ce-f0fd-4c16-8920-ef88c6604962")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }

                if (ejercicioseleccionado.equals("Press declinado con mancuernas")) {
                    int reps = 8;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Flagartijas%2F20211210_115201.jpg?alt=media&token=375a0c21-c29b-4dc9-ac44-60cc8dff2bfd")
                            .fit().centerCrop()
                            .into(imagenpectoral);
                }


                //----

                if (ejercicioseleccionado2.equals("Press con mancuernas en banco inclinado")) {
                    int reps = 10;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20inclinado%2F20210131_110514.jpg?alt=media&token=11b4850c-6470-4e95-90a5-deb17964ffb6")
                            .fit().centerCrop()
                            .into(imagenpectoral2);

                }

                if (ejercicioseleccionado2.equals("Aperturas con mancuernas en banco plano")) {
                    int reps = 12;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20plano%2F20210131_110935.jpg?alt=media&token=2fed102e-3ac9-4e3d-a8a8-f0800ae5e909")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }

                if (ejercicioseleccionado2.equals("Press con mancuernas en banco plano")) {
                    int reps = 10;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20plano%2F20210131_110730.jpg?alt=media&token=d104a7b6-223b-4e2b-b26c-81b371a15dac")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }

                if (ejercicioseleccionado2.equals("Press de pectorales en máquina hammer")) {
                    int reps = 10;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20de%20pectorales%20en%20maquina%20hammer%2F20210205_112023.jpg?alt=media&token=59f3486d-abb5-49e6-8319-3081f3789efa")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }

                if (ejercicioseleccionado2.equals("Press inclinado con barra")) {
                    int reps = 6;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20con%20barra%2F20210306_111438.jpg?alt=media&token=66760c33-7ecf-44ef-95d2-c63525c3df3c")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }

                if (ejercicioseleccionado2.equals("Press de pectorales en maquina")) {
                    int reps = 10;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20en%20maquina%2F20210306_114640.jpg?alt=media&token=592af745-5d25-4185-806f-5d1b5613a52b")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }

                if (ejercicioseleccionado2.equals("Aperturas con mancuernas en banco inclinado")) {
                    int reps = 12;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20inclinado%2F20211210_114004.jpg?alt=media&token=25ecdbcf-9c21-4995-bb73-ce3fde443e07")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }

                if (ejercicioseleccionado2.equals("Aperturas en crossover (polea a nivel medio)")) {
                    int reps = 15;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20nivel%20medio%2F20211210_114518.jpg?alt=media&token=6f45c63c-7da2-4b58-bf98-6fc55cd9529b")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }

                if (ejercicioseleccionado2.equals("Aperturas en crossover (polea a nivel bajo)")) {
                    int reps = 15;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20baja%2F20211210_114549.jpg?alt=media&token=88dddd71-9d58-4421-bd9f-4f9115b30a2d")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }

                if (ejercicioseleccionado2.equals("Aperturas en crossover (polea a nivel alto)")) {
                    int reps = 15;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20alta%2F20211210_114340.jpg?alt=media&token=47c7cc8f-c5b2-4eeb-8c17-1c367ee0d571")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }

                if (ejercicioseleccionado2.equals("Fondos")) {
                    int reps = 10;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Ffondos%2F20211210_114650.jpg?alt=media&token=48053b12-28ba-4b01-bc3e-bc70b798e5a3")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }

                if (ejercicioseleccionado2.equals("Press inclinado en smith")) {
                    int reps = 8;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20en%20smith%2F20211210_114936.jpg?alt=media&token=c7657baa-792e-47e0-8582-63cce1afb5f6")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }

                if (ejercicioseleccionado2.equals("Press horizontal con barra")) {
                    int reps = 6;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20con%20barra%2F20211211_133124.jpg?alt=media&token=4d662706-8d37-4cc3-aab8-26862f028dab")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }

                if (ejercicioseleccionado2.equals("Lagartijas")) {
                    int reps = 12;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Flagartijas%2F20211210_115202.jpg?alt=media&token=26209733-4ac6-41f1-8e6c-13b47862dba5")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }

                if (ejercicioseleccionado2.equals("Press plano en smith")) {
                    int reps = 8;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20plano%20en%20smith%2F20211210_115046.jpg?alt=media&token=a9b0d2be-ec51-4eab-b881-bc522bd339f5")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }

                if (ejercicioseleccionado2.equals("Aperturas en peck deck")) {
                    int reps = 15;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20en%20peck%20deck%2F20211210_115417.jpg?alt=media&token=8de8c9ce-f0fd-4c16-8920-ef88c6604962")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }

                if (ejercicioseleccionado2.equals("Press declinado con mancuernas")) {
                    int reps = 8;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral2.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20declinado%20con%20mancuernas%2FIMG_0308.jpg?alt=media&token=4fa254f7-3be4-4b2b-a604-5d8a2ca6de89")
                            .fit().centerCrop()
                            .into(imagenpectoral2);
                }


                //---


                if (ejercicioseleccionado3.equals("Press con mancuernas en banco inclinado")) {
                    int reps = 10;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20inclinado%2F20210131_110514.jpg?alt=media&token=11b4850c-6470-4e95-90a5-deb17964ffb6")
                            .fit().centerCrop()
                            .into(imagenpectoral3);

                }

                if (ejercicioseleccionado3.equals("Aperturas con mancuernas en banco plano")) {
                    int reps = 12;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20plano%2F20210131_110935.jpg?alt=media&token=2fed102e-3ac9-4e3d-a8a8-f0800ae5e909")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
                }

                if (ejercicioseleccionado3.equals("Press con mancuernas en banco plano")) {
                    int reps = 10;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20plano%2F20210131_110730.jpg?alt=media&token=d104a7b6-223b-4e2b-b26c-81b371a15dac")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
                }

                if (ejercicioseleccionado3.equals("Press de pectorales en máquina hammer")) {
                    int reps = 10;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20de%20pectorales%20en%20maquina%20hammer%2F20210205_112023.jpg?alt=media&token=59f3486d-abb5-49e6-8319-3081f3789efa")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
                }

                if (ejercicioseleccionado3.equals("Press inclinado con barra")) {
                    int reps = 6;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20con%20barra%2F20210306_111438.jpg?alt=media&token=66760c33-7ecf-44ef-95d2-c63525c3df3c")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
                }

                if (ejercicioseleccionado3.equals("Press de pectorales en maquina")) {
                    int reps = 10;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20en%20maquina%2F20210306_114640.jpg?alt=media&token=592af745-5d25-4185-806f-5d1b5613a52b")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
                }

                if (ejercicioseleccionado3.equals("Aperturas con mancuernas en banco inclinado")) {
                    int reps = 12;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20inclinado%2F20211210_114004.jpg?alt=media&token=25ecdbcf-9c21-4995-bb73-ce3fde443e07")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
                }

                if (ejercicioseleccionado3.equals("Aperturas en crossover (polea a nivel medio)")) {
                    int reps = 15;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20nivel%20medio%2F20211210_114518.jpg?alt=media&token=6f45c63c-7da2-4b58-bf98-6fc55cd9529b")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
                }

                if (ejercicioseleccionado3.equals("Aperturas en crossover (polea a nivel bajo)")) {
                    int reps = 15;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20baja%2F20211210_114549.jpg?alt=media&token=88dddd71-9d58-4421-bd9f-4f9115b30a2d")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
                }

                if (ejercicioseleccionado3.equals("Aperturas en crossover (polea a nivel alto)")) {
                    int reps = 15;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20alta%2F20211210_114340.jpg?alt=media&token=47c7cc8f-c5b2-4eeb-8c17-1c367ee0d571")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
                }

                if (ejercicioseleccionado3.equals("Fondos")) {
                    int reps = 10;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Ffondos%2F20211210_114650.jpg?alt=media&token=48053b12-28ba-4b01-bc3e-bc70b798e5a3")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
                }

                if (ejercicioseleccionado3.equals("Press inclinado en smith")) {
                    int reps = 8;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20en%20smith%2F20211210_114936.jpg?alt=media&token=c7657baa-792e-47e0-8582-63cce1afb5f6")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
                }

                if (ejercicioseleccionado3.equals("Press horizontal con barra")) {
                    int reps = 6;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20con%20barra%2F20211211_133124.jpg?alt=media&token=4d662706-8d37-4cc3-aab8-26862f028dab")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
                }

                if (ejercicioseleccionado3.equals("Lagartijas")) {
                    int reps = 12;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Flagartijas%2F20211210_115202.jpg?alt=media&token=26209733-4ac6-41f1-8e6c-13b47862dba5")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
                }

                if (ejercicioseleccionado3.equals("Press plano en smith")) {
                    int reps = 8;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20plano%20en%20smith%2F20211210_115046.jpg?alt=media&token=a9b0d2be-ec51-4eab-b881-bc522bd339f5")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
                }

                if (ejercicioseleccionado3.equals("Aperturas en peck deck")) {
                    int reps = 15;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20en%20peck%20deck%2F20211210_115417.jpg?alt=media&token=8de8c9ce-f0fd-4c16-8920-ef88c6604962")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
                }

                if (ejercicioseleccionado3.equals("Press declinado con mancuernas")) {
                    int reps = 8;
                    String repespectoral = Integer.toString(reps);
                    repeticionespectoral3.setText(repespectoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20declinado%20con%20mancuernas%2FIMG_0308.jpg?alt=media&token=4fa254f7-3be4-4b2b-a604-5d8a2ca6de89")
                            .fit().centerCrop()
                            .into(imagenpectoral3);
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

                //---


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


                //-----

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


                //-----

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


                //triceps
                if (ejercicioseleccionadotriceps.equals("Copa con barra")) {
                    int reps = 6;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20barra%2F20210310_113434.jpg?alt=media&token=2248759f-65be-4c94-951d-9a51ea67fdd0")
                            .fit().centerCrop()
                            .into(imagentriceps);
                }

                if (ejercicioseleccionadotriceps.equals("Copa con mancuerna a 1 brazo")) {
                    int reps = 10;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%20a%201%20brazo%2F20211211_134125.jpg?alt=media&token=6a09c03d-52d2-489d-b733-44cf1636c8db")
                            .fit().centerCrop()
                            .into(imagentriceps);
                }

                if (ejercicioseleccionadotriceps.equals("Extensiones de tríceps a 1 brazo agarre supino")) {
                    int reps = 15;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20a%201%20brazo%20agarre%20supino%2F20210306_120236.jpg?alt=media&token=8cbdc0b6-9c3a-4e32-9a77-5aadeaef1f85")
                            .fit().centerCrop()
                            .into(imagentriceps);
                }

                if (ejercicioseleccionadotriceps.equals("Extensiones de tríceps con cuerda")) {
                    int reps = 15;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20con%20cuerda%2F20210131_104718.jpg?alt=media&token=16b1f8b0-ef5a-45f5-b4de-a0d5a289ca59")
                            .fit().centerCrop()
                            .into(imagentriceps);
                }

                if (ejercicioseleccionadotriceps.equals("Extensiones de tríceps en máquina")) {
                    int reps = 12;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20maquina%2F20210131_104124.jpg?alt=media&token=9b6efd0c-3bed-48ed-b96f-893a06879207")
                            .fit().centerCrop()
                            .into(imagentriceps);
                }

                if (ejercicioseleccionadotriceps.equals("Fondos en máquina")) {
                    int reps = 10;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Ffondos%20en%20maquina%2F20210131_104422.jpg?alt=media&token=4a2f6161-b9b0-47d0-a718-d1b4a5f02100")
                            .fit().centerCrop()
                            .into(imagentriceps);
                }

                if (ejercicioseleccionadotriceps.equals("Patada para tríceps a 1 brazo")) {
                    int reps = 8;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20triceps%20a%201%20brazo%2F20210131_105749.jpg?alt=media&token=3edb47a6-91f3-4fdd-b9ef-7ed86bcb22fc")
                            .fit().centerCrop()
                            .into(imagentriceps);
                }

                if (ejercicioseleccionadotriceps.equals("Patada para tríceps con polea")) {
                    int reps = 12;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20tr%C3%ADceps%20con%20polea%2F20210303_120303.jpg?alt=media&token=c1821599-0a85-4254-b855-4e14d909d198")
                            .fit().centerCrop()
                            .into(imagentriceps);
                }

                if (ejercicioseleccionadotriceps.equals("Rompecraneos con mancuernas")) {
                    int reps = 10;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20mancuernas%2F20210306_121025.jpg?alt=media&token=443ab4fd-91fa-42f6-b76c-e5fa5f98a988")
                            .fit().centerCrop()
                            .into(imagentriceps);
                }

                if (ejercicioseleccionadotriceps.equals("Rompecraneos con barra z")) {
                    int reps = 6;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20barra%20z%2F20211211_133613.jpg?alt=media&token=51f761d5-a7bb-4d06-9c2b-7b4c109ebdb5")
                            .fit().centerCrop()
                            .into(imagentriceps);
                }

                if (ejercicioseleccionadotriceps.equals("Copa con mancuerna sentado")) {
                    int reps = 6;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%2F20211211_133811.jpg?alt=media&token=3292c999-28d4-4ba7-b9d2-c30e1f91b060")
                            .fit().centerCrop()
                            .into(imagentriceps);
                }

                if (ejercicioseleccionadotriceps.equals("Extensiones de tríceps en polea alta con maneral recto")) {
                    int reps = 12;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20polea%20alta%20con%20manera%20recto%2F20211211_134008.jpg?alt=media&token=d3a079cf-e0d6-40b2-b8de-3b8c2ed75cdd")
                            .fit().centerCrop()
                            .into(imagentriceps);
                }

                if (ejercicioseleccionadotriceps.equals("Press cerrado con barra")) {
                    int reps = 6;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20con%20barra%2FIMG_0333.jpg?alt=media&token=e8337d1e-5160-400c-8923-b771369ef950")
                            .fit().centerCrop()
                            .into(imagentriceps);
                }

                if (ejercicioseleccionadotriceps.equals("Press cerrado en smith")) {
                    int reps = 10;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20en%20smith%2F20211211_134356.jpg?alt=media&token=97ae02ab-aed5-4fe5-87d9-9bb75453bcdf")
                            .fit().centerCrop()
                            .into(imagentriceps);
                }

                //------
                if (ejercicioseleccionadotriceps2.equals("Copa con barra")) {
                    int reps = 6;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps2.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20barra%2F20210310_113434.jpg?alt=media&token=2248759f-65be-4c94-951d-9a51ea67fdd0")
                            .fit().centerCrop()
                            .into(imagentriceps2);
                }

                if (ejercicioseleccionadotriceps2.equals("Copa con mancuerna a 1 brazo")) {
                    int reps = 10;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps2.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%20a%201%20brazo%2F20211211_134125.jpg?alt=media&token=6a09c03d-52d2-489d-b733-44cf1636c8db")
                            .fit().centerCrop()
                            .into(imagentriceps2);
                }

                if (ejercicioseleccionadotriceps2.equals("Extensiones de tríceps a 1 brazo agarre supino")) {
                    int reps = 15;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps2.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20a%201%20brazo%20agarre%20supino%2F20210306_120236.jpg?alt=media&token=8cbdc0b6-9c3a-4e32-9a77-5aadeaef1f85")
                            .fit().centerCrop()
                            .into(imagentriceps2);
                }

                if (ejercicioseleccionadotriceps2.equals("Extensiones de tríceps con cuerda")) {
                    int reps = 15;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps2.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20con%20cuerda%2F20210131_104718.jpg?alt=media&token=16b1f8b0-ef5a-45f5-b4de-a0d5a289ca59")
                            .fit().centerCrop()
                            .into(imagentriceps2);
                }

                if (ejercicioseleccionadotriceps2.equals("Extensiones de tríceps en máquina")) {
                    int reps = 12;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps2.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20maquina%2F20210131_104124.jpg?alt=media&token=9b6efd0c-3bed-48ed-b96f-893a06879207")
                            .fit().centerCrop()
                            .into(imagentriceps2);
                }

                if (ejercicioseleccionadotriceps2.equals("Fondos en máquina")) {
                    int reps = 10;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps2.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Ffondos%20en%20maquina%2F20210131_104422.jpg?alt=media&token=4a2f6161-b9b0-47d0-a718-d1b4a5f02100")
                            .fit().centerCrop()
                            .into(imagentriceps2);
                }

                if (ejercicioseleccionadotriceps2.equals("Patada para tríceps a 1 brazo")) {
                    int reps = 8;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps2.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20triceps%20a%201%20brazo%2F20210131_105749.jpg?alt=media&token=3edb47a6-91f3-4fdd-b9ef-7ed86bcb22fc")
                            .fit().centerCrop()
                            .into(imagentriceps2);
                }

                if (ejercicioseleccionadotriceps2.equals("Patada para tríceps con polea")) {
                    int reps = 12;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps2.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20tr%C3%ADceps%20con%20polea%2F20210303_120303.jpg?alt=media&token=c1821599-0a85-4254-b855-4e14d909d198")
                            .fit().centerCrop()
                            .into(imagentriceps2);
                }

                if (ejercicioseleccionadotriceps2.equals("Rompecraneos con mancuernas")) {
                    int reps = 10;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps2.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20mancuernas%2F20210306_121025.jpg?alt=media&token=443ab4fd-91fa-42f6-b76c-e5fa5f98a988")
                            .fit().centerCrop()
                            .into(imagentriceps2);
                }

                if (ejercicioseleccionadotriceps2.equals("Rompecraneos con barra z")) {
                    int reps = 6;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps2.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20barra%20z%2F20211211_133613.jpg?alt=media&token=51f761d5-a7bb-4d06-9c2b-7b4c109ebdb5")
                            .fit().centerCrop()
                            .into(imagentriceps2);
                }

                if (ejercicioseleccionadotriceps2.equals("Copa con mancuerna sentado")) {
                    int reps = 6;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps2.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%2F20211211_133811.jpg?alt=media&token=3292c999-28d4-4ba7-b9d2-c30e1f91b060")
                            .fit().centerCrop()
                            .into(imagentriceps2);
                }

                if (ejercicioseleccionadotriceps2.equals("Extensiones de tríceps en polea alta con maneral recto")) {
                    int reps = 12;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps2.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20polea%20alta%20con%20manera%20recto%2F20211211_134008.jpg?alt=media&token=d3a079cf-e0d6-40b2-b8de-3b8c2ed75cdd")
                            .fit().centerCrop()
                            .into(imagentriceps2);
                }

                if (ejercicioseleccionadotriceps2.equals("Press cerrado con barra")) {
                    int reps = 6;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps2.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20con%20barra%2FIMG_0333.jpg?alt=media&token=e8337d1e-5160-400c-8923-b771369ef950")
                            .fit().centerCrop()
                            .into(imagentriceps2);
                }

                if (ejercicioseleccionadotriceps2.equals("Press cerrado en smith")) {
                    int reps = 10;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps2.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20con%20barra%2FIMG_0333.jpg?alt=media&token=e8337d1e-5160-400c-8923-b771369ef950 ")
                            .fit().centerCrop()
                            .into(imagentriceps2);
                }


                //frontal

                if (ejercicioseleccionadofrontal.equals("Elevaciones frontales con disco")) {
                    int reps = 10;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaciones%20frontales%20con%20mancuernas%2F20210131_110211.jpg?alt=media&token=d0d9503f-675a-49b7-a41f-b4b6bec5160b")
                            .fit().centerCrop()
                            .into(imagenfrontal);
                }

                if (ejercicioseleccionadofrontal.equals("Elevaciones frontales con mancuernas agarre prono")) {
                    int reps = 10;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20prono%2F20211211_131542.jpg?alt=media&token=2d239b78-cc91-42f4-9082-5aa6c65d7269")
                            .fit().centerCrop()
                            .into(imagenfrontal);
                }

                if (ejercicioseleccionadofrontal.equals("Press en máquina agarre neutro")) {
                    int reps = 10;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20en%20maquina%20agarre%20neutro%2F20210205_115518.jpg?alt=media&token=53c0e6cc-746f-406c-a941-580436c6c340")
                            .fit().centerCrop()
                            .into(imagenfrontal);
                }

                if (ejercicioseleccionadofrontal.equals("Press militar con barra")) {
                    int reps = 6;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20barra%2F20210310_112107.jpg?alt=media&token=5b5ebed3-b4ae-41f2-a6cd-98a93f705ac1")
                            .fit().centerCrop()
                            .into(imagenfrontal);
                }

                if (ejercicioseleccionadofrontal.equals("Press militar con mancuernas")) {
                    int reps = 8;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111220.jpg?alt=media&token=9dfa83e7-77cd-493a-a77c-e017675dfdbb")
                            .fit().centerCrop()
                            .into(imagenfrontal);
                }

                if (ejercicioseleccionadofrontal.equals("Elevaciones frontales con mancuerna agarre supino")) {
                    int reps = 12;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111220.jpg?alt=media&token=9dfa83e7-77cd-493a-a77c-e017675dfdbb")
                            .fit().centerCrop()
                            .into(imagenfrontal);
                }

                if (ejercicioseleccionadofrontal.equals("Elevaciones frontales con mancuernas agarre neutro")) {
                    int reps = 12;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20neutro%2F20211211_131609.jpg?alt=media&token=cf4ebe11-fc55-4cec-8970-d1b53dbb4195")
                            .fit().centerCrop()
                            .into(imagenfrontal);
                }

                if (ejercicioseleccionadofrontal.equals("Elevaciones frontales con polea baja a 1 brazo")) {
                    int reps = 15;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20cuerda%20a%201%20brazo%20en%20polea%20baja%2F20211211_132025.jpg?alt=media&token=95b8ce8f-f9d2-4522-8142-49b5f9c5f76c")
                            .fit().centerCrop()
                            .into(imagenfrontal);
                }

                if (ejercicioseleccionadofrontal.equals("Elevaciones frontal con cuerda en polea baja")) {
                    int reps = 15;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20cuerda%20en%20polea%20bjaa%2F20211211_131930.jpg?alt=media&token=28ead862-adde-434f-894f-14a0b5252e7d")
                            .fit().centerCrop()
                            .into(imagenfrontal);
                }

                if (ejercicioseleccionadofrontal.equals("Press militar en smith")) {
                    int reps = 8;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20smith%2F20211211_132928.jpg?alt=media&token=e6b5e09b-cb42-4ff0-864c-9509a5183561")
                            .fit().centerCrop()
                            .into(imagenfrontal);
                }

                if (ejercicioseleccionadofrontal.equals("Press Arnold")) {
                    int reps = 10;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20arnold%2F20211211_132627.jpg?alt=media&token=eda53e9d-00f2-4ba1-b902-2474a8b84ba6")
                            .fit().centerCrop()
                            .into(imagenfrontal);
                }

                if (ejercicioseleccionadofrontal.equals("Press en máquina agarre prono")) {
                    int reps = 10;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20maquina%20agarre%20prono%2F20211211_132226.jpg?alt=media&token=9e4300d1-5f77-4afc-bf57-10f289e42992")
                            .fit().centerCrop()
                            .into(imagenfrontal);
                    ;
                }

                if (ejercicioseleccionadofrontal.equals("Push press")) {
                    int reps = 6;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpush%20press%2F20211211_133415.jpg?alt=media&token=a9c6db66-5353-4197-8059-c516571414b1")
                            .fit().centerCrop()
                            .into(imagenfrontal);
                }

                //-------

                if (ejercicioseleccionadofrontal2.equals("Elevaciones frontales con disco")) {
                    int reps = 10;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal2.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaciones%20frontales%20con%20mancuernas%2F20210131_110211.jpg?alt=media&token=d0d9503f-675a-49b7-a41f-b4b6bec5160b")
                            .fit().centerCrop()
                            .into(imagenfrontal2);
                }

                if (ejercicioseleccionadofrontal2.equals("Elevaciones frontales con mancuernas agarre prono")) {
                    int reps = 10;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal2.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20prono%2F20211211_131542.jpg?alt=media&token=2d239b78-cc91-42f4-9082-5aa6c65d7269")
                            .fit().centerCrop()
                            .into(imagenfrontal2);
                }

                if (ejercicioseleccionadofrontal2.equals("Press en máquina agarre neutro")) {
                    int reps = 10;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal2.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20en%20maquina%20agarre%20neutro%2F20210205_115518.jpg?alt=media&token=53c0e6cc-746f-406c-a941-580436c6c340")
                            .fit().centerCrop()
                            .into(imagenfrontal2);
                }

                if (ejercicioseleccionadofrontal2.equals("Press militar con barra")) {
                    int reps = 6;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal2.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20barra%2F20210310_112107.jpg?alt=media&token=5b5ebed3-b4ae-41f2-a6cd-98a93f705ac1")
                            .fit().centerCrop()
                            .into(imagenfrontal2);
                }

                if (ejercicioseleccionadofrontal2.equals("Press militar con mancuernas")) {
                    int reps = 8;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal2.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111220.jpg?alt=media&token=9dfa83e7-77cd-493a-a77c-e017675dfdbb")
                            .fit().centerCrop()
                            .into(imagenfrontal2);
                }

                if (ejercicioseleccionadofrontal2.equals("Elevaciones frontales con mancuerna agarre supino")) {
                    int reps = 12;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal2.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111220.jpg?alt=media&token=9dfa83e7-77cd-493a-a77c-e017675dfdbb")
                            .fit().centerCrop()
                            .into(imagenfrontal2);
                }

                if (ejercicioseleccionadofrontal2.equals("Elevaciones frontales con mancuernas agarre neutro")) {
                    int reps = 12;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal2.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20neutro%2F20211211_131609.jpg?alt=media&token=cf4ebe11-fc55-4cec-8970-d1b53dbb4195")
                            .fit().centerCrop()
                            .into(imagenfrontal2);
                }

                if (ejercicioseleccionadofrontal2.equals("Elevaciones frontales con polea baja a 1 brazo")) {
                    int reps = 15;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal2.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20cuerda%20a%201%20brazo%20en%20polea%20baja%2F20211211_132025.jpg?alt=media&token=95b8ce8f-f9d2-4522-8142-49b5f9c5f76c")
                            .fit().centerCrop()
                            .into(imagenfrontal2);
                }

                if (ejercicioseleccionadofrontal2.equals("Elevaciones frontal con cuerda en polea baja")) {
                    int reps = 15;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal2.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20cuerda%20en%20polea%20bjaa%2F20211211_131930.jpg?alt=media&token=28ead862-adde-434f-894f-14a0b5252e7d")
                            .fit().centerCrop()
                            .into(imagenfrontal2);
                }

                if (ejercicioseleccionadofrontal2.equals("Press militar en smith")) {
                    int reps = 8;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal2.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20smith%2F20211211_132928.jpg?alt=media&token=e6b5e09b-cb42-4ff0-864c-9509a5183561")
                            .fit().centerCrop()
                            .into(imagenfrontal2);
                }

                if (ejercicioseleccionadofrontal2.equals("Press Arnold")) {
                    int reps = 10;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal2.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20arnold%2F20211211_132627.jpg?alt=media&token=eda53e9d-00f2-4ba1-b902-2474a8b84ba6")
                            .fit().centerCrop()
                            .into(imagenfrontal2);
                }

                if (ejercicioseleccionadofrontal2.equals("Press en máquina agarre prono")) {
                    int reps = 10;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal2.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20maquina%20agarre%20prono%2F20211211_132226.jpg?alt=media&token=9e4300d1-5f77-4afc-bf57-10f289e42992")
                            .fit().centerCrop()
                            .into(imagenfrontal2);
                    ;
                }

                if (ejercicioseleccionadofrontal2.equals("Push press")) {
                    int reps = 6;
                    String repesfrontal = Integer.toString(reps);
                    repeticionesfrontal2.setText(repesfrontal + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpush%20press%2F20211211_133415.jpg?alt=media&token=a9c6db66-5353-4197-8059-c516571414b1")
                            .fit().centerCrop()
                            .into(imagenfrontal2);
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


                //------

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



//-------------------------------------------------------------------------------------------------------------------------------------------------------------
                //RER

                String RER1 = datasnapshot.child("progresosrer").getValue().toString();
                int rer1int = Integer.parseInt(RER1);

                String ejerciciopecho = datasnapshot.child("pectoral/ ejercicio primario").getValue().toString();
                String ejerciciopecho2 = datasnapshot.child("pectoral/ ejercicio secundario").getValue().toString();
                String ejerciciopecho3 = datasnapshot.child("pectoral/ ejercicio tercero").getValue().toString();

                String ejercicioespalda = datasnapshot.child("espalda/ ejercicio primario").getValue().toString();
                String ejercicioespalda2 = datasnapshot.child("espalda/ ejercicio secundario").getValue().toString();
                String ejercicioespalda3 = datasnapshot.child("espalda/ ejercicio tercero").getValue().toString();

                String ejerciciobiceps = datasnapshot.child("biceps/ ejercicio primario").getValue().toString();
                String ejerciciobiceps2 = datasnapshot.child("biceps/ ejercicio secundario").getValue().toString();

                String ejerciciotriceps = datasnapshot.child("triceps/ ejercicio primario").getValue().toString();
                String ejerciciotriceps2 = datasnapshot.child("triceps/ ejercicio secundario").getValue().toString();

                String ejerciciofrontal = datasnapshot.child("deltoide frontal/ ejercicio primario").getValue().toString();
                String ejerciciofrontal2 = datasnapshot.child("deltoide frontal/ ejercicio secundario").getValue().toString();

                String ejerciciotrapecios = datasnapshot.child("trapecios/ ejercicio primario").getValue().toString();
                String ejerciciotrapecios2 = datasnapshot.child("trapecios/ ejercicio secundario").getValue().toString();




                //RER INICIAL 3 - 4 Y 2 - 3
                if(rer1int >= 18) {


                    //pectoral
                    switch(ejerciciopecho){
                        //ejercicios compuestos
                        case "Press con mancuernas en banco plano":
                            rer1.setText("3 - 4 RER");
                            break;
                        case "Press con mancuernas en banco inclinado":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Press de pectorales en maquina":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Press declinado con mancuernas":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Press inclinado con barra":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Press plano con barra":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Press inclinado en smith":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Press horizontal con barra":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Press plano en smith":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Press de pectorales en maquina hammer":
                            rer1.setText("3 - 4 RER");
                            break;

                        //ejercicios simples

                        case "Aperturas con mancuernas en banco plano":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Aperturas con mancuernas en banco inclinado":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Aperturas en peck deck":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Fondos":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel medio)":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel bajo)":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel alto)":
                            rer1.setText("2 - 3 RER");
                            break;

                    }

                    switch(ejerciciopecho2){
                        //ejercicios compuestos
                        case "Press con mancuernas en banco plano":
                            rer2.setText("3 - 4 RER");
                            break;
                        case "Press con mancuernas en banco inclinado":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Press de pectorales en maquina":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Press declinado con mancuernas":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Press inclinado con barra":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Press plano con barra":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Press inclinado en smith":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Press horizontal con barra":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Press plano en smith":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Press de pectorales en maquina hammer":
                            rer2.setText("3 - 4 RER");
                            break;

                        //ejercicios simples

                        case "Aperturas con mancuernas en banco plano":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Aperturas con mancuernas en banco inclinado":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Aperturas en peck deck":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Fondos":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel medio)":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel bajo)":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel alto)":
                            rer2.setText("2 - 3 RER");
                            break;

                    }


                    switch(ejerciciopecho3){
                        //ejercicios compuestos
                        case "Press con mancuernas en banco plano":
                            rer3.setText("3 - 4 RER");
                            break;
                        case "Press con mancuernas en banco inclinado":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Press de pectorales en maquina":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Press declinado con mancuernas":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Press inclinado con barra":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Press plano con barra":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Press inclinado en smith":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Press horizontal con barra":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Press plano en smith":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Press de pectorales en maquina hammer":
                            rer3.setText("3 - 4 RER");
                            break;

                        //ejercicios simples

                        case "Aperturas con mancuernas en banco plano":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Aperturas con mancuernas en banco inclinado":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Aperturas en peck deck":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Fondos":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel medio)":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel bajo)":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel alto)":
                            rer3.setText("2 - 3 RER");
                            break;

                    }







                    //TRAPECIOS
                    switch(ejerciciotrapecios){
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

                    switch(ejerciciotrapecios2){
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






                    //FRONTAL
                    switch(ejerciciofrontal){
                        //ejercicios compuestos
                        case "Press militar con barra":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Press militar con mancuernas":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Push press":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Press militar en smith":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Press en máquina agarre prono":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Press Arnold":
                            rer11.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Press en máquina agarre neutro":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre prono":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con mancuerna agarre supino":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con polea baja a 1 brazo":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con disco":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontal con cuerda en polea baja":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre neutro":
                            rer11.setText("2 - 3 RER");
                            break;

                    }



                    //FRONTAL
                    switch(ejerciciofrontal2){
                        //ejercicios compuestos
                        case "Press militar con barra":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Press militar con mancuernas":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Push press":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Press militar en smith":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Press en máquina agarre prono":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Press Arnold":
                            rer12.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Press en máquina agarre neutro":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre prono":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con mancuerna agarre supino":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con polea baja a 1 brazo":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con disco":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontal con cuerda en polea baja":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre neutro":
                            rer12.setText("2 - 3 RER");
                            break;

                    }







                    //triceps
                    switch(ejerciciotriceps){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Press cerrado en smith":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Copa con barra":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer9.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Fondos en máquina":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer9.setText("2 - 3 RER");
                            break;

                    }


                    //triceps
                    switch(ejerciciotriceps2){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Press cerrado en smith":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Copa con barra":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer10.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Fondos en máquina":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer10.setText("2 - 3 RER");
                            break;

                    }








                    //BICEPS
                    switch(ejerciciobiceps){
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
                    switch(ejerciciobiceps2){
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
                    switch(ejercicioespalda2){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Remo pendlay":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Dominadas":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer5.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer5.setText("2 - 3 RER");
                            break;


                    }

                    //espalda
                    switch(ejercicioespalda){
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

                    //espalda
                    switch(ejercicioespalda3){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer6.setText("3 - 4 RER");
                            break;

                        case "Remo pendlay":
                            rer6.setText("3 - 4 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer6.setText("3 - 4 RER");
                            break;

                        case "Dominadas":
                            rer6.setText("3 - 4 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer6.setText("3 - 4 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer6.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer6.setText("2 - 3 RER");
                            break;


                    }







//--------------------------------------


                }
                // RER FINAL  1 - 2 Y 0 - 1

                if (rer1int <= 12){

                    //pectoral
                    switch(ejerciciopecho){
                        //ejercicios compuestos
                        case "Press con mancuernas en banco plano":
                            rer1.setText("1 - 2 RER");
                            break;
                        case "Press con mancuernas en banco inclinado":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Press de pectorales en maquina":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Press declinado con mancuernas":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Press inclinado con barra":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Press plano con barra":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Press inclinado en smith":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Press horizontal con barra":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Press plano en smith":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Press de pectorales en maquina hammer":
                            rer1.setText("1 - 2 RER");
                            break;

                        //ejercicios simples

                        case "Aperturas con mancuernas en banco plano":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Aperturas con mancuernas en banco inclinado":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Aperturas en peck deck":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Fondos":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel medio)":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel bajo)":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel alto)":
                            rer1.setText("0 - 1 RER");
                            break;

                    }


                    switch(ejerciciopecho2){
                        //ejercicios compuestos
                        case "Press con mancuernas en banco plano":
                            rer2.setText("1 - 2 RER");
                            break;
                        case "Press con mancuernas en banco inclinado":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Press de pectorales en maquina":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Press declinado con mancuernas":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Press inclinado con barra":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Press plano con barra":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Press inclinado en smith":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Press horizontal con barra":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Press plano en smith":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Press de pectorales en maquina hammer":
                            rer2.setText("1 - 2 RER");
                            break;

                        //ejercicios simples

                        case "Aperturas con mancuernas en banco plano":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Aperturas con mancuernas en banco inclinado":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Aperturas en peck deck":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Fondos":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel medio)":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel bajo)":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel alto)":
                            rer2.setText("0 - 1 RER");
                            break;

                    }

                    switch(ejerciciopecho3){
                        //ejercicios compuestos
                        case "Press con mancuernas en banco plano":
                            rer3.setText("1 - 2 RER");
                            break;
                        case "Press con mancuernas en banco inclinado":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Press de pectorales en maquina":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Press declinado con mancuernas":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Press inclinado con barra":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Press plano con barra":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Press inclinado en smith":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Press horizontal con barra":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Press plano en smith":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Press de pectorales en maquina hammer":
                            rer3.setText("1 - 2 RER");
                            break;

                        //ejercicios simples

                        case "Aperturas con mancuernas en banco plano":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Aperturas con mancuernas en banco inclinado":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Aperturas en peck deck":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Fondos":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel medio)":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel bajo)":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel alto)":
                            rer3.setText("0 - 1 RER");
                            break;

                    }




                    //TRAPECIOS
                    switch(ejerciciotrapecios){
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

                    switch(ejerciciotrapecios){
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



                    //FRONTAL
                    switch(ejerciciofrontal){
                        //ejercicios compuestos
                        case "Press militar con barra":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Press militar con mancuernas":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Push press":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Press militar en smith":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Press en máquina agarre prono":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Press Arnold":
                            rer11.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Press en máquina agarre neutro":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre prono":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con mancuerna agarre supino":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con polea baja a 1 brazo":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con disco":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontal con cuerda en polea baja":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre neutro":
                            rer11.setText("0 - 1 RER");
                            break;

                    }


                    switch(ejerciciofrontal2){
                        //ejercicios compuestos
                        case "Press militar con barra":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Press militar con mancuernas":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Push press":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Press militar en smith":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Press en máquina agarre prono":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Press Arnold":
                            rer12.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Press en máquina agarre neutro":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre prono":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con mancuerna agarre supino":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con polea baja a 1 brazo":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con disco":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontal con cuerda en polea baja":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre neutro":
                            rer12.setText("0 - 1 RER");
                            break;

                    }






                    //triceps
                    switch(ejerciciotriceps){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Press cerrado en smith":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Copa con barra":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer9.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Fondos en máquina":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer9.setText("0 - 1 RER");
                            break;

                    }


                    switch(ejerciciotriceps2){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Press cerrado en smith":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Copa con barra":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer10.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Fondos en máquina":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer10.setText("0 - 1 RER");
                            break;

                    }






                    //BICEPS
                    switch(ejerciciobiceps){
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

                    switch(ejerciciobiceps2){
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

                    switch(ejercicioespalda){
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

                    switch(ejercicioespalda2){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Remo pendlay":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Dominadas":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer5.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer5.setText("0 - 1 RER");
                            break;


                    }

                    switch(ejercicioespalda3){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Remo pendlay":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Dominadas":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer6.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer6.setText("0 - 1 RER");
                            break;


                    }










                }

                // RER MEDIO 2 - 3  Y 1 - 2

                if (rer1int>13 && rer1int<=17){


                    //pectoral
                    switch(ejerciciopecho){
                        //ejercicios compuestos
                        case "Press con mancuernas en banco plano":
                            rer1.setText("2 - 3 RER");
                            break;
                        case "Press con mancuernas en banco inclinado":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Press de pectorales en maquina":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Press declinado con mancuernas":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Press inclinado con barra":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Press plano con barra":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Press inclinado en smith":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Press horizontal con barra":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Press plano en smith":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Press de pectorales en maquina hammer":
                            rer1.setText("2 - 3 RER");
                            break;

                        //ejercicios simples

                        case "Aperturas con mancuernas en banco plano":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Aperturas con mancuernas en banco inclinado":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Aperturas en peck deck":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Fondos":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel medio)":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel bajo)":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel alto)":
                            rer1.setText("1 - 2 RER");
                            break;

                    }

                    switch(ejerciciopecho2){
                        //ejercicios compuestos
                        case "Press con mancuernas en banco plano":
                            rer2.setText("2 - 3 RER");
                            break;
                        case "Press con mancuernas en banco inclinado":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Press de pectorales en maquina":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Press declinado con mancuernas":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Press inclinado con barra":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Press plano con barra":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Press inclinado en smith":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Press horizontal con barra":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Press plano en smith":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Press de pectorales en maquina hammer":
                            rer2.setText("2 - 3 RER");
                            break;

                        //ejercicios simples

                        case "Aperturas con mancuernas en banco plano":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Aperturas con mancuernas en banco inclinado":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Aperturas en peck deck":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Fondos":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel medio)":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel bajo)":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel alto)":
                            rer2.setText("1 - 2 RER");
                            break;

                    }

                    switch(ejerciciopecho3){
                        //ejercicios compuestos
                        case "Press con mancuernas en banco plano":
                            rer3.setText("2 - 3 RER");
                            break;
                        case "Press con mancuernas en banco inclinado":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Press de pectorales en maquina":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Press declinado con mancuernas":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Press inclinado con barra":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Press plano con barra":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Press inclinado en smith":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Press horizontal con barra":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Press plano en smith":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Press de pectorales en maquina hammer":
                            rer3.setText("2 - 3 RER");
                            break;

                        //ejercicios simples

                        case "Aperturas con mancuernas en banco plano":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Aperturas con mancuernas en banco inclinado":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Aperturas en peck deck":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Fondos":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel medio)":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel bajo)":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Aperturas en crossover (polea a nivel alto)":
                            rer3.setText("1 - 2 RER");
                            break;

                    }




                    //TRAPECIOS
                    switch(ejerciciotrapecios){
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


                    switch(ejerciciotrapecios2){
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




                    //FRONTAL
                    switch(ejerciciofrontal){
                        //ejercicios compuestos
                        case "Press militar con barra":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Press militar con mancuernas":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Push press":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Press militar en smith":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Press en máquina agarre prono":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Press Arnold":
                            rer11.setText("2 - 3 RER");
                            break;




                        //ejercicios simples
                        case "Press en máquina agarre neutro":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre prono":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con mancuerna agarre supino":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con polea baja a 1 brazo":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con disco":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontal con cuerda en polea baja":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre neutro":
                            rer11.setText("1 - 2 RER");
                            break;

                    }


                    switch(ejerciciofrontal2){
                        //ejercicios compuestos
                        case "Press militar con barra":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Press militar con mancuernas":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Push press":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Press militar en smith":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Press en máquina agarre prono":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Press Arnold":
                            rer12.setText("2 - 3 RER");
                            break;




                        //ejercicios simples
                        case "Press en máquina agarre neutro":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre prono":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con mancuerna agarre supino":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con polea baja a 1 brazo":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con disco":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontal con cuerda en polea baja":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre neutro":
                            rer12.setText("1 - 2 RER");
                            break;

                    }



                    //triceps
                    switch(ejerciciotriceps){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Press cerrado en smith":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Copa con barra":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer9.setText("2 - 3 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Fondos en máquina":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer9.setText("1 - 2 RER");
                            break;

                    }

                    switch(ejerciciotriceps2){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Press cerrado en smith":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Copa con barra":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer10.setText("2 - 3 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Fondos en máquina":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer10.setText("1 - 2 RER");
                            break;

                    }








                    //BICEPS
                    switch(ejerciciobiceps){
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

                    switch(ejerciciobiceps2){
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
                    switch(ejercicioespalda2){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Remo pendlay":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Dominadas":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer5.setText("2 - 3 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer5.setText("1 - 2 RER");
                            break;


                    }

                    switch(ejercicioespalda3){
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Remo pendlay":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Dominadas":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer6.setText("2 - 3 RER");
                            break;



                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer6.setText("1 - 2 RER");
                            break;


                    }


                }




//-------------------------------------------------------------------------------------------------------------------------------------------------------------

                //SERIES

                String spectoral = datasnapshot.child("series pectoral").getValue().toString();
                Double sp = Double.parseDouble(spectoral);
                Double spdividido = sp / 2;
                Double spf = Math.ceil(spdividido);
                Double spf1 = spf / 3;
                Double spf2 = spf / 3;
                Double spf3 = spf / 3;
                int spfint = (int) Math.ceil(spf1);
                int spfint2 = (int) Math.round(spf2);
                int spfint3 = (int) Math.floor(spf3);
                String seriesfinalpectoral = String.valueOf(spfint);
                String seriesfinalpectoral2 = String.valueOf(spfint2);
                String seriesfinalpectoral3 = String.valueOf(spfint3);
                seriespectoral.setText(seriesfinalpectoral + " Series");
                seriespectoral2.setText(seriesfinalpectoral2 + " Series");
                seriespectoral3.setText(seriesfinalpectoral3 + " Series");



                String sespalda = datasnapshot.child("series espalda").getValue().toString();
                Double se = Double.parseDouble(sespalda);
                Double sedividido = se / 2;
                Double sef = Math.ceil(sedividido);
                Double sef1 = sef / 3;
                Double sef2 = sef / 3;
                Double sef3 = sef / 3;
                int sefint = (int) Math.ceil(sef1);
                int sefint2 = (int) Math.round(sef2);
                int sefint3 = (int) Math.floor(sef3);
                String seriesfinalespalda = String.valueOf(sefint);
                String seriesfinalespalda2 = String.valueOf(sefint2);
                String seriesfinalespalda3 = String.valueOf(sefint3);
                seriesespalda.setText(seriesfinalespalda + " Series");
                seriesespalda2.setText(seriesfinalespalda2 + " Series");
                seriesespalda3.setText(seriesfinalespalda3 + " Series");



                String sbiceps = datasnapshot.child("series biceps").getValue().toString();
                Double sb = Double.parseDouble(sbiceps);
                Double sbdividido = sb / 2;
                Double sbf = Math.ceil(sbdividido);
                Double sbf1 = sbf / 2;
                Double sbf2 = sbf / 2;
                int sbfint = (int) Math.ceil(sbf1);
                int sbfint2 = (int) Math.floor(sbf2);
                String seriesfinalbiceps = String.valueOf(sbfint);
                String seriesfinalbiceps2 = String.valueOf(sbfint2);
                seriesbiceps.setText(seriesfinalbiceps + " Series");
                seriesbiceps2.setText(seriesfinalbiceps2 + " Series");


                String striceps = datasnapshot.child("series triceps").getValue().toString();
                Double str = Double.parseDouble(striceps);
                Double strdividido = str / 2;
                Double strf = Math.ceil(strdividido);
                Double strf1 = strf / 2;
                Double strf2 = strf / 2;
                int strfint = (int) Math.ceil(strf1);
                int strfint2 = (int) Math.round(strf2);
                String seriesfinaltriceps = String.valueOf(strfint);
                String seriesfinaltriceps2 = String.valueOf(strfint2);
                seriestriceps.setText(seriesfinaltriceps + " Series");
                seriestriceps2.setText(seriesfinaltriceps2 + " Series");


                String sfrontal = datasnapshot.child("series deltoide frontal").getValue().toString();
                Double sfr = Double.parseDouble(sfrontal);
                Double sfrontaldividido = sfr / 2;
                Double sfrontalf = Math.ceil(sfrontaldividido);
                Double sfrontalf1 = sfrontalf / 2;
                Double sfrontal2 = sfrontalf / 2;
                int sfrontalint = (int) Math.round(sfrontalf1);
                int sfrontalint2 = (int) Math.floor(sfrontal2);
                String seriesfinalfrontal = String.valueOf(sfrontalint);
                String seriesfinalfrontal2 = String.valueOf(sfrontalint2);
                seriesfrontal.setText(seriesfinalfrontal + " Series");
                seriesfrontal2.setText(seriesfinalfrontal2 + " Series");




                String strapecios = datasnapshot.child("series trapecios").getValue().toString();
                Double straps = Double.parseDouble(strapecios);
                Double strapeciosdividido = straps / 2;
                Double strapsf = Math.ceil(strapeciosdividido);
                Double strapsf1 = strapsf / 2;
                Double strapsfs2 = strapsf / 2;
                int strapeciosint = (int) Math.round(strapsf1);
                int strapeciosint2 = (int) Math.floor(strapsfs2);
                String seriesfinaltrapecios = String.valueOf(strapeciosint);
                String seriesfinaltrapecios2 = String.valueOf(strapeciosint2);
                seriestraps.setText(seriesfinaltrapecios + " Series");
                seriestraps2.setText(seriesfinaltrapecios2 + " Series");








                String stringpesoinicial = datasnapshot.child("Historial pectoral/ 4 dias/ primer ejercicio/ dia 1").getValue().toString();
                peso1.setText(stringpesoinicial);

                String stringpesoinicial2 = datasnapshot.child("Historial pectoral/ 4 dias/ segundo ejercicio/ dia 1").getValue().toString();
                peso2.setText(stringpesoinicial2);

                String stringpesoinicial3 = datasnapshot.child("Historial pectoral/ 4 dias/ tercer ejercicio/ dia 1").getValue().toString();
                peso3.setText(stringpesoinicial3);



                String stringpesoinicialespalda = datasnapshot.child("Historial espalda/ 4 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesoespalda.setText(stringpesoinicialespalda);

                String stringpesoinicialespalda2 = datasnapshot.child("Historial espalda/ 4 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesoespalda2.setText(stringpesoinicialespalda2);

                String stringpesoinicialespalda3 = datasnapshot.child("Historial espalda/ 4 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesoespalda3.setText(stringpesoinicialespalda3);



                String stringpesoinicialbiceps = datasnapshot.child("Historial biceps/ 4 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesobiceps.setText(stringpesoinicialbiceps);

                String stringpesoinicialbiceps2 = datasnapshot.child("Historial biceps/ 4 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesobiceps2.setText(stringpesoinicialbiceps2);



                String stringpesoinicialtriceps = datasnapshot.child("Historial triceps/ 4 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesotriceps.setText(stringpesoinicialtriceps);

                String stringpesoinicialtriceps2 = datasnapshot.child("Historial triceps/ 4 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesotriceps2.setText(stringpesoinicialtriceps2);



                String stringpesoinicialfrontal = datasnapshot.child("Historial frontal/ 4 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesofrontal.setText(stringpesoinicialfrontal);

                String stringpesoinicialfrontal2 = datasnapshot.child("Historial frontal/ 4 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesofrontal2.setText(stringpesoinicialfrontal2);



                String stringpesoinicialtrapecios = datasnapshot.child("Historial trapecios/ 4 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesotrapecios.setText(stringpesoinicialtrapecios);

                String stringpesoinicialtrapecios2 = datasnapshot.child("Historial trapecios/ 4 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesotrapecios2.setText(stringpesoinicialtrapecios2);













            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//permite dejar puesto el peso ingresado en el edit text
        peso1.addTextChangedListener(new TextWatcher() {
                                         @Override
                                         public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                         }

                                         @Override
                                         public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                         }

                                         @Override
                                         public void afterTextChanged(Editable editable) {
                                             SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(peso1.getContext());
                                             preferences.edit().putString("editText",editable.toString()).commit();



                                         }
                                     }
        );


        peso2.addTextChangedListener(new TextWatcher() {
                                         @Override
                                         public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                         }

                                         @Override
                                         public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                         }

                                         @Override
                                         public void afterTextChanged(Editable editable) {
                                             SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(peso2.getContext());
                                             preferences.edit().putString("editText",editable.toString()).commit();



                                         }
                                     }
        );



        peso3.addTextChangedListener(new TextWatcher() {
                                         @Override
                                         public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                         }

                                         @Override
                                         public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                         }

                                         @Override
                                         public void afterTextChanged(Editable editable) {
                                             SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(peso3.getContext());
                                             preferences.edit().putString("editText",editable.toString()).commit();



                                         }
                                     }
        );


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


        pesobiceps.addTextChangedListener(new TextWatcher() {
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

        pesotriceps.addTextChangedListener(new TextWatcher() {
                                         @Override
                                         public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                         }

                                         @Override
                                         public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                         }

                                         @Override
                                         public void afterTextChanged(Editable editable) {
                                             SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesotriceps.getContext());
                                             preferences.edit().putString("editText",editable.toString()).commit();



                                         }
                                     }
        );


        pesotriceps2.addTextChangedListener(new TextWatcher() {
                                         @Override
                                         public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                         }

                                         @Override
                                         public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                         }

                                         @Override
                                         public void afterTextChanged(Editable editable) {
                                             SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesotriceps2.getContext());
                                             preferences.edit().putString("editText",editable.toString()).commit();



                                         }
                                     }
        );



        pesofrontal.addTextChangedListener(new TextWatcher() {
                                         @Override
                                         public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                         }

                                         @Override
                                         public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                         }

                                         @Override
                                         public void afterTextChanged(Editable editable) {
                                             SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesofrontal.getContext());
                                             preferences.edit().putString("editText",editable.toString()).commit();



                                         }
                                     }
        );


        pesofrontal2.addTextChangedListener(new TextWatcher() {
                                         @Override
                                         public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                         }

                                         @Override
                                         public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                         }

                                         @Override
                                         public void afterTextChanged(Editable editable) {
                                             SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesofrontal2.getContext());
                                             preferences.edit().putString("editText",editable.toString()).commit();



                                         }
                                     }
        );



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



        rer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno4dialunes.this, rer.class);
                startActivity(intent);
            }
        });

        rer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno4dialunes.this, rer.class);
                startActivity(intent);
            }
        });

        rer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno4dialunes.this, rer.class);
                startActivity(intent);
            }
        });

        rer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno4dialunes.this, rer.class);
                startActivity(intent);
            }
        });


        rer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno4dialunes.this, rer.class);
                startActivity(intent);
            }
        });


        rer6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno4dialunes.this, rer.class);
                startActivity(intent);
            }
        });


        rer7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno4dialunes.this, rer.class);
                startActivity(intent);
            }
        });

        rer8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno4dialunes.this, rer.class);
                startActivity(intent);
            }
        });

        rer9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno4dialunes.this, rer.class);
                startActivity(intent);
            }
        });

        rer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno4dialunes.this, rer.class);
                startActivity(intent);
            }
        });

        rer11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno4dialunes.this, rer.class);
                startActivity(intent);
            }
        });

        rer12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno4dialunes.this, rer.class);
                startActivity(intent);
            }
        });

        rer13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno4dialunes.this, rer.class);
                startActivity(intent);
            }
        });

        rer14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno4dialunes.this, rer.class);
                startActivity(intent);
            }
        });







    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void findelentrenamiento1 (View view){

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
                    mInterstitialAd.show(entreno4dialunes.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }

            }
        }, 300);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();
        String datoejercicio1 = peso1.getText().toString();
        String datoejercicio1_2 = peso2.getText().toString();
        String datoejercicio1_3 = peso3.getText().toString();

        String datoejercicio2 = pesoespalda.getText().toString();
        String datoejercicio2_2 = pesoespalda2.getText().toString();
        String datoejercicio2_3 = pesoespalda3.getText().toString();

        String datoejercicio3 = pesobiceps.getText().toString();
        String datoejercicio3_2 = pesobiceps2.getText().toString();

        String datoejercicio4 = pesotriceps.getText().toString();
        String datoejercicio4_2 = pesotriceps2.getText().toString();

        String datoejercicio5 = pesofrontal.getText().toString();
        String datoejercicio5_2 = pesofrontal2.getText().toString();

        String datoejercicio10 = pesotrapecios.getText().toString();
        String datoejercicio10_2 = pesotrapecios2.getText().toString();



        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                Map<String, Object> pesoactualizandose2 = new HashMap<>();
                pesoactualizandose2.put("Historial pectoral/ 4 dias/ primer ejercicio/ dia 1", datoejercicio1);
                pesoactualizandose2.put("Historial pectoral/ 4 dias/ segundo ejercicio/ dia 1", datoejercicio1_2);
                pesoactualizandose2.put("Historial pectoral/ 4 dias/ tercer ejercicio/ dia 1", datoejercicio1_3);

                pesoactualizandose2.put("Historial espalda/ 4 dias/ primer ejercicio/ dia 1", datoejercicio2);
                pesoactualizandose2.put("Historial espalda/ 4 dias/ segundo ejercicio/ dia 1", datoejercicio2_2);
                pesoactualizandose2.put("Historial espalda/ 4 dias/ tercer ejercicio/ dia 1", datoejercicio2_3);

                pesoactualizandose2.put("Historial biceps/ 4 dias/ primer ejercicio/ dia 1", datoejercicio3);
                pesoactualizandose2.put("Historial biceps/ 4 dias/ segundo ejercicio/ dia 1", datoejercicio3_2);

                pesoactualizandose2.put("Historial triceps/ 4 dias/ primer ejercicio/ dia 1", datoejercicio4);
                pesoactualizandose2.put("Historial triceps/ 4 dias/ segundo ejercicio/ dia 1", datoejercicio4_2);

                pesoactualizandose2.put("Historial frontal/ 4 dias/ primer ejercicio/ dia 1", datoejercicio5);
                pesoactualizandose2.put("Historial frontal/ 4 dias/ segundo ejercicio/ dia 1", datoejercicio5_2);

                pesoactualizandose2.put("Historial trapecios/ 4 dias/ primer ejercicio/ dia 1", datoejercicio10);
                pesoactualizandose2.put("Historial trapecios/ 4 dias/ segundo ejercicio/ dia 1", datoejercicio10_2);


                mDatabase.child("Users").child(id).updateChildren(pesoactualizandose2);

                //si se modifica el datachange en algun otro momento envia a esta pantalla, por lo cual se condiciona el envio
                boolean botonpresionado = true;

                if (botonpresionado == true){

                    Intent findelentrenamiento = new Intent(entreno4dialunes.this, entrenamientofinalizado.class);
                    String valor2 = getIntent().getExtras().getString("actual");
                    findelentrenamiento.putExtra("actual", valor2);
                    findelentrenamiento.putExtra("entreno?", "si");
                    startActivity(findelentrenamiento);
                    finish();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }



    public void ejercicio (View view){
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("pectoral/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno4dialunes.this, ejercicio.class);
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
                String ej = datasnapshot.child("pectoral/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno4dialunes.this, ejercicio.class);
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
                String ej = datasnapshot.child("pectoral/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno4dialunes.this, ejercicio.class);
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
                String ej = datasnapshot.child("espalda/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno4dialunes.this, ejercicio.class);
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
                String ej = datasnapshot.child("espalda/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno4dialunes.this, ejercicio.class);
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
                String ej = datasnapshot.child("espalda/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno4dialunes.this, ejercicio.class);
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
                String ej = datasnapshot.child("biceps/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno4dialunes.this, ejercicio.class);
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
                String ej = datasnapshot.child("biceps/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno4dialunes.this, ejercicio.class);
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
                String ej = datasnapshot.child("triceps/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno4dialunes.this, ejercicio.class);
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
                String ej = datasnapshot.child("triceps/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno4dialunes.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    public void ejercicio5 (View view){
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("deltoide frontal/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno4dialunes.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    public void ejercicio5parte2 (View view){
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("deltoide frontal/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno4dialunes.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void ejercicio6 (View view){
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("trapecios/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno4dialunes.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    public void ejercicio6parte2 (View view){
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("trapecios/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno4dialunes.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}
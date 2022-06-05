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

public class entreno6diamartesmujer extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private EditText pesolateral3, pesobiceps3, pesolateral2, pesoespalda, pesoespalda2, pesoabdomen, pesoabdomen2,
            pesoespalda3, pesobiceps, pesobiceps2, pesolateral;
    private String ejercicioseleccionadoespalda, ejercicioseleccionadobiceps3, ejercicioseleccionadolateral, ejercicioseleccionadolateral2,
            ejercicioseleccionadobiceps;
    private TextView rer1, rer2, rer3, rer4, rer5, rer6, rer7, rer8, rer9, rer10, rer91, rer11, rer17, rer18, rer19, rer12, rer13, rer14, rer15, rer16;
    private TextView fechacompleta;
    private TextView serieslateral2, serieslateral3, ejerciciobiceps,  seriesbiceps3, ejerciciobiceps3, repeticionesbiceps3, ejerciciobiceps2, repeticionesbiceps2,
            ejerciciolateral3, repeticioneslateral3,  ejerciciolateral2, seriesabdomen, seriesabdomen2,
            ejercicioabdomen2,  repeticioneslateral2, repeticionesabdomen, repeticionesabdomen2,
            seriesespalda, seriesespalda2, seriesespalda3, seriesbiceps, seriesbiceps2, serieslateral;
    private Spinner  spinner14, spinner91,  spinner15,  spinner4, spinner5, spinner7, spinner8, spinner9, spinner10, spinner11,  spinner13;
    private  TextView  ejercicioespalda, ejercicioespalda2, ejercicioespalda3,
            repeticionesespalda2, repeticionesespalda3, repeticionesespalda,  repeticionesbiceps, ejerciciolateral, repeticioneslateral,  ejercicioabdomen;
    private ImageView imagenpectoral, imagenlaterales3, imagenlaterales2, imagenbiceps3, imagenbiceps2, imagenabdomen2, imagenabdomen,
        imagenespalda, imagenespalda2, imagenespalda3, imagenbiceps,  imagenlaterales;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private String  ejercicioseleccionadoabdomen,   ejercicioseleccionadolateral3, ejercicioseleccionadoabdomen2,  ejercicioseleccionadoespalda2,
            ejercicioseleccionadoespalda3,  ejercicioseleccionadobiceps2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_entreno6diamartesmujer);

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


        fechacompleta = (TextView) findViewById(R.id.textView273611);
        Date date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("d MMM yyyy");
        String sfecha = fecha.format(date);
        fechacompleta.setText(sfecha);


        Toolbar toolbar = findViewById(R.id.toolbarentreno6diamartesmujer);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Entrenamiento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        spinner4 = (Spinner) findViewById(R.id.spinner4611);
        spinner5 = (Spinner) findViewById(R.id.spinner5611);
        spinner7 = (Spinner) findViewById(R.id.spinner13espalda3611);


        spinner8 = (Spinner) findViewById(R.id.spinner7611);
        spinner9 = (Spinner) findViewById(R.id.spinner8611);
        spinner91 = (Spinner) findViewById(R.id.spinner81611);


        spinner10 = (Spinner) findViewById(R.id.spinner13611);
        spinner11 = (Spinner) findViewById(R.id.spinner14611);
        spinner13 = (Spinner) findViewById(R.id.spinner142lateral3611);

        spinner14 = (Spinner) findViewById(R.id.spinner13abs3511);
        spinner15 = (Spinner) findViewById(R.id.spinner142abs3511);


        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner4.setAdapter(adapter4);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner5.setAdapter(adapter5);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner7.setAdapter(adapter7);

        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner8.setAdapter(adapter8);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner9.setAdapter(adapter9);
        ArrayAdapter<CharSequence> adapter91 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner91.setAdapter(adapter91);

        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner10.setAdapter(adapter10);
        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner11.setAdapter(adapter11);
        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner13.setAdapter(adapter13);


        ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner14.setAdapter(adapter14);
        ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner15.setAdapter(adapter15);



        rer4 = findViewById(R.id.buttonrer4a611);
        rer5 = findViewById(R.id.buttonrer5a611);
        rer7 = findViewById(R.id.buttonrer13espalda3611);


        rer8 = findViewById(R.id.buttonrer7a611);
        rer9 = findViewById(R.id.buttonrer8a611);
        rer91 = findViewById(R.id.buttonrer8a1611);


        rer14 = findViewById(R.id.buttonrer13a611);
        rer15 = findViewById(R.id.buttonrer14a611);
        rer16 = findViewById(R.id.buttonrer14a2lateral3611);


        rer17 = findViewById(R.id.buttonrer13abs3511);
        rer18 = findViewById(R.id.buttonrer14a2abs3511);



        //espalda 3
        ejercicioespalda = (TextView) findViewById(R.id.textView219espalda1611);
        repeticionesespalda = (TextView) findViewById(R.id.textView221espalda1611);
        imagenespalda = (ImageView) findViewById(R.id.imageView11espalda1611);
        pesoespalda = (EditText) findViewById(R.id.textView222espalda1611);
        seriesespalda = (TextView) findViewById(R.id.textView220espalda1611);

        ejercicioespalda2 = (TextView) findViewById(R.id.textView219espalda2611);
        repeticionesespalda2 = (TextView) findViewById(R.id.textView221espalda2611);
        imagenespalda2 = (ImageView) findViewById(R.id.imageView11espalda2611);
        pesoespalda2 = (EditText) findViewById(R.id.textView222espalda2611);
        seriesespalda2 = (TextView) findViewById(R.id.textView220espalda2611);

        ejercicioespalda3 = (TextView) findViewById(R.id.textView219espalda3611);
        repeticionesespalda3 = (TextView) findViewById(R.id.textView221espalda3611);
        imagenespalda3 = (ImageView) findViewById(R.id.imageView11espalda3611);
        pesoespalda3 = (EditText) findViewById(R.id.textView222espalda3611);
        seriesespalda3 = (TextView) findViewById(R.id.textView220espalda3611);


        //biceps 2
        ejerciciobiceps = (TextView) findViewById(R.id.textView219biceps1611);
        repeticionesbiceps = (TextView) findViewById(R.id.textView221biceps1611);
        imagenbiceps = (ImageView) findViewById(R.id.imageView11biceps1611);
        pesobiceps = (EditText) findViewById(R.id.textView222biceps1611);
        seriesbiceps = (TextView) findViewById(R.id.textView220biceps1611);

        ejerciciobiceps2 = (TextView) findViewById(R.id.textView219biceps2611);
        repeticionesbiceps2 = (TextView) findViewById(R.id.textView221biceps2611);
        imagenbiceps2 = (ImageView) findViewById(R.id.imageView11biceps2611);
        pesobiceps2 = (EditText) findViewById(R.id.textView222biceps2611);
        seriesbiceps2 = (TextView) findViewById(R.id.textView220biceps2611);

        ejerciciobiceps3 = (TextView) findViewById(R.id.textView219biceps21611);
        repeticionesbiceps3 = (TextView) findViewById(R.id.textView221biceps21611);
        imagenbiceps3 = (ImageView) findViewById(R.id.imageView11biceps21611);
        pesobiceps3 = (EditText) findViewById(R.id.textView222biceps21611);
        seriesbiceps3 = (TextView) findViewById(R.id.textView220biceps21611);


        //laterales 3

        ejerciciolateral = (TextView) findViewById(R.id.textView219traps1611);
        repeticioneslateral = (TextView) findViewById(R.id.textView221traps1611);
        imagenlaterales = (ImageView) findViewById(R.id.imageView11traps1611);
        pesolateral = (EditText) findViewById(R.id.textView222traps1611);
        serieslateral = (TextView) findViewById(R.id.textView220traps1611);


        ejerciciolateral2 = (TextView) findViewById(R.id.textView219traps2611);
        repeticioneslateral2 = (TextView) findViewById(R.id.textView221traps2611);
        imagenlaterales2 = (ImageView) findViewById(R.id.imageView11traps2611);
        pesolateral2 = (EditText) findViewById(R.id.textView222traps2611);
        serieslateral2 = (TextView) findViewById(R.id.textView220traps2611);


        ejerciciolateral3 = (TextView) findViewById(R.id.textView2192lateral3611);
        repeticioneslateral3 = (TextView) findViewById(R.id.textView2212lateral3611);
        imagenlaterales3 = (ImageView) findViewById(R.id.imageView112lateral3611);
        pesolateral3 = (EditText) findViewById(R.id.textView2222lateral3611);
        serieslateral3 = (TextView) findViewById(R.id.textView2202lateral3611);

//abdomen 3
        ejercicioabdomen = (TextView) findViewById(R.id.textView219abs3511);
        repeticionesabdomen = (TextView) findViewById(R.id.textView221abs3511);
        imagenabdomen = (ImageView) findViewById(R.id.imageView11abs3511);
        pesoabdomen = (EditText) findViewById(R.id.textView222abs3511);
        seriesabdomen = (TextView) findViewById(R.id.textView220abs3511);


        ejercicioabdomen2 = (TextView) findViewById(R.id.textView2192abs3511);
        repeticionesabdomen2 = (TextView) findViewById(R.id.textView2212abs3511);
        imagenabdomen2 = (ImageView) findViewById(R.id.imageView112abs3511);
        pesoabdomen2 = (EditText) findViewById(R.id.textView2222abs3511);
        seriesabdomen2 = (TextView) findViewById(R.id.textView2202abs3511);



        mAuth = FirebaseAuth.getInstance();

        //logicadelentrenamiento(ejercicios)


        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();


        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if (datasnapshot.exists()) {


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

                    String stringejerciciobiceps3 = datasnapshot.child("biceps/ ejercicio tercero").getValue().toString();
                    ejerciciobiceps3.setText(stringejerciciobiceps3);
                    ejercicioseleccionadobiceps3 = stringejerciciobiceps3;


                    String stringejerciciofrontal2 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio primario").getValue().toString();
                    ejerciciolateral.setText(stringejerciciofrontal2);
                    ejercicioseleccionadolateral = stringejerciciofrontal2;

                    String stringejerciciofrontal3 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio secundario").getValue().toString();
                    ejerciciolateral2.setText(stringejerciciofrontal3);
                    ejercicioseleccionadolateral2 = stringejerciciofrontal3;

                    String stringejercicioabs = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();
                    ejerciciolateral3.setText(stringejercicioabs);
                    ejercicioseleccionadolateral3 = stringejercicioabs;


                    String stringejercicioab = datasnapshot.child("abdominales/ ejercicio primario").getValue().toString();
                    ejercicioabdomen.setText(stringejercicioab);
                    ejercicioseleccionadoabdomen = stringejercicioab;

                    String stringejercicioab2 = datasnapshot.child("abdominales/ ejercicio secundario").getValue().toString();
                    ejercicioabdomen2.setText(stringejercicioab2);
                    ejercicioseleccionadoabdomen2 = stringejercicioab2;


                }


                //---





                //abs
                if (ejercicioseleccionadoabdomen.equals("Crunch abdominal en maquina con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20maquina%20con%20cuerda%2F20210203_122801.jpg?alt=media&token=b7b6492d-0e43-4d80-8e4a-58a874b0b740")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch abdominal")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121917.jpg?alt=media&token=6a7354cf-d38a-4931-ae6d-3bd5a0a6f1a1")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch abdominal en maquina")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123647.jpg?alt=media&token=21d241b4-69a6-4e42-8f6b-d8eab01d5e16")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Rodillo abdominal")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112445.jpg?alt=media&token=65fbc2e2-c04e-4300-af76-36ba341c3a1b")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Elevaciones de piernas acostado en banco")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854.jpg?alt=media&token=9cab081e-a91e-40ef-8be1-e481445eddd1")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Elevaciones de piernas en silla romana")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112604.jpg?alt=media&token=a27b1953-a16e-419b-b206-ad01ebf5138d")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch tipo bicicleta")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch abdominal en banco declinado")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113147.jpg?alt=media&token=55b3d636-887e-4c01-ba37-e274fce2e1d1")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch abdominal en banco declinado con balon en la nuca")) {
                    int reps = 8;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113217.jpg?alt=media&token=a6ad17e7-d218-41c7-9412-b26ffd74fc38")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch acostado en flexión de piernas")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20con%20flexi%C3%B3n%20de%20piernas%2F20211210_113340.jpg?alt=media&token=063a87c6-0413-4e4f-b103-8e1892a93987")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch lateral")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113437.jpg?alt=media&token=eccbfefe-6820-4879-b370-0ccb1454573e")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Toques al talón")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113834.jpg?alt=media&token=3521bce4-bbd0-4936-9994-1df7bd3f72d4")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch lateral con polea alta")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113702.jpg?alt=media&token=1717a072-a610-449b-8a35-3dec01aded1a")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch abdominal hincado con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112931.jpg?alt=media&token=6dc6d69c-958a-4c9d-b5c3-0cd990fde57a")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }




                //abs
                if (ejercicioseleccionadoabdomen2.equals("Crunch abdominal en maquina con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20maquina%20con%20cuerda%2F20210203_122801.jpg?alt=media&token=b7b6492d-0e43-4d80-8e4a-58a874b0b740")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch abdominal")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121917.jpg?alt=media&token=6a7354cf-d38a-4931-ae6d-3bd5a0a6f1a1")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch abdominal en maquina")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123647.jpg?alt=media&token=21d241b4-69a6-4e42-8f6b-d8eab01d5e16")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Rodillo abdominal")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112445.jpg?alt=media&token=65fbc2e2-c04e-4300-af76-36ba341c3a1b")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Elevaciones de piernas acostado en banco")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854.jpg?alt=media&token=9cab081e-a91e-40ef-8be1-e481445eddd1")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Elevaciones de piernas en silla romana")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112604.jpg?alt=media&token=a27b1953-a16e-419b-b206-ad01ebf5138d")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch tipo bicicleta")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch abdominal en banco declinado")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113147.jpg?alt=media&token=55b3d636-887e-4c01-ba37-e274fce2e1d1")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch abdominal en banco declinado con balon en la nuca")) {
                    int reps = 8;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113217.jpg?alt=media&token=a6ad17e7-d218-41c7-9412-b26ffd74fc38")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch acostado en flexión de piernas")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20con%20flexi%C3%B3n%20de%20piernas%2F20211210_113340.jpg?alt=media&token=063a87c6-0413-4e4f-b103-8e1892a93987")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch lateral")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113437.jpg?alt=media&token=eccbfefe-6820-4879-b370-0ccb1454573e")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Toques al talón")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113834.jpg?alt=media&token=3521bce4-bbd0-4936-9994-1df7bd3f72d4")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch lateral con polea alta")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113702.jpg?alt=media&token=1717a072-a610-449b-8a35-3dec01aded1a")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch abdominal hincado con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112931.jpg?alt=media&token=6dc6d69c-958a-4c9d-b5c3-0cd990fde57a")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
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



                //-----


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


                //-----

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




                //laterales
                if (ejercicioseleccionadolateral.equals("Elevaciones laterales con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaciones%20laterales%20con%20mancuernas%2F20210131_105249.jpg?alt=media&token=2ffa2e63-ca3c-4b91-900d-2a3b938a3932")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }


                if (ejercicioseleccionadolateral.equals("Elevación lateral con polea baja")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20polea%20baja%2F20210313_121731.jpg?alt=media&token=5248be4d-3506-4e15-8134-f5f4e06e2c8a")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if (ejercicioseleccionadolateral.equals("Flys invertidos en peck deck")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20en%20peck%20deck%2Fflye3.jpg?alt=media&token=6c84d085-2518-4319-8e27-444114709d9f")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if (ejercicioseleccionadolateral.equals("Remo al mentón con barra")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20barra%2Frem2.jpg?alt=media&token=d9843316-dd2f-43a3-a8a1-7f7168069624")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if (ejercicioseleccionadolateral.equals("Remo al mentón con polea baja")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem3.jpg.jpg?alt=media&token=b302e29e-81ff-429f-9daa-56c84b18ce6d")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if (ejercicioseleccionadolateral.equals("Elevación lateral con polea baja por detrás")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115743.jpg?alt=media&token=d75af285-55fc-499e-84cc-c13f86539e5c")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if (ejercicioseleccionadolateral.equals("Elevación lateral con mancuernas acostado en banco inclinado de perfil")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120233.jpg?alt=media&token=a40ae582-7b39-4ccd-927b-d64da79c55b8")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if (ejercicioseleccionadolateral.equals("Elevación lateral con mancuerna a 45°")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112606.jpg?alt=media&token=224d744f-9b85-4ea0-b50a-333667af2f9a")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if (ejercicioseleccionadolateral.equals("Flys cruzados con poleas")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if (ejercicioseleccionadolateral.equals("Flys agachado con mancuernas")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20agachados%2F20211210_120455.jpg?alt=media&token=3b398377-2569-4d55-9062-fb9e2011eaf5")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if (ejercicioseleccionadolateral.equals("Facepull con cuerda")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120826.jpg?alt=media&token=dad7d426-1561-4435-aac6-7c7cf954eb73")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if (ejercicioseleccionadolateral.equals("Remo al mentón con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20mancuernas%2F20211210_120546.jpg?alt=media&token=c2160078-997f-46da-8464-35955cd1f23e")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }


                //laterales
                if (ejercicioseleccionadolateral2.equals("Elevaciones laterales con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaciones%20laterales%20con%20mancuernas%2F20210131_105249.jpg?alt=media&token=2ffa2e63-ca3c-4b91-900d-2a3b938a3932")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }


                if (ejercicioseleccionadolateral2.equals("Elevación lateral con polea baja")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20polea%20baja%2F20210313_121731.jpg?alt=media&token=5248be4d-3506-4e15-8134-f5f4e06e2c8a")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if (ejercicioseleccionadolateral2.equals("Flys invertidos en peck deck")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20en%20peck%20deck%2Fflye3.jpg?alt=media&token=6c84d085-2518-4319-8e27-444114709d9f")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if (ejercicioseleccionadolateral2.equals("Remo al mentón con barra")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20barra%2Frem2.jpg?alt=media&token=d9843316-dd2f-43a3-a8a1-7f7168069624")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if (ejercicioseleccionadolateral2.equals("Remo al mentón con polea baja")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem3.jpg.jpg?alt=media&token=b302e29e-81ff-429f-9daa-56c84b18ce6d")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if (ejercicioseleccionadolateral2.equals("Elevación lateral con polea baja por detrás")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115743.jpg?alt=media&token=d75af285-55fc-499e-84cc-c13f86539e5c")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if (ejercicioseleccionadolateral2.equals("Elevación lateral con mancuernas acostado en banco inclinado de perfil")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120233.jpg?alt=media&token=a40ae582-7b39-4ccd-927b-d64da79c55b8")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if (ejercicioseleccionadolateral2.equals("Elevación lateral con mancuerna a 45°")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112606.jpg?alt=media&token=224d744f-9b85-4ea0-b50a-333667af2f9a")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if (ejercicioseleccionadolateral2.equals("Flys cruzados con poleas")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if (ejercicioseleccionadolateral2.equals("Flys agachado con mancuernas")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20agachados%2F20211210_120455.jpg?alt=media&token=3b398377-2569-4d55-9062-fb9e2011eaf5")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if (ejercicioseleccionadolateral2.equals("Facepull con cuerda")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120826.jpg?alt=media&token=dad7d426-1561-4435-aac6-7c7cf954eb73")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if (ejercicioseleccionadolateral2.equals("Remo al mentón con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20mancuernas%2F20211210_120546.jpg?alt=media&token=c2160078-997f-46da-8464-35955cd1f23e")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }


                //laterales
                if (ejercicioseleccionadolateral3.equals("Elevaciones laterales con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaciones%20laterales%20con%20mancuernas%2F20210131_105249.jpg?alt=media&token=2ffa2e63-ca3c-4b91-900d-2a3b938a3932")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }


                if (ejercicioseleccionadolateral3.equals("Elevación lateral con polea baja")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20polea%20baja%2F20210313_121731.jpg?alt=media&token=5248be4d-3506-4e15-8134-f5f4e06e2c8a")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if (ejercicioseleccionadolateral3.equals("Flys invertidos en peck deck")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20en%20peck%20deck%2Fflye3.jpg?alt=media&token=6c84d085-2518-4319-8e27-444114709d9f")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if (ejercicioseleccionadolateral3.equals("Remo al mentón con barra")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20barra%2Frem2.jpg?alt=media&token=d9843316-dd2f-43a3-a8a1-7f7168069624")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if (ejercicioseleccionadolateral3.equals("Remo al mentón con polea baja")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem3.jpg.jpg?alt=media&token=b302e29e-81ff-429f-9daa-56c84b18ce6d")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if (ejercicioseleccionadolateral3.equals("Elevación lateral con polea baja por detrás")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115743.jpg?alt=media&token=d75af285-55fc-499e-84cc-c13f86539e5c")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if (ejercicioseleccionadolateral3.equals("Elevación lateral con mancuernas acostado en banco inclinado de perfil")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120233.jpg?alt=media&token=a40ae582-7b39-4ccd-927b-d64da79c55b8")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if (ejercicioseleccionadolateral3.equals("Elevación lateral con mancuerna a 45°")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112606.jpg?alt=media&token=224d744f-9b85-4ea0-b50a-333667af2f9a")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if (ejercicioseleccionadolateral3.equals("Flys cruzados con poleas")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if (ejercicioseleccionadolateral3.equals("Flys agachado con mancuernas")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20agachados%2F20211210_120455.jpg?alt=media&token=3b398377-2569-4d55-9062-fb9e2011eaf5")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if (ejercicioseleccionadolateral3.equals("Facepull con cuerda")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120826.jpg?alt=media&token=dad7d426-1561-4435-aac6-7c7cf954eb73")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if (ejercicioseleccionadolateral3.equals("Remo al mentón con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20mancuernas%2F20211210_120546.jpg?alt=media&token=c2160078-997f-46da-8464-35955cd1f23e")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }


                //abs
                if (ejercicioseleccionadoabdomen.equals("Crunch abdominal en maquina con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20maquina%20con%20cuerda%2F20210203_122801.jpg?alt=media&token=b7b6492d-0e43-4d80-8e4a-58a874b0b740")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch abdominal")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121917.jpg?alt=media&token=6a7354cf-d38a-4931-ae6d-3bd5a0a6f1a1")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch abdominal en maquina")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123647.jpg?alt=media&token=21d241b4-69a6-4e42-8f6b-d8eab01d5e16")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Rodillo abdominal")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112445.jpg?alt=media&token=65fbc2e2-c04e-4300-af76-36ba341c3a1b")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Elevaciones de piernas acostado en banco")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854.jpg?alt=media&token=9cab081e-a91e-40ef-8be1-e481445eddd1")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Elevaciones de piernas en silla romana")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112604.jpg?alt=media&token=a27b1953-a16e-419b-b206-ad01ebf5138d")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch tipo bicicleta")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch abdominal en banco declinado")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113147.jpg?alt=media&token=55b3d636-887e-4c01-ba37-e274fce2e1d1")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch abdominal en banco declinado con balon en la nuca")) {
                    int reps = 8;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113217.jpg?alt=media&token=a6ad17e7-d218-41c7-9412-b26ffd74fc38")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch acostado en flexión de piernas")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20con%20flexi%C3%B3n%20de%20piernas%2F20211210_113340.jpg?alt=media&token=063a87c6-0413-4e4f-b103-8e1892a93987")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch lateral")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113437.jpg?alt=media&token=eccbfefe-6820-4879-b370-0ccb1454573e")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Toques al talón")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113834.jpg?alt=media&token=3521bce4-bbd0-4936-9994-1df7bd3f72d4")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch lateral con polea alta")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113702.jpg?alt=media&token=1717a072-a610-449b-8a35-3dec01aded1a")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if (ejercicioseleccionadoabdomen.equals("Crunch abdominal hincado con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112931.jpg?alt=media&token=6dc6d69c-958a-4c9d-b5c3-0cd990fde57a")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }




                //abs
                if (ejercicioseleccionadoabdomen2.equals("Crunch abdominal en maquina con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20maquina%20con%20cuerda%2F20210203_122801.jpg?alt=media&token=b7b6492d-0e43-4d80-8e4a-58a874b0b740")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch abdominal")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121917.jpg?alt=media&token=6a7354cf-d38a-4931-ae6d-3bd5a0a6f1a1")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch abdominal en maquina")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123647.jpg?alt=media&token=21d241b4-69a6-4e42-8f6b-d8eab01d5e16")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Rodillo abdominal")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112445.jpg?alt=media&token=65fbc2e2-c04e-4300-af76-36ba341c3a1b")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Elevaciones de piernas acostado en banco")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854.jpg?alt=media&token=9cab081e-a91e-40ef-8be1-e481445eddd1")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Elevaciones de piernas en silla romana")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112604.jpg?alt=media&token=a27b1953-a16e-419b-b206-ad01ebf5138d")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch tipo bicicleta")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch abdominal en banco declinado")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113147.jpg?alt=media&token=55b3d636-887e-4c01-ba37-e274fce2e1d1")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch abdominal en banco declinado con balon en la nuca")) {
                    int reps = 8;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113217.jpg?alt=media&token=a6ad17e7-d218-41c7-9412-b26ffd74fc38")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch acostado en flexión de piernas")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20con%20flexi%C3%B3n%20de%20piernas%2F20211210_113340.jpg?alt=media&token=063a87c6-0413-4e4f-b103-8e1892a93987")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch lateral")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113437.jpg?alt=media&token=eccbfefe-6820-4879-b370-0ccb1454573e")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Toques al talón")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113834.jpg?alt=media&token=3521bce4-bbd0-4936-9994-1df7bd3f72d4")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch lateral con polea alta")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113702.jpg?alt=media&token=1717a072-a610-449b-8a35-3dec01aded1a")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if (ejercicioseleccionadoabdomen2.equals("Crunch abdominal hincado con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112931.jpg?alt=media&token=6dc6d69c-958a-4c9d-b5c3-0cd990fde57a")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }



//-------------------------------------------------------------------------------------------------------------------------------------------------------------
                //RER

                String RER1 = datasnapshot.child("progresosrer").getValue().toString();
                int rer1int = Integer.parseInt(RER1);



                String ejercicioespalda = datasnapshot.child("espalda/ ejercicio primario").getValue().toString();
                String ejercicioespalda2 = datasnapshot.child("espalda/ ejercicio secundario").getValue().toString();
                String ejercicioespalda3 = datasnapshot.child("espalda/ ejercicio tercero").getValue().toString();


                String ejerciciobiceps = datasnapshot.child("biceps/ ejercicio primario").getValue().toString();
                String ejerciciobiceps2 = datasnapshot.child("biceps/ ejercicio secundario").getValue().toString();
                String ejerciciobiceps3 = datasnapshot.child("biceps/ ejercicio tercero").getValue().toString();


                String ejerciciolateral = datasnapshot.child("deltoides laterales y posteriores/ ejercicio primario").getValue().toString();
                String ejerciciolateral2 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio secundario").getValue().toString();
                String ejerciciolateral3 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();


                String ejercicioabdomen = datasnapshot.child("abdominales/ ejercicio primario").getValue().toString();
                String ejercicioabdomen2 = datasnapshot.child("abdominales/ ejercicio secundario").getValue().toString();


                //RER INICIAL 3 - 4 Y 2 - 3
                if (rer1int >= 18) {


                    //abdomen
                    switch(ejercicioabdomen){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer17.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer17.setText("3 - 4 RER");
                            break;

                        case "Rodillo abdominal":
                            rer17.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer17.setText("3 - 4 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer17.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer17.setText("3 - 4 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer17.setText("2 - 3 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer17.setText("2 - 3 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer17.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer17.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal":
                            rer17.setText("2 - 3 RER");
                            break;

                        case "Plancha":
                            rer17.setText("-");
                            break;

                        case "Toques al talón":
                            rer17.setText("2 - 3 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer17.setText("2 - 3 RER");
                            break;

                        case "Crunch lateral":
                            rer17.setText("2 - 3 RER");
                            break;

                    }



                    //abdomen
                    switch(ejercicioabdomen2){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer18.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer18.setText("3 - 4 RER");
                            break;

                        case "Rodillo abdominal":
                            rer18.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer18.setText("3 - 4 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer18.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer18.setText("3 - 4 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer18.setText("2 - 3 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer18.setText("2 - 3 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer18.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer18.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal":
                            rer18.setText("2 - 3 RER");
                            break;

                        case "Plancha":
                            rer18.setText("-");
                            break;

                        case "Toques al talón":
                            rer18.setText("2 - 3 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer18.setText("2 - 3 RER");
                            break;

                        case "Crunch lateral":
                            rer18.setText("2 - 3 RER");
                            break;

                    }





                    //deltoides laterales
                    switch (ejerciciolateral) {
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer14.setText("3 - 4 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer14.setText("3 - 4 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer14.setText("3 - 4 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer14.setText("3 - 4 RER");
                            break;


                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Facepull con cuerda":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer14.setText("2 - 3 RER");
                            break;

                    }

                    //deltoides laterales
                    switch (ejerciciolateral2) {
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer15.setText("3 - 4 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer15.setText("3 - 4 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer15.setText("3 - 4 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer15.setText("3 - 4 RER");
                            break;


                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Facepull con cuerda":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer15.setText("2 - 3 RER");
                            break;

                    }

                    //deltoides laterales
                    switch (ejerciciolateral3) {
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer16.setText("3 - 4 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer16.setText("3 - 4 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer16.setText("3 - 4 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer16.setText("3 - 4 RER");
                            break;


                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Facepull con cuerda":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer16.setText("2 - 3 RER");
                            break;

                    }







                    //BICEPS
                    switch (ejerciciobiceps) {
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


                    //BICEPS
                    switch (ejerciciobiceps2) {
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer9.setText("3 - 4 RER");
                            break;


                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Curl spider con barra":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer9.setText("2 - 3 RER");
                            break;


                    }


                    //BICEPS
                    switch (ejerciciobiceps3) {
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer91.setText("3 - 4 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer91.setText("3 - 4 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer91.setText("3 - 4 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer91.setText("3 - 4 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer91.setText("3 - 4 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer91.setText("3 - 4 RER");
                            break;


                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer91.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer91.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer91.setText("2 - 3 RER");
                            break;

                        case "Curl spider con barra":
                            rer91.setText("2 - 3 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer91.setText("2 - 3 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer91.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer91.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer91.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer91.setText("2 - 3 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer91.setText("2 - 3 RER");
                            break;


                    }


                    //espalda
                    switch (ejercicioespalda2) {
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
                    switch (ejercicioespalda3) {
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Remo pendlay":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Dominadas":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer7.setText("3 - 4 RER");
                            break;


                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer7.setText("2 - 3 RER");
                            break;


                    }


                    //espalda
                    switch (ejercicioespalda) {
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


//--------------------------------------


                }
                // RER FINAL  1 - 2 Y 0 - 1

                if (rer1int <= 12) {




                    switch(ejercicioabdomen){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer17.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer17.setText("1 - 2 RER");
                            break;

                        case "Rodillo abdominal":
                            rer17.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer17.setText("1 - 2 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer17.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer17.setText("1 - 2 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer17.setText("0 - 1 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer17.setText("0 - 1 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer17.setText("0 - 1 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Crunch abdominal":
                            rer17.setText("0 - 1 RER");
                            break;

                        case "Plancha":
                            rer17.setText("-");
                            break;

                        case "Toques al talón":
                            rer17.setText("0 - 1 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer17.setText("0 - 1 RER");
                            break;

                        case "Crunch lateral":
                            rer17.setText("0 - 1 RER");
                            break;

                    }



                    //abdomen
                    switch(ejercicioabdomen2){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer18.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer18.setText("1 - 2 RER");
                            break;

                        case "Rodillo abdominal":
                            rer18.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer18.setText("1 - 2 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer18.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer18.setText("1 - 2 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer18.setText("0 - 1 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer18.setText("0 - 1 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer18.setText("0 - 1 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer18.setText("0 - 1 RER");
                            break;

                        case "Crunch abdominal":
                            rer18.setText("0 - 1 RER");
                            break;

                        case "Plancha":
                            rer18.setText("-");
                            break;

                        case "Toques al talón":
                            rer18.setText("0 - 1 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer18.setText("0 - 1 RER");
                            break;

                        case "Crunch lateral":
                            rer18.setText("0 - 1 RER");
                            break;

                    }





                    //deltoides laterales
                    switch (ejerciciolateral) {
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer14.setText("1 - 2 RER");
                            break;


                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Facepull con cuerda":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer14.setText("0 - 1 RER");
                            break;

                    }

                    //deltoides laterales
                    switch (ejerciciolateral2) {
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer15.setText("1 - 2 RER");
                            break;


                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Facepull con cuerda":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer15.setText("0 - 1 RER");
                            break;

                    }


                    //deltoides laterales
                    switch (ejerciciolateral3) {
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer16.setText("1 - 2 RER");
                            break;


                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Facepull con cuerda":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer16.setText("0 - 1 RER");
                            break;

                    }









                    //BICEPS
                    switch (ejerciciobiceps) {
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

                    switch (ejerciciobiceps2) {
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer9.setText("1 - 2 RER");
                            break;


                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Curl spider con barra":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer9.setText("0 - 1 RER");
                            break;


                    }


                    //espalda
                    switch (ejercicioespalda3) {
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Remo pendlay":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Dominadas":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer7.setText("1 - 2 RER");
                            break;


                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer7.setText("0 - 1 RER");
                            break;


                    }

                    switch (ejercicioespalda) {
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

                    switch (ejercicioespalda2) {
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


                }

                // RER MEDIO 2 - 3  Y 1 - 2

                if (rer1int > 13 && rer1int <= 17) {


                    //abdomen
                    switch(ejercicioabdomen){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer17.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer17.setText("2 - 3 RER");
                            break;

                        case "Rodillo abdominal":
                            rer17.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer17.setText("2 - 3 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer17.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer17.setText("2 - 3 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer17.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer17.setText("1 - 2 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer17.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer17.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal":
                            rer17.setText("1 - 2 RER");
                            break;

                        case "Plancha":
                            rer17.setText("-");
                            break;

                        case "Toques al talón":
                            rer17.setText("1 - 2 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer17.setText("1 - 2 RER");
                            break;

                        case "Crunch lateral":
                            rer17.setText("1 - 2 RER");
                            break;

                    }



                    //abdomen
                    switch(ejercicioabdomen2){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer18.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer18.setText("2 - 3 RER");
                            break;

                        case "Rodillo abdominal":
                            rer18.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer18.setText("2 - 3 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer18.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer18.setText("2 - 3 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer18.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer18.setText("1 - 2 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer18.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer18.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal":
                            rer18.setText("1 - 2 RER");
                            break;

                        case "Plancha":
                            rer18.setText("-");
                            break;

                        case "Toques al talón":
                            rer18.setText("1 - 2 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer18.setText("1 - 2 RER");
                            break;

                        case "Crunch lateral":
                            rer18.setText("1 - 2 RER");
                            break;

                    }






                    //deltoides laterales
                    switch (ejerciciolateral) {
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer15.setText("2 - 3 RER");
                            break;


                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Facepull con cuerda":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer14.setText("1 - 2 RER");
                            break;

                    }

                    //deltoides laterales
                    switch (ejerciciolateral2) {
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer15.setText("2 - 3 RER");
                            break;


                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Facepull con cuerda":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer15.setText("1 - 2 RER");
                            break;

                    }


                    //deltoides laterales
                    switch (ejerciciolateral3) {
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer16.setText("2 - 3 RER");
                            break;


                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Facepull con cuerda":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer16.setText("1 - 2 RER");
                            break;

                    }










                    //BICEPS
                    switch (ejerciciobiceps) {
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

                    switch (ejerciciobiceps2) {
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer9.setText("2 - 3 RER");
                            break;


                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Curl spider con barra":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer9.setText("1 - 2 RER");
                            break;


                    }


                    //espalda
                    switch (ejercicioespalda) {
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
                    switch (ejercicioespalda2) {
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


                    switch (ejercicioespalda3) {
                        //ejercicios compuestos
                        case "Peso muerto convencional":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Remo pendlay":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Remo horizontal con barra":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Dominadas":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Remo con mancuerna a 1 brazo":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Remo en máquina hammer":
                            rer7.setText("2 - 3 RER");
                            break;


                        //ejercicios simples
                        case "Pullover con mancuerna":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Remo en máquina agarre en pronación":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Jalon frontal con agarre cerrado":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Hiperextensiones de espalda en el banco":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Remo a 1 mano con polea baja":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Remo sentado en polea con triangulo":
                            rer7.setText("1 - 2 RER");
                            break;


                    }


                }


//-------------------------------------------------------------------------------------------------------------------------------------------------------------

                //series



                String slaterale = datasnapshot.child("series espalda").getValue().toString();
                Double slate = Double.parseDouble(slaterale);
                Double slateraldivididoe = slate / 2;
                Double slateralfe = Math.ceil(slateraldivididoe);
                Double slateralf1e = slateralfe / 3;
                Double slateralf2e = slateralfe / 3;
                Double slateralf3e = slateralfe / 3;

                int slateralinte = (int) Math.ceil(slateralf1e);
                int slateralint2e = (int) Math.ceil(slateralf2e);
                int slateralint3e = (int) Math.round(slateralf3e);
                if (slateralint3e == 1){
                    slateralint3e++;
                }

                String seriesfinallaterale = String.valueOf(slateralinte);
                String seriesfinallateral2e = String.valueOf(slateralint2e);
                String seriesfinallateral3e = String.valueOf(slateralint3e);

                seriesespalda.setText(seriesfinallaterale + " Series");
                seriesespalda2.setText(seriesfinallateral2e + " Series");
                seriesespalda3.setText(seriesfinallateral3e + " Series");




                String scuadriceps = datasnapshot.child("series biceps").getValue().toString();
                Double scuad = Double.parseDouble(scuadriceps);
                Double scuaddividido = scuad / 2;
                Double scuadf = Math.ceil(scuaddividido);
                Double scuadf1 = scuadf / 3;
                Double scuadf2 = scuadf / 3;
                Double scuadf3 = scuadf / 3;


                int scuadint = (int) Math.ceil(scuadf1);
                int scuadint2 = (int) Math.floor(scuadf2);
                if (scuadint2 == 1){
                    scuadint2++;
                }
                int scuadint3 = (int) Math.floor(scuadf3);
                if (scuadint3 == 1){
                    scuadint3++;
                }

                String seriesfinalcuad = String.valueOf(scuadint);
                String seriesfinalcuad2 = String.valueOf(scuadint2);
                String seriesfinalcuad3 = String.valueOf(scuadint3);


                seriesbiceps.setText(seriesfinalcuad + " Series");
                seriesbiceps2.setText(seriesfinalcuad2 + " Series");
                seriesbiceps3.setText(seriesfinalcuad3 + " Series");



                String sfemoralesl = datasnapshot.child("series deltoides laterales y posteriores").getValue().toString();
                Double sfeml = Double.parseDouble(sfemoralesl);
                Double sfemdivididol = sfeml / 2;
                Double sfemoralesfl = Math.ceil(sfemdivididol);
                Double sfemoralesf1l = sfemoralesfl / 3;
                Double sfemoralesf2l = sfemoralesfl / 3;
                Double sfemoralesf3l = sfemoralesfl / 3;
                int sfemoralesintl = (int) Math.ceil(sfemoralesf1l);
                int sfemoralesint2l = (int) Math.round(sfemoralesf2l);
                if (sfemoralesint2l == 1){
                    sfemoralesint2l++;
                }
                int sfemoralesint3l = (int) Math.floor(sfemoralesf3l);
                if (sfemoralesint3l == 1){
                    sfemoralesint3l++;
                }
                String seriesfinalfemoralesl = String.valueOf(sfemoralesintl);
                String seriesfinalfemorales2l = String.valueOf(sfemoralesint2l);
                String seriesfinalfemorales3l = String.valueOf(sfemoralesint3l);
                serieslateral.setText(seriesfinalfemoralesl + " Series");
                serieslateral2.setText(seriesfinalfemorales2l + " Series");
                serieslateral3.setText(seriesfinalfemorales3l + " Series");



                String sgluteosa = datasnapshot.child("series abdominales").getValue().toString();
                Double sgla = Double.parseDouble(sgluteosa);
                Double sgluteosdivididoa = sgla / 2;
                Double sgluteosfa = Math.ceil(sgluteosdivididoa);
                Double sgluteosf1a = sgluteosfa / 2;
                Double sgluteosf2a = sgluteosfa / 2;
                Double sgluteosf3a = sgluteosfa / 3;
                int sgluteosinta = (int) Math.ceil(sgluteosf1a);
                int sgluteosint2a = (int) Math.round(sgluteosf2a);
                if (sgluteosint2a == 1){
                    sgluteosint2a++;
                }
                int sgluteosint3a = (int) Math.round(sgluteosf3a);
                String seriesgluteosfinala = String.valueOf(sgluteosinta);
                String seriesgluteosfinal2a = String.valueOf(sgluteosint2a);
                String seriesgluteosfinal3a = String.valueOf(sgluteosint3a);
                seriesabdomen.setText(seriesgluteosfinala + " Series");
                seriesabdomen2.setText(seriesgluteosfinal2a + " Series");




                String stringpesoinicialespalda = datasnapshot.child("Historial espalda/ 6 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesoespalda.setText(stringpesoinicialespalda);

                String stringpesoinicialespalda2 = datasnapshot.child("Historial espalda/ 6 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesoespalda2.setText(stringpesoinicialespalda2);

                String stringpesoinicialespalda3 = datasnapshot.child("Historial espalda/ 6 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesoespalda3.setText(stringpesoinicialespalda3);


                String stringpesoinicialbiceps = datasnapshot.child("Historial biceps/ 6 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesobiceps.setText(stringpesoinicialbiceps);

                String stringpesoinicialbiceps2 = datasnapshot.child("Historial biceps/ 6 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesobiceps2.setText(stringpesoinicialbiceps2);

                String stringpesoinicialbiceps3 = datasnapshot.child("Historial biceps/ 6 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesobiceps3.setText(stringpesoinicialbiceps3);


                String stringpesoinicialtrapecios = datasnapshot.child("Historial deltoides laterales y posteriores/ 6 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesolateral.setText(stringpesoinicialtrapecios);

                String stringpesoinicialtrapecios2 = datasnapshot.child("Historial deltoides laterales y posteriores/ 6 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesolateral2.setText(stringpesoinicialtrapecios2);

                String stringpesoinicialtrapecios3 = datasnapshot.child("Historial deltoides laterales y posteriores/ 6 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesolateral3.setText(stringpesoinicialtrapecios3);



                String stringpesoinicialtrapecios21 = datasnapshot.child("Historial abdomen/ 6 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesoabdomen.setText(stringpesoinicialtrapecios21);

                String stringpesoinicialtrapecios22 = datasnapshot.child("Historial abdomen/ 6 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesoabdomen2.setText(stringpesoinicialtrapecios22);

                String stringpesoinicialtrapecios23 = datasnapshot.child("Historial abdomen/ 6 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesoabdomen2.setText(stringpesoinicialtrapecios23);


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
                                                   preferences.edit().putString("editText", editable.toString()).commit();


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
                                                    preferences.edit().putString("editText", editable.toString()).commit();


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




        pesoabdomen.addTextChangedListener(new TextWatcher() {
                                               @Override
                                               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void afterTextChanged(Editable editable) {
                                                   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesoabdomen.getContext());
                                                   preferences.edit().putString("editText",editable.toString()).commit();



                                               }
                                           }
        );


        pesoabdomen2.addTextChangedListener(new TextWatcher() {
                                                @Override
                                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void afterTextChanged(Editable editable) {
                                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesoabdomen2.getContext());
                                                    preferences.edit().putString("editText",editable.toString()).commit();



                                                }
                                            }
        );






        rer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });


        rer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });




        rer7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });




        rer8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });


        rer91.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });




        rer14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });



        rer15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });


        rer16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });


        rer17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diamartesmujer.this, rer.class);
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

    public void findelentrenamiento1611 (View view){

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
                    mInterstitialAd.show(entreno6diamartesmujer.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }

            }
        }, 1000);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();



        String datoejercicio2 = pesoespalda.getText().toString();
        String datoejercicio2_2 = pesoespalda2.getText().toString();
        String datoejercicioabs2 = pesoespalda3.getText().toString();

        String datoejercicio3 = pesobiceps.getText().toString();
        String datoejercicio3_2 = pesobiceps2.getText().toString();
        String datoejercicio3_3 = pesobiceps3.getText().toString();


        String datoejercicio10 = pesolateral.getText().toString();
        String datoejercicio10_2 = pesolateral2.getText().toString();
        String datoejercicioabs = pesolateral3.getText().toString();


        String datoabs = pesoabdomen.getText().toString();
        String datoabs2 = pesoabdomen2.getText().toString();




        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                Map<String, Object> pesoactualizandose2 = new HashMap<>();


                pesoactualizandose2.put("Historial espalda/ 6 dias/ primer ejercicio/ dia 1", datoejercicio2);
                pesoactualizandose2.put("Historial espalda/ 6 dias/ segundo ejercicio/ dia 1", datoejercicio2_2);
                pesoactualizandose2.put("Historial espalda/ 6 dias/ tercer ejercicio/ dia 1", datoejercicioabs2);

                pesoactualizandose2.put("Historial biceps/ 6 dias/ primer ejercicio/ dia 1", datoejercicio3);
                pesoactualizandose2.put("Historial biceps/ 6 dias/ segundo ejercicio/ dia 1", datoejercicio3_2);
                pesoactualizandose2.put("Historial biceps/ 6 dias/ tercer ejercicio/ dia 1", datoejercicio3_3);

                pesoactualizandose2.put("Historial deltoides laterales y posteriores/ 6 dias/ primer ejercicio/ dia 1", datoejercicio10);
                pesoactualizandose2.put("Historial deltoides laterales y posteriores/ 6 dias/ segundo ejercicio/ dia 1", datoejercicio10_2);
                pesoactualizandose2.put("Historial deltoides laterales y posteriores/ 6 dias/ tercer ejercicio/ dia 1", datoejercicioabs);

                pesoactualizandose2.put("Historial abdomen/ 6 dias/ primer ejercicio/ dia 1", datoabs);
                pesoactualizandose2.put("Historial abdomen/ 6 dias/ segundo ejercicio/ dia 1", datoabs2);








                mDatabase.child("Users").child(id).updateChildren(pesoactualizandose2);


                //si se modifica el datachange en algun otro momento envia a esta pantalla, por lo cual se condiciona el envio
                boolean botonpresionado = true;

                if (botonpresionado == true){



                    Intent findelentrenamiento = new Intent(entreno6diamartesmujer.this, entrenamientofinalizado.class);

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









        //   Toast.makeText(this, "Gracias por entrenar con Korellia Club. Tu entrenamiento ha sido guardado.", Toast.LENGTH_SHORT).show();

    }








    public void ejercicio1 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("espalda/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno6diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno6diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno6diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno6diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno6diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno6diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno6diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno6diamartesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("abdominales/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("abdominales/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno6diamartesmujer.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}
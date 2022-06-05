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

public class entreno5diamartesmujer extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private EditText peso1, peso2, pesolateral3, pesolateral2, pesoespalda, pesoespalda2, pesoespalda3, pesobiceps, pesobiceps2, pesotriceps, pesotriceps2,
            pesofrontal, pesolateral;
    private String ejercicioseleccionado, ejercicioseleccionadoespalda, ejercicioseleccionadolateral, ejercicioseleccionadolateral2,
            ejercicioseleccionadobiceps, ejercicioseleccionadotriceps,  ejercicioseleccionadofrontal;
    private TextView rer1, rer2, rer4, rer5,  rer7, rer8, rer9, rer10, rer11, rer13, rer14, rer15, rer16;
    private TextView fechacompleta;
    private TextView seriespectoral,serieslateral2, serieslateral3, ejerciciolateral3, repeticioneslateral3,  ejerciciolateral2, repeticioneslateral2,  seriespectoral2,
            seriesespalda, seriesespalda2, seriesespalda3, seriesbiceps, seriesbiceps2, seriestriceps, seriestriceps2, seriesfrontal, serieslateral;
    private Spinner spinner1, spinner2, spinner14, spinner15, spinner16, spinner4, spinner5, spinner7, spinner8, spinner9, spinner10, spinner11,  spinner13;
    private  TextView ejerciciopectoral, repeticionespectoral2, ejerciciopectoral2,
            repeticionespectoral, ejercicioespalda, ejercicioespalda2, ejercicioespalda3, repeticionesespalda2, repeticionesespalda3, repeticionesespalda,
            ejerciciobiceps, ejerciciobiceps2, repeticionesbiceps, repeticionesbiceps2, ejerciciotriceps, repeticionestriceps,  repeticionestriceps2, ejerciciofrontal,
            repeticionesfrontal, ejerciciotriceps2, ejerciciolateral, repeticioneslateral;
    private ImageView imagenpectoral, imagenlaterales3, imagenlaterales2, imagenpectoral2, imagenespalda, imagenespalda2, imagenespalda3, imagenbiceps,
            imagenbiceps2, imagentriceps, imagentriceps2,  imagenfrontal, imagenlaterales;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private String ejercicioseleccionado2,  ejercicioseleccionadolateral3,  ejercicioseleccionadoespalda2,     ejercicioseleccionadoespalda3,
            ejercicioseleccionadobiceps2, ejercicioseleccionadotriceps2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_entreno5diamartesmujer);

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


        fechacompleta = (TextView) findViewById(R.id.textView2736);
        Date date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("d MMM yyyy");
        String sfecha = fecha.format(date);
        fechacompleta.setText(sfecha);


        Toolbar toolbar = findViewById(R.id.toolbarentreno5diamartesmujer);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Entrenamiento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        spinner1= (Spinner) findViewById(R.id.spinner16);
        spinner2= (Spinner) findViewById(R.id.spinner26);


        spinner4= (Spinner) findViewById(R.id.spinner46);
        spinner5= (Spinner) findViewById(R.id.spinner56);
        spinner7= (Spinner) findViewById(R.id.spinner13espalda36);


        spinner8= (Spinner) findViewById(R.id.spinner76);
        spinner9= (Spinner) findViewById(R.id.spinner86);

        spinner10= (Spinner) findViewById(R.id.spinner96);
        spinner11= (Spinner) findViewById(R.id.spinner106);

        spinner13= (Spinner) findViewById(R.id.spinner116);

        spinner14= (Spinner) findViewById(R.id.spinner136);
        spinner15= (Spinner) findViewById(R.id.spinner146);
        spinner16= (Spinner) findViewById(R.id.spinner142lateral36);






        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner1.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner2.setAdapter(adapter2);

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
        ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner16.setAdapter(adapter16);


        rer1 = findViewById(R.id.buttonrer1a6);
        rer2 = findViewById(R.id.buttonrer2a6);


        rer4 = findViewById(R.id.buttonrer4a6);
        rer5 = findViewById(R.id.buttonrer5a6);
        rer7 = findViewById(R.id.buttonrer13espalda36);


        rer8 = findViewById(R.id.buttonrer7a6);
        rer9 = findViewById(R.id.buttonrer8a6);

        rer10 = findViewById(R.id.buttonrer9a6);
        rer11 = findViewById(R.id.buttonrer10a6);

        rer13 = findViewById(R.id.buttonrer11a6);

        rer14 = findViewById(R.id.buttonrer13a6);
        rer15 = findViewById(R.id.buttonrer14a6);
        rer16 = findViewById(R.id.buttonrer14a2lateral36);




        //pectoral 3
        ejerciciopectoral = (TextView) findViewById(R.id.textView2196);
        repeticionespectoral = (TextView) findViewById(R.id.textView2216);
        imagenpectoral = (ImageView) findViewById(R.id.imageView116);
        peso1 = (EditText) findViewById(R.id.textView2226);
        seriespectoral = (TextView) findViewById(R.id.textView2206);


        ejerciciopectoral2 = (TextView) findViewById(R.id.textView219pectoral26);
        repeticionespectoral2 = (TextView) findViewById(R.id.textView221pec26);
        imagenpectoral2 = (ImageView) findViewById(R.id.imageView11imagen26);
        peso2 = (EditText) findViewById(R.id.textView222pec26);
        seriespectoral2 = (TextView) findViewById(R.id.textView220pec26);


        //espalda 3
        ejercicioespalda = (TextView) findViewById(R.id.textView219espalda16);
        repeticionesespalda = (TextView) findViewById(R.id.textView221espalda16);
        imagenespalda = (ImageView) findViewById(R.id.imageView11espalda16);
        pesoespalda = (EditText) findViewById(R.id.textView222espalda16);
        seriesespalda = (TextView) findViewById(R.id.textView220espalda16);

        ejercicioespalda2 = (TextView) findViewById(R.id.textView219espalda26);
        repeticionesespalda2 = (TextView) findViewById(R.id.textView221espalda26);
        imagenespalda2 = (ImageView) findViewById(R.id.imageView11espalda26);
        pesoespalda2 = (EditText) findViewById(R.id.textView222espalda26);
        seriesespalda2 = (TextView) findViewById(R.id.textView220espalda26);

        ejercicioespalda3 = (TextView) findViewById(R.id.textView219espalda36);
        repeticionesespalda3 = (TextView) findViewById(R.id.textView221espalda36);
        imagenespalda3 = (ImageView) findViewById(R.id.imageView11espalda36);
        pesoespalda3 = (EditText) findViewById(R.id.textView222espalda36);
        seriesespalda3 = (TextView) findViewById(R.id.textView220espalda36);



        //biceps 2
        ejerciciobiceps = (TextView) findViewById(R.id.textView219biceps16);
        repeticionesbiceps = (TextView) findViewById(R.id.textView221biceps16);
        imagenbiceps = (ImageView) findViewById(R.id.imageView11biceps16);
        pesobiceps = (EditText) findViewById(R.id.textView222biceps16);
        seriesbiceps = (TextView) findViewById(R.id.textView220biceps16);

        ejerciciobiceps2 = (TextView) findViewById(R.id.textView219biceps26);
        repeticionesbiceps2 = (TextView) findViewById(R.id.textView221biceps26);
        imagenbiceps2 = (ImageView) findViewById(R.id.imageView11biceps26);
        pesobiceps2 = (EditText) findViewById(R.id.textView222biceps26);
        seriesbiceps2 = (TextView) findViewById(R.id.textView220biceps26);


        //triceps 2
        ejerciciotriceps = (TextView) findViewById(R.id.nombreejerciciotriceps16);
        repeticionestriceps = (TextView) findViewById(R.id.textView221triceps16);
        imagentriceps = (ImageView) findViewById(R.id.imageView11triceps16);
        pesotriceps = (EditText) findViewById(R.id.textView222triceps16);
        seriestriceps = (TextView) findViewById(R.id.textView220triceps16);


        ejerciciotriceps2 = (TextView) findViewById(R.id.textView219triceps26);
        repeticionestriceps2 = (TextView) findViewById(R.id.textView221triecps26);
        imagentriceps2 = (ImageView) findViewById(R.id.imageView11triceps26);
        pesotriceps2 = (EditText) findViewById(R.id.textView222triceps26);
        seriestriceps2 = (TextView) findViewById(R.id.textView220triceps26);


        //frontales
        ejerciciofrontal = (TextView) findViewById(R.id.textView219frontal16);
        repeticionesfrontal = (TextView) findViewById(R.id.textView221frontal16);
        imagenfrontal = (ImageView) findViewById(R.id.imageView11frontal16);
        pesofrontal = (EditText) findViewById(R.id.textView222frontal16);
        seriesfrontal= (TextView) findViewById(R.id.textView220frontal16);



        //laterales 3

        ejerciciolateral = (TextView) findViewById(R.id.textView219traps16);
        repeticioneslateral = (TextView) findViewById(R.id.textView221traps16);
        imagenlaterales = (ImageView) findViewById(R.id.imageView11traps16);
        pesolateral = (EditText) findViewById(R.id.textView222traps16);
        serieslateral = (TextView) findViewById(R.id.textView220traps16);


        ejerciciolateral2 = (TextView) findViewById(R.id.textView219traps26);
        repeticioneslateral2 = (TextView) findViewById(R.id.textView221traps26);
        imagenlaterales2 = (ImageView) findViewById(R.id.imageView11traps26);
        pesolateral2 = (EditText) findViewById(R.id.textView222traps26);
        serieslateral2 = (TextView) findViewById(R.id.textView220traps26);


        ejerciciolateral3 = (TextView) findViewById(R.id.textView2192lateral36);
        repeticioneslateral3 = (TextView) findViewById(R.id.textView2212lateral36);
        imagenlaterales3 = (ImageView) findViewById(R.id.imageView112lateral36);
        pesolateral3 = (EditText) findViewById(R.id.textView2222lateral36);
        serieslateral3 = (TextView) findViewById(R.id.textView2202lateral36);






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



                    String stringejerciciofrontal2 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio primario").getValue().toString();
                    ejerciciolateral.setText(stringejerciciofrontal2);
                    ejercicioseleccionadolateral = stringejerciciofrontal2;

                    String stringejerciciofrontal3 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio secundario").getValue().toString();
                    ejerciciolateral2.setText(stringejerciciofrontal3);
                    ejercicioseleccionadolateral2 = stringejerciciofrontal3;

                    String stringejercicioabs = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();
                    ejerciciolateral3.setText(stringejercicioabs);
                    ejercicioseleccionadolateral3 = stringejercicioabs;








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
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20declinado%20con%20mancuernas%2FIMG_0308.jpg?alt=media&token=4fa254f7-3be4-4b2b-a604-5d8a2ca6de89")
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


                //---


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
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20en%20smith%2F20211211_134356.jpg?alt=media&token=97ae02ab-aed5-4fe5-87d9-9bb75453bcdf")
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





//-------------------------------------------------------------------------------------------------------------------------------------------------------------
                //RER

                String RER1 = datasnapshot.child("progresosrer").getValue().toString();
                int rer1int = Integer.parseInt(RER1);

                String ejerciciopecho = datasnapshot.child("pectoral/ ejercicio primario").getValue().toString();
                String ejerciciopecho2 = datasnapshot.child("pectoral/ ejercicio secundario").getValue().toString();


                String ejercicioespalda = datasnapshot.child("espalda/ ejercicio primario").getValue().toString();
                String ejercicioespalda2 = datasnapshot.child("espalda/ ejercicio secundario").getValue().toString();
                String ejercicioespalda3 = datasnapshot.child("espalda/ ejercicio tercero").getValue().toString();


                String ejerciciobiceps = datasnapshot.child("biceps/ ejercicio primario").getValue().toString();
                String ejerciciobiceps2 = datasnapshot.child("biceps/ ejercicio secundario").getValue().toString();

                String ejerciciotriceps = datasnapshot.child("triceps/ ejercicio primario").getValue().toString();
                String ejerciciotriceps2 = datasnapshot.child("triceps/ ejercicio secundario").getValue().toString();

                String ejerciciofrontal = datasnapshot.child("deltoide frontal/ ejercicio primario").getValue().toString();


                String ejerciciolateral = datasnapshot.child("deltoides laterales y posteriores/ ejercicio primario").getValue().toString();
                String ejerciciolateral2 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio secundario").getValue().toString();
                String ejerciciolateral3 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();







                //RER INICIAL 3 - 4 Y 2 - 3
                if(rer1int >= 18) {





                    //deltoides laterales
                    switch(ejerciciolateral){
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
                    switch(ejerciciolateral2){
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
                    switch(ejerciciolateral3){
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







                    //FRONTAL
                    switch(ejerciciofrontal){
                        //ejercicios compuestos
                        case "Press militar con barra":
                            rer13.setText("3 - 4 RER");
                            break;

                        case "Press militar con mancuernas":
                            rer13.setText("3 - 4 RER");
                            break;

                        case "Push press":
                            rer13.setText("3 - 4 RER");
                            break;

                        case "Press militar en smith":
                            rer13.setText("3 - 4 RER");
                            break;

                        case "Press en máquina agarre prono":
                            rer13.setText("3 - 4 RER");
                            break;

                        case "Press Arnold":
                            rer13.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Press en máquina agarre neutro":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre prono":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con mancuerna agarre supino":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con polea baja a 1 brazo":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con disco":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontal con cuerda en polea baja":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre neutro":
                            rer13.setText("2 - 3 RER");
                            break;

                    }





                    //triceps
                    switch(ejerciciotriceps){
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


                    //triceps
                    switch(ejerciciotriceps2){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Press cerrado en smith":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Copa con barra":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer11.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Fondos en máquina":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer11.setText("2 - 3 RER");
                            break;

                    }








                    //BICEPS
                    switch(ejerciciobiceps){
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
                    switch(ejerciciobiceps2){
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
                    switch(ejercicioespalda3){
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








//--------------------------------------


                }
                // RER FINAL  1 - 2 Y 0 - 1

                if (rer1int <= 12){



                    //deltoides laterales
                    switch(ejerciciolateral){
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
                    switch(ejerciciolateral2){
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
                    switch(ejerciciolateral3){
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






                    //FRONTAL
                    switch(ejerciciofrontal){
                        //ejercicios compuestos
                        case "Press militar con barra":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Press militar con mancuernas":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Push press":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Press militar en smith":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Press en máquina agarre prono":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Press Arnold":
                            rer13.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Press en máquina agarre neutro":
                            rer13.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre prono":
                            rer13.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con mancuerna agarre supino":
                            rer13.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con polea baja a 1 brazo":
                            rer13.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con disco":
                            rer13.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontal con cuerda en polea baja":
                            rer13.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre neutro":
                            rer13.setText("0 - 1 RER");
                            break;

                    }








                    //triceps
                    switch(ejerciciotriceps){
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


                    switch(ejerciciotriceps2){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Press cerrado en smith":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Copa con barra":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer11.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Fondos en máquina":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer11.setText("0 - 1 RER");
                            break;

                    }






                    //BICEPS
                    switch(ejerciciobiceps){
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

                    switch(ejerciciobiceps2){
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
                    switch(ejercicioespalda3){
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













                }

                // RER MEDIO 2 - 3  Y 1 - 2

                if (rer1int>13 && rer1int<=17){



                    //deltoides laterales
                    switch(ejerciciolateral){
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
                    switch(ejerciciolateral2){
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
                    switch(ejerciciolateral3){
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





                    //FRONTAL
                    switch(ejerciciofrontal){
                        //ejercicios compuestos
                        case "Press militar con barra":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Press militar con mancuernas":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Push press":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Press militar en smith":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Press en máquina agarre prono":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Press Arnold":
                            rer13.setText("2 - 3 RER");
                            break;




                        //ejercicios simples
                        case "Press en máquina agarre neutro":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre prono":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con mancuerna agarre supino":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con polea baja a 1 brazo":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con disco":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontal con cuerda en polea baja":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre neutro":
                            rer13.setText("1 - 2 RER");
                            break;

                    }




                    //triceps
                    switch(ejerciciotriceps){
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

                    switch(ejerciciotriceps2){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Press cerrado en smith":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Copa con barra":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer11.setText("2 - 3 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Fondos en máquina":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer11.setText("1 - 2 RER");
                            break;

                    }








                    //BICEPS
                    switch(ejerciciobiceps){
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

                    switch(ejerciciobiceps2){
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

                //SERIES


                String slateral = datasnapshot.child("series pectoral").getValue().toString();
                Double slat = Double.parseDouble(slateral);
                Double slateraldividido = slat / 2;
                Double slateralf = Math.ceil(slateraldividido);
                Double slateralf1 = slateralf / 3;
                Double slateralf2 = slateralf / 3;
                Double slateralf3 = slateralf / 3;

                int slateralint = (int) Math.round(slateralf1);
                if (slateralint == 1){
                    slateralint++;
                }
                int slateralint2 = (int) Math.round(slateralf2);
                if (slateralint2 == 1){
                    slateralint2++;
                }
                int slateralint3 = (int) Math.round(slateralf3);

                String seriesfinallateral = String.valueOf(slateralint);
                String seriesfinallateral2 = String.valueOf(slateralint2);
                String seriesfinallateral3 = String.valueOf(slateralint3);

                seriespectoral.setText(seriesfinallateral + " Series");
                seriespectoral2.setText(seriesfinallateral2 + " Series");




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
                Double scuadf1 = scuadf / 2;
                Double scuadf2 = scuadf / 2;


                int scuadint = (int) Math.ceil(scuadf1);
                int scuadint2 = (int) Math.floor(scuadf2);
                if (scuadint2 == 1){
                    scuadint2++;
                }


                String seriesfinalcuad = String.valueOf(scuadint);
                String seriesfinalcuad2 = String.valueOf(scuadint2);

                seriesbiceps.setText(seriesfinalcuad + " Series");
                seriesbiceps2.setText(seriesfinalcuad2 + " Series");


                String scuadricepst = datasnapshot.child("series triceps").getValue().toString();
                Double scuadt = Double.parseDouble(scuadricepst);
                Double scuaddivididot = scuadt / 2;
                Double scuadft = Math.ceil(scuaddivididot);
                Double scuadf1t = scuadft / 4;
                Double scuadf2t = scuadft / 4;

                int scuadintt = (int) Math.ceil(scuadf1t);
                int scuadint2t = (int) Math.ceil(scuadf2t);

                String seriesfinalcuadt = String.valueOf(scuadintt);
                String seriesfinalcuad2t = String.valueOf(scuadint2t);

                seriestriceps.setText(seriesfinalcuadt + " Series");
                seriestriceps2.setText(seriesfinalcuad2t + " Series");



                String sfrontal = datasnapshot.child("series deltoide frontal").getValue().toString();
                Double sfron = Double.parseDouble(sfrontal);
                Double srfrondividido = sfron / 2;
                Double sfronesf = Math.ceil(srfrondividido);
                int sfronlesint = (int) Math.round(sfronesf);
                if (sfronlesint == 1){
                    sfronlesint++;
                }
                String seriesfinalfrontal = String.valueOf(sfronlesint);
                seriesfrontal.setText(seriesfinalfrontal + " Series");


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







                String stringpesoinicial = datasnapshot.child("Historial pectoral/ 5 dias/ primer ejercicio/ dia 1").getValue().toString();
                peso1.setText(stringpesoinicial);

                String stringpesoinicial2 = datasnapshot.child("Historial pectoral/ 5 dias/ segundo ejercicio/ dia 1").getValue().toString();
                peso2.setText(stringpesoinicial2);





                String stringpesoinicialespalda = datasnapshot.child("Historial espalda/ 5 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesoespalda.setText(stringpesoinicialespalda);

                String stringpesoinicialespalda2 = datasnapshot.child("Historial espalda/ 5 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesoespalda2.setText(stringpesoinicialespalda2);

                String stringpesoinicialespalda3 = datasnapshot.child("Historial espalda/ 5 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesoespalda3.setText(stringpesoinicialespalda3);






                String stringpesoinicialbiceps = datasnapshot.child("Historial biceps/ 5 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesobiceps.setText(stringpesoinicialbiceps);

                String stringpesoinicialbiceps2 = datasnapshot.child("Historial biceps/ 5 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesobiceps2.setText(stringpesoinicialbiceps2);



                String stringpesoinicialtriceps = datasnapshot.child("Historial triceps/ 5 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesotriceps.setText(stringpesoinicialtriceps);

                String stringpesoinicialtriceps2 = datasnapshot.child("Historial triceps/ 5 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesotriceps2.setText(stringpesoinicialtriceps2);



                String stringpesoinicialfrontal = datasnapshot.child("Historial frontal/ 5 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesofrontal.setText(stringpesoinicialfrontal);



                String stringpesoinicialtrapecios = datasnapshot.child("Historial deltoides laterales y posteriores/ 5 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesolateral.setText(stringpesoinicialtrapecios);

                String stringpesoinicialtrapecios2 = datasnapshot.child("Historial deltoides laterales y posteriores/ 5 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesolateral2.setText(stringpesoinicialtrapecios2);

                String stringpesoinicialtrapecios3 = datasnapshot.child("Historial deltoides laterales y posteriores/ 5 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesolateral3.setText(stringpesoinicialtrapecios3);















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





        rer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno5diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno5diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });


        rer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno5diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });


        rer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno5diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });




        rer7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno5diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno5diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno5diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno5diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno5diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });



        rer13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno5diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno5diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });



        rer15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno5diamartesmujer.this, rer.class);
                startActivity(intent);
            }
        });


        rer16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno5diamartesmujer.this, rer.class);
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

    public void findelentrenamiento16w (View view){

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
                    mInterstitialAd.show(entreno5diamartesmujer.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }

            }
        }, 1000);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();

        String datoejercicio1 = peso1.getText().toString();
        String datoejercicio1_2 = peso2.getText().toString();


        String datoejercicio2 = pesoespalda.getText().toString();
        String datoejercicio2_2 = pesoespalda2.getText().toString();
        String datoejercicioabs2 = pesoespalda3.getText().toString();

        String datoejercicio3 = pesobiceps.getText().toString();
        String datoejercicio3_2 = pesobiceps2.getText().toString();

        String datoejercicio4 = pesotriceps.getText().toString();
        String datoejercicio4_2 = pesotriceps2.getText().toString();

        String datoejercicio5 = pesofrontal.getText().toString();

        String datoejercicio10 = pesolateral.getText().toString();
        String datoejercicio10_2 = pesolateral2.getText().toString();
        String datoejercicioabs = pesolateral3.getText().toString();




        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                Map<String, Object> pesoactualizandose2 = new HashMap<>();
                pesoactualizandose2.put("Historial pectoral/ 5 dias/ primer ejercicio/ dia 1", datoejercicio1);
                pesoactualizandose2.put("Historial pectoral/ 5 dias/ segundo ejercicio/ dia 1", datoejercicio1_2);

                pesoactualizandose2.put("Historial espalda/ 5 dias/ primer ejercicio/ dia 1", datoejercicio2);
                pesoactualizandose2.put("Historial espalda/ 5 dias/ segundo ejercicio/ dia 1", datoejercicio2_2);
                pesoactualizandose2.put("Historial espalda/ 5 dias/ tercer ejercicio/ dia 1", datoejercicioabs2);

                pesoactualizandose2.put("Historial biceps/ 5 dias/ primer ejercicio/ dia 1", datoejercicio3);
                pesoactualizandose2.put("Historial biceps/ 5 dias/ segundo ejercicio/ dia 1", datoejercicio3_2);

                pesoactualizandose2.put("Historial triceps/ 5 dias/ primer ejercicio/ dia 1", datoejercicio4);
                pesoactualizandose2.put("Historial triceps/ 5 dias/ segundo ejercicio/ dia 1", datoejercicio4_2);

                pesoactualizandose2.put("Historial frontal/ 5 dias/ primer ejercicio/ dia 1", datoejercicio5);

                pesoactualizandose2.put("Historial deltoides laterales y posteriores/ 5 dias/ primer ejercicio/ dia 1", datoejercicio10);
                pesoactualizandose2.put("Historial deltoides laterales y posteriores/ 5 dias/ segundo ejercicio/ dia 1", datoejercicio10_2);
                pesoactualizandose2.put("Historial deltoides laterales y posteriores/ 5 dias/ tercer ejercicio/ dia 1", datoejercicioabs);







                mDatabase.child("Users").child(id).updateChildren(pesoactualizandose2);


                //si se modifica el datachange en algun otro momento envia a esta pantalla, por lo cual se condiciona el envio
                boolean botonpresionado = true;

                if (botonpresionado == true){



                    Intent findelentrenamiento = new Intent(entreno5diamartesmujer.this, entrenamientofinalizado.class);

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




    public void ejercicio (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("pectoral/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diamartesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diamartesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("deltoides laterales y posteriores/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamartesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("deltoides laterales y posteriores/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamartesmujer.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    public void ejercicio6parte3 (View view){


        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamartesmujer.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }




}
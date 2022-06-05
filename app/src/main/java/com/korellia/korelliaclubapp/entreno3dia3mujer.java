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

public class entreno3dia3mujer extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    private TextView fechacompleta;
    private TextView mTextViewDatos;
    private Spinner spinnerintensidad, spinnerintensidadespalda, spinnerintensidadbiceps, spinnerintensidadtriceps, spinnerintensidadfrontal, spinnerintensidadlaterales, spinnerintensidadcuadriceps,
            spinnerintensidadisquios, spinnerintensidadgluteos, spinnerintensidadpantorrillas, spinnerintensidadabdomen, spinnerintensidadtrapecios;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private EditText peso1, pesoespalda, pesofemoral2,  pesobiceps, pesotriceps, pesofrontal, pesolateral, pesocuadriceps, pesofemoral, pesogluteos, pesopantorrillas, pesotrapecios, pesoabdomen;
    private String ejercicioseleccionado, ejercicioseleccionadoespalda, ejercicioseleccionadofemoral2, ejercicioseleccionadobiceps, ejercicioseleccionadotriceps, ejercicioseleccionadocuadriceps, ejercicioseleccionadofrontal,
            ejerciciosleccionadolaterales, ejercicioseleccionadofemoral, ejerciciselecionadogluteo, ejerciciseleccionadopantorrillas, ejercicioseleccionadoabs, ejercicioseleccionadotraps;
    private TextView rer1, rer2, rer3, rer4, rer5, rer6, rer7, rer8, rer9, rer10, rer11, rer12;
    private TextView seriespectoral, seriesfemoral2, seriesespalda, repeticionesfemoral2, seriesbiceps, seriestriceps, seriesfrontal, serieslateral, seriescuadriceps, seriesfemoral, seriespantorrillas, seriesgluteos, seriestraps, seriesabdomen;
    private  TextView ejerciciopectoral, repeticionespectoral, ejerciciofemoral2, ejercicioespalda, repeticionesespalda, ejerciciobiceps, repeticionesbiceps, ejerciciotriceps, repeticionestriceps, ejerciciofrontal,
            repeticionesfrontal, ejerciciolateral, repeticioneslateral, ejerciciocuadriceps, repeticionescuadriceps, ejerciciofemoral, repeticionesfemoral, ejerciciogluteos, repeticionesgluteos,
            ejerciciopantorrillas, repeticionespantorrillas, ejerciciotrapecios, repeticionestrapecios, ejercicioabdomen, repeticionesbadomen;
    private ImageView imagenpectoral, imagenespalda, imagenfemoral2, imagenbiceps, imagentriceps, imagenfrontal, imagenlaterales, imagencuadriceps, imagenfemoral, imagengluteos, imagenpantorrillas, imagentrapecios, imageneabdomen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_entreno3dia3mujer);


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




        setContentView(R.layout.activity_entreno3dia3mujer);
        Toolbar toolbar = findViewById(R.id.toolbarentreno3dia3mujer);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Entrenamiento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fechacompleta = (TextView) findViewById(R.id.fechaentreno3dia3mujer);
        Date date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("d MMM yyyy");
        String sfecha = fecha.format(date);
        fechacompleta.setText(sfecha);


        spinnerintensidad= (Spinner) findViewById(R.id.spinner1entreno3dia3mujer);
        spinnerintensidadespalda= (Spinner) findViewById(R.id.spinner2entreno3dia3mujer);
        spinnerintensidadbiceps= (Spinner) findViewById(R.id.spinner3entreno3dia3mujer);
        spinnerintensidadtriceps= (Spinner) findViewById(R.id.spinner4entreno3dia3mujer);
        spinnerintensidadfrontal= (Spinner) findViewById(R.id.spinner5entreno3dia3mujer);
        spinnerintensidadlaterales= (Spinner) findViewById(R.id.spinner6entreno3dia3mujer);
        spinnerintensidadcuadriceps= (Spinner) findViewById(R.id.spinner7entreno3dia3mujer);
        spinnerintensidadisquios= (Spinner) findViewById(R.id.spinner8entreno3dia3mujer);
        spinnerintensidadpantorrillas= (Spinner) findViewById(R.id.spinner9entreno3dia3mujer);
        spinnerintensidadabdomen= (Spinner) findViewById(R.id.spinner10entreno3dia3mujer);
        spinnerintensidadtrapecios= (Spinner) findViewById(R.id.spinner11entreno3dia3mujer);
        spinnerintensidadgluteos= (Spinner) findViewById(R.id.spinner12entreno3dia3mujer);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();


        rer1 = findViewById(R.id.buttonrer1dia3mujer);
        rer2 = findViewById(R.id.buttonrer2dia3mujer);
        rer3 = findViewById(R.id.buttonrer3dia3mujer);
        rer4 = findViewById(R.id.buttonrer4dia3mujer);
        rer5 = findViewById(R.id.buttonrer5dia3mujer);
        rer6 = findViewById(R.id.buttonrer6dia3mujer);
        rer7 = findViewById(R.id.buttonrer7dia3mujer);
        rer8 = findViewById(R.id.buttonrer8dia3mujer);
        rer9 = findViewById(R.id.buttonrer9dia3mujer);
        rer10 = findViewById(R.id.buttonrer10dia3mujer);
        rer11 = findViewById(R.id.buttonrer11dia3mujer);
        rer12 = findViewById(R.id.buttonrer12dia3mujer);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidad.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadespalda.setAdapter(adapter2);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadbiceps.setAdapter(adapter3);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadtriceps.setAdapter(adapter4);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadfrontal.setAdapter(adapter5);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadlaterales.setAdapter(adapter6);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadcuadriceps.setAdapter(adapter7);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadisquios.setAdapter(adapter8);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadpantorrillas.setAdapter(adapter9);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadgluteos.setAdapter(adapter10);
        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadabdomen.setAdapter(adapter11);
        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadtrapecios.setAdapter(adapter12);




        //pectoral
        ejerciciopectoral = (TextView) findViewById(R.id.ejercicio1entreno3dia3mujer);
        repeticionespectoral = (TextView) findViewById(R.id.reps1entreno3dia3mujer);
        imagenpectoral = (ImageView) findViewById(R.id.imagen1entreno3dia3mujer);
        peso1 = (EditText) findViewById(R.id.peso1entreno3dia3mujer);
        seriespectoral = (TextView) findViewById(R.id.series1entreno3dia3mujer);

        //espalda
        ejercicioespalda = (TextView) findViewById(R.id.ejercicio2entreno3dia3mujer);
        repeticionesespalda = (TextView) findViewById(R.id.reps2entreno3dia3mujer);
        imagenespalda = (ImageView) findViewById(R.id.imagen2entreno3dia3mujer);
        pesoespalda = (EditText) findViewById(R.id.peso2entreno3dia3mujer);
        seriesespalda = (TextView) findViewById(R.id.series2entreno3dia3mujer);


        //biceps
        ejerciciobiceps = (TextView) findViewById(R.id.ejercicio3entreno3dia3mujer);
        repeticionesbiceps = (TextView) findViewById(R.id.reps3entreno3dia3mujer);
        imagenbiceps = (ImageView) findViewById(R.id.imagen3entreno3dia3mujer);
        pesobiceps = (EditText) findViewById(R.id.peso3entreno3dia3mujer);
        seriesbiceps = (TextView) findViewById(R.id.series3entreno3dia3mujer);


        //triceps
        ejerciciotriceps = (TextView) findViewById(R.id.ejercicio4entreno3dia3mujer);
        repeticionestriceps = (TextView) findViewById(R.id.reps4entreno3dia3mujer);
        imagentriceps = (ImageView) findViewById(R.id.imagen4entreno3dia3mujer);
        pesotriceps = (EditText) findViewById(R.id.peso4entreno3dia3mujer);
        seriestriceps = (TextView) findViewById(R.id.series4entreno3dia3mujer);


        //frontales
        ejerciciofrontal = (TextView) findViewById(R.id.ejercicio5entreno3dia3mujer);
        repeticionesfrontal = (TextView) findViewById(R.id.reps5entreno3dia3mujer);
        imagenfrontal = (ImageView) findViewById(R.id.imagen5entreno3dia3mujer);
        pesofrontal = (EditText) findViewById(R.id.peso5entreno3dia3mujer);
        seriesfrontal= (TextView) findViewById(R.id.series5entreno3dia3mujer);


        //laterlaes
        ejerciciolateral = (TextView) findViewById(R.id.ejercicio6entreno3dia3mujer);
        repeticioneslateral = (TextView) findViewById(R.id.reps6entreno3dia3mujer);
        imagenlaterales = (ImageView) findViewById(R.id.imagen6entreno3dia3mujer);
        pesolateral = (EditText) findViewById(R.id.peso6entreno3dia3mujer);
        serieslateral = (TextView) findViewById(R.id.series6entreno3dia3mujer);


        //cuadriceps
        ejerciciocuadriceps = (TextView) findViewById(R.id.ejercicio7entreno3dia3mujer);
        repeticionescuadriceps = (TextView) findViewById(R.id.reps7entreno3dia3mujer);
        imagencuadriceps = (ImageView) findViewById(R.id.imagen7entreno3dia3mujer);
        pesocuadriceps = (EditText) findViewById(R.id.peso7entreno3dia3mujer);
        seriescuadriceps = (TextView) findViewById(R.id.series7entreno3dia3mujer);

        //isquios
        ejerciciofemoral = (TextView) findViewById(R.id.ejercicio8entreno3dia3mujer);
        repeticionesfemoral = (TextView) findViewById(R.id.reps8entreno3dia3mujer);
        imagenfemoral = (ImageView) findViewById(R.id.imagen8entreno3dia3mujer);
        pesofemoral = (EditText) findViewById(R.id.peso8entreno3dia3mujer);
        seriesfemoral = (TextView) findViewById(R.id.series8entreno3dia3mujer);


        //gluteos
        ejerciciogluteos= (TextView) findViewById(R.id.ejercicio9entreno3dia3mujer);
        repeticionesgluteos = (TextView) findViewById(R.id.reps9entreno3dia3mujer);
        imagengluteos = (ImageView) findViewById(R.id.imagen9entreno3dia3mujer);
        pesogluteos = (EditText) findViewById(R.id.peso9entreno3dia3mujer);
        seriesgluteos = (TextView) findViewById(R.id.series9entreno3dia3mujer);


        //pantorrillas
        ejerciciopantorrillas = (TextView) findViewById(R.id.ejercicio10entreno3dia3mujer);
        repeticionespantorrillas = (TextView) findViewById(R.id.reps10entreno3dia3mujer);
        imagenpantorrillas = (ImageView) findViewById(R.id.imagen10entreno3dia3mujer);
        pesopantorrillas = (EditText) findViewById(R.id.peso10entreno3dia3mujer);
        seriespantorrillas = (TextView) findViewById(R.id.series10entreno3dia3mujer);


        //trapecios
        ejerciciofemoral2 = (TextView) findViewById(R.id.ejercicio11entreno3dia3mujer);
        repeticionesfemoral2 = (TextView) findViewById(R.id.reps11entreno3dia3mujer);
        imagenfemoral2 = (ImageView) findViewById(R.id.imagen11entreno3dia3mujer);
        pesofemoral2 = (EditText) findViewById(R.id.peso11entreno3dia3mujer);
        seriesfemoral2 = (TextView) findViewById(R.id.series11entreno3dia3mujer);


        //abdomen
        ejercicioabdomen = (TextView) findViewById(R.id.ejercicio12entreno3dia3mujer);
        repeticionesbadomen = (TextView) findViewById(R.id.reps12entreno3dia3mujer);
        imageneabdomen = (ImageView) findViewById(R.id.imagen12entreno3dia3mujer);
        pesoabdomen = (EditText) findViewById(R.id.peso12entreno3dia3mujer);
        seriesabdomen = (TextView) findViewById(R.id.series12entreno3dia3mujer);

        mAuth = FirebaseAuth.getInstance();

        //logicadelentrenamiento(ejercicios)


        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if (datasnapshot.exists()) {

                    String ejercicio = datasnapshot.child("pectoral/ ejercicio tercero").getValue().toString();
                    ejerciciopectoral.setText(ejercicio);
                    ejercicioseleccionado = ejercicio;

                    String stringejercicioespalda = datasnapshot.child("espalda/ ejercicio tercero").getValue().toString();
                    ejercicioespalda.setText(stringejercicioespalda);
                    ejercicioseleccionadoespalda = stringejercicioespalda;

                    String stringejerciciobiceps = datasnapshot.child("biceps/ ejercicio tercero").getValue().toString();
                    ejerciciobiceps.setText(stringejerciciobiceps);
                    ejercicioseleccionadobiceps = stringejerciciobiceps;

                    String stringejerciciotriceps = datasnapshot.child("triceps/ ejercicio tercero").getValue().toString();
                    ejerciciotriceps.setText(stringejerciciotriceps);
                    ejercicioseleccionadotriceps = stringejerciciotriceps;

                    String stringejerciciofrontal = datasnapshot.child("deltoide frontal/ ejercicio tercero").getValue().toString();
                    ejerciciofrontal.setText(stringejerciciofrontal);
                    ejercicioseleccionadofrontal = stringejerciciofrontal;

                    String stringejerciciolateral = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();
                    ejerciciolateral.setText(stringejerciciolateral);
                    ejerciciosleccionadolaterales = stringejerciciolateral;

                    String stringejerciciocuadriceps = datasnapshot.child("cuadriceps/ ejercicio tercero").getValue().toString();
                    ejerciciocuadriceps.setText(stringejerciciocuadriceps);
                    ejercicioseleccionadocuadriceps = stringejerciciocuadriceps;

                    String stringejerciciogluteos = datasnapshot.child("gluteos y aductores/ ejercicio tercero").getValue().toString();
                    ejerciciogluteos.setText(stringejerciciogluteos);
                    ejerciciselecionadogluteo = stringejerciciogluteos;

                    String stringejerciciopant = datasnapshot.child("pantorrillas/ ejercicio tercero").getValue().toString();
                    ejerciciopantorrillas.setText(stringejerciciopant);
                    ejerciciseleccionadopantorrillas = stringejerciciopant;

                    String stringejercicioabs = datasnapshot.child("abdominales/ ejercicio tercero").getValue().toString();
                    ejercicioabdomen.setText(stringejercicioabs);
                    ejercicioseleccionadoabs = stringejercicioabs;

                    String stringejerciciotraps = datasnapshot.child("isquios/ ejercicio cuarto").getValue().toString();
                    ejerciciofemoral2.setText(stringejerciciotraps);
                    ejercicioseleccionadofemoral2 = stringejerciciotraps;

                    String stringejerciciofemoral = datasnapshot.child("isquios/ ejercicio tercero").getValue().toString();
                    ejerciciofemoral.setText(stringejerciciofemoral);
                    ejercicioseleccionadofemoral = stringejerciciofemoral;


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
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaciones%20frontales%20con%20mancuernas%2F20210131_110211.jpg?alt=media&token=d0d9503f-675a-49b7-a41f-b4b6bec5160b")
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
                if ( ejerciciosleccionadolaterales.equals("Elevaciones laterales con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaciones%20laterales%20con%20mancuernas%2F20210131_105249.jpg?alt=media&token=2ffa2e63-ca3c-4b91-900d-2a3b938a3932")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }


                if ( ejerciciosleccionadolaterales.equals("Elevación lateral con polea baja")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20polea%20baja%2F20210313_121731.jpg?alt=media&token=5248be4d-3506-4e15-8134-f5f4e06e2c8a")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejerciciosleccionadolaterales.equals("Flys invertidos en peck deck")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20en%20peck%20deck%2Fflye3.jpg?alt=media&token=6c84d085-2518-4319-8e27-444114709d9f")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejerciciosleccionadolaterales.equals("Remo al mentón con barra")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20barra%2Frem2.jpg?alt=media&token=d9843316-dd2f-43a3-a8a1-7f7168069624")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejerciciosleccionadolaterales.equals("Remo al mentón con polea baja")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem3.jpg.jpg?alt=media&token=b302e29e-81ff-429f-9daa-56c84b18ce6d")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejerciciosleccionadolaterales.equals("Elevación lateral con polea baja por detrás")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115743.jpg?alt=media&token=d75af285-55fc-499e-84cc-c13f86539e5c")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejerciciosleccionadolaterales.equals("Elevación lateral con mancuernas acostado en banco inclinado de perfil")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120233.jpg?alt=media&token=a40ae582-7b39-4ccd-927b-d64da79c55b8")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejerciciosleccionadolaterales.equals("Elevación lateral con mancuerna a 45°")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112606.jpg?alt=media&token=224d744f-9b85-4ea0-b50a-333667af2f9a")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejerciciosleccionadolaterales.equals("Flys cruzados con poleas")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejerciciosleccionadolaterales.equals("Flys agachado con mancuernas")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20agachados%2F20211210_120455.jpg?alt=media&token=3b398377-2569-4d55-9062-fb9e2011eaf5")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejerciciosleccionadolaterales.equals("Facepull con cuerda")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120826.jpg?alt=media&token=dad7d426-1561-4435-aac6-7c7cf954eb73")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                if ( ejerciciosleccionadolaterales.equals("Remo al mentón con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20mancuernas%2F20211210_120546.jpg?alt=media&token=c2160078-997f-46da-8464-35955cd1f23e")
                            .fit().centerCrop()
                            .into(imagenlaterales);
                }

                //cuadriceps
                if ( ejercicioseleccionadocuadriceps.equals("Desplantes con mancuernas")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fdesplantes%20con%20mancuernas%2F20210131_112942.jpg?alt=media&token=2b6b25b6-e5c6-4057-be69-bd2cad0c2af6")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionadocuadriceps.equals("Prensa a 1 pierna")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112525.jpg?alt=media&token=9288507d-1f03-4147-b0d4-b89d491dbc60")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionadocuadriceps.equals("Prensa a 45°")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115038.jpg?alt=media&token=f8264fd9-f7e9-440b-8557-00aac5fec37d")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionadocuadriceps.equals("Prensa horizontal en máquina")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20horizontal%20en%20maquina%2F20210202_115706.jpg?alt=media&token=71099f4e-277a-44f4-9d54-9b86509400a7")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionadocuadriceps.equals("Sentadilla con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20con%20barra%2F20210206_111054.jpg?alt=media&token=7bb9cf31-7d1f-46b9-aef2-3f92d0d662aa")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionadocuadriceps.equals("Sentadilla en máquina perfecta")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20en%20maquina%20perfecta%2F20210204_120342.jpg?alt=media&token=30659f89-9cf0-4183-97f8-1022479b30ab")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionadocuadriceps.equals("Sentadilla frontal con mancuernas")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113031.jpg?alt=media&token=b7055a35-bb96-4797-a082-7fb395bbfee3")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionadocuadriceps.equals("Sentadilla")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionadocuadriceps.equals("Sentadilla frontal con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionadocuadriceps.equals("Sentadilla frontal en smith")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20en%20smith%2F20211211_135602.jpg?alt=media&token=e1b0c3c9-2b6e-446a-9f05-d0651ba1da89")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionadocuadriceps.equals("Sentadilla smith profunda")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135922.jpg?alt=media&token=ddd7e42b-797b-4103-a384-0b9208546141")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionadocuadriceps.equals("Sentadilla smith a 90°")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20a%2090%20grados%20en%20smith%2FIMG_0338.jpg?alt=media&token=5a256969-7282-4b20-a9f4-e6801d322f68")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionadocuadriceps.equals("Sentadilla bulgara con mancuernas")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112831.jpg?alt=media&token=273285a7-7376-4960-a28b-252e1ae4236a")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionadocuadriceps.equals("Extensiones de cuadriceps en máquina")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111311.jpg?alt=media&token=fbafd51a-6f5b-48a2-a252-40a61c84f09d")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }



                //isquios
                if ( ejercicioseleccionadofemoral.equals("Curl acostado con mancuerna")) {
                    int reps = 15;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20acostado%20con%20mancuerna%2F20210308_122433.jpg?alt=media&token=93a79028-afb8-4b92-93d5-23cc097ca721")
                            .fit().centerCrop()
                            .into(imagenfemoral);
                }

                if ( ejercicioseleccionadofemoral.equals("Curl femoral parado a 1 pierna en máquina")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122852.jpg?alt=media&token=59d7e392-1aad-4c52-a71d-faf7a1224d05")
                            .fit().centerCrop()
                            .into(imagenfemoral);
                }

                if ( ejercicioseleccionadofemoral.equals("Curl femoral acostado en máquina")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20acostado%20en%20maquina%2F20210202_121632.jpg?alt=media&token=7cb5375f-ee3c-4a14-bf57-ed8aa27dbcf3")
                            .fit().centerCrop()
                            .into(imagenfemoral);
                }

                if ( ejercicioseleccionadofemoral.equals("Curl femoral sentado en máquina")) {
                    int reps = 10;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20sentado%20en%20maquina%20para%20isquiosurales%2F20210131_103833.jpg?alt=media&token=408960ec-40e6-4a2b-8fb5-8548347d77c5")
                            .fit().centerCrop()
                            .into(imagenfemoral);
                }

                if ( ejercicioseleccionadofemoral.equals("Peso muerto a 1 pierna")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20a%201%20pierna%2F20210131_113706.jpg?alt=media&token=01c3e97b-bc16-4bd3-be7e-2328716e9188")
                            .fit().centerCrop()
                            .into(imagenfemoral);
                }

                if ( ejercicioseleccionadofemoral.equals("Peso muerto con mancuernas")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20mancuernas%2F20210131_113529.jpg?alt=media&token=af2e3ef5-0983-418b-8ccf-94b0f39a5510")
                            .fit().centerCrop()
                            .into(imagenfemoral);
                }

                if ( ejercicioseleccionadofemoral.equals("Peso muerto con piernas rigidas con barra")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20piernas%20r%C3%ADgidas%20con%20barra%2F20210308_120010.jpg?alt=media&token=92155ace-9f79-4981-b5ff-8f6dbe9d9783")
                            .fit().centerCrop()
                            .into(imagenfemoral);
                }

                if ( ejercicioseleccionadofemoral.equals("Curl femoral acostado en máquina a 1 pierna")) {
                    int reps = 10;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122830(0).jpg?alt=media&token=70aa1e30-89af-46af-9a9e-b3e9b805b93c")
                            .fit().centerCrop()
                            .into(imagenfemoral);
                }


                if ( ejercicioseleccionadofemoral.equals("Peso muerto en smith")) {
                    int reps = 10;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20en%20smith%2F20211211_135441.jpg?alt=media&token=7788cc84-8a01-4bb4-8c6e-258a26be9a98")
                            .fit().centerCrop()
                            .into(imagenfemoral);
                }


                if ( ejercicioseleccionadofemoral.equals("Elevación de cadera a una pierna")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Felevaci%C3%B3n%20de%20cadera%20a%201%20pierna%2F20211211_135110.jpg?alt=media&token=acbc4c3f-9615-440c-bdff-28ebfc54a1ae")
                            .fit().centerCrop()
                            .into(imagenfemoral);
                }


                //isquios
                if ( ejercicioseleccionadofemoral2.equals("Curl acostado con mancuerna")) {
                    int reps = 15;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20acostado%20con%20mancuerna%2F20210308_122433.jpg?alt=media&token=93a79028-afb8-4b92-93d5-23cc097ca721")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral parado a 1 pierna en máquina")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122852.jpg?alt=media&token=59d7e392-1aad-4c52-a71d-faf7a1224d05")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral acostado en máquina")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20acostado%20en%20maquina%2F20210202_121632.jpg?alt=media&token=7cb5375f-ee3c-4a14-bf57-ed8aa27dbcf3")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral sentado en máquina")) {
                    int reps = 10;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20sentado%20en%20maquina%20para%20isquiosurales%2F20210131_103833.jpg?alt=media&token=408960ec-40e6-4a2b-8fb5-8548347d77c5")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Peso muerto a 1 pierna")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20a%201%20pierna%2F20210131_113706.jpg?alt=media&token=01c3e97b-bc16-4bd3-be7e-2328716e9188")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Peso muerto con mancuernas")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20mancuernas%2F20210131_113529.jpg?alt=media&token=af2e3ef5-0983-418b-8ccf-94b0f39a5510")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Peso muerto con piernas rigidas con barra")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20piernas%20r%C3%ADgidas%20con%20barra%2F20210308_120010.jpg?alt=media&token=92155ace-9f79-4981-b5ff-8f6dbe9d9783")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral acostado en máquina a 1 pierna")) {
                    int reps = 10;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122830(0).jpg?alt=media&token=70aa1e30-89af-46af-9a9e-b3e9b805b93c")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }


                if ( ejercicioseleccionadofemoral2.equals("Peso muerto en smith")) {
                    int reps = 10;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20en%20smith%2F20211211_135441.jpg?alt=media&token=7788cc84-8a01-4bb4-8c6e-258a26be9a98")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }


                if ( ejercicioseleccionadofemoral2.equals("Elevación de cadera a una pierna")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Felevaci%C3%B3n%20de%20cadera%20a%201%20pierna%2F20211211_135110.jpg?alt=media&token=acbc4c3f-9615-440c-bdff-28ebfc54a1ae")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }





                //gluteos
                if ( ejerciciselecionadogluteo.equals("Aducciones de cadera en polea")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111641.jpg?alt=media&token=2c6c6ec6-806a-4bca-ae11-f4284d740751")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejerciciselecionadogluteo.equals("Aducciones de cadera en máquina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20en%20maquina%2F20210224_120014.jpg?alt=media&token=10f79db9-a51a-4c7f-b345-bbf315bd89f4")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejerciciselecionadogluteo.equals("Goblet squat")) {
                    int reps = 10;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgoblet%20squat%2F20211210_111428.jpg?alt=media&token=a8cb7d1d-d535-4868-b03b-f443a1e70a87")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejerciciselecionadogluteo.equals("Hip thrust con barra")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fhip%20thrust%20con%20barra%2F20210210_112151.jpg?alt=media&token=4ee62dc4-1073-448a-a1f2-64ed8e0eccd0")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejerciciselecionadogluteo.equals("Patada para glúteo con mancuerna")) {
                    int reps = 10;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20mancuerna%2F20210210_113919.jpg?alt=media&token=9ecbd1ff-9b5e-4314-9d18-6e5ef6297ba9")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejerciciselecionadogluteo.equals("Abducciones de cadera en polea")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111641.jpg?alt=media&token=2c6c6ec6-806a-4bca-ae11-f4284d740751")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }


                if ( ejerciciselecionadogluteo.equals("Abducciones de cadera en máquina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20en%20maquina%2F20210204_115306.jpg?alt=media&token=f072eb5e-d411-4ef7-9e8b-d23cfbd0a990")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejerciciselecionadogluteo.equals("Patada para glúteo con polea")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20polea%2F20210308_125722.jpg?alt=media&token=ba18cfd3-bc40-4919-b59d-7868d8b95f1c")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejerciciselecionadogluteo.equals("Patada para glúteos con máquina de pie")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%20de%20pie%2F20210202_123925.jpg?alt=media&token=09e3e5ff-2478-4f3d-aa0c-c210a296761b")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejerciciselecionadogluteo.equals("Patada para glúteos en máquina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%2F20210131_111648.jpg?alt=media&token=e014fed1-f7cd-49f9-b683-3a5620b0b029")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejerciciselecionadogluteo.equals("Peso muerto tipo sumo con barra")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20barra%2F20210210_112935.jpg?alt=media&token=b2d84e57-45a6-4bf5-8a8b-8d671513cd8f")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejerciciselecionadogluteo.equals("Peso muerto tipo sumo con mancuerna")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20mancuerna%2F20210131_113330.jpg?alt=media&token=f79ca688-ba30-4d65-a328-ee456f27013e")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejerciciselecionadogluteo.equals("Puente a 1 pierna")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20a%201%20pierna%2F20210131_113159.jpg?alt=media&token=bcabdcb0-892f-4e4a-bc08-7f696e3fce95")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejerciciselecionadogluteo.equals("Puente con mancuerna")) {
                    int reps = 10;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20con%20mancuerna%2F20210131_113131.jpg?alt=media&token=5207ad4d-8bbc-4d2a-9ca6-6abdfdfd013f")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejerciciselecionadogluteo.equals("Sentadilla smith tipo sumo")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fsentadilla%20Smith%20tipo%20sumo%2F20210310_114633.jpg?alt=media&token=50fb2cd4-d99a-4852-b0d6-1e379903c736")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }






                //pantorrillas
                if ( ejerciciseleccionadopantorrillas.equals("Elevaciones de talón en costurera")) {
                    int reps = 15;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20costurera%2F20210220_123439.jpg?alt=media&token=cd5d5a75-3dfc-46ce-8b24-1b366faa38ee")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }

                if ( ejerciciseleccionadopantorrillas.equals("Elevación de talón en prensa a 1 pierna")) {
                    int reps = 10;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20a%201%20pierna%2F20210215_130011.jpg?alt=media&token=d3f4cafe-26f6-4cd2-a862-d02e29ff75ba")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }

                if ( ejerciciseleccionadopantorrillas.equals("Elevación de talón parado con mancuernas")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20parado%20con%20mancuerna%2F20210310_120558.jpg?alt=media&token=3d5edaad-c045-4256-aea7-34d967faef76")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }

                if ( ejerciciseleccionadopantorrillas.equals("Elevación de talón parado en máquina")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20sentadilla%20perfecta%2F20211215_113308.jpg?alt=media&token=8ebb1b76-9791-414a-8965-b6504b4b2d7b")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }

                if ( ejerciciseleccionadopantorrillas.equals("Elevación de talón en prensa 45°")) {
                    int reps = 8;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaci%C3%B3n%20de%20tal%C3%B3n%20en%20prensa%2045%C2%B0%2FIMG_0369.jpg?alt=media&token=1f2c4ccf-7cf9-4dd2-bd92-7bab13bc3539")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }

                if ( ejerciciseleccionadopantorrillas.equals("Elevación de talón en prensa horizontal")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20horizontal%2F20211215_111104.jpg?alt=media&token=65f55792-18ee-4e71-bfd3-68788892af40")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }



                //isquios
                if ( ejercicioseleccionadofemoral2.equals("Curl acostado con mancuerna")) {
                    int reps = 15;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20acostado%20con%20mancuerna%2F20210308_122433.jpg?alt=media&token=93a79028-afb8-4b92-93d5-23cc097ca721")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral parado a 1 pierna en máquina")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122852.jpg?alt=media&token=59d7e392-1aad-4c52-a71d-faf7a1224d05")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral acostado en máquina")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20acostado%20en%20maquina%2F20210202_121632.jpg?alt=media&token=7cb5375f-ee3c-4a14-bf57-ed8aa27dbcf3")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral sentado en máquina")) {
                    int reps = 10;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20sentado%20en%20maquina%20para%20isquiosurales%2F20210131_103833.jpg?alt=media&token=408960ec-40e6-4a2b-8fb5-8548347d77c5")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Peso muerto a 1 pierna")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20a%201%20pierna%2F20210131_113706.jpg?alt=media&token=01c3e97b-bc16-4bd3-be7e-2328716e9188")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Peso muerto con mancuernas")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20mancuernas%2F20210131_113529.jpg?alt=media&token=af2e3ef5-0983-418b-8ccf-94b0f39a5510")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Peso muerto con piernas rigidas con barra")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20piernas%20r%C3%ADgidas%20con%20barra%2F20210308_120010.jpg?alt=media&token=92155ace-9f79-4981-b5ff-8f6dbe9d9783")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral acostado en máquina a 1 pierna")) {
                    int reps = 10;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122830(0).jpg?alt=media&token=70aa1e30-89af-46af-9a9e-b3e9b805b93c")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }


                if ( ejercicioseleccionadofemoral2.equals("Peso muerto en smith")) {
                    int reps = 10;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20en%20smith%2F20211211_135441.jpg?alt=media&token=7788cc84-8a01-4bb4-8c6e-258a26be9a98")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }


                if ( ejercicioseleccionadofemoral2.equals("Elevación de cadera a una pierna")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Felevaci%C3%B3n%20de%20cadera%20a%201%20pierna%2F20211211_135110.jpg?alt=media&token=acbc4c3f-9615-440c-bdff-28ebfc54a1ae")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }




                //abs
                if ( ejercicioseleccionadoabs.equals("Crunch abdominal en maquina con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20maquina%20con%20cuerda%2F20210203_122801.jpg?alt=media&token=b7b6492d-0e43-4d80-8e4a-58a874b0b740")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if ( ejercicioseleccionadoabs.equals("Crunch abdominal")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121917.jpg?alt=media&token=6a7354cf-d38a-4931-ae6d-3bd5a0a6f1a1")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if ( ejercicioseleccionadoabs.equals("Crunch abdominal en maquina")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123647.jpg?alt=media&token=21d241b4-69a6-4e42-8f6b-d8eab01d5e16")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if ( ejercicioseleccionadoabs.equals("Rodillo abdominal")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112445.jpg?alt=media&token=65fbc2e2-c04e-4300-af76-36ba341c3a1b")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if ( ejercicioseleccionadoabs.equals("Elevaciones de piernas acostado en banco")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854.jpg?alt=media&token=9cab081e-a91e-40ef-8be1-e481445eddd1")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if ( ejercicioseleccionadoabs.equals("Elevaciones de piernas en silla romana")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112604.jpg?alt=media&token=a27b1953-a16e-419b-b206-ad01ebf5138d")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if ( ejercicioseleccionadoabs.equals("Crunch tipo bicicleta")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if ( ejercicioseleccionadoabs.equals("Crunch abdominal en banco declinado")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113147.jpg?alt=media&token=55b3d636-887e-4c01-ba37-e274fce2e1d1")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if ( ejercicioseleccionadoabs.equals("Crunch abdominal en banco declinado con balon en la nuca")) {
                    int reps = 8;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113217.jpg?alt=media&token=a6ad17e7-d218-41c7-9412-b26ffd74fc38")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if ( ejercicioseleccionadoabs.equals("Crunch acostado en flexión de piernas")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20con%20flexi%C3%B3n%20de%20piernas%2F20211210_113340.jpg?alt=media&token=063a87c6-0413-4e4f-b103-8e1892a93987")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if ( ejercicioseleccionadoabs.equals("Crunch lateral")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113437.jpg?alt=media&token=eccbfefe-6820-4879-b370-0ccb1454573e")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if ( ejercicioseleccionadoabs.equals("Toques al talón")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113834.jpg?alt=media&token=3521bce4-bbd0-4936-9994-1df7bd3f72d4")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if ( ejercicioseleccionadoabs.equals("Crunch lateral con polea alta")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113702.jpg?alt=media&token=1717a072-a610-449b-8a35-3dec01aded1a")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if ( ejercicioseleccionadoabs.equals("Crunch abdominal hincado con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112931.jpg?alt=media&token=6dc6d69c-958a-4c9d-b5c3-0cd990fde57a")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }




//-------------------------------------------------------------------------------------------------------------------------------------------------------------
                //RER

                String RER1 = datasnapshot.child("progresosrer").getValue().toString();
                int rer1int = Integer.parseInt(RER1);
                String ejerciciopecho = datasnapshot.child("pectoral/ ejercicio tercero").getValue().toString();
                String ejercicioespalda = datasnapshot.child("espalda/ ejercicio tercero").getValue().toString();
                String ejerciciobiceps = datasnapshot.child("biceps/ ejercicio tercero").getValue().toString();
                String ejerciciotriceps = datasnapshot.child("triceps/ ejercicio tercero").getValue().toString();
                String ejerciciofrontal = datasnapshot.child("deltoide frontal/ ejercicio tercero").getValue().toString();
                String ejerciciolateral = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();
                String ejerciciocuadriceps = datasnapshot.child("cuadriceps/ ejercicio tercero").getValue().toString();
                String ejerciciofemorales = datasnapshot.child("isquios/ ejercicio tercero").getValue().toString();
                String ejerciciogluteos = datasnapshot.child("gluteos y aductores/ ejercicio tercero").getValue().toString();
                String ejerciciopantor = datasnapshot.child("pantorrillas/ ejercicio tercero").getValue().toString();
                String ejercicioabdomen = datasnapshot.child("abdominales/ ejercicio tercero").getValue().toString();
                String ejerciciofemorales2 = datasnapshot.child("isquios/ ejercicio cuarto").getValue().toString();




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


                    //abdomen
                    switch(ejercicioabdomen){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Rodillo abdominal":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer12.setText("3 - 4 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Plancha":
                            rer12.setText("-");
                            break;

                        case "Toques al talón":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Crunch lateral":
                            rer12.setText("2 - 3 RER");
                            break;

                    }

                    //deltoides laterales
                    switch(ejerciciolateral){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer6.setText("3 - 4 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer6.setText("3 - 4 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer6.setText("3 - 4 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer6.setText("3 - 4 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Facepull con cuerda":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer6.setText("2 - 3 RER");
                            break;

                    }



                    //FRONTAL
                    switch(ejerciciofrontal){
                        //ejercicios compuestos
                        case "Press militar con barra":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Press militar con mancuernas":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Push press":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Press militar en smith":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Press en máquina agarre prono":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Press Arnold":
                            rer5.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Press en máquina agarre neutro":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre prono":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con mancuerna agarre supino":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con polea baja a 1 brazo":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con disco":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontal con cuerda en polea baja":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre neutro":
                            rer5.setText("2 - 3 RER");
                            break;

                    }



                    //triceps
                    switch(ejerciciotriceps){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Press cerrado en smith":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Copa con barra":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer4.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Fondos en máquina":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer4.setText("2 - 3 RER");
                            break;

                    }


                    //BICEPS
                    switch(ejerciciobiceps){
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer3.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Curl spider con barra":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer3.setText("2 - 3 RER");
                            break;


                    }

                    //PANTORRILLAS
                    switch(ejerciciopantor){
                        //ejercicios compuestos
                        case "Elevación de talón parado en máquina":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Elevación de talón en prensa 45°":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Elevación de talón en prensa a 1 pierna":
                            rer10.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "ELevación de talón parado con mancuerna":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevaciones de talón en costurera":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevación de talón en prensa horizontal":
                            rer10.setText("2 - 3 RER");
                            break;
                    }


                    //GLUTEOS
                    switch(ejerciciogluteos){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Patada para glúteos con máquina de pie":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer9.setText("3 - 4 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Aducciones de cadera en máquina":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Peso muerto tipo sumo con mancuernal":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Goblet squat":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Abducciones de cadera en polea":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Abducciones de cadera en máquina":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Patada para glúteo con polea":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Patada para glúteos en máquina":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Puente con mancuerna":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Patada para glúteo con mancuerna":
                            rer9.setText("2 - 3 RER");
                            break;

                    }


                    //ISQUIOS
                    switch(ejerciciofemorales){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer8.setText("3 - 4 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer8.setText("3 - 4 RER");
                            break;

                        case "Peso muerto en smith":
                            rer8.setText("3 - 4 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl femoral acostado en máquina":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl femoral acostado en máquina a 1 pierna":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl femoral sentado en máquina":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en máquina":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Elevación de cadera a una pierna":
                            rer8.setText("2 - 3 RER");
                            break;

                    }


                    //ISQUIOS
                    switch(ejerciciofemorales2){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Peso muerto en smith":
                            rer11.setText("3 - 4 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Curl femoral acostado en máquina":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Curl femoral acostado en máquina a 1 pierna":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Curl femoral sentado en máquina":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en máquina":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Elevación de cadera a una pierna":
                            rer11.setText("2 - 3 RER");
                            break;

                    }


                    //espalda
                    switch(ejercicioespalda){
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

                    //cuadriceps
                    switch(ejerciciocuadriceps){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Sentadilla con barra":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Prensa a 45°":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer7.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90°":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Prensa horizontal en máquina":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Sentadilla en máquina perfecta":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Extensiones de cuadriceps en máquina":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Sentadilla":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer7.setText("2 - 3 RER");
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


                    //abdomen
                    switch(ejercicioabdomen){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Rodillo abdominal":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer12.setText("1 - 2 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Crunch abdominal":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Plancha":
                            rer12.setText("-");
                            break;

                        case "Toques al talón":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Crunch lateral":
                            rer12.setText("0 - 1 RER");
                            break;

                    }

                    //deltoides laterales
                    switch(ejerciciolateral){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer6.setText("1 - 2 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Facepull con cuerda":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer6.setText("0 - 1 RER");
                            break;

                    }




                    //FRONTAL
                    switch(ejerciciofrontal){
                        //ejercicios compuestos
                        case "Press militar con barra":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Press militar con mancuernas":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Push press":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Press militar en smith":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Press en máquina agarre prono":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Press Arnold":
                            rer5.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Press en máquina agarre neutro":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre prono":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con mancuerna agarre supino":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con polea baja a 1 brazo":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con disco":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontal con cuerda en polea baja":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre neutro":
                            rer5.setText("0 - 1 RER");
                            break;

                    }



                    //triceps
                    switch(ejerciciotriceps){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Press cerrado en smith":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Copa con barra":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer4.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Fondos en máquina":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer4.setText("0 - 1 RER");
                            break;

                    }


                    //BICEPS
                    switch(ejerciciobiceps){
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer3.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer3.setText("0 - 1  RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Curl spider con barra":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer3.setText("0 - 1 RER");
                            break;


                    }

                    //PANTORRILLAS
                    switch(ejerciciopantor){
                        //ejercicios compuestos
                        case "Elevación de talón parado en máquina":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Elevación de talón en prensa 45°":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Elevación de talón en prensa a 1 pierna":
                            rer10.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "ELevación de talón parado con mancuerna":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Elevaciones de talón en costurera":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Elevación de talón en prensa horizontal":
                            rer10.setText("0 - 1 RER");
                            break;
                    }


                    //PANTORRILLAS
                    switch(ejerciciogluteos){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Patada para glúteos con máquina de pie":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer9.setText("1 - 2 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Aducciones de cadera en máquina":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Peso muerto tipo sumo con mancuernal":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Goblet squat":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Abducciones de cadera en polea":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Abducciones de cadera en máquina":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Patada para glúteo con polea":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Patada para glúteos en máquina":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Puente con mancuerna":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Patada para glúteo con mancuerna":
                            rer9.setText("0 - 1 RER");
                            break;

                    }


                    //ISQUIOS
                    switch(ejerciciofemorales){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Peso muerto en smith":
                            rer8.setText("1 - 2 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en máquina":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en máquina a 1 pierna":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Curl femoral sentado en máquina":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en máquina":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Elevación de cadera a una pierna":
                            rer8.setText("0 - 1 RER");
                            break;

                    }


                    //ISQUIOS
                    switch(ejerciciofemorales2){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Peso muerto en smith":
                            rer11.setText("1 - 2 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en máquina":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en máquina a 1 pierna":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Curl femoral sentado en máquina":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en máquina":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Elevación de cadera a una pierna":
                            rer11.setText("0 - 1 RER");
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

                    //cuadriceps
                    switch(ejerciciocuadriceps){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Sentadilla con barra":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Prensa a 45°":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer7.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90°":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Prensa horizontal en máquina":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Sentadilla en máquina perfecta":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Extensiones de cuadriceps en máquina":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Sentadilla":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer7.setText("0 - 1 RER");
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


                    //abdomen
                    switch(ejercicioabdomen){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Rodillo abdominal":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer12.setText("2 - 3 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Plancha":
                            rer12.setText("-");
                            break;

                        case "Toques al talón":
                            rer12.setText("1 - 1 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Crunch lateral":
                            rer12.setText("1 - 2 RER");
                            break;

                    }

                    //deltoides laterales
                    switch(ejerciciolateral){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer6.setText("2 - 3 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Facepull con cuerda":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer6.setText("1 - 2 RER");
                            break;

                    }



                    //FRONTAL
                    switch(ejerciciofrontal){
                        //ejercicios compuestos
                        case "Press militar con barra":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Press militar con mancuernas":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Push press":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Press militar en smith":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Press en máquina agarre prono":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Press Arnold":
                            rer5.setText("2 - 3 RER");
                            break;




                        //ejercicios simples
                        case "Press en máquina agarre neutro":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre prono":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con mancuerna agarre supino":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con polea baja a 1 brazo":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con disco":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontal con cuerda en polea baja":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre neutro":
                            rer5.setText("1 - 2 RER");
                            break;

                    }



                    //triceps
                    switch(ejerciciotriceps){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Press cerrado en smith":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Copa con barra":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer4.setText("2 - 3 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Fondos en máquina":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer4.setText("1 - 2 RER");
                            break;

                    }


                    //BICEPS
                    switch(ejerciciobiceps){
                        //ejercicios compuestos
                        case "Curl martillo con barra romana":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps a 90° con barra":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Curl predicador con barra z":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Curl concentrado a 1 brazo recargado en muslo":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Curl martillo con mancuernas":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Curl de biceps con barra z":
                            rer3.setText("2 - 3 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps acostado en banco inclinado":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps alternado":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Curl spider con barra":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Curl de bíceps en predicador con mancuernas":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Curl martillo con cuerda":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con polea maneral recto":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps en máquina":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Curl de biceps con polea altura media a 1 brazo":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Curl spider con mancuernas":
                            rer3.setText("1 - 2 RER");
                            break;


                    }


                    //PANTORRILLAS
                    switch(ejerciciopantor){
                        //ejercicios compuestos
                        case "Elevación de talón parado en máquina":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevación de talón en prensa 45°":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevación de talón en prensa a 1 pierna":
                            rer10.setText("2 - 3 RER");
                            break;



                        //ejercicios simples
                        case "ELevación de talón parado con mancuerna":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de talón en costurera":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Elevación de talón en prensa horizontal":
                            rer10.setText("1 - 2 RER");
                            break;
                    }


                    //PANTORRILLAS
                    switch(ejerciciogluteos){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Patada para glúteos con máquina de pie":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer9.setText("2 - 3 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Aducciones de cadera en máquina":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Peso muerto tipo sumo con mancuernal":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Goblet squat":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Abducciones de cadera en polea":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Abducciones de cadera en máquina":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Patada para glúteo con polea":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Patada para glúteos en máquina":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Puente con mancuerna":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Patada para glúteo con mancuerna":
                            rer9.setText("1 - 2 RER");
                            break;

                    }


                    //ISQUIOS
                    switch(ejerciciofemorales){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Peso muerto en smith":
                            rer8.setText("2 - 3 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl femoral acostado en máquina":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl femoral acostado en máquina a 1 pierna":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl femoral sentado en máquina":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en máquina":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Elevación de cadera a una pierna":
                            rer8.setText("1 - 2 RER");
                            break;

                    }



                    //ISQUIOS
                    switch(ejerciciofemorales2){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Peso muerto en smith":
                            rer11.setText("2 - 3 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Curl femoral acostado en máquina":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Curl femoral acostado en máquina a 1 pierna":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Curl femoral sentado en máquina":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en máquina":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Elevación de cadera a una pierna":
                            rer11.setText("1 - 2 RER");
                            break;

                    }


                    //espalda
                    switch(ejercicioespalda){
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

                    //cuadriceps
                    switch(ejerciciocuadriceps){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Sentadilla con barra":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Prensa a 45°":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer7.setText("2 - 3 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90°":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Prensa horizontal en máquina":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Sentadilla en máquina perfecta":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Extensiones de cuadriceps en máquina":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Sentadilla":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer7.setText("1 - 2 RER");
                            break;

                    }







                }













//-------------------------------------------------------------------------------------------------------------------------------------------------------------

                //SERIES

                String spectoral = datasnapshot.child("series pectoral").getValue().toString();
                Double sp = Double.parseDouble(spectoral);
                Double spdividido = sp / 3;
                Double spf = Math.ceil(spdividido);
                int spfint = (int) Math.round(spf);
                if (spfint == 1){
                    spfint++;
                }
                String seriesfinalpectoral = String.valueOf(spfint);
                seriespectoral.setText(seriesfinalpectoral + " Series");



                String sespalda = datasnapshot.child("series espalda").getValue().toString();
                Double se = Double.parseDouble(sespalda);
                Double sedividido = se / 3;
                Double sef = Math.ceil(sedividido);
                int sefint = (int) Math.round(sef);
                if (sefint == 1){
                    sefint++;
                }
                String seriesfinalespalda = String.valueOf(sefint);
                seriesespalda.setText(seriesfinalespalda + " Series");



                String sbiceps = datasnapshot.child("series biceps").getValue().toString();
                Double sb = Double.parseDouble(sbiceps);
                Double sbdividido = sb / 3;
                Double sbf = Math.ceil(sbdividido);
                int sbfint = (int) Math.round(sbf);
                if (sbfint == 1){
                    sbfint++;
                }
                String seriesfinalbiceps = String.valueOf(sbfint);
                seriesbiceps.setText(seriesfinalbiceps + " Series");


                String striceps = datasnapshot.child("series triceps").getValue().toString();
                Double str = Double.parseDouble(striceps);
                Double strdividido = str / 3;
                Double strf = Math.ceil(strdividido);
                int strfint = (int) Math.round(strf);
                if (strfint == 1){
                    strfint++;
                }
                String seriesfinaltriceps = String.valueOf(strfint);
                seriestriceps.setText(seriesfinaltriceps + " Series");


                String sfrontal = datasnapshot.child("series deltoide frontal").getValue().toString();
                Double sfr = Double.parseDouble(sfrontal);
                Double sfrontaldividido = sfr / 3;
                Double sfrontalf = Math.ceil(sfrontaldividido);
                int sfrontalint = (int) Math.round(sfrontalf);
                if (sfrontalint == 1){
                    sfrontalint++;
                }
                String seriesfinalfrontal = String.valueOf(sfrontalint);
                seriesfrontal.setText(seriesfinalfrontal + " Series");


                String slateral = datasnapshot.child("series deltoides laterales y posteriores").getValue().toString();
                Double slat = Double.parseDouble(slateral);
                Double slateraldividido = slat / 3;
                Double slateralf = Math.ceil(slateraldividido);
                int slateralint = (int) Math.round(slateralf);
                if (slateralint == 1){
                    slateralint++;
                }
                String seriesfinallateral = String.valueOf(slateralint);
                serieslateral.setText(seriesfinallateral + " Series");


                String scuadriceps = datasnapshot.child("series cuadriceps").getValue().toString();
                Double scuad = Double.parseDouble(scuadriceps);
                Double scuaddividido = scuad / 3;
                Double scuadf = Math.ceil(scuaddividido);
                int scuadint = (int) Math.round(scuadf);
                if (scuadint == 1){
                    scuadint++;
                }
                String seriesfinalcuad = String.valueOf(scuadint);
                seriescuadriceps.setText(seriesfinalcuad + " Series");


                String sfemorales = datasnapshot.child("series femorales").getValue().toString();
                Double sfem = Double.parseDouble(sfemorales);
                Double sfemdividido = sfem / 3;
                Double sfemoralesf = Math.ceil(sfemdividido);
                int sfemoralesint = (int) Math.round(sfemoralesf);
                if (sfemoralesint== 1){
                    sfemoralesint++;
                }
                String seriesfinalfemorales = String.valueOf(sfemoralesint);
                seriesfemoral.setText(seriesfinalfemorales + " Series");


                String sgluteos = datasnapshot.child("series gluteos").getValue().toString();
                Double sgl = Double.parseDouble(sgluteos);
                Double sgluteosdividido = sgl / 3;
                Double sgluteosf = Math.ceil(sgluteosdividido);
                int sgluteosint = (int) Math.round(sgluteosf);
                if (sgluteosint == 1){
                    sgluteosint++;
                }
                String seriesgluteosfinal = String.valueOf(sgluteosint);
                seriesgluteos.setText(seriesgluteosfinal + " Series");


                String spantorrillas = datasnapshot.child("series pantorrillas").getValue().toString();
                Double span = Double.parseDouble(spantorrillas);
                Double spantorrillasdividido = span / 3;
                Double spantof = Math.ceil(spantorrillasdividido);
                int spantorrillasint = (int) Math.round(spantof);
                if (spantorrillasint == 1){
                    spantorrillasint++;
                }
                String seriesfinalpantorrillas = String.valueOf(spantorrillasint);
                seriesfrontal.setText(seriesfinalpantorrillas + " Series");



                String strapecios = datasnapshot.child("series femorales").getValue().toString();
                Double straps = Double.parseDouble(strapecios);
                Double strapeciosdividido = straps / 3;
                Double strapsf = Math.ceil(strapeciosdividido);
                int strapeciosint = (int) Math.round(strapsf);
                if (strapeciosint == 1){
                    strapeciosint++;
                }
                String seriesfinaltrapecios = String.valueOf(strapeciosint);
                seriesfemoral2.setText(seriesfinaltrapecios + " Series");




                String sabdomen = datasnapshot.child("series abdominales").getValue().toString();
                Double sabds = Double.parseDouble(sabdomen);
                Double sabdomendividido = sabds / 3;
                Double sabsf = Math.ceil(sabdomendividido);
                int sabdomenint = (int) Math.round(sabsf);
                if (sabdomenint == 1){
                    sabdomenint++;
                }
                String seriesfinalabdomen = String.valueOf(sabdomenint);
                seriesabdomen.setText(seriesfinalabdomen + " Series");





                String stringpesoinicial = datasnapshot.child("Historial pectoral/ 3 dias/ primer ejercicio/ dia 3").getValue().toString();
                peso1.setText(stringpesoinicial);

                String stringpesoinicialespalda = datasnapshot.child("Historial espalda/ 3 dias/ primer ejercicio/ dia 3").getValue().toString();
                pesoespalda.setText(stringpesoinicialespalda);

                String stringpesoinicialbiceps = datasnapshot.child("Historial biceps/ 3 dias/ primer ejercicio/ dia 3").getValue().toString();
                pesobiceps.setText(stringpesoinicialbiceps);

                String stringpesoinicialtriceps = datasnapshot.child("Historial triceps/ 3 dias/ primer ejercicio/ dia 3").getValue().toString();
                pesotriceps.setText(stringpesoinicialtriceps);

                String stringpesoinicialfrontal = datasnapshot.child("Historial frontal/ 3 dias/ primer ejercicio/ dia 3").getValue().toString();
                pesofrontal.setText(stringpesoinicialfrontal);

                String stringpesoiniciallateral = datasnapshot.child("Historial deltoides laterales y posteriores/ 3 dias/ primer ejercicio/ dia 3").getValue().toString();
                pesolateral.setText(stringpesoiniciallateral);

                String stringpesoinicialcuadriceps = datasnapshot.child("Historial cuadriceps/ 3 dias/ primer ejercicio/ dia 3").getValue().toString();
                pesocuadriceps.setText(stringpesoinicialcuadriceps);

                String stringpesoinicialfemoral = datasnapshot.child("Historial isquios/ 3 dias/ primer ejercicio/ dia 3").getValue().toString();
                pesofemoral.setText(stringpesoinicialfemoral);

                String stringpesoinicialpantorrillas = datasnapshot.child("Historial pantorrillas/ 3 dias/ primer ejercicio/ dia 3").getValue().toString();
                pesopantorrillas.setText(stringpesoinicialpantorrillas);

                String stringpesoinicialgluteos = datasnapshot.child("Historial gluteos y aductores/ 3 dias/ primer ejercicio/ dia 3").getValue().toString();
                pesogluteos.setText(stringpesoinicialgluteos);

                String stringpesoinicialtrapecios = datasnapshot.child("Historial isquios/ 3 dias/ segundo ejercicio/ dia 3").getValue().toString();
                pesofemoral2.setText(stringpesoinicialtrapecios);

                String stringpesoinicialabdomen = datasnapshot.child("Historial abdomen/ 3 dias/ primer ejercicio/ dia 3").getValue().toString();
                pesoabdomen.setText(stringpesoinicialabdomen);





            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
























        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidad.setAdapter(adapter1);
        ArrayAdapter<CharSequence> adapter21 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadespalda.setAdapter(adapter21);
        ArrayAdapter<CharSequence> adapter31 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadbiceps.setAdapter(adapter31);
        ArrayAdapter<CharSequence> adapter41 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadtriceps.setAdapter(adapter41);
        ArrayAdapter<CharSequence> adapter51 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadfrontal.setAdapter(adapter51);
        ArrayAdapter<CharSequence> adapter61 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadlaterales.setAdapter(adapter61);
        ArrayAdapter<CharSequence> adapter71 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadcuadriceps.setAdapter(adapter71);
        ArrayAdapter<CharSequence> adapter81 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadisquios.setAdapter(adapter81);
        ArrayAdapter<CharSequence> adapter91 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadpantorrillas.setAdapter(adapter91);
        ArrayAdapter<CharSequence> adapter101 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadgluteos.setAdapter(adapter101);
        ArrayAdapter<CharSequence> adapter111 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadabdomen.setAdapter(adapter111);
        ArrayAdapter<CharSequence> adapter121 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinnerintensidadtrapecios.setAdapter(adapter121);



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

                                                   mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
                                                       @Override
                                                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                           String pesoa = pesoespalda.getText().toString();
                                                           Map<String, Object> pesoactualizandose = new HashMap<>();
                                                           pesoactualizandose.put("Historial espalda/ 3 dias/ primer ejercicio/ dia 3", pesoa);


                                                           mDatabase.child("Users").child(id).updateChildren(pesoactualizandose);
                                                       }

                                                       @Override
                                                       public void onCancelled(@NonNull DatabaseError error) {

                                                       }
                                                   });


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
                                                  SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesobiceps.getContext());
                                                  preferences.edit().putString("editText",editable.toString()).commit();

                                                  mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
                                                      @Override
                                                      public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                          String pesoa = pesobiceps.getText().toString();
                                                          Map<String, Object> pesoactualizandose = new HashMap<>();
                                                          pesoactualizandose.put("Historial biceps/ 3 dias/ primer ejercicio/ dia 3", pesoa);


                                                          mDatabase.child("Users").child(id).updateChildren(pesoactualizandose);
                                                      }

                                                      @Override
                                                      public void onCancelled(@NonNull DatabaseError error) {

                                                      }
                                                  });


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

                                                   mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
                                                       @Override
                                                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                           String pesoa = pesotriceps.getText().toString();
                                                           Map<String, Object> pesoactualizandose = new HashMap<>();
                                                           pesoactualizandose.put("Historial triceps/ 3 dias/ primer ejercicio/ dia 3", pesoa);


                                                           mDatabase.child("Users").child(id).updateChildren(pesoactualizandose);
                                                       }

                                                       @Override
                                                       public void onCancelled(@NonNull DatabaseError error) {

                                                       }
                                                   });


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

                                                   mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
                                                       @Override
                                                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                           String pesoa = pesofrontal.getText().toString();
                                                           Map<String, Object> pesoactualizandose = new HashMap<>();
                                                           pesoactualizandose.put("Historial frontal/ 3 dias/ primer ejercicio/ dia 3", pesoa);


                                                           mDatabase.child("Users").child(id).updateChildren(pesoactualizandose);
                                                       }

                                                       @Override
                                                       public void onCancelled(@NonNull DatabaseError error) {

                                                       }
                                                   });


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

                                                   mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
                                                       @Override
                                                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                           String pesoa = pesolateral.getText().toString();
                                                           Map<String, Object> pesoactualizandose = new HashMap<>();
                                                           pesoactualizandose.put("Historial deltoides laterales y posteriores/ 3 dias/ primer ejercicio/ dia 3", pesoa);


                                                           mDatabase.child("Users").child(id).updateChildren(pesoactualizandose);
                                                       }

                                                       @Override
                                                       public void onCancelled(@NonNull DatabaseError error) {

                                                       }
                                                   });


                                               }
                                           }
        );





        pesocuadriceps.addTextChangedListener(new TextWatcher() {
                                                  @Override
                                                  public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                  }

                                                  @Override
                                                  public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                  }

                                                  @Override
                                                  public void afterTextChanged(Editable editable) {
                                                      SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesocuadriceps.getContext());
                                                      preferences.edit().putString("editText",editable.toString()).commit();

                                                      mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
                                                          @Override
                                                          public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                              String pesoa = pesocuadriceps.getText().toString();
                                                              Map<String, Object> pesoactualizandose = new HashMap<>();
                                                              pesoactualizandose.put("Historial cuadriceps/ 3 dias/ primer ejercicio/ dia 3", pesoa);


                                                              mDatabase.child("Users").child(id).updateChildren(pesoactualizandose);
                                                          }

                                                          @Override
                                                          public void onCancelled(@NonNull DatabaseError error) {

                                                          }
                                                      });


                                                  }
                                              }
        );



        pesofemoral.addTextChangedListener(new TextWatcher() {
                                               @Override
                                               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void afterTextChanged(Editable editable) {
                                                   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesofemoral.getContext());
                                                   preferences.edit().putString("editText",editable.toString()).commit();

                                                   mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
                                                       @Override
                                                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                           String pesoa = pesofemoral.getText().toString();
                                                           Map<String, Object> pesoactualizandose = new HashMap<>();
                                                           pesoactualizandose.put("Historial isquios/ 3 dias/ primer ejercicio/ dia 3", pesoa);


                                                           mDatabase.child("Users").child(id).updateChildren(pesoactualizandose);
                                                       }

                                                       @Override
                                                       public void onCancelled(@NonNull DatabaseError error) {

                                                       }
                                                   });


                                               }
                                           }
        );



        pesogluteos.addTextChangedListener(new TextWatcher() {
                                               @Override
                                               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void afterTextChanged(Editable editable) {
                                                   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesogluteos.getContext());
                                                   preferences.edit().putString("editText",editable.toString()).commit();

                                                   mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
                                                       @Override
                                                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                           String pesoa = pesogluteos.getText().toString();
                                                           Map<String, Object> pesoactualizandose = new HashMap<>();
                                                           pesoactualizandose.put("Historial gluteos y aductores/ 3 dias/ primer ejercicio/ dia 3", pesoa);


                                                           mDatabase.child("Users").child(id).updateChildren(pesoactualizandose);
                                                       }

                                                       @Override
                                                       public void onCancelled(@NonNull DatabaseError error) {

                                                       }
                                                   });


                                               }
                                           }
        );

        pesopantorrillas.addTextChangedListener(new TextWatcher() {
                                                    @Override
                                                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                    }

                                                    @Override
                                                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                    }

                                                    @Override
                                                    public void afterTextChanged(Editable editable) {
                                                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesopantorrillas.getContext());
                                                        preferences.edit().putString("editText",editable.toString()).commit();

                                                        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                                String pesoa = pesopantorrillas.getText().toString();
                                                                Map<String, Object> pesoactualizandose = new HashMap<>();
                                                                pesoactualizandose.put("Historial pantorrillas/ 3 dias/ primer ejercicio/ dia 3", pesoa);


                                                                mDatabase.child("Users").child(id).updateChildren(pesoactualizandose);
                                                            }

                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError error) {

                                                            }
                                                        });


                                                    }
                                                }
        );




        pesofemoral2.addTextChangedListener(new TextWatcher() {
                                                 @Override
                                                 public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                 }

                                                 @Override
                                                 public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                 }

                                                 @Override
                                                 public void afterTextChanged(Editable editable) {
                                                     SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesofemoral2.getContext());
                                                     preferences.edit().putString("editText",editable.toString()).commit();

                                                     mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
                                                         @Override
                                                         public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                             String pesoa = pesofemoral2.getText().toString();
                                                             Map<String, Object> pesoactualizandose = new HashMap<>();
                                                             pesoactualizandose.put("Historial isquios/ 3 dias/ segundo ejercicio/ dia 3", pesoa);


                                                             mDatabase.child("Users").child(id).updateChildren(pesoactualizandose);
                                                         }

                                                         @Override
                                                         public void onCancelled(@NonNull DatabaseError error) {

                                                         }
                                                     });


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

                                                   mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
                                                       @Override
                                                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                           String pesoa = pesoabdomen.getText().toString();
                                                           Map<String, Object> pesoactualizandose = new HashMap<>();
                                                           pesoactualizandose.put("Historial abdomen/ 3 dias/ primer ejercicio/ dia 3", pesoa);


                                                           mDatabase.child("Users").child(id).updateChildren(pesoactualizandose);
                                                       }

                                                       @Override
                                                       public void onCancelled(@NonNull DatabaseError error) {

                                                       }
                                                   });


                                               }
                                           }
        );







        rer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno3dia3mujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno3dia3mujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno3dia3mujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno3dia3mujer.this, rer.class);
                startActivity(intent);
            }
        });


        rer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno3dia3mujer.this, rer.class);
                startActivity(intent);
            }
        });


        rer6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno3dia3mujer.this, rer.class);
                startActivity(intent);
            }
        });


        rer7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno3dia3mujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno3dia3mujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno3dia3mujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno3dia3mujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno3dia3mujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno3dia3mujer.this, rer.class);
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



    public void findelentrenamiento3 (View view){

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
                    mInterstitialAd.show(entreno3dia3mujer.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }

            }
        }, 1000);



        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();
        String datoejercicio1 = peso1.getText().toString();
        String datoejercicio2 = pesoespalda.getText().toString();
        String datoejercicio3 = pesobiceps.getText().toString();
        String datoejercicio4 = pesotriceps.getText().toString();
        String datoejercicio5 = pesofrontal.getText().toString();
        String datoejercicio6 = pesolateral.getText().toString();
        String datoejercicio7 = pesocuadriceps.getText().toString();
        String datoejercicio8 = pesofemoral.getText().toString();
        String datoejercicio9 = pesopantorrillas.getText().toString();
        String datoejercicio10 = pesofemoral2.getText().toString();
        String datoejercicio11 = pesogluteos.getText().toString();
        String datoejercicio12 = pesoabdomen.getText().toString();


        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                Map<String, Object> pesoactualizandose2 = new HashMap<>();
                pesoactualizandose2.put("Historial pectoral/ 3 dias/ primer ejercicio/ dia 3", datoejercicio1);
                pesoactualizandose2.put("Historial espalda/ 3 dias/ primer ejercicio/ dia 3", datoejercicio2);
                pesoactualizandose2.put("Historial biceps/ 3 dias/ primer ejercicio/ dia 3", datoejercicio3);
                pesoactualizandose2.put("Historial triceps/ 3 dias/ primer ejercicio/ dia 3", datoejercicio4);
                pesoactualizandose2.put("Historial frontal/ 3 dias/ primer ejercicio/ dia 3", datoejercicio5);
                pesoactualizandose2.put("Historial deltoides laterales y posteriores/ 3 dias/ primer ejercicio/ dia 3", datoejercicio6);
                pesoactualizandose2.put("Historial cuadriceps/ 3 dias/ primer ejercicio/ dia 3", datoejercicio7);
                pesoactualizandose2.put("Historial isquios/ 3 dias/ primer ejercicio/ dia 3", datoejercicio8);
                pesoactualizandose2.put("Historial pantorrillas/ 3 dias/ primer ejercicio/ dia 3", datoejercicio9);
                pesoactualizandose2.put("Historial isquios/ 3 dias/ segundo ejercicio/ dia 3", datoejercicio10);
                pesoactualizandose2.put("Historial gluteos y aductores/ 3 dias/ primer ejercicio/ dia 3", datoejercicio11);
                pesoactualizandose2.put("Historial abdomen/ 3 dias/ primer ejercicio/ dia 3", datoejercicio12);

                mDatabase.child("Users").child(id).updateChildren(pesoactualizandose2);

                //si se modifica el datachange en algun otro momento envia a esta pantalla, por lo cual se condiciona el envio
                boolean botonpresionado = true;

                if (botonpresionado == true){

                    Intent findelentrenamiento = new Intent(entreno3dia3mujer.this, entrenamientofinalizado.class);
                    String valor2 = getIntent().getExtras().getString("actual");
                    findelentrenamiento.putExtra("actual", valor2);
                    findelentrenamiento.putExtra("entreno?dia3", "sidia3");
                    startActivity(findelentrenamiento);
                    finish();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void ejercicioentreno3dia3 (View view){

        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("pectoral/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno3dia3mujer.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void ejercicio2entreno3dia3(View view) {
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("espalda/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno3dia3mujer.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void ejercicio3entreno3dia3(View view) {
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("biceps/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno3dia3mujer.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void ejercicio4entreno3dia3(View view) {
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("triceps/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno3dia3mujer.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void ejercicio5entreno3dia3(View view) {
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("deltoide frontal/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno3dia3mujer.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void ejercicio6entreno3dia3(View view) {
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno3dia3mujer.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void ejercicio7entreno3dia3(View view) {
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("cuadriceps/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno3dia3mujer.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void ejercicio8entreno3dia3(View view) {
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("isquios/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno3dia3mujer.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void ejercicio9entreno3dia3(View view) {
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("gluteos y aductores/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno3dia3mujer.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void ejercicio10entreno3dia3(View view) {
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("pantorrillas/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno3dia3mujer.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void ejercicio11entreno3dia3(View view) {
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("isquios/ ejercicio cuarto").getValue().toString();
                Intent ejercicio = new Intent(entreno3dia3mujer.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void ejercicio12entreno3dia3(View view) {
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("abdominales/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno3dia3mujer.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

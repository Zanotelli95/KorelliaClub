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

public class entreno5diamiercolesmujer extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private EditText  pesoabdomen2,pesocuadriceps, pesofemoral, pesogluteos,
            pesopantorrillas, pesoabdomen, pesocuadriceps2, pesofemora2, pesogluteos2, pesopantorrillas2;
    private String ejercicioseleccionadocuadriceps,ejercicioseleccionadofemoral;
    private TextView rer1, rer2,  rer5, rer15, rer16, rer6,rer9, rer10, rer11, rer12, rer13, rer14;
    private String  ejercicioseleccionadofemoral2, ejercicioseleccionadogluteos2, ejercicioseleccionadopantorrillas2, ejercicioseleccionadopantorrillas, ejercicioseleccionadoabdomen;
    private TextView fechacompleta;
    private TextView seriescuadriceps, seriesfemoral, seriespantorrillas, seriesgluteos, seriesabdomen;
    private Spinner spinner1, spinner2, spinner15, spinner16, spinner5, spinner6, spinner9, spinner10, spinner11, spinner12, spinner13, spinner14;
    private  TextView  ejerciciocuadriceps, repeticionescuadriceps, ejerciciofemoral, repeticionesfemoral, ejerciciogluteos, repeticionesgluteos,
            ejerciciopantorrillas, ejercicioabdomen;
    private ImageView  imagencuadriceps, imagenabdomen, imagenabdomen2, imagencuadriceps2,
            imagenfemoral, imagengluteos, imagenpantorrillas, imagengluteos2, imagenpantorrillas2;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private EditText pesogluteos3, pesopantorrillas3;
    private TextView  repeticionesabdomen, repeticionesabdomen2, seriesabdomen2;
    private ImageView imagenfemoral2, imagengluteos3, imagenpantorrillas3;
    private TextView  ejerciciocuadriceps2,  ejerciciofemoral2,  ejerciciogluteos2, ejerciciogluteos3, ejerciciopantorrillas2, ejerciciopantorrillas3,seriescuadriceps2,
            seriesfemoral2, seriesgluteos2, seriesgluteos3, seriespantorrillas2, seriespantorrillas3,
            repeticionescuadriceps2,  repeticionesfemoral2,  repeticionesgluteos2, repeticionesgluteos3, repeticionespantorrillas, repeticionespantorrillas2, repeticionespantorrillas3;
    private String  ejercicioseleccionadoabdomen2;
    private TextView  ejercicioabdomen2;
    private String ejercicioseleccionadocuadriceps2, ejercicioseleccionadogluteos3;
    private String ejercicioseleccionadogluteo;
    private String ejercicioseleccionadopantorrillas3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_entreno5diamiercolesmujer);

        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this,"ca-app-pub-7204318393811470/3163516125", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
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



        fechacompleta = (TextView) findViewById(R.id.textView27717);
        Date date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("d MMM yyyy");
        String sfecha = fecha.format(date);
        fechacompleta.setText(sfecha);


        Toolbar toolbar = findViewById(R.id.toolbarentreno5diamiercolesmujer);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Entrenamiento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinner1 = (Spinner) findViewById(R.id.spinner1e17);
        spinner2 = (Spinner) findViewById(R.id.spinner2e17);


        spinner5 = (Spinner) findViewById(R.id.spinner5e17);
        spinner6 = (Spinner) findViewById(R.id.spinner6e17);


        spinner9 = (Spinner) findViewById(R.id.spinner9e17);
        spinner10 = (Spinner) findViewById(R.id.spinner10e17);
        spinner11 = (Spinner) findViewById(R.id.spinner11e17);

        spinner12 = (Spinner) findViewById(R.id.spinner12e17);
        spinner13 = (Spinner) findViewById(R.id.spinner13e17);
        spinner14 = (Spinner) findViewById(R.id.spinner14e17);

        spinner15= (Spinner) findViewById(R.id.spinner13abs337);
        spinner16= (Spinner) findViewById(R.id.spinner142abs337);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner1.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner2.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner5.setAdapter(adapter5);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner6.setAdapter(adapter6);


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
        ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner15.setAdapter(adapter15);
        ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(this, R.array.combo_intensidad,
                R.layout.spinner_item_korellia);
        spinner16.setAdapter(adapter16);


        rer1 = findViewById(R.id.rer1quadsentreno5diamiercoles17);
        rer2 = findViewById(R.id.rer2quadsentreno5diamiercoles17);


        rer5 = findViewById(R.id.rer1isquiosentreno5diamiercoles17);
        rer6 = findViewById(R.id.rer2isquiosentreno5diamiercoles17);


        rer9 = findViewById(R.id.rer1gluteosentreno5diamiercoles17);
        rer10 = findViewById(R.id.rer2gluteosentreno5diamiercoles17);
        rer11 = findViewById(R.id.rer3gluteosentreno5diamiercoles17);

        rer12 = findViewById(R.id.rer1pantorrillasentreno5diamiercoles17);
        rer13 = findViewById(R.id.rer2pantorrillasentreno5diamiercoles17);
        rer14 = findViewById(R.id.rer3pantorrillasentreno5diamiercoles17);

        rer15 = findViewById(R.id.buttonrer13abs337);
        rer16 = findViewById(R.id.buttonrer14a2abs337);




        //cuadriceps 4
        ejerciciocuadriceps = (TextView) findViewById(R.id.nombrequadsentreno5diamiercoles17);
        repeticionescuadriceps = (TextView) findViewById(R.id.repes1quadsentreno5diamiercoles17);
        imagencuadriceps = (ImageView) findViewById(R.id.imagen1quadsentreno5diamiercoles17);
        pesocuadriceps = (EditText) findViewById(R.id.peso1quadsentreno5diamiercoles17);
        seriescuadriceps = (TextView) findViewById(R.id.series1quadsentreno5diamiercoles17);

        ejerciciocuadriceps2 = (TextView) findViewById(R.id.nombre2quadsentreno5diamiercoles17);
        repeticionescuadriceps2 = (TextView) findViewById(R.id.repes2quadsentreno5diamiercoles17);
        imagencuadriceps2 = (ImageView) findViewById(R.id.imagen2quadsentreno5diamiercoles17);
        pesocuadriceps2 = (EditText) findViewById(R.id.peso2quadsentreno5diamiercoles17);
        seriescuadriceps2 = (TextView) findViewById(R.id.series2quadsentreno5diamiercoles17);


        //isquios 4
        ejerciciofemoral = (TextView) findViewById(R.id.nombre1isquiosentreno5diamiercoles17);
        repeticionesfemoral = (TextView) findViewById(R.id.repes1isquiosentreno5diamiercoles17);
        imagenfemoral = (ImageView) findViewById(R.id.image1isquiosentreno5diamiercoles17);
        pesofemoral = (EditText) findViewById(R.id.peso1isquiosentreno5diamiercoles17);
        seriesfemoral = (TextView) findViewById(R.id.series1isquiosentreno5diamiercoles17);

        ejerciciofemoral2 = (TextView) findViewById(R.id.nombre2isquiosentreno5diamiercoles17);
        repeticionesfemoral2 = (TextView) findViewById(R.id.repes2isquiosentreno5diamiercoles17);
        imagenfemoral2 = (ImageView) findViewById(R.id.image2isquiosentreno5diamiercoles17);
        pesofemora2 = (EditText) findViewById(R.id.peso2isquiosentreno5diamiercoles17);
        seriesfemoral2 = (TextView) findViewById(R.id.series2isquiosentreno5diamiercoles17);



        //gluteos y aductores 3
        ejerciciogluteos = (TextView) findViewById(R.id.nombre1gluteosentreno5diamiercoles17);
        repeticionesgluteos = (TextView) findViewById(R.id.repes1gluteosentreno5diamiercoles17);
        imagengluteos = (ImageView) findViewById(R.id.imagen1gluteosentreno5diamiercoles17);
        pesogluteos = (EditText) findViewById(R.id.peso1gluteosentreno5diamiercoles17);
        seriesgluteos = (TextView) findViewById(R.id.series1gluteosentreno5diamiercoles17);

        ejerciciogluteos2 = (TextView) findViewById(R.id.nombre2gluteosentreno5diamiercoles17);
        repeticionesgluteos2 = (TextView) findViewById(R.id.repes2gluteosentreno5diamiercoles17);
        imagengluteos2 = (ImageView) findViewById(R.id.imagen2gluteosentreno5diamiercoles17);
        pesogluteos2 = (EditText) findViewById(R.id.peso2gluteosentreno5diamiercoles17);
        seriesgluteos2 = (TextView) findViewById(R.id.series2gluteosentreno5diamiercoles17);

        ejerciciogluteos3 = (TextView) findViewById(R.id.nombre3gluteosentreno5diamiercoles17);
        repeticionesgluteos3 = (TextView) findViewById(R.id.repes3gluteosentreno5diamiercoles17);
        imagengluteos3 = (ImageView) findViewById(R.id.imagen3gluteosentreno5diamiercoles17);
        pesogluteos3 = (EditText) findViewById(R.id.peso3gluteosentreno5diamiercoles17);
        seriesgluteos3 = (TextView) findViewById(R.id.series3gluteosentreno5diamiercoles17);


        //pantorrillas 3
        ejerciciopantorrillas = (TextView) findViewById(R.id.nombre1pantorrillasentreno5diamiercoles17);
        repeticionespantorrillas = (TextView) findViewById(R.id.repes1pantorrillasentreno5diamiercoles17);
        imagenpantorrillas = (ImageView) findViewById(R.id.imagen1pantorrillasentreno5diamiercoles17);
        pesopantorrillas = (EditText) findViewById(R.id.peso1pantorrillasentreno5diamiercoles17);
        seriespantorrillas = (TextView) findViewById(R.id.series1pantorrillasentreno5diamiercoles17);

        ejerciciopantorrillas2 = (TextView) findViewById(R.id.nombre2pantorrillasentreno5diamiercoles17);
        repeticionespantorrillas2 = (TextView) findViewById(R.id.repes2pantorrillasentreno5diamiercoles17);
        imagenpantorrillas2 = (ImageView) findViewById(R.id.imagen2pantorrillasentreno5diamiercoles17);
        pesopantorrillas2 = (EditText) findViewById(R.id.peso2pantorrillasentreno5diamiercoles17);
        seriespantorrillas2 = (TextView) findViewById(R.id.series2pantorrillasentreno5diamiercoles17);

        ejerciciopantorrillas3 = (TextView) findViewById(R.id.nombre3pantorrillasentreno5diamiercoles17);
        repeticionespantorrillas3 = (TextView) findViewById(R.id.repes3pantorrillasentreno5diamiercoles17);
        imagenpantorrillas3 = (ImageView) findViewById(R.id.imagen3pantorrillasentreno5diamiercoles17);
        pesopantorrillas3 = (EditText) findViewById(R.id.peso3pantorrillasentreno5diamiercoles17);
        seriespantorrillas3 = (TextView) findViewById(R.id.series3pantorrillasentreno5diamiercoles17);


        //abdomen 3

        ejercicioabdomen = (TextView) findViewById(R.id.textView219abs337);
        repeticionesabdomen = (TextView) findViewById(R.id.textView221abs337);
        imagenabdomen = (ImageView) findViewById(R.id.imageView11abs337);
        pesoabdomen = (EditText) findViewById(R.id.textView222abs337);
        seriesabdomen = (TextView) findViewById(R.id.textView220abs337);


        ejercicioabdomen2 = (TextView) findViewById(R.id.textView2192abs337);
        repeticionesabdomen2 = (TextView) findViewById(R.id.textView2212abs337);
        imagenabdomen2 = (ImageView) findViewById(R.id.imageView112abs337);
        pesoabdomen2 = (EditText) findViewById(R.id.textView2222abs337);
        seriesabdomen2 = (TextView) findViewById(R.id.textView2202abs337);



        mAuth = FirebaseAuth.getInstance();

        //logicadelentrenamiento(ejercicios)





        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();



        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                if (datasnapshot.exists()) {

                    String ejercicio = datasnapshot.child("cuadriceps/ ejercicio primario").getValue().toString();
                    ejerciciocuadriceps.setText(ejercicio);
                    ejercicioseleccionadocuadriceps = ejercicio;

                    String ejercicio2 = datasnapshot.child("cuadriceps/ ejercicio secundario").getValue().toString();
                    ejerciciocuadriceps2.setText(ejercicio2);
                    ejercicioseleccionadocuadriceps2 = ejercicio2;





                    String stringejerciciotriceps = datasnapshot.child("isquios/ ejercicio primario").getValue().toString();
                    ejerciciofemoral.setText(stringejerciciotriceps);
                    ejercicioseleccionadofemoral = stringejerciciotriceps;

                    String stringejerciciofemoral3 = datasnapshot.child("isquios/ ejercicio secundario").getValue().toString();
                    ejerciciofemoral2.setText(stringejerciciofemoral3);
                    ejercicioseleccionadofemoral2 = stringejerciciofemoral3;





                    String stringejerciciotricepsf = datasnapshot.child("gluteos y aductores/ ejercicio primario").getValue().toString();
                    ejerciciogluteos.setText(stringejerciciotricepsf);
                    ejercicioseleccionadogluteo = stringejerciciotricepsf;

                    String stringejerciciotriceps2 = datasnapshot.child("gluteos y aductores/ ejercicio secundario").getValue().toString();
                    ejerciciogluteos2.setText(stringejerciciotriceps2);
                    ejercicioseleccionadogluteos2 = stringejerciciotriceps2;

                    String stringejerciciofrontal = datasnapshot.child("gluteos y aductores/ ejercicio tercero").getValue().toString();
                    ejerciciogluteos3.setText(stringejerciciofrontal);
                    ejercicioseleccionadogluteos3 = stringejerciciofrontal;



                    String stringejerciciofrontal2 = datasnapshot.child("pantorrillas/ ejercicio primario").getValue().toString();
                    ejerciciopantorrillas.setText(stringejerciciofrontal2);
                    ejercicioseleccionadopantorrillas = stringejerciciofrontal2;

                    String stringejerciciotraps = datasnapshot.child("pantorrillas/ ejercicio secundario").getValue().toString();
                    ejerciciopantorrillas2.setText(stringejerciciotraps);
                    ejercicioseleccionadopantorrillas2 = stringejerciciotraps;

                    String stringejerciciotraps2 = datasnapshot.child("pantorrillas/ ejercicio tercero").getValue().toString();
                    ejerciciopantorrillas3.setText(stringejerciciotraps2);
                    ejercicioseleccionadopantorrillas3 = stringejerciciotraps2;



                    String stringejercicioabs = datasnapshot.child("abdominales/ ejercicio primario").getValue().toString();
                    ejercicioabdomen.setText(stringejercicioabs);
                    ejercicioseleccionadoabdomen = stringejercicioabs;

                    String stringejercicioabs2 = datasnapshot.child("abdominales/ ejercicio secundario").getValue().toString();
                    ejercicioabdomen2.setText(stringejercicioabs2);
                    ejercicioseleccionadoabdomen2 = stringejercicioabs2;


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

                if ( ejercicioseleccionadocuadriceps.equals("Prensa a 45??")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115038.jpg?alt=media&token=f8264fd9-f7e9-440b-8557-00aac5fec37d")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionadocuadriceps.equals("Prensa horizontal en m??quina")) {
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

                if ( ejercicioseleccionadocuadriceps.equals("Sentadilla en m??quina perfecta")) {
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
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%2FIMG_0347.jpg?alt=media&token=257a95fe-9f3d-45e5-af92-eafb7c7a87ee")
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

                if ( ejercicioseleccionadocuadriceps.equals("Sentadilla smith a 90??")) {
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

                if ( ejercicioseleccionadocuadriceps.equals("Extensiones de cuadriceps en m??quina")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111311.jpg?alt=media&token=fbafd51a-6f5b-48a2-a252-40a61c84f09d")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                //cuadriceps
                if ( ejercicioseleccionadocuadriceps2.equals("Desplantes con mancuernas")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fdesplantes%20con%20mancuernas%2F20210131_112942.jpg?alt=media&token=2b6b25b6-e5c6-4057-be69-bd2cad0c2af6")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionadocuadriceps2.equals("Prensa a 1 pierna")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112525.jpg?alt=media&token=9288507d-1f03-4147-b0d4-b89d491dbc60")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionadocuadriceps2.equals("Prensa a 45??")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115038.jpg?alt=media&token=f8264fd9-f7e9-440b-8557-00aac5fec37d")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionadocuadriceps2.equals("Prensa horizontal en m??quina")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20horizontal%20en%20maquina%2F20210202_115706.jpg?alt=media&token=71099f4e-277a-44f4-9d54-9b86509400a7")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionadocuadriceps2.equals("Sentadilla con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20con%20barra%2F20210206_111054.jpg?alt=media&token=7bb9cf31-7d1f-46b9-aef2-3f92d0d662aa")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionadocuadriceps2.equals("Sentadilla en m??quina perfecta")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20en%20maquina%20perfecta%2F20210204_120342.jpg?alt=media&token=30659f89-9cf0-4183-97f8-1022479b30ab")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionadocuadriceps2.equals("Sentadilla frontal con mancuernas")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113031.jpg?alt=media&token=b7055a35-bb96-4797-a082-7fb395bbfee3")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionadocuadriceps2.equals("Sentadilla")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionadocuadriceps2.equals("Sentadilla frontal con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%2FIMG_0347.jpg?alt=media&token=257a95fe-9f3d-45e5-af92-eafb7c7a87ee")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionadocuadriceps2.equals("Sentadilla frontal en smith")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20en%20smith%2F20211211_135602.jpg?alt=media&token=e1b0c3c9-2b6e-446a-9f05-d0651ba1da89")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionadocuadriceps2.equals("Sentadilla smith profunda")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135922.jpg?alt=media&token=ddd7e42b-797b-4103-a384-0b9208546141")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionadocuadriceps2.equals("Sentadilla smith a 90??")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20a%2090%20grados%20en%20smith%2FIMG_0338.jpg?alt=media&token=5a256969-7282-4b20-a9f4-e6801d322f68")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionadocuadriceps2.equals("Sentadilla bulgara con mancuernas")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112831.jpg?alt=media&token=273285a7-7376-4960-a28b-252e1ae4236a")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionadocuadriceps2.equals("Extensiones de cuadriceps en m??quina")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111311.jpg?alt=media&token=fbafd51a-6f5b-48a2-a252-40a61c84f09d")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
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

                if ( ejercicioseleccionadofemoral.equals("Curl femoral parado a 1 pierna en m??quina")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122852.jpg?alt=media&token=59d7e392-1aad-4c52-a71d-faf7a1224d05")
                            .fit().centerCrop()
                            .into(imagenfemoral);
                }

                if ( ejercicioseleccionadofemoral.equals("Curl femoral acostado en m??quina")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20acostado%20en%20maquina%2F20210202_121632.jpg?alt=media&token=7cb5375f-ee3c-4a14-bf57-ed8aa27dbcf3")
                            .fit().centerCrop()
                            .into(imagenfemoral);
                }

                if ( ejercicioseleccionadofemoral.equals("Curl femoral sentado en m??quina")) {
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

                if ( ejercicioseleccionadofemoral.equals("Curl femoral acostado en m??quina a 1 pierna")) {
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


                if ( ejercicioseleccionadofemoral.equals("Elevaci??n de cadera a una pierna")) {
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

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral parado a 1 pierna en m??quina")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122852.jpg?alt=media&token=59d7e392-1aad-4c52-a71d-faf7a1224d05")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral acostado en m??quina")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20acostado%20en%20maquina%2F20210202_121632.jpg?alt=media&token=7cb5375f-ee3c-4a14-bf57-ed8aa27dbcf3")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral sentado en m??quina")) {
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

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral acostado en m??quina a 1 pierna")) {
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


                if ( ejercicioseleccionadofemoral2.equals("Elevaci??n de cadera a una pierna")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Felevaci%C3%B3n%20de%20cadera%20a%201%20pierna%2F20211211_135110.jpg?alt=media&token=acbc4c3f-9615-440c-bdff-28ebfc54a1ae")
                            .fit().centerCrop()
                            .into(imagenfemoral2);
                }





                //gluteos
                if ( ejercicioseleccionadogluteo.equals("Aducciones de cadera en polea")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111641.jpg?alt=media&token=2c6c6ec6-806a-4bca-ae11-f4284d740751")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteo.equals("Aducciones de cadera en m??quina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20en%20maquina%2F20210224_120014.jpg?alt=media&token=10f79db9-a51a-4c7f-b345-bbf315bd89f4")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteo.equals("Goblet squat")) {
                    int reps = 10;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgoblet%20squat%2F20211210_111428.jpg?alt=media&token=a8cb7d1d-d535-4868-b03b-f443a1e70a87")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteo.equals("Hip thrust con barra")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fhip%20thrust%20con%20barra%2F20210210_112151.jpg?alt=media&token=4ee62dc4-1073-448a-a1f2-64ed8e0eccd0")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteo.equals("Patada para gl??teo con mancuerna")) {
                    int reps = 10;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20mancuerna%2F20210210_113919.jpg?alt=media&token=9ecbd1ff-9b5e-4314-9d18-6e5ef6297ba9")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteo.equals("Abducciones de cadera en polea")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111641.jpg?alt=media&token=2c6c6ec6-806a-4bca-ae11-f4284d740751")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }


                if ( ejercicioseleccionadogluteo.equals("Abducciones de cadera en m??quina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20en%20maquina%2F20210204_115306.jpg?alt=media&token=f072eb5e-d411-4ef7-9e8b-d23cfbd0a990")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteo.equals("Patada para gl??teo con polea")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20polea%2F20210308_125722.jpg?alt=media&token=ba18cfd3-bc40-4919-b59d-7868d8b95f1c")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteo.equals("Patada para gl??teos con m??quina de pie")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%20de%20pie%2F20210202_123925.jpg?alt=media&token=09e3e5ff-2478-4f3d-aa0c-c210a296761b")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteo.equals("Patada para gl??teos en m??quina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%2F20210131_111648.jpg?alt=media&token=e014fed1-f7cd-49f9-b683-3a5620b0b029")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteo.equals("Peso muerto tipo sumo con barra")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20barra%2F20210210_112935.jpg?alt=media&token=b2d84e57-45a6-4bf5-8a8b-8d671513cd8f")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteo.equals("Peso muerto tipo sumo con mancuerna")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20mancuerna%2F20210131_113330.jpg?alt=media&token=f79ca688-ba30-4d65-a328-ee456f27013e")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteo.equals("Puente a 1 pierna")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20a%201%20pierna%2F20210131_113159.jpg?alt=media&token=bcabdcb0-892f-4e4a-bc08-7f696e3fce95")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteo.equals("Puente con mancuerna")) {
                    int reps = 10;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20con%20mancuerna%2F20210131_113131.jpg?alt=media&token=5207ad4d-8bbc-4d2a-9ca6-6abdfdfd013f")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteo.equals("Sentadilla smith tipo sumo")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fsentadilla%20Smith%20tipo%20sumo%2F20210310_114633.jpg?alt=media&token=50fb2cd4-d99a-4852-b0d6-1e379903c736")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }




                //gluteos
                if (  ejercicioseleccionadogluteos2.equals("Aducciones de cadera en polea")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111641.jpg?alt=media&token=2c6c6ec6-806a-4bca-ae11-f4284d740751")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Aducciones de cadera en m??quina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20en%20maquina%2F20210224_120014.jpg?alt=media&token=10f79db9-a51a-4c7f-b345-bbf315bd89f4")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Goblet squat")) {
                    int reps = 10;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgoblet%20squat%2F20211210_111428.jpg?alt=media&token=a8cb7d1d-d535-4868-b03b-f443a1e70a87")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Hip thrust con barra")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fhip%20thrust%20con%20barra%2F20210210_112151.jpg?alt=media&token=4ee62dc4-1073-448a-a1f2-64ed8e0eccd0")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Patada para gl??teo con mancuerna")) {
                    int reps = 10;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20mancuerna%2F20210210_113919.jpg?alt=media&token=9ecbd1ff-9b5e-4314-9d18-6e5ef6297ba9")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Abducciones de cadera en polea")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111641.jpg?alt=media&token=2c6c6ec6-806a-4bca-ae11-f4284d740751")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }


                if ( ejercicioseleccionadogluteos2.equals("Abducciones de cadera en m??quina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20en%20maquina%2F20210204_115306.jpg?alt=media&token=f072eb5e-d411-4ef7-9e8b-d23cfbd0a990")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Patada para gl??teo con polea")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20polea%2F20210308_125722.jpg?alt=media&token=ba18cfd3-bc40-4919-b59d-7868d8b95f1c")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Patada para gl??teos con m??quina de pie")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%20de%20pie%2F20210202_123925.jpg?alt=media&token=09e3e5ff-2478-4f3d-aa0c-c210a296761b")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Patada para gl??teos en m??quina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%2F20210131_111648.jpg?alt=media&token=e014fed1-f7cd-49f9-b683-3a5620b0b029")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Peso muerto tipo sumo con barra")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20barra%2F20210210_112935.jpg?alt=media&token=b2d84e57-45a6-4bf5-8a8b-8d671513cd8f")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Peso muerto tipo sumo con mancuerna")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20mancuerna%2F20210131_113330.jpg?alt=media&token=f79ca688-ba30-4d65-a328-ee456f27013e")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Puente a 1 pierna")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20a%201%20pierna%2F20210131_113159.jpg?alt=media&token=bcabdcb0-892f-4e4a-bc08-7f696e3fce95")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Puente con mancuerna")) {
                    int reps = 10;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20con%20mancuerna%2F20210131_113131.jpg?alt=media&token=5207ad4d-8bbc-4d2a-9ca6-6abdfdfd013f")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Sentadilla smith tipo sumo")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fsentadilla%20Smith%20tipo%20sumo%2F20210310_114633.jpg?alt=media&token=50fb2cd4-d99a-4852-b0d6-1e379903c736")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }





                //gluteos
                if (  ejercicioseleccionadogluteos3.equals("Aducciones de cadera en polea")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos3.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111641.jpg?alt=media&token=2c6c6ec6-806a-4bca-ae11-f4284d740751")
                            .fit().centerCrop()
                            .into(imagengluteos3);
                }

                if ( ejercicioseleccionadogluteos3.equals("Aducciones de cadera en m??quina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos3.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20en%20maquina%2F20210224_120014.jpg?alt=media&token=10f79db9-a51a-4c7f-b345-bbf315bd89f4")
                            .fit().centerCrop()
                            .into(imagengluteos3);
                }

                if ( ejercicioseleccionadogluteos3.equals("Goblet squat")) {
                    int reps = 10;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos3.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgoblet%20squat%2F20211210_111428.jpg?alt=media&token=a8cb7d1d-d535-4868-b03b-f443a1e70a87")
                            .fit().centerCrop()
                            .into(imagengluteos3);
                }

                if ( ejercicioseleccionadogluteos3.equals("Hip thrust con barra")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos3.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fhip%20thrust%20con%20barra%2F20210210_112151.jpg?alt=media&token=4ee62dc4-1073-448a-a1f2-64ed8e0eccd0")
                            .fit().centerCrop()
                            .into(imagengluteos3);
                }

                if ( ejercicioseleccionadogluteos3.equals("Patada para gl??teo con mancuerna")) {
                    int reps = 10;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos3.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20mancuerna%2F20210210_113919.jpg?alt=media&token=9ecbd1ff-9b5e-4314-9d18-6e5ef6297ba9")
                            .fit().centerCrop()
                            .into(imagengluteos3);
                }

                if ( ejercicioseleccionadogluteos3.equals("Abducciones de cadera en polea")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos3.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111641.jpg?alt=media&token=2c6c6ec6-806a-4bca-ae11-f4284d740751")
                            .fit().centerCrop()
                            .into(imagengluteos3);
                }


                if ( ejercicioseleccionadogluteos3.equals("Abducciones de cadera en m??quina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos3.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20en%20maquina%2F20210204_115306.jpg?alt=media&token=f072eb5e-d411-4ef7-9e8b-d23cfbd0a990")
                            .fit().centerCrop()
                            .into(imagengluteos3);
                }

                if ( ejercicioseleccionadogluteos3.equals("Patada para gl??teo con polea")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos3.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20polea%2F20210308_125722.jpg?alt=media&token=ba18cfd3-bc40-4919-b59d-7868d8b95f1c")
                            .fit().centerCrop()
                            .into(imagengluteos3);
                }

                if ( ejercicioseleccionadogluteos3.equals("Patada para gl??teos con m??quina de pie")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos3.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%20de%20pie%2F20210202_123925.jpg?alt=media&token=09e3e5ff-2478-4f3d-aa0c-c210a296761b")
                            .fit().centerCrop()
                            .into(imagengluteos3);
                }

                if ( ejercicioseleccionadogluteos3.equals("Patada para gl??teos en m??quina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos3.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%2F20210131_111648.jpg?alt=media&token=e014fed1-f7cd-49f9-b683-3a5620b0b029")
                            .fit().centerCrop()
                            .into(imagengluteos3);
                }

                if ( ejercicioseleccionadogluteos3.equals("Peso muerto tipo sumo con barra")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos3.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20barra%2F20210210_112935.jpg?alt=media&token=b2d84e57-45a6-4bf5-8a8b-8d671513cd8f")
                            .fit().centerCrop()
                            .into(imagengluteos3);
                }

                if ( ejercicioseleccionadogluteos3.equals("Peso muerto tipo sumo con mancuerna")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos3.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20mancuerna%2F20210131_113330.jpg?alt=media&token=f79ca688-ba30-4d65-a328-ee456f27013e")
                            .fit().centerCrop()
                            .into(imagengluteos3);
                }

                if ( ejercicioseleccionadogluteos3.equals("Puente a 1 pierna")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos3.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20a%201%20pierna%2F20210131_113159.jpg?alt=media&token=bcabdcb0-892f-4e4a-bc08-7f696e3fce95")
                            .fit().centerCrop()
                            .into(imagengluteos3);
                }

                if ( ejercicioseleccionadogluteos3.equals("Puente con mancuerna")) {
                    int reps = 10;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos3.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20con%20mancuerna%2F20210131_113131.jpg?alt=media&token=5207ad4d-8bbc-4d2a-9ca6-6abdfdfd013f")
                            .fit().centerCrop()
                            .into(imagengluteos3);
                }

                if ( ejercicioseleccionadogluteos3.equals("Sentadilla smith tipo sumo")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos3.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fsentadilla%20Smith%20tipo%20sumo%2F20210310_114633.jpg?alt=media&token=50fb2cd4-d99a-4852-b0d6-1e379903c736")
                            .fit().centerCrop()
                            .into(imagengluteos3);
                }



                //pantorrillas
                if ( ejercicioseleccionadopantorrillas.equals("Elevaciones de tal??n en costurera")) {
                    int reps = 15;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20costurera%2F20210220_123439.jpg?alt=media&token=cd5d5a75-3dfc-46ce-8b24-1b366faa38ee")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }

                if ( ejercicioseleccionadopantorrillas.equals("Elevaciones de tal??n en prensa a 1 pierna")) {
                    int reps = 10;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20a%201%20pierna%2F20210215_130011.jpg?alt=media&token=d3f4cafe-26f6-4cd2-a862-d02e29ff75ba")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }

                if ( ejercicioseleccionadopantorrillas.equals("Elevaci??n de tal??n parado con mancuernas")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20parado%20con%20mancuerna%2F20210310_120558.jpg?alt=media&token=3d5edaad-c045-4256-aea7-34d967faef76")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }

                if ( ejercicioseleccionadopantorrillas.equals("Elevaci??n de tal??n parado en m??quina")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20sentadilla%20perfecta%2F20211215_113308.jpg?alt=media&token=8ebb1b76-9791-414a-8965-b6504b4b2d7b")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }

                if ( ejercicioseleccionadopantorrillas.equals("Elevaci??n de tal??n en prensa 45??")) {
                    int reps = 8;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaci%C3%B3n%20de%20tal%C3%B3n%20en%20prensa%2045%C2%B0%2FIMG_0369.jpg?alt=media&token=1f2c4ccf-7cf9-4dd2-bd92-7bab13bc3539")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }

                if ( ejercicioseleccionadopantorrillas.equals("Elevaci??n de tal??n en prensa horizontal")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20horizontal%2F20211215_111104.jpg?alt=media&token=65f55792-18ee-4e71-bfd3-68788892af40")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }



                //pantorrillas
                if ( ejercicioseleccionadopantorrillas2.equals("Elevaciones de tal??n en costurera")) {
                    int reps = 15;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas2.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20costurera%2F20210220_123439.jpg?alt=media&token=cd5d5a75-3dfc-46ce-8b24-1b366faa38ee")
                            .fit().centerCrop()
                            .into(imagenpantorrillas2);
                }

                if ( ejercicioseleccionadopantorrillas2.equals("Elevaciones de tal??n en prensa a 1 pierna")) {
                    int reps = 10;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas2.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20a%201%20pierna%2F20210215_130011.jpg?alt=media&token=d3f4cafe-26f6-4cd2-a862-d02e29ff75ba")
                            .fit().centerCrop()
                            .into(imagenpantorrillas2);
                }

                if ( ejercicioseleccionadopantorrillas2.equals("Elevaci??n de tal??n parado con mancuernas")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas2.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20parado%20con%20mancuerna%2F20210310_120558.jpg?alt=media&token=3d5edaad-c045-4256-aea7-34d967faef76")
                            .fit().centerCrop()
                            .into(imagenpantorrillas2);
                }

                if ( ejercicioseleccionadopantorrillas2.equals("Elevaci??n de tal??n parado en m??quina")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas2.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20sentadilla%20perfecta%2F20211215_113308.jpg?alt=media&token=8ebb1b76-9791-414a-8965-b6504b4b2d7b")
                            .fit().centerCrop()
                            .into(imagenpantorrillas2);
                }

                if ( ejercicioseleccionadopantorrillas2.equals("Elevaci??n de tal??n en prensa 45??")) {
                    int reps = 8;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas2.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaci%C3%B3n%20de%20tal%C3%B3n%20en%20prensa%2045%C2%B0%2FIMG_0369.jpg?alt=media&token=1f2c4ccf-7cf9-4dd2-bd92-7bab13bc3539")
                            .fit().centerCrop()
                            .into(imagenpantorrillas2);
                }

                if ( ejercicioseleccionadopantorrillas2.equals("Elevaci??n de tal??n en prensa horizontal")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas2.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20horizontal%2F20211215_111104.jpg?alt=media&token=65f55792-18ee-4e71-bfd3-68788892af40")
                            .fit().centerCrop()
                            .into(imagenpantorrillas2);
                }

//pantorrillas
                if ( ejercicioseleccionadopantorrillas3.equals("Elevaciones de tal??n en costurera")) {
                    int reps = 15;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas3.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20costurera%2F20210220_123439.jpg?alt=media&token=cd5d5a75-3dfc-46ce-8b24-1b366faa38ee")
                            .fit().centerCrop()
                            .into(imagenpantorrillas3);
                }

                if ( ejercicioseleccionadopantorrillas3.equals("Elevaciones de tal??n en prensa a 1 pierna")) {
                    int reps = 10;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas3.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20a%201%20pierna%2F20210215_130011.jpg?alt=media&token=d3f4cafe-26f6-4cd2-a862-d02e29ff75ba")
                            .fit().centerCrop()
                            .into(imagenpantorrillas3);
                }

                if ( ejercicioseleccionadopantorrillas3.equals("Elevaci??n de tal??n parado con mancuernas")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas3.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20parado%20con%20mancuerna%2F20210310_120558.jpg?alt=media&token=3d5edaad-c045-4256-aea7-34d967faef76")
                            .fit().centerCrop()
                            .into(imagenpantorrillas3);
                }

                if ( ejercicioseleccionadopantorrillas3.equals("Elevaci??n de tal??n parado en m??quina")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas3.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20sentadilla%20perfecta%2F20211215_113308.jpg?alt=media&token=8ebb1b76-9791-414a-8965-b6504b4b2d7b")
                            .fit().centerCrop()
                            .into(imagenpantorrillas3);
                }

                if ( ejercicioseleccionadopantorrillas3.equals("Elevaci??n de tal??n en prensa 45??")) {
                    int reps = 8;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas3.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaci%C3%B3n%20de%20tal%C3%B3n%20en%20prensa%2045%C2%B0%2FIMG_0369.jpg?alt=media&token=1f2c4ccf-7cf9-4dd2-bd92-7bab13bc3539")
                            .fit().centerCrop()
                            .into(imagenpantorrillas3);
                }

                if ( ejercicioseleccionadopantorrillas3.equals("Elevaci??n de tal??n en prensa horizontal")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas3.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20horizontal%2F20211215_111104.jpg?alt=media&token=65f55792-18ee-4e71-bfd3-68788892af40")
                            .fit().centerCrop()
                            .into(imagenpantorrillas3);
                }



                //abs
                if ( ejercicioseleccionadoabdomen.equals("Crunch abdominal en maquina con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20maquina%20con%20cuerda%2F20210203_122801.jpg?alt=media&token=b7b6492d-0e43-4d80-8e4a-58a874b0b740")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if ( ejercicioseleccionadoabdomen.equals("Crunch abdominal")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121917.jpg?alt=media&token=6a7354cf-d38a-4931-ae6d-3bd5a0a6f1a1")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if ( ejercicioseleccionadoabdomen.equals("Crunch abdominal en maquina")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123647.jpg?alt=media&token=21d241b4-69a6-4e42-8f6b-d8eab01d5e16")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if ( ejercicioseleccionadoabdomen.equals("Rodillo abdominal")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112445.jpg?alt=media&token=65fbc2e2-c04e-4300-af76-36ba341c3a1b")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if ( ejercicioseleccionadoabdomen.equals("Elevaciones de piernas acostado en banco")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854.jpg?alt=media&token=9cab081e-a91e-40ef-8be1-e481445eddd1")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if ( ejercicioseleccionadoabdomen.equals("Elevaciones de piernas en silla romana")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112604.jpg?alt=media&token=a27b1953-a16e-419b-b206-ad01ebf5138d")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if ( ejercicioseleccionadoabdomen.equals("Crunch tipo bicicleta")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if ( ejercicioseleccionadoabdomen.equals("Crunch abdominal en banco declinado")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113147.jpg?alt=media&token=55b3d636-887e-4c01-ba37-e274fce2e1d1")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if ( ejercicioseleccionadoabdomen.equals("Crunch abdominal en banco declinado con balon en la nuca")) {
                    int reps = 8;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113217.jpg?alt=media&token=a6ad17e7-d218-41c7-9412-b26ffd74fc38")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if ( ejercicioseleccionadoabdomen.equals("Crunch acostado en flexi??n de piernas")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20con%20flexi%C3%B3n%20de%20piernas%2F20211210_113340.jpg?alt=media&token=063a87c6-0413-4e4f-b103-8e1892a93987")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if ( ejercicioseleccionadoabdomen.equals("Crunch lateral")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113437.jpg?alt=media&token=eccbfefe-6820-4879-b370-0ccb1454573e")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if ( ejercicioseleccionadoabdomen.equals("Toques al tal??n")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113834.jpg?alt=media&token=3521bce4-bbd0-4936-9994-1df7bd3f72d4")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if ( ejercicioseleccionadoabdomen.equals("Crunch lateral con polea alta")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113702.jpg?alt=media&token=1717a072-a610-449b-8a35-3dec01aded1a")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }

                if ( ejercicioseleccionadoabdomen.equals("Crunch abdominal hincado con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112931.jpg?alt=media&token=6dc6d69c-958a-4c9d-b5c3-0cd990fde57a")
                            .fit().centerCrop()
                            .into(imagenabdomen);
                }



                //abs
                if ( ejercicioseleccionadoabdomen2.equals("Crunch abdominal en maquina con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20maquina%20con%20cuerda%2F20210203_122801.jpg?alt=media&token=b7b6492d-0e43-4d80-8e4a-58a874b0b740")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if ( ejercicioseleccionadoabdomen2.equals("Crunch abdominal")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121917.jpg?alt=media&token=6a7354cf-d38a-4931-ae6d-3bd5a0a6f1a1")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if ( ejercicioseleccionadoabdomen2.equals("Crunch abdominal en maquina")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123647.jpg?alt=media&token=21d241b4-69a6-4e42-8f6b-d8eab01d5e16")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if ( ejercicioseleccionadoabdomen2.equals("Rodillo abdominal")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112445.jpg?alt=media&token=65fbc2e2-c04e-4300-af76-36ba341c3a1b")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if ( ejercicioseleccionadoabdomen2.equals("Elevaciones de piernas acostado en banco")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854.jpg?alt=media&token=9cab081e-a91e-40ef-8be1-e481445eddd1")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if ( ejercicioseleccionadoabdomen2.equals("Elevaciones de piernas en silla romana")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112604.jpg?alt=media&token=a27b1953-a16e-419b-b206-ad01ebf5138d")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if ( ejercicioseleccionadoabdomen2.equals("Crunch tipo bicicleta")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if ( ejercicioseleccionadoabdomen2.equals("Crunch abdominal en banco declinado")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113147.jpg?alt=media&token=55b3d636-887e-4c01-ba37-e274fce2e1d1")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if ( ejercicioseleccionadoabdomen2.equals("Crunch abdominal en banco declinado con balon en la nuca")) {
                    int reps = 8;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113217.jpg?alt=media&token=a6ad17e7-d218-41c7-9412-b26ffd74fc38")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if ( ejercicioseleccionadoabdomen2.equals("Crunch acostado en flexi??n de piernas")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20con%20flexi%C3%B3n%20de%20piernas%2F20211210_113340.jpg?alt=media&token=063a87c6-0413-4e4f-b103-8e1892a93987")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if ( ejercicioseleccionadoabdomen2.equals("Crunch lateral")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113437.jpg?alt=media&token=eccbfefe-6820-4879-b370-0ccb1454573e")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if ( ejercicioseleccionadoabdomen2.equals("Toques al tal??n")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113834.jpg?alt=media&token=3521bce4-bbd0-4936-9994-1df7bd3f72d4")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if ( ejercicioseleccionadoabdomen2.equals("Crunch lateral con polea alta")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen2.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113702.jpg?alt=media&token=1717a072-a610-449b-8a35-3dec01aded1a")
                            .fit().centerCrop()
                            .into(imagenabdomen2);
                }

                if ( ejercicioseleccionadoabdomen2.equals("Crunch abdominal hincado con cuerda")) {
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

                String ejerciciocuadriceps = datasnapshot.child("cuadriceps/ ejercicio primario").getValue().toString();
                String ejerciciocuadriceps2 = datasnapshot.child("cuadriceps/ ejercicio secundario").getValue().toString();

                String ejercicioisquios = datasnapshot.child("isquios/ ejercicio primario").getValue().toString();
                String ejercicioisquios2 = datasnapshot.child("isquios/ ejercicio secundario").getValue().toString();

                String ejerciciogluteos = datasnapshot.child("gluteos y aductores/ ejercicio primario").getValue().toString();
                String ejerciciogluteos2 = datasnapshot.child("gluteos y aductores/ ejercicio secundario").getValue().toString();
                String ejerciciogluteos3 = datasnapshot.child("gluteos y aductores/ ejercicio tercero").getValue().toString();


                String ejerciciopantorrillas = datasnapshot.child("pantorrillas/ ejercicio primario").getValue().toString();
                String ejerciciopantorrillas2 = datasnapshot.child("pantorrillas/ ejercicio secundario").getValue().toString();
                String ejerciciopantorrillas3 = datasnapshot.child("pantorrillas/ ejercicio tercero").getValue().toString();

                String ejercicioabdomen = datasnapshot.child("abdominales/ ejercicio primario").getValue().toString();
                String ejercicioabdomen2 = datasnapshot.child("abdominales/ ejercicio secundario").getValue().toString();



                //RER INICIAL 3 - 4 Y 2 - 3
                if(rer1int >= 18) {


                    //abdomen
                    switch(ejercicioabdomen){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer15.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer15.setText("3 - 4 RER");
                            break;

                        case "Rodillo abdominal":
                            rer15.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer15.setText("3 - 4 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer15.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer15.setText("3 - 4 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Plancha":
                            rer15.setText("-");
                            break;

                        case "Toques al tal??n":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Crunch acostado en flexi??n de piernas":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Crunch lateral":
                            rer15.setText("2 - 3 RER");
                            break;

                    }



                    //abdomen
                    switch(ejercicioabdomen2){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer16.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer16.setText("3 - 4 RER");
                            break;

                        case "Rodillo abdominal":
                            rer16.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer16.setText("3 - 4 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer16.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer16.setText("3 - 4 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Plancha":
                            rer16.setText("-");
                            break;

                        case "Toques al tal??n":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Crunch acostado en flexi??n de piernas":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Crunch lateral":
                            rer16.setText("2 - 3 RER");
                            break;

                    }


                    //cuadriceps
                    switch(ejerciciocuadriceps){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Sentadilla con barra":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Prensa a 45??":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer1.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90??":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Prensa horizontal en m??quina":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Sentadilla en m??quina perfecta":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Extensiones de cuadriceps en m??quina":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Sentadilla":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer1.setText("2 - 3 RER");
                            break;

                    }


                    //cuadriceps
                    switch(ejerciciocuadriceps2){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Sentadilla con barra":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Prensa a 45??":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer2.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90??":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Prensa horizontal en m??quina":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Sentadilla en m??quina perfecta":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Extensiones de cuadriceps en m??quina":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Sentadilla":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer2.setText("2 - 3 RER");
                            break;

                    }




                    //ISQUIOS
                    switch(ejercicioisquios){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Peso muerto en smith":
                            rer5.setText("3 - 4 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl femoral acostado en m??quina":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl femoral acostado en m??quina a 1 pierna":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl femoral sentado en m??quina":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en m??quina":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Elevaci??n de cadera a una pierna":
                            rer5.setText("2 - 3 RER");
                            break;

                    }


                    //ISQUIOS
                    switch(ejercicioisquios2){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer6.setText("3 - 4 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer6.setText("3 - 4 RER");
                            break;

                        case "Peso muerto en smith":
                            rer6.setText("3 - 4 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl femoral acostado en m??quina":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl femoral acostado en m??quina a 1 pierna":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl femoral sentado en m??quina":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en m??quina":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Elevaci??n de cadera a una pierna":
                            rer6.setText("2 - 3 RER");
                            break;

                    }



                    //PANTORRILLAS
                    switch(ejerciciopantorrillas){
                        //ejercicios compuestos
                        case "Elevaci??n de tal??n parado en m??quina":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa 45??":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Elevaciones de tal??n en prensa a 1 pierna":
                            rer12.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "ELevaci??n de tal??n parado con mancuernas":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevaciones de tal??n en costurera":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa horizontal":
                            rer12.setText("2 - 3 RER");
                            break;
                    }

                    //PANTORRILLAS
                    switch(ejerciciopantorrillas){
                        //ejercicios compuestos
                        case "Elevaci??n de tal??n parado en m??quina":
                            rer13.setText("3 - 4 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa 45??":
                            rer13.setText("3 - 4 RER");
                            break;

                        case "Elevaciones de tal??n en prensa a 1 pierna":
                            rer13.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "ELevaci??n de tal??n parado con mancuernas":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Elevaciones de tal??n en costurera":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa horizontal":
                            rer13.setText("2 - 3 RER");
                            break;
                    }

                    //PANTORRILLAS
                    switch(ejerciciopantorrillas3){
                        //ejercicios compuestos
                        case "Elevaci??n de tal??n parado en m??quina":
                            rer14.setText("3 - 4 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa 45??":
                            rer14.setText("3 - 4 RER");
                            break;

                        case "Elevaciones de tal??n en prensa a 1 pierna":
                            rer14.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "ELevaci??n de tal??n parado con mancuernas":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Elevaciones de tal??n en costurera":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa horizontal":
                            rer14.setText("2 - 3 RER");
                            break;
                    }

                    //gluteos
                    switch(ejerciciogluteos){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Patada para gl??teos con m??quina de pie":
                            rer9.setText("3 - 4 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer9.setText("3 - 4 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Aducciones de cadera en m??quina":
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

                        case "Abducciones de cadera en m??quina":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Patada para gl??teo con polea":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Patada para gl??teos en m??quina":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Puente con mancuerna":
                            rer9.setText("2 - 3 RER");
                            break;

                        case "Patada para gl??teo con mancuerna":
                            rer9.setText("2 - 3 RER");
                            break;

                    }

                    //gluteos
                    switch(ejerciciogluteos2){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Patada para gl??teos con m??quina de pie":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer10.setText("3 - 4 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Aducciones de cadera en m??quina":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Peso muerto tipo sumo con mancuernal":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Goblet squat":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Abducciones de cadera en polea":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Abducciones de cadera en m??quina":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Patada para gl??teo con polea":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Patada para gl??teos en m??quina":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Puente con mancuerna":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Patada para gl??teo con mancuerna":
                            rer10.setText("2 - 3 RER");
                            break;

                    }

                    //gluteos
                    switch(ejerciciogluteos3){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Patada para gl??teos con m??quina de pie":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer11.setText("3 - 4 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Aducciones de cadera en m??quina":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Peso muerto tipo sumo con mancuernal":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Goblet squat":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Abducciones de cadera en polea":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Abducciones de cadera en m??quina":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Patada para gl??teo con polea":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Patada para gl??teos en m??quina":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Puente con mancuerna":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Patada para gl??teo con mancuerna":
                            rer11.setText("2 - 3 RER");
                            break;

                    }




                }


                // RER FINAL  1 - 2 Y 0 - 1

                if (rer1int <= 12){

                    //abdomen
                    switch(ejercicioabdomen){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Rodillo abdominal":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer15.setText("1 - 2 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Crunch abdominal":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Plancha":
                            rer15.setText("-");
                            break;

                        case "Toques al tal??n":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Crunch acostado en flexi??n de piernas":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Crunch lateral":
                            rer15.setText("0 - 1 RER");
                            break;

                    }



                    //abdomen
                    switch(ejercicioabdomen2){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Rodillo abdominal":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer16.setText("1 - 2 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Crunch abdominal":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Plancha":
                            rer16.setText("-");
                            break;

                        case "Toques al tal??n":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Crunch acostado en flexi??n de piernas":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Crunch lateral":
                            rer16.setText("0 - 1 RER");
                            break;

                    }





                    //PANTORRILLAS
                    switch(ejerciciopantorrillas){
                        //ejercicios compuestos
                        case "Elevaci??n de tal??n parado en m??quina":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa 45??":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de tal??n en prensa a 1 pierna":
                            rer12.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "ELevaci??n de tal??n parado con mancuernas":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Elevaciones de tal??n en costurera":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa horizontal":
                            rer12.setText("0 - 1 RER");
                            break;
                    }


                    //PANTORRILLAS
                    switch(ejerciciopantorrillas2){
                        //ejercicios compuestos
                        case "Elevaci??n de tal??n parado en m??quina":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa 45??":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de tal??n en prensa a 1 pierna":
                            rer13.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "ELevaci??n de tal??n parado con mancuernas":
                            rer13.setText("0 - 1 RER");
                            break;

                        case "Elevaciones de tal??n en costurera":
                            rer13.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa horizontal":
                            rer13.setText("0 - 1 RER");
                            break;
                    }


                    //PANTORRILLAS
                    switch(ejerciciopantorrillas3){
                        //ejercicios compuestos
                        case "Elevaci??n de tal??n parado en m??quina":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa 45??":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de tal??n en prensa a 1 pierna":
                            rer14.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "ELevaci??n de tal??n parado con mancuernas":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Elevaciones de tal??n en costurera":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa horizontal":
                            rer14.setText("0 - 1 RER");
                            break;
                    }



                    //gluteos
                    switch(ejerciciogluteos){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Patada para gl??teos con m??quina de pie":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer9.setText("1 - 2 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Aducciones de cadera en m??quina":
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

                        case "Abducciones de cadera en m??quina":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con polea":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teos en m??quina":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Puente con mancuerna":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con mancuerna":
                            rer9.setText("0 - 1 RER");
                            break;

                    }


                    //gluteos
                    switch(ejerciciogluteos2){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Patada para gl??teos con m??quina de pie":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer10.setText("1 - 2 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Aducciones de cadera en m??quina":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Peso muerto tipo sumo con mancuernal":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Goblet squat":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Abducciones de cadera en polea":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Abducciones de cadera en m??quina":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con polea":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teos en m??quina":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Puente con mancuerna":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con mancuerna":
                            rer10.setText("0 - 1 RER");
                            break;

                    }


                    //gluteos
                    switch(ejerciciogluteos3){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Patada para gl??teos con m??quina de pie":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer11.setText("1 - 2 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Aducciones de cadera en m??quina":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Peso muerto tipo sumo con mancuernal":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Goblet squat":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Abducciones de cadera en polea":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Abducciones de cadera en m??quina":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con polea":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teos en m??quina":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Puente con mancuerna":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con mancuerna":
                            rer11.setText("0 - 1 RER");
                            break;

                    }

                    //ISQUIOS
                    switch(ejercicioisquios){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Peso muerto en smith":
                            rer5.setText("1 - 2 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en m??quina":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en m??quina a 1 pierna":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl femoral sentado en m??quina":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en m??quina":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n de cadera a una pierna":
                            rer5.setText("0 - 1 RER");
                            break;

                    }

                    //ISQUIOS
                    switch(ejercicioisquios2){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Peso muerto en smith":
                            rer6.setText("1 - 2 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en m??quina":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en m??quina a 1 pierna":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl femoral sentado en m??quina":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en m??quina":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n de cadera a una pierna":
                            rer6.setText("0 - 1 RER");
                            break;

                    }




                    //cuadriceps
                    switch(ejerciciocuadriceps){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Sentadilla con barra":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Prensa a 45??":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer1.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90??":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Prensa horizontal en m??quina":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Sentadilla en m??quina perfecta":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Extensiones de cuadriceps en m??quina":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Sentadilla":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer1.setText("0 - 1 RER");
                            break;

                    }

                    //cuadriceps
                    switch(ejerciciocuadriceps2){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Sentadilla con barra":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Prensa a 45??":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer2.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90??":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Prensa horizontal en m??quina":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Sentadilla en m??quina perfecta":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Extensiones de cuadriceps en m??quina":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Sentadilla":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer2.setText("0 - 1 RER");
                            break;

                    }




                }

                // RER MEDIO 2 - 3  Y 1 - 2

                if (rer1int>13 && rer1int<=17){

                    //PANTORRILLAS
                    switch(ejerciciopantorrillas){
                        //ejercicios compuestos
                        case "Elevaci??n de tal??n parado en m??quina":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa 45??":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de tal??n en prensa a 1 pierna":
                            rer12.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "ELevaci??n de tal??n parado con mancuernas":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Elevaciones de tal??n en costurera":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa horizontal":
                            rer12.setText("0 - 1 RER");
                            break;
                    }

                    //PANTORRILLAS
                    switch(ejerciciopantorrillas2){
                        //ejercicios compuestos
                        case "Elevaci??n de tal??n parado en m??quina":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa 45??":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de tal??n en prensa a 1 pierna":
                            rer13.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "ELevaci??n de tal??n parado con mancuernas":
                            rer13.setText("0 - 1 RER");
                            break;

                        case "Elevaciones de tal??n en costurera":
                            rer13.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa horizontal":
                            rer13.setText("0 - 1 RER");
                            break;
                    }

                    //PANTORRILLAS
                    switch(ejerciciopantorrillas3){
                        //ejercicios compuestos
                        case "Elevaci??n de tal??n parado en m??quina":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa 45??":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de tal??n en prensa a 1 pierna":
                            rer14.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "ELevaci??n de tal??n parado con mancuernas":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Elevaciones de tal??n en costurera":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa horizontal":
                            rer14.setText("0 - 1 RER");
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

                        case "Patada para gl??teos con m??quina de pie":
                            rer9.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer9.setText("1 - 2 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Aducciones de cadera en m??quina":
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

                        case "Abducciones de cadera en m??quina":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con polea":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teos en m??quina":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Puente con mancuerna":
                            rer9.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con mancuerna":
                            rer9.setText("0 - 1 RER");
                            break;

                    }


                    //PANTORRILLAS
                    switch(ejerciciogluteos2){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Patada para gl??teos con m??quina de pie":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer10.setText("1 - 2 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Aducciones de cadera en m??quina":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Peso muerto tipo sumo con mancuernal":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Goblet squat":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Abducciones de cadera en polea":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Abducciones de cadera en m??quina":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con polea":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teos en m??quina":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Puente con mancuerna":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con mancuerna":
                            rer10.setText("0 - 1 RER");
                            break;

                    }

                    //PANTORRILLAS
                    switch(ejerciciogluteos3){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Patada para gl??teos con m??quina de pie":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer11.setText("1 - 2 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Aducciones de cadera en m??quina":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Peso muerto tipo sumo con mancuernal":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Goblet squat":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Abducciones de cadera en polea":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Abducciones de cadera en m??quina":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con polea":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teos en m??quina":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Puente con mancuerna":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con mancuerna":
                            rer11.setText("0 - 1 RER");
                            break;

                    }



                    //ISQUIOS
                    switch(ejercicioisquios){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Peso muerto en smith":
                            rer5.setText("1 - 2 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en m??quina":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en m??quina a 1 pierna":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl femoral sentado en m??quina":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en m??quina":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n de cadera a una pierna":
                            rer5.setText("0 - 1 RER");
                            break;

                    }



                    //ISQUIOS
                    switch(ejercicioisquios2){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Peso muerto en smith":
                            rer6.setText("1 - 2 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en m??quina":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en m??quina a 1 pierna":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl femoral sentado en m??quina":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en m??quina":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n de cadera a una pierna":
                            rer6.setText("0 - 1 RER");
                            break;

                    }



                    //cuadriceps
                    switch(ejerciciocuadriceps){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Sentadilla con barra":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Prensa a 45??":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer1.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90??":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Prensa horizontal en m??quina":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Sentadilla en m??quina perfecta":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Extensiones de cuadriceps en m??quina":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Sentadilla":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer1.setText("0 - 1 RER");
                            break;

                    }


                    //cuadriceps
                    switch(ejerciciocuadriceps2){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Sentadilla con barra":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Prensa a 45??":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer2.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90??":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Prensa horizontal en m??quina":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Sentadilla en m??quina perfecta":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Extensiones de cuadriceps en m??quina":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Sentadilla":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer2.setText("0 - 1 RER");
                            break;

                    }




                    //abdomen
                    switch(ejercicioabdomen){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Rodillo abdominal":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer15.setText("2 - 3 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Plancha":
                            rer15.setText("-");
                            break;

                        case "Toques al tal??n":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Crunch acostado en flexi??n de piernas":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Crunch lateral":
                            rer15.setText("1 - 2 RER");
                            break;

                    }



                    //abdomen
                    switch(ejercicioabdomen2){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Rodillo abdominal":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer16.setText("2 - 3 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Plancha":
                            rer16.setText("-");
                            break;

                        case "Toques al tal??n":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Crunch acostado en flexi??n de piernas":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Crunch lateral":
                            rer16.setText("1 - 2 RER");
                            break;

                    }



                }



//-------------------------------------------------------------------------------------------------------------------------------------------------------------

                //SERIES



                String slateral = datasnapshot.child("series cuadriceps").getValue().toString();
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
                int slateralint4 = (int) Math.floor(slateralf4);
                String seriesfinallateral = String.valueOf(slateralint);
                String seriesfinallateral2 = String.valueOf(slateralint2);
                String seriesfinallateral3 = String.valueOf(slateralint3);
                String seriesfinallateral4 = String.valueOf(slateralint4);
                seriescuadriceps.setText(seriesfinallateral + " Series");
                seriescuadriceps2.setText(seriesfinallateral2 + " Series");




                String scuadriceps = datasnapshot.child("series femorales").getValue().toString();
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
                int scuadint4 = (int) Math.floor(scuadf4);
                String seriesfinalcuad = String.valueOf(scuadint);
                String seriesfinalcuad2 = String.valueOf(scuadint2);
                String seriesfinalcuad3 = String.valueOf(scuadint3);
                String seriesfinalcuad4 = String.valueOf(scuadint4);
                seriesfemoral.setText(seriesfinalcuad + " Series");
                seriesfemoral2.setText(seriesfinalcuad2 + " Series");




                String sfemorales = datasnapshot.child("series gluteos").getValue().toString();
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
                seriesgluteos.setText(seriesfinalfemorales + " Series");
                seriesgluteos2.setText(seriesfinalfemorales2 + " Series");
                seriesgluteos3.setText(seriesfinalfemorales3 + " Series");


                String sgluteos = datasnapshot.child("series pantorrillas").getValue().toString();
                Double sgl = Double.parseDouble(sgluteos);
                Double sgluteosdividido = sgl / 2;
                Double sgluteosf = Math.ceil(sgluteosdividido);
                Double sgluteosf1 = sgluteosf / 3;
                Double sgluteosf2 = sgluteosf / 3;
                Double sgluteosf3 = sgluteosf / 3;
                int sgluteosint = (int) Math.ceil(sgluteosf1);
                int sgluteosint2 = (int) Math.round(sgluteosf2);
                if (sgluteosint2 == 1){
                    sgluteosint2++;
                }
                int sgluteosint3 = (int) Math.floor(sgluteosf3);
                if (sgluteosint3 == 1){
                    sgluteosint3++;
                }
                String seriesgluteosfinal = String.valueOf(sgluteosint);
                String seriesgluteosfinal2 = String.valueOf(sgluteosint2);
                String seriesgluteosfinal3 = String.valueOf(sgluteosint3);
                seriespantorrillas.setText(seriesgluteosfinal + " Series");
                seriespantorrillas2.setText(seriesgluteosfinal2 + " Series");
                seriespantorrillas3.setText(seriesgluteosfinal3 + " Series");


                String sgluteosa = datasnapshot.child("series abdominales").getValue().toString();
                Double sgla = Double.parseDouble(sgluteosa);
                Double sgluteosdivididoa = sgla / 2;
                Double sgluteosfa = Math.ceil(sgluteosdivididoa);
                Double sgluteosf1a = sgluteosfa / 3;
                Double sgluteosf2a = sgluteosfa / 3;
                Double sgluteosf3a = sgluteosfa / 3;
                int sgluteosinta = (int) Math.ceil(sgluteosf1a);
                int sgluteosint2a = (int) Math.round(sgluteosf2a);
                if (sgluteosint2a == 1){
                    sgluteosint2a++;
                }
                int sgluteosint3a = (int) Math.round(sgluteosf3a);
                if (sgluteosint3a == 1){
                    sgluteosint3a++;
                }
                String seriesgluteosfinala = String.valueOf(sgluteosinta);
                String seriesgluteosfinal2a = String.valueOf(sgluteosint2a);
                String seriesgluteosfinal3a = String.valueOf(sgluteosint3a);
                seriesabdomen.setText(seriesgluteosfinala + " Series");
                seriesabdomen2.setText(seriesgluteosfinal2a + " Series");






                String stringpesoiniciallateral = datasnapshot.child("Historial cuadriceps/ 5 dias/ primer ejercicio/ dia 2").getValue().toString();
                pesocuadriceps.setText(stringpesoiniciallateral);

                String stringpesoiniciallateral2 = datasnapshot.child("Historial cuadriceps/ 5 dias/ segundo ejercicio/ dia 2").getValue().toString();
                pesocuadriceps2.setText(stringpesoiniciallateral2);





                String stringpesoinicialcuadriceps2 = datasnapshot.child("Historial isquios/ 5 dias/ primer ejercicio/ dia 2").getValue().toString();
                pesofemoral.setText(stringpesoinicialcuadriceps2);

                String stringpesoinicialcuadriceps3 = datasnapshot.child("Historial isquios/ 5 dias/ segundo ejercicio/ dia 2").getValue().toString();
                pesofemora2.setText(stringpesoinicialcuadriceps3);





                String stringpesoinicialfemoral3 = datasnapshot.child("Historial gluteos y aductores/ 5 dias/ primer ejercicio/ dia 2").getValue().toString();
                pesogluteos.setText(stringpesoinicialfemoral3);

                String stringpesoinicialpantorrillas = datasnapshot.child("Historial gluteos y aductores/ 5 dias/ segundo ejercicio/ dia 2").getValue().toString();
                pesogluteos2.setText(stringpesoinicialpantorrillas);

                String stringpesoinicialpantorrillas2 = datasnapshot.child("Historial gluteos y aductores/ 5 dias/ tercer ejercicio/ dia 2").getValue().toString();
                pesogluteos3.setText(stringpesoinicialpantorrillas2);



                String stringpesoinicialgluteos = datasnapshot.child("Historial pantorrillas/ 5 dias/ primer ejercicio/ dia 2").getValue().toString();
                pesopantorrillas.setText(stringpesoinicialgluteos);

                String stringpesoinicialgluteos2 = datasnapshot.child("Historial pantorrillas/ 5 dias/ segundo ejercicio/ dia 2").getValue().toString();
                pesopantorrillas2.setText(stringpesoinicialgluteos2);

                String stringpesoinicialabdomen = datasnapshot.child("Historial pantorrillas/ 5 dias/ tercer ejercicio/ dia 2").getValue().toString();
                pesopantorrillas3.setText(stringpesoinicialabdomen);



                String stringpesoabdomen = datasnapshot.child("Historial abdomen/ 5 dias/ primer ejercicio/ dia 2").getValue().toString();
                pesoabdomen.setText(stringpesoabdomen);

                String stringpesoabdomen2 = datasnapshot.child("Historial abdomen/ 5 dias/ segundo ejercicio/ dia 2").getValue().toString();
                pesoabdomen2.setText(stringpesoabdomen2);





            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





















        //permite dejar puesto el peso ingresado en el edit text
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



                                                  }
                                              }
        );


        //permite dejar puesto el peso ingresado en el edit text
        pesocuadriceps2.addTextChangedListener(new TextWatcher() {
                                                   @Override
                                                   public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                   }

                                                   @Override
                                                   public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                   }

                                                   @Override
                                                   public void afterTextChanged(Editable editable) {
                                                       SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesocuadriceps2.getContext());
                                                       preferences.edit().putString("editText",editable.toString()).commit();



                                                   }
                                               }
        );





        //permite dejar puesto el peso ingresado en el edit text
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



                                               }
                                           }
        );



        //permite dejar puesto el peso ingresado en el edit text
        pesofemora2.addTextChangedListener(new TextWatcher() {
                                               @Override
                                               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                               }

                                               @Override
                                               public void afterTextChanged(Editable editable) {
                                                   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesofemora2.getContext());
                                                   preferences.edit().putString("editText",editable.toString()).commit();



                                               }
                                           }
        );







        //permite dejar puesto el peso ingresado en el edit text
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



                                               }
                                           }
        );


        //permite dejar puesto el peso ingresado en el edit text
        pesogluteos2.addTextChangedListener(new TextWatcher() {
                                                @Override
                                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void afterTextChanged(Editable editable) {
                                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesogluteos2.getContext());
                                                    preferences.edit().putString("editText",editable.toString()).commit();



                                                }
                                            }
        );


        //permite dejar puesto el peso ingresado en el edit text
        pesogluteos3.addTextChangedListener(new TextWatcher() {
                                                @Override
                                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void afterTextChanged(Editable editable) {
                                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesogluteos3.getContext());
                                                    preferences.edit().putString("editText",editable.toString()).commit();



                                                }
                                            }
        );


        //permite dejar puesto el peso ingresado en el edit text
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



                                                    }
                                                }
        );


        //permite dejar puesto el peso ingresado en el edit text
        pesopantorrillas2.addTextChangedListener(new TextWatcher() {
                                                     @Override
                                                     public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                     }

                                                     @Override
                                                     public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                     }

                                                     @Override
                                                     public void afterTextChanged(Editable editable) {
                                                         SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesopantorrillas2.getContext());
                                                         preferences.edit().putString("editText",editable.toString()).commit();



                                                     }
                                                 }
        );


        //permite dejar puesto el peso ingresado en el edit text
        pesopantorrillas3.addTextChangedListener(new TextWatcher() {
                                                     @Override
                                                     public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                     }

                                                     @Override
                                                     public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                     }

                                                     @Override
                                                     public void afterTextChanged(Editable editable) {
                                                         SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesopantorrillas3.getContext());
                                                         preferences.edit().putString("editText",editable.toString()).commit();



                                                     }
                                                 }
        );



        //permite dejar puesto el peso ingresado en el edit text
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




        //permite dejar puesto el peso ingresado en el edit text
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







    }


    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void findelentrenamientoentreno5diamiercoles7(View view) {

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
                    mInterstitialAd.show(entreno5diamiercolesmujer.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }

            }
        }, 300);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();

        String datoejercicio1 = pesocuadriceps.getText().toString();
        String datoejercicio1_2 = pesocuadriceps2.getText().toString();


        String datoejercicio2 = pesofemoral.getText().toString();
        String datoejercicio2_2 = pesofemora2.getText().toString();

        String datoejercicio3 = pesogluteos.getText().toString();
        String datoejercicio3_2 = pesogluteos2.getText().toString();
        String datoejercicio3_3 = pesogluteos3.getText().toString();

        String datoejercicio4 = pesopantorrillas.getText().toString();
        String datoejercicio4_2 = pesopantorrillas2.getText().toString();
        String datoejercicio4_3 = pesopantorrillas3.getText().toString();

        String abdomen = pesoabdomen.getText().toString();
        String abdomen2= pesoabdomen2.getText().toString();



        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                Map<String, Object> pesoactualizandose2 = new HashMap<>();
                pesoactualizandose2.put("Historial cuadriceps/ 5 dias/ primer ejercicio/ dia 2", datoejercicio1);
                pesoactualizandose2.put("Historial cuadriceps/ 5 dias/ segundo ejercicio/ dia 2", datoejercicio1_2);


                pesoactualizandose2.put("Historial isquios/ 5 dias/ primer ejercicio/ dia 2", datoejercicio2);
                pesoactualizandose2.put("Historial isquios/ 5 dias/ segundo ejercicio/ dia 2", datoejercicio2_2);

                pesoactualizandose2.put("Historial gluteos y aductores/ 5 dias/ primer ejercicio/ dia 2", datoejercicio3);
                pesoactualizandose2.put("Historial gluteos y aductores/ 5 dias/ segundo ejercicio/ dia 2", datoejercicio3_2);
                pesoactualizandose2.put("Historial gluteos y aductores/ 5 dias/ tercer ejercicio/ dia 2", datoejercicio3_3);

                pesoactualizandose2.put("Historial pantorrillas/ 5 dias/ primer ejercicio/ dia 2", datoejercicio4);
                pesoactualizandose2.put("Historial pantorrillas/ 5 dias/ segundo ejercicio/ dia 2", datoejercicio4_2);
                pesoactualizandose2.put("Historial pantorrillas/ 5 dias/ tercer ejercicio/ dia 2", datoejercicio4_3);

                pesoactualizandose2.put("Historial abdominales/ 5 dias/ primer ejercicio/ dia 2", abdomen);
                pesoactualizandose2.put("Historial abdominales/ 5 dias/ segundo ejercicio/ dia 2", abdomen2);





                mDatabase.child("Users").child(id).updateChildren(pesoactualizandose2);


                //si se modifica el datachange en algun otro momento envia a esta pantalla, por lo cual se condiciona el envio
                boolean botonpresionado = true;

                if (botonpresionado == true){



                    Intent findelentrenamiento = new Intent(entreno5diamiercolesmujer.this, entrenamientofinalizado.class);

                    String valor2 = getIntent().getExtras().getString("actual");
                    findelentrenamiento.putExtra("actual", valor2);
                    findelentrenamiento.putExtra("entreno?", "sidia3");

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
                String ej = datasnapshot.child("cuadriceps/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("cuadriceps/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("cuadriceps/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("cuadriceps/ ejercicio cuarto").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("isquios/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("isquios/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("isquios/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("isquios/ ejercicio cuarto").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("gluteos y aductores/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("gluteos y aductores/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("gluteos y aductores/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("pantorrillas/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("pantorrillas/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("pantorrillas/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("abdominales/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("abdominales/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diamiercolesmujer.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}
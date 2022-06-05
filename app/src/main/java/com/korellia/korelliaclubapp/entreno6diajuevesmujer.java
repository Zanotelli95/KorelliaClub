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

public class entreno6diajuevesmujer extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private EditText peso1, peso2, pesotriceps3, peso3, pesoabdomen, pesoabdomen2, pesoabdomen3, pesofrontal2, pesotriceps, pesotriceps2, pesofrontal;
    private String ejercicioseleccionado,  ejercicioseleccionadotriceps, ejercicioseleccionadofrontal;
    private TextView rer1, rer2, rer3, rer4, rer5, rer7, rer8, rer9, rer10, rer11, rer12, rer13, rer14, rer15, rer16;
    private TextView fechacompleta;
    private TextView seriespectoral,
            seriesabdomen, seriesabdomen2, seriesabdomen3, ejercicioabdomen2, ejercicioabdomen3, repeticionesabdomen, repeticionesabdomen2,
            repeticionesabdomen3,  seriespectoral2, seriespectoral3,  seriestriceps,
            seriestriceps2, seriesfrontal;
    private Spinner spinner1, spinner2, spinner3, spinner14, spinner15, spinner16, spinner4, spinner5, spinner6,  spinner12, spinner13;
    private  TextView ejerciciopectoral, repeticionespectoral2, repeticionespectoral3, repeticionestriceps3, seriestriceps3, ejerciciotriceps3,
            ejerciciopectoral2, ejerciciopectoral3, repeticionespectoral, ejerciciotriceps,
            repeticionestriceps,  repeticionestriceps2, ejerciciofrontal,
            repeticionesfrontal, ejerciciotriceps2, ejercicioabdomen;
    private ImageView imagenpectoral, imagentriceps3,  imagenabdomen2,  imagenabdomen3, imagenabdomen,
          imagenfrontal2, imagenpectoral2, imagenpectoral3,
            imagentriceps, imagentriceps2,  imagenfrontal;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private TextView ejerciciofrontal2,  repeticionesfrontal2,  seriesfrontal2;
    private String ejercicioseleccionado2,  ejercicioseleccionadoabdomen,  ejercicioseleccionadotriceps3, ejercicioseleccionadoabdomen2,
            ejercicioseleccionadoabdomen3,  ejercicioseleccionado3, ejercicioseleccionadofrontal2, ejercicioseleccionadotriceps2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_entreno6diajuevesmujer);



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


        fechacompleta = (TextView) findViewById(R.id.textView273613);
        Date date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("d MMM yyyy");
        String sfecha = fecha.format(date);
        fechacompleta.setText(sfecha);


        Toolbar toolbar = findViewById(R.id.toolbarentreno6diajuevesmujer);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Entrenamiento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        spinner1= (Spinner) findViewById(R.id.spinner1613);
        spinner2= (Spinner) findViewById(R.id.spinner2613);
        spinner3= (Spinner) findViewById(R.id.spinner8613);

        spinner4= (Spinner) findViewById(R.id.spinner9613);
        spinner5= (Spinner) findViewById(R.id.spinner106213);
        spinner6= (Spinner) findViewById(R.id.spinner106313);

        spinner12= (Spinner) findViewById(R.id.spinner116f13);
        spinner13= (Spinner) findViewById(R.id.spinner116f213);

        spinner14= (Spinner) findViewById(R.id.spinner13abs3513);
        spinner15= (Spinner) findViewById(R.id.spinner142abs3513);
        spinner16= (Spinner) findViewById(R.id.spinner143abs3513);






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



        rer1 = findViewById(R.id.buttonrer1a613);
        rer2 = findViewById(R.id.buttonrer2a613);
        rer3 = findViewById(R.id.buttonrer8a613);


        rer4 = findViewById(R.id.buttonrer9a613);
        rer5 = findViewById(R.id.buttonrer10a6213);
        rer7 = findViewById(R.id.buttonrer10a6313);

        rer10 = findViewById(R.id.buttonrer11a6113);
        rer11 = findViewById(R.id.buttonrer11a6213);


        rer14 = findViewById(R.id.buttonrer13abs3513);
        rer15 = findViewById(R.id.buttonrer14a2abs3513);
        rer16 = findViewById(R.id.buttonrer14a3abs3513);




        //pectoral 3
        ejerciciopectoral = (TextView) findViewById(R.id.textView219613);
        repeticionespectoral = (TextView) findViewById(R.id.textView221613);
        imagenpectoral = (ImageView) findViewById(R.id.imageView11613);
        peso1 = (EditText) findViewById(R.id.textView222613);
        seriespectoral = (TextView) findViewById(R.id.textView220613);


        ejerciciopectoral2 = (TextView) findViewById(R.id.textView219pectoral2613);
        repeticionespectoral2 = (TextView) findViewById(R.id.textView221pec2613);
        imagenpectoral2 = (ImageView) findViewById(R.id.imageView11imagen2613);
        peso2 = (EditText) findViewById(R.id.textView222pec2613);
        seriespectoral2 = (TextView) findViewById(R.id.textView220pec2613);


        ejerciciopectoral3 = (TextView) findViewById(R.id.textView219biceps2613);
        repeticionespectoral3 = (TextView) findViewById(R.id.textView221biceps2613);
        imagenpectoral3 = (ImageView) findViewById(R.id.imageView11biceps2613);
        peso3 = (EditText) findViewById(R.id.textView222biceps2613);
        seriespectoral3 = (TextView) findViewById(R.id.textView220biceps2613);




        //triceps 2
        ejerciciotriceps = (TextView) findViewById(R.id.nombreejerciciotriceps1613);
        repeticionestriceps = (TextView) findViewById(R.id.textView221triceps1613);
        imagentriceps = (ImageView) findViewById(R.id.imageView11triceps1613);
        pesotriceps = (EditText) findViewById(R.id.textView222triceps1613);
        seriestriceps = (TextView) findViewById(R.id.textView220triceps1613);

        ejerciciotriceps2 = (TextView) findViewById(R.id.textView219triceps26213);
        repeticionestriceps2 = (TextView) findViewById(R.id.textView221triecps26213);
        imagentriceps2 = (ImageView) findViewById(R.id.imageView11triceps26213);
        pesotriceps2 = (EditText) findViewById(R.id.textView222triceps26213);
        seriestriceps2 = (TextView) findViewById(R.id.textView220triceps26213);

        ejerciciotriceps3 = (TextView) findViewById(R.id.textView219triceps26313);
        repeticionestriceps3 = (TextView) findViewById(R.id.textView221triecps26313);
        imagentriceps3 = (ImageView) findViewById(R.id.imageView11triceps26313);
        pesotriceps3 = (EditText) findViewById(R.id.textView222triceps26313);
        seriestriceps3 = (TextView) findViewById(R.id.textView220triceps26313);




        //frontales
        ejerciciofrontal = (TextView) findViewById(R.id.textView219frontal16113);
        repeticionesfrontal = (TextView) findViewById(R.id.textView221frontal16113);
        imagenfrontal = (ImageView) findViewById(R.id.imageView11frontal16113);
        pesofrontal = (EditText) findViewById(R.id.textView222frontal16113);
        seriesfrontal= (TextView) findViewById(R.id.textView220frontal16113);

        ejerciciofrontal2 = (TextView) findViewById(R.id.textView219frontal16213);
        repeticionesfrontal2 = (TextView) findViewById(R.id.textView221frontal16213);
        imagenfrontal2 = (ImageView) findViewById(R.id.imageView11frontal16213);
        pesofrontal2 = (EditText) findViewById(R.id.textView222frontal16213);
        seriesfrontal2= (TextView) findViewById(R.id.textView220frontal16213);


        //abdomen 3
        ejercicioabdomen = (TextView) findViewById(R.id.textView219abs3513);
        repeticionesabdomen = (TextView) findViewById(R.id.textView221abs3513);
        imagenabdomen = (ImageView) findViewById(R.id.imageView11abs3513);
        pesoabdomen = (EditText) findViewById(R.id.textView222abs3513);
        seriesabdomen = (TextView) findViewById(R.id.textView220abs3513);


        ejercicioabdomen2 = (TextView) findViewById(R.id.textView2192abs3513);
        repeticionesabdomen2 = (TextView) findViewById(R.id.textView2212abs3513);
        imagenabdomen2 = (ImageView) findViewById(R.id.imageView112abs3513);
        pesoabdomen2 = (EditText) findViewById(R.id.textView2222abs3513);
        seriesabdomen2 = (TextView) findViewById(R.id.textView2202abs3513);


        ejercicioabdomen3 = (TextView) findViewById(R.id.textView219traps23abs3513);
        repeticionesabdomen3 = (TextView) findViewById(R.id.textView221traps23abs3513);
        imagenabdomen3 = (ImageView) findViewById(R.id.imageView11traps23abs3513);
        pesoabdomen3 = (EditText) findViewById(R.id.textView222traps23abs3513);
        seriesabdomen3 = (TextView) findViewById(R.id.textView220traps23abs3513);






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


                    String stringejerciciotriceps = datasnapshot.child("triceps/ ejercicio primario").getValue().toString();
                    ejerciciotriceps.setText(stringejerciciotriceps);
                    ejercicioseleccionadotriceps = stringejerciciotriceps;

                    String stringejerciciotriceps2 = datasnapshot.child("triceps/ ejercicio secundario").getValue().toString();
                    ejerciciotriceps2.setText(stringejerciciotriceps2);
                    ejercicioseleccionadotriceps2 = stringejerciciotriceps2;

                    String stringejerciciotriceps3 = datasnapshot.child("triceps/ ejercicio tercero").getValue().toString();
                    ejerciciotriceps3.setText(stringejerciciotriceps3);
                    ejercicioseleccionadotriceps3 = stringejerciciotriceps3;



                    String stringejerciciofrontal = datasnapshot.child("deltoide frontal/ ejercicio primario").getValue().toString();
                    ejerciciofrontal.setText(stringejerciciofrontal);
                    ejercicioseleccionadofrontal = stringejerciciofrontal;

                    String stringejerciciofrontal2 = datasnapshot.child("deltoide frontal/ ejercicio secundario").getValue().toString();
                    ejerciciofrontal2.setText(stringejerciciofrontal2);
                    ejercicioseleccionadofrontal2 = stringejerciciofrontal2;




                    String stringejercicioab = datasnapshot.child("abdominales/ ejercicio primario").getValue().toString();
                    ejercicioabdomen.setText(stringejercicioab);
                    ejercicioseleccionadoabdomen = stringejercicioab;

                    String stringejercicioab2 = datasnapshot.child("abdominales/ ejercicio secundario").getValue().toString();
                    ejercicioabdomen2.setText(stringejercicioab2);
                    ejercicioseleccionadoabdomen2 = stringejercicioab2;

                    String stringejercicioabdomen3 = datasnapshot.child("abdominales/ ejercicio tercero").getValue().toString();
                    ejercicioabdomen3.setText(stringejercicioabdomen3);
                    ejercicioseleccionadoabdomen3 = stringejercicioabdomen3;




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
                //----

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


                //---





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

                if ( ejercicioseleccionadoabdomen.equals("Crunch acostado en flexión de piernas")) {
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

                if ( ejercicioseleccionadoabdomen.equals("Toques al talón")) {
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
                if ( ejercicioseleccionadoabdomen3.equals("Crunch abdominal en maquina con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20maquina%20con%20cuerda%2F20210203_122801.jpg?alt=media&token=b7b6492d-0e43-4d80-8e4a-58a874b0b740")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch abdominal")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121917.jpg?alt=media&token=6a7354cf-d38a-4931-ae6d-3bd5a0a6f1a1")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch abdominal en maquina")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123647.jpg?alt=media&token=21d241b4-69a6-4e42-8f6b-d8eab01d5e16")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Rodillo abdominal")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112445.jpg?alt=media&token=65fbc2e2-c04e-4300-af76-36ba341c3a1b")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Elevaciones de piernas acostado en banco")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854.jpg?alt=media&token=9cab081e-a91e-40ef-8be1-e481445eddd1")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Elevaciones de piernas en silla romana")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112604.jpg?alt=media&token=a27b1953-a16e-419b-b206-ad01ebf5138d")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch tipo bicicleta")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch abdominal en banco declinado")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113147.jpg?alt=media&token=55b3d636-887e-4c01-ba37-e274fce2e1d1")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch abdominal en banco declinado con balon en la nuca")) {
                    int reps = 8;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113217.jpg?alt=media&token=a6ad17e7-d218-41c7-9412-b26ffd74fc38")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch acostado en flexión de piernas")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20con%20flexi%C3%B3n%20de%20piernas%2F20211210_113340.jpg?alt=media&token=063a87c6-0413-4e4f-b103-8e1892a93987")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch lateral")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113437.jpg?alt=media&token=eccbfefe-6820-4879-b370-0ccb1454573e")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Toques al talón")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113834.jpg?alt=media&token=3521bce4-bbd0-4936-9994-1df7bd3f72d4")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch lateral con polea alta")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113702.jpg?alt=media&token=1717a072-a610-449b-8a35-3dec01aded1a")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch abdominal hincado con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112931.jpg?alt=media&token=6dc6d69c-958a-4c9d-b5c3-0cd990fde57a")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
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

                if ( ejercicioseleccionadoabdomen2.equals("Crunch acostado en flexión de piernas")) {
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

                if ( ejercicioseleccionadoabdomen2.equals("Toques al talón")) {
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


                //------
                if (ejercicioseleccionadotriceps3.equals("Copa con barra")) {
                    int reps = 6;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps3.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20barra%2F20210310_113434.jpg?alt=media&token=2248759f-65be-4c94-951d-9a51ea67fdd0")
                            .fit().centerCrop()
                            .into(imagentriceps3);
                }

                if (ejercicioseleccionadotriceps3.equals("Copa con mancuerna a 1 brazo")) {
                    int reps = 10;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps3.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%20a%201%20brazo%2F20211211_134125.jpg?alt=media&token=6a09c03d-52d2-489d-b733-44cf1636c8db")
                            .fit().centerCrop()
                            .into(imagentriceps3);
                }

                if (ejercicioseleccionadotriceps3.equals("Extensiones de tríceps a 1 brazo agarre supino")) {
                    int reps = 15;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps3.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20a%201%20brazo%20agarre%20supino%2F20210306_120236.jpg?alt=media&token=8cbdc0b6-9c3a-4e32-9a77-5aadeaef1f85")
                            .fit().centerCrop()
                            .into(imagentriceps3);
                }

                if (ejercicioseleccionadotriceps3.equals("Extensiones de tríceps con cuerda")) {
                    int reps = 15;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps3.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20con%20cuerda%2F20210131_104718.jpg?alt=media&token=16b1f8b0-ef5a-45f5-b4de-a0d5a289ca59")
                            .fit().centerCrop()
                            .into(imagentriceps3);
                }

                if (ejercicioseleccionadotriceps3.equals("Extensiones de tríceps en máquina")) {
                    int reps = 12;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps3.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20maquina%2F20210131_104124.jpg?alt=media&token=9b6efd0c-3bed-48ed-b96f-893a06879207")
                            .fit().centerCrop()
                            .into(imagentriceps3);
                }

                if (ejercicioseleccionadotriceps3.equals("Fondos en máquina")) {
                    int reps = 10;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps3.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Ffondos%20en%20maquina%2F20210131_104422.jpg?alt=media&token=4a2f6161-b9b0-47d0-a718-d1b4a5f02100")
                            .fit().centerCrop()
                            .into(imagentriceps3);
                }

                if (ejercicioseleccionadotriceps3.equals("Patada para tríceps a 1 brazo")) {
                    int reps = 8;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps3.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20triceps%20a%201%20brazo%2F20210131_105749.jpg?alt=media&token=3edb47a6-91f3-4fdd-b9ef-7ed86bcb22fc")
                            .fit().centerCrop()
                            .into(imagentriceps3);
                }

                if (ejercicioseleccionadotriceps3.equals("Patada para tríceps con polea")) {
                    int reps = 12;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps3.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20tr%C3%ADceps%20con%20polea%2F20210303_120303.jpg?alt=media&token=c1821599-0a85-4254-b855-4e14d909d198")
                            .fit().centerCrop()
                            .into(imagentriceps3);
                }

                if (ejercicioseleccionadotriceps3.equals("Rompecraneos con mancuernas")) {
                    int reps = 10;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps3.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20mancuernas%2F20210306_121025.jpg?alt=media&token=443ab4fd-91fa-42f6-b76c-e5fa5f98a988")
                            .fit().centerCrop()
                            .into(imagentriceps3);
                }

                if (ejercicioseleccionadotriceps3.equals("Rompecraneos con barra z")) {
                    int reps = 6;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps3.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20barra%20z%2F20211211_133613.jpg?alt=media&token=51f761d5-a7bb-4d06-9c2b-7b4c109ebdb5")
                            .fit().centerCrop()
                            .into(imagentriceps3);
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

                if (ejercicioseleccionadotriceps3.equals("Extensiones de tríceps en polea alta con maneral recto")) {
                    int reps = 12;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps3.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20polea%20alta%20con%20manera%20recto%2F20211211_134008.jpg?alt=media&token=d3a079cf-e0d6-40b2-b8de-3b8c2ed75cdd")
                            .fit().centerCrop()
                            .into(imagentriceps3);
                }

                if (ejercicioseleccionadotriceps3.equals("Press cerrado con barra")) {
                    int reps = 6;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps3.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20con%20barra%2FIMG_0333.jpg?alt=media&token=e8337d1e-5160-400c-8923-b771369ef950")
                            .fit().centerCrop()
                            .into(imagentriceps3);
                }

                if (ejercicioseleccionadotriceps3.equals("Press cerrado en smith")) {
                    int reps = 10;
                    String repestriceps = Integer.toString(reps);
                    repeticionestriceps3.setText(repestriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20en%20smith%2F20211211_134356.jpg?alt=media&token=97ae02ab-aed5-4fe5-87d9-9bb75453bcdf")
                            .fit().centerCrop()
                            .into(imagentriceps3);
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

                //frontal

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

                if ( ejercicioseleccionadoabdomen.equals("Crunch acostado en flexión de piernas")) {
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

                if ( ejercicioseleccionadoabdomen.equals("Toques al talón")) {
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
                if ( ejercicioseleccionadoabdomen3.equals("Crunch abdominal en maquina con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20maquina%20con%20cuerda%2F20210203_122801.jpg?alt=media&token=b7b6492d-0e43-4d80-8e4a-58a874b0b740")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch abdominal")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121917.jpg?alt=media&token=6a7354cf-d38a-4931-ae6d-3bd5a0a6f1a1")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch abdominal en maquina")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123647.jpg?alt=media&token=21d241b4-69a6-4e42-8f6b-d8eab01d5e16")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Rodillo abdominal")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112445.jpg?alt=media&token=65fbc2e2-c04e-4300-af76-36ba341c3a1b")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Elevaciones de piernas acostado en banco")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854.jpg?alt=media&token=9cab081e-a91e-40ef-8be1-e481445eddd1")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Elevaciones de piernas en silla romana")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112604.jpg?alt=media&token=a27b1953-a16e-419b-b206-ad01ebf5138d")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch tipo bicicleta")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch abdominal en banco declinado")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113147.jpg?alt=media&token=55b3d636-887e-4c01-ba37-e274fce2e1d1")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch abdominal en banco declinado con balon en la nuca")) {
                    int reps = 8;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113217.jpg?alt=media&token=a6ad17e7-d218-41c7-9412-b26ffd74fc38")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch acostado en flexión de piernas")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20con%20flexi%C3%B3n%20de%20piernas%2F20211210_113340.jpg?alt=media&token=063a87c6-0413-4e4f-b103-8e1892a93987")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch lateral")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113437.jpg?alt=media&token=eccbfefe-6820-4879-b370-0ccb1454573e")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Toques al talón")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113834.jpg?alt=media&token=3521bce4-bbd0-4936-9994-1df7bd3f72d4")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch lateral con polea alta")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113702.jpg?alt=media&token=1717a072-a610-449b-8a35-3dec01aded1a")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
                }

                if ( ejercicioseleccionadoabdomen3.equals("Crunch abdominal hincado con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesabdomen3.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112931.jpg?alt=media&token=6dc6d69c-958a-4c9d-b5c3-0cd990fde57a")
                            .fit().centerCrop()
                            .into(imagenabdomen3);
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

                if ( ejercicioseleccionadoabdomen2.equals("Crunch acostado en flexión de piernas")) {
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

                if ( ejercicioseleccionadoabdomen2.equals("Toques al talón")) {
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

                String ejerciciopecho = datasnapshot.child("pectoral/ ejercicio primario").getValue().toString();
                String ejerciciopecho2 = datasnapshot.child("pectoral/ ejercicio secundario").getValue().toString();
                String ejerciciopecho3 = datasnapshot.child("pectoral/ ejercicio tercero").getValue().toString();

                String ejerciciotriceps = datasnapshot.child("triceps/ ejercicio primario").getValue().toString();
                String ejerciciotriceps2 = datasnapshot.child("triceps/ ejercicio secundario").getValue().toString();
                String ejerciciotriceps3 = datasnapshot.child("triceps/ ejercicio tercero").getValue().toString();

                String ejerciciofrontal = datasnapshot.child("deltoide frontal/ ejercicio primario").getValue().toString();
                String ejerciciofrontal2 = datasnapshot.child("deltoide frontal/ ejercicio secundario").getValue().toString();

                String ejercicioabdomen = datasnapshot.child("abdominales/ ejercicio primario").getValue().toString();
                String ejercicioabdomen2 = datasnapshot.child("abdominales/ ejercicio secundario").getValue().toString();
                String ejercicioabdomen3 = datasnapshot.child("abdominales/ ejercicio tercero").getValue().toString();






                //RER INICIAL 3 - 4 Y 2 - 3
                if(rer1int >= 18) {




                    //abdomen
                    switch(ejercicioabdomen){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer14.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer14.setText("3 - 4 RER");
                            break;

                        case "Rodillo abdominal":
                            rer14.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer14.setText("3 - 4 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer14.setText("3 - 4 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer14.setText("3 - 4 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Plancha":
                            rer14.setText("-");
                            break;

                        case "Toques al talón":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Crunch lateral":
                            rer14.setText("2 - 3 RER");
                            break;

                    }



                    //abdomen
                    switch(ejercicioabdomen2){
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

                        case "Toques al talón":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer15.setText("2 - 3 RER");
                            break;

                        case "Crunch lateral":
                            rer15.setText("2 - 3 RER");
                            break;

                    }




                    //abdomen
                    switch(ejercicioabdomen3){
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

                        case "Toques al talón":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer16.setText("2 - 3 RER");
                            break;

                        case "Crunch lateral":
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







                    //FRONTAL
                    switch(ejerciciofrontal){
                        //ejercicios compuestos
                        case "Press militar con barra":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Press militar con mancuernas":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Push press":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Press militar en smith":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Press en máquina agarre prono":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Press Arnold":
                            rer10.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Press en máquina agarre neutro":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre prono":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con mancuerna agarre supino":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con polea baja a 1 brazo":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con disco":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontal con cuerda en polea baja":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre neutro":
                            rer10.setText("2 - 3 RER");
                            break;

                    }

                    switch(ejerciciofrontal2){
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


                    //triceps
                    switch(ejerciciotriceps2){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Press cerrado en smith":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Copa con barra":
                            rer5.setText("3 - 4 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer5.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Fondos en máquina":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer5.setText("2 - 3 RER");
                            break;

                    }



                    //triceps
                    switch(ejerciciotriceps3){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Press cerrado en smith":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Copa con barra":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer7.setText("3 - 4 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Fondos en máquina":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer7.setText("2 - 3 RER");
                            break;

                    }












//--------------------------------------


                }
                // RER FINAL  1 - 2 Y 0 - 1

                if (rer1int <= 12){



                    switch(ejercicioabdomen){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Rodillo abdominal":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer14.setText("1 - 2 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Crunch abdominal":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Plancha":
                            rer14.setText("-");
                            break;

                        case "Toques al talón":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer14.setText("0 - 1 RER");
                            break;

                        case "Crunch lateral":
                            rer14.setText("0 - 1 RER");
                            break;

                    }



                    //abdomen
                    switch(ejercicioabdomen2){
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

                        case "Toques al talón":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer15.setText("0 - 1 RER");
                            break;

                        case "Crunch lateral":
                            rer15.setText("0 - 1 RER");
                            break;

                    }




                    //abdomen
                    switch(ejercicioabdomen3){
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

                        case "Toques al talón":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer16.setText("0 - 1 RER");
                            break;

                        case "Crunch lateral":
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






                    //FRONTAL
                    switch(ejerciciofrontal){
                        //ejercicios compuestos
                        case "Press militar con barra":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Press militar con mancuernas":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Push press":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Press militar en smith":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Press en máquina agarre prono":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Press Arnold":
                            rer10.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Press en máquina agarre neutro":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre prono":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con mancuerna agarre supino":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con polea baja a 1 brazo":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con disco":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontal con cuerda en polea baja":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre neutro":
                            rer10.setText("0 - 1 RER");
                            break;

                    }

                    //FRONTAL
                    switch(ejerciciofrontal2){
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


                    switch(ejerciciotriceps2){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Press cerrado en smith":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Copa con barra":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer5.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Fondos en máquina":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer5.setText("0 - 1 RER");
                            break;

                    }


                    switch(ejerciciotriceps3){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Press cerrado en smith":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Copa con barra":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer7.setText("1 - 2 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Fondos en máquina":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer7.setText("0 - 1 RER");
                            break;

                    }









                }

                // RER MEDIO 2 - 3  Y 1 - 2

                if (rer1int>13 && rer1int<=17){

                    switch(ejercicioabdomen){
                        //ejercicios compuestos
                        case "Crunch abdominal en maquina":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en maquina con cuerda":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Rodillo abdominal":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal hincado con cuerda":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Crunch tipo bicicleta":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Crunch abdominal en banco declinado con balon en la nuca":
                            rer14.setText("2 - 3 RER");
                            break;


                        //ejercicios csimples
                        case "Elevaciones de piernas acostado en banco":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de piernas en silla romana":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Crunch lateral con polea alta":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal en banco declinado":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Crunch abdominal":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Plancha":
                            rer14.setText("-");
                            break;

                        case "Toques al talón":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Crunch lateral":
                            rer14.setText("1 - 2 RER");
                            break;

                    }



                    //abdomen
                    switch(ejercicioabdomen2){
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

                        case "Toques al talón":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer15.setText("1 - 2 RER");
                            break;

                        case "Crunch lateral":
                            rer15.setText("1 - 2 RER");
                            break;

                    }




                    //abdomen
                    switch(ejercicioabdomen3){
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

                        case "Toques al talón":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer16.setText("1 - 2 RER");
                            break;

                        case "Crunch lateral":
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


                    //FRONTAL
                    switch(ejerciciofrontal2){
                        //ejercicios compuestos
                        case "Press militar con barra":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Press militar con mancuernas":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Push press":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Press militar en smith":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Press en máquina agarre prono":
                            rer14.setText("2 - 3 RER");
                            break;

                        case "Press Arnold":
                            rer14.setText("2 - 3 RER");
                            break;




                        //ejercicios simples
                        case "Press en máquina agarre neutro":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre prono":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con mancuerna agarre supino":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con polea baja a 1 brazo":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con disco":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontal con cuerda en polea baja":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Elevaciones frontales con mancuernas agarre neutro":
                            rer14.setText("1 - 2 RER");
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

                    switch(ejerciciotriceps3){
                        //ejercicios compuestos
                        case "Press cerrado con barra":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Press cerrado en smith":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Rompecraneos con barra z":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Rompecraneos con mancuernas":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Copa con barra":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Copa con mancuerna sentado":
                            rer12.setText("2 - 3 RER");
                            break;




                        //ejercicios simples
                        case "Copa con mancuerna a 1 brazo":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps en máquina":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Fondos en máquina":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps en polea alta con maneral recto":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps a 1 brazo agarre supino":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Patada para tríceps a 1 brazo":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Extensiones de tríceps con cuerda":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Patada para tríceps con polea":
                            rer12.setText("1 - 2 RER");
                            break;

                    }









                }




//-------------------------------------------------------------------------------------------------------------------------------------------------------------

                //SERIES



                String slateral = datasnapshot.child("series pectoral").getValue().toString();
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
                seriespectoral.setText(seriesfinallateral + " Series");
                seriespectoral2.setText(seriesfinallateral2 + " Series");
                seriespectoral3.setText(seriesfinallateral3 + " Series");



                String scuadriceps = datasnapshot.child("series triceps").getValue().toString();
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
                seriestriceps.setText(seriesfinalcuad + " Series");
                seriestriceps2.setText(seriesfinalcuad2 + " Series");
                seriestriceps3.setText(seriesfinalcuad3 + " Series");



                String sfemorales = datasnapshot.child("series deltoide frontal").getValue().toString();
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
                seriesfrontal.setText(seriesfinalfemorales + " Series");
                seriesfrontal2.setText(seriesfinalfemorales2 + " Series");



                String sgluteos = datasnapshot.child("series abdominales").getValue().toString();
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
                int sgluteosint3 = (int) Math.round(sgluteosf3);
                if (sgluteosint3 == 1){
                    sgluteosint3++;
                }
                String seriesgluteosfinal = String.valueOf(sgluteosint);
                String seriesgluteosfinal2 = String.valueOf(sgluteosint2);
                String seriesgluteosfinal3 = String.valueOf(sgluteosint3);
                seriesabdomen.setText(seriesgluteosfinal + " Series");
                seriesabdomen2.setText(seriesgluteosfinal2 + " Series");
                seriesabdomen3.setText(seriesgluteosfinal3 + " Series");







                String stringpesoinicial = datasnapshot.child("Historial pectoral/ 6 dias/ primer ejercicio/ dia 1").getValue().toString();
                peso1.setText(stringpesoinicial);

                String stringpesoinicial2 = datasnapshot.child("Historial pectoral/ 6 dias/ segundo ejercicio/ dia 1").getValue().toString();
                peso2.setText(stringpesoinicial2);

                String stringpesoinicial3 = datasnapshot.child("Historial pectoral/ 6 dias/ tercer ejercicio/ dia 1").getValue().toString();
                peso3.setText(stringpesoinicial3);




                String stringpesoinicialtriceps = datasnapshot.child("Historial triceps/ 6 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesotriceps.setText(stringpesoinicialtriceps);

                String stringpesoinicialtriceps2 = datasnapshot.child("Historial triceps/ 6 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesotriceps2.setText(stringpesoinicialtriceps2);

                String stringpesoinicialtriceps3 = datasnapshot.child("Historial triceps/ 6 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesotriceps3.setText(stringpesoinicialtriceps3);



                String stringpesoinicialfrontal = datasnapshot.child("Historial frontal/ 6 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesofrontal.setText(stringpesoinicialfrontal);

                String stringpesoinicialfrontal2 = datasnapshot.child("Historial frontal/ 6 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesofrontal2.setText(stringpesoinicialfrontal2);




                String stringpesoinicialtrapecios21 = datasnapshot.child("Historial abdomen/ 6 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesoabdomen.setText(stringpesoinicialtrapecios21);

                String stringpesoinicialtrapecios22 = datasnapshot.child("Historial abdomen/ 6 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesoabdomen2.setText(stringpesoinicialtrapecios22);

                String stringpesoinicialtrapecios23 = datasnapshot.child("Historial abdomen/ 6 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesoabdomen3.setText(stringpesoinicialtrapecios23);













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

        pesotriceps3.addTextChangedListener(new TextWatcher() {
                                                @Override
                                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void afterTextChanged(Editable editable) {
                                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesotriceps3.getContext());
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


        pesoabdomen3.addTextChangedListener(new TextWatcher() {
                                                @Override
                                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void afterTextChanged(Editable editable) {
                                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesoabdomen3.getContext());
                                                    preferences.edit().putString("editText",editable.toString()).commit();



                                                }
                                            }
        );


        rer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diajuevesmujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diajuevesmujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diajuevesmujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diajuevesmujer.this, rer.class);
                startActivity(intent);
            }
        });


        rer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diajuevesmujer.this, rer.class);
                startActivity(intent);
            }
        });




        rer7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diajuevesmujer.this, rer.class);
                startActivity(intent);
            }
        });





        rer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diajuevesmujer.this, rer.class);
                startActivity(intent);
            }
        });

        rer11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diajuevesmujer.this, rer.class);
                startActivity(intent);
            }
        });




        rer14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diajuevesmujer.this, rer.class);
                startActivity(intent);
            }
        });



        rer15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diajuevesmujer.this, rer.class);
                startActivity(intent);
            }
        });


        rer16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entreno6diajuevesmujer.this, rer.class);
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

    public void findelentrenamiento16 (View view){


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
                    mInterstitialAd.show(entreno6diajuevesmujer.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }

            }
        }, 1000);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();

        String datoejercicio1 = peso1.getText().toString();
        String datoejercicio1_2 = peso2.getText().toString();
        String datoejercicio1_3 = peso3.getText().toString();


        String datoejercicio4 = pesotriceps.getText().toString();
        String datoejercicio4_2 = pesotriceps2.getText().toString();
        String datoejercicio4_3 = pesotriceps2.getText().toString();

        String datoejercicio5 = pesofrontal.getText().toString();
        String datoejercicio6 = pesofrontal2.getText().toString();

        String datoabs = pesoabdomen.getText().toString();
        String datoabs2 = pesoabdomen2.getText().toString();
        String datoabs3 = pesoabdomen3.getText().toString();



        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                Map<String, Object> pesoactualizandose2 = new HashMap<>();
                pesoactualizandose2.put("Historial pectoral/ 6 dias/ primer ejercicio/ dia 1", datoejercicio1);
                pesoactualizandose2.put("Historial pectoral/ 6 dias/ segundo ejercicio/ dia 1", datoejercicio1_2);
                pesoactualizandose2.put("Historial pectoral/ 6 dias/ tercer ejercicio/ dia 1", datoejercicio1_3);


                pesoactualizandose2.put("Historial triceps/ 6 dias/ primer ejercicio/ dia 1", datoejercicio4);
                pesoactualizandose2.put("Historial triceps/ 6 dias/ segundo ejercicio/ dia 1", datoejercicio4_2);
                pesoactualizandose2.put("Historial triceps/ 6 dias/ tercer ejercicio/ dia 1", datoejercicio4_3);


                pesoactualizandose2.put("Historial frontal/ 6 dias/ primer ejercicio/ dia 1", datoejercicio5);
                pesoactualizandose2.put("Historial frontal/ 6 dias/ segundo ejercicio/ dia 1", datoejercicio6);

                pesoactualizandose2.put("Historial abdomen/ 6 dias/ primer ejercicio/ dia 1", datoabs);
                pesoactualizandose2.put("Historial abdomen/ 6 dias/ segundo ejercicio/ dia 1", datoabs2);
                pesoactualizandose2.put("Historial abdomen/ 6 dias/ tercer ejercicio/ dia 1", datoabs3);







                mDatabase.child("Users").child(id).updateChildren(pesoactualizandose2);


                //si se modifica el datachange en algun otro momento envia a esta pantalla, por lo cual se condiciona el envio
                boolean botonpresionado = true;

                if (botonpresionado == true){



                    Intent findelentrenamiento = new Intent(entreno6diajuevesmujer.this, entrenamientofinalizado.class);

                    String valor2 = getIntent().getExtras().getString("actual");
                    findelentrenamiento.putExtra("actual", valor2);
                    findelentrenamiento.putExtra("entreno?", "sidia4");

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
                Intent ejercicio = new Intent(entreno6diajuevesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno6diajuevesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno6diajuevesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno6diajuevesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno6diajuevesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("triceps/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno6diajuevesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno6diajuevesmujer.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno6diajuevesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("abdominales/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno6diajuevesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("abdominales/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno6diajuevesmujer.this, ejercicio.class);

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
                String ej = datasnapshot.child("abdominales/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno6diajuevesmujer.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }





}
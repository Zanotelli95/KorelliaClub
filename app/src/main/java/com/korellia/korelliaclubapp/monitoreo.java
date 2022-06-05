package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

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

import java.util.HashMap;
import java.util.Map;

public class monitoreo extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    RadioButton r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r58, r59, r60, r61;
    private FirebaseAuth mAuth;
    private DatabaseReference mRootReference;
    private DatabaseReference mDatabase;
    int valor1, valor2, valor3, valor4;
    double sumatotal, seriespectoralsuma, seriespectoral,
                        seriesespaldasuma, seriesespalda,
                        seriesbicepssuma, seriesbiiceps,
                        seriestricepssuma, seriestriceps,
                        seriescuadssuma, seriescuads,
                        seriesfemoralessuma, seriesfemorales,
                        seriesfrontalsuma, seriesfrontal,
                        serieslateralsuma, serieslateral,
                        seriespantorrillassuma, seriespantorrillas,
                        seriesgluteossuma, seriesgluteos,
                        seriestrapssuma, seriestraps,
                        seriesabssuma,  seriesabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoreo);



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


        Toolbar toolbar = findViewById(R.id.toolbarmonitoreo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Monitoreo");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();
        mRootReference = FirebaseDatabase.getInstance().getReference();

        r46 = (RadioButton)  findViewById(R.id.radioButton46);
        r47 = (RadioButton)  findViewById(R.id.radioButton47);
        r48 = (RadioButton)  findViewById(R.id.radioButton48);
        r49 = (RadioButton)  findViewById(R.id.radioButton49);

        r50 = (RadioButton)  findViewById(R.id.radioButton50);
        r51 = (RadioButton)  findViewById(R.id.radioButton51);
        r52 = (RadioButton)  findViewById(R.id.radioButton52);

        r53 = (RadioButton)  findViewById(R.id.radioButton53);
        r54 = (RadioButton)  findViewById(R.id.radioButton54);
        r55 = (RadioButton)  findViewById(R.id.radioButton55);
        r56 = (RadioButton)  findViewById(R.id.radioButton56);

        r58 = (RadioButton)  findViewById(R.id.radioButton58);
        r59 = (RadioButton)  findViewById(R.id.radioButton59);
        r60 = (RadioButton)  findViewById(R.id.radioButton60);
        r61 = (RadioButton)  findViewById(R.id.radioButton61);



        String id = mAuth.getCurrentUser().getUid();

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                //obtiene series actuales y las suma
                String ejercicio = datasnapshot.child("series pectoral").getValue().toString();
                seriespectoral = Double.parseDouble(ejercicio);

                String espaldaejercicio = datasnapshot.child("series espalda").getValue().toString();
                seriesespalda = Double.parseDouble(espaldaejercicio);

                String bicepsejercicio = datasnapshot.child("series biceps").getValue().toString();
                seriesbiiceps = Double.parseDouble(bicepsejercicio);

                String tricepsejercicio = datasnapshot.child("series triceps").getValue().toString();
                seriestriceps = Double.parseDouble(tricepsejercicio);

                String frontalejercicio = datasnapshot.child("series deltoide frontal").getValue().toString();
                seriesfrontal = Double.parseDouble(frontalejercicio);

                String lateralejercicio = datasnapshot.child("series deltoides laterales y posteriores").getValue().toString();
                serieslateral = Double.parseDouble(lateralejercicio);

                String pantorrillasejercicio = datasnapshot.child("series pantorrillas").getValue().toString();
                seriespantorrillas = Double.parseDouble(pantorrillasejercicio);

                String trapeciosejercicio = datasnapshot.child("series trapecios").getValue().toString();
                seriestraps = Double.parseDouble(trapeciosejercicio);

                String gluteosejercicio = datasnapshot.child("series gluteos").getValue().toString();
                seriesgluteos = Double.parseDouble(gluteosejercicio);

                String absejercicio = datasnapshot.child("series abdominales").getValue().toString();
                seriesabs = Double.parseDouble(absejercicio);

                String cuadsejercicio = datasnapshot.child("series cuadriceps").getValue().toString();
                seriescuads = Double.parseDouble(cuadsejercicio);

                String femoejercicio = datasnapshot.child("series femorales").getValue().toString();
                seriesfemorales = Double.parseDouble(femoejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    public void semana (View view){


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
                    mInterstitialAd.show(monitoreo.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }

            }
        }, 300);




        if (view.getId()==R.id.button31 && r46.isChecked() || r47.isChecked() || r48.isChecked() || r49.isChecked()){

            if (  r46.isChecked() ) {
                 valor1 = 8;
            }
            if (  r47.isChecked() ) {
                valor1 = 6;
            }
            if (  r48.isChecked() ) {
                valor1 = 4;
            }
            if (  r49.isChecked() ) {
                valor1 = 2;
            }


            if ( r50.isChecked() || r51.isChecked() || r52.isChecked() ) {

                if (  r50.isChecked() ) {
                    valor2 = 3;
                }
                if (  r51.isChecked() ) {
                    valor2 = 2;
                }
                if (  r52.isChecked() ) {
                    valor2 = 1;
                }

                if (  r53.isChecked() || r54.isChecked() || r55.isChecked() || r56.isChecked() ) {

                    if (  r53.isChecked() ) {
                        valor3 = 4;
                    }
                    if (  r54.isChecked() ) {
                        valor3 = 3;
                    }
                    if (  r55.isChecked() ) {
                        valor3 = 2;
                    }
                    if (  r56.isChecked() ) {
                        valor3 = 1;
                    }


                    if ( r58.isChecked() || r59.isChecked() || r60.isChecked() || r61.isChecked()) {

                        if (  r58.isChecked() ) {
                            valor4 = 8;
                        }
                        if (  r59.isChecked() ) {
                            valor4 = 6;
                        }
                        if (  r60.isChecked() ) {
                            valor4 = 4;
                        }
                        if (  r61.isChecked() ) {
                            valor4 = 2;
                        }



                        int sumasseriesfinales = valor1 + valor2 + valor3+ valor4;

                        if ( sumasseriesfinales <= 8 ) {
                            String id = mAuth.getCurrentUser().getUid();
                            Map<String, Object> rer = new HashMap<>();
                            rer.put("progresosrer", "20");
                            mDatabase.child("Users").child(id).updateChildren(rer);


                           //     Intent intent = new Intent (monitoreo.this, nuevobloque.class);
                            //    startActivity(intent);
                             //   finish();

                        }
                        if ( sumasseriesfinales  >= 9 || sumasseriesfinales <= 10 ) {
                            String id = mAuth.getCurrentUser().getUid();
                            Map<String, Object> rer = new HashMap<>();
                            rer.put("progresosrer", sumasseriesfinales);
                            mDatabase.child("Users").child(id).updateChildren(rer);

                             sumatotal =  1.0;



                        }
                        if ( sumasseriesfinales  >= 11 || sumasseriesfinales <= 16  ) {
                            String id = mAuth.getCurrentUser().getUid();
                            Map<String, Object> rer = new HashMap<>();
                            rer.put("progresosrer", sumasseriesfinales);
                            mDatabase.child("Users").child(id).updateChildren(rer);

                            sumatotal = 2.0;



                        }
                        if (  sumasseriesfinales  >= 17 || sumasseriesfinales <= 19 ) {
                            String id = mAuth.getCurrentUser().getUid();
                            Map<String, Object> rer = new HashMap<>();
                            rer.put("progresosrer", sumasseriesfinales);
                            mDatabase.child("Users").child(id).updateChildren(rer);

                             sumatotal =  3.0;




                        }
                        if (  sumasseriesfinales  >= 20 ) {
                            String id = mAuth.getCurrentUser().getUid();
                            Map<String, Object> rer = new HashMap<>();
                            rer.put("progresosrer", sumasseriesfinales);
                            mDatabase.child("Users").child(id).updateChildren(rer);

                             sumatotal =  4.0;




                        }








                    }else {
                        String responde="Llena todos los campos";
                        Toast.makeText(getApplicationContext(),responde,Toast.LENGTH_SHORT).show();
                    }


                }else {
                    String responde="Llena todos los campos";
                    Toast.makeText(getApplicationContext(),responde,Toast.LENGTH_SHORT).show();
                }


            }else {
                String responde="Llena todos los campos";
                Toast.makeText(getApplicationContext(),responde,Toast.LENGTH_SHORT).show();
            }




        }else {
            String responde="Llena todos los campos";
            Toast.makeText(getApplicationContext(),responde,Toast.LENGTH_SHORT).show();
        }





        String id = mAuth.getCurrentUser().getUid();
        seriespectoralsuma = sumatotal + seriespectoral;
        seriesespaldasuma = sumatotal + seriesespalda;
        seriesfrontalsuma = sumatotal + seriesfrontal;
        serieslateralsuma = sumatotal + serieslateral;
        seriesabssuma = sumatotal + seriesabs;
        seriesbicepssuma = sumatotal + seriesbiiceps;
        seriestricepssuma = sumatotal + seriestriceps;
        seriescuadssuma = sumatotal + seriescuads;
        seriesfemoralessuma = sumatotal + seriesfemorales;
        seriesgluteossuma = sumatotal + seriesgluteos;
        seriestrapssuma = sumatotal + seriestraps;
        seriespantorrillassuma = sumatotal + seriespantorrillas;



        //actualiza
        Map<String, Object> editarseries = new HashMap<>();
        editarseries.put("series pectoral", seriespectoralsuma);
        editarseries.put("series espalda", seriesespaldasuma);
        editarseries.put("series deltoide frontal", seriesfrontalsuma);
        editarseries.put("series deltoides laterales y posteriores", serieslateralsuma);
        editarseries.put("series abdominales", seriesabssuma);
        editarseries.put("series biceps", seriesbicepssuma);
        editarseries.put("series triceps", seriestricepssuma);
        editarseries.put("series cuadriceps", seriescuadssuma);
        editarseries.put("series femorales", seriesfemoralessuma);
        editarseries.put("series gluteos", seriesgluteossuma);
        editarseries.put("series trapecios", seriestrapssuma);
        editarseries.put("series pantorrillas", seriespantorrillassuma);




        mDatabase.child("Users").child(id).updateChildren(editarseries);

        finish();


//lleva a la actividad correspondiente con el monitoreo resuelto



        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snap) {
                String destino = snap.child("progresosrer").getValue().toString();
               int destinoint = Integer.parseInt(destino);



                if ( destinoint <= 8 ) {


                    Intent intent = new Intent (monitoreo.this, monitoreofinalizado.class);
                    startActivity(intent);
                    finish();

                }
                if ( destinoint  >= 9 || destinoint <= 10 ) {

                    Intent intent = new Intent (monitoreo.this, monitoreofinalizado.class);
                    startActivity(intent);
                    finish();


                }
                if ( destinoint  >= 11 || destinoint <= 16  ) {

                    Intent intent = new Intent (monitoreo.this, monitoreofinalizado.class);
                    startActivity(intent);
                    finish();


                }
                if (  destinoint  >= 17 || destinoint <= 19 ) {


                    Intent intent = new Intent (monitoreo.this, monitoreofinalizado.class);
                    startActivity(intent);
                    finish();


                }
                if (  destinoint  >= 20 ) {

                    Intent intent = new Intent (monitoreo.this, monitoreofinalizado.class);
                    startActivity(intent);
                    finish();



                }





            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(monitoreo.this, MainActivity.class);
        startActivity(intent);
    }

    public void onDestroy() { super.onDestroy(); }


}
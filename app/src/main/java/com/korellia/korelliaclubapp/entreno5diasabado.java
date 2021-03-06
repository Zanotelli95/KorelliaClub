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

public class entreno5diasabado extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private EditText pesolateral, pesocuadriceps, pesofemoral, pesogluteos, pesopantorrillas, pesocuadriceps2,
            pesocuadriceps3, pesofemora2, pesofemoral3, pesolateral2, pesolateral3, pesogluteos2, pesopantorrillas2;
    private String  ejercicioseleccionadocuadriceps, ejercicioseleccionadofemoral, ejercicioseleccionadolateral;
    private TextView rer1, rer2, rer3, rer4, rer5, rer6, rer7, rer8, rer9, rer10, rer11, rer12, rer13, rer14;
    private String  ejercicioseleccionadofemoral2, ejercicioseleccionadolateral2, ejercicioseleccionadofemoral3,  ejercicioseleccionadolateral3,
            ejercicioseleccionadogluteos, ejercicioseleccionadogluteos2, ejercicioseleccionadopantorrillas2, ejercicioseleccionadopantorrillas;
    private TextView fechacompleta;
    private TextView  serieslateral, seriescuadriceps, seriesfemoral, seriespantorrillas, seriesgluteos;
    private Spinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8, spinner9, spinner10, spinner11, spinner12;
    private  TextView  ejerciciopantorrillas2, ejerciciolateral, repeticioneslateral, repeticionesfemoral, repeticionesfemoral2, repeticionesfemoral3,
            ejerciciocuadriceps, repeticionescuadriceps, ejerciciofemoral,  ejerciciogluteos, repeticionesgluteos,
            ejerciciopantorrillas;
    private ImageView  imagencuadriceps, imagencuadriceps2, imagencuadriceps3, imagenfemoral, imagengluteos, imagenpantorrillas,
            imagenfemoral3, imagenlaterales2, imagenlaterales3, imagengluteos2, imagenpantorrillas2;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private ImageView imagencuadriceps4,imagenlateral, imagenfemoral2;
    private TextView seriespantorrillas2, ejerciciolateral2;
    private TextView  ejerciciofemoral2, repeticioneslateral2, ejerciciolateral3, repeticioneslateral3, serieslateral3, serieslateral2,
            ejerciciogluteos2, seriesgluteos2,  ejerciciofemoral3, seriesfemoral2, seriesfemoral3,
            ejerciciocuadriceps2, ejerciciocuadriceps3, ejerciciocuadriceps4, seriescuadriceps2, seriescuadriceps3, seriescuadriceps4,
            pesocuadriceps4, repeticionescuadriceps2, repeticionesgluteos2, repeticionespantorrillas, repeticionespantorrillas2,repeticionescuadriceps3, repeticionescuadriceps4;
    private String ejercicioseleccionadocuadriceps2, ejercicioseleccionadocuadriceps3, ejercicioseleccionadocuadriceps4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_entreno5diasabado);


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

        fechacompleta = (TextView) findViewById(R.id.textView279);
        Date date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("d MMM yyyy");
        String sfecha = fecha.format(date);
        fechacompleta.setText(sfecha);

        Toolbar toolbar = findViewById(R.id.toolbarentreno5diasabado);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Entrenamiento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        spinner1= (Spinner) findViewById(R.id.spinner1v);
        spinner2= (Spinner) findViewById(R.id.spinner2v);
        spinner3= (Spinner) findViewById(R.id.spinner3v);

        spinner4= (Spinner) findViewById(R.id.spinner4v);
        spinner5= (Spinner) findViewById(R.id.spinner5v);
        spinner6= (Spinner) findViewById(R.id.spinner6v);

        spinner7= (Spinner) findViewById(R.id.spinner7v);
        spinner8= (Spinner) findViewById(R.id.spinner8v);

        spinner9= (Spinner) findViewById(R.id.spinner9v);
        spinner10= (Spinner) findViewById(R.id.spinner10v);

        spinner11= (Spinner) findViewById(R.id.spinner11v);

        spinner12= (Spinner) findViewById(R.id.spinner12v);







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



        rer1 = findViewById(R.id.rer1quadsentreno5diasabado);
        rer2 = findViewById(R.id.rer2quadsentreno5diasabado);
        rer3 = findViewById(R.id.rer3quadsentreno5disabado);
        rer4 = findViewById(R.id.rer4quadsentreno5diasabado);

        rer5 = findViewById(R.id.rer1isquiosentreno5diasabado);
        rer6 = findViewById(R.id.rer2isquiosentreno5diasabado);
        rer7 = findViewById(R.id.rer3isquiosentreno5diasabado);

        rer8 = findViewById(R.id.rer1gluteosentreno5diasabado);
        rer9 = findViewById(R.id.rer2gluteosentreno5diasabado);

        rer10 = findViewById(R.id.rer1deltoidesentreno5diasabado);
        rer11 = findViewById(R.id.rer2deltoidesentreno5diasabado);
        rer12 = findViewById(R.id.rer3deltoidesentreno5diasabado);

        rer13 = findViewById(R.id.rer1pantorrillasentreno5diasabado);
        rer14 = findViewById(R.id.rer2pantorrillasentreno5diasabado);




        //cuadriceps 4
        ejerciciocuadriceps = (TextView) findViewById(R.id.nombrequadsentreno5diasabado);
        repeticionescuadriceps = (TextView) findViewById(R.id.repes1quadsentreno5diasabado);
        imagencuadriceps = (ImageView) findViewById(R.id.imagen1quadsentreno5diasabado);
        pesocuadriceps = (EditText) findViewById(R.id.peso1quadsentreno5diasabado);
        seriescuadriceps = (TextView) findViewById(R.id.series1quadsentreno5diasabado);


        ejerciciocuadriceps2 = (TextView) findViewById(R.id.nombre2quadsentreno5diasabado);
        repeticionescuadriceps2 = (TextView) findViewById(R.id.repes2quadsentreno5diasabado);
        imagencuadriceps2 = (ImageView) findViewById(R.id.imagen2quadsentreno5diasabado);
        pesocuadriceps2 = (EditText) findViewById(R.id.peso2quadsentreno5diasabado);
        seriescuadriceps2 = (TextView) findViewById(R.id.series2quadsentreno5diasabado);


        ejerciciocuadriceps3 = (TextView) findViewById(R.id.nombre3quadsentreno5diasabado);
        repeticionescuadriceps3 = (TextView) findViewById(R.id.repes3quadsentreno5diasabado);
        imagencuadriceps3 = (ImageView) findViewById(R.id.imagen3quadsentreno5diasabado);
        pesocuadriceps3 = (EditText) findViewById(R.id.peso3quadsentreno5diasabado);
        seriescuadriceps3 = (TextView) findViewById(R.id.series3quadsentreno5diasabado);


        ejerciciocuadriceps4 = (TextView) findViewById(R.id.nombre4quadsentreno5diasabado);
        repeticionescuadriceps4 = (TextView) findViewById(R.id.repes4quadsentreno5diasabado);
        imagencuadriceps4 = (ImageView) findViewById(R.id.imagen4quadsentreno5diasabado);
        pesocuadriceps4 = (EditText) findViewById(R.id.peso4quadsentreno5diasabado);
        seriescuadriceps4 = (TextView) findViewById(R.id.series4quadsentreno5diasabado);




        //isquios 2
        ejerciciofemoral = (TextView) findViewById(R.id.nombre1isquiosentreno5diasabado);
        repeticionesfemoral = (TextView) findViewById(R.id.repes1isquiosentreno5diasabado);
        imagenfemoral = (ImageView) findViewById(R.id.image1isquiosentreno5diasabado);
        pesofemoral = (EditText) findViewById(R.id.peso1isquiosentreno5diasabado);
        seriesfemoral = (TextView) findViewById(R.id.series1isquiosentreno5diasabado);

        ejerciciofemoral2 = (TextView) findViewById(R.id.nombre2isquiosentreno5diasabado);
        repeticionesfemoral2 = (TextView) findViewById(R.id.repes2isquiosentreno5diasabado);
        imagenfemoral2 = (ImageView) findViewById(R.id.image2isquiosentreno5diasabado);
        pesofemora2 = (EditText) findViewById(R.id.peso2isquiosentreno5diasabado);
        seriesfemoral2 = (TextView) findViewById(R.id.series2isquiosentreno5diasabado);

        ejerciciofemoral3 = (TextView) findViewById(R.id.nombre3isquiosentreno5diasabado);
        repeticionesfemoral3 = (TextView) findViewById(R.id.repes3isquiosentreno5diasabado);
        imagenfemoral3 = (ImageView) findViewById(R.id.imagen3isquiosentreno5diasabado);
        pesofemoral3 = (EditText) findViewById(R.id.peso3isquiosentreno5diasabado);
        seriesfemoral3 = (TextView) findViewById(R.id.series3isquiosentreno5diasabado);



        //gluteos 2
        ejerciciogluteos = (TextView) findViewById(R.id.nombre1gluteosentreno5diasabado);
        repeticionesgluteos = (TextView) findViewById(R.id.repes1gluteosentreno5diasabado);
        imagengluteos = (ImageView) findViewById(R.id.imagen1gluteosentreno5diasabado);
        pesogluteos = (EditText) findViewById(R.id.peso1gluteosentreno5diasabado);
        seriesgluteos = (TextView) findViewById(R.id.series1gluteosentreno5diasabado);


        ejerciciogluteos2 = (TextView) findViewById(R.id.nombre2gluteosentreno5diasabado);
        repeticionesgluteos2 = (TextView) findViewById(R.id.repes2gluteosentreno5diasabado);
        imagengluteos2 = (ImageView) findViewById(R.id.imagen2gluteosentreno5diasabado);
        pesogluteos2 = (EditText) findViewById(R.id.peso2gluteosentreno5diasabado);
        seriesgluteos2 = (TextView) findViewById(R.id.series2gluteosentreno5diasabado);



        //lateral 1
        ejerciciolateral = (TextView) findViewById(R.id.nombre1deltoidesentreno5diasabado);
        repeticioneslateral = (TextView) findViewById(R.id.repes1deltoidesentreno5diasabado);
        imagenlateral = (ImageView) findViewById(R.id.imagen1deltoidesentreno5diasabado);
        pesolateral = (EditText) findViewById(R.id.peso1deltoidesentreno5diasabado);
        serieslateral = (TextView) findViewById(R.id.series1deltoidesentreno5diasabado);

        ejerciciolateral2 = (TextView) findViewById(R.id.nombre2deltoidesentreno5diasabado);
        repeticioneslateral2 = (TextView) findViewById(R.id.repes2deloitdesentreno5diasabado);
        imagenlaterales2 = (ImageView) findViewById(R.id.imagen2deltoidesentreno5diasabado);
        pesolateral2 = (EditText) findViewById(R.id.peso2deltoidesentreno5diasabado);
        serieslateral2 = (TextView) findViewById(R.id.series2deltoidesentreno5diasabado);

        ejerciciolateral3 = (TextView) findViewById(R.id.nombre3deltoidesentreno5diasabado);
        repeticioneslateral3 = (TextView) findViewById(R.id.repes3deloitdesentreno5diasabado);
        imagenlaterales3 = (ImageView) findViewById(R.id.imagen3deltoidesentreno5diasabado);
        pesolateral3 = (EditText) findViewById(R.id.peso3deltoidesentreno5diasabado);
        serieslateral3 = (TextView) findViewById(R.id.series3deltoidesentreno5diasabado);



        //panto 2
        ejerciciopantorrillas = (TextView) findViewById(R.id.nombre1pantorrillassentreno5diasabado);
        repeticionespantorrillas = (TextView) findViewById(R.id.repes1pantorrillasentreno5diasabado);
        imagenpantorrillas = (ImageView) findViewById(R.id.imagen1pantorrillasentreno5diasabado);
        pesopantorrillas = (EditText) findViewById(R.id.peso1pantorrillasentreno5diasabado);
        seriespantorrillas = (TextView) findViewById(R.id.series1pantorrillasentreno5diasabado);

        ejerciciopantorrillas2 = (TextView) findViewById(R.id.nombre2pantorrillasentreno5diasabado);
        repeticionespantorrillas2 = (TextView) findViewById(R.id.repes2pantorrillasentreno5diasabado);
        imagenpantorrillas2 = (ImageView) findViewById(R.id.imagen2pantorrillasentreno5diapantorrillas);
        pesopantorrillas2 = (EditText) findViewById(R.id.peso2pantorrillasentreno5diasabado);
        seriespantorrillas2 = (TextView) findViewById(R.id.series2pantorrillasentreno5diasabado);





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

                    String ejercicio3 = datasnapshot.child("cuadriceps/ ejercicio tercero").getValue().toString();
                    ejerciciocuadriceps3.setText(ejercicio3);
                    ejercicioseleccionadocuadriceps3 = ejercicio3;

                    String ejercicio4 = datasnapshot.child("cuadriceps/ ejercicio cuarto").getValue().toString();
                    ejerciciocuadriceps4.setText(ejercicio4);
                    ejercicioseleccionadocuadriceps4 = ejercicio4;



                    String stringejerciciofemoral= datasnapshot.child("isquios/ ejercicio primario").getValue().toString();
                    ejerciciofemoral.setText(stringejerciciofemoral);
                    ejercicioseleccionadofemoral = stringejerciciofemoral;

                    String stringejerciciotriceps = datasnapshot.child("isquios/ ejercicio secundario").getValue().toString();
                    ejerciciofemoral2.setText(stringejerciciotriceps);
                    ejercicioseleccionadofemoral2 = stringejerciciotriceps;

                    String stringejerciciofemoral3 = datasnapshot.child("isquios/ ejercicio tercero").getValue().toString();
                    ejerciciofemoral3.setText(stringejerciciofemoral3);
                    ejercicioseleccionadofemoral3 = stringejerciciofemoral3;



                    String stringejerciciobiceps = datasnapshot.child("deltoides laterales y posteriores/ ejercicio primario").getValue().toString();
                    ejerciciolateral.setText(stringejerciciobiceps);
                    ejercicioseleccionadolateral = stringejerciciobiceps;

                    String stringejerciciobiceps2 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio secundario").getValue().toString();
                    ejerciciolateral2.setText(stringejerciciobiceps2);
                    ejercicioseleccionadolateral2 = stringejerciciobiceps2;

                    String stringejerciciofrontal = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();
                    ejerciciolateral3.setText(stringejerciciofrontal);
                    ejercicioseleccionadolateral3 = stringejerciciofrontal;



                    String stringejerciciotricepsf = datasnapshot.child("gluteos y aductores/ ejercicio primario").getValue().toString();
                    ejerciciogluteos.setText(stringejerciciotricepsf);
                    ejercicioseleccionadogluteos = stringejerciciotricepsf;

                    String stringejerciciotriceps2 = datasnapshot.child("gluteos y aductores/ ejercicio secundario").getValue().toString();
                    ejerciciogluteos2.setText(stringejerciciotriceps2);
                    ejercicioseleccionadogluteos2 = stringejerciciotriceps2;




                    String stringejerciciopantorrillas = datasnapshot.child("pantorrillas/ ejercicio primario").getValue().toString();
                    ejerciciopantorrillas.setText(stringejerciciopantorrillas);
                    ejercicioseleccionadopantorrillas = stringejerciciopantorrillas;

                    String stringejerciciofrontal2 = datasnapshot.child("pantorrillas/ ejercicio secundario").getValue().toString();
                    ejerciciopantorrillas2.setText(stringejerciciofrontal2);
                    ejercicioseleccionadopantorrillas2 = stringejerciciofrontal2;




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

                if ( ejercicioseleccionadocuadriceps.equals("Sentadilla en maquina perfecta")) {
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

                if ( ejercicioseleccionadocuadriceps2.equals("Sentadilla en maquina perfecta")) {
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
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
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

//cuadriceps
                if ( ejercicioseleccionadocuadriceps3.equals("Desplantes con mancuernas")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fdesplantes%20con%20mancuernas%2F20210131_112942.jpg?alt=media&token=2b6b25b6-e5c6-4057-be69-bd2cad0c2af6")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionadocuadriceps3.equals("Prensa a 1 pierna")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112525.jpg?alt=media&token=9288507d-1f03-4147-b0d4-b89d491dbc60")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionadocuadriceps3.equals("Prensa a 45??")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115038.jpg?alt=media&token=f8264fd9-f7e9-440b-8557-00aac5fec37d")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionadocuadriceps3.equals("Prensa horizontal en m??quina")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20horizontal%20en%20maquina%2F20210202_115706.jpg?alt=media&token=71099f4e-277a-44f4-9d54-9b86509400a7")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionadocuadriceps3.equals("Sentadilla con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20con%20barra%2F20210206_111054.jpg?alt=media&token=7bb9cf31-7d1f-46b9-aef2-3f92d0d662aa")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionadocuadriceps3.equals("Sentadilla en maquina perfecta")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20en%20maquina%20perfecta%2F20210204_120342.jpg?alt=media&token=30659f89-9cf0-4183-97f8-1022479b30ab")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionadocuadriceps3.equals("Sentadilla frontal con mancuernas")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113031.jpg?alt=media&token=b7055a35-bb96-4797-a082-7fb395bbfee3")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionadocuadriceps3.equals("Sentadilla")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionadocuadriceps3.equals("Sentadilla frontal con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionadocuadriceps3.equals("Sentadilla frontal en smith")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20en%20smith%2F20211211_135602.jpg?alt=media&token=e1b0c3c9-2b6e-446a-9f05-d0651ba1da89")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionadocuadriceps3.equals("Sentadilla smith profunda")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135922.jpg?alt=media&token=ddd7e42b-797b-4103-a384-0b9208546141")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionadocuadriceps3.equals("Sentadilla smith a 90??")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20a%2090%20grados%20en%20smith%2FIMG_0338.jpg?alt=media&token=5a256969-7282-4b20-a9f4-e6801d322f68")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionadocuadriceps3.equals("Sentadilla bulgara con mancuernas")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112831.jpg?alt=media&token=273285a7-7376-4960-a28b-252e1ae4236a")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionadocuadriceps3.equals("Extensiones de cuadriceps en m??quina")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111311.jpg?alt=media&token=fbafd51a-6f5b-48a2-a252-40a61c84f09d")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }



                //cuadriceps
                if ( ejercicioseleccionadocuadriceps4.equals("Desplantes con mancuernas")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps4.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fdesplantes%20con%20mancuernas%2F20210131_112942.jpg?alt=media&token=2b6b25b6-e5c6-4057-be69-bd2cad0c2af6")
                            .fit().centerCrop()
                            .into(imagencuadriceps4);
                }

                if ( ejercicioseleccionadocuadriceps4.equals("Prensa a 1 pierna")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps4.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112525.jpg?alt=media&token=9288507d-1f03-4147-b0d4-b89d491dbc60")
                            .fit().centerCrop()
                            .into(imagencuadriceps4);
                }

                if ( ejercicioseleccionadocuadriceps4.equals("Prensa a 45??")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps4.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115038.jpg?alt=media&token=f8264fd9-f7e9-440b-8557-00aac5fec37d")
                            .fit().centerCrop()
                            .into(imagencuadriceps4);
                }

                if ( ejercicioseleccionadocuadriceps4.equals("Prensa horizontal en m??quina")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps4.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20horizontal%20en%20maquina%2F20210202_115706.jpg?alt=media&token=71099f4e-277a-44f4-9d54-9b86509400a7")
                            .fit().centerCrop()
                            .into(imagencuadriceps4);
                }

                if ( ejercicioseleccionadocuadriceps4.equals("Sentadilla con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps4.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20con%20barra%2F20210206_111054.jpg?alt=media&token=7bb9cf31-7d1f-46b9-aef2-3f92d0d662aa")
                            .fit().centerCrop()
                            .into(imagencuadriceps4);
                }

                if ( ejercicioseleccionadocuadriceps4.equals("Sentadilla en maquina perfecta")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps4.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20en%20maquina%20perfecta%2F20210204_120342.jpg?alt=media&token=30659f89-9cf0-4183-97f8-1022479b30ab")
                            .fit().centerCrop()
                            .into(imagencuadriceps4);
                }

                if ( ejercicioseleccionadocuadriceps4.equals("Sentadilla frontal con mancuernas")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps4.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113031.jpg?alt=media&token=b7055a35-bb96-4797-a082-7fb395bbfee3")
                            .fit().centerCrop()
                            .into(imagencuadriceps4);
                }

                if ( ejercicioseleccionadocuadriceps4.equals("Sentadilla")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps4.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                            .fit().centerCrop()
                            .into(imagencuadriceps4);
                }

                if ( ejercicioseleccionadocuadriceps4.equals("Sentadilla frontal con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps4.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                            .fit().centerCrop()
                            .into(imagencuadriceps4);
                }

                if ( ejercicioseleccionadocuadriceps4.equals("Sentadilla frontal en smith")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps4.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20en%20smith%2F20211211_135602.jpg?alt=media&token=e1b0c3c9-2b6e-446a-9f05-d0651ba1da89")
                            .fit().centerCrop()
                            .into(imagencuadriceps4);
                }

                if ( ejercicioseleccionadocuadriceps4.equals("Sentadilla smith profunda")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps4.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135922.jpg?alt=media&token=ddd7e42b-797b-4103-a384-0b9208546141")
                            .fit().centerCrop()
                            .into(imagencuadriceps4);
                }

                if ( ejercicioseleccionadocuadriceps4.equals("Sentadilla smith a 90??")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps4.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20a%2090%20grados%20en%20smith%2FIMG_0338.jpg?alt=media&token=5a256969-7282-4b20-a9f4-e6801d322f68")
                            .fit().centerCrop()
                            .into(imagencuadriceps4);
                }

                if ( ejercicioseleccionadocuadriceps4.equals("Sentadilla bulgara con mancuernas")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps4.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112831.jpg?alt=media&token=273285a7-7376-4960-a28b-252e1ae4236a")
                            .fit().centerCrop()
                            .into(imagencuadriceps4);
                }

                if ( ejercicioseleccionadocuadriceps4.equals("Extensiones de cuadriceps en m??quina")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps4.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111311.jpg?alt=media&token=fbafd51a-6f5b-48a2-a252-40a61c84f09d")
                            .fit().centerCrop()
                            .into(imagencuadriceps4);
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



                //isquios
                if ( ejercicioseleccionadofemoral3.equals("Curl acostado con mancuerna")) {
                    int reps = 15;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral3.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20acostado%20con%20mancuerna%2F20210308_122433.jpg?alt=media&token=93a79028-afb8-4b92-93d5-23cc097ca721")
                            .fit().centerCrop()
                            .into(imagenfemoral3);
                }

                if ( ejercicioseleccionadofemoral3.equals("Curl femoral parado a 1 pierna en m??quina")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral3.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122852.jpg?alt=media&token=59d7e392-1aad-4c52-a71d-faf7a1224d05")
                            .fit().centerCrop()
                            .into(imagenfemoral3);
                }

                if ( ejercicioseleccionadofemoral3.equals("Curl femoral acostado en m??quina")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral3.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20acostado%20en%20maquina%2F20210202_121632.jpg?alt=media&token=7cb5375f-ee3c-4a14-bf57-ed8aa27dbcf3")
                            .fit().centerCrop()
                            .into(imagenfemoral3);
                }

                if ( ejercicioseleccionadofemoral3.equals("Curl femoral sentado en m??quina")) {
                    int reps = 10;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral3.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20sentado%20en%20maquina%20para%20isquiosurales%2F20210131_103833.jpg?alt=media&token=408960ec-40e6-4a2b-8fb5-8548347d77c5")
                            .fit().centerCrop()
                            .into(imagenfemoral3);
                }

                if ( ejercicioseleccionadofemoral3.equals("Peso muerto a 1 pierna")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral3.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20a%201%20pierna%2F20210131_113706.jpg?alt=media&token=01c3e97b-bc16-4bd3-be7e-2328716e9188")
                            .fit().centerCrop()
                            .into(imagenfemoral3);
                }

                if ( ejercicioseleccionadofemoral3.equals("Peso muerto con mancuernas")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral3.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20mancuernas%2F20210131_113529.jpg?alt=media&token=af2e3ef5-0983-418b-8ccf-94b0f39a5510")
                            .fit().centerCrop()
                            .into(imagenfemoral3);
                }

                if ( ejercicioseleccionadofemoral3.equals("Peso muerto con piernas rigidas con barra")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral3.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20piernas%20r%C3%ADgidas%20con%20barra%2F20210308_120010.jpg?alt=media&token=92155ace-9f79-4981-b5ff-8f6dbe9d9783")
                            .fit().centerCrop()
                            .into(imagenfemoral3);
                }

                if ( ejercicioseleccionadofemoral3.equals("Curl femoral acostado en m??quina a 1 pierna")) {
                    int reps = 10;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral3.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122830(0).jpg?alt=media&token=70aa1e30-89af-46af-9a9e-b3e9b805b93c")
                            .fit().centerCrop()
                            .into(imagenfemoral3);
                }


                if ( ejercicioseleccionadofemoral3.equals("Peso muerto en smith")) {
                    int reps = 10;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral3.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20en%20smith%2F20211211_135441.jpg?alt=media&token=7788cc84-8a01-4bb4-8c6e-258a26be9a98")
                            .fit().centerCrop()
                            .into(imagenfemoral3);
                }


                if ( ejercicioseleccionadofemoral3.equals("Elevaci??n de cadera a una pierna")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral3.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Felevaci%C3%B3n%20de%20cadera%20a%201%20pierna%2F20211211_135110.jpg?alt=media&token=acbc4c3f-9615-440c-bdff-28ebfc54a1ae")
                            .fit().centerCrop()
                            .into(imagenfemoral3);
                }



                //gluteos
                if ( ejercicioseleccionadogluteos.equals("Aducciones de cadera en polea")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111641.jpg?alt=media&token=2c6c6ec6-806a-4bca-ae11-f4284d740751")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Aducciones de cadera en m??quina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20en%20maquina%2F20210224_120014.jpg?alt=media&token=10f79db9-a51a-4c7f-b345-bbf315bd89f4")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Goblet squat")) {
                    int reps = 10;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgoblet%20squat%2F20211210_111428.jpg?alt=media&token=a8cb7d1d-d535-4868-b03b-f443a1e70a87")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Hip thrust con barra")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fhip%20thrust%20con%20barra%2F20210210_112151.jpg?alt=media&token=4ee62dc4-1073-448a-a1f2-64ed8e0eccd0")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Patada para gl??teo con mancuerna")) {
                    int reps = 10;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20mancuerna%2F20210210_113919.jpg?alt=media&token=9ecbd1ff-9b5e-4314-9d18-6e5ef6297ba9")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Abducciones de cadera en polea")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111641.jpg?alt=media&token=2c6c6ec6-806a-4bca-ae11-f4284d740751")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }


                if ( ejercicioseleccionadogluteos.equals("Abducciones de cadera en m??quina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20en%20maquina%2F20210204_115306.jpg?alt=media&token=f072eb5e-d411-4ef7-9e8b-d23cfbd0a990")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Patada para gl??teo con polea")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20polea%2F20210308_125722.jpg?alt=media&token=ba18cfd3-bc40-4919-b59d-7868d8b95f1c")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Patada para gl??teos con m??quina de pie")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%20de%20pie%2F20210202_123925.jpg?alt=media&token=09e3e5ff-2478-4f3d-aa0c-c210a296761b")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Patada para gl??teos en m??quina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%2F20210131_111648.jpg?alt=media&token=e014fed1-f7cd-49f9-b683-3a5620b0b029")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Peso muerto tipo sumo con barra")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20barra%2F20210210_112935.jpg?alt=media&token=b2d84e57-45a6-4bf5-8a8b-8d671513cd8f")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Peso muerto tipo sumo con mancuerna")) {
                    int reps = 6;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20mancuerna%2F20210131_113330.jpg?alt=media&token=f79ca688-ba30-4d65-a328-ee456f27013e")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Puente a 1 pierna")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20a%201%20pierna%2F20210131_113159.jpg?alt=media&token=bcabdcb0-892f-4e4a-bc08-7f696e3fce95")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Puente con mancuerna")) {
                    int reps = 10;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20con%20mancuerna%2F20210131_113131.jpg?alt=media&token=5207ad4d-8bbc-4d2a-9ca6-6abdfdfd013f")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Sentadilla smith tipo sumo")) {
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

                //laterales
                if ( ejercicioseleccionadolateral.equals("Elevaciones laterales con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaciones%20laterales%20con%20mancuernas%2F20210131_105249.jpg?alt=media&token=2ffa2e63-ca3c-4b91-900d-2a3b938a3932")
                            .fit().centerCrop()
                            .into(imagenlateral);
                }


                if ( ejercicioseleccionadolateral.equals("Elevaci??n lateral con polea baja")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20polea%20baja%2F20210313_121731.jpg?alt=media&token=5248be4d-3506-4e15-8134-f5f4e06e2c8a")
                            .fit().centerCrop()
                            .into(imagenlateral);
                }

                if ( ejercicioseleccionadolateral.equals("Flys invertidos en peck deck")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20en%20peck%20deck%2Fflye3.jpg?alt=media&token=6c84d085-2518-4319-8e27-444114709d9f")
                            .fit().centerCrop()
                            .into(imagenlateral);
                }

                if ( ejercicioseleccionadolateral.equals("Remo al ment??n con barra")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20barra%2Frem2.jpg?alt=media&token=d9843316-dd2f-43a3-a8a1-7f7168069624")
                            .fit().centerCrop()
                            .into(imagenlateral);
                }

                if ( ejercicioseleccionadolateral.equals("Remo al ment??n con polea baja")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem3.jpg.jpg?alt=media&token=b302e29e-81ff-429f-9daa-56c84b18ce6d")
                            .fit().centerCrop()
                            .into(imagenlateral);
                }

                if ( ejercicioseleccionadolateral.equals("Elevaci??n lateral con polea baja por detr??s")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115743.jpg?alt=media&token=d75af285-55fc-499e-84cc-c13f86539e5c")
                            .fit().centerCrop()
                            .into(imagenlateral);
                }

                if ( ejercicioseleccionadolateral.equals("Elevaci??n lateral con mancuernas acostado en banco inclinado de perfil")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120233.jpg?alt=media&token=a40ae582-7b39-4ccd-927b-d64da79c55b8")
                            .fit().centerCrop()
                            .into(imagenlateral);
                }

                if ( ejercicioseleccionadolateral.equals("Elevaci??n lateral con mancuerna a 45??")) {
                    int reps = 10;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112606.jpg?alt=media&token=224d744f-9b85-4ea0-b50a-333667af2f9a")
                            .fit().centerCrop()
                            .into(imagenlateral);
                }

                if ( ejercicioseleccionadolateral.equals("Flys cruzados con poleas")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375")
                            .fit().centerCrop()
                            .into(imagenlateral);
                }

                if ( ejercicioseleccionadolateral.equals("Flys agachado con mancuernas")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20agachados%2F20211210_120455.jpg?alt=media&token=3b398377-2569-4d55-9062-fb9e2011eaf5")
                            .fit().centerCrop()
                            .into(imagenlateral);
                }

                if ( ejercicioseleccionadolateral.equals("Facepull con cuerda")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120826.jpg?alt=media&token=dad7d426-1561-4435-aac6-7c7cf954eb73")
                            .fit().centerCrop()
                            .into(imagenlateral);
                }

                if ( ejercicioseleccionadolateral.equals("Remo al ment??n con mancuernas")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20mancuernas%2F20211210_120546.jpg?alt=media&token=c2160078-997f-46da-8464-35955cd1f23e")
                            .fit().centerCrop()
                            .into(imagenlateral);
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


                if ( ejercicioseleccionadolateral2.equals("Elevaci??n lateral con polea baja")) {
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

                if ( ejercicioseleccionadolateral2.equals("Remo al ment??n con barra")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20barra%2Frem2.jpg?alt=media&token=d9843316-dd2f-43a3-a8a1-7f7168069624")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if ( ejercicioseleccionadolateral2.equals("Remo al ment??n con polea baja")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem3.jpg.jpg?alt=media&token=b302e29e-81ff-429f-9daa-56c84b18ce6d")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if ( ejercicioseleccionadolateral2.equals("Elevaci??n lateral con polea baja por detr??s")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115743.jpg?alt=media&token=d75af285-55fc-499e-84cc-c13f86539e5c")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if ( ejercicioseleccionadolateral2.equals("Elevaci??n lateral con mancuernas acostado en banco inclinado de perfil")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral2.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120233.jpg?alt=media&token=a40ae582-7b39-4ccd-927b-d64da79c55b8")
                            .fit().centerCrop()
                            .into(imagenlaterales2);
                }

                if ( ejercicioseleccionadolateral2.equals("Elevaci??n lateral con mancuerna a 45??")) {
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

                if ( ejercicioseleccionadolateral2.equals("Remo al ment??n con mancuernas")) {
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


                if ( ejercicioseleccionadolateral3.equals("Elevaci??n lateral con polea baja")) {
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

                if ( ejercicioseleccionadolateral3.equals("Remo al ment??n con barra")) {
                    int reps = 8;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20barra%2Frem2.jpg?alt=media&token=d9843316-dd2f-43a3-a8a1-7f7168069624")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if ( ejercicioseleccionadolateral3.equals("Remo al ment??n con polea baja")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem3.jpg.jpg?alt=media&token=b302e29e-81ff-429f-9daa-56c84b18ce6d")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if ( ejercicioseleccionadolateral3.equals("Elevaci??n lateral con polea baja por detr??s")) {
                    int reps = 15;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115743.jpg?alt=media&token=d75af285-55fc-499e-84cc-c13f86539e5c")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if ( ejercicioseleccionadolateral3.equals("Elevaci??n lateral con mancuernas acostado en banco inclinado de perfil")) {
                    int reps = 12;
                    String repeslateral = Integer.toString(reps);
                    repeticioneslateral3.setText(repeslateral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120233.jpg?alt=media&token=a40ae582-7b39-4ccd-927b-d64da79c55b8")
                            .fit().centerCrop()
                            .into(imagenlaterales3);
                }

                if ( ejercicioseleccionadolateral3.equals("Elevaci??n lateral con mancuerna a 45??")) {
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

                if ( ejercicioseleccionadolateral3.equals("Remo al ment??n con mancuernas")) {
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

                String ejerciciocuadriceps = datasnapshot.child("cuadriceps/ ejercicio primario").getValue().toString();
                String ejerciciocuadriceps2 = datasnapshot.child("cuadriceps/ ejercicio secundario").getValue().toString();
                String ejerciciocuadriceps3 = datasnapshot.child("cuadriceps/ ejercicio tercero").getValue().toString();
                String ejerciciocuadriceps4 = datasnapshot.child("cuadriceps/ ejercicio cuarto").getValue().toString();


                String ejercicioisquios = datasnapshot.child("isquios/ ejercicio primario").getValue().toString();
                String ejercicioisquios2 = datasnapshot.child("isquios/ ejercicio secundario").getValue().toString();
                String ejercicioisquios3 = datasnapshot.child("isquios/ ejercicio tercero").getValue().toString();

                String ejerciciolateral = datasnapshot.child("deltoides laterales y posteriores/ ejercicio primario").getValue().toString();
                String ejerciciolateral2 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio secundario").getValue().toString();
                String ejerciciolateral3 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();

                String ejerciciogluteos = datasnapshot.child("gluteos y aductores/ ejercicio primario").getValue().toString();
                String ejerciciogluteos2 = datasnapshot.child("gluteos y aductores/ ejercicio secundario").getValue().toString();

                String ejerciciopantorrillas = datasnapshot.child("pantorrillas/ ejercicio primario").getValue().toString();
                String ejerciciopantorrillas2 = datasnapshot.child("pantorrillas/ ejercicio secundario").getValue().toString();




                //RER INICIAL 3 - 4 Y 2 - 3
                if(rer1int >= 18) {

                    //deltoides laterales
                    switch(ejerciciolateral){
                        //ejercicios compuestos
                        case "Remo al ment??n con barra":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Elevaci??n lateral con mancuernas acostado en banco inclinado de perfil":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Remo al ment??n con mancuernas":
                            rer10.setText("3 - 4 RER");
                            break;



                        //ejercicios csimples
                        case "Elevaci??n lateral con polea baja por detr??s":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevaci??n lateral con mancuerna a 45??":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevaci??n lateral con polea baja":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Remo al ment??n con polea baja":
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
                    switch(ejerciciolateral2){
                        //ejercicios compuestos
                        case "Remo al ment??n con barra":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Elevaci??n lateral con mancuernas acostado en banco inclinado de perfil":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Remo al ment??n con mancuernas":
                            rer11.setText("3 - 4 RER");
                            break;



                        //ejercicios csimples
                        case "Elevaci??n lateral con polea baja por detr??s":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Elevaci??n lateral con mancuerna a 45??":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Elevaci??n lateral con polea baja":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Remo al ment??n con polea baja":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Facepull con cuerda":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer11.setText("2 - 3 RER");
                            break;

                    }



                    //deltoides laterales
                    switch(ejerciciolateral3){
                        //ejercicios compuestos
                        case "Remo al ment??n con barra":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Elevaci??n lateral con mancuernas acostado en banco inclinado de perfil":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Remo al ment??n con mancuernas":
                            rer12.setText("3 - 4 RER");
                            break;



                        //ejercicios csimples
                        case "Elevaci??n lateral con polea baja por detr??s":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevaci??n lateral con mancuerna a 45??":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevaci??n lateral con polea baja":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Remo al ment??n con polea baja":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Facepull con cuerda":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer12.setText("2 - 3 RER");
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

                    //cuadriceps
                    switch(ejerciciocuadriceps3){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Sentadilla con barra":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Prensa a 45??":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer3.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90??":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Prensa horizontal en m??quina":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Sentadilla en m??quina perfecta":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Extensiones de cuadriceps en m??quina":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Sentadilla":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer3.setText("2 - 3 RER");
                            break;

                    }


                    //cuadriceps
                    switch(ejerciciocuadriceps4){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Sentadilla con barra":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Prensa a 45??":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer4.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90??":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Prensa horizontal en m??quina":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Sentadilla en m??quina perfecta":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Extensiones de cuadriceps en m??quina":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Sentadilla":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer4.setText("2 - 3 RER");
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


                    //ISQUIOS
                    switch(ejercicioisquios3){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Peso muerto en smith":
                            rer7.setText("3 - 4 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl femoral acostado en m??quina":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl femoral acostado en m??quina a 1 pierna":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl femoral sentado en m??quina":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en m??quina":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Elevaci??n de cadera a una pierna":
                            rer7.setText("2 - 3 RER");
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
                    switch(ejerciciopantorrillas2){
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
                            rer8.setText("3 - 4 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer8.setText("3 - 4 RER");
                            break;

                        case "Patada para gl??teos con m??quina de pie":
                            rer8.setText("3 - 4 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer8.setText("3 - 4 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Aducciones de cadera en m??quina":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Peso muerto tipo sumo con mancuernal":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Goblet squat":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Abducciones de cadera en polea":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Abducciones de cadera en m??quina":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Patada para gl??teo con polea":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Patada para gl??teos en m??quina":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Puente con mancuerna":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Patada para gl??teo con mancuerna":
                            rer8.setText("2 - 3 RER");
                            break;

                    }

                    //gluteos
                    switch(ejerciciogluteos2){
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





                }
                // RER FINAL  1 - 2 Y 0 - 1

                if (rer1int <= 12){

                    //deltoides laterales
                    switch(ejerciciolateral){
                        //ejercicios compuestos
                        case "Remo al ment??n con barra":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n lateral con mancuernas acostado en banco inclinado de perfil":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Remo al ment??n con mancuernas":
                            rer10.setText("1 - 2 RER");
                            break;



                        //ejercicios csimples
                        case "Elevaci??n lateral con polea baja por detr??s":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n lateral con mancuerna a 45??":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n lateral con polea baja":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Remo al ment??n con polea baja":
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
                    switch(ejerciciolateral2){
                        //ejercicios compuestos
                        case "Remo al ment??n con barra":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n lateral con mancuernas acostado en banco inclinado de perfil":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Remo al ment??n con mancuernas":
                            rer11.setText("1 - 2 RER");
                            break;



                        //ejercicios csimples
                        case "Elevaci??n lateral con polea baja por detr??s":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n lateral con mancuerna a 45??":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n lateral con polea baja":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Remo al ment??n con polea baja":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Facepull con cuerda":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer11.setText("0 - 1 RER");
                            break;

                    }

                    //deltoides laterales
                    switch(ejerciciolateral3){
                        //ejercicios compuestos
                        case "Remo al ment??n con barra":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n lateral con mancuernas acostado en banco inclinado de perfil":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Remo al ment??n con mancuernas":
                            rer12.setText("1 - 2 RER");
                            break;



                        //ejercicios csimples
                        case "Elevaci??n lateral con polea baja por detr??s":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n lateral con mancuerna a 45??":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n lateral con polea baja":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Remo al ment??n con polea baja":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Facepull con cuerda":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer12.setText("0 - 1 RER");
                            break;

                    }



                    //PANTORRILLAS
                    switch(ejerciciopantorrillas){
                        //ejercicios compuestos
                        case "Elevaci??n de tal??n parado en m??quina":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n de tal??n en prensa 45??":
                            rer1.setText("1 - 2 RER");
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
                    switch(ejerciciopantorrillas2){
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
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Patada para gl??teos con m??quina de pie":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer8.setText("1 - 2 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Aducciones de cadera en m??quina":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Peso muerto tipo sumo con mancuernal":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Goblet squat":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Abducciones de cadera en polea":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Abducciones de cadera en m??quina":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con polea":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teos en m??quina":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Puente con mancuerna":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con mancuerna":
                            rer8.setText("0 - 1 RER");
                            break;

                    }


                    //gluteos
                    switch(ejerciciogluteos2){
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

                    //ISQUIOS
                    switch(ejercicioisquios3){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Peso muerto en smith":
                            rer7.setText("1 - 2 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en m??quina":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en m??quina a 1 pierna":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl femoral sentado en m??quina":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en m??quina":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n de cadera a una pierna":
                            rer7.setText("0 - 1 RER");
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


                    //cuadriceps
                    switch(ejerciciocuadriceps3){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Sentadilla con barra":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Prensa a 45??":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer3.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90??":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Prensa horizontal en m??quina":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Sentadilla en m??quina perfecta":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Extensiones de cuadriceps en m??quina":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Sentadilla":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer3.setText("0 - 1 RER");
                            break;

                    }

                    //cuadriceps
                    switch(ejerciciocuadriceps4){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Sentadilla con barra":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Prensa a 45??":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer4.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90??":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Prensa horizontal en m??quina":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Sentadilla en m??quina perfecta":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Extensiones de cuadriceps en m??quina":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Sentadilla":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer4.setText("0 - 1 RER");
                            break;

                    }



                }

                // RER MEDIO 2 - 3  Y 1 - 2

                if (rer1int>13 && rer1int<=17){

                    //deltoides laterales
                    switch(ejerciciolateral){
                        //ejercicios compuestos
                        case "Remo al ment??n con barra":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Elevaci??n lateral con mancuernas acostado en banco inclinado de perfil":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Remo al ment??n con mancuernas":
                            rer10.setText("2 - 3 RER");
                            break;



                        //ejercicios csimples
                        case "Elevaci??n lateral con polea baja por detr??s":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n lateral con mancuerna a 45??":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n lateral con polea baja":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Remo al ment??n con polea baja":
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
                    switch(ejerciciolateral2){
                        //ejercicios compuestos
                        case "Remo al ment??n con barra":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Elevaci??n lateral con mancuernas acostado en banco inclinado de perfil":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Remo al ment??n con mancuernas":
                            rer11.setText("2 - 3 RER");
                            break;



                        //ejercicios csimples
                        case "Elevaci??n lateral con polea baja por detr??s":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n lateral con mancuerna a 45??":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n lateral con polea baja":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Remo al ment??n con polea baja":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Facepull con cuerda":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer11.setText("1 - 2 RER");
                            break;

                    }

                    //deltoides laterales
                    switch(ejerciciolateral3){
                        //ejercicios compuestos
                        case "Remo al ment??n con barra":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevaci??n lateral con mancuernas acostado en banco inclinado de perfil":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Remo al ment??n con mancuernas":
                            rer12.setText("2 - 3 RER");
                            break;



                        //ejercicios csimples
                        case "Elevaci??n lateral con polea baja por detr??s":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n lateral con mancuerna a 45??":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaci??n lateral con polea baja":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Remo al ment??n con polea baja":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Facepull con cuerda":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer12.setText("1 - 2 RER");
                            break;

                    }



                    //PANTORRILLAS
                    switch(ejerciciopantorrillas){
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
                    switch(ejerciciopantorrillas2){
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
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Patada para gl??teos con m??quina de pie":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer8.setText("1 - 2 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Aducciones de cadera en m??quina":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Peso muerto tipo sumo con mancuernal":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Goblet squat":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Abducciones de cadera en polea":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Abducciones de cadera en m??quina":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con polea":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teos en m??quina":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Puente con mancuerna":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Patada para gl??teo con mancuerna":
                            rer8.setText("0 - 1 RER");
                            break;

                    }


                    //PANTORRILLAS
                    switch(ejerciciogluteos2){
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


                    //ISQUIOS
                    switch(ejercicioisquios3){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Peso muerto en smith":
                            rer7.setText("1 - 2 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en m??quina":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en m??quina a 1 pierna":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl femoral sentado en m??quina":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en m??quina":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Elevaci??n de cadera a una pierna":
                            rer7.setText("0 - 1 RER");
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
                seriescuadriceps.setText(seriesfinallateral + " Series");
                seriescuadriceps2.setText(seriesfinallateral2 + " Series");
                seriescuadriceps3.setText(seriesfinallateral3 + " Series");
                seriescuadriceps4.setText(seriesfinallateral4 + " Series");


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
                if (scuadint3 == 1){
                    scuadint3++;
                }
                int scuadint4 = (int) Math.floor(scuadf4);
                String seriesfinalcuad = String.valueOf(scuadint);
                String seriesfinalcuad2 = String.valueOf(scuadint2);
                String seriesfinalcuad3 = String.valueOf(scuadint3);
                String seriesfinalcuad4 = String.valueOf(scuadint4);
                seriesfemoral.setText(seriesfinalcuad + " Series");
                seriesfemoral2.setText(seriesfinalcuad2 + " Series");
                seriesfemoral3.setText(seriesfinalcuad3 + " Series");



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
                int sfemoralesint3 = (int) Math.round(sfemoralesf3);
                String seriesfinalfemorales = String.valueOf(sfemoralesint);
                String seriesfinalfemorales2 = String.valueOf(sfemoralesint2);
                String seriesfinalfemorales3 = String.valueOf(sfemoralesint3);
                seriesgluteos.setText(seriesfinalfemorales + " Series");
                seriesgluteos2.setText(seriesfinalfemorales2 + " Series");



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
                String seriesgluteosfinal = String.valueOf(sgluteosint);
                String seriesgluteosfinal2 = String.valueOf(sgluteosint2);
                String seriesgluteosfinal3 = String.valueOf(sgluteosint3);
                seriespantorrillas.setText(seriesgluteosfinal + " Series");
                seriespantorrillas2.setText(seriesgluteosfinal2 + " Series");


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
                String seriesfinalfemoralesl = String.valueOf(sfemoralesintl);
                String seriesfinalfemorales2l = String.valueOf(sfemoralesint2l);
                String seriesfinalfemorales3l = String.valueOf(sfemoralesint3l);
                serieslateral.setText(seriesfinalfemoralesl + " Series");
                serieslateral2.setText(seriesfinalfemorales2l + " Series");
                serieslateral3.setText(seriesfinalfemorales3l + " Series");







                String stringpesoiniciallateral = datasnapshot.child("Historial cuadriceps/ 5 dias/ primer ejercicio/ dia 2").getValue().toString();
                pesocuadriceps.setText(stringpesoiniciallateral);

                String stringpesoiniciallateral2 = datasnapshot.child("Historial cuadriceps/ 5 dias/ segundo ejercicio/ dia 2").getValue().toString();
                pesocuadriceps2.setText(stringpesoiniciallateral2);

                String stringpesoiniciallateral3 = datasnapshot.child("Historial cuadriceps/ 5 dias/ tercer ejercicio/ dia 2").getValue().toString();
                pesocuadriceps3.setText(stringpesoiniciallateral3);

                String stringpesoinicialcuadriceps = datasnapshot.child("Historial cuadriceps/ 5 dias/ cuarto ejercicio/ dia 2").getValue().toString();
                pesocuadriceps4.setText(stringpesoinicialcuadriceps);



                String stringpesoinicialcuadriceps2 = datasnapshot.child("Historial isquios/ 5 dias/ segundo ejercicio/ dia 2").getValue().toString();
                pesofemoral.setText(stringpesoinicialcuadriceps2);

                String stringpesoinicialcuadriceps3 = datasnapshot.child("Historial isquios/ 5 dias/ tercer ejercicio/ dia 2").getValue().toString();
                pesofemora2.setText(stringpesoinicialcuadriceps3);

                String stringpesoinicialfemoral = datasnapshot.child("Historial isquios/ 5 dias/ primer ejercicio/ dia 2").getValue().toString();
                pesofemoral3.setText(stringpesoinicialfemoral);



                String stringpesoinicialfemoral2 = datasnapshot.child("Historial deltoides laterales y posteriores/ 5 dias/ segundo ejercicio/ dia 2").getValue().toString();
                pesolateral.setText(stringpesoinicialfemoral2);

                String stringpesoinicialfemoral3 = datasnapshot.child("Historial deltoides laterales y posteriores/ 5 dias/ primer ejercicio/ dia 2").getValue().toString();
                pesolateral2.setText(stringpesoinicialfemoral3);

                String stringpesoinicialpantorrillas = datasnapshot.child("Historial deltoides laterales y posteriores/ 5 dias/ tercer ejercicio/ dia 2").getValue().toString();
                pesolateral3.setText(stringpesoinicialpantorrillas);




                String stringpesoinicialpantorrillas2 = datasnapshot.child("Historial gluteos y aductores/ 5 dias/ primer ejercicio/ dia 2").getValue().toString();
                pesogluteos.setText(stringpesoinicialpantorrillas2);


                String stringpesoinicialpantorrillas3 = datasnapshot.child("Historial gluteos y aductores/ 5 dias/ segundo ejercicio/ dia 2").getValue().toString();
                pesogluteos2.setText(stringpesoinicialpantorrillas3);



                String stringpesoinicialgluteos = datasnapshot.child("Historial pantorrillas/ 5 dias/ primer ejercicio/ dia 2").getValue().toString();
                pesopantorrillas.setText(stringpesoinicialgluteos);

                String stringpesoinicialgluteos2 = datasnapshot.child("Historial pantorrillas/ 5 dias/ segundo ejercicio/ dia 2").getValue().toString();
                pesopantorrillas2.setText(stringpesoinicialgluteos2);






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
        pesocuadriceps3.addTextChangedListener(new TextWatcher() {
                                                 @Override
                                                 public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                 }

                                                 @Override
                                                 public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                 }

                                                 @Override
                                                 public void afterTextChanged(Editable editable) {
                                                     SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesocuadriceps3.getContext());
                                                     preferences.edit().putString("editText",editable.toString()).commit();



                                                 }
                                             }
        );



        //permite dejar puesto el peso ingresado en el edit text
        pesocuadriceps4.addTextChangedListener(new TextWatcher() {
                                                   @Override
                                                   public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                   }

                                                   @Override
                                                   public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                   }

                                                   @Override
                                                   public void afterTextChanged(Editable editable) {
                                                       SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesocuadriceps4.getContext());
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
        pesofemoral3.addTextChangedListener(new TextWatcher() {
                                                @Override
                                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void afterTextChanged(Editable editable) {
                                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(pesofemoral3.getContext());
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




    }


    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void findelentrenamientoentreno5diasabado(View view) {

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
                    mInterstitialAd.show(entreno5diasabado.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }

            }
        }, 1000);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();

        String datoejercicio1 = pesocuadriceps.getText().toString();
        String datoejercicio1_2 = pesocuadriceps2.getText().toString();
        String datoejercicio1_3 = pesocuadriceps3.getText().toString();
        String datoejercicio1_4 = pesocuadriceps4.getText().toString();

        String datoejercicio2 = pesofemoral.getText().toString();
        String datoejercicio2_2 = pesofemora2.getText().toString();
        String datoejercicio2_3 = pesofemoral3.getText().toString();

        String datoejercicio2_4 = pesogluteos.getText().toString();
        String datoejercicio3 = pesogluteos2.getText().toString();

        String datoejercicio3_2 = pesolateral3.getText().toString();
        String datoejercicio3_3 = pesolateral.getText().toString();
        String datoejercicio4 = pesolateral2.getText().toString();

        String datoejercicio4_1 = pesopantorrillas.getText().toString();
        String datoejercicio4_2 = pesopantorrillas2.getText().toString();




        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                Map<String, Object> pesoactualizandose2 = new HashMap<>();
                pesoactualizandose2.put("Historial cuadriceps/ 5 dias/ primer ejercicio/ dia 2", datoejercicio1);
                pesoactualizandose2.put("Historial cuadriceps/ 5 dias/ segundo ejercicio/ dia 2", datoejercicio1_2);
                pesoactualizandose2.put("Historial cuadriceps/ 5 dias/ tercer ejercicio/ dia 2", datoejercicio1_3);
                pesoactualizandose2.put("Historial cuadriceps/ 5 dias/ cuarto ejercicio/ dia 2", datoejercicio1_4);

                pesoactualizandose2.put("Historial isquios/ 5 dias/ primer ejercicio/ dia 2", datoejercicio2);
                pesoactualizandose2.put("Historial isquios/ 5 dias/ segundo ejercicio/ dia 2", datoejercicio2_2);
                pesoactualizandose2.put("Historial isquios/ 5 dias/ tercer ejercicio/ dia 2", datoejercicio2_3);

                pesoactualizandose2.put("Historial gluteos y aductores/ 5 dias/ primer ejercicio/ dia 2", datoejercicio2_4);
                pesoactualizandose2.put("Historial gluteos y aductores/ 5 dias/ segundo ejercicio/ dia 2", datoejercicio3);

                pesoactualizandose2.put("Historial deltoides laterales y posteriores/ 5 dias/ tercer ejercicio/ dia 2", datoejercicio3_2);
                pesoactualizandose2.put("Historial deltoides laterales y posteriores/ 5 dias/ primer ejercicio/ dia 2", datoejercicio3_3);
                pesoactualizandose2.put("Historial deltoides laterales y posteriores/ 5 dias/ segundo ejercicio/ dia 2", datoejercicio4);

                pesoactualizandose2.put("Historial pantorrillas/ 5 dias/ primer ejercicio/ dia 2", datoejercicio4_1);
                pesoactualizandose2.put("Historial pantorrillas/ 5 dias/ segundo ejercicio/ dia 2", datoejercicio4_2);






                mDatabase.child("Users").child(id).updateChildren(pesoactualizandose2);


                //si se modifica el datachange en algun otro momento envia a esta pantalla, por lo cual se condiciona el envio
                boolean botonpresionado = true;

                if (botonpresionado == true){



                    Intent findelentrenamiento = new Intent(entreno5diasabado.this, entrenamientofinalizado.class);

                    String valor2 = getIntent().getExtras().getString("actual");
                    findelentrenamiento.putExtra("actual", valor2);
                    findelentrenamiento.putExtra("entreno?", "sidia5");

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
                Intent ejercicio = new Intent(entreno5diasabado.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diasabado.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diasabado.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diasabado.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diasabado.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diasabado.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diasabado.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diasabado.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diasabado.this, ejercicio.class);

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
                Intent ejercicio = new Intent(entreno5diasabado.this, ejercicio.class);

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
                String ej = datasnapshot.child("deltoides laterales y posteriores/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diasabado.this, ejercicio.class);

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
                String ej = datasnapshot.child("deltoides laterales y posteriores/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diasabado.this, ejercicio.class);

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
                String ej = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();
                Intent ejercicio = new Intent(entreno5diasabado.this, ejercicio.class);

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
                String ej = datasnapshot.child("pantorrillas/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diasabado.this, ejercicio.class);

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
                String ej = datasnapshot.child("pantorrillas/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno5diasabado.this, ejercicio.class);

                ejercicio.putExtra("ej", ej);

                startActivity(ejercicio);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
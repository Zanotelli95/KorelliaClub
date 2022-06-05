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

public class entreno4diamartes extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private EditText pesolateral, pesocuadriceps, pesofemoral, pesogluteos, pesopantorrillas, pesoabdomen, pesocuadriceps2,
            pesocuadriceps3, pesofemora2, pesofemoral3, pesolateral2, pesolateral3, pesogluteos2, pesopantorrillas2;
    private String ejercicioseleccionado,  ejercicioseleccionadofemoral, ejercicioseleccionadolateral;
    private TextView rer1, rer2, rer3, rer4, rer5, rer6, rer7, rer8, rer9, rer10, rer11, rer12, rer13, rer14;
    private String ejercicioseleccionado2, ejercicioseleccionado3, ejercicioseleccionadofemoral2, ejercicioseleccionadofemoral3,
            ejercicioseleccionadolateral2, ejercicioseleccionadolateral3, ejercicioseleccionadogluteos, ejercicioseleccionadogluteos2,
            ejercicioseleccionadopantorrillas2, ejercicioseleccionadopantorrillas, ejercicioseleccionadoabdomen;
    private TextView fechacompleta;
    private TextView serieslateral, seriescuadriceps, seriesfemoral, seriespantorrillas, seriesgluteos,  seriesabdomen;
    private Spinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8, spinner9, spinner10, spinner11, spinner12, spinner13, spinner14;
    private  TextView ejerciciolateral, repeticioneslateral, ejerciciocuadriceps, repeticionescuadriceps, ejerciciofemoral, repeticionesfemoral, ejerciciogluteos, repeticionesgluteos,
            ejerciciopantorrillas, ejercicioabdomen, repeticionesbadomen;
    private ImageView imagencuadriceps, imagencuadriceps2, imagencuadriceps3, imagenfemoral, imagengluteos,
            imagenpantorrillas, imagenfemora2, imagenfemoral3, imagenlaterales, imagenlaterales2, imagenlaterales3, imagengluteos2, imagenpantorrillas2,
          imageneabdomen;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private TextView ejerciciocuadriceps2, repeticionescuadriceps2, repeticionespantorrillas2, seriescuadriceps2,
            ejerciciocuadriceps3, repeticionescuadriceps3, seriescuadriceps3, ejerciciofemoral2, ejerciciofemoral3,
            repeticionesfemora2, repeticionesfemoral3,
    seriesfemoral2, seriesfemoral3, ejerciciolateral2, ejerciciolateral3, repeticioneslateral2, repeticioneslateral3,
            serieslateral2, serieslateral3, seriesgluteos2, ejerciciogluteos2, repeticionesgluteos2, ejerciciopantorrillas2, seriespantorrillas2, repeticionespantorrillas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_entreno4diamartes);

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


        fechacompleta = (TextView) findViewById(R.id.textView272);
        Date date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("d MMM yyyy");
        String sfecha = fecha.format(date);
        fechacompleta.setText(sfecha);

        Toolbar toolbar = findViewById(R.id.toolbarentreno4diamartes);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Entrenamiento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinner1= (Spinner) findViewById(R.id.spinner1b);
        spinner2= (Spinner) findViewById(R.id.spinner2b);
        spinner3= (Spinner) findViewById(R.id.spinner3b);
        spinner4= (Spinner) findViewById(R.id.spinner4b);
        spinner5= (Spinner) findViewById(R.id.spinner5b);
        spinner6= (Spinner) findViewById(R.id.spinner6b);
        spinner7= (Spinner) findViewById(R.id.spinner7b);
        spinner8= (Spinner) findViewById(R.id.spinner8b);
        spinner9= (Spinner) findViewById(R.id.spinner9b);
        spinner10= (Spinner) findViewById(R.id.spinner10b);
        spinner11= (Spinner) findViewById(R.id.spinner11b);
        spinner12= (Spinner) findViewById(R.id.spinner12b);
        spinner13= (Spinner) findViewById(R.id.spinner13b);
        spinner14= (Spinner) findViewById(R.id.spinner14b);

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


        rer1 = findViewById(R.id.buttonrer1z);
        rer2 = findViewById(R.id.buttonrer2z);
        rer3 = findViewById(R.id.buttonrer3z);
        rer4 = findViewById(R.id.buttonrer4z);
        rer5 = findViewById(R.id.buttonrer5z);
        rer6 = findViewById(R.id.buttonrer6z);
        rer7 = findViewById(R.id.buttonrer7z);
        rer8 = findViewById(R.id.buttonrer8z);
        rer9 = findViewById(R.id.buttonrer9z);
        rer10 = findViewById(R.id.buttonrer10z);
        rer11 = findViewById(R.id.buttonrer11z);
        rer12 = findViewById(R.id.buttonrer12z);
        rer13 = findViewById(R.id.buttonrer13z);
        rer14 = findViewById(R.id.buttonrer14z);



        //cuadriceps 3
        ejerciciocuadriceps = (TextView) findViewById(R.id.textView219martes);
        repeticionescuadriceps = (TextView) findViewById(R.id.textView221martes);
        imagencuadriceps = (ImageView) findViewById(R.id.imageView11martes);
        pesocuadriceps = (EditText) findViewById(R.id.textView222martes);
        seriescuadriceps = (TextView) findViewById(R.id.textView220martes);

        ejerciciocuadriceps2 = (TextView) findViewById(R.id.textView219martes2);
        repeticionescuadriceps2 = (TextView) findViewById(R.id.textView221martes2);
        imagencuadriceps2 = (ImageView) findViewById(R.id.imageView11martes2);
        pesocuadriceps2 = (EditText) findViewById(R.id.textView222martes2);
        seriescuadriceps2 = (TextView) findViewById(R.id.textView220martes2);

        ejerciciocuadriceps3 = (TextView) findViewById(R.id.textView219martes3);
        repeticionescuadriceps3 = (TextView) findViewById(R.id.textView221martes3);
        imagencuadriceps3 = (ImageView) findViewById(R.id.imageView11martes3);
        pesocuadriceps3 = (EditText) findViewById(R.id.textView222martes3);
        seriescuadriceps3 = (TextView) findViewById(R.id.textView220martes3);


        //isquios 3
        ejerciciofemoral = (TextView) findViewById(R.id.textView219espalda1martes);
        repeticionesfemoral = (TextView) findViewById(R.id.textView221espalda1martes);
        imagenfemoral = (ImageView) findViewById(R.id.imageView11espalda1martes);
        pesofemoral = (EditText) findViewById(R.id.textView222espalda1martes);
        seriesfemoral = (TextView) findViewById(R.id.textView220espalda1martes);

        ejerciciofemoral2 = (TextView) findViewById(R.id.textView219espalda2martes);
        repeticionesfemora2 = (TextView) findViewById(R.id.textView221espalda2martes);
        imagenfemora2 = (ImageView) findViewById(R.id.imageView11espalda2martes);
        pesofemora2 = (EditText) findViewById(R.id.textView222espalda2martes);
        seriesfemoral2 = (TextView) findViewById(R.id.textView220espalda2martes);

        ejerciciofemoral3 = (TextView) findViewById(R.id.textView219espalda3martes);
        repeticionesfemoral3 = (TextView) findViewById(R.id.textView221espalda3martes);
        imagenfemoral3 = (ImageView) findViewById(R.id.imageView11espalda3martes);
        pesofemoral3 = (EditText) findViewById(R.id.textView222espalda3martes);
        seriesfemoral3 = (TextView) findViewById(R.id.textView220espalda3martes);


        //deltoides 3
        ejerciciolateral = (TextView) findViewById(R.id.textView219biceps1martes);
        repeticioneslateral = (TextView) findViewById(R.id.textView221biceps1martes);
        imagenlaterales = (ImageView) findViewById(R.id.imageView11biceps1martes);
        pesolateral = (EditText) findViewById(R.id.textView222biceps1martes);
        serieslateral = (TextView) findViewById(R.id.textView220biceps1martes);

        ejerciciolateral2 = (TextView) findViewById(R.id.textView219biceps2martes);
        repeticioneslateral2 = (TextView) findViewById(R.id.textView221biceps2martes);
        imagenlaterales2 = (ImageView) findViewById(R.id.imageView11biceps2martes);
        pesolateral2 = (EditText) findViewById(R.id.textView22biceps2martes);
        serieslateral2 = (TextView) findViewById(R.id.textView220biceps2martes);

        ejerciciolateral3 = (TextView) findViewById(R.id.nombreejerciciotriceps1martes);
        repeticioneslateral3 = (TextView) findViewById(R.id.textView221triceps1martes);
        imagenlaterales3 = (ImageView) findViewById(R.id.imageView11triceps1martes);
        pesolateral3 = (EditText) findViewById(R.id.textView222triceps1martes);
        serieslateral3 = (TextView) findViewById(R.id.textView220triceps1martes);


        //gluteos y aductores 2
        ejerciciogluteos = (TextView) findViewById(R.id.textView219traps2martes);
        repeticionesgluteos = (TextView) findViewById(R.id.textView221traps2martes);
        imagengluteos = (ImageView) findViewById(R.id.imageView11traps2martes);
        pesogluteos = (EditText) findViewById(R.id.textView222traps2martes);
        seriesgluteos = (TextView) findViewById(R.id.textView220traps2martes);

        ejerciciogluteos2 = (TextView) findViewById(R.id.textView219triceps2martes);
        repeticionesgluteos2 = (TextView) findViewById(R.id.textView221triecps2martes);
        imagengluteos2 = (ImageView) findViewById(R.id.imageView11triceps2martes);
        pesogluteos2 = (EditText) findViewById(R.id.textView222triceps2martes);
        seriesgluteos2 = (TextView) findViewById(R.id.textView220triceps2martes);


        //pantorrillas 2
        ejerciciopantorrillas = (TextView) findViewById(R.id.textView219frontal1martes);
        repeticionespantorrillas = (TextView) findViewById(R.id.textView221frontal1martes);
        imagenpantorrillas = (ImageView) findViewById(R.id.imageView11frontal1martes);
        pesopantorrillas = (EditText) findViewById(R.id.textView222frontal1martes);
        seriespantorrillas= (TextView) findViewById(R.id.textView220frontal1martes);

        ejerciciopantorrillas2 = (TextView) findViewById(R.id.textView219frontal2martes);
        repeticionespantorrillas2 = (TextView) findViewById(R.id.textView221frontal2martes);
        imagenpantorrillas2 = (ImageView) findViewById(R.id.imageView11frontal2martes);
        pesopantorrillas2 = (EditText) findViewById(R.id.textView222frontal2martes);
        seriespantorrillas2 = (TextView) findViewById(R.id.textView220frontal2martes);


        //abdomen 1

        ejercicioabdomen = (TextView) findViewById(R.id.textView219traps1martes);
        repeticionesbadomen = (TextView) findViewById(R.id.textView221traps1martes);
        imageneabdomen = (ImageView) findViewById(R.id.imageView11traps1martes);
        pesoabdomen = (EditText) findViewById(R.id.textView222traps1martes);
        seriesabdomen = (TextView) findViewById(R.id.textView220traps1martes);


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
                    ejercicioseleccionado = ejercicio;

                    String ejercicio2 = datasnapshot.child("cuadriceps/ ejercicio secundario").getValue().toString();
                    ejerciciocuadriceps2.setText(ejercicio2);
                    ejercicioseleccionado2 = ejercicio2;

                    String ejercicio3 = datasnapshot.child("cuadriceps/ ejercicio tercero").getValue().toString();
                    ejerciciocuadriceps3.setText(ejercicio3);
                    ejercicioseleccionado3 = ejercicio3;


                    String stringejerciciofemoral= datasnapshot.child("isquios/ ejercicio primario").getValue().toString();
                    ejerciciofemoral.setText(stringejerciciofemoral);
                    ejercicioseleccionadofemoral = stringejerciciofemoral;

                    String stringejerciciofemoral2 = datasnapshot.child("isquios/ ejercicio secundario").getValue().toString();
                    ejerciciofemoral2.setText(stringejerciciofemoral2);
                    ejercicioseleccionadofemoral2 = stringejerciciofemoral2;

                    String stringejerciciofemoral3 = datasnapshot.child("isquios/ ejercicio tercero").getValue().toString();
                    ejerciciofemoral3.setText(stringejerciciofemoral3);
                    ejercicioseleccionadofemoral3 = stringejerciciofemoral3;


                    String stringejerciciobiceps = datasnapshot.child("deltoides laterales y posteriores/ ejercicio primario").getValue().toString();
                    ejerciciolateral.setText(stringejerciciobiceps);
                    ejercicioseleccionadolateral = stringejerciciobiceps;

                    String stringejerciciobiceps2 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio secundario").getValue().toString();
                    ejerciciolateral2.setText(stringejerciciobiceps2);
                    ejercicioseleccionadolateral2 = stringejerciciobiceps2;

                    String stringejerciciotriceps = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();
                    ejerciciolateral3.setText(stringejerciciotriceps);
                    ejercicioseleccionadolateral3 = stringejerciciotriceps;


                    String stringejerciciotriceps2 = datasnapshot.child("gluteos y aductores/ ejercicio primario").getValue().toString();
                    ejerciciogluteos.setText(stringejerciciotriceps2);
                    ejercicioseleccionadogluteos = stringejerciciotriceps2;

                    String stringejerciciofrontal = datasnapshot.child("gluteos y aductores/ ejercicio secundario").getValue().toString();
                    ejerciciogluteos2.setText(stringejerciciofrontal);
                    ejercicioseleccionadogluteos2 = stringejerciciofrontal;


                    String stringejerciciofrontal2 = datasnapshot.child("pantorrillas/ ejercicio secundario").getValue().toString();
                    ejerciciopantorrillas2.setText(stringejerciciofrontal2);
                    ejercicioseleccionadopantorrillas2 = stringejerciciofrontal2;

                    String stringejerciciotraps = datasnapshot.child("pantorrillas/ ejercicio primario").getValue().toString();
                    ejerciciopantorrillas.setText(stringejerciciotraps);
                    ejercicioseleccionadopantorrillas = stringejerciciotraps;


                    String stringejerciciotraps2 = datasnapshot.child("abdominales/ ejercicio primario").getValue().toString();
                    ejercicioabdomen.setText(stringejerciciotraps2);
                    ejercicioseleccionadoabdomen = stringejerciciotraps2;


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

                if (ejercicioseleccionadolateral.equals("Flys agachado con mancuernas")) {
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

                if (ejercicioseleccionadolateral2.equals("Flys agachado con mancuernas")) {
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

                if (ejercicioseleccionadolateral3.equals("Flys agachado con mancuernas")) {
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










                //cuadriceps
                if ( ejercicioseleccionado.equals("Desplantes con mancuernas")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fdesplantes%20con%20mancuernas%2F20210131_112942.jpg?alt=media&token=2b6b25b6-e5c6-4057-be69-bd2cad0c2af6")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Prensa a 1 pierna")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112525.jpg?alt=media&token=9288507d-1f03-4147-b0d4-b89d491dbc60")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Prensa a 45°")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115038.jpg?alt=media&token=f8264fd9-f7e9-440b-8557-00aac5fec37d")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Prensa horizontal en máquina")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20horizontal%20en%20maquina%2F20210202_115706.jpg?alt=media&token=71099f4e-277a-44f4-9d54-9b86509400a7")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20con%20barra%2F20210206_111054.jpg?alt=media&token=7bb9cf31-7d1f-46b9-aef2-3f92d0d662aa")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla en máquina perfecta")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20en%20maquina%20perfecta%2F20210204_120342.jpg?alt=media&token=30659f89-9cf0-4183-97f8-1022479b30ab")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla frontal con mancuernas")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113031.jpg?alt=media&token=b7055a35-bb96-4797-a082-7fb395bbfee3")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla frontal con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla frontal en smith")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135922.jpg?alt=media&token=ddd7e42b-797b-4103-a384-0b9208546141")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla smith profunda")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135922.jpg?alt=media&token=ddd7e42b-797b-4103-a384-0b9208546141")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla smith a 90°")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135922.jpg?alt=media&token=ddd7e42b-797b-4103-a384-0b9208546141")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla bulgara con mancuernas")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112831.jpg?alt=media&token=273285a7-7376-4960-a28b-252e1ae4236a")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Extensiones de cuadriceps en máquina")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111311.jpg?alt=media&token=fbafd51a-6f5b-48a2-a252-40a61c84f09d")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }






                //cuadriceps
                if ( ejercicioseleccionado.equals("Desplantes con mancuernas")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fdesplantes%20con%20mancuernas%2F20210131_112942.jpg?alt=media&token=2b6b25b6-e5c6-4057-be69-bd2cad0c2af6")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Prensa a 1 pierna")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112525.jpg?alt=media&token=9288507d-1f03-4147-b0d4-b89d491dbc60")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Prensa a 45°")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115038.jpg?alt=media&token=f8264fd9-f7e9-440b-8557-00aac5fec37d")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Prensa horizontal en máquina")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20horizontal%20en%20maquina%2F20210202_115706.jpg?alt=media&token=71099f4e-277a-44f4-9d54-9b86509400a7")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20con%20barra%2F20210206_111054.jpg?alt=media&token=7bb9cf31-7d1f-46b9-aef2-3f92d0d662aa")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla en máquina perfecta")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20en%20maquina%20perfecta%2F20210204_120342.jpg?alt=media&token=30659f89-9cf0-4183-97f8-1022479b30ab")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla frontal con mancuernas")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113031.jpg?alt=media&token=b7055a35-bb96-4797-a082-7fb395bbfee3")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla frontal con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla frontal en smith")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20en%20smith%2F20211211_135602.jpg?alt=media&token=e1b0c3c9-2b6e-446a-9f05-d0651ba1da89")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla smith profunda")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135922.jpg?alt=media&token=ddd7e42b-797b-4103-a384-0b9208546141")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla smith a 90°")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20a%2090%20grados%20en%20smith%2FIMG_0338.jpg?alt=media&token=5a256969-7282-4b20-a9f4-e6801d322f68")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Sentadilla bulgara con mancuernas")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112831.jpg?alt=media&token=273285a7-7376-4960-a28b-252e1ae4236a")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }

                if ( ejercicioseleccionado.equals("Extensiones de cuadriceps en máquina")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111311.jpg?alt=media&token=fbafd51a-6f5b-48a2-a252-40a61c84f09d")
                            .fit().centerCrop()
                            .into(imagencuadriceps);
                }


                //cuadriceps
                if ( ejercicioseleccionado2.equals("Desplantes con mancuernas")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fdesplantes%20con%20mancuernas%2F20210131_112942.jpg?alt=media&token=2b6b25b6-e5c6-4057-be69-bd2cad0c2af6")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionado2.equals("Prensa a 1 pierna")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112525.jpg?alt=media&token=9288507d-1f03-4147-b0d4-b89d491dbc60")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionado2.equals("Prensa a 45°")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115038.jpg?alt=media&token=f8264fd9-f7e9-440b-8557-00aac5fec37d")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionado2.equals("Prensa horizontal en máquina")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20horizontal%20en%20maquina%2F20210202_115706.jpg?alt=media&token=71099f4e-277a-44f4-9d54-9b86509400a7")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionado2.equals("Sentadilla con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20con%20barra%2F20210206_111054.jpg?alt=media&token=7bb9cf31-7d1f-46b9-aef2-3f92d0d662aa")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionado2.equals("Sentadilla en máquina perfecta")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20en%20maquina%20perfecta%2F20210204_120342.jpg?alt=media&token=30659f89-9cf0-4183-97f8-1022479b30ab")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionado2.equals("Sentadilla frontal con mancuernas")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113031.jpg?alt=media&token=b7055a35-bb96-4797-a082-7fb395bbfee3")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionado2.equals("Sentadilla")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionado2.equals("Sentadilla frontal con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionado2.equals("Sentadilla frontal en smith")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20en%20smith%2F20211211_135602.jpg?alt=media&token=e1b0c3c9-2b6e-446a-9f05-d0651ba1da89")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionado2.equals("Sentadilla smith profunda")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135922.jpg?alt=media&token=ddd7e42b-797b-4103-a384-0b9208546141")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionado2.equals("Sentadilla smith a 90°")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20a%2090%20grados%20en%20smith%2FIMG_0338.jpg?alt=media&token=5a256969-7282-4b20-a9f4-e6801d322f68")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionado2.equals("Sentadilla bulgara con mancuernas")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112831.jpg?alt=media&token=273285a7-7376-4960-a28b-252e1ae4236a")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }

                if ( ejercicioseleccionado2.equals("Extensiones de cuadriceps en máquina")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps2.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111311.jpg?alt=media&token=fbafd51a-6f5b-48a2-a252-40a61c84f09d")
                            .fit().centerCrop()
                            .into(imagencuadriceps2);
                }



                //cuadriceps
                if ( ejercicioseleccionado3.equals("Desplantes con mancuernas")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fdesplantes%20con%20mancuernas%2F20210131_112942.jpg?alt=media&token=2b6b25b6-e5c6-4057-be69-bd2cad0c2af6")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionado3.equals("Prensa a 1 pierna")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112525.jpg?alt=media&token=9288507d-1f03-4147-b0d4-b89d491dbc60")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionado3.equals("Prensa a 45°")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115038.jpg?alt=media&token=f8264fd9-f7e9-440b-8557-00aac5fec37d")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionado3.equals("Prensa horizontal en máquina")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20horizontal%20en%20maquina%2F20210202_115706.jpg?alt=media&token=71099f4e-277a-44f4-9d54-9b86509400a7")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionado3.equals("Sentadilla con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20con%20barra%2F20210206_111054.jpg?alt=media&token=7bb9cf31-7d1f-46b9-aef2-3f92d0d662aa")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionado3.equals("Sentadilla en máquina perfecta")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20en%20maquina%20perfecta%2F20210204_120342.jpg?alt=media&token=30659f89-9cf0-4183-97f8-1022479b30ab")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionado3.equals("Sentadilla frontal con mancuernas")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113031.jpg?alt=media&token=b7055a35-bb96-4797-a082-7fb395bbfee3")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionado3.equals("Sentadilla")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionado3.equals("Sentadilla frontal con barra")) {
                    int reps = 6;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionado3.equals("Sentadilla frontal en smith")) {
                    int reps = 8;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20en%20smith%2F20211211_135602.jpg?alt=media&token=e1b0c3c9-2b6e-446a-9f05-d0651ba1da89")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionado3.equals("Sentadilla smith profunda")) {
                    int reps = 10;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135922.jpg?alt=media&token=ddd7e42b-797b-4103-a384-0b9208546141")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionado3.equals("Sentadilla smith a 90°")) {
                    int reps = 12;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20a%2090%20grados%20en%20smith%2FIMG_0338.jpg?alt=media&token=5a256969-7282-4b20-a9f4-e6801d322f68")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionado3.equals("Sentadilla bulgara con mancuernas")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112831.jpg?alt=media&token=273285a7-7376-4960-a28b-252e1ae4236a")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
                }

                if ( ejercicioseleccionado3.equals("Extensiones de cuadriceps en máquina")) {
                    int reps = 15;
                    String repescuadriceps = Integer.toString(reps);
                    repeticionescuadriceps3.setText(repescuadriceps + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111311.jpg?alt=media&token=fbafd51a-6f5b-48a2-a252-40a61c84f09d")
                            .fit().centerCrop()
                            .into(imagencuadriceps3);
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
                    repeticionesfemora2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20acostado%20con%20mancuerna%2F20210308_122433.jpg?alt=media&token=93a79028-afb8-4b92-93d5-23cc097ca721")
                            .fit().centerCrop()
                            .into(imagenfemora2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral parado a 1 pierna en máquina")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemora2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122852.jpg?alt=media&token=59d7e392-1aad-4c52-a71d-faf7a1224d05")
                            .fit().centerCrop()
                            .into(imagenfemora2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral acostado en máquina")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemora2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20acostado%20en%20maquina%2F20210202_121632.jpg?alt=media&token=7cb5375f-ee3c-4a14-bf57-ed8aa27dbcf3")
                            .fit().centerCrop()
                            .into(imagenfemora2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral sentado en máquina")) {
                    int reps = 10;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemora2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20sentado%20en%20maquina%20para%20isquiosurales%2F20210131_103833.jpg?alt=media&token=408960ec-40e6-4a2b-8fb5-8548347d77c5")
                            .fit().centerCrop()
                            .into(imagenfemora2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Peso muerto a 1 pierna")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemora2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20a%201%20pierna%2F20210131_113706.jpg?alt=media&token=01c3e97b-bc16-4bd3-be7e-2328716e9188")
                            .fit().centerCrop()
                            .into(imagenfemora2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Peso muerto con mancuernas")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemora2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20mancuernas%2F20210131_113529.jpg?alt=media&token=af2e3ef5-0983-418b-8ccf-94b0f39a5510")
                            .fit().centerCrop()
                            .into(imagenfemora2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Peso muerto con piernas rigidas con barra")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemora2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20piernas%20r%C3%ADgidas%20con%20barra%2F20210308_120010.jpg?alt=media&token=92155ace-9f79-4981-b5ff-8f6dbe9d9783")
                            .fit().centerCrop()
                            .into(imagenfemora2);
                }

                if ( ejercicioseleccionadofemoral2.equals("Curl femoral acostado en máquina a 1 pierna")) {
                    int reps = 10;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemora2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122830(0).jpg?alt=media&token=70aa1e30-89af-46af-9a9e-b3e9b805b93c")
                            .fit().centerCrop()
                            .into(imagenfemora2);
                }


                if ( ejercicioseleccionadofemoral2.equals("Peso muerto en smith")) {
                    int reps = 10;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemora2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20en%20smith%2F20211211_135441.jpg?alt=media&token=7788cc84-8a01-4bb4-8c6e-258a26be9a98")
                            .fit().centerCrop()
                            .into(imagenfemora2);
                }


                if ( ejercicioseleccionadofemoral2.equals("Elevación de cadera a una pierna")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemora2.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Felevaci%C3%B3n%20de%20cadera%20a%201%20pierna%2F20211211_135110.jpg?alt=media&token=acbc4c3f-9615-440c-bdff-28ebfc54a1ae")
                            .fit().centerCrop()
                            .into(imagenfemora2);
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

                if ( ejercicioseleccionadofemoral3.equals("Curl femoral parado a 1 pierna en máquina")) {
                    int reps = 12;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral3.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122852.jpg?alt=media&token=59d7e392-1aad-4c52-a71d-faf7a1224d05")
                            .fit().centerCrop()
                            .into(imagenfemoral3);
                }

                if ( ejercicioseleccionadofemoral3.equals("Curl femoral acostado en máquina")) {
                    int reps = 8;
                    String repesfemoral = Integer.toString(reps);
                    repeticionesfemoral3.setText(repesfemoral + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20acostado%20en%20maquina%2F20210202_121632.jpg?alt=media&token=7cb5375f-ee3c-4a14-bf57-ed8aa27dbcf3")
                            .fit().centerCrop()
                            .into(imagenfemoral3);
                }

                if ( ejercicioseleccionadofemoral3.equals("Curl femoral sentado en máquina")) {
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

                if ( ejercicioseleccionadofemoral3.equals("Curl femoral acostado en máquina a 1 pierna")) {
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


                if ( ejercicioseleccionadofemoral3.equals("Elevación de cadera a una pierna")) {
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

                if ( ejercicioseleccionadogluteos.equals("Aducciones de cadera en máquina")) {
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

                if ( ejercicioseleccionadogluteos.equals("Patada para glúteo con mancuerna")) {
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


                if ( ejercicioseleccionadogluteos.equals("Abducciones de cadera en máquina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20en%20maquina%2F20210204_115306.jpg?alt=media&token=f072eb5e-d411-4ef7-9e8b-d23cfbd0a990")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Patada para glúteo con polea")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20polea%2F20210308_125722.jpg?alt=media&token=ba18cfd3-bc40-4919-b59d-7868d8b95f1c")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Patada para glúteos con máquina de pie")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%20de%20pie%2F20210202_123925.jpg?alt=media&token=09e3e5ff-2478-4f3d-aa0c-c210a296761b")
                            .fit().centerCrop()
                            .into(imagengluteos);
                }

                if ( ejercicioseleccionadogluteos.equals("Patada para glúteos en máquina")) {
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
                if ( ejercicioseleccionadogluteos2.equals("Aducciones de cadera en polea")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111641.jpg?alt=media&token=2c6c6ec6-806a-4bca-ae11-f4284d740751")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Aducciones de cadera en máquina")) {
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

                if ( ejercicioseleccionadogluteos2.equals("Patada para glúteo con mancuerna")) {
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


                if ( ejercicioseleccionadogluteos2.equals("Abducciones de cadera en máquina")) {
                    int reps = 15;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20en%20maquina%2F20210204_115306.jpg?alt=media&token=f072eb5e-d411-4ef7-9e8b-d23cfbd0a990")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Patada para glúteo con polea")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20polea%2F20210308_125722.jpg?alt=media&token=ba18cfd3-bc40-4919-b59d-7868d8b95f1c")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if (ejercicioseleccionadogluteos2.equals("Patada para glúteos con máquina de pie")) {
                    int reps = 12;
                    String repesgluteo = Integer.toString(reps);
                    repeticionesgluteos2.setText(repesgluteo + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%20de%20pie%2F20210202_123925.jpg?alt=media&token=09e3e5ff-2478-4f3d-aa0c-c210a296761b")
                            .fit().centerCrop()
                            .into(imagengluteos2);
                }

                if ( ejercicioseleccionadogluteos2.equals("Patada para glúteos en máquina")) {
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

                if (ejercicioseleccionadogluteos2.equals("Puente con mancuerna")) {
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
                if ( ejercicioseleccionadopantorrillas.equals("Elevaciones de talón en costurera")) {
                    int reps = 15;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20costurera%2F20210220_123439.jpg?alt=media&token=cd5d5a75-3dfc-46ce-8b24-1b366faa38ee")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }

                if ( ejercicioseleccionadopantorrillas.equals("Elevaciones de talón en prensa a 1 pierna")) {
                    int reps = 10;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20a%201%20pierna%2F20210215_130011.jpg?alt=media&token=d3f4cafe-26f6-4cd2-a862-d02e29ff75ba")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }

                if ( ejercicioseleccionadopantorrillas.equals("Elevación de talón parado con mancuernas")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20parado%20con%20mancuerna%2F20210310_120558.jpg?alt=media&token=3d5edaad-c045-4256-aea7-34d967faef76")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }

                if ( ejercicioseleccionadopantorrillas.equals("Elevación de talón parado en máquina")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20sentadilla%20perfecta%2F20211215_113308.jpg?alt=media&token=8ebb1b76-9791-414a-8965-b6504b4b2d7b")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }

                if ( ejercicioseleccionadopantorrillas.equals("Elevación de talón en prensa 45°")) {
                    int reps = 8;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaci%C3%B3n%20de%20tal%C3%B3n%20en%20prensa%2045%C2%B0%2FIMG_0369.jpg?alt=media&token=1f2c4ccf-7cf9-4dd2-bd92-7bab13bc3539")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }

                if ( ejercicioseleccionadopantorrillas.equals("Elevación de talón en prensa horizontal")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20horizontal%2F20211215_111104.jpg?alt=media&token=65f55792-18ee-4e71-bfd3-68788892af40")
                            .fit().centerCrop()
                            .into(imagenpantorrillas);
                }




                //pantorrillas
                if ( ejercicioseleccionadopantorrillas2.equals("Elevaciones de talón en costurera")) {
                    int reps = 15;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas2.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20costurera%2F20210220_123439.jpg?alt=media&token=cd5d5a75-3dfc-46ce-8b24-1b366faa38ee")
                            .fit().centerCrop()
                            .into(imagenpantorrillas2);
                }

                if (ejercicioseleccionadopantorrillas2.equals("Elevaciones de talón en prensa a 1 pierna")) {
                    int reps = 10;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas2.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20a%201%20pierna%2F20210215_130011.jpg?alt=media&token=d3f4cafe-26f6-4cd2-a862-d02e29ff75ba")
                            .fit().centerCrop()
                            .into(imagenpantorrillas2);
                }

                if ( ejercicioseleccionadopantorrillas2.equals("Elevación de talón parado con mancuernas")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas2.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20parado%20con%20mancuerna%2F20210310_120558.jpg?alt=media&token=3d5edaad-c045-4256-aea7-34d967faef76")
                            .fit().centerCrop()
                            .into(imagenpantorrillas2);
                }

                if ( ejercicioseleccionadopantorrillas2.equals("Elevación de talón parado en máquina")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas2.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20sentadilla%20perfecta%2F20211215_113308.jpg?alt=media&token=8ebb1b76-9791-414a-8965-b6504b4b2d7b")
                            .fit().centerCrop()
                            .into(imagenpantorrillas2);
                }

                if ( ejercicioseleccionadopantorrillas2.equals("Elevación de talón en prensa 45°")) {
                    int reps = 8;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas2.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaci%C3%B3n%20de%20tal%C3%B3n%20en%20prensa%2045%C2%B0%2FIMG_0369.jpg?alt=media&token=1f2c4ccf-7cf9-4dd2-bd92-7bab13bc3539")
                            .fit().centerCrop()
                            .into(imagenpantorrillas2);
                }

                if ( ejercicioseleccionadopantorrillas2.equals("Elevación de talón en prensa horizontal")) {
                    int reps = 12;
                    String repespant = Integer.toString(reps);
                    repeticionespantorrillas2.setText(repespant + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20horizontal%2F20211215_111104.jpg?alt=media&token=65f55792-18ee-4e71-bfd3-68788892af40")
                            .fit().centerCrop()
                            .into(imagenpantorrillas2);
                }









                //abs
                if ( ejercicioseleccionadoabdomen.equals("Crunch abdominal en maquina con cuerda")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20maquina%20con%20cuerda%2F20210203_122801.jpg?alt=media&token=b7b6492d-0e43-4d80-8e4a-58a874b0b740")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if (  ejercicioseleccionadoabdomen.equals("Crunch abdominal")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121917.jpg?alt=media&token=6a7354cf-d38a-4931-ae6d-3bd5a0a6f1a1")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if (  ejercicioseleccionadoabdomen.equals("Crunch abdominal en maquina")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123647.jpg?alt=media&token=21d241b4-69a6-4e42-8f6b-d8eab01d5e16")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if (  ejercicioseleccionadoabdomen.equals("Rodillo abdominal")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112445.jpg?alt=media&token=65fbc2e2-c04e-4300-af76-36ba341c3a1b")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if (  ejercicioseleccionadoabdomen.equals("Elevaciones de piernas acostado en banco")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854.jpg?alt=media&token=9cab081e-a91e-40ef-8be1-e481445eddd1")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if ( ejercicioseleccionadoabdomen.equals("Elevaciones de piernas en silla romana")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112604.jpg?alt=media&token=a27b1953-a16e-419b-b206-ad01ebf5138d")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if (  ejercicioseleccionadoabdomen.equals("Crunch tipo bicicleta")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if (  ejercicioseleccionadoabdomen.equals("Crunch abdominal en banco declinado")) {
                    int reps = 10;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113147.jpg?alt=media&token=55b3d636-887e-4c01-ba37-e274fce2e1d1")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if ( ejercicioseleccionadoabdomen.equals("Crunch abdominal en banco declinado con balon en la nuca")) {
                    int reps = 8;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113217.jpg?alt=media&token=a6ad17e7-d218-41c7-9412-b26ffd74fc38")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if (  ejercicioseleccionadoabdomen.equals("Crunch acostado en flexión de piernas")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20con%20flexi%C3%B3n%20de%20piernas%2F20211210_113340.jpg?alt=media&token=063a87c6-0413-4e4f-b103-8e1892a93987")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if (  ejercicioseleccionadoabdomen.equals("Crunch lateral")) {
                    int reps = 18;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113437.jpg?alt=media&token=eccbfefe-6820-4879-b370-0ccb1454573e")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if (  ejercicioseleccionadoabdomen.equals("Toques al talón")) {
                    int reps = 15;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113834.jpg?alt=media&token=3521bce4-bbd0-4936-9994-1df7bd3f72d4")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if (  ejercicioseleccionadoabdomen.equals("Crunch lateral con polea alta")) {
                    int reps = 12;
                    String repesabs = Integer.toString(reps);
                    repeticionesbadomen.setText(repesabs + " Reps");
                    Picasso.get()
                            .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113702.jpg?alt=media&token=1717a072-a610-449b-8a35-3dec01aded1a")
                            .fit().centerCrop()
                            .into(imageneabdomen);
                }

                if (  ejercicioseleccionadoabdomen.equals("Crunch abdominal hincado con cuerda")) {
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

                String ejerciciolateral = datasnapshot.child("deltoides laterales y posteriores/ ejercicio primario").getValue().toString();
                String ejerciciolateral2 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio secundario").getValue().toString();
                String ejerciciolateral3 = datasnapshot.child("deltoides laterales y posteriores/ ejercicio tercero").getValue().toString();

                String ejerciciocuadriceps = datasnapshot.child("cuadriceps/ ejercicio primario").getValue().toString();
                String ejerciciocuadriceps2 = datasnapshot.child("cuadriceps/ ejercicio secundario").getValue().toString();
                String ejerciciocuadriceps3 = datasnapshot.child("cuadriceps/ ejercicio tercero").getValue().toString();

                String ejerciciofemorales = datasnapshot.child("isquios/ ejercicio primario").getValue().toString();
                String ejerciciofemorales2 = datasnapshot.child("isquios/ ejercicio secundario").getValue().toString();
                String ejerciciofemorales3 = datasnapshot.child("isquios/ ejercicio tercero").getValue().toString();


                String ejerciciogluteos = datasnapshot.child("gluteos y aductores/ ejercicio primario").getValue().toString();
                String ejerciciogluteos2 = datasnapshot.child("gluteos y aductores/ ejercicio secundario").getValue().toString();


                String ejerciciopantor = datasnapshot.child("pantorrillas/ ejercicio primario").getValue().toString();
                String ejerciciopantor2 = datasnapshot.child("pantorrillas/ ejercicio secundario").getValue().toString();


                String ejercicioabdomen = datasnapshot.child("abdominales/ ejercicio primario").getValue().toString();




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





                    //deltoides laterales
                    switch(ejerciciolateral){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer7.setText("3 - 4 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer7.setText("3 - 4 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Facepull con cuerda":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer7.setText("2 - 3 RER");
                            break;

                    }


                    //deltoides laterales
                    switch(ejerciciolateral2){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer8.setText("3 - 4 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer8.setText("3 - 4 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer8.setText("3 - 4 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer8.setText("3 - 4 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Facepull con cuerda":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer8.setText("2 - 3 RER");
                            break;

                    }

                    //deltoides laterales
                    switch(ejerciciolateral3){
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











                    //PANTORRILLAS
                    switch(ejerciciopantor){
                        //ejercicios compuestos
                        case "Elevación de talón parado en máquina":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Elevación de talón en prensa 45°":
                            rer12.setText("3 - 4 RER");
                            break;

                        case "Elevaciones de talón en prensa a 1 pierna":
                            rer12.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "ELevación de talón parado con mancuernas":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevaciones de talón en costurera":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevación de talón en prensa horizontal":
                            rer12.setText("2 - 3 RER");
                            break;
                    }



                    //PANTORRILLAS
                    switch(ejerciciopantor){
                        //ejercicios compuestos
                        case "Elevación de talón parado en máquina":
                            rer13.setText("3 - 4 RER");
                            break;

                        case "Elevación de talón en prensa 45°":
                            rer13.setText("3 - 4 RER");
                            break;

                        case "Elevaciones de talón en prensa a 1 pierna":
                            rer13.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "ELevación de talón parado con mancuernas":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Elevaciones de talón en costurera":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Elevación de talón en prensa horizontal":
                            rer13.setText("2 - 3 RER");
                            break;
                    }




                    //gluteos
                    switch(ejerciciogluteos){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Patada para glúteos con máquina de pie":
                            rer10.setText("3 - 4 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer10.setText("3 - 4 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Aducciones de cadera en máquina":
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

                        case "Abducciones de cadera en máquina":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Patada para glúteo con polea":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Patada para glúteos en máquina":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Puente con mancuerna":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Patada para glúteo con mancuerna":
                            rer10.setText("2 - 3 RER");
                            break;

                    }

                    //gluteos
                    switch(ejerciciogluteos){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Patada para glúteos con máquina de pie":
                            rer11.setText("3 - 4 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer11.setText("3 - 4 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Aducciones de cadera en máquina":
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

                        case "Abducciones de cadera en máquina":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Patada para glúteo con polea":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Patada para glúteos en máquina":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Puente con mancuerna":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Patada para glúteo con mancuerna":
                            rer11.setText("2 - 3 RER");
                            break;

                    }







                    //ISQUIOS
                    switch(ejerciciofemorales){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer4.setText("3 - 4 RER");
                            break;

                        case "Peso muerto en smith":
                            rer4.setText("3 - 4 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Curl femoral acostado en máquina":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Curl femoral acostado en máquina a 1 pierna":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Curl femoral sentado en máquina":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en máquina":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Elevación de cadera a una pierna":
                            rer4.setText("2 - 3 RER");
                            break;

                    }



                    //ISQUIOS
                    switch(ejerciciofemorales2){
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

                        case "Curl femoral acostado en máquina":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl femoral acostado en máquina a 1 pierna":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl femoral sentado en máquina":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en máquina":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Elevación de cadera a una pierna":
                            rer5.setText("2 - 3 RER");
                            break;

                    }




                    //ISQUIOS
                    switch(ejerciciofemorales3){
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

                        case "Curl femoral acostado en máquina":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl femoral acostado en máquina a 1 pierna":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl femoral sentado en máquina":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en máquina":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Elevación de cadera a una pierna":
                            rer6.setText("2 - 3 RER");
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

                        case "Prensa a 45°":
                            rer1.setText("3 - 4 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer1.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90°":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Prensa horizontal en máquina":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Sentadilla en máquina perfecta":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Extensiones de cuadriceps en máquina":
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

                        case "Prensa a 45°":
                            rer2.setText("3 - 4 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer2.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90°":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Prensa horizontal en máquina":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Sentadilla en máquina perfecta":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Extensiones de cuadriceps en máquina":
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

                        case "Prensa a 45°":
                            rer3.setText("3 - 4 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer3.setText("3 - 4 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90°":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Prensa horizontal en máquina":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Sentadilla en máquina perfecta":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Extensiones de cuadriceps en máquina":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Sentadilla":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer3.setText("2 - 3 RER");
                            break;

                    }



//--------------------------------------


                }
                // RER FINAL  1 - 2 Y 0 - 1

                if (rer1int <= 12){




                    //abdomen
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

                    //deltoides laterales
                    switch(ejerciciolateral){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer7.setText("1 - 2 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Facepull con cuerda":
                            rer7.setText("0 - 1 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer7.setText("0 - 1 RER");
                            break;

                    }


                    //deltoides laterales
                    switch(ejerciciolateral2){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer8.setText("1 - 2 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Facepull con cuerda":
                            rer8.setText("0 - 1 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer8.setText("0 - 1 RER");
                            break;

                    }

                    //deltoides laterales
                    switch(ejerciciolateral3){
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








                    //PANTORRILLAS
                    switch(ejerciciopantor){
                        //ejercicios compuestos
                        case "Elevación de talón parado en máquina":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevación de talón en prensa 45°":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de talón en prensa a 1 pierna":
                            rer12.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "ELevación de talón parado con mancuernas":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Elevaciones de talón en costurera":
                            rer12.setText("0 - 1 RER");
                            break;

                        case "Elevación de talón en prensa horizontal":
                            rer12.setText("0 - 1 RER");
                            break;
                    }

                    switch(ejerciciopantor2){
                        //ejercicios compuestos
                        case "Elevación de talón parado en máquina":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Elevación de talón en prensa 45°":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de talón en prensa a 1 pierna":
                            rer13.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "ELevación de talón parado con mancuernas":
                            rer13.setText("0 - 1 RER");
                            break;

                        case "Elevaciones de talón en costurera":
                            rer13.setText("0 - 1 RER");
                            break;

                        case "Elevación de talón en prensa horizontal":
                            rer13.setText("0 - 1 RER");
                            break;
                    }



                    //gluteos
                    switch(ejerciciogluteos){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Patada para glúteos con máquina de pie":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer10.setText("1 - 2 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Aducciones de cadera en máquina":
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

                        case "Abducciones de cadera en máquina":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Patada para glúteo con polea":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Patada para glúteos en máquina":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Puente con mancuerna":
                            rer10.setText("0 - 1 RER");
                            break;

                        case "Patada para glúteo con mancuerna":
                            rer10.setText("0 - 1 RER");
                            break;

                    }


                    //gluteos
                    switch(ejerciciogluteos2){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Patada para glúteos con máquina de pie":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer11.setText("1 - 2 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Aducciones de cadera en máquina":
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

                        case "Abducciones de cadera en máquina":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Patada para glúteo con polea":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Patada para glúteos en máquina":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Puente con mancuerna":
                            rer11.setText("0 - 1 RER");
                            break;

                        case "Patada para glúteo con mancuerna":
                            rer11.setText("0 - 1 RER");
                            break;

                    }





                    //ISQUIOS
                    switch(ejerciciofemorales){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Peso muerto en smith":
                            rer4.setText("1 - 2 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en máquina":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en máquina a 1 pierna":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Curl femoral sentado en máquina":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en máquina":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer4.setText("0 - 1 RER");
                            break;

                        case "Elevación de cadera a una pierna":
                            rer4.setText("0 - 1 RER");
                            break;

                    }



                    //ISQUIOS
                    switch(ejerciciofemorales2){
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

                        case "Curl femoral acostado en máquina":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en máquina a 1 pierna":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl femoral sentado en máquina":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en máquina":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer5.setText("0 - 1 RER");
                            break;

                        case "Elevación de cadera a una pierna":
                            rer5.setText("0 - 1 RER");
                            break;

                    }


                    //ISQUIOS
                    switch(ejerciciofemorales3){
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

                        case "Curl femoral acostado en máquina":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl femoral acostado en máquina a 1 pierna":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl femoral sentado en máquina":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en máquina":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer6.setText("0 - 1 RER");
                            break;

                        case "Elevación de cadera a una pierna":
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

                        case "Prensa a 45°":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer1.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90°":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Prensa horizontal en máquina":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Sentadilla en máquina perfecta":
                            rer1.setText("0 - 1 RER");
                            break;

                        case "Extensiones de cuadriceps en máquina":
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

                        case "Prensa a 45°":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer2.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90°":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Prensa horizontal en máquina":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Sentadilla en máquina perfecta":
                            rer2.setText("0 - 1 RER");
                            break;

                        case "Extensiones de cuadriceps en máquina":
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

                        case "Prensa a 45°":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer3.setText("1 - 2 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90°":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Prensa horizontal en máquina":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Sentadilla en máquina perfecta":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Extensiones de cuadriceps en máquina":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Sentadilla":
                            rer3.setText("0 - 1 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer3.setText("0 - 1 RER");
                            break;

                    }








                }

                // RER MEDIO 2 - 3  Y 1 - 2

                if (rer1int>13 && rer1int<=17){




                    //abdomen
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
                            rer14.setText("1 - 1 RER");
                            break;

                        case "Crunch acostado en flexión de piernas":
                            rer14.setText("1 - 2 RER");
                            break;

                        case "Crunch lateral":
                            rer14.setText("1 - 2 RER");
                            break;

                    }


                    //deltoides laterales
                    switch(ejerciciolateral){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer7.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer7.setText("2 - 3 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Facepull con cuerda":
                            rer7.setText("1 - 2 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer7.setText("1 - 2 RER");
                            break;

                    }

                    //deltoides laterales
                    switch(ejerciciolateral2){
                        //ejercicios compuestos
                        case "Remo al mentón con barra":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Elevaciones laterales con mancuernas":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                            rer8.setText("2 - 3 RER");
                            break;

                        case "Remo al mentón con mancuernas":
                            rer8.setText("2 - 3 RER");
                            break;



                        //ejercicios csimples
                        case "Elevación lateral con polea baja por detrás":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Flys invertidos en peck deck":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Flys agachado con mancuernas":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con mancuerna a 45°":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Elevación lateral con polea baja":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Remo al mentón con polea baja":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Facepull con cuerda":
                            rer8.setText("1 - 2 RER");
                            break;

                        case "Flys cruzados con poleas":
                            rer8.setText("1 - 2 RER");
                            break;

                    }

                    //deltoides laterales
                    switch(ejerciciolateral3){
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




                    //PANTORRILLAS
                    switch(ejerciciopantor){
                        //ejercicios compuestos
                        case "Elevación de talón parado en máquina":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevación de talón en prensa 45°":
                            rer12.setText("2 - 3 RER");
                            break;

                        case "Elevaciones de talón en prensa a 1 pierna":
                            rer12.setText("2 - 3 RER");
                            break;



                        //ejercicios simples
                        case "ELevación de talón parado con mancuernas":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de talón en costurera":
                            rer12.setText("1 - 2 RER");
                            break;

                        case "Elevación de talón en prensa horizontal":
                            rer12.setText("1 - 2 RER");
                            break;
                    }

                    //PANTORRILLAS
                    switch(ejerciciopantor2){
                        //ejercicios compuestos
                        case "Elevación de talón parado en máquina":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Elevación de talón en prensa 45°":
                            rer13.setText("2 - 3 RER");
                            break;

                        case "Elevaciones de talón en prensa a 1 pierna":
                            rer13.setText("2 - 3 RER");
                            break;



                        //ejercicios simples
                        case "ELevación de talón parado con mancuernas":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Elevaciones de talón en costurera":
                            rer13.setText("1 - 2 RER");
                            break;

                        case "Elevación de talón en prensa horizontal":
                            rer13.setText("1 - 2 RER");
                            break;
                    }



                    //gluteos
                    switch(ejerciciogluteos){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Patada para glúteos con máquina de pie":
                            rer10.setText("2 - 3 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer10.setText("2 - 3 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Aducciones de cadera en máquina":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Peso muerto tipo sumo con mancuernal":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Goblet squat":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Abducciones de cadera en polea":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Abducciones de cadera en máquina":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Patada para glúteo con polea":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Patada para glúteos en máquina":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Puente con mancuerna":
                            rer10.setText("1 - 2 RER");
                            break;

                        case "Patada para glúteo con mancuerna":
                            rer10.setText("1 - 2 RER");
                            break;

                    }

                    //gluteos
                    switch(ejerciciogluteos2){
                        //ejercicios compuestos
                        case "Hip thrust con barra":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Peso muerto tipo sumo con barra":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Patada para glúteos con máquina de pie":
                            rer11.setText("2 - 3 RER");
                            break;

                        case "Sentadilla smith tipo sumo":
                            rer11.setText("2 - 3 RER");
                            break;

                        //ejercicios simples
                        case "Aducciones de cadera en polea":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Aducciones de cadera en máquina":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Peso muerto tipo sumo con mancuernal":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Goblet squat":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Abducciones de cadera en polea":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Abducciones de cadera en máquina":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Patada para glúteo con polea":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Patada para glúteos en máquina":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Puente a 1 pierna":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Puente con mancuerna":
                            rer11.setText("1 - 2 RER");
                            break;

                        case "Patada para glúteo con mancuerna":
                            rer11.setText("1 - 2 RER");
                            break;

                    }



                    //ISQUIOS
                    switch(ejerciciofemorales){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer4.setText("2 - 3 RER");
                            break;

                        case "Peso muerto en smith":
                            rer4.setText("2 - 3 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Curl femoral acostado en máquina":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Curl femoral acostado en máquina a 1 pierna":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Curl femoral sentado en máquina":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en máquina":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer4.setText("1 - 2 RER");
                            break;

                        case "Elevación de cadera a una pierna":
                            rer4.setText("1 - 2 RER");
                            break;

                    }

                    //ISQUIOS
                    switch(ejerciciofemorales2){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer5.setText("2 - 3 RER");
                            break;

                        case "Peso muerto en smith":
                            rer5.setText("2 - 3 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl femoral acostado en máquina":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl femoral acostado en máquina a 1 pierna":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl femoral sentado en máquina":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en máquina":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer5.setText("1 - 2 RER");
                            break;

                        case "Elevación de cadera a una pierna":
                            rer5.setText("1 - 2 RER");
                            break;

                    }

                    //ISQUIOS
                    switch(ejerciciofemorales3){
                        //ejercicios compuestos
                        case "Peso muerto con piernas rigidas con barra":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Peso muerto con mancuernas":
                            rer6.setText("2 - 3 RER");
                            break;

                        case "Peso muerto en smith":
                            rer6.setText("2 - 3 RER");
                            break;


                        //ejercicios simples
                        case "Peso muerto a 1 pierna":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl femoral acostado en máquina":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl femoral acostado en máquina a 1 pierna":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl femoral sentado en máquina":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl femoral parado a 1 pierna en máquina":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Curl acostado con mancuerna":
                            rer6.setText("1 - 2 RER");
                            break;

                        case "Elevación de cadera a una pierna":
                            rer6.setText("1 - 2 RER");
                            break;

                    }




                    //cuadriceps
                    switch(ejerciciocuadriceps){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Sentadilla con barra":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Prensa a 45°":
                            rer1.setText("2 - 3 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer1.setText("2 - 3 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90°":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Prensa horizontal en máquina":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Sentadilla en máquina perfecta":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Extensiones de cuadriceps en máquina":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Sentadilla":
                            rer1.setText("1 - 2 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer1.setText("1 - 2 RER");
                            break;

                    }







                    //cuadriceps
                    switch(ejerciciocuadriceps2){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Sentadilla con barra":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Prensa a 45°":
                            rer2.setText("2 - 3 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer2.setText("2 - 3 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90°":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Prensa horizontal en máquina":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Sentadilla en máquina perfecta":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Extensiones de cuadriceps en máquina":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Sentadilla":
                            rer2.setText("1 - 2 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer2.setText("1 - 2 RER");
                            break;

                    }





                    //cuadriceps
                    switch(ejerciciocuadriceps3){
                        //ejercicios compuestos
                        case "Sentadilla frontal con barra":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Sentadilla smith profunda":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Sentadilla con barra":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Sentadilla frontal en smith":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Prensa a 45°":
                            rer3.setText("2 - 3 RER");
                            break;

                        case "Sentadilla bulgara con mancuernas":
                            rer3.setText("2 - 3 RER");
                            break;



                        //ejercicios simples
                        case "Sentadlla smith a 90°":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Prensa a 1 pierna":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Desplantes con mancuernas":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Prensa horizontal en máquina":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Sentadilla en máquina perfecta":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Extensiones de cuadriceps en máquina":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Sentadilla":
                            rer3.setText("1 - 2 RER");
                            break;

                        case "Sentadilla frontal con mancuernas":
                            rer3.setText("1 - 2 RER");
                            break;

                    }


                }



//-------------------------------------------------------------------------------------------------------------------------------------------------------------

                //SERIES



                String slateral = datasnapshot.child("series deltoides laterales y posteriores").getValue().toString();
                Double slat = Double.parseDouble(slateral);
                Double slateraldividido = slat / 2;
                Double slateralf = Math.ceil(slateraldividido);
                Double slateralf1 = slateralf / 3;
                Double slateralf2 = slateralf / 3;
                Double slateralf3 = slateralf / 3;
                int slateralint = (int) Math.ceil(slateralf1);
                int slateralint2 = (int) Math.round(slateralf2);
                if (slateralint2 == 1){
                    slateralint2++;
                }
                int slateralint3 = (int) Math.floor(slateralf3);
                if (slateralint3 == 1){
                    slateralint3++;
                }
                String seriesfinallateral = String.valueOf(slateralint);
                String seriesfinallateral2 = String.valueOf(slateralint2);
                String seriesfinallateral3 = String.valueOf(slateralint3);
                serieslateral.setText(seriesfinallateral + " Series");
                serieslateral2.setText(seriesfinallateral2 + " Series");
                serieslateral3.setText(seriesfinallateral3 + " Series");



                String scuadriceps = datasnapshot.child("series cuadriceps").getValue().toString();
                Double scuad = Double.parseDouble(scuadriceps);
                Double scuaddividido = scuad / 2;
                Double scuadf = Math.ceil(scuaddividido);
                Double scuadf1 = scuadf / 3;
                Double scuadf2 = scuadf / 3;
                Double scuadf3 = scuadf / 3;
                int scuadint = (int) Math.ceil(scuadf1);
                int scuadint2 = (int) Math.round(scuadf2);
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
                seriescuadriceps.setText(seriesfinalcuad + " Series");
                seriescuadriceps2.setText(seriesfinalcuad2 + " Series");
                seriescuadriceps3.setText(seriesfinalcuad3 + " Series");


                String sfemorales = datasnapshot.child("series femorales").getValue().toString();
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
                seriesfemoral.setText(seriesfinalfemorales + " Series");
                seriesfemoral2.setText(seriesfinalfemorales2 + " Series");
                seriesfemoral3.setText(seriesfinalfemorales3 + " Series");


                String sgluteos = datasnapshot.child("series gluteos").getValue().toString();
                Double sgl = Double.parseDouble(sgluteos);
                Double sgluteosdividido = sgl / 2;
                Double sgluteosf = Math.ceil(sgluteosdividido);
                Double sgluteosf1 = sgluteosf / 2;
                Double sgluteosf2 = sgluteosf / 2;
                int sgluteosint = (int) Math.round(sgluteosf1);
                if (sgluteosint == 1){
                    sgluteosint++;
                }
                int sgluteosint2 = (int) Math.floor(sgluteosf2);
                if (sgluteosint2 == 1){
                    sgluteosint2++;
                }
                String seriesgluteosfinal = String.valueOf(sgluteosint);
                String seriesgluteosfinal2 = String.valueOf(sgluteosint2);
                seriesgluteos.setText(seriesgluteosfinal + " Series");
                seriesgluteos2.setText(seriesgluteosfinal2 + " Series");


                String spantorrillas = datasnapshot.child("series pantorrillas").getValue().toString();
                Double span = Double.parseDouble(spantorrillas);
                Double spantorrillasdividido = span / 2;
                Double spantof = Math.ceil(spantorrillasdividido);
                Double spantof1 = spantof / 2;
                Double spantof2 = spantof / 2;
                int spantorrillasint = (int) Math.round(spantof1);
                if (spantorrillasint == 1){
                    spantorrillasint++;
                }
                int spantorrillasint2 = (int) Math.floor(spantof2);
                if (spantorrillasint2 == 1){
                    spantorrillasint2++;
                }
                String seriesfinalpantorrillas = String.valueOf(spantorrillasint);
                String seriesfinalpantorrillas2 = String.valueOf(spantorrillasint2);
                seriespantorrillas.setText(seriesfinalpantorrillas + " Series");
                seriespantorrillas2.setText(seriesfinalpantorrillas2 + " Series");



                String sabdomen = datasnapshot.child("series abdominales").getValue().toString();
                Double sabds = Double.parseDouble(sabdomen);
                Double sabdomendividido = sabds / 2;
                Double sabsf = Math.ceil(sabdomendividido);
                int sabdomenint = (int) Math.round(sabsf);
                if (sabdomenint == 1){
                    sabdomenint++;
                }
                String seriesfinalabdomen = String.valueOf(sabdomenint);
                seriesabdomen.setText(seriesfinalabdomen + " Series");





                String stringpesoiniciallateral = datasnapshot.child("Historial deltoides laterales y posteriores/ 4 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesolateral.setText(stringpesoiniciallateral);

                String stringpesoiniciallateral2 = datasnapshot.child("Historial deltoides laterales y posteriores/ 4 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesolateral2.setText(stringpesoiniciallateral2);

                String stringpesoiniciallateral3 = datasnapshot.child("Historial deltoides laterales y posteriores/ 4 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesolateral3.setText(stringpesoiniciallateral3);



                String stringpesoinicialcuadriceps = datasnapshot.child("Historial cuadriceps/ 4 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesocuadriceps.setText(stringpesoinicialcuadriceps);

                String stringpesoinicialcuadriceps2 = datasnapshot.child("Historial cuadriceps/ 4 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesocuadriceps2.setText(stringpesoinicialcuadriceps2);

                String stringpesoinicialcuadriceps3 = datasnapshot.child("Historial cuadriceps/ 4 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesocuadriceps3.setText(stringpesoinicialcuadriceps3);




                String stringpesoinicialfemoral = datasnapshot.child("Historial isquios/ 4 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesofemoral.setText(stringpesoinicialfemoral);

                String stringpesoinicialfemoral2 = datasnapshot.child("Historial isquios/ 4 dias/ segundo ejercicio/ dia 1").getValue().toString();
                pesofemora2.setText(stringpesoinicialfemoral2);

                String stringpesoinicialfemoral3 = datasnapshot.child("Historial isquios/ 4 dias/ tercer ejercicio/ dia 1").getValue().toString();
                pesofemoral3.setText(stringpesoinicialfemoral3);



                String stringpesoinicialpantorrillas = datasnapshot.child("Historial pantorrillas/ 4 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesopantorrillas.setText(stringpesoinicialpantorrillas);

                String stringpesoinicialpantorrillas2 = datasnapshot.child("Historial pantorrillas/ 4 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesopantorrillas2.setText(stringpesoinicialpantorrillas2);



                String stringpesoinicialgluteos = datasnapshot.child("Historial gluteos y aductores/ 4 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesogluteos.setText(stringpesoinicialgluteos);

                String stringpesoinicialgluteos2 = datasnapshot.child("Historial gluteos y aductores/ 4 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesogluteos2.setText(stringpesoinicialgluteos2);



                String stringpesoinicialabdomen = datasnapshot.child("Historial abdomen/ 4 dias/ primer ejercicio/ dia 1").getValue().toString();
                pesoabdomen.setText(stringpesoinicialabdomen);




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





    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void buttonfindelentrenamiento4diamartesb (View view){

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
                    mInterstitialAd.show(entreno4diamartes.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }

            }
        }, 300);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();
        String datoejercicio1 = pesocuadriceps.getText().toString();
        String datoejercicio1_2 = pesocuadriceps2.getText().toString();
        String datoejercicio1_3 = pesocuadriceps3.getText().toString();

        String datoejercicio2 = pesofemoral.getText().toString();
        String datoejercicio2_2 = pesofemora2.getText().toString();
        String datoejercicio2_3 = pesofemoral3.getText().toString();

        String datoejercicio3 = pesolateral.getText().toString();
        String datoejercicio3_2 = pesolateral2.getText().toString();
        String datoejercicio4 = pesolateral3.getText().toString();

        String datoejercicio4_2 = pesogluteos.getText().toString();
        String datoejercicio5 = pesogluteos2.getText().toString();

        String datoejercicio5_2 = pesopantorrillas.getText().toString();
        String datoejercicio10 = pesopantorrillas2.getText().toString();

        String datoejercicio10_2 = pesoabdomen.getText().toString();



        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                Map<String, Object> pesoactualizandose2 = new HashMap<>();
                pesoactualizandose2.put("Historial cuadriceps/ 4 dias/ primer ejercicio/ dia 1", datoejercicio1);
                pesoactualizandose2.put("Historial cuadriceps/ 4 dias/ segundo ejercicio/ dia 1", datoejercicio1_2);
                pesoactualizandose2.put("Historial cuadriceps/ 4 dias/ tercer ejercicio/ dia 1", datoejercicio1_3);

                pesoactualizandose2.put("Historial isquios/ 4 dias/ primer ejercicio/ dia 1", datoejercicio2);
                pesoactualizandose2.put("Historial isquios/ 4 dias/ segundo ejercicio/ dia 1", datoejercicio2_2);
                pesoactualizandose2.put("Historial isquios/ 4 dias/ tercer ejercicio/ dia 1", datoejercicio2_3);

                pesoactualizandose2.put("Historial deltoides laterales y posteriores/ 4 dias/ primer ejercicio/ dia 1", datoejercicio3);
                pesoactualizandose2.put("Historial deltoides laterales y posteriores/ 4 dias/ segundo ejercicio/ dia 1", datoejercicio3_2);
                pesoactualizandose2.put("Historial deltoides laterales y posteriores/ 4 dias/ tercer ejercicio/ dia 1", datoejercicio4);

                pesoactualizandose2.put("Historial gluteos y aductores/ 4 dias/ segundo ejercicio/ dia 1", datoejercicio4_2);
                pesoactualizandose2.put("Historial gluteos y aductores/ 4 dias/ primer ejercicio/ dia 1", datoejercicio5);

                pesoactualizandose2.put("Historial pantorrillas/ 4 dias/ segundo ejercicio/ dia 1", datoejercicio5_2);
                pesoactualizandose2.put("Historial pantorrillas/ 4 dias/ primer ejercicio/ dia 1", datoejercicio10);

                pesoactualizandose2.put("Historial abdomen/ 4 dias/ primer ejercicio/ dia 1", datoejercicio10_2);


                mDatabase.child("Users").child(id).updateChildren(pesoactualizandose2);

                //si se modifica el datachange en algun otro momento envia a esta pantalla, por lo cual se condiciona el envio
                boolean botonpresionado = true;

                if (botonpresionado == true){


                    Intent findelentrenamiento = new Intent(entreno4diamartes .this, entrenamientofinalizado.class);
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


    }

    public void ejercicio (View view){
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String ej = datasnapshot.child("cuadriceps/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno4diamartes.this, ejercicio.class);
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
                Intent ejercicio = new Intent(entreno4diamartes.this, ejercicio.class);
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
                Intent ejercicio = new Intent(entreno4diamartes.this, ejercicio.class);
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
                Intent ejercicio = new Intent(entreno4diamartes.this, ejercicio.class);
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
                Intent ejercicio = new Intent(entreno4diamartes.this, ejercicio.class);
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
                Intent ejercicio = new Intent(entreno4diamartes.this, ejercicio.class);
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
                Intent ejercicio = new Intent(entreno4diamartes.this, ejercicio.class);
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
                Intent ejercicio = new Intent(entreno4diamartes.this, ejercicio.class);
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
                Intent ejercicio = new Intent(entreno4diamartes.this, ejercicio.class);
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
                String ej = datasnapshot.child("gluteos y aductores/ ejercicio primario").getValue().toString();
                Intent ejercicio = new Intent(entreno4diamartes.this, ejercicio.class);
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
                String ej = datasnapshot.child("gluteos y aductores/ ejercicio secundario").getValue().toString();
                Intent ejercicio = new Intent(entreno4diamartes.this, ejercicio.class);
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
                Intent ejercicio = new Intent(entreno4diamartes.this, ejercicio.class);
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
                Intent ejercicio = new Intent(entreno4diamartes.this, ejercicio.class);
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
                Intent ejercicio = new Intent(entreno4diamartes.this, ejercicio.class);
                ejercicio.putExtra("ej", ej);
                startActivity(ejercicio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }



}
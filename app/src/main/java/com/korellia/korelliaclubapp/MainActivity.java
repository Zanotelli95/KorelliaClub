package com.korellia.korelliaclubapp;

import android.os.Bundle;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.korellia.korelliaclubapp.databinding.ActivityMainBinding;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private static final String TAG = "";
    private ActivityMainBinding binding;
    private DatabaseReference mDatabase1;
    private FirebaseAuth mAuth1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);

// anuncios

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.navigation_home, R.id.navigation_dashboard, R.id.progresos, R.id.me)
                    .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        ActionBar actionbar = getSupportActionBar();
     //  actionbar.hide();



       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.ic_baseline_email_24);
        //getSupportActionBar().setLogo(R.drawable.ic_baseline_email_24);



        mAuth1 = FirebaseAuth.getInstance();
        mDatabase1 = FirebaseDatabase.getInstance().getReference();
        String id = mAuth1.getCurrentUser().getUid();


// actualizacion 1.8
        mDatabase1.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                Map< String, Object > generadorcm = new HashMap<>();
                generadorcm.put("preferencia medidas", "centimetros");
                mDatabase1.child("Users").child(id).updateChildren(generadorcm);

                String puntaje = datasnapshot.child("puntaje medidas").getValue().toString();

                if (puntaje.equals("true")){

                    Map< String, Object > generador = new HashMap<>();
                    generador.put("Brazo contraido/ primera medida/ medida", "0");
                    generador.put("Brazo contraido/ primera medida/ fecha", "0");
                    generador.put("Brazo contraido/ segunda medida/ medida", "0");
                    generador.put("Brazo contraido/ segunda medida/ fecha", "0");
                    generador.put("Brazo contraido/ tercer medida/ medida", "0");
                    generador.put("Brazo contraido/ tercer medida/ fecha", "0");
                    generador.put("Brazo contraido/ cuarto medida/ medida", "0");
                    generador.put("Brazo contraido/ cuarto medida/ fecha", "0");
                    generador.put("Brazo contraido/ quinto medida/ medida", "0");
                    generador.put("Brazo contraido/ quinto medida/ fecha", "0");
                    generador.put("Brazo contraido/ sexto medida/ medida", "0");
                    generador.put("Brazo contraido/ sexto medida/ fecha", "0");
                    generador.put("Brazo contraido/ septimo medida/ medida", "0");
                    generador.put("Brazo contraido/ septimo medida/ fecha", "0");
                    generador.put("Brazo contraido/ octavo medida/ medida", "0");
                    generador.put("Brazo contraido/ octavo medida/ fecha", "0");
                    generador.put("Brazo contraido/ noveno medida/ medida", "0");
                    generador.put("Brazo contraido/ noveno medida/ fecha", "0");
                    generador.put("Brazo contraido/ decimo medida/ medida", "0");
                    generador.put("Brazo contraido/ decimo medida/ fecha", "0");
                    generador.put("Brazo contraido/ onceavo medida/ medida", "0");
                    generador.put("Brazo contraido/ onceavo medida/ fecha", "0");
                    generador.put("Brazo contraido/ doceavo medida/ medida", "0");
                    generador.put("Brazo contraido/ doceavo medida/ fecha", "0");

                    generador.put("Brazo relajado/ primera medida/ medida", "0");
                    generador.put("Brazo relajado/ primera medida/ fecha", "0");
                    generador.put("Brazo relajado/ segunda medida/ medida", "0");
                    generador.put("Brazo relajado/ segunda medida/ fecha", "0");
                    generador.put("Brazo relajado/ tercer medida/ medida", "0");
                    generador.put("Brazo relajado/ tercer medida/ fecha", "0");
                    generador.put("Brazo relajado/ cuarto medida/ medida", "0");
                    generador.put("Brazo relajado/ cuarto medida/ fecha", "0");
                    generador.put("Brazo relajado/ quinto medida/ medida", "0");
                    generador.put("Brazo relajado/ quinto medida/ fecha", "0");
                    generador.put("Brazo relajado/ sexto medida/ medida", "0");
                    generador.put("Brazo relajado/ sexto medida/ fecha", "0");
                    generador.put("Brazo relajado/ septimo medida/ medida", "0");
                    generador.put("Brazo relajado/ septimo medida/ fecha", "0");
                    generador.put("Brazo relajado/ octavo medida/ medida", "0");
                    generador.put("Brazo relajado/ octavo medida/ fecha", "0");
                    generador.put("Brazo relajado/ noveno medida/ medida", "0");
                    generador.put("Brazo relajado/ noveno medida/ fecha", "0");
                    generador.put("Brazo relajado/ decimo medida/ medida", "0");
                    generador.put("Brazo relajado/ decimo medida/ fecha", "0");
                    generador.put("Brazo relajado/ onceavo medida/ medida", "0");
                    generador.put("Brazo relajado/ onceavo medida/ fecha", "0");
                    generador.put("Brazo relajado/ doceavo medida/ medida", "0");
                    generador.put("Brazo relajado/ doceavo medida/ fecha", "0");

                    generador.put("Cadera/ primera medida/ medida", "0");
                    generador.put("Cadera/ primera medida/ fecha", "0");
                    generador.put("Cadera/ segunda medida/ medida", "0");
                    generador.put("Cadera/ segunda medida/ fecha", "0");
                    generador.put("Cadera/ tercer medida/ medida", "0");
                    generador.put("Cadera/ tercer medida/ fecha", "0");
                    generador.put("Cadera/ cuarto medida/ medida", "0");
                    generador.put("Cadera/ cuarto medida/ fecha", "0");
                    generador.put("Cadera/ quinto medida/ medida", "0");
                    generador.put("Cadera/ quinto medida/ fecha", "0");
                    generador.put("Cadera/ sexto medida/ medida", "0");
                    generador.put("Cadera/ sexto medida/ fecha", "0");
                    generador.put("Cadera/ septimo medida/ medida", "0");
                    generador.put("Cadera/ septimo medida/ fecha", "0");
                    generador.put("Cadera/ octavo medida/ medida", "0");
                    generador.put("Cadera/ octavo medida/ fecha", "0");
                    generador.put("Cadera/ noveno medida/ medida", "0");
                    generador.put("Cadera/ noveno medida/ fecha", "0");
                    generador.put("Cadera/ decimo medida/ medida", "0");
                    generador.put("Cadera/ decimo medida/ fecha", "0");
                    generador.put("Cadera/ onceavo medida/ medida", "0");
                    generador.put("Cadera/ onceavo medida/ fecha", "0");
                    generador.put("Cadera/ doceavo medida/ medida", "0");
                    generador.put("Cadera/ doceavo medida/ fecha", "0");

                    generador.put("Cintura/ primera medida/ medida", "0");
                    generador.put("Cintura/ primera medida/ fecha", "0");
                    generador.put("Cintura/ segunda medida/ medida", "0");
                    generador.put("Cintura/ segunda medida/ fecha", "0");
                    generador.put("Cintura/ tercer medida/ medida", "0");
                    generador.put("Cintura/ tercer medida/ fecha", "0");
                    generador.put("Cintura/ cuarto medida/ medida", "0");
                    generador.put("Cintura/ cuarto medida/ fecha", "0");
                    generador.put("Cintura/ quinto medida/ medida", "0");
                    generador.put("Cintura/ quinto medida/ fecha", "0");
                    generador.put("Cintura/ sexto medida/ medida", "0");
                    generador.put("Cintura/ sexto medida/ fecha", "0");
                    generador.put("Cintura/ septimo medida/ medida", "0");
                    generador.put("Cintura/ septimo medida/ fecha", "0");
                    generador.put("Cintura/ octavo medida/ medida", "0");
                    generador.put("Cintura/ octavo medida/ fecha", "0");
                    generador.put("Cintura/ noveno medida/ medida", "0");
                    generador.put("Cintura/ noveno medida/ fecha", "0");
                    generador.put("Cintura/ decimo medida/ medida", "0");
                    generador.put("Cintura/ decimo medida/ fecha", "0");
                    generador.put("Cintura/ onceavo medida/ medida", "0");
                    generador.put("Cintura/ onceavo medida/ fecha", "0");
                    generador.put("Cintura/ doceavo medida/ medida", "0");
                    generador.put("Cintura/ doceavo medida/ fecha", "0");

                    generador.put("Muslo/ primera medida/ medida", "0");
                    generador.put("Muslo/ primera medida/ fecha", "0");
                    generador.put("Muslo/ segunda medida/ medida", "0");
                    generador.put("Muslo/ segunda medida/ fecha", "0");
                    generador.put("Muslo/ tercer medida/ medida", "0");
                    generador.put("Muslo/ tercer medida/ fecha", "0");
                    generador.put("Muslo/ cuarto medida/ medida", "0");
                    generador.put("Muslo/ cuarto medida/ fecha", "0");
                    generador.put("Muslo/ quinto medida/ medida", "0");
                    generador.put("Muslo/ quinto medida/ fecha", "0");
                    generador.put("Muslo/ sexto medida/ medida", "0");
                    generador.put("Muslo/ sexto medida/ fecha", "0");
                    generador.put("Muslo/ septimo medida/ medida", "0");
                    generador.put("Muslo/ septimo medida/ fecha", "0");
                    generador.put("Muslo/ octavo medida/ medida", "0");
                    generador.put("Muslo/ octavo medida/ fecha", "0");
                    generador.put("Muslo/ noveno medida/ medida", "0");
                    generador.put("Muslo/ noveno medida/ fecha", "0");
                    generador.put("Muslo/ decimo medida/ medida", "0");
                    generador.put("Muslo/ decimo medida/ fecha", "0");
                    generador.put("Muslo/ onceavo medida/ medida", "0");
                    generador.put("Muslo/ onceavo medida/ fecha", "0");
                    generador.put("Muslo/ doceavo medida/ medida", "0");
                    generador.put("Muslo/ doceavo medida/ fecha", "0");

                    generador.put("Muslo medio/ primera medida/ medida", "0");
                    generador.put("Muslo medio/ primera medida/ fecha", "0");
                    generador.put("Muslo medio/ segunda medida/ medida", "0");
                    generador.put("Muslo medio/ segunda medida/ fecha", "0");
                    generador.put("Muslo medio/ tercer medida/ medida", "0");
                    generador.put("Muslo medio/ tercer medida/ fecha", "0");
                    generador.put("Muslo medio/ cuarto medida/ medida", "0");
                    generador.put("Muslo medio/ cuarto medida/ fecha", "0");
                    generador.put("Muslo medio/ quinto medida/ medida", "0");
                    generador.put("Muslo medio/ quinto medida/ fecha", "0");
                    generador.put("Muslo medio/ sexto medida/ medida", "0");
                    generador.put("Muslo medio/ sexto medida/ fecha", "0");
                    generador.put("Muslo medio/ septimo medida/ medida", "0");
                    generador.put("Muslo medio/ septimo medida/ fecha", "0");
                    generador.put("Muslo medio/ octavo medida/ medida", "0");
                    generador.put("Muslo medio/ octavo medida/ fecha", "0");
                    generador.put("Muslo medio/ noveno medida/ medida", "0");
                    generador.put("Muslo medio/ noveno medida/ fecha", "0");
                    generador.put("Muslo medio/ decimo medida/ medida", "0");
                    generador.put("Muslo medio/ decimo medida/ fecha", "0");
                    generador.put("Muslo medio/ onceavo medida/ medida", "0");
                    generador.put("Muslo medio/ onceavo medida/ fecha", "0");
                    generador.put("Muslo medio/ doceavo medida/ medida", "0");
                    generador.put("Muslo medio/ doceavo medida/ fecha", "0");

                    generador.put("Pantorrillas/ primera medida/ medida", "0");
                    generador.put("Pantorrillas/ primera medida/ fecha", "0");
                    generador.put("Pantorrillas/ segunda medida/ medida", "0");
                    generador.put("Pantorrillas/ segunda medida/ fecha", "0");
                    generador.put("Pantorrillas/ tercer medida/ medida", "0");
                    generador.put("Pantorrillas/ tercer medida/ fecha", "0");
                    generador.put("Pantorrillas/ cuarto medida/ medida", "0");
                    generador.put("Pantorrillas/ cuarto medida/ fecha", "0");
                    generador.put("Pantorrillas/ quinto medida/ medida", "0");
                    generador.put("Pantorrillas/ quinto medida/ fecha", "0");
                    generador.put("Pantorrillas/ sexto medida/ medida", "0");
                    generador.put("Pantorrillas/ sexto medida/ fecha", "0");
                    generador.put("Pantorrillas/ septimo medida/ medida", "0");
                    generador.put("Pantorrillas/ septimo medida/ fecha", "0");
                    generador.put("Pantorrillas/ octavo medida/ medida", "0");
                    generador.put("Pantorrillas/ octavo medida/ fecha", "0");
                    generador.put("Pantorrillas/ noveno medida/ medida", "0");
                    generador.put("Pantorrillas/ noveno medida/ fecha", "0");
                    generador.put("Pantorrillas/ decimo medida/ medida", "0");
                    generador.put("Pantorrillas/ decimo medida/ fecha", "0");
                    generador.put("Pantorrillas/ onceavo medida/ medida", "0");
                    generador.put("Pantorrillas/ onceavo medida/ fecha", "0");
                    generador.put("Pantorrillas/ doceavo medida/ medida", "0");
                    generador.put("Pantorrillas/ doceavo medida/ fecha", "0");


                    generador.put("Torax/ primera medida/ medida", "0");
                    generador.put("Torax/ primera medida/ fecha", "0");
                    generador.put("Torax/ segunda medida/ medida", "0");
                    generador.put("Torax/ segunda medida/ fecha", "0");
                    generador.put("Torax/ tercer medida/ medida", "0");
                    generador.put("Torax/ tercer medida/ fecha", "0");
                    generador.put("Torax/ cuarto medida/ medida", "0");
                    generador.put("Torax/ cuarto medida/ fecha", "0");
                    generador.put("Torax/ quinto medida/ medida", "0");
                    generador.put("Torax/ quinto medida/ fecha", "0");
                    generador.put("Torax/ sexto medida/ medida", "0");
                    generador.put("Torax/ sexto medida/ fecha", "0");
                    generador.put("Torax/ septimo medida/ medida", "0");
                    generador.put("Torax/ septimo medida/ fecha", "0");
                    generador.put("Torax/ octavo medida/ medida", "0");
                    generador.put("Torax/ octavo medida/ fecha", "0");
                    generador.put("Torax/ noveno medida/ medida", "0");
                    generador.put("Torax/ noveno medida/ fecha", "0");
                    generador.put("Torax/ decimo medida/ medida", "0");
                    generador.put("Torax/ decimo medida/ fecha", "0");
                    generador.put("Torax/ onceavo medida/ medida", "0");
                    generador.put("Torax/ onceavo medida/ fecha", "0");
                    generador.put("Torax/ doceavo medida/ medida", "0");
                    generador.put("Torax/ doceavo medida/ fecha", "0");

                    generador.put("puntaje medidas", "false");
                    mDatabase1.child("Users").child(id).updateChildren(generador);


                } else {

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public void onBackPressed() {

    }

}
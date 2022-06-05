package com.korellia.korelliaclubapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.korellia.korelliaclubapp.R;
import com.korellia.korelliaclubapp.bibliotecadeejercicios;
import com.korellia.korelliaclubapp.databinding.FragmentHomeBinding;
import com.korellia.korelliaclubapp.monitoreo;
import com.korellia.korelliaclubapp.nutricion;
import com.korellia.korelliaclubapp.semana3dias;
import com.korellia.korelliaclubapp.semana4dias;
import com.korellia.korelliaclubapp.semana5dias;
import com.korellia.korelliaclubapp.semana6dias;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    View vista;
    ImageButton entrenamiento;
    ImageButton monitoreo;
    ImageButton biblioteca;
    ImageButton calentamiento, nutricion;


    private String dias;
    private String sexo;
 private   int diasparaentrenar;
     private DatabaseReference mDatabase;
     private FirebaseAuth mAuth;
   private DatabaseReference mRootReference;

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();


        vista = inflater.inflate(R.layout.fragment_home, container, false);
        entrenamiento = (ImageButton) vista.findViewById(R.id.imageViewentrenamiento);
        monitoreo = (ImageButton) vista.findViewById(R.id.imageViewmonitoreo);
       biblioteca = (ImageButton) vista.findViewById(R.id.imageView2);
        nutricion = (ImageButton) vista.findViewById(R.id.imageViewnutricion);


        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
                                                                     @Override
                                                                     public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                                                                         if (datasnapshot.exists()) {

                                                                              dias = datasnapshot.child("dias").getValue().toString();

                                                                              diasparaentrenar = Integer.parseInt(dias);

                                                                         }

                                                                     }

                                                                     @Override
                                                                     public void onCancelled(@NonNull DatabaseError error) {

                                                                     }
                                                                 });


                entrenamiento.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (diasparaentrenar == 3){



                                Intent intent = new Intent(getActivity(), semana3dias.class);

                                startActivity(intent);


                         
                        }

                        if (diasparaentrenar == 4){


                                Intent intent = new Intent(getActivity(), semana4dias.class);

                                startActivity(intent);

                        }

                        if (diasparaentrenar == 5){



                                Intent intent = new Intent(getActivity(), semana5dias.class);

                                startActivity(intent);


                        }

                        if (diasparaentrenar == 6){



                                Intent intent = new Intent(getActivity(), semana6dias.class);

                                startActivity(intent);


                        }


                    }
                });


        monitoreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), monitoreo.class);
                startActivity(intent);
            }
        });

        nutricion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), nutricion.class);
                startActivity(intent);
            }
        });


        biblioteca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), bibliotecadeejercicios.class);
                startActivity(intent);
            }
        });




        return vista;
    }





}
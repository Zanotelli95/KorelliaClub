package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class historialentrenamiento extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    RecyclerView recyclerView;
    int numeroderecyclersint = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historialentrenamiento);


        Toolbar toolbar = findViewById(R.id.toolbarhistorial);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Historial de entrenamiento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();


        String entrenof = getIntent().getExtras().getString("entreno");


        int entrenofint = Integer.parseInt(entrenof);
        int enf = entrenofint + 1;
        String entrenofinal = String.valueOf(enf);

        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
                                                                     @Override
                                                                     public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                                                                         Map<String, Object> sientreno = new HashMap<>();
                                                                         sientreno.put("diasentrenados", entrenofinal);

                                                                         mDatabase.child("Users").child(id).updateChildren(sientreno);


                                                                     }

                                                                     @Override
                                                                     public void onCancelled(@NonNull DatabaseError error) {

                                                                     }
                                                                 });


        recyclerView = findViewById(R.id.recyclerhistorial);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,  false));



        //traer numero de dias entrenados por el usuario




            llenarrecycler();







    }


    private void llenarrecycler() {


        String entrenof = getIntent().getExtras().getString("entreno");


   }





    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
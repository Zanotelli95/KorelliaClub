package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class finsemana extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finsemana);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();


    }

    public void salirsemana(View view) {

        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String id = mAuth.getCurrentUser().getUid();
                String nuevasemana1 = "false";
                String nuevasemana2 = "false";
                String nuevasemana3 = "false";
                String nuevasemana4 = "false";
                String nuevasemana5 = "false";
                String nuevasemana6 = "false";


                Map<String, Object> finsemana = new HashMap<>();

                finsemana.put("diaactual1", nuevasemana1);
                finsemana.put("diaactual2", nuevasemana2);
                finsemana.put("diaactual3", nuevasemana3);
                finsemana.put("diaactual4", nuevasemana4);
                finsemana.put("diaactual5", nuevasemana5);
                finsemana.put("diaactual6", nuevasemana6);

                mDatabase.child("Users").child(id).updateChildren(finsemana);


                Intent responder = new Intent(finsemana.this, monitoreo.class);
                startActivity(responder);
                finish();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }

    public void onDestroy() { super.onDestroy(); }


}
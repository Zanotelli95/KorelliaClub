package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class pesocorporal extends AppCompatActivity {


    TextView pesoinicial;

    TextView medidanov21, medidadic21, medidaene22, medidafeb22, medidamar22, medidaabr22;
    EditText nuevamedidanov21, nuevamedidadic21, nuevamedidaene22, nuevamedidafeb22, nuevamedidamar22, nuevamedidaabr22;
    Button botonmedidanov21peso, botonmedidadic21peso, botonmedidaene22peso, botonmedidafeb22peso, botonmedidamar22peso, botonmedidaabr22peso;
    private DatabaseReference mRootReference;
    private DatabaseReference mDatabase10;
    private FirebaseAuth mAuthmedidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_pesocorporal);

        Toolbar toolbar = findViewById(R.id.toolbarpesocorporal);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Peso corporal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRootReference = FirebaseDatabase.getInstance().getReference();

        mAuthmedidas = FirebaseAuth.getInstance();
        mDatabase10 = FirebaseDatabase.getInstance().getReference();
        String idmedidas = mAuthmedidas.getCurrentUser().getUid();

        pesoinicial = (TextView) findViewById(R.id.pesoinicial);


        medidanov21 = (TextView) findViewById(R.id.medidanoviembre2021peso);
        medidadic21 = (TextView) findViewById(R.id.medidadiciembre2021peso);
        medidaene22 = (TextView) findViewById(R.id.medidaenero2022peso);
        medidafeb22 = (TextView) findViewById(R.id.medidafebrero2022peso);
        medidamar22 = (TextView) findViewById(R.id.medidamarzo022peso);
        medidaabr22 = (TextView) findViewById(R.id.medidaabril2022peso);


        nuevamedidanov21 = (EditText) findViewById(R.id.nuevamedidanov21peso);
        nuevamedidadic21 = (EditText) findViewById(R.id.nuevamedidadic21peso);
        nuevamedidaene22 = (EditText) findViewById(R.id.nuevamedidaene22peso);
        nuevamedidafeb22 = (EditText) findViewById(R.id.nuevamedidafebrero22peso);
        nuevamedidamar22 = (EditText) findViewById(R.id.nuevamedidamarzo22peso);
        nuevamedidaabr22 = (EditText) findViewById(R.id.nuevamedidaabril22peso);


        botonmedidanov21peso = (Button) findViewById(R.id.botonnuevamedidanov21peso);
        botonmedidadic21peso = (Button) findViewById(R.id.botonnuevamedidadic21peso);
        botonmedidaene22peso = (Button) findViewById(R.id.botonnuevamedidaene22peso);
        botonmedidafeb22peso = (Button) findViewById(R.id.botonnuevamedidafebrero22peso);
        botonmedidamar22peso = (Button) findViewById(R.id.botonnuevamedidamarzo22peso);
        botonmedidaabr22peso = (Button) findViewById(R.id.botonnuevamedidaabril22peso);


        mDatabase10.child("Users").child(idmedidas).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String pesoactual = datasnapshot.child("kilogramos").getValue().toString();
                pesoinicial.setText(pesoactual);

                String medidanov = datasnapshot.child("Peso Corporal/ Noviembre 2021").getValue().toString();
                String medidadic = datasnapshot.child("Peso Corporal/ Diciembre 2021").getValue().toString();
                String medidaenero = datasnapshot.child("Peso Corporal/ Enero 2022").getValue().toString();

                String medidafeb = datasnapshot.child("Peso Corporal/ Febrero 2022").getValue().toString();
                String medidamar = datasnapshot.child("Peso Corporal/ Marzo 2022").getValue().toString();
                String medidaabr = datasnapshot.child("Peso Corporal/ Abril 2022").getValue().toString();
                medidanov21.setText(medidanov);
                medidadic21.setText(medidadic);
                medidaene22.setText(medidaenero);

                medidafeb22.setText(medidafeb);
                medidamar22.setText(medidamar);
                medidaabr22.setText(medidaabr);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        botonmedidanov21peso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nov21 =  nuevamedidanov21.getText().toString();
                medidanov21.setText(nov21);
                Map<String, Object> peso = new HashMap<>();
                peso.put("Peso Corporal/ Noviembre 2021", nov21);
                mRootReference.child("Users").child(idmedidas).updateChildren(peso);
                nuevamedidanov21.setText("");



            }
        });


        botonmedidadic21peso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dic21 =  nuevamedidadic21.getText().toString();
                medidadic21.setText(dic21);
               Map<String, Object> peso = new HashMap<>();
                peso.put("Peso Corporal/ Diciembre 2021", dic21);
                mRootReference.child("Users").child(idmedidas).updateChildren(peso);
                nuevamedidadic21.setText("");
                Intent intent = new Intent(pesocorporal.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        botonmedidaene22peso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ene22 =  nuevamedidaene22.getText().toString();
                medidaene22.setText(ene22);
                Map<String, Object> peso = new HashMap<>();
                peso.put("Peso Corporal/ Enero 2022", ene22);
                mRootReference.child("Users").child(idmedidas).updateChildren(peso);
                nuevamedidadic21.setText("");

            }
        });

        botonmedidafeb22peso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String feb22 =  nuevamedidafeb22.getText().toString();
                medidafeb22.setText(feb22);
                Map<String, Object> peso = new HashMap<>();
                peso.put("Peso Corporal/ Febrero 2022", feb22);
                mRootReference.child("Users").child(idmedidas).updateChildren(peso);
                nuevamedidafeb22.setText("");

            }
        });

        botonmedidamar22peso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mar22 =  nuevamedidamar22.getText().toString();
                medidamar22.setText(mar22);
                Map<String, Object> peso = new HashMap<>();
                peso.put("Peso Corporal/ Marzo 2022", mar22);
                mRootReference.child("Users").child(idmedidas).updateChildren(peso);
                nuevamedidamar22.setText("");

            }
        });

        botonmedidaabr22peso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String abr22 =  nuevamedidaabr22.getText().toString();
                medidaabr22.setText(abr22);
                Map<String, Object> peso = new HashMap<>();
                peso.put("Peso Corporal/ Abril 2022", abr22);
                mRootReference.child("Users").child(idmedidas).updateChildren(peso);
                nuevamedidaabr22.setText("");

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
}
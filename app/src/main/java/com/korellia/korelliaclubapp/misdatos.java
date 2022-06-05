package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

public class misdatos extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    TextView textodisciplina;
    TextView textnombre;
    TextView textapellido;
    TextView textemail;
    TextView textimc, textdescripcion;
    Button editardatos;

    DatabaseReference mRootReference;

    ImageView imagen;
    Button subirimagen;
    StorageReference storage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misdatos);

        Toolbar toolbar = findViewById(R.id.toolbarmisdatos);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mis Datos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();



        mRootReference = FirebaseDatabase.getInstance().getReference();



        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();


        textodisciplina = (TextView) findViewById(R.id.textViewdisciplina);
        textnombre = (TextView) findViewById(R.id.textViewnombrer);
        textemail = (TextView) findViewById(R.id.textViewemail);
        textimc = (TextView) findViewById(R.id.textViewimc);
        textdescripcion = (TextView) findViewById(R.id.textViewdescripcionimc);
      //  editardatos = (Button) findViewById(R.id.buttoneditardatos);

        textapellido =  (TextView) findViewById(R.id.textViewapellidor);


        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if (datasnapshot.exists()) {
                    String disciplina = datasnapshot.child("disciplina").getValue().toString();
                    String nombre = datasnapshot.child("name").getValue().toString();
                    String email = datasnapshot.child("email").getValue().toString();
                    String apellido = datasnapshot.child("apellido").getValue().toString();

                   String imc = datasnapshot.child("IMC").getValue().toString();

                    textodisciplina.setText(disciplina);
                    textimc.setText(imc);
                    textnombre.setText(nombre);
                    textemail.setText(email);
                    textapellido.setText(apellido);

                 float imcint = Float.parseFloat(imc);
                    String bajo = "Bajo de peso";
                    String normal = "Peso normal";
                    String sobrepeso = "Sobrepeso";
                    String obesidad1 =  "Obesidad tipo 1";
                    String obesidad2 =  "Obesidad tipo 2";
                    String obesidad3 =  "Obesidad tipo 3";



                    if (imcint <= 18.49) {
                            textdescripcion.setText(bajo);
                    }
                    if (imcint >= 18.5 && imcint <=24.9) {
                        textdescripcion.setText(normal);
                    }
                    if (imcint >= 25 && imcint <=29.9) {
                        textdescripcion.setText(sobrepeso);
                    }
                    if (imcint >= 30 && imcint <=34.9) {
                        textdescripcion.setText(obesidad1);
                    }
                    if (imcint >= 35 && imcint <=39.9) {
                        textdescripcion.setText(obesidad2);
                    }
                    if (imcint >= 40) {
                        textdescripcion.setText(obesidad3);
                    }




                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

   /* editardatos.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent editar = new Intent(misdatos.this, editardatos.class);
            startActivity(editar);

        }
    });
*/



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
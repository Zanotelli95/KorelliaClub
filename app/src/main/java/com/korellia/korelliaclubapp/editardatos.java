package com.korellia.korelliaclubapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class editardatos extends AppCompatActivity {

    EditText nombre, apellido, correo;
    DatabaseReference mRootReference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editardatos);

      Toolbar toolbar = findViewById(R.id.toolbareditar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Editar datos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       mRootReference = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();
      //  guardar = (Button) findViewById(R.id.buttonguardardatos);

        nombre = (EditText) findViewById(R.id.editnombrer);
        apellido = (EditText) findViewById(R.id.editapellidor);
        correo = (EditText) findViewById(R.id.editemail);

        String id = mAuth.getCurrentUser().getUid();

/*
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String nombreeditado = nombre.getText().toString();
                String apellidoeditado = apellido.getText().toString();
                String correoeditado = correo.getText().toString();



                if(nombreeditado != null){
                    Map<String, Object> editar = new HashMap<>();
                    editar.put("name", nombreeditado);
                    mRootReference.child("Users").child(id).updateChildren(editar);
                }



                if (apellidoeditado != null){
                    Map<String, Object> editar = new HashMap<>();
                    editar.put("apellido", apellidoeditado);
                    mRootReference.child("Users").child(id).updateChildren(editar);
                }

                if (correoeditado != null){
                    Map<String, Object> editar = new HashMap<>();
                    editar.put("email", correoeditado);
                    mRootReference.child("Users").child(id).updateChildren(editar);
                }



                Intent editados = new Intent(editardatos.this, misdatos.class);
                startActivity(editados);
                Toast.makeText(getApplicationContext(),nombreeditado,Toast.LENGTH_SHORT).show();
                finish();

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
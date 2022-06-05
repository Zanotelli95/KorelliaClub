package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class olvidado extends AppCompatActivity {

    private EditText correo;
    private Button botonenviar;
    private String email = "";
    private FirebaseAuth mAtuh;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidado);

        correo = (EditText) findViewById(R.id.textView105);
        botonenviar = (Button) findViewById(R.id.button32);
        mAtuh = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);


        botonenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = correo.getText().toString();

                if (!email.isEmpty()){

                    resetpass();

                }  else {
                    Toast.makeText(olvidado.this, "Debe ingresar el email", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void resetpass(){

        mAtuh.setLanguageCode("es");
        mAtuh.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                    Toast.makeText(olvidado.this, "Se ha enviado un correo para restablecer tu contraseña", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(olvidado.this, "Este correo no esta registrado, verifica el correo", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}
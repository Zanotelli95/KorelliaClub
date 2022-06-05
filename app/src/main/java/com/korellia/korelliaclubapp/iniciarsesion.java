package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class iniciarsesion extends AppCompatActivity {

    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private Button mButtonLogin;

    private String email = "";
    private String password = "";
    TextView olvido;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarsesion);


        mAuth = FirebaseAuth.getInstance();

        mEditTextEmail = (EditText) findViewById(R.id.emailinicio);
        mEditTextPassword = (EditText) findViewById(R.id.contraseñainicio);
        mButtonLogin = (Button) findViewById(R.id.botoniniciarsesion);
        olvido = (TextView) findViewById(R.id.textView5);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = mEditTextEmail.getText().toString();
                password = mEditTextPassword.getText().toString();

                if(!email.isEmpty() && !password.isEmpty()) {
                    loginUser();

                }

                else {
                    Toast.makeText(iniciarsesion.this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
                }

            }
        });


        olvido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(iniciarsesion.this, olvidado.class));
                finish();
            }
        });
    }

    private void loginUser(){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(iniciarsesion.this, MainActivity.class));
                    finish();
                }

                else {
                    Toast.makeText(iniciarsesion.this, "No se puede iniciar sesion, compruebe los datos", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}
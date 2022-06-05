package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class registro extends AppCompatActivity {
    private EditText mEditTextMensaje;
    private Button mBtnCrearDatos;
    private DatabaseReference mDatabase;
   private  DatabaseReference mRootReference;

    private String name="";
    private String email = "";
    private String password = "";
    private String apellido = "";
    private String telefono = "";

    private String confirmar = ""; // quitar despues
    private String variablesexo = "";
    private String variablepais = "";
    private String variabledia = "";
    private String variablemes = "";
    private String variableaño = "";
    private String variableedad = "";

    Spinner sexo;
    Spinner pais;

    Button bfecha;

    private int dia, mes, mesfinal, año, edad, diafinal, añofinal;

    private EditText apellidosregistro;
    private EditText emailregistro;
    private EditText telefonoregistro;

    private EditText contraseñaregistro;
    private EditText confirmarregistro;
    private Spinner spinnersexo;
    private Spinner spinnerpais;



    //registroterminos
    TextView linkTextView;

    //base dedatos
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mRootReference = FirebaseDatabase.getInstance().getReference();

        apellidosregistro = (EditText) findViewById(R.id.apellidosregistro);
        emailregistro = (EditText) findViewById(R.id.emailregistro);
        telefonoregistro = (EditText) findViewById(R.id.telefonoregistro);

        contraseñaregistro = (EditText) findViewById(R.id.contraseñaregistro);
        confirmarregistro = (EditText) findViewById(R.id.confirmarregistro);
        spinnersexo = (Spinner) findViewById(R.id.spinnersexo);
        spinnerpais = (Spinner) findViewById(R.id.spinnerpais);


        bfecha = (Button) findViewById(R.id.botonfechadenacimiento);


        bfecha.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          final Calendar c= Calendar.getInstance();
                                          dia=c.get(Calendar.DAY_OF_MONTH);
                                          mes=c.get(Calendar.MONTH);
                                          año=c.get(Calendar.YEAR);


                                          DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                                              @Override

                                              public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                                                  bfecha.setText(dayOfMonth + "/" + (monthOfYear +1 ) + "/" + year );

                                                  mesfinal = monthOfYear +1;
                                                  diafinal = dayOfMonth + 0;
                                                  añofinal = year + 0;


                                                 Calendar fechaactual = Calendar.getInstance();
                                                  int añoactual = fechaactual.get(Calendar.YEAR) - añofinal;
                                                  int mesactual = fechaactual.get(Calendar.MONTH) - mesfinal;
                                                  int diaactual = fechaactual.get(Calendar.DAY_OF_MONTH) - diafinal;

                                                  //Se ajusta el año dependiendo el mes y el día
                                                  if(mesactual<0 || (mesactual==0 && diaactual<0)){
                                                      añoactual--;
                                                  }
                                                  //Regresa la edad en base a la fecha de nacimiento
                                                  edad = añoactual;


                                              }
                                          }
                                          ,año, mes, dia);


                                          datePickerDialog.show();





                                      }
                                  });



                mEditTextMensaje = (EditText) findViewById(R.id.nombreregistro);
        mBtnCrearDatos = (Button) findViewById(R.id.acceder);

        mAuth = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance().getReference();

        //linkdeterminosenregistro

        linkTextView = findViewById(R.id.terminosderegistro);
        linkTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                gotoUrl("https://korellia.com/terminos");
            }
        });

        sexo = findViewById(R.id.spinnersexo);
        pais = findViewById(R.id.spinnerpais);


        //firebase


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.combo_sexo,
                R.layout.spinner_item_korellia);
        sexo.setAdapter(adapter);


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.combo_pais,
                R.layout.spinner_item_korellia);
        pais.setAdapter(adapter2);






        mBtnCrearDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = mEditTextMensaje.getText().toString();
                email = emailregistro.getText().toString();
                password = contraseñaregistro.getText().toString();
                apellido = apellidosregistro.getText().toString();
                telefono = telefonoregistro.getText().toString();
                variabledia = Integer.toString(diafinal);
                variablemes = Integer.toString(mesfinal);
                variableaño = Integer.toString(añofinal);
                variableedad = Integer.toString(edad);
                confirmar = confirmarregistro.getText().toString();
                variablesexo = spinnersexo.getSelectedItem().toString();
                variablepais = spinnerpais.getSelectedItem().toString();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty() && !apellido.isEmpty() && !telefono.isEmpty()
                       && !confirmar.isEmpty()) {

                    if (password.length() >= 6 && password.equals(confirmar)) {
                        registerUser();

                    } else {

                        Toast.makeText(registro.this, "Las contraseñas no coinciden o tienen menos de 6 caracteres", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(registro.this, "Debe completar todos los campos", Toast.LENGTH_SHORT).show();


                }

            }


            private void registerUser() {
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String id = mAuth.getCurrentUser().getUid();
                            Map<String, Object> map = new HashMap<>();
                            map.put("name", name);
                            map.put("email", email);
                            map.put("password", password);
                            map.put("apellido", apellido);
                            map.put("telefono", telefono);
                            map.put("Dia de nacimiento", diafinal);
                            map.put("Mes de nacimiento", mesfinal);
                            map.put("Año de nacimiento", añofinal);
                            map.put("Edad", edad);
                            map.put("sexo", variablesexo);
                            map.put("pais", variablepais);


                            mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override


                                public void onComplete(@NonNull Task<Void> task2) {
                                    if (task2.isSuccessful()) {
                                        startActivity(new Intent(registro.this, disciplinas.class));
                                        finish();


                                    } else {

                                        Toast.makeText(registro.this, "Error: No se crearon datos del usuario", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                        } else {
                            Toast.makeText(registro.this, "No se registro el usuario.", Toast.LENGTH_SHORT).show();
                        }

                    }
                });


            }
        });

    }



    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }




}
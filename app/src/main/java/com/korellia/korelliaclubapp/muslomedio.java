package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class muslomedio extends AppCompatActivity {

    private TextView medida1, medida2, medida3, medida4, medida5, medida6, medida7, medida8, medida9, medida10, medida11, medida12;
    private TextView cm1, cm2, cm3, cm4, cm5, cm6, cm7, cm8, cm9, cm10, cm11, cm12;
    private TextView fecha1, fecha2, fecha3, fecha4, fecha5, fecha6, fecha7, fecha8, fecha9, fecha10, fecha11, fecha12;
    private EditText agregar;

    private TextView fechacompleta;
    private DatabaseReference mRootReference1;
    private DatabaseReference mDatabase1;
    private FirebaseAuth mAuth1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_muslomedio);


        Toolbar toolbar = findViewById(R.id.toolbarmuslomedio);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Muslo medio");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        fechacompleta = (TextView) findViewById(R.id.textView243);
        Date date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("d MMM yyyy");
        String sfecha = fecha.format(date);
        fechacompleta.setText(sfecha);

        mRootReference1 = FirebaseDatabase.getInstance().getReference();

        mAuth1 = FirebaseAuth.getInstance();
        mDatabase1 = FirebaseDatabase.getInstance().getReference();
        String id = mAuth1.getCurrentUser().getUid();

        medida1 = (TextView) findViewById(R.id.primermedidamuslomedio);
        medida2 = (TextView) findViewById(R.id.segundamedidamuslomedio);
        medida3 = (TextView) findViewById(R.id.tercermedidamuslomedio);
        medida4 = (TextView) findViewById(R.id.cuartomedidamuslomedio);
        medida5 = (TextView) findViewById(R.id.quintomedidamuslomedio);
        medida6 = (TextView) findViewById(R.id.sextomedidamuslomedio);
        medida7 = (TextView) findViewById(R.id.septimomedidamuslomedio);
        medida8 = (TextView) findViewById(R.id.octavomedidamuslomedio);
        medida9 = (TextView) findViewById(R.id.novenomedidamuslomedio);
        medida10 = (TextView) findViewById(R.id.decimomedidamuslomedio);
        medida11 = (TextView) findViewById(R.id.onceavomedidamuslomedio);
        medida12 = (TextView) findViewById(R.id.doceavomedidamuslomedio);


        cm1 = (TextView) findViewById(R.id.textView234muslomedio);
        cm2 = (TextView) findViewById(R.id.segundatextView234muslomedio);
        cm3 = (TextView) findViewById(R.id.tercertextView234muslomedio);
        cm4 = (TextView) findViewById(R.id.cuartotextView234muslomedio);
        cm5 = (TextView) findViewById(R.id.quintotextView234muslomedio);
        cm6 = (TextView) findViewById(R.id.sextotextView234muslomedio);
        cm7 = (TextView) findViewById(R.id.septimotextView234muslomedio);
        cm8 = (TextView) findViewById(R.id.octavotextView234muslomedio);
        cm9 = (TextView) findViewById(R.id.novenotextView234muslomedio);
        cm10 = (TextView) findViewById(R.id.decimotextView234muslomedio);
        cm11 = (TextView) findViewById(R.id.onceavotextView234muslomedio);
        cm12 = (TextView) findViewById(R.id.doceavotextView234muslomedio);

        fecha1 = (TextView) findViewById(R.id.textView229muslomedio);
        fecha2 = (TextView) findViewById(R.id.segundatextView229muslomedio);
        fecha3 = (TextView) findViewById(R.id.tercertextView229muslomedio);
        fecha4 = (TextView) findViewById(R.id.cuartotextView229muslomedio);
        fecha5 = (TextView) findViewById(R.id.quintotextView229muslomedio);
        fecha6 = (TextView) findViewById(R.id.sextotextView229muslomedio);
        fecha7 = (TextView) findViewById(R.id.septimotextView229muslomedio);
        fecha8 = (TextView) findViewById(R.id.octavotextView229muslomedio);
        fecha9 = (TextView) findViewById(R.id.novenotextView229muslomedio);
        fecha10 = (TextView) findViewById(R.id.decimotextView229muslomedio);
        fecha11 = (TextView) findViewById(R.id.onceavotextView229muslomedio);
        fecha12 = (TextView) findViewById(R.id.doceavotextView229muslomedio);




        agregar = (EditText) findViewById(R.id.textView231muslomedio);

        //comprobar valor actual en base datos y colocarlo

        mDatabase1.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String uno = datasnapshot.child("Muslo medio/ primera medida/ medida").getValue().toString();
                String unofecha = datasnapshot.child("Muslo medio/ primera medida/ fecha").getValue().toString();
                String dos = datasnapshot.child("Muslo medio/ segunda medida/ medida").getValue().toString();
                String dosfecha = datasnapshot.child("Muslo medio/ segunda medida/ fecha").getValue().toString();
                String tres = datasnapshot.child("Muslo medio/ tercer medida/ medida").getValue().toString();
                String tresfecha = datasnapshot.child("Muslo medio/ tercer medida/ fecha").getValue().toString();
                String cuatro = datasnapshot.child("Muslo medio/ cuarto medida/ medida").getValue().toString();
                String cuatrofecha = datasnapshot.child("Muslo medio/ cuarto medida/ fecha").getValue().toString();
                String quinto = datasnapshot.child("Muslo medio/ quinto medida/ medida").getValue().toString();
                String quintofecha = datasnapshot.child("Muslo medio/ quinto medida/ fecha").getValue().toString();
                String sexto = datasnapshot.child("Muslo medio/ sexto medida/ medida").getValue().toString();
                String sextofecha = datasnapshot.child("Muslo medio/ sexto medida/ fecha").getValue().toString();
                String septimo = datasnapshot.child("Muslo medio/ septimo medida/ medida").getValue().toString();
                String septimofecha = datasnapshot.child("Muslo medio/ septimo medida/ fecha").getValue().toString();
                String octavo = datasnapshot.child("Muslo medio/ octavo medida/ medida").getValue().toString();
                String octavofecha = datasnapshot.child("Muslo medio/ octavo medida/ fecha").getValue().toString();
                String noveno = datasnapshot.child("Muslo medio/ noveno medida/ medida").getValue().toString();
                String novenofecha = datasnapshot.child("Muslo medio/ noveno medida/ fecha").getValue().toString();
                String decimo = datasnapshot.child("Muslo medio/ decimo medida/ medida").getValue().toString();
                String decimofecha = datasnapshot.child("Muslo medio/ decimo medida/ fecha").getValue().toString();
                String onceavo = datasnapshot.child("Muslo medio/ onceavo medida/ medida").getValue().toString();
                String onceavofecha = datasnapshot.child("Muslo medio/ onceavo medida/ fecha").getValue().toString();
                String doceavo = datasnapshot.child("Muslo medio/ doceavo medida/ medida").getValue().toString();
                String doceavofecha = datasnapshot.child("Muslo medio/ doceavo medida/ fecha").getValue().toString();
                String primermedidab = datasnapshot.child("preferencia medidas").getValue().toString();

                medida1.setText(uno);    fecha1.setText(unofecha);
                medida2.setText(dos);    fecha2.setText(dosfecha);
                medida3.setText(tres);    fecha3.setText(tresfecha);
                medida4.setText(cuatro);    fecha4.setText(cuatrofecha);
                medida5.setText(quinto);    fecha5.setText(quintofecha);
                medida6.setText(sexto);    fecha6.setText(sextofecha);
                medida7.setText(septimo);    fecha7.setText(septimofecha);
                medida8.setText(octavo);    fecha8.setText(octavofecha);
                medida9.setText(noveno);    fecha9.setText(novenofecha);
                medida10.setText(decimo);    fecha10.setText(decimofecha);
                medida11.setText(onceavo);    fecha11.setText(onceavofecha);
                medida12.setText(doceavo);    fecha12.setText(doceavofecha);


                String valor1b = medida1.getText().toString();
                String valor2b = medida2.getText().toString();
                String valor3b = medida3.getText().toString();
                String valor4b = medida4.getText().toString();
                String valor5b = medida5.getText().toString();
                String valor6b = medida6.getText().toString();
                String valor7b = medida7.getText().toString();
                String valor8b = medida8.getText().toString();
                String valor9b = medida9.getText().toString();
                String valor10b = medida10.getText().toString();
                String valor11b = medida11.getText().toString();
                String valor12b = medida12.getText().toString();

                if (valor1b.isEmpty()){

                }  else {

                    if (primermedidab.equals("centimetros")){
                        cm1.setText("centimetros");
                    } else {
                        cm1.setText("pulgadas");
                    }
                }

                if (valor2b.isEmpty()){

                }  else {

                    if (primermedidab.equals("centimetros")){
                        cm2.setText("centimetros");
                    } else {
                        cm2.setText("pulgadas");
                    }
                }

                if (valor3b.isEmpty()){

                }  else {

                    if (primermedidab.equals("centimetros")){
                        cm3.setText("centimetros");
                    } else {
                        cm3.setText("pulgadas");
                    }
                }

                if (valor4b.isEmpty()){

                }  else {

                    if (primermedidab.equals("centimetros")){
                        cm4.setText("centimetros");
                    } else {
                        cm4.setText("pulgadas");
                    }
                }

                if (valor5b.isEmpty()){

                }  else {

                    if (primermedidab.equals("centimetros")){
                        cm5.setText("centimetros");
                    } else {
                        cm5.setText("pulgadas");
                    }
                }

                if (valor6b.isEmpty()){

                }  else {

                    if (primermedidab.equals("centimetros")){
                        cm6.setText("centimetros");
                    } else {
                        cm6.setText("pulgadas");
                    }
                }

                if (valor7b.isEmpty()){

                }  else {

                    if (primermedidab.equals("centimetros")){
                        cm7.setText("centimetros");
                    } else {
                        cm7.setText("pulgadas");
                    }
                }

                if (valor8b.isEmpty()){

                }  else {

                    if (primermedidab.equals("centimetros")){
                        cm8.setText("centimetros");
                    } else {
                        cm8.setText("pulgadas");
                    }
                }


                if (valor9b.isEmpty()){

                }  else {

                    if (primermedidab.equals("centimetros")){
                        cm9.setText("centimetros");
                    } else {
                        cm9.setText("pulgadas");
                    }
                }

                if (valor10b.isEmpty()){

                }  else {

                    if (primermedidab.equals("centimetros")){
                        cm10.setText("centimetros");
                    } else {
                        cm10.setText("pulgadas");
                    }
                }

                if (valor11b.isEmpty()){

                }  else {

                    if (primermedidab.equals("centimetros")){
                        cm11.setText("centimetros");
                    } else {
                        cm11.setText("pulgadas");
                    }
                }

                if (valor12b.isEmpty()){

                }  else {

                    if (primermedidab.equals("centimetros")){
                        cm12.setText("centimetros");
                    } else {
                        cm12.setText("pulgadas");
                    }
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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



    public void ingresarmuslo(View view) {
        String id2 = mAuth1.getCurrentUser().getUid();

        String medida1string = medida1.getText().toString();
        String medida2string = medida2.getText().toString();
        String medida3string = medida3.getText().toString();
        String medida4string = medida4.getText().toString();
        String medida5string = medida5.getText().toString();
        String medida6string = medida6.getText().toString();
        String medida7string = medida7.getText().toString();
        String medida8string = medida8.getText().toString();
        String medida9string = medida9.getText().toString();
        String medida10string = medida10.getText().toString();
        String medida11string = medida11.getText().toString();
        String medida12string = medida12.getText().toString();

        String fechaactual = fechacompleta.getText().toString();

        if (medida1string.isEmpty()){
            String agregar1 = agregar.getText().toString();
            medida1.setText(agregar1);
            agregar.setText("");
            fecha1.setText(fechaactual);

            Map<String, Object> medidabrazorelajado = new HashMap<>();
            medidabrazorelajado.put("Muslo medio/ primera medida/ medida", agregar1);
            medidabrazorelajado.put("Muslo medio/ primera medida/ fecha", fechaactual);
            mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);

            Toast.makeText(this, "Medida agregada", Toast.LENGTH_SHORT).show();
            mDatabase1.child("Users").child(id2).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                    String primermedida = datasnapshot.child("preferencia medidas").getValue().toString();
                    if (primermedida.equals("centimetros")){
                        cm1.setText("centimetros");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }  else {

            if (medida2string.isEmpty()){
                String agregar1 = agregar.getText().toString();
                medida2.setText(agregar1);
                agregar.setText("");
                fecha2.setText(fechaactual);

                Map<String, Object> medidabrazorelajado = new HashMap<>();
                medidabrazorelajado.put("Muslo medio/ segunda medida/ medida", agregar1);
                medidabrazorelajado.put("Muslo medio/ segunda medida/ fecha", fechaactual);
                mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);

                Toast.makeText(this, "Medida agregada", Toast.LENGTH_SHORT).show();
                mDatabase1.child("Users").child(id2).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        String primermedida = datasnapshot.child("preferencia medidas").getValue().toString();
                        if (primermedida.equals("centimetros")){
                            cm2.setText("centimetros");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




            } else {
                if (medida3string.isEmpty()){
                    String agregar1 = agregar.getText().toString();
                    medida3.setText(agregar1);
                    agregar.setText("");
                    fecha3.setText(fechaactual);

                    Map<String, Object> medidabrazorelajado = new HashMap<>();
                    medidabrazorelajado.put("Muslo medio/ tercer medida/ medida", agregar1);
                    medidabrazorelajado.put("Muslo medio/ tercer medida/ fecha", fechaactual);
                    mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);

                    Toast.makeText(this, "Medida agregada", Toast.LENGTH_SHORT).show();
                    mDatabase1.child("Users").child(id2).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            String primermedida = datasnapshot.child("preferencia medidas").getValue().toString();
                            if (primermedida.equals("centimetros")){
                                cm3.setText("centimetros");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });




                }  else {
                    if (medida4string.isEmpty()){
                        String agregar1 = agregar.getText().toString();
                        medida4.setText(agregar1);
                        agregar.setText("");
                        fecha4.setText(fechaactual);

                        Map<String, Object> medidabrazorelajado = new HashMap<>();
                        medidabrazorelajado.put("Muslo medio/ cuarto medida/ medida", agregar1);
                        medidabrazorelajado.put("Muslo medio/ cuarto medida/ fecha", fechaactual);
                        mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);

                        Toast.makeText(this, "Medida agregada", Toast.LENGTH_SHORT).show();
                        mDatabase1.child("Users").child(id2).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                                String primermedida = datasnapshot.child("preferencia medidas").getValue().toString();
                                if (primermedida.equals("centimetros")){
                                    cm4.setText("centimetros");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });




                    }  else {
                        if (medida5string.isEmpty()){
                            String agregar1 = agregar.getText().toString();
                            medida5.setText(agregar1);
                            agregar.setText("");
                            fecha5.setText(fechaactual);

                            Map<String, Object> medidabrazorelajado = new HashMap<>();
                            medidabrazorelajado.put("Muslo medio/ quinto medida/ medida", agregar1);
                            medidabrazorelajado.put("Muslo medio/ quinto medida/ fecha", fechaactual);
                            mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);

                            Toast.makeText(this, "Medida agregada", Toast.LENGTH_SHORT).show();
                            mDatabase1.child("Users").child(id2).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                                    String primermedida = datasnapshot.child("preferencia medidas").getValue().toString();
                                    if (primermedida.equals("centimetros")){
                                        cm5.setText("centimetros");
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });



                        } else {
                            if (medida6string.isEmpty()){
                                String agregar1 = agregar.getText().toString();
                                medida6.setText(agregar1);
                                agregar.setText("");
                                fecha6.setText(fechaactual);

                                Map<String, Object> medidabrazorelajado = new HashMap<>();
                                medidabrazorelajado.put("Muslo medio/ sexto medida/ medida", agregar1);
                                medidabrazorelajado.put("Muslo medio/ sexto medida/ fecha", fechaactual);
                                mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);

                                Toast.makeText(this, "Medida agregada", Toast.LENGTH_SHORT).show();
                                mDatabase1.child("Users").child(id2).addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                                        String primermedida = datasnapshot.child("preferencia medidas").getValue().toString();
                                        if (primermedida.equals("centimetros")){
                                            cm6.setText("centimetros");
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            } else {
                                if (medida7string.isEmpty()){
                                    String agregar1 = agregar.getText().toString();
                                    medida7.setText(agregar1);
                                    agregar.setText("");
                                    fecha7.setText(fechaactual);

                                    Map<String, Object> medidabrazorelajado = new HashMap<>();
                                    medidabrazorelajado.put("Muslo medio/ septimo medida/ medida", agregar1);
                                    medidabrazorelajado.put("Muslo medio/ septimo medida/ fecha", fechaactual);
                                    mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);

                                    Toast.makeText(this, "Medida agregada", Toast.LENGTH_SHORT).show();
                                    mDatabase1.child("Users").child(id2).addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                                            String primermedida = datasnapshot.child("preferencia medidas").getValue().toString();
                                            if (primermedida.equals("centimetros")){
                                                cm7.setText("centimetros");
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
                                }  else {
                                    if (medida8string.isEmpty()){
                                        String agregar1 = agregar.getText().toString();
                                        medida8.setText(agregar1);
                                        agregar.setText("");
                                        fecha8.setText(fechaactual);

                                        Map<String, Object> medidabrazorelajado = new HashMap<>();
                                        medidabrazorelajado.put("Muslo medio/ octavo medida/ medida", agregar1);
                                        medidabrazorelajado.put("Muslo medio/ octavo medida/ fecha", fechaactual);
                                        mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);

                                        Toast.makeText(this, "Medida agregada", Toast.LENGTH_SHORT).show();
                                        mDatabase1.child("Users").child(id2).addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                                                String primermedida = datasnapshot.child("preferencia medidas").getValue().toString();
                                                if (primermedida.equals("centimetros")){
                                                    cm8.setText("centimetros");
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError error) {

                                            }
                                        });

                                    } else {
                                        if (medida9string.isEmpty()){
                                            String agregar1 = agregar.getText().toString();
                                            medida9.setText(agregar1);
                                            agregar.setText("");
                                            fecha9.setText(fechaactual);

                                            Map<String, Object> medidabrazorelajado = new HashMap<>();
                                            medidabrazorelajado.put("Muslo medio/ noveno medida/ medida", agregar1);
                                            medidabrazorelajado.put("Muslo medio/ noveno medida/ fecha", fechaactual);
                                            mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);

                                            Toast.makeText(this, "Medida agregada", Toast.LENGTH_SHORT).show();
                                            mDatabase1.child("Users").child(id2).addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                                                    String primermedida = datasnapshot.child("preferencia medidas").getValue().toString();
                                                    if (primermedida.equals("centimetros")){
                                                        cm9.setText("centimetros");
                                                    }
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError error) {

                                                }
                                            });

                                        } else {
                                            if (medida10string.isEmpty()){
                                                String agregar1 = agregar.getText().toString();
                                                medida10.setText(agregar1);
                                                agregar.setText("");
                                                fecha10.setText(fechaactual);

                                                Map<String, Object> medidabrazorelajado = new HashMap<>();
                                                medidabrazorelajado.put("Muslo medio/ decimo medida/ medida", agregar1);
                                                medidabrazorelajado.put("Muslo medio/ decimo medida/ fecha", fechaactual);
                                                mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);

                                                Toast.makeText(this, "Medida agregada", Toast.LENGTH_SHORT).show();
                                                mDatabase1.child("Users").child(id2).addValueEventListener(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                                                        String primermedida = datasnapshot.child("preferencia medidas").getValue().toString();
                                                        if (primermedida.equals("centimetros")){
                                                            cm10.setText("centimetros");
                                                        }
                                                    }

                                                    @Override
                                                    public void onCancelled(@NonNull DatabaseError error) {

                                                    }
                                                });
                                            } else {
                                                if (medida11string.isEmpty()){
                                                    String agregar1 = agregar.getText().toString();
                                                    medida11.setText(agregar1);
                                                    agregar.setText("");
                                                    fecha11.setText(fechaactual);

                                                    Map<String, Object> medidabrazorelajado = new HashMap<>();
                                                    medidabrazorelajado.put("Muslo medio/ onceavo medida/ medida", agregar1);
                                                    medidabrazorelajado.put("Muslo medio/ onceavo medida/ fecha", fechaactual);
                                                    mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);

                                                    Toast.makeText(this, "Medida agregada", Toast.LENGTH_SHORT).show();
                                                    mDatabase1.child("Users").child(id2).addValueEventListener(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                                                            String primermedida = datasnapshot.child("preferencia medidas").getValue().toString();
                                                            if (primermedida.equals("centimetros")){
                                                                cm11.setText("centimetros");
                                                            }
                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError error) {

                                                        }
                                                    });

                                                } else {
                                                    if (medida12string.isEmpty()){
                                                        String agregar1 = agregar.getText().toString();
                                                        medida12.setText(agregar1);
                                                        agregar.setText("");
                                                        fecha12.setText(fechaactual);

                                                        Map<String, Object> medidabrazorelajado = new HashMap<>();
                                                        medidabrazorelajado.put("Muslo medio/ doceavo medida/ medida", agregar1);
                                                        medidabrazorelajado.put("Muslo medio/ doceavo medida/ fecha", fechaactual);
                                                        mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);

                                                        Toast.makeText(this, "Medida agregada", Toast.LENGTH_SHORT).show();
                                                        mDatabase1.child("Users").child(id2).addValueEventListener(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                                                                String primermedida = datasnapshot.child("preferencia medidas").getValue().toString();
                                                                if (primermedida.equals("centimetros")){
                                                                    cm12.setText("centimetros");
                                                                }
                                                            }

                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError error) {

                                                            }
                                                        });

                                                    }  else {
                                                        Toast.makeText(this, "No se pueden agregar más medidas, por favor elimina alguna", Toast.LENGTH_SHORT).show();
                                                    }


                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }



            }

        }



    }


    public void eliminarprimeromuslomedio(View view) {

        String actual = medida1.getText().toString();
        agregar.setText(actual);

    }

    public void eliminarsegundomuslomedio(View view) {

        String actual = medida2.getText().toString();
        agregar.setText(actual);

    }

    public void eliminarterceromuslomedio(View view) {

        String actual = medida3.getText().toString();
        agregar.setText(actual);

    }

    public void eliminarcuartomuslomedio(View view) {

        String actual = medida4.getText().toString();
        agregar.setText(actual);

    }

    public void eliminarquintomuslomedio(View view) {

        String actual = medida5.getText().toString();
        agregar.setText(actual);

    }

    public void eliminarsextomuslomedio(View view) {

        String actual = medida6.getText().toString();
        agregar.setText(actual);

    }

    public void eliminarseptimomuslomedio(View view) {

        String actual = medida7.getText().toString();
        agregar.setText(actual);

    }

    public void eliminaroctavomuslomedio(View view) {

        String actual = medida8.getText().toString();
        agregar.setText(actual);

    }


    public void eliminarnovenomuslomedio(View view) {

        String actual = medida9.getText().toString();
        agregar.setText(actual);

    }

    public void eliminardecimomuslomedio(View view) {

        String actual = medida10.getText().toString();
        agregar.setText(actual);

    }

    public void eliminaronceavomuslomedio(View view) {

        String actual = medida11.getText().toString();
        agregar.setText(actual);

    }

    public void eliminardoceavomuslomedio(View view) {

        String actual = medida12.getText().toString();
        agregar.setText(actual);

    }



    public void borrarmuslomedio(View view) {
        String id2 = mAuth1.getCurrentUser().getUid();
        String edittext = agregar.getText().toString();

        if (edittext.isEmpty()){

        }

        else {

            String valor1 = medida1.getText().toString();
            String valor2 = medida2.getText().toString();
            String valor3 = medida3.getText().toString();
            String valor4 = medida4.getText().toString();
            String valor5 = medida5.getText().toString();
            String valor6 = medida6.getText().toString();
            String valor7 = medida7.getText().toString();
            String valor8 = medida8.getText().toString();
            String valor9 = medida9.getText().toString();
            String valor10 = medida10.getText().toString();
            String valor11 = medida11.getText().toString();
            String valor12 = medida12.getText().toString();



            if (edittext.equals(valor1)){
                agregar.setText("");
                medida1.setText("");
                fecha1.setText("");
                cm1.setText("");

                Map<String, Object> medidabrazorelajado = new HashMap<>();
                medidabrazorelajado.put("Muslo medio/ primera medida/ medida", "");
                medidabrazorelajado.put("Muslo medio/ primera medida/ fecha", "");
                mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);



            } else {
                if (edittext.equals(valor2)){
                    agregar.setText("");
                    medida2.setText("");
                    fecha2.setText("");
                    cm2.setText("");

                    Map<String, Object> medidabrazorelajado = new HashMap<>();
                    medidabrazorelajado.put("Muslo medio/ segunda medida/ medida", "");
                    medidabrazorelajado.put("Muslo medio/ segunda medida/ fecha", "");
                    mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);



                } else {
                    if (edittext.equals(valor3)){
                        agregar.setText("");
                        medida3.setText("");
                        fecha3.setText("");
                        cm3.setText("");

                        Map<String, Object> medidabrazorelajado = new HashMap<>();
                        medidabrazorelajado.put("Muslo medio/ tercer medida/ medida", "");
                        medidabrazorelajado.put("Muslo medio/ tercer medida/ fecha", "");
                        mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);



                    }  else {
                        if (edittext.equals(valor4)){
                            agregar.setText("");
                            medida4.setText("");
                            fecha4.setText("");
                            cm4.setText("");

                            Map<String, Object> medidabrazorelajado = new HashMap<>();
                            medidabrazorelajado.put("Muslo medio/ cuarto medida/ medida", "");
                            medidabrazorelajado.put("Muslo medio/ cuarto medida/ fecha", "");
                            mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);



                        } else {
                            if (edittext.equals(valor5)){
                                agregar.setText("");
                                medida5.setText("");
                                fecha5.setText("");
                                cm5.setText("");

                                Map<String, Object> medidabrazorelajado = new HashMap<>();
                                medidabrazorelajado.put("Muslo medio/ quinto medida/ medida", "");
                                medidabrazorelajado.put("Muslo medio/ quinto medida/ fecha", "");
                                mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);



                            } else {
                                if (edittext.equals(valor6)){
                                    agregar.setText("");
                                    medida6.setText("");
                                    fecha6.setText("");
                                    cm6.setText("");

                                    Map<String, Object> medidabrazorelajado = new HashMap<>();
                                    medidabrazorelajado.put("Muslo medio/ sexto medida/ medida", "");
                                    medidabrazorelajado.put("Muslo medio/ sexto medida/ fecha", "");
                                    mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);



                                } else {
                                    if (edittext.equals(valor7)){
                                        agregar.setText("");
                                        medida7.setText("");
                                        fecha7.setText("");
                                        cm7.setText("");

                                        Map<String, Object> medidabrazorelajado = new HashMap<>();
                                        medidabrazorelajado.put("Muslo medio/ septimo medida/ medida", "");
                                        medidabrazorelajado.put("Muslo medio/ septimo medida/ fecha", "");
                                        mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);



                                    } else {
                                        if (edittext.equals(valor8)){
                                            agregar.setText("");
                                            medida8.setText("");
                                            fecha8.setText("");
                                            cm8.setText("");

                                            Map<String, Object> medidabrazorelajado = new HashMap<>();
                                            medidabrazorelajado.put("Muslo medio/ octavo medida/ medida", "");
                                            medidabrazorelajado.put("Muslo medio/ octavo medida/ fecha", "");
                                            mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);



                                        } else {
                                            if (edittext.equals(valor9)){
                                                agregar.setText("");
                                                medida9.setText("");
                                                fecha9.setText("");
                                                cm9.setText("");

                                                Map<String, Object> medidabrazorelajado = new HashMap<>();
                                                medidabrazorelajado.put("Muslo medio/ noveno medida/ medida", "");
                                                medidabrazorelajado.put("Muslo medio/ noveno medida/ fecha", "");
                                                mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);



                                            } else {
                                                if (edittext.equals(valor10)){
                                                    agregar.setText("");
                                                    medida10.setText("");
                                                    fecha10.setText("");
                                                    cm10.setText("");

                                                    Map<String, Object> medidabrazorelajado = new HashMap<>();
                                                    medidabrazorelajado.put("Muslo medio/ decimo medida/ medida", "");
                                                    medidabrazorelajado.put("Muslo medio/ decimo medida/ fecha", "");
                                                    mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);



                                                } else {
                                                    if (edittext.equals(valor11)){
                                                        agregar.setText("");
                                                        medida11.setText("");
                                                        fecha11.setText("");
                                                        cm11.setText("");

                                                        Map<String, Object> medidabrazorelajado = new HashMap<>();
                                                        medidabrazorelajado.put("Muslo medio/ onceavo medida/ medida", "");
                                                        medidabrazorelajado.put("Muslo medio/ onceavo medida/ fecha", "");
                                                        mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);



                                                    } else {
                                                        if (edittext.equals(valor12)){
                                                            agregar.setText("");
                                                            medida12.setText("");
                                                            fecha12.setText("");
                                                            cm12.setText("");

                                                            Map<String, Object> medidabrazorelajado = new HashMap<>();
                                                            medidabrazorelajado.put("Muslo medio/ doceavo medida/ medida", "");
                                                            medidabrazorelajado.put("Muslo medio/ doceavo medida/ fecha", "");
                                                            mDatabase1.child("Users").child(id2).updateChildren(medidabrazorelajado);



                                                        } else {
                                                            Toast.makeText(this, "Primero, selecciona una medida", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }

    }










}
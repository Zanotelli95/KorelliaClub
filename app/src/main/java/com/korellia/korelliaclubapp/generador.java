package com.korellia.korelliaclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class generador extends AppCompatActivity {

    private   DatabaseReference mDatabase;
    private  FirebaseAuth mAuth;
    private    DatabaseReference mRootReference;

    private    int contadoraltura = 0;
    private    int contadorpeso = 0;
    private    int contadoredaddeentrenamiento = 0;
    private    int contadorreposo = 0;
    private   int contadoralimenticios = 0;
    private   int contadorestresf = 0;
    private     int puntosfinales = 0;
    private     String fin;

    //nutricion




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generador);

        //logicadelentrenamiento(ejercicios)
        mRootReference = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();

        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if (datasnapshot.exists()) {
                        double Contadorgener;
                        double edadcr; double edadfin = 0;
                        double estatura; double estaturafin = 0;
                         double peso; double pesofin = 0;
                         double expfin = 0;
                         double fuerza = 0;
                         double fre = 0;
                         double rec = 0;
                         double act;
                         double estresfis = 0;
                         double reposofin = 0;
                         double estresmen = 0;
                         double nutricion = 0;


                    //series minimas
                    String genero = datasnapshot.child("sexo").getValue().toString();
                    if (genero.equals("Masculino")){
                        Contadorgener = 0;

                        String centimetros = datasnapshot.child("centimetros").getValue().toString();
                        estatura = Double.parseDouble(centimetros);
                        if (estatura <= 170){
                            estaturafin = 1;
                        }
                        if (estatura > 170 && estatura < 182){
                            estaturafin = 0.5;
                        }
                        if (estatura >= 182 && estatura < 195){
                            estaturafin = -0.5;
                        }
                        if (estatura >= 195){
                            estaturafin = -1;
                        }


                        String kg = datasnapshot.child("kilogramos").getValue().toString();
                        peso = Double.parseDouble(kg);
                        if (peso <= 75){
                            pesofin = 1.5;
                        }
                        if (peso > 75 && peso < 99){
                            pesofin = 0.5;
                        }
                        if (peso >= 100 && peso < 125){
                            pesofin = -0.5;
                        }
                        if (peso >= 125){
                            pesofin = -1.5;
                        }



                    } else {
                        Contadorgener = 1.5;


                        String centimetros = datasnapshot.child("centimetros").getValue().toString();
                        estatura = Double.parseDouble(centimetros);
                        if (estatura <= 160){
                            estaturafin = 1;
                        }
                        if (estatura > 160 && estatura < 167){
                            estaturafin = 0.5;
                        }
                        if (estatura >= 167 && estatura < 175){
                            estaturafin = -0.5;
                        }
                        if (estatura >= 175){
                            estaturafin = -1;
                        }

                        String kg = datasnapshot.child("kilogramos").getValue().toString();
                        peso = Double.parseDouble(kg);
                        if (peso <= 56){
                            pesofin = 1.5;
                        }
                        if (peso > 56 && peso < 75){
                            pesofin = 0.5;
                        }
                        if (peso >= 75 && peso < 90){
                            pesofin = -0.5;
                        }
                        if (peso >= 90){
                            pesofin = -1.5;
                        }



                    }

                    String edadcronologica = datasnapshot.child("Edad").getValue().toString();
                        edadcr = Double.parseDouble(edadcronologica);
                    if (edadcr <= 19){
                        edadfin = -1;
                    }
                    if (edadcr > 19 && edadcr < 30){
                        edadfin = -0.5;
                    }
                    if (edadcr > 30 && edadcr < 40){
                        edadfin = 0;
                    }
                    if (edadcr > 40 && edadcr < 50){
                        edadfin = 0.5;
                    }
                    if (edadcr >= 50){
                        edadfin = 1;
                    }


                    String exp = datasnapshot.child("años de entrenamiento").getValue().toString();

                    if (exp.equals("nunca he entrenado")){
                        expfin = -1;
                        fuerza = -0.5;
                    }
                    if (exp.equals("menos de 4 años")){
                        expfin = -1;
                        fuerza = -0.5;
                    }
                    if (exp.equals("de 4 a 8 años")){
                        edadfin = -0.5;
                        fuerza = -0;
                    }
                    if (exp.equals("de 8 a 12 años")){
                        edadfin = 0.5;
                        fuerza = 0.5;
                    }
                    if (exp.equals("más de 12 años")){
                        edadfin = 1;
                        fuerza = 1;
                    }


                    String frecuenciaanterior = datasnapshot.child("frecuencia de entrenamiento anterior").getValue().toString();
                    if (frecuenciaanterior.equals("1 vez por semana")){
                            fre = -1;
                    }
                    if (frecuenciaanterior.equals("1 a 2 veces por semana")){
                        fre = -0.5;
                    }
                    if (frecuenciaanterior.equals("2 veces por semana")){
                        fre = 0;
                    }
                    if (frecuenciaanterior.equals("2 a 3 veces por semana")){
                        fre = 0.5;
                    }
                    if (frecuenciaanterior.equals("3 veces por semana")){
                        fre = 1;
                    }
                    if (frecuenciaanterior.equals("nunca he entrenado")){
                        fre = 0;
                    }

                    String recuperacion= datasnapshot.child("capacidad de recuperación").getValue().toString();
                    if (recuperacion.equals("nunca he entrenado")){
                        rec = 0;
                    }
                    if (recuperacion.equals("menos de 1 día")){
                        rec = 1;
                    }
                    if (recuperacion.equals("raramente se presenta dolor por más de un día")){
                        rec = 0.5;
                    }
                    if (recuperacion.equals("se presenta dolor de 1 a 2 días")){
                        rec = 0;
                    }
                    if (recuperacion.equals("se presenta dolor hasta por 2 dias")){
                        rec = -0.5;
                    }
                    if (recuperacion.equals("se presenta dolor hasta por 3 dias")){
                        rec = -1;
                    }


                    String actividades = datasnapshot.child("actividades extras").getValue().toString();
                    if (actividades.equals("si")){
                        act = -1;
                    } else {
                        act = 0;
                    }

                    String estresf = datasnapshot.child("estrés físico").getValue().toString();
                    if (estresf.equals("alto")){
                        estresfis = 1.5;
                    }
                    if (estresf.equals("bajo")){
                        estresfis = -0.5;
                    }
                    if (estresf.equals("regular")){
                        estresfis = 1;
                    }
                    if (estresf.equals("nulo")){
                        estresfis = 0;
                    }

                    String estresm = datasnapshot.child("estrés mental").getValue().toString();
                    if (estresm.equals("alto")){
                        estresmen = 0.5;
                    }
                    if (estresm.equals("regular")){
                        estresmen = 0;
                    }
                    if (estresm.equals("bajo")){
                        estresmen = -0.5;
                    }

                    String sueño = datasnapshot.child("horas de sueño").getValue().toString();
                    if (sueño.equals("alto")){
                        reposofin = 0.5;
                    }
                    if (sueño.equals("regular")){
                        reposofin = 0;
                    }
                    if (sueño.equals("bajo")){
                        reposofin = -0.5;
                    }

                    String alimentacion = datasnapshot.child("objetivos nutricionales").getValue().toString();
                    if (alimentacion.equals("Planeo ganar mucho peso corporal")){
                        nutricion = -1.5;
                    }
                    if (alimentacion.equals("Planeo ganar un peso corporal moderado")){
                        nutricion = -1;
                    }
                    if (alimentacion.equals("Planeo ganar poco peso corporal")){
                        nutricion = -0.5;
                    }
                    if (alimentacion.equals("Planeo mantener mi peso corporal")){
                        nutricion = 0;
                    }
                    if (alimentacion.equals("Planeo bajar poco peso corporal")){
                        nutricion = 0.5;
                    }
                    if (alimentacion.equals("Planeo bajar un peso corporal moderado")){
                        nutricion = 1;
                    }
                    if (alimentacion.equals("Planeo bajar mucho peso corporal")){
                        nutricion = 1.5;
                    }



                    Double seriespectorales = 12 + Contadorgener + edadfin + estaturafin + pesofin + expfin + fuerza + fre + rec + act + estresfis + reposofin + estresmen + nutricion;
                   Double seriespectoralesredondeado = Math.ceil(seriespectorales);

                   Double seriesespalda = 12 + Contadorgener + edadfin + estaturafin + pesofin + expfin + fuerza + fre + rec + act + estresfis + reposofin + estresmen + nutricion;
                    Double seriesespaldaredondeado = Math.ceil(seriesespalda);

                    Double seriesbiceps = 10 + Contadorgener + edadfin + estaturafin + pesofin + expfin + fuerza + fre + rec + act + estresfis + reposofin + estresmen + nutricion;
                    Double seriesbicepsredondeado = Math.ceil(seriesbiceps);

                    Double seriestriceps = 8 + Contadorgener + edadfin + estaturafin + pesofin + expfin + fuerza + fre + rec + act + estresfis + reposofin + estresmen + nutricion;
                    Double seriestricepsredondeado = Math.ceil(seriestriceps);

                    Double seriesfrontal = 6 + Contadorgener + edadfin + estaturafin + pesofin + expfin + fuerza + fre + rec + act + estresfis + reposofin + estresmen + nutricion;
                    Double seriesfrontalredondeado = Math.floor(seriesfrontal);

                    Double serieslateral = 10 + Contadorgener + edadfin + estaturafin + pesofin + expfin + fuerza + fre + rec + act + estresfis + reposofin + estresmen + nutricion;
                    Double serieslateralredondeado = Math.ceil(serieslateral);

                    Double seriestraps = 5 + Contadorgener + edadfin + estaturafin + pesofin + expfin + fuerza + fre + rec + act + estresfis + reposofin + estresmen + nutricion;
                    Double seriestrapsredondeado = Math.floor(seriestraps);

                    Double seriescuadriceps = 10 + Contadorgener + edadfin + estaturafin + pesofin + expfin + fuerza + fre + rec + act + estresfis + reposofin + estresmen + nutricion;
                    Double seriescuadricepsredondeado = Math.ceil(seriescuadriceps);

                    Double seriesfemorales = 8 + Contadorgener + edadfin + estaturafin + pesofin + expfin + fuerza + fre + rec + act + estresfis + reposofin + estresmen + nutricion;
                    Double seriesfemoralesredondeado = Math.ceil(seriesfemorales);

                    Double seriespantorrillas = 10 + Contadorgener + edadfin + estaturafin + pesofin + expfin + fuerza + fre + rec + act + estresfis + reposofin + estresmen + nutricion;
                    Double seriespantorrillasredondeado = Math.ceil(seriespantorrillas);

                    Double seriesabs = 6 + Contadorgener + edadfin + estaturafin + pesofin + expfin + fuerza + fre + rec + act + estresfis + reposofin + estresmen + nutricion;
                    Double seriesabsredondeado = Math.ceil(seriesabs);

                    Double seriesgluteos = 6 + Contadorgener + edadfin + estaturafin + pesofin + expfin + fuerza + fre + rec + act + estresfis + reposofin + estresmen + nutricion;
                    Double seriesgluteosredondeado = Math.ceil(seriesgluteos);



                    Map<String, Object> series = new HashMap<>();
                    series.put("series pectoral", seriespectoralesredondeado);
                    series.put("series espalda", seriesespaldaredondeado);
                    series.put("series biceps", seriesbicepsredondeado);
                    series.put("series triceps", seriestricepsredondeado);
                    series.put("series deltoide frontal", seriesfrontalredondeado);
                    series.put("series deltoides laterales y posteriores", serieslateralredondeado);
                    series.put("series trapecios", seriestrapsredondeado);
                    series.put("series cuadriceps", seriescuadricepsredondeado);
                    series.put("series femorales", seriesfemoralesredondeado);
                    series.put("series pantorrillas", seriespantorrillasredondeado);
                    series.put("series abdominales", seriesabsredondeado);
                    series.put("series gluteos", seriesgluteosredondeado);



                    mRootReference.child("Users").child(id).updateChildren(series);


//------------------------------------------------------------------------------------------------------------------------------------------------------




                    //nutricion

                        String objetivo= datasnapshot.child("objetivos nutricionales").getValue().toString();


                        String kg= datasnapshot.child("kilogramos").getValue().toString();
                        String cm= datasnapshot.child("centimetros").getValue().toString();
                        String edad= datasnapshot.child("Edad").getValue().toString();
                        String sexo= datasnapshot.child("sexo").getValue().toString();
                        String dias = datasnapshot.child("dias").getValue().toString();

                        if(sexo.equals("Masculino")) {
                            float parte1 = (Float.parseFloat(kg) * 10);
                            String parte1s = Float.toString(parte1);

                            float parte2 = (float) (Float.parseFloat(cm) * 6.25);
                            String parte2s = Double.toString(parte2);

                            float parte3 = (float) (Float.parseFloat(edad) * 5);
                            String parte3s = Double.toString(parte3);

                            float parte4 = 5;


                            float metabolismo = parte1 + parte2 - parte3 + parte4;


                            if(dias.equals("3")){
                                float caloriasmantenimiento = Math.round((float) (metabolismo * 1.375)) / 1 ;
                                String caloriasmanteimientofinalesstring = Float.toString(caloriasmantenimiento);


                                if (objetivo.equals("Planeo ganar mucho peso corporal")){
                                    float suma = caloriasmantenimiento + 700;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo ganar un peso corporal moderado")){
                                    float suma = caloriasmantenimiento + 500;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo ganar poco peso corporal")){
                                    float suma = caloriasmantenimiento + 300;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo mantener mi peso corporal")){
                                    float suma = caloriasmantenimiento + 0;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo bajar poco peso corporal")){
                                    float suma = caloriasmantenimiento - 300;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo bajar un peso corporal moderado")){
                                    float suma = caloriasmantenimiento - 500;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo bajar mucho peso corporal")){
                                    float suma = caloriasmantenimiento - 700;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }



                            }

                            if(dias.equals("4")){
                                float caloriasmantenimiento = Math.round((float) (metabolismo * 1.55)) / 1;
                                String caloriasmanteimientofinalesstring = Float.toString(caloriasmantenimiento);


                                if (objetivo.equals("Planeo ganar mucho peso corporal")){
                                    float suma = caloriasmantenimiento + 700;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo ganar un peso corporal moderado")){
                                    float suma = caloriasmantenimiento + 500;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo ganar poco peso corporal")){
                                    float suma = caloriasmantenimiento + 300;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo mantener mi peso corporal")){
                                    float suma = caloriasmantenimiento + 0;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo bajar poco peso corporal")){
                                    float suma = caloriasmantenimiento - 300;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo bajar un peso corporal moderado")){
                                    float suma = caloriasmantenimiento - 500;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo bajar mucho peso corporal")){
                                    float suma = caloriasmantenimiento - 700;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }


                            }


                            if(dias.equals("5")){
                                float caloriasmantenimiento = Math.round((float) (metabolismo * 1.725)) / 1;
                                String caloriasmanteimientofinalesstring = Float.toString(caloriasmantenimiento);


                                if (objetivo.equals("Planeo ganar mucho peso corporal")){
                                    float suma = caloriasmantenimiento + 700;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo ganar un peso corporal moderado")){
                                    float suma = caloriasmantenimiento + 500;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo ganar poco peso corporal")){
                                    float suma = caloriasmantenimiento + 300;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo mantener mi peso corporal")){
                                    float suma = caloriasmantenimiento + 0;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo bajar poco peso corporal")){
                                    float suma = caloriasmantenimiento - 300;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo bajar un peso corporal moderado")){
                                    float suma = caloriasmantenimiento - 500;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo bajar mucho peso corporal")){
                                    float suma = caloriasmantenimiento - 700;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }


                            }

                            if(dias.equals("6")){
                                float caloriasmantenimiento = Math.round((float) (metabolismo * 1.725)) / 1;
                                String caloriasmanteimientofinalesstring = Float.toString(caloriasmantenimiento);


                                if (objetivo.equals("Planeo ganar mucho peso corporal")){
                                    float suma = caloriasmantenimiento + 700;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo ganar un peso corporal moderado")){
                                    float suma = caloriasmantenimiento + 500;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo ganar poco peso corporal")){
                                    float suma = caloriasmantenimiento + 300;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo mantener mi peso corporal")){
                                    float suma = caloriasmantenimiento + 0;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo bajar poco peso corporal")){
                                    float suma = caloriasmantenimiento - 300;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo bajar un peso corporal moderado")){
                                    float suma = caloriasmantenimiento - 500;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }

                                if (objetivo.equals("Planeo bajar mucho peso corporal")){
                                    float suma = caloriasmantenimiento - 700;
                                    String cf = Float.toString(suma);

                                    Map<String, Object> generador = new HashMap<>();
                                    generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                    generador.put("calorias totales", cf);

                                    mRootReference.child("Users").child(id).updateChildren(generador);
                                }


                            }




                        }


                        //femininna
                    if (sexo.equals("Femenino")){

                        float parte1 = (Float.parseFloat(kg) * 10);
                        String parte1s = Float.toString(parte1);

                        float parte2 = (float) (Float.parseFloat(cm) * 6.25);
                        String parte2s = Double.toString(parte2);

                        float parte3 = (float) (Float.parseFloat(edad) * 5);
                        String parte3s = Double.toString(parte3);

                        float parte4 = 161;


                        float metabolismo = parte1 + parte2 - parte3 - parte4;


                        if(dias.equals("3")){
                            float caloriasmantenimiento = Math.round((float) (metabolismo * 1.375)) / 1;
                            String caloriasmanteimientofinalesstring = Float.toString(caloriasmantenimiento);


                            if (objetivo.equals("Planeo ganar mucho peso corporal")){
                                float suma = caloriasmantenimiento + 700;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo ganar un peso corporal moderado")){
                                float suma = caloriasmantenimiento + 500;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo ganar poco peso corporal")){
                                float suma = caloriasmantenimiento + 300;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo mantener mi peso corporal")){
                                float suma = caloriasmantenimiento + 0;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo bajar poco peso corporal")){
                                float suma = caloriasmantenimiento - 300;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);
                            }

                            if (objetivo.equals("Planeo bajar un peso corporal moderado")){
                                float suma = caloriasmantenimiento - 500;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo bajar mucho peso corporal")){
                                float suma = caloriasmantenimiento - 700;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);
                            }



                        }

                        if(dias.equals("4")){
                            float caloriasmantenimiento = Math.round((float) (metabolismo * 1.55)) / 1;
                            String caloriasmanteimientofinalesstring = Float.toString(caloriasmantenimiento);


                            if (objetivo.equals("Planeo ganar mucho peso corporal")){
                                float suma = caloriasmantenimiento + 700;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);


                            }

                            if (objetivo.equals("Planeo ganar un peso corporal moderado")){
                                float suma = caloriasmantenimiento + 500;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo ganar poco peso corporal")){
                                float suma = caloriasmantenimiento + 300;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo mantener mi peso corporal")){
                                float suma = caloriasmantenimiento + 0;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);
                            }

                            if (objetivo.equals("Planeo bajar poco peso corporal")){
                                float suma = caloriasmantenimiento - 300;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo bajar un peso corporal moderado")){
                                float suma = caloriasmantenimiento - 500;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo bajar mucho peso corporal")){
                                float suma = caloriasmantenimiento - 700;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);
                            }


                        }


                        if(dias.equals("5")){
                            float caloriasmantenimiento = Math.round((float) (metabolismo * 1.725)) / 1;
                            String caloriasmanteimientofinalesstring = Float.toString(caloriasmantenimiento);


                            if (objetivo.equals("Planeo ganar mucho peso corporal")){
                                float suma = caloriasmantenimiento + 700;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo ganar un peso corporal moderado")){
                                float suma = caloriasmantenimiento + 500;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo ganar poco peso corporal")){
                                float suma = caloriasmantenimiento + 300;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo mantener mi peso corporal")){
                                float suma = caloriasmantenimiento + 0;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo bajar poco peso corporal")){
                                float suma = caloriasmantenimiento - 300;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo bajar un peso corporal moderado")){
                                float suma = caloriasmantenimiento - 500;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo bajar mucho peso corporal")){
                                float suma = caloriasmantenimiento - 700;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }


                        }

                        if(dias.equals("6")){
                            float caloriasmantenimiento = Math.round((float) (metabolismo * 1.725)) / 1;
                            String caloriasmanteimientofinalesstring = Float.toString(caloriasmantenimiento);


                            if (objetivo.equals("Planeo ganar mucho peso corporal")){
                                float suma = caloriasmantenimiento + 700;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo ganar un peso corporal moderado")){
                                float suma = caloriasmantenimiento + 500;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo ganar poco peso corporal")){
                                float suma = caloriasmantenimiento + 300;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo mantener mi peso corporal")){
                                float suma = caloriasmantenimiento + 0;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }

                            if (objetivo.equals("Planeo bajar poco peso corporal")){
                                float suma = caloriasmantenimiento - 300;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);
                            }

                            if (objetivo.equals("Planeo bajar un peso corporal moderado")){
                                float suma = caloriasmantenimiento - 500;
                                String cf = Float.toString(suma);
                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);


                            }

                            if (objetivo.equals("Planeo bajar mucho peso corporal")){
                                float suma = caloriasmantenimiento - 700;
                                String cf = Float.toString(suma);

                                Map<String, Object> generador = new HashMap<>();
                                generador.put("calorias de mantenimiento", caloriasmantenimiento);
                                generador.put("calorias totales", cf);

                                mRootReference.child("Users").child(id).updateChildren(generador);

                            }


                        }


                    }












 //---------------------------------------------------------------------------------------------------------------------------------------------------------





                        //entrenamiento

                    //si es hombre...

                    String altura = datasnapshot.child("centimetros").getValue().toString();
                    String pesocorporal = datasnapshot.child("kilogramos").getValue().toString();
                    String edadentrenamiento = datasnapshot.child("años de entrenamiento").getValue().toString();
                    String reposo = datasnapshot.child("horas de sueño").getValue().toString();
                    String habitosalimenticios = datasnapshot.child("objetivos nutricionales").getValue().toString();
                    String estresfisico = datasnapshot.child("estrés físico").getValue().toString();

                    int alturag = Integer.parseInt(altura);
                    int pesocorporalg = Integer.parseInt(pesocorporal);

                    int alturamedia = 175;
                    int pesomedio = 80;

                    //altura
                    if (alturag >alturamedia){
                        contadoraltura = 1;
                    }
                    //peso
                    if (pesocorporalg >pesomedio){
                        contadorpeso = 1;
                    }
                    //años de entrenamiento
                    if (edadentrenamiento.equals("nunca he entrenado")){
                        contadoredaddeentrenamiento = 0;
                    }
                    if (edadentrenamiento.equals("menos de 4 años")){
                        contadoredaddeentrenamiento = 0;
                    }
                    if (edadentrenamiento.equals("de 4 a 8 años")){
                        contadoredaddeentrenamiento = 0;
                    }
                    if (edadentrenamiento.equals("de 8 a 12 años")){
                        contadoredaddeentrenamiento = 1;
                    }
                    if (edadentrenamiento.equals("más de 12 años")){
                        contadoredaddeentrenamiento = 1;
                    }
                    //horas de sueño
                    if (reposo.equals("menos de 5 horas")){
                        contadorreposo = 0;
                    }
                    if (reposo.equals("de 5 a 7 horas")){
                        contadorreposo = 1;
                    }
                    if (reposo.equals("más de 7 horas")){
                        contadorreposo = 1;
                    }
                    //habitos alimenticios
                    if (habitosalimenticios.equals("Planeo bajar mucho peso corporal")){
                        contadoralimenticios = 0;
                    }
                    if (habitosalimenticios.equals("Planeo bajar un peso corporal moderado")){
                        contadoralimenticios = 0;
                    }
                    if (habitosalimenticios.equals("Planeo bajar poco peso corporal")){
                        contadoralimenticios = 0;
                    }
                    if (habitosalimenticios.equals("Planeo mantener mi peso corporal")){
                        contadoralimenticios = 1;
                    }
                    if (habitosalimenticios.equals("Planeo ganar poco peso corporal")){
                        contadoralimenticios = 1;
                    }
                    if (habitosalimenticios.equals("Planeo ganar un peso corporal moderado")){
                        contadoralimenticios = 1;
                    }
                    if (habitosalimenticios.equals("Planeo ganar mucho peso corporal")){
                        contadoralimenticios = 1;
                    }
                    //estres fisico
                    if (estresfisico.equals("alto")){
                        contadorestresf = 0;
                    }
                    if (estresfisico.equals("bajo")){
                        contadorestresf = 0;
                    }
                    if (estresfisico.equals("regular")){
                        contadorestresf = 1;
                    }
                    if (estresfisico.equals("nulo")){
                        contadorestresf = 1;
                    }


                    //determina el puntaje final para los ejercicios y los sube a firebase
                    puntosfinales = contadorestresf + contadoralimenticios + contadorreposo + contadoredaddeentrenamiento + contadorpeso + contadoraltura;
                     fin = Integer.toString(puntosfinales);
                   // Toast.makeText(getApplicationContext(),fin,Toast.LENGTH_SHORT).show();


                    Map<String, Object> generador = new HashMap<>();
                    generador.put("puntaje ejercicios", fin);
                    mRootReference.child("Users").child(id).updateChildren(generador);


                    int puntajefinal = Integer.parseInt(fin);
                    if (puntajefinal < 3) {
                        //selecciona al azar una ejercicio listado y lo sube a firebase

                        //pecho
                        ArrayList<String> listapectoral = new ArrayList<>();
                        listapectoral.add("Press con mancuernas en banco plano");
                        listapectoral.add("Press con mancuernas en banco inclinado");
                        listapectoral.add("Press de pectorales en máquina hammer");
                        listapectoral.add("Press declinado con mancuernas");

                        StringBuilder stringBuilder = new StringBuilder();
                        Random random = new Random();
                        int i = random.nextInt(listapectoral.size());
                        stringBuilder.append(listapectoral.get(i));
                        String newPath = stringBuilder.toString();

                        //pecho ejercicio secundario
                        ArrayList<String> listapectoral2 = new ArrayList<>();
                        listapectoral2.add("Aperturas con mancuernas en banco plano");
                        listapectoral2.add("Aperturas con mancuernas en banco inclinado");
                        listapectoral2.add("Aperturas en peck deck");
                        listapectoral2.add("Fondos");


                        StringBuilder stringBuilder2 = new StringBuilder();
                        Random random2 = new Random();
                        int i2 = random2.nextInt(listapectoral2.size());
                        stringBuilder2.append(listapectoral2.get(i2));
                        String newPath2 = stringBuilder2.toString();

                        //pecho ejercicio terciairio
                        ArrayList<String> listapectoral3 = new ArrayList<>();
                        listapectoral3.add("Fondos");
                        listapectoral3.add("Press con mancuernas en banco inclinado");
                        listapectoral3.add("Press de pectorales en maquina");
                        listapectoral3.add("Aperturas en crossover (polea a nivel medio)");
                        listapectoral3.add("Aperturas en crossover (polea a nivel bajo)");


                        StringBuilder stringBuilder3 = new StringBuilder();
                        Random random3 = new Random();
                        int i3 = random3.nextInt(listapectoral3.size());
                        stringBuilder3.append(listapectoral3.get(i3));
                        String newPath3 = stringBuilder3.toString();

                        //pecho ejercicio cuarto
                        ArrayList<String> listapectoral4 = new ArrayList<>();
                        listapectoral4.add("Aperturas en crossover (polea a nivel medio)");
                        listapectoral4.add("Aperturas en crossover (polea a nivel bajo)");
                        listapectoral4.add("Aperturas en crossover (polea a nivel alto)");
                        listapectoral4.add("Lagartijas");


                        StringBuilder stringBuilder4 = new StringBuilder();
                        Random random4 = new Random();
                        int i4 = random4.nextInt(listapectoral4.size());
                        stringBuilder4.append(listapectoral4.get(i4));
                        String newPath4 = stringBuilder4.toString();


                        Map<String, Object> ejercicio = new HashMap<>();
                        ejercicio.put("pectoral/ ejercicio primario", newPath);
                        ejercicio.put("pectoral/ ejercicio secundario", newPath2);
                        ejercicio.put("pectoral/ ejercicio tercero", newPath3);
                        ejercicio.put("pectoral/ ejercicio cuarto", newPath4);
                        mRootReference.child("Users").child(id).updateChildren(ejercicio);


                        //abs
                        ArrayList<String> listaabs = new ArrayList<>();
                        listaabs.add("Crunch abdominal en maquina");
                        listaabs.add("Crunch abdominal en maquina con cuerda");
                        listaabs.add("Rodillo abdominal");
                        listaabs.add("Crunch abdominal hincado con cuerda");
                        listaabs.add("Crunch tipo bicicleta");
                        listaabs.add("Crunch abdominal en banco declinado con balon en la nuca");

                        StringBuilder stringBuilderabs = new StringBuilder();
                        Random randomabs = new Random();
                        int iabs = randomabs.nextInt(listaabs.size());
                        stringBuilderabs.append(listaabs.get(iabs));
                        String newPathabs = stringBuilderabs.toString();

                        ArrayList<String> listaabs2 = new ArrayList<>();
                        listaabs2.add("Elevaciones de piernas acostado en banco");
                        listaabs2.add("Elevaciones de piernas en silla romana");
                        listaabs2.add("Crunch lateral con polea alta");
                        listaabs2.add("Crunch abdominal en banco declinado");

                        StringBuilder stringBuilderabs2 = new StringBuilder();
                        Random randomabs2 = new Random();
                        int iabs2 = randomabs2.nextInt(listaabs2.size());
                        stringBuilderabs2.append(listaabs2.get(iabs2));
                        String newPathabs2 = stringBuilderabs2.toString();

                        ArrayList<String> listaabs3 = new ArrayList<>();
                        listaabs3.add("Crunch abdominal");
                        listaabs3.add("Toques al talón");
                        listaabs3.add("Crunch acostado en flexión de piernas");
                        listaabs3.add("Crunch lateral");

                        StringBuilder stringBuilderabs3 = new StringBuilder();
                        Random randomabs3 = new Random();
                        int iabs3 = randomabs3.nextInt(listaabs3.size());


                        stringBuilderabs3.append(listaabs3.get(iabs3));
                        String newPathabs3 = stringBuilderabs3.toString();


                        Map<String, Object> ejercicioabs = new HashMap<>();
                        ejercicioabs.put("abdominales/ ejercicio primario", newPathabs);
                        ejercicioabs.put("abdominales/ ejercicio secundario", newPathabs2);
                        ejercicioabs.put("abdominales/ ejercicio tercero", newPathabs3);
                        mRootReference.child("Users").child(id).updateChildren(ejercicioabs);


                        //elevaciones laterales y posteriores
                        ArrayList<String> listalaterales = new ArrayList<>();
                        listalaterales.add("Remo al mentón con barra");
                        listalaterales.add("Elevaciones laterales con mancuernas");
                        listalaterales.add("Elevación lateral con mancuernas acostado en banco inclinado de perfil");
                        listalaterales.add("Remo al mentón con mancuernas");

                        StringBuilder stringBuilderlaterales = new StringBuilder();
                        Random randomlaterales = new Random();
                        int ilaterales = randomlaterales.nextInt(listalaterales.size());
                        stringBuilderlaterales.append(listalaterales.get(ilaterales));
                        String newPathlaterales = stringBuilderlaterales.toString();

                        ArrayList<String> listalaterales2 = new ArrayList<>();
                        listalaterales2.add("Elevación lateral con polea baja por detrás");
                        listalaterales2.add("Flys invertidos en peck deck");
                        listalaterales2.add("Flys agachado con mancuernas");
                        listalaterales2.add("Elevación lateral con mancuerna a 45°");

                        StringBuilder stringBuilderlaterales2 = new StringBuilder();
                        Random randomlaterales2 = new Random();
                        int ilaterales2 = randomlaterales2.nextInt(listalaterales2.size());
                        stringBuilderlaterales2.append(listalaterales2.get(ilaterales2));
                        String newPathlaterales2 = stringBuilderlaterales2.toString();

                        ArrayList<String> listalaterales3 = new ArrayList<>();
                        listalaterales3.add("Elevación lateral con polea baja");
                        listalaterales3.add("Remo al mentón con polea baja");
                        listalaterales3.add("Facepull con cuerda");
                        listalaterales3.add("Flys cruzados con poleas");


                        StringBuilder stringBuilderlaterales3 = new StringBuilder();
                        Random randomlaterales3 = new Random();
                        int ilaterales3 = randomlaterales3.nextInt(listalaterales3.size());
                        stringBuilderlaterales3.append(listalaterales3.get(ilaterales3));
                        String newPathlaterales3 = stringBuilderlaterales3.toString();


                        Map<String, Object> ejerciciolaterales = new HashMap<>();
                        ejerciciolaterales.put("deltoides laterales y posteriores/ ejercicio primario", newPathlaterales);
                        ejerciciolaterales.put("deltoides laterales y posteriores/ ejercicio secundario", newPathlaterales2);
                        ejerciciolaterales.put("deltoides laterales y posteriores/ ejercicio tercero", newPathlaterales3);
                        mRootReference.child("Users").child(id).updateChildren(ejerciciolaterales);


                        //trapecios
                        ArrayList<String> listatraps = new ArrayList<>();
                        listatraps.add("Encogimiento de hombros con mancuernas");
                        listatraps.add("Encogimiento de hombros en smith por delante");
                        listatraps.add("Encogimiento de hombros con barra por delante");

                        StringBuilder stringBuildertraps = new StringBuilder();
                        Random randomtraps = new Random();
                        int itraps = randomtraps.nextInt(listatraps.size());
                        stringBuildertraps.append(listatraps.get(itraps));
                        String newPathtraps = stringBuildertraps.toString();

                        ArrayList<String> listatraps2 = new ArrayList<>();
                        listatraps2.add("Paseo del granjero");
                        listatraps2.add("Encogiminto de hombros con barra por detrás");
                        listatraps2.add("Encogimiento de hombros con smith por detrás");


                        StringBuilder stringBuildertraps2 = new StringBuilder();
                        Random randomtraps2 = new Random();
                        int itraps2 = randomtraps2.nextInt(listatraps2.size());
                        stringBuildertraps2.append(listatraps2.get(itraps2));
                        String newPathtraps2 = stringBuildertraps2.toString();


                        Map<String, Object> ejerciciotraps2 = new HashMap<>();
                        ejerciciotraps2.put("trapecios/ ejercicio primario", newPathtraps);
                        ejerciciotraps2.put("trapecios/ ejercicio secundario", newPathtraps2);
                        ejerciciotraps2.put("trapecios/ ejercicio tercero", newPathtraps2);
                        mRootReference.child("Users").child(id).updateChildren(ejerciciotraps2);


                        //deltoide frontal
                        ArrayList<String> listafrontales = new ArrayList<>();
                        listafrontales.add("Press militar con mancuernas");
                        listafrontales.add("Press militar en smith");
                        listafrontales.add("Press en máquina agarre prono");
                        listafrontales.add("Press en máquina agarre neutro");
                        listafrontales.add("Press Arnold");

                        StringBuilder stringBuilderfrontales = new StringBuilder();
                        Random randomfrontales = new Random();
                        int ifrontales = randomfrontales.nextInt(listafrontales.size());
                        stringBuilderfrontales.append(listafrontales.get(ifrontales));
                        String newPathfrontales = stringBuilderfrontales.toString();

                        ArrayList<String> listafrontales2 = new ArrayList<>();
                        listafrontales2.add("Elevaciones frontales con mancuernas agarre neutro");
                        listafrontales2.add("Elevaciones frontales con mancuernas agarre prono");
                        listafrontales2.add("Elevaciones frontales con mancuerna agarre supino");


                        StringBuilder stringBuilderfrontales2 = new StringBuilder();
                        Random randomfrontales2 = new Random();
                        int ifrontales2 = randomfrontales2.nextInt(listafrontales2.size());
                        stringBuilderfrontales2.append(listafrontales2.get(ifrontales2));
                        String newPathfrontales2 = stringBuilderfrontales2.toString();

                        ArrayList<String> listafrontales3 = new ArrayList<>();
                        listafrontales3.add("Elevaciones frontales con polea baja a 1 brazo");
                        listafrontales3.add("Elevaciones frontales con disco");
                        listafrontales3.add("Elevaciones frontal con cuerda en polea baja");


                        StringBuilder stringBuilderfrontales3 = new StringBuilder();
                        Random randomfrontales3 = new Random();
                        int ifrontales3 = randomfrontales3.nextInt(listafrontales3.size());
                        stringBuilderfrontales3.append(listafrontales3.get(ifrontales3));
                        String newPathfrontales3 = stringBuilderfrontales3.toString();


                        Map<String, Object> ejerciciofrontales = new HashMap<>();
                        ejerciciofrontales.put("deltoide frontal/ ejercicio primario", newPathfrontales);
                        ejerciciofrontales.put("deltoide frontal/ ejercicio secundario", newPathfrontales2);
                        ejerciciofrontales.put("deltoide frontal/ ejercicio tercero", newPathfrontales3);
                        mRootReference.child("Users").child(id).updateChildren(ejerciciofrontales);


                        //triceps
                        ArrayList<String> listatriceps = new ArrayList<>();
                        listatriceps.add("Press cerrado con barra");
                        listatriceps.add("Press cerrado en smith");
                        listatriceps.add("Rompecraneos con barra z");
                        listatriceps.add("Copa con barra");
                        listatriceps.add("Rompecraneos con mancuernas");


                        StringBuilder stringBuildertriceps = new StringBuilder();
                        Random randomtriceps = new Random();
                        int itriceps = randomtriceps.nextInt(listatriceps.size());
                        stringBuildertriceps.append(listatriceps.get(itriceps));
                        String newPathtriceps = stringBuildertriceps.toString();

                        ArrayList<String> listatriceps2 = new ArrayList<>();
                        listatriceps2.add("Copa con mancuerna sentado");
                        listatriceps2.add("Copa con mancuerna a 1 brazo");
                        listatriceps2.add("Extensiones de tríceps en máquina");
                        listatriceps2.add("Fondos en máquina");


                        StringBuilder stringBuildertriceps2 = new StringBuilder();
                        Random randomtriceps2 = new Random();
                        int itriceps2 = randomtriceps2.nextInt(listatriceps2.size());
                        stringBuildertriceps2.append(listatriceps2.get(itriceps2));
                        String newPathtriceps2 = stringBuildertriceps2.toString();

                        ArrayList<String> listatriceps3 = new ArrayList<>();
                        listatriceps3.add("Extensiones de tríceps en polea alta con maneral recto");
                        listatriceps3.add("Extensiones de tríceps a 1 brazo agarre supino");
                        listatriceps3.add("Patada para tríceps a 1 brazo");


                        StringBuilder stringBuildertriceps3 = new StringBuilder();
                        Random randomtriceps3 = new Random();
                        int itriceps3 = randomtriceps3.nextInt(listatriceps3.size());
                        stringBuildertriceps3.append(listatriceps3.get(itriceps3));
                        String newPathtriceps3 = stringBuildertriceps3.toString();

                        ArrayList<String> listatriceps4 = new ArrayList<>();
                        listatriceps4.add("Extensiones de tríceps en polea alta con maneral recto");
                        listatriceps4.add("Extensiones de tríceps con cuerda");
                        listatriceps4.add("Patada para tríceps con polea");


                        StringBuilder stringBuildertriceps4 = new StringBuilder();
                        Random randomtriceps4 = new Random();
                        int itriceps4 = randomtriceps4.nextInt(listatriceps4.size());
                        stringBuildertriceps4.append(listatriceps4.get(itriceps4));
                        String newPathtriceps4 = stringBuildertriceps4.toString();


                        Map<String, Object> ejerciciotriceps = new HashMap<>();
                        ejerciciotriceps.put("triceps/ ejercicio primario", newPathtriceps);
                        ejerciciotriceps.put("triceps/ ejercicio secundario", newPathtriceps2);
                        ejerciciotriceps.put("triceps/ ejercicio tercero", newPathtriceps3);
                        ejerciciotriceps.put("triceps/ ejercicio cuarto", newPathtriceps4);
                        mRootReference.child("Users").child(id).updateChildren(ejerciciotriceps);


                        //biceps
                        ArrayList<String> listabiceps = new ArrayList<>();
                        listabiceps.add("Curl martillo con barra romana");
                        listabiceps.add("Curl de biceps a 90° con barra");
                        listabiceps.add("Curl predicador con barra z");


                        StringBuilder stringBuilderbiceps = new StringBuilder();
                        Random randombiceps = new Random();
                        int ibiceps = randombiceps.nextInt(listabiceps.size());
                        stringBuilderbiceps.append(listabiceps.get(ibiceps));
                        String newPathbiceps = stringBuilderbiceps.toString();

                        ArrayList<String> listabiceps2 = new ArrayList<>();
                        listabiceps2.add("Curl concentrado a 1 brazo recargado en muslo");
                        listabiceps2.add("Curl de biceps acostado en banco inclinado");
                        listabiceps2.add("Curl de biceps con barra z");
                        listabiceps2.add("Curl martillo con mancuernas");

                        StringBuilder stringBuilderbiceps2 = new StringBuilder();
                        Random randombiceps2 = new Random();
                        int ibiceps2 = randombiceps2.nextInt(listabiceps2.size());
                        stringBuilderbiceps2.append(listabiceps2.get(ibiceps2));
                        String newPathbiceps2 = stringBuilderbiceps2.toString();

                        ArrayList<String> listabiceps3 = new ArrayList<>();
                        listabiceps3.add("Curl de biceps alternado");
                        listabiceps3.add("Curl spider con barra");
                        listabiceps3.add("Curl de bíceps en predicador con mancuernas");
                        listabiceps3.add("Curl martillo con cuerda");


                        StringBuilder stringBuilderbiceps3 = new StringBuilder();
                        Random randombiceps3 = new Random();
                        int ibiceps3 = randombiceps3.nextInt(listabiceps3.size());
                        stringBuilderbiceps3.append(listabiceps3.get(ibiceps3));
                        String newPathbiceps3 = stringBuilderbiceps3.toString();


                        ArrayList<String> listabiceps4 = new ArrayList<>();
                        listabiceps4.add("Curl de biceps con polea maneral recto");
                        listabiceps4.add("Curl de biceps en máquina");
                        listabiceps4.add("Curl de biceps con polea altura media a 1 brazo");
                        listabiceps4.add("Curl spider con mancuernas");

                        StringBuilder stringBuilderbiceps4 = new StringBuilder();
                        Random randombiceps4 = new Random();
                        int ibiceps4 = randombiceps4.nextInt(listabiceps4.size());
                        stringBuilderbiceps4.append(listabiceps3.get(ibiceps4));
                        String newPathbiceps4 = stringBuilderbiceps4.toString();


                        Map<String, Object> ejerciciobiceps = new HashMap<>();
                        ejerciciobiceps.put("biceps/ ejercicio primario", newPathbiceps);
                        ejerciciobiceps.put("biceps/ ejercicio secundario", newPathbiceps2);
                        ejerciciobiceps.put("biceps/ ejercicio tercero", newPathbiceps3);
                        ejerciciobiceps.put("biceps/ ejercicio cuarto", newPathbiceps4);
                        mRootReference.child("Users").child(id).updateChildren(ejerciciobiceps);




                        //pantorrillas
                        ArrayList<String> listapantorrillas = new ArrayList<>();
                        listapantorrillas.add("Elevación de talón parado en máquina");
                        listapantorrillas.add("Elevación de talón en prensa 45°");
                        listapantorrillas.add("Elevación de talón en prensa a 1 pierna");



                        StringBuilder stringBuilderpantorrillas = new StringBuilder();
                        Random randompantorrillas = new Random();
                        int ipantorrillas = randompantorrillas.nextInt(listapantorrillas.size());
                        stringBuilderpantorrillas.append(listapantorrillas.get(ipantorrillas));
                        String newPathpantorrillas = stringBuilderpantorrillas.toString();

                        ArrayList<String> listapantorrillas2 = new ArrayList<>();
                        listapantorrillas2.add("ELevación de talón parado con mancuernas");
                        listapantorrillas2.add("Elevaciones de talón en costurera");



                        StringBuilder stringBuilderpantorrillas2 = new StringBuilder();
                        Random randompantorrillas2 = new Random();
                        int ipantorrillas2 = randompantorrillas2.nextInt(listapantorrillas2.size());
                        stringBuilderpantorrillas2.append(listapantorrillas2.get(ipantorrillas2));
                        String newPathpantorrillas2 = stringBuilderpantorrillas2.toString();

                        ArrayList<String> listapantorrillas3 = new ArrayList<>();
                        listapantorrillas3.add("Elevaciones de talón en costurera");
                        listapantorrillas3.add("Elevación de talón en prensa horizontal");




                        StringBuilder stringBuilderpantorrillas3 = new StringBuilder();
                        Random randompantorrillas3 = new Random();
                        int ipantorrillas3 = randompantorrillas3.nextInt(listapantorrillas3.size());
                        stringBuilderpantorrillas3.append(listapantorrillas3.get(ipantorrillas3));
                        String newPathpantorrillas3 = stringBuilderpantorrillas3.toString();



                        Map<String, Object> ejerciciopantorrillas = new HashMap<>();
                        ejerciciopantorrillas.put("pantorrillas/ ejercicio primario", newPathpantorrillas);
                        ejerciciopantorrillas.put("pantorrillas/ ejercicio secundario", newPathpantorrillas2);
                        ejerciciopantorrillas.put("pantorrillas/ ejercicio tercero", newPathpantorrillas3);

                        mRootReference.child("Users").child(id).updateChildren(ejerciciopantorrillas);



                        //gluteos y aductores
                        ArrayList<String> listagluteos = new ArrayList<>();
                        listagluteos.add("Peso muerto tipo sumo con mancuerna");
                        listagluteos.add("Puente con mancuerna");
                        listagluteos.add("Patada para glúteos con máquina de pie");
                        listagluteos.add("Sentadilla smith tipo sumo");
                        listagluteos.add("Patada para glúteos en máquina");

                        StringBuilder stringBuildergluteos = new StringBuilder();
                        Random randomgluteos = new Random();
                        int igluteos = randomgluteos.nextInt(listagluteos.size());
                        stringBuildergluteos.append(listagluteos.get(igluteos));
                        String newPathgluteos = stringBuildergluteos.toString();

                        ArrayList<String> listagluteos2 = new ArrayList<>();
                        listagluteos2.add("Aducciones de cadera en polea");
                        listagluteos2.add("Aducciones de cadera en máquina");
                        listagluteos2.add("Goblet squat");



                        StringBuilder stringBuildergluteos2 = new StringBuilder();
                        Random randomgluteos2 = new Random();
                        int igluteos2 = randomgluteos2.nextInt(listagluteos2.size());
                        stringBuildergluteos2.append(listagluteos2.get(igluteos2));
                        String newPathgluteos2 = stringBuildergluteos2.toString();

                        ArrayList<String> listagluteos3 = new ArrayList<>();
                        listagluteos3.add("Abducciones de cadera en polea");
                        listagluteos3.add("Abducciones de cadera en máquina");
                        listagluteos3.add("Patada para glúteo con polea");
                        listagluteos3.add("Puente a 1 pierna");
                        listagluteos3.add("Patada para glúteo con mancuerna");



                        StringBuilder stringBuildergluteo3 = new StringBuilder();
                        Random randomgluteos3 = new Random();
                        int igluteos3 = randomgluteos3.nextInt(listagluteos3.size());
                        stringBuildergluteo3.append(listagluteos3.get(igluteos3));
                        String newPathgluteos3 = stringBuildergluteo3.toString();


                        //por si se ocupara para mujer
                        ArrayList<String> listagluteos4 = new ArrayList<>();
                        listagluteos4.add("Abducciones de cadera en polea");
                        listagluteos4.add("Abducciones de cadera en máquina");
                        listagluteos4.add("Patada para glúteo con polea");
                        listagluteos4.add("Patada para glúteos en máquina");
                        listagluteos4.add("Puente a 1 pierna");
                        listagluteos4.add("Puente con mancuerna");
                        listagluteos4.add("Patada para glúteo con mancuerna");
                        listagluteos4.add("Aducciones de cadera en polea");
                        listagluteos4.add("Aducciones de cadera en máquina");
                        listagluteos4.add("Peso muerto tipo sumo con mancuerna");
                        listagluteos4.add("Goblet squat");
                        listagluteos4.add("Patada para glúteos con máquina de pie");


                        StringBuilder stringBuildergluteo4 = new StringBuilder();
                        Random randomgluteos4 = new Random();
                        int igluteos4 = randomgluteos4.nextInt(listagluteos4.size());
                        stringBuildergluteo4.append(listagluteos4.get(igluteos4));
                        String newPathgluteos4 = stringBuildergluteo4.toString();

                        Map<String, Object> ejerciciogluteos = new HashMap<>();
                        ejerciciogluteos.put("gluteos y aductores/ ejercicio primario", newPathgluteos);
                        ejerciciogluteos.put("gluteos y aductores/ ejercicio secundario", newPathgluteos2);
                        ejerciciogluteos.put("gluteos y aductores/ ejercicio tercero", newPathgluteos3);
                        ejerciciogluteos.put("gluteos y aductores/ ejercicio cuarto", newPathgluteos4);

                        mRootReference.child("Users").child(id).updateChildren(ejerciciogluteos);





                        //isquios .. femorales
                        ArrayList<String> listaisquios = new ArrayList<>();
                        listaisquios.add("Peso muerto con piernas rigidas con barra");
                        listaisquios.add("Peso muerto con mancuernas");
                        listaisquios.add("Peso muerto en smith");


                        StringBuilder stringBuilderisquios = new StringBuilder();
                        Random randomisquios = new Random();
                        int iisquios = randomisquios.nextInt(listaisquios.size());
                        stringBuilderisquios.append(listaisquios.get(iisquios));
                        String newPathisquios = stringBuilderisquios.toString();

                        ArrayList<String> listaisquios2 = new ArrayList<>();
                        listaisquios2.add("Peso muerto a 1 pierna");
                        listaisquios2.add("Curl femoral acostado en máquina");
                        listaisquios2.add("Curl femoral acostado en máquina a 1 pierna");



                        StringBuilder stringBuilderisquios2 = new StringBuilder();
                        Random randomisquios2 = new Random();
                        int iisquios2 = randomisquios2.nextInt(listaisquios2.size());
                        stringBuilderisquios2.append(listaisquios2.get(iisquios2));
                        String newPathisquios2 = stringBuilderisquios2.toString();

                        ArrayList<String> listaisquios3 = new ArrayList<>();
                        listaisquios3.add("Curl femoral sentado en máquina");
                        listaisquios3.add("Curl femoral parado a 1 pierna en máquina");;
                        listaisquios3.add("Curl acostado con mancuerna");


                        StringBuilder stringBuilderisquios3 = new StringBuilder();
                        Random randomisquios3 = new Random();
                        int iisquios3 = randomisquios3.nextInt(listaisquios3.size());
                        stringBuilderisquios3.append(listaisquios3.get(iisquios3));
                        String newPathisquios3 = stringBuilderisquios3.toString();

                        ArrayList<String> listaisquios4 = new ArrayList<>();
                        listaisquios4.add("Elevación de cadera a una pierna");
                        listaisquios4.add("Curl femoral parado a 1 pierna en máquina");;
                        listaisquios4.add("Curl acostado con mancuerna");
                        listaisquios4.add("Peso muerto a 1 pierna");



                        StringBuilder stringBuilderisquios4 = new StringBuilder();
                        Random randomisquios4 = new Random();
                        int iisquios4 = randomisquios4.nextInt(listaisquios4.size());
                        stringBuilderisquios4.append(listaisquios4.get(iisquios4));
                        String newPathisquios4 = stringBuilderisquios4.toString();


                        Map<String, Object> ejercicioisquios = new HashMap<>();
                        ejercicioisquios.put("isquios/ ejercicio primario", newPathisquios);
                        ejercicioisquios.put("isquios/ ejercicio secundario", newPathisquios2);
                        ejercicioisquios.put("isquios/ ejercicio tercero", newPathisquios3);
                        ejercicioisquios.put("isquios/ ejercicio cuarto", newPathisquios4);

                        mRootReference.child("Users").child(id).updateChildren(ejercicioisquios);




                        //Espalda
                        ArrayList<String> listaespalda = new ArrayList<>();

                        listaespalda.add("Remo horizontal con barra");
                        listaespalda.add("Remo horizontal con smith");
                        listaespalda.add("Dominadas");


                        StringBuilder stringBuilderespalda = new StringBuilder();
                        Random randomespalda = new Random();
                        int iespalda = randomespalda.nextInt(listaespalda.size());
                        stringBuilderespalda.append(listaespalda.get(iespalda));
                        String newPathespalda = stringBuilderespalda.toString();

                        ArrayList<String> listaespalda2 = new ArrayList<>();
                        listaespalda2.add("Remo con mancuerna a 1 brazo");
                        listaespalda2.add("Pullover con mancuerna");
                        listaespalda2.add("Remo en máquina agarre en pronación");
                        listaespalda2.add("Remo en máquina hammer");


                        StringBuilder stringBuilderespalda2 = new StringBuilder();
                        Random randomespalda2 = new Random();
                        int iespalda2 = randomespalda2.nextInt(listaespalda2.size());
                        stringBuilderespalda2.append(listaespalda2.get(iespalda2));
                        String newPathespalda2 = stringBuilderespalda2.toString();

                        ArrayList<String> listaespalda3 = new ArrayList<>();
                        listaespalda3.add("Jalon frontal con agarre cerrado");
                        listaespalda3.add("Pullover con cuerda");
                        listaespalda3.add("Jalon frontal con triangulo");
                        listaespalda3.add("Jalón frontal con agarre abierto");


                        StringBuilder stringBuilderespalda3 = new StringBuilder();
                        Random randomespalda3 = new Random();
                        int iespalda3 = randomespalda3.nextInt(listaespalda3.size());
                        stringBuilderespalda3.append(listaespalda3.get(iespalda3));
                        String newPathespalda3 = stringBuilderespalda3.toString();

                        ArrayList<String> listaespalda4 = new ArrayList<>();
                        listaespalda4.add("Hiperextensiones de espalda baja");
                        listaespalda4.add("Remo a 1 mano con polea baja");
                        listaespalda4.add("Remo sentado en polea con triangulo");


                        StringBuilder stringBuilderespalda4 = new StringBuilder();
                        Random randomespalda4 = new Random();
                        int iespalda4 = randomespalda4.nextInt(listaespalda4.size());
                        stringBuilderespalda4.append(listaespalda4.get(iespalda4));
                        String newPathespalda4 = stringBuilderespalda4.toString();




                        Map<String, Object> ejercicioespalda = new HashMap<>();
                        ejercicioespalda.put("espalda/ ejercicio primario", newPathespalda);
                        ejercicioespalda.put("espalda/ ejercicio secundario", newPathespalda2);
                        ejercicioespalda.put("espalda/ ejercicio tercero", newPathespalda3);
                        ejercicioespalda.put("espalda/ ejercicio cuarto", newPathespalda4);

                        mRootReference.child("Users").child(id).updateChildren(ejercicioespalda);



                    //Cuadriceps
                        ArrayList<String> listacuadriceps = new ArrayList<>();

                        listacuadriceps.add("Sentadilla smith profunda");
                        listacuadriceps.add("Sentadilla con barra");
                        listacuadriceps.add("Sentadilla frontal en smith");



                        StringBuilder stringBuildercuadriceps = new StringBuilder();
                        Random randomcuadriceps = new Random();
                        int icuadriceps = randomcuadriceps.nextInt(listacuadriceps.size());
                        stringBuildercuadriceps.append(listacuadriceps.get(icuadriceps));
                        String newPathcuadriceps = stringBuildercuadriceps.toString();

                        ArrayList<String> listacuadriceps2 = new ArrayList<>();

                        listacuadriceps2.add("Sentadilla smith a 90°");
                        listacuadriceps2.add("Sentadilla bulgara con mancuernas");
                        listacuadriceps2.add("Prensa a 45°");



                        StringBuilder stringBuildercuadriceps2 = new StringBuilder();
                        Random randomcuadriceps2 = new Random();
                        int icuadriceps2 = randomcuadriceps2.nextInt(listacuadriceps2.size());
                        stringBuildercuadriceps2.append(listacuadriceps2.get(icuadriceps2));
                        String newPathcuadriceps2 = stringBuildercuadriceps2.toString();

                        ArrayList<String> listacuadriceps3 = new ArrayList<>();
                        listacuadriceps3.add("Prensa a 1 pierna");
                        listacuadriceps3.add("Prensa horizontal en máquina");
                        listacuadriceps3.add("Sentadilla en máquina perfecta");



                        StringBuilder stringBuildercuadriceps3 = new StringBuilder();
                        Random randomcuadriceps3 = new Random();
                        int icuadriceps3 = randomcuadriceps3.nextInt(listacuadriceps3.size());
                        stringBuildercuadriceps3.append(listacuadriceps3.get(icuadriceps3));
                        String newPathcuadriceps3 = stringBuildercuadriceps3.toString();

                        ArrayList<String> listacuadriceps4 = new ArrayList<>();
                        listacuadriceps4.add("Extensiones de cuadriceps en máquina");
                        listacuadriceps4.add("Sentadilla");
                        listacuadriceps4.add("Desplantes con mancuernas");
                        listacuadriceps4.add("Sentadilla frontal con mancuernas");



                        StringBuilder stringBuildercuadriceps4 = new StringBuilder();
                        Random randomcuadriceps4 = new Random();
                        int icuadriceps4 = randomcuadriceps4.nextInt(listacuadriceps4.size());
                        stringBuildercuadriceps4.append(listacuadriceps4.get(icuadriceps4));
                        String newPathcuadriceps4 = stringBuildercuadriceps4.toString();


                        Map<String, Object> ejerciciocuadriceps = new HashMap<>();
                        ejerciciocuadriceps.put("cuadriceps/ ejercicio primario", newPathcuadriceps);
                        ejerciciocuadriceps.put("cuadriceps/ ejercicio secundario", newPathcuadriceps2);
                        ejerciciocuadriceps.put("cuadriceps/ ejercicio tercero", newPathcuadriceps3);
                        ejerciciocuadriceps.put("cuadriceps/ ejercicio cuarto", newPathcuadriceps4);

                        mRootReference.child("Users").child(id).updateChildren(ejerciciocuadriceps);



                        //Calentamiento
                        ArrayList<String> listacalentamiento = new ArrayList<>();
                        listacalentamiento.add("Bird dogs");
                        listacalentamiento.add("Dead bugs");
                        listacalentamiento.add("Db Cuban press");
                        listacalentamiento.add("Rotación externa de hombro con mancuernas pegado al cuerpo");
                        listacalentamiento.add("Rotación externa de hombro con cable pegado al cuerpo");
                        listacalentamiento.add("Aducciones de hombro");
                        listacalentamiento.add("Rotación de hombros con brazos extendidos");
                        listacalentamiento.add("Rotación de hombro");
                        listacalentamiento.add("Rotación de muñecas");

                        StringBuilder stringBuildercalentamiento = new StringBuilder();
                        Random randomcalentamiento = new Random();
                        int icalentamiento = randomcalentamiento.nextInt(listacalentamiento.size());
                        stringBuildercalentamiento.append(listacalentamiento.get(icalentamiento));
                        String newPathcalentamiento = stringBuildercalentamiento.toString();

                        ArrayList<String> listacalentamiento2 = new ArrayList<>();
                        listacalentamiento2.add("Goblet squat");
                        listacalentamiento2.add("Tall Kneeling Glute Activation");
                        listacalentamiento2.add("Mountain climber stretch dynamic");
                        listacalentamiento2.add("Balanceo de pierna");
                        listacalentamiento2.add("Desplantes sin peso");
                        listacalentamiento2.add("Gatos-Camello");
                        listacalentamiento2.add("Rotación de tobillos");
                        listacalentamiento2.add("Elevación de piernas acostado");
                        listacalentamiento2.add("Puentes acostado");

                        StringBuilder stringBuildercalentamiento2 = new StringBuilder();
                        Random randomcalentamiento2 = new Random();
                        int icalentamiento2 = randomcalentamiento2.nextInt(listacalentamiento2.size());
                        stringBuildercalentamiento2.append(listacalentamiento2.get(icalentamiento2));
                        String newPathcalentamiento2 = stringBuildercalentamiento2.toString();

                        ArrayList<String> listacalentamiento3 = new ArrayList<>();
                        listacalentamiento3.add("Bird dogs");
                        listacalentamiento3.add("Dead bugs");
                        listacalentamiento3.add("Db Cuban press");
                        listacalentamiento3.add("Rotación externa de hombro con mancuernas pegado al cuerpo");
                        listacalentamiento3.add("Rotación externa de hombro con cable pegado al cuerpo");
                        listacalentamiento3.add("Aducciones de hombro");
                        listacalentamiento3.add("Rotación de hombros con brazos extendidos");
                        listacalentamiento3.add("Rotación de hombro");
                        listacalentamiento3.add("Rotación de muñecas");

                        StringBuilder stringBuildercalentamiento3 = new StringBuilder();
                        Random randomcalentamiento3 = new Random();
                        int icalentamiento3 = randomcalentamiento3.nextInt(listacalentamiento3.size());
                        stringBuildercalentamiento3.append(listacalentamiento3.get(icalentamiento3));
                        String newPathcalentamiento3 = stringBuildercalentamiento3.toString();

                        ArrayList<String> listacalentamiento4 = new ArrayList<>();
                        listacalentamiento4.add("Goblet squat");
                        listacalentamiento4.add("Tall Kneeling Glute Activation");
                        listacalentamiento4.add("Mountain climber stretch dynamic");
                        listacalentamiento4.add("Balanceo de pierna");
                        listacalentamiento4.add("Desplantes sin peso");
                        listacalentamiento4.add("Gatos-Camello");
                        listacalentamiento4.add("Rotación de tobillos");
                        listacalentamiento4.add("Elevación de piernas acostado");
                        listacalentamiento4.add("Puentes acostado");

                        StringBuilder stringBuildercalentamiento4 = new StringBuilder();
                        Random randomcalentamiento4 = new Random();
                        int icalentamiento4 = randomcalentamiento4.nextInt(listacalentamiento4.size());
                        stringBuildercalentamiento4.append(listacalentamiento4.get(icalentamiento4));
                        String newPathcalentamiento4 = stringBuildercalentamiento4.toString();


                        Map<String, Object> ejerciciocalentamiento = new HashMap<>();
                        ejerciciocalentamiento.put("calentamiento/ ejercicio primario", newPathcalentamiento);
                        ejerciciocalentamiento.put("calentamiento/ ejercicio secundario", newPathcalentamiento2);
                        ejerciciocalentamiento.put("calentamiento/ ejercicio tercero", newPathcalentamiento3);
                        ejerciciocalentamiento.put("calentamiento/ ejercicio cuarto", newPathcalentamiento4);

                        mRootReference.child("Users").child(id).updateChildren(ejerciciocalentamiento);



                      //---------------- PESO


                        String pesoinicial = "Peso";

                        Map<String, Object> pesoejercicios = new HashMap<>();
                        pesoejercicios.put("Historial pectoral/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial pectoral/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial pectoral/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 5 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 5 dias/ cuarto ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial pectoral/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 6 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 6 dias/ cuarto ejercicio/ dia 2", pesoinicial);

                        pesoejercicios.put("Historial espalda/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial espalda/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial espalda/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 5 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 5 dias/ cuarto ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial espalda/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 6 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 6 dias/ cuarto ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial biceps/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial biceps/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial biceps/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 5 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 5 dias/ cuarto ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial biceps/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 6 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 6 dias/ cuarto ejercicio/ dia 2", pesoinicial);


                        pesoejercicios.put("Historial triceps/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial triceps/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial triceps/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 5 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 5 dias/ cuarto ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial triceps/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 6 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 6 dias/ cuarto ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial frontal/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial frontal/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial frontal/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial frontal/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial frontal/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial frontal/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial frontal/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);





                        pesoejercicios.put("Historial cuadriceps/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 3 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 3 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 3 dias/ segundo ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ cuarto ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ cuarto ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ tercer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ cuarto ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ cuarto ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ tercer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ cuarto ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial isquios/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial isquios/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 4 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 4 dias/ cuarto ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial isquios/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ cuarto ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ tercer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ cuarto ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial isquios/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ cuarto ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ tercer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ cuarto ejercicio/ dia 3", pesoinicial);




                        pesoejercicios.put("Historial gluteos y aductores/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ cuarto ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ cuarto ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ cuarto ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ cuarto ejercicio/ dia 2", pesoinicial);

                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ tercer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ cuarto ejercicio/ dia 3", pesoinicial);




                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ cuarto ejercicio/ dia 1", pesoinicial);


                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ cuarto ejercicio/ dia 2", pesoinicial);


                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ tercer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ cuarto ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial pantorrillas/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial pantorrillas/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);

                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ tercer ejercicio/ dia 3", pesoinicial);




                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);

                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ tercer ejercicio/ dia 3", pesoinicial);


                        pesoejercicios.put("Historial trapecios/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial trapecios/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial trapecios/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial trapecios/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial trapecios/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial trapecios/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial abdomen/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial abdomen/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial abdomen/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial abdomen/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);

                        pesoejercicios.put("Historial abdomen/ 5 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 5 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 5 dias/ tercer ejercicio/ dia 3", pesoinicial);




                        pesoejercicios.put("Historial abdomen/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial abdomen/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);

                        pesoejercicios.put("Historial abdomen/ 6 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 6 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 6 dias/ tercer ejercicio/ dia 3", pesoinicial);





                        pesoejercicios.put("diasentrenados", "0");

                        pesoejercicios.put("diaactual1", "false");
                        pesoejercicios.put("diaactual2", "false");
                        pesoejercicios.put("diaactual3", "false");
                        pesoejercicios.put("diaactual4", "false");
                        pesoejercicios.put("diaactual5", "false");
                        pesoejercicios.put("diaactual6", "false");

                        pesoejercicios.put("progresosrer", "0");


                        mRootReference.child("Users").child(id).updateChildren(pesoejercicios);








                    } else {

                        //pecho
                        ArrayList<String> listapectoral = new ArrayList<>();
                        listapectoral.add("Press inclinado con barra");
                        listapectoral.add("Press inclinado en smith");
                        listapectoral.add("Press horizontal con barra");
                        listapectoral.add("Press plano en smith");

                        StringBuilder stringBuilder = new StringBuilder();
                        Random random = new Random();
                        int opcion2 = random.nextInt(listapectoral.size());
                        stringBuilder.append(listapectoral.get(opcion2));
                        String opciondos = stringBuilder.toString();


                        //ejercicio secundario
                        ArrayList<String> listapectoral2 = new ArrayList<>();
                        listapectoral2.add("Aperturas con mancuernas en banco plano");
                        listapectoral2.add("Aperturas con mancuernas en banco inclinado");
                        listapectoral2.add("Aperturas en peck deck");
                        listapectoral2.add("Fondos");


                        StringBuilder stringBuilder2 = new StringBuilder();
                        Random random2 = new Random();
                        int i2 = random2.nextInt(listapectoral2.size());
                        stringBuilder2.append(listapectoral2.get(i2));
                        String newPath2 = stringBuilder2.toString();

                        //ejercicio terciairio
                        ArrayList<String> listapectoral3 = new ArrayList<>();
                        listapectoral3.add("Press con mancuernas en banco inclinado");
                        listapectoral3.add("Press de pectorales en máquina hammer");
                        listapectoral3.add("Press con mancuernas en banco plano");
                        listapectoral3.add("Lagartijas");
                        listapectoral3.add("Press de pectorales en maquina");
                        listapectoral3.add("Press declinado con mancuernas");


                        StringBuilder stringBuilder3 = new StringBuilder();
                        Random random3 = new Random();
                        int i3 = random3.nextInt(listapectoral3.size());
                        stringBuilder3.append(listapectoral3.get(i3));
                        String newPath3 = stringBuilder3.toString();

                        //ejercicio cuarto
                        ArrayList<String> listapectoral4 = new ArrayList<>();
                        listapectoral4.add("Aperturas en crossover (polea a nivel medio)");
                        listapectoral4.add("Aperturas en crossover (polea a nivel bajo)");
                        listapectoral4.add("Aperturas en crossover (polea a nivel alto)");
                        listapectoral4.add("Fondos");


                        StringBuilder stringBuilder4 = new StringBuilder();
                        Random random4 = new Random();
                        int i4 = random4.nextInt(listapectoral4.size());
                        stringBuilder4.append(listapectoral4.get(i4));
                        String newPath4 = stringBuilder4.toString();



                        Map<String, Object> ejercicio = new HashMap<>();
                        ejercicio.put("pectoral/ ejercicio primario", opciondos);
                        ejercicio.put("pectoral/ ejercicio secundario", newPath2);
                        ejercicio.put("pectoral/ ejercicio tercero", newPath3);
                        ejercicio.put("pectoral/ ejercicio cuarto", newPath4);
                        mRootReference.child("Users").child(id).updateChildren(ejercicio);




                        //abs
                        ArrayList<String> listaabs = new ArrayList<>();
                        listaabs.add("Crunch abdominal en maquina");
                        listaabs.add("Crunch abdominal en maquina con cuerda");
                        listaabs.add("Rodillo abdominal");
                        listaabs.add("Crunch abdominal hincado con cuerda");
                        listaabs.add("Crunch tipo bicicleta");
                        listaabs.add("Crunch abdominal en banco declinado con balon en la nuca");

                        StringBuilder stringBuilderabs = new StringBuilder();
                        Random randomabs = new Random();
                        int iabs = randomabs.nextInt(listaabs.size());
                        stringBuilderabs.append(listaabs.get(iabs));
                        String newPathabs = stringBuilderabs.toString();

                        ArrayList<String> listaabs2 = new ArrayList<>();
                        listaabs2.add("Elevaciones de piernas acostado en banco");
                        listaabs2.add("Elevaciones de piernas en silla romana");
                        listaabs2.add("Crunch lateral con polea alta");
                        listaabs2.add("Crunch abdominal en banco declinado");

                        StringBuilder stringBuilderabs2 = new StringBuilder();
                        Random randomabs2 = new Random();
                        int iabs2 = randomabs2.nextInt(listaabs2.size());
                        stringBuilderabs2.append(listaabs2.get(iabs2));
                        String newPathabs2 = stringBuilderabs2.toString();

                        ArrayList<String> listaabs3 = new ArrayList<>();
                        listaabs3.add("Crunch abdominal");
                        listaabs3.add("Toques al talón");
                        listaabs3.add("Crunch acostado en flexión de piernas");
                        listaabs3.add("Crunch lateral");

                        StringBuilder stringBuilderabs3 = new StringBuilder();
                        Random randomabs3 = new Random();
                        int iabs3 = randomabs3.nextInt(listaabs3.size());
                        stringBuilderabs3.append(listaabs3.get(iabs3));
                        String newPathabs3 = stringBuilderabs3.toString();


                        Map<String, Object> ejercicioabs = new HashMap<>();
                        ejercicioabs.put("abdominales/ ejercicio primario", newPathabs);
                        ejercicioabs.put("abdominales/ ejercicio secundario", newPathabs2);
                        ejercicioabs.put("abdominales/ ejercicio tercero", newPathabs3);
                        mRootReference.child("Users").child(id).updateChildren(ejercicioabs);




                        //elevaciones laterales y posteriores
                        ArrayList<String> listalaterales = new ArrayList<>();
                        listalaterales.add("Remo al mentón con barra");
                        listalaterales.add("Elevaciones laterales con mancuernas");
                        listalaterales.add("Elevación lateral con mancuernas acostado en banco inclinado de perfil");
                        listalaterales.add("Remo al mentón con mancuernas");

                        StringBuilder stringBuilderlaterales = new StringBuilder();
                        Random randomlaterales = new Random();
                        int ilaterales = randomlaterales.nextInt(listalaterales.size());
                        stringBuilderlaterales.append(listalaterales.get(ilaterales));
                        String newPathlaterales = stringBuilderlaterales.toString();

                        ArrayList<String> listalaterales2 = new ArrayList<>();
                        listalaterales2.add("Elevación lateral con polea baja por detrás");
                        listalaterales2.add("Flys invertidos en peck deck");
                        listalaterales2.add("Flys agachado con mancuernas");
                        listalaterales2.add("Elevación lateral con mancuerna a 45°");

                        StringBuilder stringBuilderlaterales2 = new StringBuilder();
                        Random randomlaterales2 = new Random();
                        int ilaterales2 = randomlaterales2.nextInt(listalaterales2.size());
                        stringBuilderlaterales2.append(listalaterales2.get(ilaterales2));
                        String newPathlaterales2 = stringBuilderlaterales2.toString();

                        ArrayList<String> listalaterales3 = new ArrayList<>();
                        listalaterales3.add("Elevación lateral con polea baja");
                        listalaterales3.add("Remo al mentón con polea baja");
                        listalaterales3.add("Facepull con cuerda");
                        listalaterales3.add("Flys cruzados con poleas");


                        StringBuilder stringBuilderlaterales3 = new StringBuilder();
                        Random randomlaterales3 = new Random();
                        int ilaterales3 = randomlaterales3.nextInt(listalaterales3.size());
                        stringBuilderlaterales3.append(listalaterales3.get(ilaterales3));
                        String newPathlaterales3 = stringBuilderlaterales3.toString();



                        Map<String, Object> ejerciciolaterales = new HashMap<>();
                        ejerciciolaterales.put("deltoides laterales y posteriores/ ejercicio primario", newPathlaterales);
                        ejerciciolaterales.put("deltoides laterales y posteriores/ ejercicio secundario", newPathlaterales2);
                        ejerciciolaterales.put("deltoides laterales y posteriores/ ejercicio tercero", newPathlaterales3);
                        mRootReference.child("Users").child(id).updateChildren(ejerciciolaterales);


                        //trapecios
                        ArrayList<String> listatraps = new ArrayList<>();
                        listatraps.add("Encogimiento de hombros con mancuernas");
                        listatraps.add("Encogimiento de hombros en smith por delante");
                        listatraps.add("Encogimiento de hombros con barra por delante");

                        StringBuilder stringBuildertraps = new StringBuilder();
                        Random randomtraps = new Random();
                        int itraps = randomtraps.nextInt(listatraps.size());
                        stringBuildertraps.append(listatraps.get(itraps));
                        String newPathtraps = stringBuildertraps.toString();

                        ArrayList<String> listatraps2 = new ArrayList<>();
                        listatraps2.add("Paseo del granjero");
                        listatraps2.add("Encogimiento de hombros con barra por detrás");
                        listatraps2.add("Encogimiento de hombros con smith por detrás");


                        StringBuilder stringBuildertraps2 = new StringBuilder();
                        Random randomtraps2 = new Random();
                        int itraps2 = randomtraps2.nextInt(listatraps2.size());
                        stringBuildertraps2.append(listatraps2.get(itraps2));
                        String newPathtraps2 = stringBuildertraps2.toString();

                        ArrayList<String> listatraps3 = new ArrayList<>();
                        listatraps3.add("Encogimiento de hombros en smith por delante");
                        listatraps3.add("Encogimiento de hombros con barra por delante");
                        listatraps3.add("Encogimiento de hombros con barra por detrás");
                        listatraps3.add("Encogimiento de hombros con smith por detrás");


                        StringBuilder stringBuildertraps3 = new StringBuilder();
                        Random randomtraps3 = new Random();
                        int itraps3 = randomtraps3.nextInt(listatraps3.size());
                        stringBuildertraps3.append(listatraps3.get(itraps3));
                        String newPathtraps3 = stringBuildertraps3.toString();



                        Map<String, Object> ejerciciotraps2 = new HashMap<>();
                        ejerciciotraps2.put("trapecios/ ejercicio primario", newPathtraps);
                        ejerciciotraps2.put("trapecios/ ejercicio secundario", newPathtraps2);
                        ejerciciotraps2.put("trapecios/ ejercicio tercero", newPathtraps3);
                        mRootReference.child("Users").child(id).updateChildren(ejerciciotraps2);


                        //deltoide frontal
                        ArrayList<String> listafrontales = new ArrayList<>();
                        listafrontales.add("Press militar con barra");
                        listafrontales.add("Press militar con mancuernas");
                        listafrontales.add("Push press");
                        listafrontales.add("Press militar en smith");
                        listafrontales.add("Press en máquina agarre prono");

                        StringBuilder stringBuilderfrontales = new StringBuilder();
                        Random randomfrontales = new Random();
                        int ifrontales = randomfrontales.nextInt(listafrontales.size());
                        stringBuilderfrontales.append(listafrontales.get(ifrontales));
                        String newPathfrontales = stringBuilderfrontales.toString();

                        ArrayList<String> listafrontales2 = new ArrayList<>();
                        listafrontales2.add("Press en máquina agarre neutro");
                        listafrontales2.add("Press Arnold");
                        listafrontales2.add("Elevaciones frontales con mancuernas agarre prono");
                        listafrontales2.add("Elevaciones frontales con mancuernas agarre neutro");
                        listafrontales2.add("Elevaciones frontales con mancuerna agarre supino");


                        StringBuilder stringBuilderfrontales2 = new StringBuilder();
                        Random randomfrontales2 = new Random();
                        int ifrontales2 = randomfrontales2.nextInt(listafrontales2.size());
                        stringBuilderfrontales2.append(listafrontales2.get(ifrontales2));
                        String newPathfrontales2 = stringBuilderfrontales2.toString();

                        ArrayList<String> listafrontales3 = new ArrayList<>();
                        listafrontales3.add("Elevaciones frontales con polea baja a 1 brazo");
                        listafrontales3.add("Elevaciones frontales con disco");
                        listafrontales3.add("Elevaciones frontal con cuerda en polea baja");
                        listafrontales3.add("Elevaciones frontales con mancuernas agarre neutro");


                        StringBuilder stringBuilderfrontales3 = new StringBuilder();
                        Random randomfrontales3 = new Random();
                        int ifrontales3 = randomfrontales3.nextInt(listafrontales3.size());
                        stringBuilderfrontales3.append(listafrontales3.get(ifrontales3));
                        String newPathfrontales3 = stringBuilderfrontales3.toString();



                        Map<String, Object> ejerciciofrontales = new HashMap<>();
                        ejerciciofrontales.put("deltoide frontal/ ejercicio primario", newPathfrontales);
                        ejerciciofrontales.put("deltoide frontal/ ejercicio secundario", newPathfrontales2);
                        ejerciciofrontales.put("deltoide frontal/ ejercicio tercero", newPathfrontales3);
                        mRootReference.child("Users").child(id).updateChildren(ejerciciofrontales);




                        //triceps
                        ArrayList<String> listatriceps = new ArrayList<>();
                        listatriceps.add("Press cerrado con barra");
                        listatriceps.add("Press cerrado en smith");
                        listatriceps.add("Rompecraneos con barra z");
                        listatriceps.add("Rompecraneos con mancuernas");
                        listatriceps.add("Copa con barra");


                        StringBuilder stringBuildertriceps = new StringBuilder();
                        Random randomtriceps = new Random();
                        int itriceps = randomtriceps.nextInt(listatriceps.size());
                        stringBuildertriceps.append(listatriceps.get(itriceps));
                        String newPathtriceps = stringBuildertriceps.toString();

                        ArrayList<String> listatriceps2 = new ArrayList<>();
                        listatriceps2.add("Copa con mancuerna sentado");
                        listatriceps2.add("Copa con mancuerna a 1 brazo");
                        listatriceps2.add("Extensiones de tríceps en máquina");
                        listatriceps2.add("Fondos en máquina");


                        StringBuilder stringBuildertriceps2 = new StringBuilder();
                        Random randomtriceps2 = new Random();
                        int itriceps2 = randomtriceps2.nextInt(listatriceps2.size());
                        stringBuildertriceps2.append(listatriceps2.get(itriceps2));
                        String newPathtriceps2 = stringBuildertriceps2.toString();

                        ArrayList<String> listatriceps3 = new ArrayList<>();
                        listatriceps3.add("Extensiones de tríceps en polea alta con maneral recto");
                        listatriceps3.add("Extensiones de tríceps a 1 brazo agarre supino");
                        listatriceps3.add("Patada para tríceps a 1 brazo");


                        StringBuilder stringBuildertriceps3 = new StringBuilder();
                        Random randomtriceps3 = new Random();
                        int itriceps3 = randomtriceps3.nextInt(listatriceps3.size());
                        stringBuildertriceps3.append(listatriceps3.get(itriceps3));
                        String newPathtriceps3 = stringBuildertriceps3.toString();

                        ArrayList<String> listatriceps4 = new ArrayList<>();
                        listatriceps4.add("Extensiones de tríceps en polea alta con maneral recto");
                        listatriceps4.add("Extensiones de tríceps con cuerda");
                        listatriceps4.add("Patada para tríceps con polea");


                        StringBuilder stringBuildertriceps4 = new StringBuilder();
                        Random randomtriceps4 = new Random();
                        int itriceps4 = randomtriceps4.nextInt(listatriceps4.size());
                        stringBuildertriceps4.append(listatriceps4.get(itriceps4));
                        String newPathtriceps4 = stringBuildertriceps4.toString();


                        Map<String, Object> ejerciciotriceps = new HashMap<>();
                        ejerciciotriceps.put("triceps/ ejercicio primario", newPathtriceps);
                        ejerciciotriceps.put("triceps/ ejercicio secundario", newPathtriceps2);
                        ejerciciotriceps.put("triceps/ ejercicio tercero", newPathtriceps3);
                        ejerciciotriceps.put("triceps/ ejercicio cuarto", newPathtriceps4);
                        mRootReference.child("Users").child(id).updateChildren(ejerciciotriceps);




                        //biceps
                        ArrayList<String> listabiceps = new ArrayList<>();
                        listabiceps.add("Curl martillo con barra romana");
                        listabiceps.add("Curl de biceps a 90° con barra");
                        listabiceps.add("Curl predicador con barra z");



                        StringBuilder stringBuilderbiceps = new StringBuilder();
                        Random randombiceps = new Random();
                        int ibiceps = randombiceps.nextInt(listabiceps.size());
                        stringBuilderbiceps.append(listabiceps.get(ibiceps));
                        String newPathbiceps = stringBuilderbiceps.toString();

                        ArrayList<String> listabiceps2 = new ArrayList<>();
                        listabiceps2.add("Curl concentrado a 1 brazo recargado en muslo");
                        listabiceps2.add("Curl de biceps acostado en banco inclinado");
                        listabiceps2.add("Curl de biceps con barra z");
                        listabiceps2.add("Curl martillo con mancuernas");

                        StringBuilder stringBuilderbiceps2 = new StringBuilder();
                        Random randombiceps2 = new Random();
                        int ibiceps2 = randombiceps2.nextInt(listabiceps2.size());
                        stringBuilderbiceps2.append(listabiceps2.get(ibiceps2));
                        String newPathbiceps2 = stringBuilderbiceps2.toString();

                        ArrayList<String> listabiceps3 = new ArrayList<>();
                        listabiceps3.add("Curl de biceps alternado");
                        listabiceps3.add("Curl spider con barra");
                        listabiceps3.add("Curl de bíceps en predicador con mancuernas");
                        listabiceps3.add("Curl martillo con cuerda");


                        StringBuilder stringBuilderbiceps3 = new StringBuilder();
                        Random randombiceps3 = new Random();
                        int ibiceps3 = randombiceps3.nextInt(listabiceps3.size());
                        stringBuilderbiceps3.append(listabiceps3.get(ibiceps3));
                        String newPathbiceps3 = stringBuilderbiceps3.toString();


                        ArrayList<String> listabiceps4 = new ArrayList<>();
                        listabiceps4.add("Curl de biceps con polea maneral recto");
                        listabiceps4.add("Curl de biceps en máquina");
                        listabiceps4.add("Curl de biceps con polea altura media a 1 brazo");
                        listabiceps4.add("Curl spider con mancuernas");

                        StringBuilder stringBuilderbiceps4 = new StringBuilder();
                        Random randombiceps4 = new Random();
                        int ibiceps4 = randombiceps4.nextInt(listabiceps4.size());
                        stringBuilderbiceps4.append(listabiceps3.get(ibiceps4));
                        String newPathbiceps4 = stringBuilderbiceps4.toString();


                        Map<String, Object> ejerciciobiceps = new HashMap<>();
                        ejerciciobiceps.put("biceps/ ejercicio primario", newPathbiceps);
                        ejerciciobiceps.put("biceps/ ejercicio secundario", newPathbiceps2);
                        ejerciciobiceps.put("biceps/ ejercicio tercero", newPathbiceps3);
                        ejerciciobiceps.put("biceps/ ejercicio cuarto", newPathbiceps4);
                        mRootReference.child("Users").child(id).updateChildren(ejerciciobiceps);





                        //pantorrillas
                        ArrayList<String> listapantorrillas = new ArrayList<>();
                        listapantorrillas.add("Elevación de talón parado en máquina");
                        listapantorrillas.add("Elevación de talón en prensa 45°");
                        listapantorrillas.add("Elevaciones de talón en prensa a 1 pierna");



                        StringBuilder stringBuilderpantorrillas = new StringBuilder();
                        Random randompantorrillas = new Random();
                        int ipantorrillas = randompantorrillas.nextInt(listapantorrillas.size());
                        stringBuilderpantorrillas.append(listapantorrillas.get(ipantorrillas));
                        String newPathpantorrillas = stringBuilderpantorrillas.toString();

                        ArrayList<String> listapantorrillas2 = new ArrayList<>();
                        listapantorrillas2.add("Elevación de talón parado con mancuernas");
                        listapantorrillas2.add("Elevaciones de talón en costurera");



                        StringBuilder stringBuilderpantorrillas2 = new StringBuilder();
                        Random randompantorrillas2 = new Random();
                        int ipantorrillas2 = randompantorrillas2.nextInt(listapantorrillas2.size());
                        stringBuilderpantorrillas2.append(listapantorrillas2.get(ipantorrillas2));
                        String newPathpantorrillas2 = stringBuilderpantorrillas2.toString();

                        ArrayList<String> listapantorrillas3 = new ArrayList<>();
                        listapantorrillas3.add("Elevaciones de talón en costurera");
                        listapantorrillas3.add("Elevación de talón en prensa horizontal");




                        StringBuilder stringBuilderpantorrillas3 = new StringBuilder();
                        Random randompantorrillas3 = new Random();
                        int ipantorrillas3 = randompantorrillas3.nextInt(listapantorrillas3.size());
                        stringBuilderpantorrillas3.append(listapantorrillas3.get(ipantorrillas3));
                        String newPathpantorrillas3 = stringBuilderpantorrillas3.toString();
                        

                        Map<String, Object> ejerciciopantorrillas = new HashMap<>();
                        ejerciciopantorrillas.put("pantorrillas/ ejercicio primario", newPathpantorrillas);
                        ejerciciopantorrillas.put("pantorrillas/ ejercicio secundario", newPathpantorrillas2);
                        ejerciciopantorrillas.put("pantorrillas/ ejercicio tercero", newPathpantorrillas3);
                        mRootReference.child("Users").child(id).updateChildren(ejerciciopantorrillas);





                        //gluteos y aductores
                        ArrayList<String> listagluteos = new ArrayList<>();
                        listagluteos.add("Hip thrust con barra");
                        listagluteos.add("Peso muerto tipo sumo con barra");
                        listagluteos.add("Patada para glúteos con máquina de pie");
                        listagluteos.add("Sentadilla smith tipo sumo");


                        StringBuilder stringBuildergluteos = new StringBuilder();
                        Random randomgluteos = new Random();
                        int igluteos = randomgluteos.nextInt(listagluteos.size());
                        stringBuildergluteos.append(listagluteos.get(igluteos));
                        String newPathgluteos = stringBuildergluteos.toString();

                        ArrayList<String> listagluteos2 = new ArrayList<>();
                        listagluteos2.add("Aducciones de cadera en polea");
                        listagluteos2.add("Aducciones de cadera en máquina");
                        listagluteos2.add("Peso muerto tipo sumo con mancuerna");
                        listagluteos2.add("Goblet squat");



                        StringBuilder stringBuildergluteos2 = new StringBuilder();
                        Random randomgluteos2 = new Random();
                        int igluteos2 = randomgluteos2.nextInt(listagluteos2.size());
                        stringBuildergluteos2.append(listagluteos2.get(igluteos2));
                        String newPathgluteos2 = stringBuildergluteos2.toString();

                        ArrayList<String> listagluteos3 = new ArrayList<>();
                        listagluteos3.add("Abducciones de cadera en polea");
                        listagluteos3.add("Abducciones de cadera en máquina");
                        listagluteos3.add("Patada para glúteo con polea");
                        listagluteos3.add("Patada para glúteos en máquina");
                        listagluteos3.add("Puente a 1 pierna");
                         listagluteos3.add("Puente con mancuerna");
                        listagluteos3.add("Patada para glúteo con mancuerna");



                        StringBuilder stringBuildergluteo3 = new StringBuilder();
                        Random randomgluteos3 = new Random();
                        int igluteos3 = randomgluteos3.nextInt(listagluteos3.size());
                        stringBuildergluteo3.append(listagluteos3.get(igluteos3));
                        String newPathgluteos3 = stringBuildergluteo3.toString();


                        //por si se ocupara para mujer
                        ArrayList<String> listagluteos4 = new ArrayList<>();
                        listagluteos4.add("Abducciones de cadera en polea");
                        listagluteos4.add("Abducciones de cadera en máquina");
                        listagluteos4.add("Patada para glúteo con polea");
                        listagluteos4.add("Patada para glúteos en máquina");
                        listagluteos4.add("Puente a 1 pierna");
                        listagluteos4.add("Puente con mancuerna");
                        listagluteos4.add("Patada para glúteo con mancuerna");
                        listagluteos4.add("Aducciones de cadera en polea");
                        listagluteos4.add("Aducciones de cadera en máquina");
                        listagluteos4.add("Peso muerto tipo sumo con mancuerna");
                        listagluteos4.add("Goblet squat");
                        listagluteos4.add("Patada para glúteos con máquina de pie");


                        StringBuilder stringBuildergluteo4 = new StringBuilder();
                        Random randomgluteos4 = new Random();
                        int igluteos4 = randomgluteos4.nextInt(listagluteos4.size());
                        stringBuildergluteo4.append(listagluteos4.get(igluteos4));
                        String newPathgluteos4 = stringBuildergluteo4.toString();

                        Map<String, Object> ejerciciogluteos = new HashMap<>();
                        ejerciciogluteos.put("gluteos y aductores/ ejercicio primario", newPathgluteos);
                        ejerciciogluteos.put("gluteos y aductores/ ejercicio secundario", newPathgluteos2);
                        ejerciciogluteos.put("gluteos y aductores/ ejercicio tercero", newPathgluteos3);
                        ejerciciogluteos.put("gluteos y aductores/ ejercicio cuarto", newPathgluteos4);

                        mRootReference.child("Users").child(id).updateChildren(ejerciciogluteos);





                        //isquios .. femorales
                        ArrayList<String> listaisquios = new ArrayList<>();
                        listaisquios.add("Peso muerto con piernas rigidas con barra");
                        listaisquios.add("Peso muerto con mancuernas");
                        listaisquios.add("Peso muerto en smith");


                        StringBuilder stringBuilderisquios = new StringBuilder();
                        Random randomisquios = new Random();
                        int iisquios = randomisquios.nextInt(listaisquios.size());
                        stringBuilderisquios.append(listaisquios.get(iisquios));
                        String newPathisquios = stringBuilderisquios.toString();

                        ArrayList<String> listaisquios2 = new ArrayList<>();
                        listaisquios2.add("Peso muerto a 1 pierna");
                        listaisquios2.add("Curl femoral acostado en máquina");;
                        listaisquios2.add("Curl femoral acostado en máquina a 1 pierna");


                        StringBuilder stringBuilderisquios2 = new StringBuilder();
                        Random randomisquios2 = new Random();
                        int iisquios2 = randomisquios2.nextInt(listaisquios2.size());
                        stringBuilderisquios2.append(listaisquios2.get(iisquios2));
                        String newPathisquios2 = stringBuilderisquios2.toString();

                        ArrayList<String> listaisquios3 = new ArrayList<>();
                        listaisquios3.add("Curl femoral sentado en máquina");
                        listaisquios3.add("Curl femoral parado a 1 pierna en máquina");;
                        listaisquios3.add("Curl acostado con mancuerna");


                        StringBuilder stringBuilderisquios3 = new StringBuilder();
                        Random randomisquios3 = new Random();
                        int iisquios3 = randomisquios3.nextInt(listaisquios3.size());
                        stringBuilderisquios3.append(listaisquios3.get(iisquios3));
                        String newPathisquios3 = stringBuilderisquios3.toString();

                        ArrayList<String> listaisquios4 = new ArrayList<>();
                        listaisquios4.add("Elevación de cadera a una pierna");
                        listaisquios4.add("Curl femoral parado a 1 pierna en máquina");;
                        listaisquios4.add("Curl acostado con mancuerna");
                        listaisquios4.add("Peso muerto a 1 pierna");



                        StringBuilder stringBuilderisquios4 = new StringBuilder();
                        Random randomisquios4 = new Random();
                        int iisquios4 = randomisquios4.nextInt(listaisquios4.size());
                        stringBuilderisquios4.append(listaisquios4.get(iisquios4));
                        String newPathisquios4 = stringBuilderisquios4.toString();


                        Map<String, Object> ejercicioisquios = new HashMap<>();
                        ejercicioisquios.put("isquios/ ejercicio primario", newPathisquios);
                        ejercicioisquios.put("isquios/ ejercicio secundario", newPathisquios2);
                        ejercicioisquios.put("isquios/ ejercicio tercero", newPathisquios3);
                        ejercicioisquios.put("isquios/ ejercicio cuarto", newPathisquios4);

                        mRootReference.child("Users").child(id).updateChildren(ejercicioisquios);





                        //Espalda
                        ArrayList<String> listaespalda = new ArrayList<>();
                        listaespalda.add("Peso muerto convencional");
                        listaespalda.add("Remo pendlay");
                        listaespalda.add("Remo horizontal con barra");
                        listaespalda.add("Remo horizontal con smith");
                        listaespalda.add("Dominadas");


                        StringBuilder stringBuilderespalda = new StringBuilder();
                        Random randomespalda = new Random();
                        int iespalda = randomespalda.nextInt(listaespalda.size());
                        stringBuilderespalda.append(listaespalda.get(iespalda));
                        String newPathespalda = stringBuilderespalda.toString();

                        ArrayList<String> listaespalda2 = new ArrayList<>();
                        listaespalda2.add("Remo con mancuerna a 1 brazo");
                        listaespalda2.add("Pullover con mancuerna");
                        listaespalda2.add("Remo en máquina agarre en pronación");
                        listaespalda2.add("Remo en máquina hammer");


                        StringBuilder stringBuilderespalda2 = new StringBuilder();
                        Random randomespalda2 = new Random();
                        int iespalda2 = randomespalda2.nextInt(listaespalda2.size());
                        stringBuilderespalda2.append(listaespalda2.get(iespalda2));
                        String newPathespalda2 = stringBuilderespalda2.toString();

                        ArrayList<String> listaespalda3 = new ArrayList<>();
                        listaespalda3.add("Jalon frontal con agarre cerrado");
                        listaespalda3.add("Pullover con cuerda");
                        listaespalda3.add("Jalon frontal con triangulo");
                        listaespalda3.add("Jalón frontal con agarre abierto");


                        StringBuilder stringBuilderespalda3 = new StringBuilder();
                        Random randomespalda3 = new Random();
                        int iespalda3 = randomespalda3.nextInt(listaespalda3.size());
                        stringBuilderespalda3.append(listaespalda3.get(iespalda3));
                        String newPathespalda3 = stringBuilderespalda3.toString();

                        ArrayList<String> listaespalda4 = new ArrayList<>();
                        listaespalda4.add("Hiperextensiones de espalda baja");
                        listaespalda4.add("Remo a 1 mano con polea baja");
                        listaespalda4.add("Remo sentado en polea con triangulo");


                        StringBuilder stringBuilderespalda4 = new StringBuilder();
                        Random randomespalda4 = new Random();
                        int iespalda4 = randomespalda4.nextInt(listaespalda4.size());
                        stringBuilderespalda4.append(listaespalda4.get(iespalda4));
                        String newPathespalda4 = stringBuilderespalda4.toString();




                        Map<String, Object> ejercicioespalda = new HashMap<>();
                        ejercicioespalda.put("espalda/ ejercicio primario", newPathespalda);
                        ejercicioespalda.put("espalda/ ejercicio secundario", newPathespalda2);
                        ejercicioespalda.put("espalda/ ejercicio tercero", newPathespalda3);
                        ejercicioespalda.put("espalda/ ejercicio cuarto", newPathespalda4);

                        mRootReference.child("Users").child(id).updateChildren(ejercicioespalda);



                        //Cuadriceps
                        ArrayList<String> listacuadriceps = new ArrayList<>();
                        listacuadriceps.add("Sentadilla frontal con barra");
                        listacuadriceps.add("Sentadilla smith profunda");
                        listacuadriceps.add("Sentadilla con barra");
                        listacuadriceps.add("Sentadilla frontal en smith");



                        StringBuilder stringBuildercuadriceps = new StringBuilder();
                        Random randomcuadriceps = new Random();
                        int icuadriceps = randomcuadriceps.nextInt(listacuadriceps.size());
                        stringBuildercuadriceps.append(listacuadriceps.get(icuadriceps));
                        String newPathcuadriceps = stringBuildercuadriceps.toString();

                        ArrayList<String> listacuadriceps2 = new ArrayList<>();

                        listacuadriceps2.add("Sentadilla smith a 90°");
                        listacuadriceps2.add("Sentadilla bulgara con mancuernas");
                        listacuadriceps2.add("Prensa a 45°");



                        StringBuilder stringBuildercuadriceps2 = new StringBuilder();
                        Random randomcuadriceps2 = new Random();
                        int icuadriceps2 = randomcuadriceps2.nextInt(listacuadriceps2.size());
                        stringBuildercuadriceps2.append(listacuadriceps2.get(icuadriceps2));
                        String newPathcuadriceps2 = stringBuildercuadriceps2.toString();

                        ArrayList<String> listacuadriceps3 = new ArrayList<>();
                        listacuadriceps3.add("Prensa a 1 pierna");
                        listacuadriceps3.add("Desplantes con mancuernas");
                        listacuadriceps3.add("Prensa horizontal en máquina");
                        listacuadriceps3.add("Sentadilla en máquina perfecta");



                        StringBuilder stringBuildercuadriceps3 = new StringBuilder();
                        Random randomcuadriceps3 = new Random();
                        int icuadriceps3 = randomcuadriceps3.nextInt(listacuadriceps3.size());
                        stringBuildercuadriceps3.append(listacuadriceps3.get(icuadriceps3));
                        String newPathcuadriceps3 = stringBuildercuadriceps3.toString();

                        ArrayList<String> listacuadriceps4 = new ArrayList<>();
                        listacuadriceps4.add("Extensiones de cuadriceps en máquina");
                        listacuadriceps4.add("Sentadilla");
                        listacuadriceps4.add("Sentadilla frontal con mancuernas");



                        StringBuilder stringBuildercuadriceps4 = new StringBuilder();
                        Random randomcuadriceps4 = new Random();
                        int icuadriceps4 = randomcuadriceps4.nextInt(listacuadriceps4.size());
                        stringBuildercuadriceps4.append(listacuadriceps4.get(icuadriceps4));
                        String newPathcuadriceps4 = stringBuildercuadriceps4.toString();


                        Map<String, Object> ejerciciocuadriceps = new HashMap<>();
                        ejerciciocuadriceps.put("cuadriceps/ ejercicio primario", newPathcuadriceps);
                        ejerciciocuadriceps.put("cuadriceps/ ejercicio secundario", newPathcuadriceps2);
                        ejerciciocuadriceps.put("cuadriceps/ ejercicio tercero", newPathcuadriceps3);
                        ejerciciocuadriceps.put("cuadriceps/ ejercicio cuarto", newPathcuadriceps4);

                        mRootReference.child("Users").child(id).updateChildren(ejerciciocuadriceps);


                        //Calentamiento
                        ArrayList<String> listacalentamiento = new ArrayList<>();
                        listacalentamiento.add("Bird dogs");
                        listacalentamiento.add("Dead bugs");
                        listacalentamiento.add("Db Cuban press");
                        listacalentamiento.add("Rotación externa de hombro con mancuernas pegado al cuerpo");
                        listacalentamiento.add("Rotación externa de hombro con cable pegado al cuerpo");
                        listacalentamiento.add("Aducciones de hombro");
                        listacalentamiento.add("Rotación de hombros con brazos extendidos");
                        listacalentamiento.add("Rotación de hombro");
                        listacalentamiento.add("Rotación de muñecas");

                        StringBuilder stringBuildercalentamiento = new StringBuilder();
                        Random randomcalentamiento = new Random();
                        int icalentamiento = randomcalentamiento.nextInt(listacalentamiento.size());
                        stringBuildercalentamiento.append(listacalentamiento.get(icalentamiento));
                        String newPathcalentamiento = stringBuildercalentamiento.toString();

                        ArrayList<String> listacalentamiento2 = new ArrayList<>();
                        listacalentamiento2.add("Goblet squat");
                        listacalentamiento2.add("Tall Kneeling Glute Activation");
                        listacalentamiento2.add("Mountain climber stretch dynamic");
                        listacalentamiento2.add("Balanceo de pierna");
                        listacalentamiento2.add("Desplantes sin peso");
                        listacalentamiento2.add("Gatos-Camello");
                        listacalentamiento2.add("Rotación de tobillos");
                        listacalentamiento2.add("Elevación de piernas acostado");
                        listacalentamiento2.add("Puentes acostado");

                        StringBuilder stringBuildercalentamiento2 = new StringBuilder();
                        Random randomcalentamiento2 = new Random();
                        int icalentamiento2 = randomcalentamiento2.nextInt(listacalentamiento2.size());
                        stringBuildercalentamiento2.append(listacalentamiento2.get(icalentamiento2));
                        String newPathcalentamiento2 = stringBuildercalentamiento2.toString();

                        ArrayList<String> listacalentamiento3 = new ArrayList<>();
                        listacalentamiento3.add("Bird dogs");
                        listacalentamiento3.add("Dead bugs");
                        listacalentamiento3.add("Db Cuban press");
                        listacalentamiento3.add("Rotación externa de hombro con mancuernas pegado al cuerpo");
                        listacalentamiento3.add("Rotación externa de hombro con cable pegado al cuerpo");
                        listacalentamiento3.add("Aducciones de hombro");
                        listacalentamiento3.add("Rotación de hombros con brazos extendidos");
                        listacalentamiento3.add("Rotación de hombro");
                        listacalentamiento3.add("Rotación de muñecas");

                        StringBuilder stringBuildercalentamiento3 = new StringBuilder();
                        Random randomcalentamiento3 = new Random();
                        int icalentamiento3 = randomcalentamiento3.nextInt(listacalentamiento3.size());
                        stringBuildercalentamiento3.append(listacalentamiento3.get(icalentamiento3));
                        String newPathcalentamiento3 = stringBuildercalentamiento3.toString();

                        ArrayList<String> listacalentamiento4 = new ArrayList<>();
                        listacalentamiento4.add("Goblet squat");
                        listacalentamiento4.add("Tall Kneeling Glute Activation");
                        listacalentamiento4.add("Mountain climber stretch dynamic");
                        listacalentamiento4.add("Balanceo de pierna");
                        listacalentamiento4.add("Desplantes sin peso");
                        listacalentamiento4.add("Gatos-Camello");
                        listacalentamiento4.add("Rotación de tobillos");
                        listacalentamiento4.add("Elevación de piernas acostado");
                        listacalentamiento4.add("Puentes acostado");

                        StringBuilder stringBuildercalentamiento4 = new StringBuilder();
                        Random randomcalentamiento4 = new Random();
                        int icalentamiento4 = randomcalentamiento4.nextInt(listacalentamiento4.size());
                        stringBuildercalentamiento4.append(listacalentamiento4.get(icalentamiento4));
                        String newPathcalentamiento4 = stringBuildercalentamiento4.toString();





                        Map<String, Object> ejerciciocalentamiento = new HashMap<>();
                        ejerciciocalentamiento.put("calentamiento/ ejercicio primario", newPathcalentamiento);
                        ejerciciocalentamiento.put("calentamiento/ ejercicio secundario", newPathcalentamiento2);
                        ejerciciocalentamiento.put("calentamiento/ ejercicio tercero", newPathcalentamiento3);
                        ejerciciocalentamiento.put("calentamiento/ ejercicio cuarto", newPathcalentamiento4);

                        mRootReference.child("Users").child(id).updateChildren(ejerciciocalentamiento);


//-----------------------PESO


                                                String pesoinicial = "";

                        Map<String, Object> pesoejercicios = new HashMap<>();
                        pesoejercicios.put("Historial pectoral/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial pectoral/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial pectoral/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 5 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 5 dias/ cuarto ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial pectoral/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 6 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pectoral/ 6 dias/ cuarto ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial espalda/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial espalda/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial espalda/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 5 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 5 dias/ cuarto ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial espalda/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 6 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial espalda/ 6 dias/ cuarto ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial biceps/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial biceps/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial biceps/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 5 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 5 dias/ cuarto ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial biceps/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 6 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial biceps/ 6 dias/ cuarto ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial triceps/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial triceps/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial triceps/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 5 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 5 dias/ cuarto ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial triceps/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 6 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial triceps/ 6 dias/ cuarto ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial frontal/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial frontal/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial frontal/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial frontal/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial frontal/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial frontal/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial frontal/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial frontal/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial deltoides laterales y posteriores/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);





                        pesoejercicios.put("Historial cuadriceps/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 3 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 3 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 3 dias/ segundo ejercicio/ dia 3", pesoinicial);




                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 4 dias/ cuarto ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ cuarto ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ tercer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 5 dias/ cuarto ejercicio/ dia 3", pesoinicial);


                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ cuarto ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ tercer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial cuadriceps/ 6 dias/ cuarto ejercicio/ dia 3", pesoinicial);


                        pesoejercicios.put("Historial isquios/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 3 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 3 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 3 dias/ segundo ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial isquios/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial isquios/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ cuarto ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ tercer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 5 dias/ cuarto ejercicio/ dia 3", pesoinicial);


                        pesoejercicios.put("Historial isquios/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ cuarto ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ tercer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial isquios/ 6 dias/ cuarto ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial gluteos y aductores/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 3 dias/ segundo ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ cuarto ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 4 dias/ cuarto ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);

                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ tercer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 5 dias/ cuarto ejercicio/ dia 3", pesoinicial);


                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);

                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ tercer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial gluteos y aductores/ 6 dias/ cuarto ejercicio/ dia 3", pesoinicial);

                        pesoejercicios.put("Historial pantorrillas/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial pantorrillas/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);

                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 5 dias/ tercer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);

                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ primer ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ segundo ejercicio/ dia 3", pesoinicial);
                        pesoejercicios.put("Historial pantorrillas/ 6 dias/ tercer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial trapecios/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial trapecios/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial trapecios/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial trapecios/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial trapecios/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial trapecios/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial trapecios/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial abdomen/ 3 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 3 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 3 dias/ primer ejercicio/ dia 3", pesoinicial);



                        pesoejercicios.put("Historial abdomen/ 4 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 4 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 4 dias/ tercer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 4 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 4 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 4 dias/ tercer ejercicio/ dia 2", pesoinicial);



                        pesoejercicios.put("Historial abdomen/ 5 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 5 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 5 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial abdomen/ 5 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 5 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 5 dias/ tercer ejercicio/ dia 2", pesoinicial);




                        pesoejercicios.put("Historial abdomen/ 6 dias/ primer ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 6 dias/ segundo ejercicio/ dia 1", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 6 dias/ tercer ejercicio/ dia 1", pesoinicial);

                        pesoejercicios.put("Historial abdomen/ 6 dias/ primer ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 6 dias/ segundo ejercicio/ dia 2", pesoinicial);
                        pesoejercicios.put("Historial abdomen/ 6 dias/ tercer ejercicio/ dia 2", pesoinicial);

                        pesoejercicios.put("diasentrenados", "0");

                        pesoejercicios.put("diaactual1", "false");
                        pesoejercicios.put("diaactual2", "false");
                        pesoejercicios.put("diaactual3", "false");
                        pesoejercicios.put("diaactual4", "false");
                        pesoejercicios.put("diaactual5", "false");
                        pesoejercicios.put("diaactual6", "false");

                        pesoejercicios.put("progresosrer", "20");



                        mRootReference.child("Users").child(id).updateChildren(pesoejercicios);




                    }



















                } else {
                    String no = "no se encontro";
                    Toast.makeText(getApplicationContext(),no,Toast.LENGTH_SHORT).show();
                }





            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });










        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(generador.this, iniciarsesion.class);

                startActivity(intent);
                //onDestroy();
                finish();



            }
        }, 3000);












    } // fin del oncreate

    public void onDestroy(){
        super.onDestroy();
    }





}
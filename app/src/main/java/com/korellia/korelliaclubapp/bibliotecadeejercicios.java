package com.korellia.korelliaclubapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class bibliotecadeejercicios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bibliotecadeejercicios);

        Toolbar toolbar = findViewById(R.id.toolbarbibliotecadeejercicios);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Biblioteca de ejercicios");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    } //findel oncreate

    //ABDOMEN
    public void crunchabdominal (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Crunch abdominal";
        intent.putExtra("ej", ej);
        startActivity(intent);


    }

    public void crunchabdominalenmaquina (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Crunch abdominal en maquina";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void crunchabdominalenmaquinaconcuerda (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Crunch abdominal en maquina con cuerda";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }



    //BICEPS

    public void curlconcentrado (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Curl concentrado a 1 brazo recargado en muslo";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }
    public void curl90grados (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Curl de biceps a 90° con barra";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }
    public void curlacostado (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Curl de biceps acostado en banco inclinado";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }
    public void curlalternado (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Curl de biceps alternado";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }
    public void curlbarraz (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Curl de biceps con barra z";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }
    public void curlmaneralrecto (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Curl de biceps con polea maneral recto";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }
    public void curlmaquina (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Curl de biceps en maquina";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }
    public void curlpredicadormancuernas (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Curl de biceps en predicador con mancuerna a 1 brazo";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }
    public void curlmartillomancuernas (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Curl martillo con mancuernas";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }
    public void curlpredicadorbarraz (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Curl predicador con barra z";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }
    public void curlspiderconbarra (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Curl spider con barra";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void curlmartilloconcuerda (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Curl martillo con cuerda";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }


    public void curlspiderconmancuernas (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Curl spider con mancuernas";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }



    //CALENTAMIENTO

    public void aduccionesdehombro (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Aducciones de hombro";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void balanceodepiernas (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Balanceo de piernas";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void bicicleta (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Bicicleta";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void desplantes(View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Desplantes sin peso";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void elevaciondepiernasacostado (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Elevación de piernas acostada";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void gatoscamello (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Gatos-Camello";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void puentesacostado (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Puentes acostada";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void rotacióndehombro (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Rotación de hombro";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void rotacióndehombrosextendidas (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Rotación de hombros con brazos extendidos";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void rotacióndetobillos (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Rotación de tobillos";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    //CUADRICEPS

    public void desplantesconmancuernas (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "desplantesconmancuernas";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void prensaa1pierna (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "prensa1pierna";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void prensa45grados (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "prensa45grados";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void prensahorizontalenmaquina (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "prensahorizontalenmaquina";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void sentadillaconbarra (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "sentadillaconbarra";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void sentadillaenmaquinaperfecta (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "sentadillaenmaquinaperfecta";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void sentadillafrontalconmancuernas (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "sentadillafrontalmancuernas";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void sentadilla (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "sentadilla";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }


    //DELTOIDE FRONTAL

    public void elevacionesfrontalesconmancuernas (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevacionesfrontalesconmancuernas";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void pressenmaquinaagarreneutro (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pressenmaquinaagarreneutro";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void pressmilitarconbarra (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pressmilitarconbarra";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void pressmilitarconmancuernas (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pressmilitarconmancuernas";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }



    //DELTOIDES LATERALES Y POSTERIORES

    public void elevacionlateralconpoleabaja (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevacionlateralconpoleabaja";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void elevacionlateralesconmancuerna (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevacionlateralesconmancuerna";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void flyesinvertidosenpeckdeck (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "flyesinvertidosenpeckdeck";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void remoalmentonconbarra (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "remoalmentonconbarra";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void remoalmentonconpoleabaja (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "remoalmentonconpoleabaja";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }


    //ESPALDA


    public void dominadas (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "dominadas";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void hiperextensiones (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "hiperextensiones";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void jalonfrontalconagarreabierto (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "jalonfrontalconagarreabierto";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void jalonfrontalcontriangulo (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "jalonfrontalcontriangulo";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void pulloverconbcuerda (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pulloverconbcuerda";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }


        public void pulloverconmancuerna (View view){
            Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
            String ej = "pulloverconmancuerna";
            intent.putExtra("ej", ej);
            startActivity(intent);

    }


    public void remoa1manoconpoleabaja (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "remoa1manoconpoleabaja";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void remoconmancuernaa1brazo (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "remoconmancuernaa1brazo";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void remoenmaquinaagarreenpronacion (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "remoenmaquinaagarreenpronacion";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void remoenmaquinahammer (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "remoenmaquinahammer";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void remosentadoenpoleacontriangulo (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "remosentadoenpoleacontriangulo";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }




    //GLUTEOS Y ADUCTORES


    public void abduccionesdecaderaenmaquina (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "abduccionesdecaderaenmaquina";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void aduccionedecaderaenmaquina (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "aduccionedecaderaenmaquina";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void hipthrustconbarra (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "hipthrustconbarra";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void patadaparagluteoconmancuerna (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "patadaparagluteoconmancuerna";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void patadaparagluteoconpolea (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "patadaparagluteoconpolea";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void patadaparagluteoenmaquina (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "patadaparagluteoenmaquina";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }


    public void patadaparagluteoenmaquinadepie (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "patadaparagluteoenmaquinadepie";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void pesomuertotiposumoconbarra (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pesomuertotiposumoconbarra";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void pesomuertotiposumoconmancuerna (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pesomuertotiposumoconmancuerna";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void puentea1pierna (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "puentea1pierna";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void pesoconmancuerna (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pesoconmancuerna";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void sentadillasmithtiposumo (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "sentadillasmithtiposumo";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }


    //ISQUIOSURALES

    public void curlacostadoconmancuerna (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "curlacostadoconmancuerna";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }


    public void curlfemorala1piernaparado (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "curlfemorala1piernaparado";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void curlfemoralacostadoenmáquina (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "curlfemoralacostadoenmáquina";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void curlsentadoenmáquinaparaisquiosurales (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "curlsentadoenmáquinaparaisquiosurales";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void pesomuertoa1pierna (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pesomuertoa1pierna";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void pesomuertoconmancuernas (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pesomuertoconmancuernas";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void pesomuertoconpiernasrigidasconbarra (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pesomuertoconpiernasrigidasconbarra";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }




    //PANTORRILLAS

    public void elevacionesdelatonencosturera (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevacionesdelatonencosturera";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void elevacionesdetalonenprensaa1pierna (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevacionesdetalonenprensaa1pierna";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void elevacionesdetalonparadoconmancuerna (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevacionesdetalonparadoconmancuerna";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }


    //PECTORALES

    public void aperturasconmancuernasenbancoplano (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "aperturasconmancuernasenbancoplano";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void presshorizontalconbarra (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "presshorizontalconbarra";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void pressconmancuernasenbancoinclinado (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pressconmancuernasenbancoinclinado";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void pressconmancuernasenbancoplano (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pressconmancuernasenbancoplano";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void pressdepectoralesenmaquinahammer (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pressdepectoralesenmaquinahammer";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void presshorizontalenmaquina (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "presshorizontalenmaquina";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }



    public void pressinclinadoconbarra (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pressinclinadoconbarra";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    //TRAPECIOS

    public void encogimientodehombrosconmancuernas (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "encogimientodehombrosconmancuernas";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void encogimientodehombrosensmith (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "encogimientodehombrosensmith";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }


    //TRICEPS

    public void copaconbarra (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "copaconbarra";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void copaconmancuernaa1brazo (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "copaconmancuernaa1brazo";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }


    public void extensiondetricepsa1brazosupino (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "extensiondetricepsa1brazosupino";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void extensionesdetricepsconcuerda (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "extensionesdetricepsconcuerda";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void extensionesdetricepsenmaquina (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "extensionesdetricepsenmaquina";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void fondosenmaquina (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "fondosenmaquina";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void patadaparatricepsa1brazo (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "patadaparatricepsa1brazo";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void patadaparatricepsconpolea (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "patadaparatricepsconpolea";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void rompecraneosconmancuernas (View view){
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "rompecraneosconmancuernas";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }









    //abdomen

    public void crunchabdominalconflexiondepiernas(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "crunchabdominalconflexiondepiernas";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void crunchabdominalenbancodeclinadoconbalonpordetras(View view) {


        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "crunchabdominalenbancodeclinadoconbalonpordetras";
        intent.putExtra("ej", ej);
        startActivity(intent);


    }

    public void crunchabdominalenbancodeclinado(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "crunchabdominalenbancodeclinado";
        intent.putExtra("ej", ej);
        startActivity(intent);


    }

    public void crunchabdominalhincadoconcuerda(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "crunchabdominalhincadoconcuerda";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void crunchabdominallateral(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "crunchabdominallateral";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void crunchlateralconpoleaalta(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "crunchlateralconpoleaalta";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void crunchtipobicicleta(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "crunchtipobicicleta";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void Elevacionesdepiernasacostadoenbanco(View view) {


        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Elevacionesdepiernasacostadoenbanco";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void Elevacióndepiernasensillaromana(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Elevacióndepiernasensillaromana";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void rodilloabdominal(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "rodilloabdominal";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void toquesaltalon(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "toquesaltalon";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }


    //------ biceps


    public void curldebicepsa1brazoconpoleaalturamedia(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "curldebicepsa1brazoconpoleaalturamedia";
        intent.putExtra("ej", ej);
        startActivity(intent);


    }

    public void curlmartillobarraromana(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "curlmartillobarraromana";
        intent.putExtra("ej", ej);
        startActivity(intent);


    }

    // ------- calentamiento

    public void bearcrawlshouldertouch(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "bearcrawlshouldertouch";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void birddogs(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "birddogs";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void Rotaciónexternadehombroconcablepegadoalcuerpo(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Rotaciónexternadehombroconcablepegadoalcuerpo";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void Rotaciónexternadehombroconmancuernaspegadoalcuerpo(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Rotaciónexternadehombroconmancuernaspegadoalcuerpo";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void tallkneelinggluteactivation(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "tallkneelinggluteactivation";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void cubanpress(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "cubanpress";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void deadbugs(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "deadbugs";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void gobletsquat(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "gobletsquat";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void Mountainclimberstretchdynamic(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Mountainclimberstretchdynamic";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void rotacióndemuñecas(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "rotacióndemuñecas";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }


    //------ cuadriceps


    public void extensionesdecuadricepsenmaquina(View view) {

        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "extensionesdecuadricepsenmaquina";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void Prensaa1pierna(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Prensaa1pierna";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void sentadillaa90gradosensmith(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "sentadillaa90gradosensmith";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void sentadillabulgaraconmancuernas(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "sentadillabulgaraconmancuernas";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void sentadillafrontalrnsmith(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "sentadillafrontalensmith";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void sentadillafrontal(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "sentadillafrontal";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void sentadillasmith(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "sentadillasmith";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    //------- deltoide frontal


    public void elevacionfrontalsupinoconmancuernas(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevacionfrontalsupinoconmancuernas";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void elevacionfrontalconcuerdaa1brazoenpoleabaja(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevacionfrontalconcuerdaa1brazoenpoleabaja";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void elevacionfrontalcondisco(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevacionfrontalcondisco";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void elevacionfrontalconmancuernassagarreneutro(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevacionfrontalconmancuernassagarreneutro";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void elevacionfrontalconmancuernasagarreprono(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevacionfrontalconmancuernasagarreprono";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void pressarnold(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pressarnold";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void pressmilitarenmaquinaagarreprono(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pressmilitarenmaquinaagarreprono";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void pressmilitarensmith(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pressmilitarensmith";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void pushpress(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Push press";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }




    //------ deltoides laterales
    public void elevacionlaterala45gradosconmancuernas(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevacionlaterala45gradosconmancuernas";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }


    public void elevacionlateralconmancuernaacostadoenbancoinclinado(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevacionlateralconmancuernaacostadoenbancoinclinado";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void elevacionlateralpordetras(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevacionlateralpordetras";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void facepullconcuerda(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "facepullconcuerda";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void flyesagachados(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "flyesagachados";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void flyesinvertidoscruzados(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "flyesinvertidoscruzados";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void remoalmentonconmancuernas(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "remoalmentonconmancuernas";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    //---- espalda

    public void jalonfrontalcerradoconpoleaalta(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "jalonfrontalcerradoconpoleaalta";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void pesomuertoconvencional(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pesomuertoconvencional";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void remohorizontalconbarra(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "remohorizontalconbarra";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void remohorizontalsmith(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "remohorizontalsmith";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void remopendlay(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "remopendlay";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    // ------ gluteos

    public void aduccionesdecaderaconpolea(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "aduccionesdecaderaconpolea";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void abduccionesdecaderaconpolea(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "abduccionesdecaderaconpolea";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }


    // ----- femorales

    public void curlfemorala1piernaacostado(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "curlfemorala1piernaacostado";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void elevaciondecaderaa1pierna(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevaciondecaderaa1pierna";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void pesomuertoensmith(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pesomuertoensmith";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }



    // ----- pantorrillas

    public void elevaciondetalonenprensahorizontal(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevaciondetalonenprensahorizontal";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void elevaciondetalonensentadillaperfecta(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevaciondetalonensentadillaperfecta";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void elevacionesdetalonenprensa45(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "elevacionesdetalonenprensa45";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }



    //------- pecho
    public void aperturasconmancuernasenbancoinclinado(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "aperturasconmancuernasenbancoinclinado";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void aperturasenpeckdeck(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "aperturasenpeckdeck";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void crossovernivelmedio(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "crossovernivelmedio";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void crossoverpoleaalta(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "crossoverpoleaalta";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void crossoverpoleabaja(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "crossoverpoleabaja";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void fondos(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "fondos";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void lagartijas(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "lagartijas";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void pressdeclinadoconmancuernas(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pressdeclinadoconmancuernas";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void pressinclinadoensmith(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "pressinclinadoensmith";
        intent.putExtra("ej", ej);
        startActivity(intent);

    }

    public void pressplanoensmith(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Press plano en smith";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }



    //----- trapecios

    public void encogimientodehombroconbarrapordelante(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "encogimientodehombroconbarrapordelante";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void encogimientodehombrosconbarrapordetrás(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "encogimientodehombrosconbarrapordetrás";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void encogimientodehombrosensmithpordetrás(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "encogimientodehombrosensmithpordetrás";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void paseodelgranjero(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "paseodelgranjero";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }


        //----- triceps

    public void copaconmancuerna(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "copaconmancuerna";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void extensionesdetricepsenpoleaaltaconmaneralrecto(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "extensionesdetricepsenpoleaaltaconmaneralrecto";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void presscerradoconbarra(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "presscerradoconbarra";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void presscerradoesmith(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "Press cerrado en smith";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }

    public void rompecraneosconbarraz(View view) {
        Intent intent = new Intent(bibliotecadeejercicios.this, ejerciciobiblioteca.class);
        String ej = "rompecraneosconbarraz";
        intent.putExtra("ej", ej);
        startActivity(intent);
    }


    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // -----------------------------------------------


}
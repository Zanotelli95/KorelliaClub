package com.korellia.korelliaclubapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ejerciciobiblioteca extends AppCompatActivity {

    ImageView switcher;
    TextView descripcion, nombre;
    RadioGroup group;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejerciciobiblioteca);



        Toolbar toolbar = findViewById(R.id.toolbarejerciciobiblioteca);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Descripción del ejercicio");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        descripcion = findViewById(R.id.textView81);
        nombre = findViewById(R.id.textView80);
        group = findViewById(R.id.grupo);
        switcher = findViewById(R.id.switcher);


        //obtener valor del boton de la activity, usar switch y extraer los elementos correspondientes de la base de datos

        String ejercicio = getIntent().getStringExtra("ej");


        switch (ejercicio) {
            //ABDOMEN


            case "toquesaltalon":
                nombre.setText("Toques al talón");
                descripcion.setText("- Acostado, realiza un crunch abdominal de manera lateral con la intención de tocar los talones con la punta de tus dedos.\n" +
                                "\n- Manten las piernas flexionadas y juntas como se muestra en la imagen.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113832.jpg?alt=media&token=7895b4de-dc2a-474f-82fa-91bd98f3dd6a")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113832.jpg?alt=media&token=7895b4de-dc2a-474f-82fa-91bd98f3dd6a")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113834.jpg?alt=media&token=3521bce4-bbd0-4936-9994-1df7bd3f72d4")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113836.jpg?alt=media&token=835d8113-9fa2-4cc4-8d91-6cc1ab84dc64")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "rodilloabdominal":
                nombre.setText("Rodillo abdominal");
                descripcion.setText("- Coger el rodillo con ambas manos, posteriormente arrodillarse y extenderse de manera que el rodillo se aleje de tus rodillas\n" +
                        "\n - Mantener el rodillo tocando el suelo en todo momento y mantener la tensión en el area abdominal en todo momento\n" +
                        "\n - Posteriorente regresar al punto inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112438.jpg?alt=media&token=4afc0b57-fb0f-486d-a273-a37b1aea9ec0")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112438.jpg?alt=media&token=4afc0b57-fb0f-486d-a273-a37b1aea9ec0")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112441.jpg?alt=media&token=ea63c563-8480-4685-8ed5-7011d88aa64a")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112445.jpg?alt=media&token=65fbc2e2-c04e-4300-af76-36ba341c3a1b")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            case "Elevacióndepiernasensillaromana":
                nombre.setText("Elevación de pierna en silla romana");
                descripcion.setText("- Recargar la espalda completamente en la silla romana.\n" +
                        "\n- Inhalar y posteriormente elevar las piernas mientras se mantienen con una muy ligera flexión como se muestra en la imagen.\n" +
                        "\n- Elevar hasta realizar un crunch adbominal casi completo pero sin despegar la espalda baja del respaldo.\n" +
                        "\n- Regresar las piernas lentamente a la posición inicial, exhalar.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112602.jpg?alt=media&token=ed4131dd-4ad9-4683-b0cb-b8a87853ac13")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112602.jpg?alt=media&token=ed4131dd-4ad9-4683-b0cb-b8a87853ac13")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112603.jpg?alt=media&token=fd8adc0e-5b7d-4bea-a754-440f4ce7f789")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112604.jpg?alt=media&token=a27b1953-a16e-419b-b206-ad01ebf5138d")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;
            case "Elevacionesdepiernasacostadoenbanco":
                nombre.setText("Elevaciones de piernas acostado en banco");
                descripcion.setText("- Acostarse boca arriba del banco y mantener la espalda pegada al banco siempre en todo el ejercicio.\n" +
                        "\n - Inhalar y elevar las piernas como se muestra en la imagen hasta realizar un crunch abdominal sin levantar la espalda baja.\n" +
                        "\n - Regresar las piernas a la posición incial, mientras exhalas.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854.jpg?alt=media&token=9cab081e-a91e-40ef-8be1-e481445eddd1")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854.jpg?alt=media&token=9cab081e-a91e-40ef-8be1-e481445eddd1")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854(0).jpg?alt=media&token=afbbdb91-e4a0-461e-836a-d89f76b69082")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110857.jpg?alt=media&token=ff050bc8-cdb0-4d28-8cae-6f6afde968aa")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "crunchtipobicicleta":
                nombre.setText("Crunch tipo bicicleta");
                descripcion.setText("- Acostado en el banco, inhalar. \n" +
                        "\n- Con las manos en la nuca como se muestra en la imagen, realizar un crunch lateral llevando uno de los brazos al lado contrario del mismo.\n" +
                        "\n- Posteriormente exhalar mientras se realiza el crunch y a continuación realizar el siguiente crunch del lado opuesto.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112734.jpg?alt=media&token=8f5da44d-2028-4de7-b862-c990724f1dbb")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112736.jpg?alt=media&token=c832a4dc-f1fe-476a-82b0-caf995de038e")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;



            case "crunchlateralconpoleaalta":
                nombre.setText("Crunch lateral con polea alta");
                descripcion.setText("- Inhalar y coger el maneral individual en polea alta de perfil.\n" +
                        "\n- Realizar un crunch lateral como se muestra en la imagen y exhalar.\n" +
                        "\n- Regresar a la posición incial y repetir con el siguiente lado.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113700.jpg?alt=media&token=5f2f4d1c-0963-4998-838b-f6b58ed8f0c7")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113700.jpg?alt=media&token=5f2f4d1c-0963-4998-838b-f6b58ed8f0c7")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113702.jpg?alt=media&token=1717a072-a610-449b-8a35-3dec01aded1a")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113704.jpg?alt=media&token=8843cf7c-b618-421d-95cf-162aeaf6088b")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;



            case "crunchabdominallateral":
                nombre.setText("Crunch abdominal lateral");
                descripcion.setText("- Con las piernas flexionadas y acostado en el banco, inhalar.\n" +
                        "\n- Realizar un crunch lateral como se muestra en la imagen, llevando un brazo al lado contrario y exhalar.\n" +
                        "\n- Mantener las piernas en su misma posición y continuar con el siguiente lado realizando el mismo movimiento.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113437.jpg?alt=media&token=eccbfefe-6820-4879-b370-0ccb1454573e")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113437.jpg?alt=media&token=eccbfefe-6820-4879-b370-0ccb1454573e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113438.jpg?alt=media&token=1ee83c6a-7ca9-4562-8b54-7641a68f8cbe")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113441.jpg?alt=media&token=706746e5-f1dd-4661-95a4-ef037dc49153")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "crunchabdominalhincadoconcuerda":
                nombre.setText("Crunch abdominal hincado con cuerda");
                descripcion.setText("- Coger la cuerda con ambos brazos en polea alta y arrodillarse.\n" +
                        "\n- Inhalar y realizar un crunch abdominal mientras se sostiene la cuerda. \n" +
                        "\n- Exhalar y regresar al punto inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112930.jpg?alt=media&token=7f979469-e8cd-48d9-bdc2-db92a7ecf641")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112930.jpg?alt=media&token=7f979469-e8cd-48d9-bdc2-db92a7ecf641")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112931.jpg?alt=media&token=6dc6d69c-958a-4c9d-b5c3-0cd990fde57a")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112933.jpg?alt=media&token=914478f7-ce1a-4b1d-9a5d-53442fc27ef3")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "crunchabdominalenbancodeclinado":
                nombre.setText("Crunch abdominal en banco declinado");
                descripcion.setText("- Acostado en banco declinado, colocar las manos en el pecho o en la nuca.\n" +
                        "\n- Inhalar y realizar un crunch abdominal como se muestra en las imagenes.\n" +
                        "\n- Exhalar al realizar el crunch y regresar de manera controlada.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113142.jpg?alt=media&token=ba44dc40-c40b-425c-a55f-36d4fd690590")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113142.jpg?alt=media&token=ba44dc40-c40b-425c-a55f-36d4fd690590")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113144.jpg?alt=media&token=6eb25b94-4d87-47ae-b9c0-4e83c61a0472")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113147.jpg?alt=media&token=55b3d636-887e-4c01-ba37-e274fce2e1d1")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            case "crunchabdominalenbancodeclinadoconbalonpordetras":
                nombre.setText("Crunch abdominal en banco declinado con balón por detrás");
                descripcion.setText("- Acostado en banco declinado, coger el balón por detrás de la nuca.\n" +
                        "\n- Inhalar y realizar un crunch abdominal como se muestra en las imagenes.\n" +
                        "\n- Exhalar al realizar el crunch y regresar de manera controlada. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113217.jpg?alt=media&token=a6ad17e7-d218-41c7-9412-b26ffd74fc38")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113221.jpg?alt=media&token=a208b738-7656-428f-ab73-8c5213b63864")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113219.jpg?alt=media&token=b51c315a-05d9-4cc8-9d91-1887185e027c")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113217.jpg?alt=media&token=a6ad17e7-d218-41c7-9412-b26ffd74fc38")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;

            case "crunchabdominalconflexiondepiernas":
                nombre.setText("Crunch abdominal con flexión de piernas");
                descripcion.setText("- Acostado en banco y mantener una flexión de piernas durante todo el movimento.\n" +
                        "\n- Mantener las manos en el pecho o en la nuca, inhalar y relizar un crunch adbominal.\n" +
                        "\n- Exhalar al final del movimiento y regresar a la posición inicial de manera controlada.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20con%20flexi%C3%B3n%20de%20piernas%2F20211210_113336.jpg?alt=media&token=41adadec-b78d-49ef-a0e4-db1ba66eba2a")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20con%20flexi%C3%B3n%20de%20piernas%2F20211210_113336.jpg?alt=media&token=41adadec-b78d-49ef-a0e4-db1ba66eba2a")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20con%20flexi%C3%B3n%20de%20piernas%2F20211210_113337.jpg?alt=media&token=890d8205-babf-4519-a602-034d8de2f48e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20con%20flexi%C3%B3n%20de%20piernas%2F20211210_113340.jpg?alt=media&token=063a87c6-0413-4e4f-b103-8e1892a93987")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;



            case "Crunch abdominal":
                nombre.setText("Crunch abdominal");
                descripcion.setText("- Acostado en un banco, manos detrás de la cabeza y pies anclados\n" +
                        "\n- Realizar una abdominal manteniendo el resto del cuerpo en una misma posición neutra \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121915.jpg?alt=media&token=145240dc-4483-47d7-b88c-fc6383c98aaf")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121915.jpg?alt=media&token=145240dc-4483-47d7-b88c-fc6383c98aaf")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121917.jpg?alt=media&token=6a7354cf-d38a-4931-ae6d-3bd5a0a6f1a1")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121916.jpg?alt=media&token=86c4637b-5ef5-4735-ab73-089f882b1e06")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;
            case "Crunch abdominal en maquina":
                nombre.setText("Crunch abdominal en maquina");
                descripcion.setText("- Sentarse en la máquina y colocar completamente la espalda en el respaldo\n" +
                        "\n- Coger los manerales de la máquina y realizar una abdominal \n" +
                        "\n- Regresar controladamente a la posición inicial \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123651.jpg?alt=media&token=d6dd4e8a-d951-41cb-a56d-50eff8291a04")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123651.jpg?alt=media&token=d6dd4e8a-d951-41cb-a56d-50eff8291a04")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123647.jpg?alt=media&token=21d241b4-69a6-4e42-8f6b-d8eab01d5e16")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123642.jpg?alt=media&token=e0da9abd-59d8-4237-8a60-f8a89033a7c7")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;


            case "Crunch abdominal en maquina con cuerda":

                nombre.setText("Crunch abdominal en maquina con cuerda");
                descripcion.setText("- Sentado en la máquina con la espalda recargada en el respaldo \n" +
                        "\n- Inspirar, coger los manerales y realizar un crunch abdominal inclinándose hacia adelante \n" +
                        "\n- Espirar y regresar controladamente a la posición inicial \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20maquina%20con%20cuerda%2F20210203_122759.jpg?alt=media&token=088d5eae-c1c6-49bb-aa7b-ef89656e2e29")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123651.jpg?alt=media&token=d6dd4e8a-d951-41cb-a56d-50eff8291a04")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20maquina%20con%20cuerda%2F20210203_122801.jpg?alt=media&token=b7b6492d-0e43-4d80-8e4a-58a874b0b740")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20maquina%20con%20cuerda%2F20210203_122804.jpg?alt=media&token=5610e8cf-9d23-4185-a2d3-d29e8e1b6b10")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            //BICEPS


                        case "curlmartillobarraromana":
                nombre.setText("Curl martillo barra romana");
                descripcion.setText("- De pie, coger la barra romana e inhalar.\n" +
                        "\n- Realizar un curl llevando la barra hacia arriba y manteniendo los brazos pegados al torso durante el movimiento.\n" +
                        "\n- Regresar a la posición inicial y exhalar.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20barra%20romana%2F20211211_134605.jpg?alt=media&token=9a651727-8978-4e21-b03a-9c916ce885f3")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20barra%20romana%2F20211211_134605.jpg?alt=media&token=9a651727-8978-4e21-b03a-9c916ce885f3")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20barra%20romana%2F20211211_134608.jpg?alt=media&token=91705f79-5119-4d58-bcac-e567f618b390")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20barra%20romana%2F20211211_134610.jpg?alt=media&token=6f342336-8476-4ef8-8351-c91f37376cfd")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                            break;

            case "curldebicepsa1brazoconpoleaalturamedia":
                nombre.setText("Curl de biceps a 1 brazo con polea altura media");
                descripcion.setText("- Colocar la polea a la misma altura de tu hombro o muy ligeramente por encima.\n " +
                        "\n- Alejarse unos pasos de la polea, coger con una mano e inhalar.\n" +
                        "\n- Realizar un curl mientras se mantiene la misma posición, como se muestra en las imagenes.\n" +
                        "\n- Regresar a la posición incial del movimiento y exhalar.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%201%20brazo%20con%20polea%20altura%20media%2F20211215_111013.jpg?alt=media&token=074bb85a-e5d8-40d9-a608-f3c1e3177b19")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%201%20brazo%20con%20polea%20altura%20media%2F20211215_111013.jpg?alt=media&token=074bb85a-e5d8-40d9-a608-f3c1e3177b19")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%201%20brazo%20con%20polea%20altura%20media%2F20211215_111008.jpg?alt=media&token=cb11ea38-64ae-43fd-8710-799870313968")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%201%20brazo%20con%20polea%20altura%20media%2F20211215_111010.jpg?alt=media&token=1fedfb25-dd3f-46f6-b7e7-ae210f38900f")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;





            case "Curl concentrado a 1 brazo recargado en muslo":
                nombre.setText("Curl concentrado a 1 brazo recargado en muslo");
                descripcion.setText("- Coger la mancuerna, sentarse en un banco y recargar el brazo a trabajar en el muslo \n" +
                        "\n- Descansar el brazo y posteriormente llevar la mancuerna hacia la barbilla contrayendo los bíceps del brazo a trabajar. \n" +
                        "\n- Una vez completado todo el recorrido, descender de manera controlada \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20concentrado%20a%201%20brazo%20recargado%20en%20muslo%2F20210303_114507.jpg?alt=media&token=41766ccc-48e4-421e-be45-fa82beba8257")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20concentrado%20a%201%20brazo%20recargado%20en%20muslo%2F20210303_114507.jpg?alt=media&token=41766ccc-48e4-421e-be45-fa82beba8257")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20concentrado%20a%201%20brazo%20recargado%20en%20muslo%2F20210303_114507(0).jpg?alt=media&token=7816982e-9b1c-4a09-83d9-5bf4e9835374")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20concentrado%20a%201%20brazo%20recargado%20en%20muslo%2F20210303_114508.jpg?alt=media&token=f20b8b01-f121-4691-ae60-03dc6c22b05a")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "Curl de biceps a 90° con barra":
                nombre.setText("Curl de biceps 90° con barra");
                descripcion.setText("- Recargado completamente en un banco a 90° coger la barra \n" +
                        "\n- Llevar la barra hacia arriba sin despegar los brazos del banco \n" +
                        "\n- Una vez logrado todo el recorrido completo, descender controladamente\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%2090%C2%B0%20con%20barra%2F20210224_120224.jpg?alt=media&token=39ce1ea5-bc73-4803-ae87-8bc35fa2ea5e")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%2090%C2%B0%20con%20barra%2F20210224_120224.jpg?alt=media&token=39ce1ea5-bc73-4803-ae87-8bc35fa2ea5e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%2090%C2%B0%20con%20barra%2F20210224_120223.jpg?alt=media&token=e7fde130-e81f-40ce-a148-390b7681e6f4")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%2090%C2%B0%20con%20barra%2F20210224_120221.jpg?alt=media&token=39c9069c-bc1d-4d80-890c-702f6ca05aeb")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "Curl de biceps acostado en banco inclinado":
                nombre.setText("Curl de biceps acostado en banco inclinado");
                descripcion.setText("- Acostado boca arriba en un banco inclinado, coger las mancuernas con un agarre neutro y posteriormente realizar un curl de bíceps mientras se realiza una supinación, al mismo tiempo ambos brazos. \n" +
                        "\n- Posteriormente extender controladamente el brazo de nuevo, hasta su posición inicial. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20acostado%20en%20banco%20inclinado%2F20210131_105854.jpg?alt=media&token=e78dbb5b-f7be-477e-852f-8f02151ba446")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20acostado%20en%20banco%20inclinado%2F20210131_105854.jpg?alt=media&token=e78dbb5b-f7be-477e-852f-8f02151ba446")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20acostado%20en%20banco%20inclinado%2F20210131_105903.jpg?alt=media&token=59e67154-9125-462d-ade1-4cdafc7e8f1e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20acostado%20en%20banco%20inclinado%2F20210131_105859.jpg?alt=media&token=4b0b61b2-fc8f-4a1c-90d7-c1613c4c7a8b")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "Curl de biceps alternado":
                nombre.setText("Curl de biceps alternado");
                descripcion.setText("- De pie, coger ambas mancuernas con un agarre neutro.\n" +
                        "\n- Posteriormente flexionar solo un brazo hasta llevarlo cercano a tu torso mientras se realiza una supinación con la mancuerna.\n" +
                        "\n- Después extender el brazo nuevamente hacia su posición inicial y a continuación repetir el mismo patrón con el otro brazo. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20alternado%2F20210131_105430.jpg?alt=media&token=0bb7a461-50e3-461a-aab4-3f0458b8b3c6")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20alternado%2F20210131_105430.jpg?alt=media&token=0bb7a461-50e3-461a-aab4-3f0458b8b3c6")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20alternado%2F20210131_105410.jpg?alt=media&token=343eb709-107d-48de-9244-876b2d78cd05")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20alternado%2F20210131_105406.jpg?alt=media&token=70a4cc94-6c7c-4b29-9f3c-c4048898d032")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "Curl de biceps con barra z":
                nombre.setText("Curl de biceps con barra z");
                descripcion.setText("\n- De pie, con la espalda bien recta, coger la barra z con una separación de muñecas a la altura de los hombros, inspirar y a continuación flexionar los codos, para posteriormente extender de nuevo los brazos de una manera controlada.\n" +
                        "\n- Este ejercicio trabaja principalmente el bíceps braquial, el braquial anterior y en menor medida el supinador largo y el conjunto de los flexores de la muñeca y los dedos. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20barra%20z%2F20210131_103242.jpg?alt=media&token=3251d734-6804-4177-b463-0ce95b65542b")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20barra%20z%2F20210131_103242.jpg?alt=media&token=3251d734-6804-4177-b463-0ce95b65542b")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20barra%20z%2F20210131_103247.jpg?alt=media&token=204b5b72-eb11-4d57-8c8e-55642943fb8f")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20barra%20z%2F20210131_103318.jpg?alt=media&token=09b97ea4-167a-4113-8331-5ca12f9350f3")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
                case "Curl de biceps con polea maneral recto":
                nombre.setText("Curl de biceps con polea maneral recto");
                descripcion.setText("- De pie, de cara al aparato el mango es cogido en supinación, inspirar y efectuar una flexión de codos, espirar al final del movimiento. \n" +
                        "\n- Este ejercicio te permite localizar el esfuerzo sobre el bíceps. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20polea%20maneral%20recto%2F20210203_120718.jpg?alt=media&token=847569a6-1b2e-4b5e-85cd-fce399aa02f4")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20polea%20maneral%20recto%2F20210203_120718.jpg?alt=media&token=847569a6-1b2e-4b5e-85cd-fce399aa02f4")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20polea%20maneral%20recto%2F20210203_120717.jpg?alt=media&token=98a90865-53c5-4df4-8551-872e6ac66849")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20polea%20maneral%20recto%2F20210203_120715.jpg?alt=media&token=64be5b68-847f-4488-a3a5-79bcaca678ac")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "Curl de biceps en maquina":
                nombre.setText("Curl de biceps en máquina");
                descripcion.setText("- Sentarse en la máquina predicador y posteriormente coger las agarraderas de la máquina, recargar completamente los brazos y mantener a la misma altura que las agarraderas, posteriormente flexionar los brazos hacia ti, y de regreso extenderlos nuevamente. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20maquina%2F20210131_104013.jpg?alt=media&token=1c5845cd-1d67-4647-b2a1-80bd06bfb7fb")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20maquina%2F20210131_104013.jpg?alt=media&token=1c5845cd-1d67-4647-b2a1-80bd06bfb7fb")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20maquina%2F20210131_104010.jpg?alt=media&token=30b56f18-ed50-4051-870f-029902fcba66")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20maquina%2F20210131_104013.jpg?alt=media&token=1c5845cd-1d67-4647-b2a1-80bd06bfb7fb")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "Curl de biceps en predicador con mancuerna a 1 brazo":
                nombre.setText("Curl de biceps en preciador con mancuerna a 1 brazo");
                descripcion.setText("- Colocar el brazo con la mancuerna recostado en el banco predicador.\n" +
                        "\n- Descender la mancuerna de manera controlada y subir de la misma manera sin despegar el brazo del banco predicador\n ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20predicador%20con%20mancuernas%2F20210306_112830.jpg?alt=media&token=26ffbcca-7507-4ad6-af69-cb8b0c2f099e")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20predicador%20con%20mancuernas%2F20210306_112830.jpg?alt=media&token=26ffbcca-7507-4ad6-af69-cb8b0c2f099e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20predicador%20con%20mancuernas%2F20210306_112832.jpg?alt=media&token=612a7572-1e2c-4145-9897-d430dfcb0b72")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20predicador%20con%20mancuernas%2F20210306_112834.jpg?alt=media&token=c968f4fa-a132-4861-b6f3-5ebe1cea2882")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "Curl martillo con cuerda":
                nombre.setText("Curl martillo con cuerda");
                descripcion.setText("- De pie, coger la cuerda con ambas manos mientras se mantiene un agarre neutro, posteriormente flexionar ambos brazos al mismo tiempo llevando la cuerda hacia tu torso, posteriormente extender los brazos hasta la posición inicial, mantenerse siempre en una posición recta. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20cuerda%2F20210131_104945.jpg?alt=media&token=c95025b2-4ad6-4c8a-a98e-ab59fc775ed4")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20cuerda%2F20210131_104945.jpg?alt=media&token=c95025b2-4ad6-4c8a-a98e-ab59fc775ed4")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20cuerda%2F20210131_104948.jpg?alt=media&token=067d2853-afc8-4153-a2ea-ced6d9e7440a")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20cuerda%2F20210131_104950.jpg?alt=media&token=4a66bc51-e51c-44b4-a9fe-77f702f7b88a")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "Curl predicador con barra z":
                nombre.setText("Curl predicador con barra z");
                descripcion.setText("- Sentado en el banco predicador o Scott, coger la barra z con un agarre a la anchura de los hombros y en supinación. \n" +
                        "\n- Realizar una flexión de bíceps llevando la barra hacia tu barbilla.\n" +
                        "\n- Una vez contraído completamente los bíceps, descender de manera controlada. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20predicador%20con%20barra%20z%2F20210303_120223.jpg?alt=media&token=44795f93-92f8-4184-ac4d-1441d0d6bfba")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20predicador%20con%20barra%20z%2F20210303_120223.jpg?alt=media&token=44795f93-92f8-4184-ac4d-1441d0d6bfba")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20predicador%20con%20barra%20z%2F20210303_120224.jpg?alt=media&token=39a615fc-fcdc-4f23-a676-1b417cf439c9")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20predicador%20con%20barra%20z%2F20210303_120226.jpg?alt=media&token=0fb392d5-9219-4a39-870f-47674d9f4738")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "Curl spider con barra":
                nombre.setText("Curl spider con barra ");
                descripcion.setText("- Cogiendo la barra y acostado boca abajo en un banco con un poco de inclinación \n" +
                        "\n- Contraer los bíceps, llevando la barra hacia arriba dejando todo lo posible los hombros en una misma posición neutral \n" +
                        "\n- Descender de manera controlada a la posición inicial\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20barra%2F20210310_114727.jpg?alt=media&token=12a5c309-6ca0-4075-aed4-fa6809a3970d")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20barra%2F20210310_114727.jpg?alt=media&token=12a5c309-6ca0-4075-aed4-fa6809a3970d")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20barra%2F20210310_114726.jpg?alt=media&token=5a07fa45-3597-492c-bc24-d5b0d4f26bf3")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20barra%2F20210310_114725.jpg?alt=media&token=351c3add-a23d-4886-a883-6385aaaac4f1")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "Curl martillo con mancuernas":
                nombre.setText("Curl martillo con mancuernas");
                descripcion.setText("- De pie, coger ambas mancuernas con un agarre neutro.\n" +
                        "\n- Flexionar los brazos manteniendo el agarre neutro, además de mantener los hombros en una misma posición neutra, hasta llevar las mancuernas los más cercano a tu torso. \n" +
                        "\n- Posteriormente extender de nuevo los brazos hasta regresar a la posición inicial. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20mancuernas%2F20210131_105601.jpg?alt=media&token=8a850676-ba1d-47ce-b699-cde95d3deb84")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20mancuernas%2F20210131_105601.jpg?alt=media&token=8a850676-ba1d-47ce-b699-cde95d3deb84")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20mancuernas%2F20210131_105538.jpg?alt=media&token=8baeafb7-15c2-4561-ae9d-2ae96fad3627")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20mancuernas%2F20210131_105535.jpg?alt=media&token=755313e9-1b5f-4978-a93e-0877a2014486")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "Curl spider con mancuernas":
                nombre.setText("Curl spider con mancuernas");
                descripcion.setText("- Cogiendo las mancuernas y acostado boca abajo en un banco con un poco de inclinación. \n" +
                        "\n- Contraer los bíceps, llevando las mancuernas hacia arriba dejando todo lo posible los hombros en una misma posición neutral. \n" +
                        "\n- Descender de manera controlada a la posición inicial.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20mancuernas%2F20210303_113055.jpg?alt=media&token=1f6afb9b-b6c2-4a93-a8fa-f4aeda02c94b")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20mancuernas%2F20210303_113055.jpg?alt=media&token=1f6afb9b-b6c2-4a93-a8fa-f4aeda02c94b")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20mancuernas%2F20210303_113056.jpg?alt=media&token=5345fbf5-cd74-41b4-a2b3-53c8376ceb27")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20mancuernas%2F20210303_113052.jpg?alt=media&token=47e0564e-f136-49f2-818c-985f0baa3437")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            //CALENTAMIENTO

            case "rotacióndemuñecas":
                nombre.setText("Rotación de muñecas");
                descripcion.setText("- Rotar las muñecas una y otra vez en su propio eje.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20mu%C3%B1ecas%2F20211210_111931.jpg?alt=media&token=1cf374a5-cd2f-43b4-b050-895cb19983a6")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20mu%C3%B1ecas%2F20211210_111931.jpg?alt=media&token=1cf374a5-cd2f-43b4-b050-895cb19983a6")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20mu%C3%B1ecas%2F20211210_111932(0).jpg?alt=media&token=d2f871ca-d0c8-43b5-8d49-e65b3e9e2e57")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20mu%C3%B1ecas%2F20211210_111932.jpg?alt=media&token=5b46c789-6664-4c15-a0a4-3d17ac8db023")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;


            case "Mountainclimberstretchdynamic":
                nombre.setText("Mountain climber stretch dynamic");
                descripcion.setText("- En el suelo, colocarse como se muestra en las imagenes.\n" +
                        "\n- LLevar una pierna por delante y de perfil como se muestra.\n" +
                        "\n- Posteriormente regresar y realizar con la siguiente pierna el mismo movimiento.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fmountain%20climber%20stretch%20dynamic%2F20211210_112013.jpg?alt=media&token=d78da0f9-e228-48c0-8d9a-bda3ee2b1e62")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fmountain%20climber%20stretch%20dynamic%2F20211210_112013.jpg?alt=media&token=d78da0f9-e228-48c0-8d9a-bda3ee2b1e62")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fmountain%20climber%20stretch%20dynamic%2F20211210_112010.jpg?alt=media&token=0c5937b5-b916-453c-b312-e7426e3d9ae8")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fmountain%20climber%20stretch%20dynamic%2F20211210_112016.jpg?alt=media&token=251e0537-7a1a-4ea3-bd61-674d697b5f6f")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            case "gobletsquat":
                nombre.setText("Goblet squat");
                descripcion.setText("- Sostener la mancuerna con ambas manos de manera como se muestra en la imagen y a la altura del pecho. \n" +
                        "\n- Separar las piernas un poco más de la anchura de los hombros. \n" +
                        "\n- Realizar una sentadilla estilo sumo, mientras se mantiene la mancuerna en la misma posición.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgoblet%20squat%2F20211210_111423.jpg?alt=media&token=cd38ccb1-1164-4add-b5ec-cef741eaa2d2")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgoblet%20squat%2F20211210_111423.jpg?alt=media&token=cd38ccb1-1164-4add-b5ec-cef741eaa2d2")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgoblet%20squat%2F20211210_111425.jpg?alt=media&token=5c8741a2-38ed-4766-9c2d-6c09c2da392f")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgoblet%20squat%2F20211210_111428.jpg?alt=media&token=a8cb7d1d-d535-4868-b03b-f443a1e70a87")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            case "deadbugs":
                nombre.setText("Dead bugs");
                descripcion.setText("- Acostado boca arriba en el suelo, acercar extremidades opuestas y posteriormente realizar con las siguientes extremidades.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fdead%20bugs%2Fdead0.jpg?alt=media&token=8e9ec1f3-2a82-404a-9ee7-55ca9a7f34f7")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fdead%20bugs%2Fdead0.jpg?alt=media&token=8e9ec1f3-2a82-404a-9ee7-55ca9a7f34f7")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fdead%20bugs%2Fdead1.jpg?alt=media&token=7d7cdd3b-1d9d-48cc-876d-166d00ba8e14")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fdead%20bugs%2Fdead2.jpg?alt=media&token=7490789c-854c-435a-8c4e-5c31609af78f")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "cubanpress":
                nombre.setText("Cuban press");
                descripcion.setText("- Coger 2 mancuernas ligeras, como se muestra en la imagen. \n" +
                        "\n- Inspirar y levantar las mancuernas hasta al pecho como se muestra en la imagen, posteriormente levantarlas de manera paralela al suelo y manteniendo el hombro en la misma posición.\n" +
                        "\n- Y realizar un press llevando las mancuernas hasta arriba, regresar de manera controlada y repetir. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fcuban%20press%2F20211210_111527.jpg?alt=media&token=c55723ca-8209-49b4-b515-c14b6c8beca2")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fcuban%20press%2F20211210_111527.jpg?alt=media&token=c55723ca-8209-49b4-b515-c14b6c8beca2")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fcuban%20press%2F20211210_111530.jpg?alt=media&token=08933cdf-77e7-485c-bbcd-a46e3445f963")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fcuban%20press%2F20211210_111532.jpg?alt=media&token=c26970f7-9d71-41c7-8fda-631312678a8c")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;


            case "tallkneelinggluteactivation":
                nombre.setText("Tall kneeling glute activation");
                descripcion.setText("- De rodillas, sosteniendo la mancuerna a la altura del pecho como se muestra en la imagen.\n" +
                        "\n- Sentarse en las mismas piernas y levantarse, contrayendo los gluteos hasta la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Ftall%20kneeling%20glute%20activation%2F20211210_111820.jpg?alt=media&token=a720491e-6df2-4045-a64f-a98b2eac5b8f")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Ftall%20kneeling%20glute%20activation%2F20211210_111820.jpg?alt=media&token=a720491e-6df2-4045-a64f-a98b2eac5b8f")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Ftall%20kneeling%20glute%20activation%2F20211210_111817.jpg?alt=media&token=42b85c77-cf3c-471c-88f4-b7003f65d793")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Ftall%20kneeling%20glute%20activation%2F20211210_111815.jpg?alt=media&token=f846794f-17fa-42ef-8929-1b346311e242")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            case "Rotaciónexternadehombroconmancuernaspegadoalcuerpo":
                nombre.setText("Rotación externa de hombro con mancuernas pegado al cuerpo");
                descripcion.setText("- Con los brazos pegados al cuerpo y sosteniendo las mancuernas manteniendo el brazo con un angulo de 90 grados.\n" +
                        "\n- Realizar una rotación externa como se muestra en a imagen.\n" +
                        "\n- Regresar a la posición inicial y repetir.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20externa%20de%20hombro%20con%20mancuerna%20pegado%20al%20cuerpo%2FIMG_0319.jpg?alt=media&token=919bb474-ebda-4b05-8042-3f6fd0e1794a")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20externa%20de%20hombro%20con%20mancuerna%20pegado%20al%20cuerpo%2FIMG_0319.jpg?alt=media&token=919bb474-ebda-4b05-8042-3f6fd0e1794a")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20externa%20de%20hombro%20con%20mancuerna%20pegado%20al%20cuerpo%2FIMG_0320.jpg?alt=media&token=da779121-8e4d-4f57-9cbb-c006a2996023")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20externa%20de%20hombro%20con%20mancuerna%20pegado%20al%20cuerpo%2FIMG_0321.jpg?alt=media&token=3f9e4fda-ae04-4ccc-ab03-920cf317227d")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            case "Rotaciónexternadehombroconcablepegadoalcuerpo":
                nombre.setText("Rotación externa de hombro con cable pegado al cuerpo");
                descripcion.setText("- Con los brazos pegados al cuerpo y sosteniendo el cable a una altura media de la polea y manteniendo el brazo con un angulo de 90 grados.\n" +
                        "\n- Realizar una rotación externa como se muestra en a imagen.\n" +
                        "\n- Regresar a la posición inicial y repetir.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fcable%20shoulder%20extensions%2F20211210_112232.jpg?alt=media&token=0e94b8e5-9633-46ae-b91a-701584731fb0")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fcable%20shoulder%20extensions%2F20211210_112232.jpg?alt=media&token=0e94b8e5-9633-46ae-b91a-701584731fb0")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fcable%20shoulder%20extensions%2F20211210_112233.jpg?alt=media&token=5650b9b9-b746-41ac-9a92-7a59b8b402b6")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fcable%20shoulder%20extensions%2F20211210_112235.jpg?alt=media&token=4d8fe01c-5b48-4bf5-93b8-abe01cff19cf")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "birddogs":
                nombre.setText("Bird dogs");
                descripcion.setText("- En el suelo arrodillado y con las manos en el suelo.\n" +
                        "\n- Tocar con un brazo la rodilla contraria como se muestra en la imagen.\n" +
                        "\n- Repetir con las otras extremidades.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbird%20dogs%2F20211210_111108.jpg?alt=media&token=3213739f-bfc0-4a4f-9426-324cb2c94c36")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbird%20dogs%2F20211210_111105.jpg?alt=media&token=5263811c-63ca-45d7-ba11-30fe44abb552")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbird%20dogs%2F20211210_111111.jpg?alt=media&token=2f377ec1-4660-4ca7-8a1b-799e07001780")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbird%20dogs%2F20211210_111108.jpg?alt=media&token=3213739f-bfc0-4a4f-9426-324cb2c94c36")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "bearcrawlshouldertouch":
                nombre.setText("Bear crawl shoulder touch");
                descripcion.setText("- Sosteniendo tu peso corporal en el suelo con las manos y las puntas de tus pies." +
                        "\n- Tocar con una mano el hombro contrario mientras mantienes la tensión en el resto del cuerpo." +
                        "\n- Realizar lo mismo con el otro hombro.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbear%20crawl%20shoulder%20touch%2F20211210_111316.jpg?alt=media&token=43967e98-1672-4b8a-a508-1d3dfd0b6843")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbear%20crawl%20shoulder%20touch%2F20211210_111316.jpg?alt=media&token=43967e98-1672-4b8a-a508-1d3dfd0b6843")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbear%20crawl%20shoulder%20touch%2F20211210_111312.jpg?alt=media&token=22455212-489d-4cf0-b678-549f9f16f6ea")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbear%20crawl%20shoulder%20touch%2F20211210_111319.jpg?alt=media&token=371d718b-b5e3-4c26-9c68-60ba7e61b789")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;
            case "Aducciones de hombro":
                nombre.setText("Aducciones de hombro");
                descripcion.setText("- Cruzando y abriendo los brazos de manera controlada");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Faducciones%20de%20hombro%2F20210131_102756.jpg?alt=media&token=92b87167-04fe-432a-bd7e-c5039b37137e")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Faducciones%20de%20hombro%2F20210131_102756.jpg?alt=media&token=92b87167-04fe-432a-bd7e-c5039b37137e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Faducciones%20de%20hombro%2F20210131_102758.jpg?alt=media&token=8e8117a1-ae56-4232-9a7d-109826fe9833")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Faducciones%20de%20hombro%2F20210131_102756.jpg?alt=media&token=92b87167-04fe-432a-bd7e-c5039b37137e")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;
            case "Balanceo de piernas":
                nombre.setText("Balanceo de piernas");
                descripcion.setText("- Elevando la pierna hacia enfrente y hacia atrás controladamente");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbalanceo%20de%20pierna%2F20210131_102225.jpg?alt=media&token=95d21739-0f94-44b9-adff-7b6d6fb6dbeb")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbalanceo%20de%20pierna%2F20210131_102225.jpg?alt=media&token=95d21739-0f94-44b9-adff-7b6d6fb6dbeb")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbalanceo%20de%20pierna%2F20210131_102221.jpg?alt=media&token=5c18296d-d556-443d-a5a7-16624b046cf0")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbalanceo%20de%20pierna%2F20210131_102225.jpg?alt=media&token=95d21739-0f94-44b9-adff-7b6d6fb6dbeb")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;
            case "Bicicleta":
                nombre.setText("Bicicleta");
                descripcion.setText("- Pedalear para empezar a entrar en calor");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbicicleta%2F20210131_113831.jpg?alt=media&token=44720334-2bdc-49ac-be00-f776c6b6080d")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbicicleta%2F20210131_113831.jpg?alt=media&token=44720334-2bdc-49ac-be00-f776c6b6080d")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbicicleta%2F20210131_113847%5B1%5D.jpg?alt=media&token=ad32a807-4eba-4b2b-a1b7-2636480fa199")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fbicicleta%2F20210131_113831.jpg?alt=media&token=44720334-2bdc-49ac-be00-f776c6b6080d")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "Desplantes sin peso":
                nombre.setText("Desplantes sin peso");
                descripcion.setText("- Realizando desplantes sin peso de manera controlada y relajada ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fdesplantes%20sin%20peso%2F20210131_102443.jpg?alt=media&token=78171aa7-7601-43e4-a809-5fb241eade18")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fdesplantes%20sin%20peso%2F20210131_102443.jpg?alt=media&token=78171aa7-7601-43e4-a809-5fb241eade18")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fdesplantes%20sin%20peso%2F20210131_102449.jpg?alt=media&token=695a261f-d094-4fbb-8d2a-e56acdb81ca0")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fdesplantes%20sin%20peso%2F20210131_102443.jpg?alt=media&token=78171aa7-7601-43e4-a809-5fb241eade18")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "Elevación de piernas acostada":
                nombre.setText("Elevación de piernas acostada");
                descripcion.setText("- Elevando la pierna hacia enfrente y hacia atrás controladamente mientras se encuentra acostado boca arriba. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Felevaci%C3%B3n%20de%20pierna%20acostado%2F20210131_102352.jpg?alt=media&token=956a9835-8211-447a-87b8-ccc89afa716e")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Felevaci%C3%B3n%20de%20pierna%20acostado%2F20210131_102352.jpg?alt=media&token=956a9835-8211-447a-87b8-ccc89afa716e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Felevaci%C3%B3n%20de%20pierna%20acostado%2F20210131_102355.jpg?alt=media&token=e049123b-c3d6-45ad-a486-5b1c3500c1d4")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Felevaci%C3%B3n%20de%20pierna%20acostado%2F20210131_102358.jpg?alt=media&token=f3e31cc9-f9d1-4819-af22-a3e6858adc84")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "Gatos-Camello":
                nombre.setText("Gato-Camello");
                descripcion.setText("- Extendiendo y arqueando la espalda de manera controlada. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgatos-camello%2F20210131_102558.jpg?alt=media&token=a3063a35-0d14-4724-9e3a-c96fa06cab8f")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgatos-camello%2F20210131_102558.jpg?alt=media&token=a3063a35-0d14-4724-9e3a-c96fa06cab8f")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgatos-camello%2F20210131_102604.jpg?alt=media&token=a1f319f5-d842-42ac-ab93-9ab19937b3bf")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgatos-camello%2F20210131_102608.jpg?alt=media&token=bcebfca3-f7e9-4ce8-9403-dc414e937118")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "Puentes acostada":
                nombre.setText("Puentes acostada");
                descripcion.setText("- Elevando la pelvis y bajando de manera controlada. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fpuentes%20acostado%2F20210131_102311.jpg?alt=media&token=98a0a220-05c6-41d4-b928-954458922bae")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fpuentes%20acostado%2F20210131_102311.jpg?alt=media&token=98a0a220-05c6-41d4-b928-954458922bae")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fpuentes%20acostado%2F20210131_102317.jpg?alt=media&token=288e0826-6acd-4163-b93b-c7003416c68e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fpuentes%20acostado%2F20210131_102311.jpg?alt=media&token=98a0a220-05c6-41d4-b928-954458922bae")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "Rotación de hombro":
                nombre.setText("Rotación de hombro");
                descripcion.setText("- Rotando cada hombro de manera controlada. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20hombro%2F20210131_102728.jpg?alt=media&token=9cae59f4-6db4-418b-89c5-1c3cd5903889")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20hombro%2F20210131_102728.jpg?alt=media&token=9cae59f4-6db4-418b-89c5-1c3cd5903889")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20hombro%2F20210131_102729.jpg?alt=media&token=81648f3b-4dc6-41a9-aec4-2b4184963732")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20hombro%2F20210131_102731.jpg?alt=media&token=f2567083-f710-487a-861c-0fe72e6be6ef")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "Rotación de hombros con brazos extendidos":
                nombre.setText("Rotación de hombros con brazos extendidos");
                descripcion.setText("- Rotando cada hombro con los brazos extendidos. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20hombro%20con%20brazos%20extendidos%2F20210131_102916.jpg?alt=media&token=7b67fcc1-9d32-4dcb-b4f4-c7f5a53a7365")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20hombro%20con%20brazos%20extendidos%2F20210131_102916.jpg?alt=media&token=7b67fcc1-9d32-4dcb-b4f4-c7f5a53a7365")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20hombro%20con%20brazos%20extendidos%2F20210131_102918.jpg?alt=media&token=76dcffbd-da68-4f50-83fd-d175aa408177")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20hombro%20con%20brazos%20extendidos%2F20210131_102920.jpg?alt=media&token=80c65006-b7cc-45b0-bfac-d1356a530a81")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;
            case "Rotación de tobillos":
                nombre.setText("Rotación de tobillos");
                descripcion.setText("- Rotando tobillos. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20tobillos%2F20210131_102126.jpg?alt=media&token=d47f750b-be23-46a9-af54-5157870d44a3")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20tobillos%2F20210131_102126.jpg?alt=media&token=d47f750b-be23-46a9-af54-5157870d44a3")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20tobillos%2F20210131_102140.jpg?alt=media&token=7dc133bd-5039-49f4-b5e7-48116afdd70b")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Frotaci%C3%B3n%20de%20tobillos%2F20210131_102143.jpg?alt=media&token=ab53bfb9-caf0-471e-bcde-29f859981573")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            //CUADRICEPS





            case "sentadillasmith":
                nombre.setText("Sentadilla smith");
                descripcion.setText("- Colocarse por debajo de la barra smith, recargandola en los trapecios y parte superior de los hombros.\n" +
                        "\n- Colocar los pies a la altura de los hombros o un poco mas abierto, siempre manteniendo una posición comoda.\n" +
                        "\n- Inhalar y realizar una sentadilla profunda de manera controlada." +
                        "\n- Subir, exhalar y repetir.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135925.jpg?alt=media&token=fa24ab90-9d23-41ad-a986-9203640e41c0")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135925.jpg?alt=media&token=fa24ab90-9d23-41ad-a986-9203640e41c0")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135921.jpg?alt=media&token=fb3bb36d-1b98-4903-81c6-703dafde7c4c")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135922.jpg?alt=media&token=ddd7e42b-797b-4103-a384-0b9208546141")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;

            case "sentadillafrontal":
                nombre.setText("Sentadilla frontal");
                descripcion.setText("- Colocar la barra en la parte superior del pecho y en la parte frontal de los hombros.\n" +
                        "\n- Mantener la vista hacia enfrente durante todo el movimiento, al igual que mantener la espalda recta todo el movimiento.\n" +
                        "\n- Inhalar y realizar una sentadilla profunda. " +
                        "\n- Subir, exhalar y repetir, mantiendo siempre la posición correcta de la barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%2FIMG_0349.jpg?alt=media&token=560936a6-7abc-4936-86ff-b5c68cb28bd8")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%2FIMG_0349.jpg?alt=media&token=560936a6-7abc-4936-86ff-b5c68cb28bd8")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%2FIMG_0348.jpg?alt=media&token=eeac3383-c54d-42de-bb86-759180ad8b87")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%2FIMG_0347.jpg?alt=media&token=257a95fe-9f3d-45e5-af92-eafb7c7a87ee")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "sentadillabulgaraconmancuernas":
                nombre.setText("Sentadilla bulgara con mancuernas");
                descripcion.setText("- Sostener la mancuerna, levantar un pie sobre un banco como se muestra en la imagen.\n" +
                        "\n- Mantener la espalda recta y bajar con la otra pierna realizando el gesto de una sentadilla.\n" +
                        "\n- Mantener el equilibrio en todo momento, regresar a la posición inicial y repetir.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112855.jpg?alt=media&token=0b7e1e1d-d473-4545-a76b-0c72d578e786")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112855.jpg?alt=media&token=0b7e1e1d-d473-4545-a76b-0c72d578e786")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112828(0).jpg?alt=media&token=2f452373-80a9-4db0-a410-e1af9ac66b84")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112831.jpg?alt=media&token=273285a7-7376-4960-a28b-252e1ae4236a")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "sentadillaa90gradosensmith":
                nombre.setText("Sentadilla a 90 grados en smith");
                descripcion.setText("- Colocarse por debajo de la barra smith, recargandola en los trapecios y parte superior de los hombros.\n" +
                        "\n- Colocar los pies a la altura de los hombros o un poco mas abierto, siempre manteniendo una posición comoda.\n" +
                        "\n- Inhalar y realizar una sentadilla a 90 grados de manera controlada.\n" +
                        "\n- Mantener la tensión en las piernas, subir, exhalar y repetir. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20a%2090%20grados%20en%20smith%2FIMG_0335.jpg?alt=media&token=5afcce2b-f18c-4b5c-9d96-549b8753f568")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20a%2090%20grados%20en%20smith%2FIMG_0335.jpg?alt=media&token=5afcce2b-f18c-4b5c-9d96-549b8753f568")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20a%2090%20grados%20en%20smith%2FIMG_0336.jpg?alt=media&token=3165f1ee-e606-4ceb-b50b-d89842a2d47e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20a%2090%20grados%20en%20smith%2FIMG_0338.jpg?alt=media&token=5a256969-7282-4b20-a9f4-e6801d322f68")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "Prensaa1pierna":
                nombre.setText("Prensa a una pierna");
                descripcion.setText("- En la prensa, colocar la espalda siempre bien apoyada en el banco, pies medianamente separados.\n" +
                        "\n- Inspirar, desbloquear la prensa y flexionar solo una rodilla mientras se mantiene la otra rodilla abajo o sin movimiento dependiendo de la prensa utilizada.\n" +
                        "\n- Mantener el control del movimiento durante todo el ejercicio, regresar, exhalar y repetir con la siguiente pierna.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112523.jpg?alt=media&token=0c3359f6-a9a7-4847-9154-4921fc723588")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112523.jpg?alt=media&token=0c3359f6-a9a7-4847-9154-4921fc723588")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112527.jpg?alt=media&token=dae2ecfe-99e3-4b63-b945-f6d9c45c9bd7")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112525.jpg?alt=media&token=9288507d-1f03-4147-b0d4-b89d491dbc60")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "extensionesdecuadricepsenmaquina":
                nombre.setText("Extensiones de cuadriceps en máquina");
                descripcion.setText("- Sentado en la máquina, manos agarrando el asiento y a espalda bien apoyada.\n" +
                        "\n- Rodillas flexionadas y tobilos colocados debajo de lo cojines.\n" +
                        "\n- Inspirar y efectuar una extensión de rodillas hasta la horizontal.\n" +
                        "\n- Expirar al final del movimiento y regresar.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111306.jpg?alt=media&token=c9db309b-3685-4acd-8c73-dde1b1cff287")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111306.jpg?alt=media&token=c9db309b-3685-4acd-8c73-dde1b1cff287")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111309.jpg?alt=media&token=9657de9a-af9b-4afa-9ff8-b62103330109")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111311.jpg?alt=media&token=fbafd51a-6f5b-48a2-a252-40a61c84f09d")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "desplantesconmancuernas":
                nombre.setText("Desplantes con mancuernas");
                descripcion.setText("- De pie, piernas ligeramente separadas sosteniendo las mancuernas con los brazos\n" +
                        "\n- Inspirar y efectuar un desplante o zancada hacia adelante manteniendo el tronco lo más recto posible\n" +
                        "\n- Durante la zancada, el muslo desplazado hacia adelante debe estabilizarse en la horizontal o ligeramente por debajo\n" +
                        "\n- Regresar a la posición inicial, espirar y repetir posteriormente con la otra pierna\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fdesplantes%20con%20mancuernas%2F20210131_112939.jpg?alt=media&token=b8eb47dd-146e-4cf0-9396-940cb52187af")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fdesplantes%20con%20mancuernas%2F20210131_112939.jpg?alt=media&token=b8eb47dd-146e-4cf0-9396-940cb52187af")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fdesplantes%20con%20mancuernas%2F20210131_112944.jpg?alt=media&token=a5365cff-be8c-4201-accc-1de45a2d0b41")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fdesplantes%20con%20mancuernas%2F20210131_112942.jpg?alt=media&token=2b6b25b6-e5c6-4057-be69-bd2cad0c2af6")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "prensa1pierna":
                nombre.setText("Prensa a 1 pierna");
                descripcion.setText("- Colocar la espalda en el respaldo bien apoyada, pies medianamente separados\n" +
                        "\n- Inspirar, desbloquear la seguridad de la máquina y flexionar una rodilla al máximo hasta llevar el muslo sobre las costillas de la caja torácica\n" +
                        "\n- Volver a la posición inicial expirando al final del movimiento\n" +
                        "\n- Repetir este movimiento posteriormente con la otra pierna. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112523.jpg?alt=media&token=0c3359f6-a9a7-4847-9154-4921fc723588")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112523.jpg?alt=media&token=0c3359f6-a9a7-4847-9154-4921fc723588")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112527.jpg?alt=media&token=dae2ecfe-99e3-4b63-b945-f6d9c45c9bd7")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112525.jpg?alt=media&token=9288507d-1f03-4147-b0d4-b89d491dbc60")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "prensa45grados":
                nombre.setText("Prensa a 45 grados");
                descripcion.setText("- Colocar la espalda en el respaldo bien apoyada, pies medianamente separados\n" +
                        "\n- Inspirar, desbloquear la seguridad de la máquina y flexionar una rodilla al máximo hasta llevar el muslo sobre las costillas de la caja torácica\n" +
                        "\n- Volver a la posición inicial expirando al final del movimiento\n" +
                        "\n- Repetir este movimiento posteriormente con la otra pierna. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115040.jpg?alt=media&token=65ec5bee-2f01-4f1f-b4b5-82a03c73da9b")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115040.jpg?alt=media&token=65ec5bee-2f01-4f1f-b4b5-82a03c73da9b")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115036.jpg?alt=media&token=dfaa3758-e8ad-4242-af30-e2ca093bae5e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115038.jpg?alt=media&token=f8264fd9-f7e9-440b-8557-00aac5fec37d")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "prensahorizontalenmaquina":
                nombre.setText("Prensa horizontal en máquina");
                descripcion.setText("- Colocar la espalda en el respaldo bien apoyada, pies medianamente separados\n" +
                        "\n- Inspirar, desbloquear la seguridad de la máquina\n" +
                        "\n- Flexionar las rodillas al máximo hasta llevar los muslos sobre las costillas de la caja torácica\n" +
                        "\n- Volver a la posición inicial expirando al final del movimiento. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20horizontal%20en%20maquina%2F20210202_115704.jpg?alt=media&token=4658afbe-4e22-4deb-b6cf-b2aed18410d4")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20horizontal%20en%20maquina%2F20210202_115704.jpg?alt=media&token=4658afbe-4e22-4deb-b6cf-b2aed18410d4")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20horizontal%20en%20maquina%2F20210202_115703.jpg?alt=media&token=76e551d3-75ce-49c4-a7b5-a0c6e8e1205c")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20horizontal%20en%20maquina%2F20210202_115703.jpg?alt=media&token=76e551d3-75ce-49c4-a7b5-a0c6e8e1205c")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "sentadillaconbarra":
                nombre.setText("Sentadilla con barra");
                descripcion.setText("- Deslizarse por debajo de la barra y situarse sobre los trapecios, un poco más alta que los deltoides posteriores\n" +
                        "\n- Coger la barra con las manos con una separación que te permita estar cómodo y tirar ligeramente los codos hacia atrás. \n" +
                        "\n- Dar un par de pasos hacia atrás y separar los pies a una distancia aproximadamente igual a la anchura de los hombros, bajar controladamente y sin curvar la espalda. \n" +
                        "\n- Cuando los fémur alcancen la horizontal o la rebasan ligeramente,  efectuar una extensión de rodillas enderezando el tronco para recuperar la posición inicial\n" +
                        "\n- Espirar al final del movimiento. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20con%20barra%2F20210206_111048.jpg?alt=media&token=cc565d95-aadc-49be-93cc-98088b251875")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20con%20barra%2F20210206_111048.jpg?alt=media&token=cc565d95-aadc-49be-93cc-98088b251875")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20con%20barra%2F20210206_111050.jpg?alt=media&token=c9894902-b205-4c12-8616-ca73d343d5bc")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20con%20barra%2F20210206_111054.jpg?alt=media&token=7bb9cf31-7d1f-46b9-aef2-3f92d0d662aa")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;
            case "sentadillaenmaquinaperfecta":
                nombre.setText("Sentadilla en maquina perfecta");
                descripcion.setText("- Espalda apoyada completamente con el respaldo de la máquina y hombros fijados en los cojines de la máquina\n" +
                        "\n- Desbloquear los seguros de la máquina. Inspirar y bajar de una manera controlada hasta rebasar ligeramente los 90° con tus piernas\n" +
                        "\n- Posteriormente regresar a la posición inicial y espirar al final del movimiento.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20en%20maquina%20perfecta%2F20210204_120331.jpg?alt=media&token=54cfbaa7-79d4-41bb-a1de-1103ed879085")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20en%20maquina%20perfecta%2F20210204_120331.jpg?alt=media&token=54cfbaa7-79d4-41bb-a1de-1103ed879085")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20en%20maquina%20perfecta%2F20210204_120330.jpg?alt=media&token=01398ab0-226f-4017-9ba5-23a7ec0816bd")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20en%20maquina%20perfecta%2F20210204_120342.jpg?alt=media&token=30659f89-9cf0-4183-97f8-1022479b30ab")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "sentadillafrontalmancuernas":
                nombre.setText("Sentadilla frontal con mancuernas");
                descripcion.setText("- De pie, con los pies separados una distancia aproximadamente igual a la anchura de los hombros\n" +
                        "\n- Mancuernas cogidas con las manos apoyadas sobre la parte alta de los músculos pectorales y sobre los deltoides frontales\n" +
                        "\n- Realizar una inspiración profunda, contraer el abdomen y flexionar las rodillas hasta que alcancen la horizontal\n" +
                        "\n- Regresar a la posición inicial, espirar al final del movimiento\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113029.jpg?alt=media&token=6f01baa8-b1bd-48a0-af0b-e0f12af112db")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113029.jpg?alt=media&token=6f01baa8-b1bd-48a0-af0b-e0f12af112db")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113030.jpg?alt=media&token=bbb919f7-5497-4101-a1d8-725bb6ee208d")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113031.jpg?alt=media&token=b7055a35-bb96-4797-a082-7fb395bbfee3")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            case "sentadillafrontalensmith":
                nombre.setText("Sentadilla frontal en smith");
                descripcion.setText("- Colocar la barra smith en la parte superior del pecho y en la parte frontal de los hombros.\n" +
                        "\n- Mantener la vista hacia enfrente durante todo el movimiento, al igual que mantener la espalda recta todo el movimiento.\n" +
                        "\n- Inhalar y realizar una sentadilla profunda.\n" +
                        "\n- Subir, exhalar y repetir, mantiendo siempre la posición correcta de la barra smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20en%20smith%2F20211211_135558.jpg?alt=media&token=3071291a-b7ac-4a98-9d3b-db8bcfdaf033")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20en%20smith%2F20211211_135558.jpg?alt=media&token=3071291a-b7ac-4a98-9d3b-db8bcfdaf033")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20en%20smith%2F20211211_135604.jpg?alt=media&token=3886e067-b53b-4945-9770-0e3010bfa56a")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20en%20smith%2F20211211_135602.jpg?alt=media&token=e1b0c3c9-2b6e-446a-9f05-d0651ba1da89")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            case "sentadilla":
                nombre.setText("Sentadilla");
                descripcion.setText("- De pie, con los pies separados una distancia aproximadamente igual a la anchura de los hombros\n" +
                        "\n- Mancuernas cogidas con las manos apoyadas sobre la parte alta de los músculos pectorales y sobre los deltoides frontales\n" +
                        "\n- Realizar una inspiración profunda, contraer el abdomen y flexionar las rodillas hasta que alcancen la horizontal\n" +
                        "\n- Regresar a la posición inicial, espirar al final del movimiento\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112743.jpg?alt=media&token=9b984886-1c1e-44b9-a78d-e41fb4917c7f")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112743.jpg?alt=media&token=9b984886-1c1e-44b9-a78d-e41fb4917c7f")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112746.jpg?alt=media&token=c3df4381-c6c5-4c3c-832e-3e4b3fd09983")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            //DELTOIDE FRONTAL

                        case "Push press":
                nombre.setText("Push press");
                descripcion.setText("- Apoyar la barra en la parte frontal de los hombros y cogiendo la barra con las manos ligeramente mas abiertas que la anchura de lo hombros.\n" +
                        "\n- Realizar una pequeña flexión de rodillas para obtener impulso y el press como se muestra en la imagen.\n" +
                        "\n- LLevando la barra completamente por arriba de la cabeza y los brazos completamente estirados. \n" +
                        "\n- Regresar con cuidado a la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpush%20press%2F20211211_133414.jpg?alt=media&token=46844f4c-127e-4935-8482-6582db6ac887")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpush%20press%2F20211211_133414.jpg?alt=media&token=46844f4c-127e-4935-8482-6582db6ac887")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpush%20press%2F20211211_133415.jpg?alt=media&token=a9c6db66-5353-4197-8059-c516571414b1")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpush%20press%2F20211211_133418.jpg?alt=media&token=22afdd1a-9c3d-4c1e-8dd8-39df98392dfe")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                            break;


            case "pressmilitarensmith":
                nombre.setText("Press militar en smith");
                descripcion.setText("- Mantener la espalda completamente pegada al banco.\n" +
                        "\n- Coger la barra smith con una anchura ligeramente superior a la de los hombros.\n" +
                        "\n- Realizar el press como se muestra en la imagen, extendiendo el brazo y controlando el ejercicio en todo momento.\n" +
                        "\n- Mantener siempre la tensión en el deltoide frontal y regresar a la posición inicial de manera controlada.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20smith%2F20211211_132934.jpg?alt=media&token=94407db1-bee5-432c-8fae-1a220731e14b")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20smith%2F20211211_132934.jpg?alt=media&token=94407db1-bee5-432c-8fae-1a220731e14b")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20smith%2F20211211_132931.jpg?alt=media&token=0fbd990b-fdf7-4cc9-89fa-e4aa3fcf4526")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20smith%2F20211211_132928.jpg?alt=media&token=e6b5e09b-cb42-4ff0-864c-9509a5183561")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;


            case "pressmilitarenmaquinaagarreprono":
                nombre.setText("Press militar en máquina agarre prono");
                descripcion.setText("- Mantener la espalda completamente pegada al banco.\n" +
                        "\n- Coger el maneral con agarre prono con una anchura ligeramente superior a la de los hombros.\n" +
                        "\n- Realizar el press como se muestra en la imagen, extendiendo el brazo y controlando el ejercicio en todo momento.\n" +
                        "\n- Mantener siempre la tensión en el deltoide frontal y regresar a la posición inicial de manera controlada. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20maquina%20agarre%20prono%2F20211211_132226.jpg?alt=media&token=9e4300d1-5f77-4afc-bf57-10f289e42992")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20maquina%20agarre%20prono%2F20211211_132226.jpg?alt=media&token=9e4300d1-5f77-4afc-bf57-10f289e42992")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20maquina%20agarre%20prono%2F20211211_132213.jpg?alt=media&token=4502ed35-b7d9-46e9-b21e-897736746d97")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20maquina%20agarre%20prono%2F20211211_132215.jpg?alt=media&token=df5728a1-9469-4318-9d37-084b4b8f057d")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

                        case "pressarnold":
                nombre.setText("Press Arnold");
                descripcion.setText("- Sostener las mancuernas como se muestra en la imagen por delante de los hombros y la mano viendo hacia ti.\n" +
                        "\n- Levantar las mancuernas hasta arriba mientras rotas el hombro para realizar el press completamente.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20arnold%2F20211211_132627.jpg?alt=media&token=eda53e9d-00f2-4ba1-b902-2474a8b84ba6")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20arnold%2F20211211_132627.jpg?alt=media&token=eda53e9d-00f2-4ba1-b902-2474a8b84ba6")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20arnold%2F20211211_132630.jpg?alt=media&token=a8596703-c748-4e63-a9a8-ab72e4779860")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20arnold%2F20211211_132632.jpg?alt=media&token=0b1b8f18-712a-4c05-b0e0-0da0168133d8")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                            break;

            case "elevacionfrontalconmancuernasagarreprono":
                nombre.setText("Elevación frontal con mancuernas agarre prono");
                descripcion.setText("- Sostener las mancuernas con un agarre prono y manteniendo el brazo recto.\n" +
                        "\n- Levantar hasta la altura del hombro o ligeramente por arriba.\n" +
                        "\n- Regresar de manera controlada la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20prono%2F20211211_131540.jpg?alt=media&token=1d1a3286-d921-4fae-bf38-81cb4d0a2420")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20prono%2F20211211_131540.jpg?alt=media&token=1d1a3286-d921-4fae-bf38-81cb4d0a2420")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20prono%2F20211211_131537.jpg?alt=media&token=858c70b8-69ee-482e-aa05-4f9b944c30f6")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20prono%2F20211211_131542.jpg?alt=media&token=2d239b78-cc91-42f4-9082-5aa6c65d7269")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;

            case "elevacionfrontalconmancuernassagarreneutro":
                nombre.setText("Elevación frontal con mancuernas agarre neutro");
                descripcion.setText("- Sostener las mancuernas con un agarre neutro y manteniendo el brazo recto.\n" +
                        "\n- Levantar hasta la altura del hombro o ligeramente por arriba.\n" +
                        "\n- Regresar de manera controlada la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20neutro%2F20211211_131604.jpg?alt=media&token=0053d417-8537-4dcb-b548-c3c694b07a96")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20neutro%2F20211211_131604.jpg?alt=media&token=0053d417-8537-4dcb-b548-c3c694b07a96")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20neutro%2F20211211_131606.jpg?alt=media&token=85068c07-f1a1-4487-b2cf-09abbe4c4d44")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20neutro%2F20211211_131609.jpg?alt=media&token=cf4ebe11-fc55-4cec-8970-d1b53dbb4195")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "elevacionfrontalcondisco":
                nombre.setText("Elevación frontal con disco");
                descripcion.setText("- Sostener el disco como se muestra en la imagen y manteniendo los brazos rectos.\n" +
                        "\n- Levantar hasta la altura del hombro o ligeramente por arriba.\n" +
                        "\n- Regresar de manera controlada la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20disco%2F20211211_131726.jpg?alt=media&token=49604bbb-9920-4f7b-a67e-a1df6b5c963b")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20disco%2F20211211_131726.jpg?alt=media&token=49604bbb-9920-4f7b-a67e-a1df6b5c963b")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20disco%2F20211211_131727.jpg?alt=media&token=e031fa66-1162-4a7f-929a-1980a7dbaafe")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20disco%2F20211211_131729.jpg?alt=media&token=c2870d17-6559-437b-b8c9-f570915987a4")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            case "elevacionfrontalconcuerdaa1brazoenpoleabaja":
                nombre.setText("Elevación frontal con cuerda a 1 brazo en polea baja");
                descripcion.setText("- Sostener la cuerda con un brazo en polea baja y manteniendo el brazo recto.\n" +
                        "\n- Levantar hasta la altura del hombro o ligeramente por arriba.\n" +
                        "\n- Regresar de manera controlada la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20cuerda%20a%201%20brazo%20en%20polea%20baja%2F20211211_131930.jpg?alt=media&token=064a721b-974b-458a-83ce-793eca647450")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20cuerda%20a%201%20brazo%20en%20polea%20baja%2F20211211_131930.jpg?alt=media&token=064a721b-974b-458a-83ce-793eca647450")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20cuerda%20a%201%20brazo%20en%20polea%20baja%2F20211211_132023.jpg?alt=media&token=e264bce0-2bbf-4f14-ba95-e4ff8bd5fdaa")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20cuerda%20a%201%20brazo%20en%20polea%20baja%2F20211211_132025.jpg?alt=media&token=95b8ce8f-f9d2-4522-8142-49b5f9c5f76c")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;


            case "elevacionfrontalsupinoconmancuernas":
                nombre.setText("Elevación frontal supino con mancuernas");
                descripcion.setText("- Sostener las mancuernas con un agarre supino y manteniendo el brazo recto.\n" +
                        "\n- Levantar hasta la altura del hombro o ligeramente por arriba.\n" +
                        "\n- Regresar de manera controlada la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevacion%20frontal%20supino%20con%20mancuernas%2FIMG_0322.jpg?alt=media&token=821d7af1-4b0b-4679-8453-dc1cd8bc35c7")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevacion%20frontal%20supino%20con%20mancuernas%2FIMG_0322.jpg?alt=media&token=821d7af1-4b0b-4679-8453-dc1cd8bc35c7")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevacion%20frontal%20supino%20con%20mancuernas%2FIMG_0323.jpg?alt=media&token=8b1939dd-51d0-41bb-8b3c-3523e54fef3d")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevacion%20frontal%20supino%20con%20mancuernas%2FIMG_0324.jpg?alt=media&token=5dd18c89-36e4-4d2d-91a8-8ec99515eaec")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "elevacionesfrontalesconmancuernas":
                nombre.setText("Elevaciones frontales con mancuernas");
                descripcion.setText("- De pie, los pies ligeramente separados, las mancuernas en pronación apoyadas sobre los muslos. \n" +
                        "\n- Elevar los brazos hacia adelante hasta el nivel de la barbilla y descender de manera controlada. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaciones%20frontales%20con%20mancuernas%2F20210131_110206.jpg?alt=media&token=e402ad78-c440-4fe2-9c24-20edbde626c6")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaciones%20frontales%20con%20mancuernas%2F20210131_110206.jpg?alt=media&token=e402ad78-c440-4fe2-9c24-20edbde626c6")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaciones%20frontales%20con%20mancuernas%2F20210131_110209.jpg?alt=media&token=372f59b3-2c3d-48ab-a003-c6dbc0ac3521")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaciones%20frontales%20con%20mancuernas%2F20210131_110211.jpg?alt=media&token=d0d9503f-675a-49b7-a41f-b4b6bec5160b")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "pressenmaquinaagarreneutro":
                nombre.setText("Press en maquina agarre neutro");
                descripcion.setText("- Espalda recargada completamente en el respaldo\n" +
                        "\n -Coger el maneral de la máquina con un agarre neutro a la altura de los hombros\n" +
                        "\n- Inspirar y desarrollar hasta estirar los brazos verticalmente.\n" +
                        "\n- Espirar al final del movimiento y bajar controladamente.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20en%20maquina%20agarre%20neutro%2F20210205_115518.jpg?alt=media&token=53c0e6cc-746f-406c-a941-580436c6c340")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20en%20maquina%20agarre%20neutro%2F20210205_115518.jpg?alt=media&token=53c0e6cc-746f-406c-a941-580436c6c340")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20en%20maquina%20agarre%20neutro%2F20210205_115517.jpg?alt=media&token=f43c27ba-d6bc-4f03-be17-5fcd655b76df")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20en%20maquina%20agarre%20neutro%2F20210205_115514.jpg?alt=media&token=9f59a906-2c52-4f39-91bb-bb1ac825fdf3")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;
            case "pressmilitarconbarra":
                nombre.setText("Press militar con barra");
                descripcion.setText("- De pie, manteniendo las muñecas siempre rectas. Apoyar en la parte superior del pecho y hombros. \n" +
                        "\n- Realizar el press, estirando los brazos llevando la barra por encima de la cabeza. \n" +
                        "\n- Bajar de manera controlada hasta la parte inicial del movimiento. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20barra%2F20210310_112107.jpg?alt=media&token=5b5ebed3-b4ae-41f2-a6cd-98a93f705ac1")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20barra%2F20210310_112107.jpg?alt=media&token=5b5ebed3-b4ae-41f2-a6cd-98a93f705ac1")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20barra%2F20210310_112107(0).jpg?alt=media&token=35a06b6a-6a10-4a8a-9383-af74919f9227")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20barra%2F20210310_112109.jpg?alt=media&token=d62a5dc5-03d9-4ba1-8d58-7dcf7e3944fb")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;
            case "pressmilitarconmancuernas":
                nombre.setText("Press militar con mancuernas");
                descripcion.setText("- Coger las mancuernas y sentarse con la espada pegada al respaldo del banco \n" +
                        "\n- Realizar un press de hombros con un agarre en pronación empezando con un ángulo de 90° con respecto a tu hombro \n" +
                        "\n- Elevar las mancuernas todo el recorrido posible y descender controladamente hasta la posición inicial \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111220.jpg?alt=media&token=9dfa83e7-77cd-493a-a77c-e017675dfdbb")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111220.jpg?alt=media&token=9dfa83e7-77cd-493a-a77c-e017675dfdbb")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111218.jpg?alt=media&token=633f8448-5344-45a8-aa25-b44799182217")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111216.jpg?alt=media&token=0e0f1768-1d9f-4c39-9308-aa87eaa0ee04")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;


            //DELOITDES LATERLAES Y POSTERIORES




            case "remoalmentonconmancuernas":
                nombre.setText("Remo al mentón con mancuernas");
                descripcion.setText("- De pie, piernas ligeramente separadas mancuernas codigas en pronación.\n" +
                        "\n- Inspirar y tirar de las mancuernas por todo el cuerpo hasta una altura cercana al mentón, sin doblar las muñecas.\n" +
                        "\n- Subiendo los codos lo más alto posible, regresar de manera controlada y repetir.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20mancuernas%2F20211210_120543.jpg?alt=media&token=ca8ee1c5-d536-4a12-8ac9-85968ef85d9f")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20mancuernas%2F20211210_120543.jpg?alt=media&token=ca8ee1c5-d536-4a12-8ac9-85968ef85d9f")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20mancuernas%2F20211210_120545.jpg?alt=media&token=671a538a-3cfd-41d1-a45f-b3448436744f")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20mancuernas%2F20211210_120546.jpg?alt=media&token=c2160078-997f-46da-8464-35955cd1f23e")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "flyesinvertidoscruzados":
                nombre.setText("Flyes invertidos cruzados");
                descripcion.setText("- Coger cada cable de manera cruzada y separarse unos pocos pasos de las poleas.\n" +
                        "\n- Posteriormente colocar las poleas y los brazos a la altura de los hombros y realizar los flyes como se muestra en la imagen.\n" +
                        "\n- Mantener siempre la tensión en los deltoides posteriores y de manera controlada realizar el flyes hasta que los codos queden a la altura de los hombros y brazos siempre se mantengan semiflexionados.√" +
                        "√- Regresar lentamente a la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120041.jpg?alt=media&token=a3f479d2-49c9-4042-8e55-305a029c4d4f")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120041.jpg?alt=media&token=a3f479d2-49c9-4042-8e55-305a029c4d4f")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120045.jpg?alt=media&token=cf00ca79-e594-4964-860f-125b5553d54a")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "flyesagachados":
                nombre.setText("Flyes agachados");
                descripcion.setText("- Coger las mancuernas con un agarre en pronación y agacharse.\n" +
                        "\n- Mantener la espalda lo más recta posible y realizar los flyes como se muestra en la imagen.\n" +
                        "\n- De manera que los codos queden alineados con la parte posteriores de los hombros." +
                        "\n- Regresar de manera controlada y repetir.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20agachados%2F20211210_120450.jpg?alt=media&token=7d2f28d9-5452-43ef-8fa4-2311ab9e51a7")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20agachados%2F20211210_120450.jpg?alt=media&token=7d2f28d9-5452-43ef-8fa4-2311ab9e51a7")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20agachados%2F20211210_120452.jpg?alt=media&token=ab7deef1-6f9a-48f9-8f25-01fcf35e08f0")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20agachados%2F20211210_120455.jpg?alt=media&token=3b398377-2569-4d55-9062-fb9e2011eaf5")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            case "facepullconcuerda":
                nombre.setText("Facepull con cuerda");
                descripcion.setText("- Colocar la cuerda en una polea con un nivel alto, coger la cuerda con un agarre neutro.\n" +
                        "\n- Llevar la cuerda hacia la altura de la cara, mientras se abren los brazos como se muestra la imagen.\n" +
                        "\n- Mantener la tensión en los deltoides durante todo el movimienot.\n" +
                        "\n- Regresar y repetir.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120822.jpg?alt=media&token=608da863-55cb-4aa7-ab68-0ee05916edcf")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120822.jpg?alt=media&token=608da863-55cb-4aa7-ab68-0ee05916edcf")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120824.jpg?alt=media&token=d16f4f8e-b056-47f9-a851-2eb6f7072a4e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120826.jpg?alt=media&token=dad7d426-1561-4435-aac6-7c7cf954eb73")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            case "elevacionlateralpordetras":
                nombre.setText("Elevación lateral por detrás");
                descripcion.setText("- De pie coger el maneral en polea baja por detrás con un agarre en pronación.\n" +
                        "\n- Mantenerse unos pasos alejado de la polea baja y posteriormente realizar una elevación lateral hasta que el maneral y el codo queden alineados con el hombro.\n" +
                        "\n- Bajar controladamente el brazo y repetir.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115738.jpg?alt=media&token=f7b449d3-20a0-4c74-a560-371aace1d921")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115738.jpg?alt=media&token=f7b449d3-20a0-4c74-a560-371aace1d921")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115741.jpg?alt=media&token=92dbd2be-ac0d-4eb1-b27b-8f105d2d6249")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115743.jpg?alt=media&token=d75af285-55fc-499e-84cc-c13f86539e5c")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;


            case "elevacionlateralconmancuernaacostadoenbancoinclinado":
                nombre.setText("Elevación lateral con mancuerna acostado en banco inclinado");
                descripcion.setText("- Colocarse en un banco inclinado de manera lateral a el y coger la mancuerna.\n" +
                        "\n- Realizar una elevación lateral con la mancuerna hasta que la mancuerna y el codo queden alineados con el hombro.\n" +
                        "\n- Regresar de manera controlada a la posición inicial como se muestra en la imagen.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120225.jpg?alt=media&token=75a4b280-fd0d-4e40-8e81-083dd68613b2")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120225.jpg?alt=media&token=75a4b280-fd0d-4e40-8e81-083dd68613b2")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120227.jpg?alt=media&token=520a2319-1661-45ec-ac70-f89ade46154a")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120233.jpg?alt=media&token=a40ae582-7b39-4ccd-927b-d64da79c55b8")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            case "elevacionlaterala45gradosconmancuernas":
                nombre.setText("Elevación lateral a 45 grados con mancuernas");
                descripcion.setText("- Coger la mancuerna y colocarse con los cerca de un punto de apoyo y el resto del torso y la mancuerna a 45 grados mas alejado como se muestra en la imagen.\n" +
                        "\n- Realizar una elevación lateral hasta que el codo y la mancuerna queden a la misma altura que el hombro.\n" +
                        "\n- Descender de manera controlada y repetir.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112602.jpg?alt=media&token=aca13906-0dce-4d22-b8f9-e2b739500e3f")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112602.jpg?alt=media&token=aca13906-0dce-4d22-b8f9-e2b739500e3f")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112604.jpg?alt=media&token=24cc7ab7-90bd-4422-b57b-523d7cdbe2b1")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112606.jpg?alt=media&token=224d744f-9b85-4ea0-b50a-333667af2f9a")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            case "elevacionlateralconpoleabaja":
                nombre.setText("Elevación lateral con polea baja");
                descripcion.setText("- De pie, coger el maneral con un brazo en polea baja. \n" +
                        "\n- Realizar una elevación lateral hasta que el codo y el maneral queden paralelos al hombro.\n" +
                        "\n- Regresar de manera controlada a la posición inicial. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20polea%20baja%2F20210313_121734.jpg?alt=media&token=3b8d47ce-08a9-4a7e-ac1e-987fe7dc3d06")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20polea%20baja%2F20210313_121734.jpg?alt=media&token=3b8d47ce-08a9-4a7e-ac1e-987fe7dc3d06")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20polea%20baja%2F20210313_121733.jpg?alt=media&token=2a037307-9762-4627-9761-d0038664aac2")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20polea%20baja%2F20210313_121731.jpg?alt=media&token=5248be4d-3506-4e15-8134-f5f4e06e2c8a")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "elevacionlateralesconmancuerna":
                nombre.setText("Elevación lateral con mancuerna");
                descripcion.setText("- De pie, con las piernas ligeramente separadas, espalda bien recta y brazos paralelos al cuerpo \n" +
                        "\n- Coger las mancuernas y elevar los brazos hasta la horizontal, manteniendo los codos ligeramente flexionados\n" +
                        "\n- Regresar a la posición de partida de una manera controlada \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaciones%20laterales%20con%20mancuernas%2F20210131_105244.jpg?alt=media&token=ed1d5cf6-e489-4b50-a61a-0438853eadcc")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaciones%20laterales%20con%20mancuernas%2F20210131_105244.jpg?alt=media&token=ed1d5cf6-e489-4b50-a61a-0438853eadcc")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaciones%20laterales%20con%20mancuernas%2F20210131_105242.jpg?alt=media&token=b0efdd01-2fa4-47e9-8b28-ed2447cd1bdc")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaciones%20laterales%20con%20mancuernas%2F20210131_105249.jpg?alt=media&token=2ffa2e63-ca3c-4b91-900d-2a3b938a3932")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "flyesinvertidosenpeckdeck":
                nombre.setText("Flyes invertidos en peck deck");
                descripcion.setText("- Sentado en la máquina de frente a ella \n" +
                        "\n- Coger los mangos de la máquina con un agarre en pronación y manteniendo los codos al mismo nivel que los hombros \n" +
                        "\n- Mantener el pectoral pegado a la máquina \n" +
                        "\n- Llevar los brazos hacia atrás mientras se mantienen ligeramente semi-flexionados\n" +
                        "\n- Regresar de manera controlada a la posición inicial\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111220.jpg?alt=media&token=9dfa83e7-77cd-493a-a77c-e017675dfdbb")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111220.jpg?alt=media&token=9dfa83e7-77cd-493a-a77c-e017675dfdbb")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111218.jpg?alt=media&token=633f8448-5344-45a8-aa25-b44799182217")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111216.jpg?alt=media&token=0e0f1768-1d9f-4c39-9308-aa87eaa0ee04")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "remoalmentonconbarra":
                nombre.setText("Remo al menton con barra");
                descripcion.setText("- De pie, coger la barra a la altura de los hombros y elevar hasta la altura del pectoral, de una manera cómoda y sin doblar las muñecas.\n" +
                        "\n- Codos hacia afuera y manteniendo en línea recta el brazo.\n" +
                        "\n- Finalmente, descender controladamente.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111220.jpg?alt=media&token=9dfa83e7-77cd-493a-a77c-e017675dfdbb")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111220.jpg?alt=media&token=9dfa83e7-77cd-493a-a77c-e017675dfdbb")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111218.jpg?alt=media&token=633f8448-5344-45a8-aa25-b44799182217")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111216.jpg?alt=media&token=0e0f1768-1d9f-4c39-9308-aa87eaa0ee04")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "remoalmentonconpoleabaja":
                nombre.setText("Remo al menton con polea baja");
                descripcion.setText("- De pie, coger el maneral en polea baja, a la altura de los hombros y elevar hasta la altura del pectoral, de una manera cómoda y sin doblar las muñecas.\n" +
                        "\n- Codos hacia afuera y manteniendo en línea recta el brazo en lo posible.\n" +
                        "\n- Finalmente, descender controladamente.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem1.jpg?alt=media&token=8d592b48-92fd-4709-9995-6d2372bb3620")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem1.jpg?alt=media&token=8d592b48-92fd-4709-9995-6d2372bb3620")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem2.jpg?alt=media&token=cfc6daad-95a1-4cb3-81b5-ba6cb630c73f")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem3.jpg.jpg?alt=media&token=b302e29e-81ff-429f-9daa-56c84b18ce6d")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;


                //ESPALDA

                    case "remohorizontalsmith":
                nombre.setText("Remo horizontal smith");
                descripcion.setText("- Colocarse de manera paralela al suelo manteniendo la espalda siempre recta y coger la barra smith a una anchura ligeramente mas abierta que la de los hombros.\n" +
                        "\n- Realizar un remo llevando la barra smith hasta la parte inicial del estomago o por debajo del pecho e inhalar durante el movimiento.\n" +
                        "\n- Mantener la tensión siempre en los musculos superiores de la espalda y regresar de manera controlada, exhalar.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20en%20smith%2F20211211_135813.jpg?alt=media&token=a0a5c7ce-b7cd-470f-b255-be0825349882")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20en%20smith%2F20211211_135813.jpg?alt=media&token=a0a5c7ce-b7cd-470f-b255-be0825349882")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20en%20smith%2F20211211_135817.jpg?alt=media&token=5eb2f2fc-bd2f-47ed-8ca8-4525830751cd")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20en%20smith%2F20211211_135827.jpg?alt=media&token=4224d3f7-5719-40c8-88b4-f60630d7ddc9")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                        break;
            case "remopendlay":
                nombre.setText("Remo pendlay");
                descripcion.setText("- Con la espalda completamente paralela al suelo agarrar la barra ligeramente mas abierta que la anchura de los hombros.\n" +
                        "\n- Y los discos tocando el suelo, realizar un remo hasta que la barra toque parte del estomago. Posteriormente regresar la barra hasta que los discos toquen el suelo nuevamente.\n" +
                        "\n- Mantener la espalda recta y paralela al suelo en todo momento y repetir.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20pendlay%2F20211211_140328.jpg?alt=media&token=aa816af9-2105-42a3-9b2b-2a225a057a70")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20pendlay%2F20211211_140328.jpg?alt=media&token=aa816af9-2105-42a3-9b2b-2a225a057a70")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20pendlay%2F20211211_140452.jpg?alt=media&token=e4b7abc2-f336-4e24-b1b4-dbc59582418a")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20pendlay%2F20211211_140328.jpg?alt=media&token=aa816af9-2105-42a3-9b2b-2a225a057a70")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "remohorizontalconbarra":
                nombre.setText("Remo horizontal con barra");
                descripcion.setText("- Con la espalda completamente paralela al suelo agarrar la barra ligeramente mas abierta que la anchura de los hombros.\n" +
                        "\n- Levantar la barra, realizar un remo hasta que la barra toque parte del estomago. Posteriormente regresar la barra a la posición inicial sin tocar el suelo, manteniendo la tensión en todo momento.\n" +
                        "\n- Mantener la espalda recta y paralela al suelo en todo momento y repetir.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20con%20barra%2F20211211_140539.jpg?alt=media&token=2dcd2101-175f-47a2-912f-8e4d5e3116b8")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20con%20barra%2F20211211_140539.jpg?alt=media&token=2dcd2101-175f-47a2-912f-8e4d5e3116b8")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20con%20barra%2F20211211_140452.jpg?alt=media&token=11a3cc3d-6295-4816-afb5-92c40c947a5e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20con%20barra%2F20211211_140539.jpg?alt=media&token=2dcd2101-175f-47a2-912f-8e4d5e3116b8")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "pesomuertoconvencional":
                nombre.setText("Peso muerto convencional");
                descripcion.setText("- Flexionar las rodillas para llevar los muslos hasta la horizontal.\n" +
                        "\n- Coger la barra con los brazos estirados, manos en proporción separadas una longitud aproximadamente igual a la anchura de los hombros.\n" +
                        "\n- Inspirar, contener la respiración, contraer la banda abdominal y la región lumbar y tensar las piernas enderazando el pecho hasta alcanzar la posicipon vertical.\n" +
                        "\n- Matener la espalda recta en todo momento.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpeso%20muerto%20convencional%2F20211215_113059.jpg?alt=media&token=133437a3-a77b-4760-9231-534135382c26")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpeso%20muerto%20convencional%2F20211215_113059.jpg?alt=media&token=133437a3-a77b-4760-9231-534135382c26")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpeso%20muerto%20convencional%2F20211215_113101.jpg?alt=media&token=7f108763-7350-4694-a857-84c36211bb44")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpeso%20muerto%20convencional%2F20211215_113104.jpg?alt=media&token=31966e27-2675-4af8-982d-7a6357c5719f")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            case "jalonfrontalcerradoconpoleaalta":
                nombre.setText("Jalón frontal cerrado con polea alta");
                descripcion.setText("- Coger el maneral alto con un agarre cerrado y en supinación.\n" +
                        "\n- Mantener la tensión en las dorsales en todo momento y contraer, llevando el maneral hacia el pecho como se muestra en la imagen.\n" +
                        "\n- Posteriormente regresar de manera controlada a la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20cerrado%20con%20polea%20alta%2FIMG_0359.jpg?alt=media&token=8cb91809-ef56-4e01-b474-95b65a01b2e3")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20cerrado%20con%20polea%20alta%2FIMG_0359.jpg?alt=media&token=8cb91809-ef56-4e01-b474-95b65a01b2e3")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20cerrado%20con%20polea%20alta%2FIMG_0360.jpg?alt=media&token=81c4af17-07d2-4032-918c-0638473a70da")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20cerrado%20con%20polea%20alta%2FIMG_0361.jpg?alt=media&token=b87f8de8-fb4f-4715-ae41-b44d1e772386")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;
            case "dominadas":
                nombre.setText("Dominadas");
                descripcion.setText("- Manos separadas en pronación cogiendo la barra fija \n" +
                        "\n- Inspirar y efectuar una tracción hasta que la barbilla llegue casi a tocar la barra \n" +
                        "\n- Espirar al final del movimiento y bajar controladamente \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fdominadas%2F20210206_111211.jpg?alt=media&token=ac8c47aa-aba5-4ad8-9432-6873c804be31")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fdominadas%2F20210206_111211.jpg?alt=media&token=ac8c47aa-aba5-4ad8-9432-6873c804be31")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fdominadas%2F20210206_111210.jpg?alt=media&token=326cfd3e-3f68-49b6-a97e-3634449c32cb")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fdominadas%2F20210206_111212.jpg?alt=media&token=f386a2a6-3d86-49fe-9a54-2a3af7aed772")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "hiperextensiones":
                nombre.setText("Hiperextensiones de espalda en banco");
                descripcion.setText("- Subir al banco y anclar fijamente los pies \n" +
                        "\n- Coger el disco y colocarlo cerca del torso \n" +
                        "\n- Realizar una hiperextensión de espalda hasta quedar recto en una línea con tu propio cuerpo \n" +
                        "\n- No hiperextender excesivamente \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fhiperextensiones%20de%20espalda%20en%20banco%2F20210220_122843.jpg?alt=media&token=dd0f18df-60fc-49e9-9f77-f3b0ef912b2e")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fhiperextensiones%20de%20espalda%20en%20banco%2F20210220_122843.jpg?alt=media&token=dd0f18df-60fc-49e9-9f77-f3b0ef912b2e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fhiperextensiones%20de%20espalda%20en%20banco%2F20210220_122848.jpg?alt=media&token=4efcd165-d6fd-4da5-b8a7-aacdc157861a")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fhiperextensiones%20de%20espalda%20en%20banco%2F20210220_122848(0).jpg?alt=media&token=73814040-ec25-4e37-bc37-c216e04fb912")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "jalonfrontalconagarreabierto":
                nombre.setText("Jalón frontal con agarre abierto");
                descripcion.setText("- Sentado frente al aparato, piernas fijadas, barra cogida en pronación y manos separadas \n" +
                        "\n- Inspirar y tirar de la barra hasta la horquilla esternal, ensachando el pecho y llevando los codos hacia atrás, espirar al final del movimiento. \n" +
                        "\n- Regresar a la fase inicial del movimiento de manera controlada y manteniendo tensión en los musculos involucrados. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20agarre%20abierto%2F20210309_114747.jpg?alt=media&token=cdbcf689-639b-4e46-8420-5641c5b0fea1")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20agarre%20abierto%2F20210309_114747.jpg?alt=media&token=cdbcf689-639b-4e46-8420-5641c5b0fea1")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20agarre%20abierto%2F20210309_114757.jpg?alt=media&token=f9bb3f6d-760e-466f-83ce-2d39fb585c23")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20agarre%20abierto%2F20210309_114753.jpg?alt=media&token=22e93bd8-14bc-4d0c-9334-d6632177cd8c")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "jalonfrontalcontriangulo":
                nombre.setText("Jalón frontal con triángulo");
                descripcion.setText("- Coger el maneral triangular firmemente, sin separarse del asiento. \n" +
                        "\n- Mantener la espalda recta y realizar el jalón llevando el maneral hacia el pecho, mientras se mantiene la fuerza y tensión en los dorsales.\n" +
                        "\n- Finalmente regresar de manera controlada a la posición inicial, sin perder tensión en la espalda.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20triangulo%2F20210306_115555.jpg?alt=media&token=738deb3d-5bfe-4e7d-b42e-bc197cc34564")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20triangulo%2F20210306_115555.jpg?alt=media&token=738deb3d-5bfe-4e7d-b42e-bc197cc34564")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20triangulo%2F20210306_115551.jpg?alt=media&token=c7bcd1b3-ac35-4fb9-8b6d-2b9575d6b585")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20triangulo%2F20210306_115552.jpg?alt=media&token=1a46beab-baac-4b4e-a7d5-7d65b3bd9181")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "pulloverconbcuerda":
                nombre.setText("Pullover con cuerda");
                descripcion.setText("- Inclinarse con la espalda recta como se muestra en la imagen, formando una linea con la polea alta.\n" +
                        "\n- Sostener la cuerda con los brazos extendidos y mantener la tensión en los dorsales.\n" +
                        "\n- Posteriormente acercar la cuerda hacia la parte baja del estómago, mientras se mantiene el estímulo en la espalda, mantener los brazos semiflexionados en todo el movimiento.\n" +
                        "\n- Regresar de manera controlada a la parte inicial del movimiento. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20cuerda%2F20210309_192655.jpg?alt=media&token=65077967-f462-4761-84a2-5065cb8ad567")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20cuerda%2F20210309_192655.jpg?alt=media&token=65077967-f462-4761-84a2-5065cb8ad567")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20cuerda%2F20210309_115655.jpg?alt=media&token=1e97a463-ff16-4658-bfb8-33d7e65a5c19")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20cuerda%2F20210309_115656.jpg?alt=media&token=1ee09cd4-bbe3-4397-8b61-bd5732ff95f9")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "pulloverconmancuerna":
                nombre.setText("Pullover con mancuerna");
                descripcion.setText("- Acostado en un banco sostener la mancuerna con ambas manos como se muestra en la imagen por encima del pecho.\n" +
                        "\n- Sostener la mancuerna con los brazos extendidos y mantener la tensión en los dorsales.\n" +
                        "\n- Posteriormente realizar el pullover alejando la mancuerna del torax como se muestra en la imagen, mientras se mantiene el estímulo en la espalda, mantener los brazos semiflexionados en todo el movimiento.\n" +
                        "\n- Regresar de manera controlada a la parte inicial del movimiento. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20mancuerna%2F20211215_111955.jpg?alt=media&token=b7879112-8f50-4e30-b2a4-767a76e41843")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20mancuerna%2F20211215_111955.jpg?alt=media&token=b7879112-8f50-4e30-b2a4-767a76e41843")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20mancuerna%2F20211215_111957.jpg?alt=media&token=42236c89-fe5b-428c-a8c3-dfd90a38eab8")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20mancuerna%2F20211215_112001.jpg?alt=media&token=733de5cb-5cea-4215-99cc-f25486c7bdb7")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "remoa1manoconpoleabaja":
                nombre.setText("Remo a 1 mano con polea baja");
                descripcion.setText("- Realizar una media sentadilla de manera que se pueda quedar en una misma posición neutral \n" +
                        "\n- Coger con 1 mano el maneral\n" +
                        "\n- Inspirar y llevar el codo hacia atrás mientras se contrae la espalda\n" +
                        "\n- Llevar el maneral hacia adelante de nuevo de una manera controlada y espirar\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20a%201%20mano%20con%20polea%20baja%2F20210219_121002.jpg?alt=media&token=125ecf30-7f66-4de6-8b17-199e18fb905a")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20a%201%20mano%20con%20polea%20baja%2F20210219_121002.jpg?alt=media&token=125ecf30-7f66-4de6-8b17-199e18fb905a")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20a%201%20mano%20con%20polea%20baja%2F20210219_121003.jpg?alt=media&token=05a2ab30-572a-4d37-873f-263d58b04154")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20a%201%20mano%20con%20polea%20baja%2F20210219_121000.jpg?alt=media&token=0f10920c-75e6-4138-885e-0aa7d9774d84")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "remoconmancuernaa1brazo":
                nombre.setText("Remo con mancuerna a 1 brazo");
                descripcion.setText("- Mancuerna cogida con una mano mientras la otra mano sirve como apoyo en alguna superficie estable. \n" +
                        "\n- Mantener la espalda recta, inspirar y tirar de la mancuerna con el brazo paralelo al cuerpo, llevando el codo hacia atrás. \n" +
                        "\n- Contraer la espalda al final del movimiento y espirar. \n" +
                        "\n- Regresar a la posición inicial bajando controladamente. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20con%20mancuerna%20a%201%20brazo%2F20210131_111241.jpg?alt=media&token=fbd44174-f1a1-48ef-9582-8ff6730a38b1")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20con%20mancuerna%20a%201%20brazo%2F20210131_111241.jpg?alt=media&token=fbd44174-f1a1-48ef-9582-8ff6730a38b1")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20con%20mancuerna%20a%201%20brazo%2F20210131_111211.jpg?alt=media&token=c4158837-8114-4743-8d2f-483d2b7fd30c")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20con%20mancuerna%20a%201%20brazo%2F20210131_111215.jpg?alt=media&token=639b0747-09be-465c-aa49-2694c36d87bf")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "remoenmaquinaagarreenpronacion":
                nombre.setText("Remo en maquina agarre en pronación");
                descripcion.setText("- Pecho apoyado en la máquina y coger los manerales con un agarre en pronación.  \n" +
                        "\n- Hombros ligeramente en depresión\n" +
                        "\n- Inspirar y llevar los brazos hacia atrás mientras se realiza una pequeña contracción en la espalda. \n" +
                        "\n- Regresar lentamente a la posición inicial de una manera controlada y espirar. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20agarre%20en%20pronacion%2F20210205_114807.jpg?alt=media&token=998a8a0f-8170-4771-9dc2-9b40e163a8a1")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20agarre%20en%20pronacion%2F20210205_114807.jpg?alt=media&token=998a8a0f-8170-4771-9dc2-9b40e163a8a1")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20agarre%20en%20pronacion%2F20210205_114808.jpg?alt=media&token=e3cc93ea-1af4-4669-ac03-94d436cd2838")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20agarre%20en%20pronacion%2F20210205_114828.jpg?alt=media&token=1e436109-0721-4bee-93fd-7af17dd3e4fd")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "remoenmaquinahammer":
                nombre.setText("Remo en máquina hammer");
                descripcion.setText("- Pecho apoyado en la máquina. \n" +
                        "\n- Coger los manerales de la máquina con un agarre en supinación.\n" +
                        "\n- Inspirar y tirar con ambos brazos hacia atrás, contrayendo la espalda. \n" +
                        "\n- Regresar a la posición inicialmente controladamente y espirar. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20hammer%2F20210203_115948.jpg?alt=media&token=71981d5a-283e-405e-8150-f7dc6ee5e4b1")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20hammer%2F20210203_115948.jpg?alt=media&token=71981d5a-283e-405e-8150-f7dc6ee5e4b1")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20hammer%2F20210203_115947.jpg?alt=media&token=11da7630-45bc-447e-bbb5-6838b0ac034c")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20hammer%2F20210203_115946.jpg?alt=media&token=ccd18a99-b86b-4e61-8832-5f068da3cd93")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "remosentadoenpoleacontriangulo":
                nombre.setText("Remo sentado en polea con triangulo");
                descripcion.setText("- Sentado, coger el maneral triangular con los pies anclados. \n" +
                        "\n- Inspirar y llevar el mango triangular hasta el abdomen, de manera que los codos queden lo más atrás posible \n" +
                        "\n- Mantener los hombros con una ligera depresión\n" +
                        "\n- Contraer la espalda y después llevar el mango triangular de nuevo al frente de manera controlada\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20sentado%20en%20polea%20con%20triangulo%2F20210205_113900.jpg?alt=media&token=bf4eca3a-3aac-4029-a187-562d7a1a9a05")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20sentado%20en%20polea%20con%20triangulo%2F20210205_113900.jpg?alt=media&token=bf4eca3a-3aac-4029-a187-562d7a1a9a05")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20sentado%20en%20polea%20con%20triangulo%2F20210205_113835.jpg?alt=media&token=6318eece-9ac2-4fa4-92de-8e709ff214ef")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20sentado%20en%20polea%20con%20triangulo%2F20210205_113845.jpg?alt=media&token=b7fe38d0-55b9-4ea5-b954-d4eb9fcf6f9b")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

                //GLUTEOS Y ADUCTORES

                case "abduccionesdecaderaconpolea":
                nombre.setText("Abducciones de cadera con polea");
                descripcion.setText("- Una vez colocada la polea en los grilletes en un pie, realizar una abducción de cadera como se muestra en la imagen.\n" +
                        "\n- Alejando el pie de la polea y manteniendo la tensión en los abductores durante todo el movimiento.\n" +
                        "\n- Regresar de manera controlada y repetir con la siguiente pierna." +
                        "\n- No confundir aducción o abducción.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20con%20polea%2F20211215_111505.jpg?alt=media&token=b2be0981-5e76-44c2-a7ee-68d5a9ce105b")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20con%20polea%2F20211215_111505.jpg?alt=media&token=b2be0981-5e76-44c2-a7ee-68d5a9ce105b")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20con%20polea%2F20211215_111539.jpg?alt=media&token=b5f231e8-344f-435b-ba06-99f8245ae0f8")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20con%20polea%2F20211215_111506.jpg?alt=media&token=f0fbf440-fcb5-4999-9695-bdf92f032cf1")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                    break;

            case "aduccionesdecaderaconpolea":
                nombre.setText("Aducciones de cadera con polea");
                descripcion.setText("- Una vez colocada la polea en los grilletes en un pie, realizar una aducción como se muestra en la imagen.\n" +
                        "\n- Alejando el pie de la polea y manteniendo la tensión en los musculos aductores durante todo el movimiento.\n" +
                        "\n- Regresar de manera controlada y repetir con la siguiente pierna.\n" +
                        "\n- No confundir aducción o abducción.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111641.jpg?alt=media&token=2c6c6ec6-806a-4bca-ae11-f4284d740751")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111641.jpg?alt=media&token=2c6c6ec6-806a-4bca-ae11-f4284d740751")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111659.jpg?alt=media&token=74abeb1d-cf18-4a51-b066-c32e237ef799")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111652.jpg?alt=media&token=0053076b-978b-4884-95a1-8257be3c0ba4")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "abduccionesdecaderaenmaquina":
                nombre.setText("Abducciones de cadera en máquina");
                descripcion.setText("- Sentado en máquina, si eres principiante mantén completamente pegada la espalda al respaldo, si eres avanzado y deseas una máxima contracción en los glúteos, inclina ligeramente el tronco hacia adelante.\n" +
                        "\n- Piernas juntas y apoyadas en los cojines\n" +
                        "\n- Inspirar y separar las piernas lo más posible\n" +
                        "\n- Regresar de manera controlada y espirar  \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20en%20maquina%2F20210204_115304.jpg?alt=media&token=7006e2b7-eab1-4d7c-be99-c96474cfaaf3")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20en%20maquina%2F20210204_115304.jpg?alt=media&token=7006e2b7-eab1-4d7c-be99-c96474cfaaf3")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20en%20maquina%2F20210204_115306.jpg?alt=media&token=f072eb5e-d411-4ef7-9e8b-d23cfbd0a990")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20en%20maquina%2F20210204_115303.jpg?alt=media&token=e084e65f-c8a9-4c94-8214-da08cf419e6d")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                    break;
            case "aduccionedecaderaenmaquina":
                nombre.setText("Aducciones de cadera en máquina");
                descripcion.setText("- Con la espalda recta, realizar una aducción de cadera hasta estirar lo más posible y regresar de manera controlada. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20en%20maquina%2F20210224_120015.jpg?alt=media&token=13c4fec2-0cd4-4866-9ced-c8c795f9ad61")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20en%20maquina%2F20210224_120015.jpg?alt=media&token=13c4fec2-0cd4-4866-9ced-c8c795f9ad61")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20en%20maquina%2F20210224_120017.jpg?alt=media&token=cdb4c5fa-7621-4107-a2f2-76e74c99bb67")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20en%20maquina%2F20210224_120014.jpg?alt=media&token=10f79db9-a51a-4c7f-b345-bbf315bd89f4")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "hipthrustconbarra":
                nombre.setText("Hip Thrust con barra");
                descripcion.setText("- Con la espalda regargada fijamente en un banco y colocando la barra en la pelvias de una manera comoda.\n" +
                        "\n- Inspirar y realizar un empuje con los glutoes hacia enfrente manteniendo siempre la tensión en los gluteos y sosteniendo la barra con ambas manos.\n" +
                        "\n- Llevar la barra lo más alto posible y regresar de manera controlada a la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fhip%20thrust%20con%20barra%2F20210210_112154.jpg?alt=media&token=d710fcf2-8355-4334-bb78-d28f6bd262e9")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fhip%20thrust%20con%20barra%2F20210210_112154.jpg?alt=media&token=d710fcf2-8355-4334-bb78-d28f6bd262e9")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fhip%20thrust%20con%20barra%2F20210210_112151.jpg?alt=media&token=4ee62dc4-1073-448a-a1f2-64ed8e0eccd0")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fhip%20thrust%20con%20barra%2F20210210_112152(0).jpg?alt=media&token=bd04b0c5-7956-4fc3-bc6f-8be7b3e79d65")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "patadaparagluteoconmancuerna":
                nombre.setText("Patada para glúteo con mancuerna");
                descripcion.setText("- De rodillas sobre una pierna y la otra sosteniendo la mancuerna apoyada en ella \n" +
                        "\n- Llevar la pierna con la mancuerna hacia atrás lo más posible, mientras el resto del cuerpo mantiene la misma posición \n" +
                        "\n- Contraer el glúteo \n" +
                        "\n- Regresar controladamente \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20mancuerna%2F20210210_113918.jpg?alt=media&token=6e51f9ec-8ac4-42cd-8705-3310bc65b6b1")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20mancuerna%2F20210210_113918.jpg?alt=media&token=6e51f9ec-8ac4-42cd-8705-3310bc65b6b1")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20mancuerna%2F20210210_113919(0).jpg?alt=media&token=714faa06-0581-4935-a4dc-a8d7214671b2")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20mancuerna%2F20210210_113919.jpg?alt=media&token=9ecbd1ff-9b5e-4314-9d18-6e5ef6297ba9")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "patadaparagluteoconpolea":
                nombre.setText("Patada para glúteo con polea");
                descripcion.setText("- Con la espalda recta y casi paralela al suelo, realizar una patada hacia atrás contrayendo lo mejor posible el glúteo involucrado extendiendo la pierna. Regresar de manera controlada. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20polea%2F20210308_125722.jpg?alt=media&token=ba18cfd3-bc40-4919-b59d-7868d8b95f1c")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20polea%2F20210308_125722.jpg?alt=media&token=ba18cfd3-bc40-4919-b59d-7868d8b95f1c")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20polea%2F20210308_125720.jpg?alt=media&token=ba1c63da-db20-4f62-83e2-fd1fae20de3d")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20polea%2F20210308_125718.jpg?alt=media&token=0a3efb37-3fb0-4e36-8763-667328359769")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "patadaparagluteoenmaquina":
                nombre.setText("Patada para glúteo en máquina");
                descripcion.setText("- Tronco inclinado hacia delante, manos en los agarres de la máquinas mientras una pierna es apoyada\n" +
                        "\n- Colocar la pierna en la posición inicial para iniciar el movimiento\n" +
                        "\n- Inspirar y llevar el muslo hacia atrás lo más posible contrayendo el glúteo \n" +
                        "\n- Regresar de manera controlada y espirar \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%2F20210131_111653.jpg?alt=media&token=9cabfa60-be5c-4b5c-900e-b5c76583ff3e")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%2F20210131_111653.jpg?alt=media&token=9cabfa60-be5c-4b5c-900e-b5c76583ff3e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%2F20210131_111651.jpg?alt=media&token=b0109aa8-8142-488f-9cde-4a8dd0adf85a")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%2F20210131_111648.jpg?alt=media&token=e014fed1-f7cd-49f9-b683-3a5620b0b029")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "patadaparagluteoenmaquinadepie":
                nombre.setText("Patada para glúteo en máquina de pie");
                descripcion.setText("Tronco inclinado hacia delante, manos en los agarres de la máquinas mientras una pierna es apoyada\n" +
                        "\n- Colocar la pierna en la posición inicial para iniciar el movimiento\n" +
                        "\n- Inspirar y llevar el muslo hacia atrás lo más posible contrayendo el glúteo \n" +
                        "\n- Regresar de manera controlada y espirar \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%20de%20pie%2F20210202_123921.jpg?alt=media&token=48909b05-fe3c-4433-890f-078c8eabc283")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%20de%20pie%2F20210202_123921.jpg?alt=media&token=48909b05-fe3c-4433-890f-078c8eabc283")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%20de%20pie%2F20210202_123923.jpg?alt=media&token=4899c2ea-6b77-42da-828c-c1a385610450")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%20de%20pie%2F20210202_123925.jpg?alt=media&token=09e3e5ff-2478-4f3d-aa0c-c210a296761b")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "pesomuertotiposumoconbarra":
                nombre.setText("Peso muerto tipo sumo con barra");
                descripcion.setText("- Colocar las piernas de manera separada estilo sumo como se muestra en la imagen.\n" +
                        "\n- Mantener la espalda recta, flexionar las rodillas y coger la barra con una anchura parecida a la de los hombros.\n" +
                        "\n- Posteriormente subir la barra mientras se mantiene la espalda recta y viendo hacia enfrente, levantando el pectoral, estirando las piernas de nuevo a un estado recto pero manteniendolas abiertas como se muestra en la imagen.\n" +
                        "\n- Al mismo tiempo que la cadera realiza una ligera extensión y manteniendo la tensión en las piernas en todo momento.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20barra%2F20210210_112941.jpg?alt=media&token=74f651b9-1bb1-4b66-b897-597b0de991a4")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20barra%2F20210210_112941.jpg?alt=media&token=74f651b9-1bb1-4b66-b897-597b0de991a4")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20barra%2F20210210_112936.jpg?alt=media&token=d22bde79-215c-48f9-86bd-a04fe9dabfe0")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20barra%2F20210210_112935.jpg?alt=media&token=b2d84e57-45a6-4bf5-8a8b-8d671513cd8f")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "pesomuertotiposumoconmancuerna":
                nombre.setText("Peso muerto tipo sumo con mancuerna");
                descripcion.setText("- Colocar las piernas de manera separada estilo sumo como se muestra en la imagen.\n" +
                        "\n- Mantener la espalda recta, flexionar las rodillas y coger la barra con una anchura parecida a la de los hombros.\n" +
                        "\n- Posteriormente subir la barra mientras se mantiene la espalda recta y viendo hacia enfrente, levantando el pectoral, estirando las piernas de nuevo a un estado recto pero manteniendolas abiertas como se muestra en la imagen.\n" +
                        "\n- Al mismo tiempo que la cadera realiza una ligera extensión y manteniendo la tensión en las piernas en todo momento. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20mancuerna%2F20210131_113328.jpg?alt=media&token=8674691c-dd45-4ed3-aa06-adcd5007a495")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20mancuerna%2F20210131_113328.jpg?alt=media&token=8674691c-dd45-4ed3-aa06-adcd5007a495")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20mancuerna%2F20210131_113333.jpg?alt=media&token=c61d9751-d020-4f24-b7b7-deccdfc96cab")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20mancuerna%2F20210131_113330.jpg?alt=media&token=f79ca688-ba30-4d65-a328-ee456f27013e")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "puentea1pierna":
                nombre.setText("Puentes a 1 pierna");
                descripcion.setText("- Tumbado en el suelo, manos sosteniendo la mancuerna ligeramente sobre una pierna \n" +
                        "\n- Inspirar y separar el trasero del suelo mientras una pierna se mantiene en el aire \n" +
                        "\n- Contraer el glúteo en la parte más arriba y bajar controladamente \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20a%201%20pierna%2F20210131_113156.jpg?alt=media&token=70b2775c-790a-4692-8b92-73e0c1371dea")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20a%201%20pierna%2F20210131_113156.jpg?alt=media&token=70b2775c-790a-4692-8b92-73e0c1371dea")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20a%201%20pierna%2F20210131_113154.jpg?alt=media&token=469935c5-112c-4701-9e03-fa06fbb7f599")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20a%201%20pierna%2F20210131_113159.jpg?alt=media&token=bcabdcb0-892f-4e4a-bc08-7f696e3fce95")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "pesoconmancuerna":
                nombre.setText("Puente con mancuerna");
                descripcion.setText("- Tumbado en el suelo, manos sosteniendo la mancuerna ligeramente sobre la pelvis de una manera cómoda y que no moleste \n" +
                        "\n- Inspirar y separar el trasero del suelo\n" +
                        "\n- Contraer los glúteos en la parte más arriba y bajar controladamente \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20con%20mancuerna%2F20210131_113126.jpg?alt=media&token=89ca3148-b90f-4774-b03d-ed38ed6b2db7")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20con%20mancuerna%2F20210131_113126.jpg?alt=media&token=89ca3148-b90f-4774-b03d-ed38ed6b2db7")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20con%20mancuerna%2F20210131_113129.jpg?alt=media&token=4c7ae9ab-ba64-4462-9080-6cb7a5ff596e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20con%20mancuerna%2F20210131_113131.jpg?alt=media&token=5207ad4d-8bbc-4d2a-9ca6-6abdfdfd013f")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "sentadillasmithtiposumo":
                nombre.setText("Sentadilla smith tipo sumo");
                descripcion.setText("- Colocarse por debajo de la barra recargándose en los trapecios. Colocar las piernas como estilo sumo y bajar manteniendo la espalda recta. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fsentadilla%20Smith%20tipo%20sumo%2F20210310_114630.jpg?alt=media&token=cecefffb-209e-4c11-a87c-9529f0296d93")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fsentadilla%20Smith%20tipo%20sumo%2F20210310_114630.jpg?alt=media&token=cecefffb-209e-4c11-a87c-9529f0296d93")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fsentadilla%20Smith%20tipo%20sumo%2F20210310_114632.jpg?alt=media&token=c1ccd46b-e1c5-47d9-b281-083f621ab9fa")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fsentadilla%20Smith%20tipo%20sumo%2F20210310_114633.jpg?alt=media&token=50fb2cd4-d99a-4852-b0d6-1e379903c736")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

                //ISQUIOSURALES

            case "pesomuertoensmith":
                nombre.setText("Peso muerto en smith");
                descripcion.setText("- De pie, piernas ligeramente separadas, coger la barra smith a una anchura aproximadamente igual a la anchura de los hombros.\n" +
                        "\n- Inspirar e inclinar el tronco hacia delante manteniendo la espalda en una posición neutra y manteniendo las piernas lo más rígidas posibles mientras se mantienen ligeramente semiflexionadas\n" +
                        " \n- Regresar de manera controlada y manteniendo siempre el trabajo en las piernas.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20en%20smith%2F20211211_135501.jpg?alt=media&token=b585be15-8155-4d63-993d-84b8020e4e57")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20en%20smith%2F20211211_135501.jpg?alt=media&token=b585be15-8155-4d63-993d-84b8020e4e57")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20en%20smith%2F20211211_135439.jpg?alt=media&token=71ae6aec-573b-41ad-904e-d52436ef1f23")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20en%20smith%2F20211211_135441.jpg?alt=media&token=7788cc84-8a01-4bb4-8c6e-258a26be9a98")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "elevaciondecaderaa1pierna":
                nombre.setText("Elevación de cadera a 1 pierna");
                descripcion.setText("- Acostado en el suelo y con las piernas arriba de un banco como se muestra en la imagen.\n" +
                        "\n- Sostener un disco en la pelvis y realizar un empuje con una de las dos piernas, manteniendo la tensión en el gluteo todo momento.\n" +
                        "\n- Regresar a la posición inicial y una vez terminadas todas las repeticiones continuar con la siguiente pierna.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Felevaci%C3%B3n%20de%20cadera%20a%201%20pierna%2F20211211_135112.jpg?alt=media&token=fc1e40f5-75d3-4f83-b0de-a5d4908892b3")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Felevaci%C3%B3n%20de%20cadera%20a%201%20pierna%2F20211211_135112.jpg?alt=media&token=fc1e40f5-75d3-4f83-b0de-a5d4908892b3")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Felevaci%C3%B3n%20de%20cadera%20a%201%20pierna%2F20211211_135108.jpg?alt=media&token=8020889f-4e80-4c09-a1ce-8dca136a8784")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Felevaci%C3%B3n%20de%20cadera%20a%201%20pierna%2F20211211_135110.jpg?alt=media&token=acbc4c3f-9615-440c-bdff-28ebfc54a1ae")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "curlfemorala1piernaacostado":
                nombre.setText("Curl femoral a 1 pierna acostado");
                descripcion.setText("- Acostado boca abajo, las manos en los agarres, las piernas extendidas, tobillos ajustado en los cojines\n" +
                        "\n- Inspirar y efectuar una flexión de una sola pierna tratando de tocar el glúteo con el tobilo.\n" +
                        "\n- Espirar al final del esfuerzo.\n" +
                        "\n- Volver a la situación de partida controlando el movimiento y repetir con la siguiente pierna.\n ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20acostado%2FIMG_0330.jpg?alt=media&token=eb84b615-e5cb-4679-ae11-4467ff5c96de")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20acostado%2FIMG_0330.jpg?alt=media&token=eb84b615-e5cb-4679-ae11-4467ff5c96de")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20acostado%2FIMG_0328.jpg?alt=media&token=5970cd3b-0f96-4090-873d-7ec8f44814de")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20acostado%2FIMG_0329.jpg?alt=media&token=5d343027-f296-4d87-80af-1baf493da47f")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;


            case "curlacostadoconmancuerna":
                nombre.setText("Curl acostado con mancuerna");
                descripcion.setText("- Acostado boca abajo, las manos en los agarres, las piernas extendidas y tobillos ajustados en los cojines. " +
                        "\n- Inspirar y efecturar una flexión simultanea de las piernas intentando tocar los gluteos con los talones, espirar al final del esfuerzo. " +
                        "\n- Volver a la situación de partida controlando el movimento en todo momento");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20acostado%20con%20mancuerna%2F20210308_122429.jpg?alt=media&token=e4e33a71-9682-462d-89b2-600d1ff229ff")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20acostado%20con%20mancuerna%2F20210308_122429.jpg?alt=media&token=e4e33a71-9682-462d-89b2-600d1ff229ff")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20acostado%20con%20mancuerna%2F20210308_122432.jpg?alt=media&token=8baf1bb5-7e53-4a2c-9e27-0aae2de17754")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20acostado%20con%20mancuerna%2F20210308_122433.jpg?alt=media&token=93a79028-afb8-4b92-93d5-23cc097ca721")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "curlfemorala1piernaparado":
                nombre.setText("Curl femoral a 1 pierna parado");
                descripcion.setText("- De pie, tronco apoyado en el soporte, rodilla fijada, pierna en extensión, tobillo colocado debajo del cojín\n" +
                        "\n- Inspirar y flexionar la rodilla\n" +
                        "\n- Espirar al final del movimiento \n ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122830(0).jpg?alt=media&token=70aa1e30-89af-46af-9a9e-b3e9b805b93c")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122830(0).jpg?alt=media&token=70aa1e30-89af-46af-9a9e-b3e9b805b93c")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122852.jpg?alt=media&token=59d7e392-1aad-4c52-a71d-faf7a1224d05")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122830(0).jpg?alt=media&token=70aa1e30-89af-46af-9a9e-b3e9b805b93c")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "curlfemoralacostadoenmáquina":
                nombre.setText("Curl femoral acostado en máquina");
                descripcion.setText("- Acostado boca abajo, las manos en los agarres, las piernas extendidas, tobillos ajustado en los cojines\n" +
                        "\n- Inspirar y efectuar una flexión simultáneo de las piernas intentando tocar los glúteos con los talones\n" +
                        "\n- Espirar al final del esfuerzo\n" +
                        "\n- Volver a la situación de partida controlando el movimiento \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20acostado%20en%20maquina%2F20210202_121616.jpg?alt=media&token=7238edae-2556-4495-9760-4537aa111aca")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20acostado%20en%20maquina%2F20210202_121616.jpg?alt=media&token=7238edae-2556-4495-9760-4537aa111aca")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20acostado%20en%20maquina%2F20210202_121615.jpg?alt=media&token=92760a76-2acb-474e-8517-9de982006d25")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20acostado%20en%20maquina%2F20210202_121632.jpg?alt=media&token=7cb5375f-ee3c-4a14-bf57-ed8aa27dbcf3")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "curlsentadoenmáquinaparaisquiosurales":
                nombre.setText("Curl sentado en máquina para isquiosurales");
                descripcion.setText("- Sentado en la máquina. piernas extendidas, tobillos colocados sobre los cojines, muslos fijos, manos en los agarres\n" +
                        "\n- Inspirar y efectuar una flexión de las rodillas,\n" +
                        "\n- Espirar al final del movimiento \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20sentado%20en%20maquina%20para%20isquiosurales%2F20210131_103827.jpg?alt=media&token=9fedba7c-3e31-4dc6-baac-e8f1a0faebb4")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20sentado%20en%20maquina%20para%20isquiosurales%2F20210131_103827.jpg?alt=media&token=9fedba7c-3e31-4dc6-baac-e8f1a0faebb4")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20sentado%20en%20maquina%20para%20isquiosurales%2F20210131_103830.jpg?alt=media&token=e19eb031-35c4-4fd6-9594-51479d411f2c")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20sentado%20en%20maquina%20para%20isquiosurales%2F20210131_103833.jpg?alt=media&token=408960ec-40e6-4a2b-8fb5-8548347d77c5")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "pesomuertoa1pierna":
                nombre.setText("Peso muerto a 1 pierna");
                descripcion.setText("- Coger la mancuerna con una mano\n" +
                        "\n- Inspirar y bajar la mancuerna controladamente mientras se mantiene la espalda lo más recta posible \n" +
                        "\n- Mantener fija la pierna la cual se quiere trabajar mientras la otra se levanta \n" +
                        "\n- Regresar lentamente y espirar\n" +
                        "\n- Repetir con la siguiente pierna  \n ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20a%201%20pierna%2F20210131_113636.jpg?alt=media&token=88e89fd3-dc8c-4583-8931-4657fe12a685")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20a%201%20pierna%2F20210131_113636.jpg?alt=media&token=88e89fd3-dc8c-4583-8931-4657fe12a685")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20a%201%20pierna%2F20210131_113643.jpg?alt=media&token=d9d80d36-5fef-44f8-9a22-1e587937e13c")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20a%201%20pierna%2F20210131_113706.jpg?alt=media&token=01c3e97b-bc16-4bd3-be7e-2328716e9188")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "pesomuertoconmancuernas":
                nombre.setText("Peso muerto con mancuernas");
                descripcion.setText("- De pie, piernas ligeramente separadas, coger las mancuernas \n" +
                        "\n- Inspirar e inclinar el tronco hacia delante manteniendo la espalda en una posición neutra y manteniendo las piernas lo más rígidas posibles mientras se mantienen ligeramente semi-flexionadas\n" +
                        "\n- Regresar de manera controlada y manteniendo siempre el trabajo en las piernas \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20mancuernas%2F20210131_113532.jpg?alt=media&token=41a9181a-07e8-43aa-81eb-dc1952394128")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20mancuernas%2F20210131_113532.jpg?alt=media&token=41a9181a-07e8-43aa-81eb-dc1952394128")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20mancuernas%2F20210131_113535.jpg?alt=media&token=66f3a303-ef78-4dd9-a2e2-d3a53f8739a2")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20mancuernas%2F20210131_113529.jpg?alt=media&token=af2e3ef5-0983-418b-8ccf-94b0f39a5510")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "pesomuertoconpiernasrigidasconbarra":
                nombre.setText("Peso muerto con piernas rigidas con barra");
                descripcion.setText("- Nos mantendremos con la espada recta, el torso mirando hacia adelante, teniendo las piernas separadas a la anchura de los hombros y las rodillas ligeramente flexionadas" +
                        "\n- Mantener las rodillas quietas y bajar la barra a lo largo de la parte superior de los pies, doblando ligeramente las caderas y manteniendo la espalda recta, manteniendo la tensión en la trasera de las piernas." +
                        "\n- Subiremos, irguiendo el torso controladamente y llevando las caderas y la barra la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20piernas%20r%C3%ADgidas%20con%20barra%2F20210308_120004.jpg?alt=media&token=087a93ff-6619-49e5-958e-c8862207de38")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20piernas%20r%C3%ADgidas%20con%20barra%2F20210308_120004.jpg?alt=media&token=087a93ff-6619-49e5-958e-c8862207de38")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20piernas%20r%C3%ADgidas%20con%20barra%2F20210308_120006.jpg?alt=media&token=716ebda2-3d26-4deb-b659-6e989b8cd727")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20piernas%20r%C3%ADgidas%20con%20barra%2F20210308_120010.jpg?alt=media&token=92155ace-9f79-4981-b5ff-8f6dbe9d9783")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

                //PANTORRILLAS

            case "elevaciondetalonenprensahorizontal":
                nombre.setText("Elevación de talón en prensa horizontal");
                descripcion.setText("- Sentado en la prensa colocar los pies, en la orilla de la prensa como se muestra en la imagen.\n" +
                        "\n- Realizar una elevación de talón iniciando desde el punto más abajo que pueda llegar el pie hasta el punto más alto.\n" +
                        "\n- De esta manera dando un recorrido completo del movimiento, regresar y repetir.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20horizontal%2F20210202_115706.jpg?alt=media&token=9e0f511e-7fb6-4712-94f0-c7b21c850813")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20horizontal%2F20210202_115706.jpg?alt=media&token=9e0f511e-7fb6-4712-94f0-c7b21c850813")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20horizontal%2F20211215_111102.jpg?alt=media&token=2e8d046a-0a94-4d54-b15b-1222cdcd49ba")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20horizontal%2F20211215_111104.jpg?alt=media&token=65f55792-18ee-4e71-bfd3-68788892af40")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "elevacionesdetalonenprensa45":
                nombre.setText("Elevaciones de talón en prensa 45 grados");
                descripcion.setText("- Sentado en la prensa horizontal colocar los pies, en la orilla de la prensa como se muestra en la imagen.\n" +
                        "\n- Realizar una elevación de talón iniciando desde el punto más abajo que pueda llegar el pie hasta el punto más alto.\n" +
                        "\n- De esta manera dando un recorrido completo del movimiento, regresar y repetir. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaci%C3%B3n%20de%20tal%C3%B3n%20en%20prensa%2045%C2%B0%2FIMG_0368.jpg?alt=media&token=f11595ed-67ea-47f7-ba81-4eb2b3d15237")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaci%C3%B3n%20de%20tal%C3%B3n%20en%20prensa%2045%C2%B0%2FIMG_0368.jpg?alt=media&token=f11595ed-67ea-47f7-ba81-4eb2b3d15237")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaci%C3%B3n%20de%20tal%C3%B3n%20en%20prensa%2045%C2%B0%2FIMG_0369.jpg?alt=media&token=1f2c4ccf-7cf9-4dd2-bd92-7bab13bc3539")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaci%C3%B3n%20de%20tal%C3%B3n%20en%20prensa%2045%C2%B0%2FIMG_0368.jpg?alt=media&token=f11595ed-67ea-47f7-ba81-4eb2b3d15237")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "elevaciondetalonensentadillaperfecta":
                nombre.setText("Elevación de talón en sentadilla perfecta");
                descripcion.setText("- Con la espalda perfectamente recargada, colocar los pies, en la orilla como se muestra en la imagen.\n" +
                        "\n- Realizar una elevación de talón iniciando desde el punto más abajo que pueda llegar el pie hasta el punto más alto.\n" +
                        "\n- De esta manera dando un recorrido completo del movimiento, regresar y repetir");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20sentadilla%20perfecta%2F20211215_113305.jpg?alt=media&token=83697c2f-4b47-4c7c-9f5a-4b5375edd91c")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20sentadilla%20perfecta%2F20211215_113305.jpg?alt=media&token=83697c2f-4b47-4c7c-9f5a-4b5375edd91c")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20sentadilla%20perfecta%2F20211215_113306.jpg?alt=media&token=68cb3301-d73a-43da-8da0-45536527c026")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20sentadilla%20perfecta%2F20211215_113308.jpg?alt=media&token=8ebb1b76-9791-414a-8965-b6504b4b2d7b")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "elevacionesdelatonencosturera":
                nombre.setText("Elevaciones de talón en costurera");
                descripcion.setText("- Sentado en la máquina costurera \n" +
                        "\n- Con la punta del pie apoyada solamente, elevar los talones hasta su máximo y descender controladamente lo más posible. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20costurera%2F20210220_123440.jpg?alt=media&token=cd062256-ddbf-4651-a415-0f9f6a388697")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20costurera%2F20210220_123440.jpg?alt=media&token=cd062256-ddbf-4651-a415-0f9f6a388697")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20costurera%2F20210220_123439.jpg?alt=media&token=cd5d5a75-3dfc-46ce-8b24-1b366faa38ee")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20costurera%2F20210220_123440.jpg?alt=media&token=cd062256-ddbf-4651-a415-0f9f6a388697")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "elevacionesdetalonenprensaa1pierna":
                nombre.setText("Elevaciones de talón en prensa a 1 pierna");
                descripcion.setText("- Espalda apoyada completamente en la máquina, colocar las puntillas del pie y levantar los talones tanto como sea posible\n" +
                        "\n- Bajar los talones hacia atrás lo más posible de una manera controlada\n" +
                        "\n- Mantener las piernas rectas o ligeramente semi-flexionadas todo el movimiento y repetir. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20a%201%20pierna%2F20210215_130008.jpg?alt=media&token=5d925155-333e-4b2e-b6f4-fe706971ad0e")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20a%201%20pierna%2F20210215_130008.jpg?alt=media&token=5d925155-333e-4b2e-b6f4-fe706971ad0e")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20a%201%20pierna%2F20210215_130007.jpg?alt=media&token=aaa1ac82-8a2c-4ddf-84a2-edb0fbda4e2d")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20a%201%20pierna%2F20210215_130011.jpg?alt=media&token=e83b13ac-b619-4bdf-b3e7-ffbe0fc52758")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "elevacionesdetalonparadoconmancuerna":
                nombre.setText("Elevaciones de talón parado con mancuerna");
                descripcion.setText("- De pie coger la mancuerna, posteriormente pararse en una superficie que permita elevar y descender completamente el talón. Elevar el talón y descender de manera controlada. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20parado%20con%20mancuerna%2F20210310_120556.jpg?alt=media&token=dce0ef9f-3e06-49c7-b8e1-545885649c56")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20parado%20con%20mancuerna%2F20210310_120556.jpg?alt=media&token=dce0ef9f-3e06-49c7-b8e1-545885649c56")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20parado%20con%20mancuerna%2F20210310_120556(0).jpg?alt=media&token=8371eae9-e5c0-48ee-9ea5-908114956983")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20parado%20con%20mancuerna%2F20210310_120558.jpg?alt=media&token=3d5edaad-c045-4256-aea7-34d967faef76")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;


            //PECTORALES



            case "Press plano en smith":
                nombre.setText("Press plano en smith");
                descripcion.setText("- Estirado sobre un banco plano, pies en el suelo para asegurar la estabilidad, brazos extendidos verticalmente, manos frente a frente en pronación y sosteniendo la barra smith. Inspirar y bajar la barra hasta el nivel del pecho flexionando los codos, posteriormente regresar a la posición inicial con los brazos extendidos.\n" +
                        "\n- Cuando las manos se encuentran frente a frente, efectuar una contracción isométrica.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20plano%20en%20smith%2F20211210_115034.jpg?alt=media&token=c19ee1f7-dcab-4ea2-b3fa-97d24b951ad9")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20plano%20en%20smith%2F20211210_115034.jpg?alt=media&token=c19ee1f7-dcab-4ea2-b3fa-97d24b951ad9")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20plano%20en%20smith%2F20211210_115044.jpg?alt=media&token=33009f7a-6fc7-4126-976f-90c661d9c13c")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20plano%20en%20smith%2F20211210_115046.jpg?alt=media&token=a9b0d2be-ec51-4eab-b881-bc522bd339f5")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "presshorizontalconbarra":
                nombre.setText("Press horizontal con barra");
                descripcion.setText("- Estirado sobre un banco plano, pies en el suelo para asegurar la estabilidad, brazos extendidos verticalmente, manos frente a frente en pronación y sosteniendo la barra. Inspirar y bajar la barra hasta el nivel del pecho flexionando los codos, posteriormente regresar a la posición inicial con los brazos extendidos.\n" +
                        "\n- Cuando las manos se encuentran frente a frente, efectuar una contracción isométrica.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20con%20barra%2F20211211_133126.jpg?alt=media&token=74a03b18-089e-4038-9998-84f298d0207f")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20con%20barra%2F20211211_133126.jpg?alt=media&token=74a03b18-089e-4038-9998-84f298d0207f")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20con%20barra%2F20211211_133124.jpg?alt=media&token=4d662706-8d37-4cc3-aab8-26862f028dab")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20con%20barra%2F20211211_133126.jpg?alt=media&token=74a03b18-089e-4038-9998-84f298d0207f")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

                        case "pressinclinadoensmith":
                nombre.setText("Press inclinado en smith");
                descripcion.setText("- Recostado sobre un banco inclinado, pies en el suelo para asegurar la estabilidad, brazos extendidos verticalmente, manos frente a frente en pronación y " +
                        "\n- sosteniendo la barra smith. Inspirar y bajar la barra hasta el nivel del pecho flexionando los codos, posteriormente regresar a la posición inicial con los brazos extendidos.\n" +
                        "\n- Cuando las manos se encuentran frente a frente, efectuar una contracción isométrica.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20en%20smith%2F20211210_114919.jpg?alt=media&token=ae7cebff-6fb7-4bc5-81d6-3679a9517937")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20en%20smith%2F20211210_114919.jpg?alt=media&token=ae7cebff-6fb7-4bc5-81d6-3679a9517937")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20en%20smith%2F20211210_114922.jpg?alt=media&token=60f781cc-a6c0-4152-a7a9-41270923bb9b")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20en%20smith%2F20211210_114936.jpg?alt=media&token=c7657baa-792e-47e0-8582-63cce1afb5f6")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                            break;

                        case "pressdeclinadoconmancuernas":
                nombre.setText("Press declinado con mancuernas");
                descripcion.setText("- Estirado sobre un banco declinado, brazos extendidos verticalmente, manos frente a frente en pronación sosteniendo las mancuernas." +
                        " Inspirar y bajar la barra hasta el nivel del pecho flexionando los codos, posteriormente regresar a la posición inicial con los brazos extendidos.\n" +
                        "\n- Cuando las manos se encuentran frente a frente, efectuar una contracción isométrica.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20declinado%20con%20mancuernas%2FIMG_0308.jpg?alt=media&token=4fa254f7-3be4-4b2b-a604-5d8a2ca6de89")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20declinado%20con%20mancuernas%2FIMG_0308.jpg?alt=media&token=4fa254f7-3be4-4b2b-a604-5d8a2ca6de89")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20declinado%20con%20mancuernas%2FIMG_0306.jpg?alt=media&token=3c424aee-5768-455e-92d6-485f74387832")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20declinado%20con%20mancuernas%2FIMG_0307.jpg?alt=media&token=920f5ba2-32c5-4e5a-b08d-f04c705ef616")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                            break;
            case "lagartijas":
                nombre.setText("Lagartijas o flexiones");
                descripcion.setText("En apoyo de cara al suelo, brazos estirados, manos separadas en una longitud igual, a la anchura de los hombros, pies ligeramente separados.\n" +
                        "\n- Inspirar y flexionar los brazos para llevar la caja torácica cercadel suelo, siempre evitando curvar demasiado la región lumbar.\n" +
                        "\n- Empujar sobre el suelo hasta conseguir la extensión completa de los brazos, espirar al final del movimiento y repetir.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Flagartijas%2F20211210_115201.jpg?alt=media&token=375a0c21-c29b-4dc9-ac44-60cc8dff2bfd")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Flagartijas%2F20211210_115201.jpg?alt=media&token=375a0c21-c29b-4dc9-ac44-60cc8dff2bfd")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Flagartijas%2F20211210_115202.jpg?alt=media&token=26209733-4ac6-41f1-8e6c-13b47862dba5")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Flagartijas%2F20211210_115204.jpg?alt=media&token=ba84f404-4ac4-4bc6-93ed-7fc8ce5b8e3e")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "fondos":
                nombre.setText("Fondos");
                descripcion.setText("Apoyado sobre las barras parelalas, brazos estirados, piernas colgando.\n" +
                        "\n- Inspirar y flexionar completamente los antebrazos sobre los brazos hasta llevar el pecho a nivel de las barras.\n" +
                        "\n- Efecturar el fondo, espirar al final del movimiento y repetir.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Ffondos%2F20211210_114647.jpg?alt=media&token=8b44b3da-5ffe-4edf-9655-14381731ca98")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Ffondos%2F20211210_114647.jpg?alt=media&token=8b44b3da-5ffe-4edf-9655-14381731ca98")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Ffondos%2F20211210_114648.jpg?alt=media&token=132dc2f7-03f7-4e91-8209-1466d334bff8")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Ffondos%2F20211210_114650.jpg?alt=media&token=48053b12-28ba-4b01-bc3e-bc70b798e5a3")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;

            case "crossoverpoleabaja":
                nombre.setText("Crossover en polea baja");
                descripcion.setText("De pie, piernas ligeramente separadas, tronco un poco inclinado, brazos separados, puños cerrados y codos ligeramente flexionados. Inspirar al final de la contracción.\n" +
                        "\n- Volver a la posición inicial y repetir, como se muestra en las imágenes.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20baja%2F20211210_114549.jpg?alt=media&token=88dddd71-9d58-4421-bd9f-4f9115b30a2d")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20baja%2F20211210_114549.jpg?alt=media&token=88dddd71-9d58-4421-bd9f-4f9115b30a2d")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20baja%2F20211210_114544.jpg?alt=media&token=22bc9cf3-3788-4756-adf4-a7403c0fcbbd")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20baja%2F20211210_114546.jpg?alt=media&token=c25f7dfd-5d14-45b0-ae18-6b7a1b72b154")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;
            case "crossoverpoleaalta":
                nombre.setText("Crossover en polea alta");
                descripcion.setText("De pie, piernas ligeramente separadas, tronco un poco inclinado, brazos separados, puños cerrados y codos ligeramente flexionados. Inspirar al final de la contracción.\n" +
                        "\n- Volver a la posición inicial y repetir, como se muestra en las imágenes.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20alta%2F20211210_114340.jpg?alt=media&token=47c7cc8f-c5b2-4eeb-8c17-1c367ee0d571")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20alta%2F20211210_114340.jpg?alt=media&token=47c7cc8f-c5b2-4eeb-8c17-1c367ee0d571")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20alta%2F20211210_114341.jpg?alt=media&token=b512344d-a68a-4166-a3e2-7a53ed51fbc1")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20alta%2F20211210_114343.jpg?alt=media&token=11de1927-abef-4c49-8b37-a304f6f2fbe5")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;


            case "crossovernivelmedio":
                nombre.setText("Crossover nivel medio");
                descripcion.setText("De pie, piernas ligeramente separadas, tronco un poco inclinado, brazos separados, puños cerrados y codos ligeramente flexionados. Inspirar al final de la contracción.\n" +
                        "\n- Volver a la posición inicial y repetir, como se muestra en las imágenes.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20nivel%20medio%2F20211210_114518.jpg?alt=media&token=6f45c63c-7da2-4b58-bf98-6fc55cd9529b")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20nivel%20medio%2F20211210_114518.jpg?alt=media&token=6f45c63c-7da2-4b58-bf98-6fc55cd9529b")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20nivel%20medio%2F20211210_114520.jpg?alt=media&token=8ab43455-fade-4fdf-acfc-47b488af8db6")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20nivel%20medio%2F20211210_114521.jpg?alt=media&token=abfa285f-c3c0-41cb-961e-6ffef1bcebdb")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;
            case "aperturasenpeckdeck":
                nombre.setText("Aperturas en peck deck");
                descripcion.setText("Sentado en la máquina, brazos extendidos, separados y semiflexionados.\n" +
                        "\n- Inspirar y juntar los brazos al máximo, manteniendo la tensión siempre en el pectoral, espirar al final del movimiento y repetir.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20en%20peck%20deck%2F20211210_115417.jpg?alt=media&token=8de8c9ce-f0fd-4c16-8920-ef88c6604962")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20en%20peck%20deck%2F20211210_115417.jpg?alt=media&token=8de8c9ce-f0fd-4c16-8920-ef88c6604962")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20en%20peck%20deck%2F20211210_115419.jpg?alt=media&token=4254131d-5dc3-4e34-a7dc-aeec48ac1488")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20en%20peck%20deck%2F20211210_115421.jpg?alt=media&token=3e755220-242a-47d6-b350-da12f00ce0cc")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "aperturasconmancuernasenbancoinclinado":
                nombre.setText("Aperturas con mancuernas en banco inclinado");
                descripcion.setText("- Acostado sobre un banco estrecho para no molestar los movimientos de los hombros\n" +
                        "\n- Mancuernas cogidas con las manos, brazos extendidos o codos ligeramente flexionados para aliviar la articulación\n" +
                        "\n- Inspirar y después separar los brazos hasta la horizontal.\n" +
                        "\n- Elevar los brazos hasta la vertical expresando al mismo tiempo y provocar una pequeña contracción isométrica al final del movimiento.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20inclinado%2F20211210_113957.jpg?alt=media&token=ce3fe93c-55ef-49a2-be96-92768e165af4")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20inclinado%2F20211210_113957.jpg?alt=media&token=ce3fe93c-55ef-49a2-be96-92768e165af4")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20inclinado%2F20211210_114000.jpg?alt=media&token=cd9aaa51-bf4d-4a41-8dc2-98fc02e3df29")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20inclinado%2F20211210_114004.jpg?alt=media&token=25ecdbcf-9c21-4995-bb73-ce3fde443e07")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "aperturasconmancuernasenbancoplano":
                nombre.setText("Aperturas con mancuernas en banco plano");
                descripcion.setText("- Acostado sobre un banco estrecho para no molestar los movimientos de los hombros\n" +
                        "\n- Mancuernas cogidas con las manos, brazos extendidos o codos ligeramente flexionados para aliviar la articulación\n" +
                        "\n- Inspirar y después separar los brazos hasta la horizontal\n" +
                        "\n- Elevar los brazos hasta la vertical expresando al mismo tiempo y provocar una pequeña contracción isométrica al final del movimiento. \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20plano%2F20210131_110926.jpg?alt=media&token=77ac04b9-cb5c-43e3-be90-bca47728238d")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20plano%2F20210131_110926.jpg?alt=media&token=77ac04b9-cb5c-43e3-be90-bca47728238d")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20plano%2F20210131_110929.jpg?alt=media&token=a1ab56e2-a8b9-44d9-9262-1a978de0f460")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20plano%2F20210131_110935.jpg?alt=media&token=2fed102e-3ac9-4e3d-a8a8-f0800ae5e909")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "pressconmancuernasenbancoinclinado":
                nombre.setText("Press con mancuernas en banco inclinado");
                descripcion.setText("- Estirado sobre un banco inclinado, pies en el suelo para asegurar la estabilidad\n" +
                        "\n- Brazos extendidos verticalmente, manos frente a frente en semi-pronación y cogiendo las mancuernas.\n" +
                        "\n- Inspirar y bajar las mancuernas hasta el nivel del pecho flexionando los codos.\n" +
                        "\n- Regresar a la posición inicial de manera paralela mancuerna con mancuerna. \n" +
                        "\n- Cuando las manos se encuentran frente a frente, efectuar una contracción isométrica.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20inclinado%2F20210131_110516.jpg?alt=media&token=7f8b9290-cfba-436c-91d7-625fb87ca2d9")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20inclinado%2F20210131_110516.jpg?alt=media&token=7f8b9290-cfba-436c-91d7-625fb87ca2d9")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20inclinado%2F20210131_110514.jpg?alt=media&token=11b4850c-6470-4e95-90a5-deb17964ffb6")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20inclinado%2F20210131_110511.jpg?alt=media&token=edaf9679-310b-41fa-bdd6-b47a72e18813")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "pressconmancuernasenbancoplano":
                nombre.setText("Press con mancuernas en banco plano");
                descripcion.setText("- Estirado sobre un banco plano, pies en el suelo para asegurar la estabilidad, brazos extendidos verticalmente, manos frente a frente en semi-pronación y cogiendo las mancuernas. Inspirar y bajar las mancuernas hasta el nivel del pecho flexionando los codos, posteriormente regresar a la posición inicial de manera paralela mancuerna con mancuerna.\n" +
                        "\n- Cuando las manos se encuentran frente a frente, efectuar una contracción isométrica.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20plano%2F20210131_110719.jpg?alt=media&token=cd04d5f7-5a11-4358-85a8-5c63b759acf7")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20plano%2F20210131_110719.jpg?alt=media&token=cd04d5f7-5a11-4358-85a8-5c63b759acf7")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20plano%2F20210131_110722.jpg?alt=media&token=5501ae15-3aa6-4e04-8e6c-61d6e1573cd8")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20plano%2F20210131_110725.jpg?alt=media&token=f7db554d-30c3-4e17-b122-41132adfe259")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "pressdepectoralesenmaquinahammer":
                nombre.setText("Press con mancuernas en máquina hammer");
                descripcion.setText("-  Espalda recargada completamente en el respaldo de la máquina.\n" +
                        "\n- Coger los manerales de la máquina con un agarre en pronación. \n" +
                        "\n- Inspirar y extender los brazos\n" +
                        "\n- Realizar una pequeña contracción en los pectorales al finalizar el movimiento.\n" +
                        "\n- Espirar al final del movimiento, regresar y repetir.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20de%20pectorales%20en%20maquina%20hammer%2F20210205_112023.jpg?alt=media&token=59f3486d-abb5-49e6-8319-3081f3789efa")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20de%20pectorales%20en%20maquina%20hammer%2F20210205_112023.jpg?alt=media&token=59f3486d-abb5-49e6-8319-3081f3789efa")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20de%20pectorales%20en%20maquina%20hammer%2F20210205_112020.jpg?alt=media&token=001c88f7-d997-4d98-87ea-73044f32e86d")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20de%20pectorales%20en%20maquina%20hammer%2F20210205_112038.jpg?alt=media&token=7b4cf31d-790c-4b90-9d80-fedee2e08024")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "presshorizontalenmaquina":
                nombre.setText("Press horizontal en máquina");
                descripcion.setText("- Sentado en la máquina con la espalda bien colocada en el respaldo, coger los manerales en pronación y empujar mientras se realiza una contracción en el pectoral.\n " +
                        "\n- Posteriormente, regresar de manera controlada a la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20en%20maquina%2F20210306_114640.jpg?alt=media&token=592af745-5d25-4185-806f-5d1b5613a52b")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20en%20maquina%2F20210306_114640.jpg?alt=media&token=592af745-5d25-4185-806f-5d1b5613a52b")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20en%20maquina%2F20210306_114641.jpg?alt=media&token=a9dd7bad-1cfb-4c22-bb91-71418a89970f")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20en%20maquina%2F20210306_114643.jpg?alt=media&token=345889cf-63d5-43ea-b6fa-69d436b44b3c")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "pressinclinadoconbarra":
                nombre.setText("Press inclinado con barra");
                descripcion.setText("- Acostado sobre un banco inclinado , pies en el suelo para asegurar la estabilidad, brazos extendidos verticalmente, manos frente a frente en semi-pronación y cogiendo la barra. \n" +
                        "\n" +
                        "Inspirar y bajar la barra hasta el nivel del pecho flexionando los codos, posteriormente regresar a la posición inicial. \n" +
                        "\n" +
                        "Cuando las manos se encuentran frente a frente, efectuar una contracción isométrica.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20con%20barra%2F1.jpg?alt=media&token=edeec62c-5f3c-4dcb-9f0c-d22cc61b6e79")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20con%20barra%2F1.jpg?alt=media&token=edeec62c-5f3c-4dcb-9f0c-d22cc61b6e79")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20con%20barra%2F2.jpg?alt=media&token=2bd5132f-5430-49d4-b0df-33f2c0702b85")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20con%20barra%2F3.jpg?alt=media&token=9d6bb48d-f204-4ac2-aeaf-9c922d02389a")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;


                //TRAPECIOS

            case "paseodelgranjero":
                nombre.setText("Paseo del granjero");
                descripcion.setText("- Coger un par de mancuernas y llevarlas de un punto a otro manteniendo siempre la tensión en los musculos trapecios y con los brazos extendidos.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fpaseo%20del%20granjero%2F20211210_121737.jpg?alt=media&token=c155c355-31fd-4bfa-977d-a7729cdfc1bb")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fpaseo%20del%20granjero%2F20211210_121737.jpg?alt=media&token=c155c355-31fd-4bfa-977d-a7729cdfc1bb")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fpaseo%20del%20granjero%2F20211210_121740.jpg?alt=media&token=b6ce6f51-a478-4317-8363-44c56ba6483b")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fpaseo%20del%20granjero%2F20211210_121741.jpg?alt=media&token=7e6b4f07-f691-443d-840a-75050755b95e")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "encogimientodehombrosensmithpordetrás":
                nombre.setText("Encogimiento de hombros en smith por detrás");
                descripcion.setText("Posicionarse por delante de la barra smith como se muestra en la imagen.\n" +
                        "\n- Coger la barra smith por detrás y realizar encogimiento de hombros manteniendo siempre la tensión en los trapecios, regresar de manera controlada a la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%20por%20detr%C3%A1s%2F20211210_121231.jpg?alt=media&token=2c9a7642-b5a1-41ae-a3d0-0e0d127aa683")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%20por%20detr%C3%A1s%2F20211210_121231.jpg?alt=media&token=2c9a7642-b5a1-41ae-a3d0-0e0d127aa683")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%20por%20detr%C3%A1s%2F20211210_121229.jpg?alt=media&token=0212d310-f21b-4e7f-a4d0-885e467c52ff")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%20por%20detr%C3%A1s%2F20211210_121231.jpg?alt=media&token=2c9a7642-b5a1-41ae-a3d0-0e0d127aa683")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "encogimientodehombrosconbarrapordetrás":
                nombre.setText("Encogimiento de hombros con barra por detrás");
                descripcion.setText("Posicionarse por delante de la barra como se muestra en la imagen.\n" +
                        "\n- Coger la barra por detrás y realizar encogimiento de hombros manteniendo siempre la tensión en los trapecios, regresar de manera controlada a la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20barra%20por%20detr%C3%A1s%2F20211210_121424.jpg?alt=media&token=ffa6e82a-f0e6-46bc-8a79-e2dc86535621")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20barra%20por%20detr%C3%A1s%2F20211210_121424.jpg?alt=media&token=ffa6e82a-f0e6-46bc-8a79-e2dc86535621")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20barra%20por%20detr%C3%A1s%2F20211210_121425.jpg?alt=media&token=a0c3e606-31d7-43d1-92b2-0667fdc3c141")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20barra%20por%20detr%C3%A1s%2F20211210_121424.jpg?alt=media&token=ffa6e82a-f0e6-46bc-8a79-e2dc86535621")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "encogimientodehombroconbarrapordelante":
                nombre.setText("Encogimiento de hombro con barra por delante");
                descripcion.setText("Posicionarse por detrás de la barra como se muestra en la imagen.\n" +
                        "\n- Coger la barra por delante y realizar encogimiento de hombros manteniendo siempre la tensión en los trapecios, regresar de manera controlada a la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombro%20con%20barra%20por%20delante%2F20211210_121406.jpg?alt=media&token=dda7a570-7923-4536-9e04-90f6ae75c125")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombro%20con%20barra%20por%20delante%2F20211210_121406.jpg?alt=media&token=dda7a570-7923-4536-9e04-90f6ae75c125")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombro%20con%20barra%20por%20delante%2F20211210_121408.jpg?alt=media&token=843e16cf-f877-4258-b469-4a5861f5f943")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombro%20con%20barra%20por%20delante%2F20211210_121406.jpg?alt=media&token=dda7a570-7923-4536-9e04-90f6ae75c125")
                                        .into(switcher);
                                break;
                        }
                    }
                });


                break;
            case "encogimientodehombrosconmancuernas":
                nombre.setText("Encogimiento de hombros con mancuernas");
                descripcion.setText("- De pie, piernas ligeramente separadas, vista al frente\n" +
                        "\n- Coger las mancuernas con los brazos relajados paralelos al cuerpo y una mancuerna en cada mano\n" +
                        "\n- Encoger los hombros y relajar a continuación.\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20mancuernas%2F20211210_121543.jpg?alt=media&token=8a1dbf84-71f0-4805-9c3c-8105245f1334")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20mancuernas%2F20211210_121543.jpg?alt=media&token=8a1dbf84-71f0-4805-9c3c-8105245f1334")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20mancuernas%2F20211210_121545.jpg?alt=media&token=2d7e3c24-1a61-4cbb-938b-b8bec0156fa2")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20mancuernas%2F20211210_121543.jpg?alt=media&token=8a1dbf84-71f0-4805-9c3c-8105245f1334")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "encogimientodehombrosensmith":
                nombre.setText("Encogimiento de hombros en smith");
                descripcion.setText("- De pie, piernas ligeramente separadas, de cara a la máquina, coger la barra de la máquina smith con las manos en pronación\n" +
                        "\n- Brazos relajados, espalda bien recta y efecturar encogimientos de hombros");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%2F20210313_122555.jpg?alt=media&token=70bb69f5-f2ae-41f4-b35f-a52feb5219ae")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%2F20210313_122555.jpg?alt=media&token=70bb69f5-f2ae-41f4-b35f-a52feb5219ae")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%2F20210313_122556.jpg?alt=media&token=b4c8eda0-ddeb-4106-b317-aef34b5cfb21")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%2F20210313_122555.jpg?alt=media&token=70bb69f5-f2ae-41f4-b35f-a52feb5219ae")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;



            //TRICEPS

            case "copaconmancuerna":
                nombre.setText("Copa con mancuerna");
                descripcion.setText("Setando con la mancuerna codiga con las 2 manos por detrás de la nuca.\n" +
                        "\n- Inspirar y efectuar una extensión de los codos. Espirar al final del movimiento.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%2F20211211_133805.jpg?alt=media&token=6903e763-70f2-43bb-8a70-56609bbf26f8")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%2F20211211_133805.jpg?alt=media&token=6903e763-70f2-43bb-8a70-56609bbf26f8")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%2F20211211_133809.jpg?alt=media&token=cc8101d9-66b2-470e-82c1-36896d26c554")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%2F20211211_133811.jpg?alt=media&token=3292c999-28d4-4ba7-b9d2-c30e1f91b060")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "extensionesdetricepsenpoleaaltaconmaneralrecto":
                nombre.setText("Extensiones de tríceps en polea alta con maneral recto");
                descripcion.setText("De pie, de cara al aparato, manos en el mango, codos alineados con el cuerpo.\n" +
                        "\n- Efectuar una extensión de los codos procurando no separarlos del cuerpo. Espirar al final del movimiento. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20polea%20alta%20con%20manera%20recto%2F20211211_134005.jpg?alt=media&token=104da626-4de9-466b-9a36-03483879d077")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20polea%20alta%20con%20manera%20recto%2F20211211_134005.jpg?alt=media&token=104da626-4de9-466b-9a36-03483879d077")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20polea%20alta%20con%20manera%20recto%2F20211211_134003.jpg?alt=media&token=ac210f56-bdf3-4147-beea-bbbd918f028f")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20polea%20alta%20con%20manera%20recto%2F20211211_134008.jpg?alt=media&token=d3a079cf-e0d6-40b2-b8de-3b8c2ed75cdd")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "presscerradoconbarra":
                nombre.setText("Press cerrado con barra");
                descripcion.setText("Recostado en un banco plano, coger la barra con una agarre en pronación y cerrado como se muestra en la imagen, a la anchura del pectoral o un poco menos y ligeramente por debajo del pectoral.\n" +
                        "\n- Extender los brazos completamente manteniendo siempre la tensión en los triceps, regresar de manera controlada.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20con%20barra%2FIMG_0331.jpg?alt=media&token=c2df1ac7-bfd4-4e45-9448-3610e0568d43")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20con%20barra%2FIMG_0331.jpg?alt=media&token=c2df1ac7-bfd4-4e45-9448-3610e0568d43")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20con%20barra%2FIMG_0332.jpg?alt=media&token=393ca290-4aa7-4fa9-ba34-dcaa62f5ef46")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20con%20barra%2FIMG_0333.jpg?alt=media&token=e8337d1e-5160-400c-8923-b771369ef950")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "Press cerrado en smith":
                nombre.setText("Press cerrado en smith");
                descripcion.setText("Recostado en un banco plano, coger la barra smith con una agarre en pronación y cerrado como se muestra en la imagen, a la anchura del pectoral o un poco menos y ligeramente por debajo del pectoral.\n" +
                        "\n- Extender los brazos completamente manteniendo siempre la tensión en los triceps, regresar de manera controlada.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20en%20smith%2F20211211_134356.jpg?alt=media&token=97ae02ab-aed5-4fe5-87d9-9bb75453bcdf")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20en%20smith%2F20211211_134356.jpg?alt=media&token=97ae02ab-aed5-4fe5-87d9-9bb75453bcdf")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20en%20smith%2F20211211_134400.jpg?alt=media&token=db674121-31bf-4392-8999-089adde211ee")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20en%20smith%2F20211211_134402.jpg?alt=media&token=9a7ffe73-2ae0-4faf-b15f-28ee306c1c2a")
                                        .into(switcher);
                                break;
                        }
                    }
                });

                break;
            case "rompecraneosconbarraz":
                nombre.setText("Rompecraneos con barra z");
                descripcion.setText("Recostado en un banco plano, la barra cogida en pronación y con las muñecas rectas.\n" +
                        "\n- Inspirar y efectuar una extensión de los codos procurando no separarlos demasiado para que la barra descienda al nivel de la frente o por detrás de la cabeza.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20barra%20z%2F20211211_133609.jpg?alt=media&token=7020fc81-9390-4bb9-ad33-6d2bde320075")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20barra%20z%2F20211211_133609.jpg?alt=media&token=7020fc81-9390-4bb9-ad33-6d2bde320075")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20barra%20z%2F20211211_133610.jpg?alt=media&token=79deba83-0475-4787-84ed-a485bb4aa367")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20barra%20z%2F20211211_133613.jpg?alt=media&token=51f761d5-a7bb-4d06-9c2b-7b4c109ebdb5")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;

            case "copaconbarra":
                nombre.setText("Copa con barra");
                descripcion.setText("- Colocar la barra por detrás de la cabeza. Extender los brazos completamente por encima de la cabeza hasta contraer por completo los tríceps. Bajar lentamente. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20barra%2F20210310_113437.jpg?alt=media&token=1ba94ed0-106f-459d-ab26-f8e116594e76")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20barra%2F20210310_113437.jpg?alt=media&token=1ba94ed0-106f-459d-ab26-f8e116594e76")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20barra%2F20210310_113434.jpg?alt=media&token=2248759f-65be-4c94-951d-9a51ea67fdd0")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20barra%2F20210310_113433.jpg?alt=media&token=d3e847d6-4300-49d9-8b81-3ba9f944e795")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "copaconmancuernaa1brazo":
                nombre.setText("Copa con mancuerna a 1 brazo");
                descripcion.setText("- De pie, coger la mancuerna con 1 brazo \n" +
                        "\n- Levantarla y por detrás de la nuca, bajar la mancuerna poco a poco moviendo solo el codo y manteniendo el hombro en la misma posición\n" +
                        "\n- Elevar la mancuerna de nuevo hasta el punto inicial \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%20a%201%20brazo%2F20211211_134125.jpg?alt=media&token=6a09c03d-52d2-489d-b733-44cf1636c8db")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%20a%201%20brazo%2F20211211_134125.jpg?alt=media&token=6a09c03d-52d2-489d-b733-44cf1636c8db")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%20a%201%20brazo%2F20211211_134144.jpg?alt=media&token=90c89e4d-2c8c-45a9-b9e5-d2d01b879ddc")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%20a%201%20brazo%2F20211211_134148.jpg?alt=media&token=da45daae-a3b3-4cc5-8e3e-0eefd4573f1a")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "extensiondetricepsa1brazosupino":
                nombre.setText("Extensiones de triceps a 1 brazo con agarre supino");
                descripcion.setText("- Coger el maneral con un agarre en supinación. Mantener la espalda recta y extender el brazo hacia la parte baja del cuerpo. " +
                        "\n- Posteriormente regresar de manera controlada. Manteniendo el hombro en la misma posición durante todo el trayecto. ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20a%201%20brazo%20agarre%20supino%2F20210306_120233.jpg?alt=media&token=2d6ea963-3585-493f-8a07-d8d2b19285a9")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20a%201%20brazo%20agarre%20supino%2F20210306_120233.jpg?alt=media&token=2d6ea963-3585-493f-8a07-d8d2b19285a9")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20a%201%20brazo%20agarre%20supino%2F20210306_120231.jpg?alt=media&token=91fd5d7e-80e6-45a9-8f43-85d9258fc646")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20a%201%20brazo%20agarre%20supino%2F20210306_120236.jpg?alt=media&token=8cbdc0b6-9c3a-4e32-9a77-5aadeaef1f85")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "extensionesdetricepsconcuerda":
                nombre.setText("Extensiones de triceps con cuerda");
                descripcion.setText("- De pie, enfrente a la polea coger la cuerda por sus extremos \n" +
                        "\n- Mantener los hombros en la misma posición y extender los codos hasta su máxima contracción\n" +
                        "\n- Regresar controladamente\n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20con%20cuerda%2F20210131_104724.jpg?alt=media&token=55b86c0a-0323-4189-bbda-c3b99fddf39d")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20con%20cuerda%2F20210131_104724.jpg?alt=media&token=55b86c0a-0323-4189-bbda-c3b99fddf39d")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20con%20cuerda%2F20210131_104716.jpg?alt=media&token=15ee379e-035a-4c56-aaad-55811645d229")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20con%20cuerda%2F20210131_104718.jpg?alt=media&token=16b1f8b0-ef5a-45f5-b4de-a0d5a289ca59")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "extensionesdetricepsenmaquina":
                nombre.setText("Extensiones de triceps en máquina");
                descripcion.setText("- Sentado en la máquina y con la espalda recargada completamente \n" +
                        "\n- Apoyar los brazos en la máquina, coger las agarraderas de la máquina y extender los codos sin despegar los brazos de la máquina \n" +
                        "\n- Regresar los brazos a la posición inicial \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20maquina%2F20210131_104120.jpg?alt=media&token=46bd539b-d885-44af-b2d5-b79c5e55c440")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20maquina%2F20210131_104120.jpg?alt=media&token=46bd539b-d885-44af-b2d5-b79c5e55c440")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20maquina%2F20210131_104205.jpg?alt=media&token=6467e638-96e4-4883-897d-755fc5060e18")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20maquina%2F20210131_104124.jpg?alt=media&token=9b6efd0c-3bed-48ed-b96f-893a06879207")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "fondosenmaquina":
                nombre.setText("Fondos en máquina");
                descripcion.setText("- Sentado en la máquina y cogiendo los manerales de la máquina con ambos brazos \n" +
                        "\n- Espalda pegada al respalda y extender lo codos hasta su máxima extensión \n" +
                        "\n- Regresar a su posición inicial de manera controlada \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Ffondos%20en%20maquina%2F20210131_104418.jpg?alt=media&token=f779857a-e9d1-4d9c-9e90-ed115bf6c40a")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Ffondos%20en%20maquina%2F20210131_104418.jpg?alt=media&token=f779857a-e9d1-4d9c-9e90-ed115bf6c40a")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Ffondos%20en%20maquina%2F20210131_104420.jpg?alt=media&token=fa06e6df-d700-4c6f-b479-d14ee828105d")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Ffondos%20en%20maquina%2F20210131_104422.jpg?alt=media&token=4a2f6161-b9b0-47d0-a718-d1b4a5f02100")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "patadaparatricepsa1brazo":
                nombre.setText("Patada para triceps a 1 brazo");
                descripcion.setText("- Coger la mancuerna con 1 brazo e inclinarse hacia adelante, puede ser apoyandose en una superficie fija con el otro brazo \n" +
                        "\n- Colocar el brazo paralelamente a la altura del torso\n" +
                        "\n- Realizar una extensión del codo llevando la mancuerna hacia atrás y apretando los tríceps sin mover la posición del hombro \n" +
                        "\n- Regresar controladamente el movimiento \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20triceps%20a%201%20brazo%2F20210131_105751.jpg?alt=media&token=03b88fbf-e284-4f78-a214-0c57f97dd729")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20triceps%20a%201%20brazo%2F20210131_105751.jpg?alt=media&token=03b88fbf-e284-4f78-a214-0c57f97dd729")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20triceps%20a%201%20brazo%2F20210131_105747.jpg?alt=media&token=132e4fdb-4b52-4189-a159-f2a29b13dbec")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20triceps%20a%201%20brazo%2F20210131_105749.jpg?alt=media&token=3edb47a6-91f3-4fdd-b9ef-7ed86bcb22fc")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "patadaparatricepsconpolea":
                nombre.setText("Patada para triceps con polea");
                descripcion.setText("- Coger la polea e inclinarse hacia adelante casi de forma paralela al suelo \n" +
                        "\n- Pegar el brazo al torso y realizar una extensión de tríceps llevando la polea hacia atrás sin despegar completamente el brazo del torso \n" +
                        "\n- Contraer los tríceps en la posición final y regresar a la posición inicial de manera controlada \n");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20tr%C3%ADceps%20con%20polea%2F20210303_120300.jpg?alt=media&token=1d8770a9-334e-4b36-b39a-697280f8a989")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20tr%C3%ADceps%20con%20polea%2F20210303_120300.jpg?alt=media&token=1d8770a9-334e-4b36-b39a-697280f8a989")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20tr%C3%ADceps%20con%20polea%2F20210303_120304.jpg?alt=media&token=2d97fb1d-a1c9-4c1b-97b8-0ec4aeb74d18")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20tr%C3%ADceps%20con%20polea%2F20210303_120303.jpg?alt=media&token=c1821599-0a85-4254-b855-4e14d909d198")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;
            case "rompecraneosconmancuernas":
                nombre.setText("Rompecraneos con mancuernas");
                descripcion.setText("- Coger las mancuernas con una agarre neutro. Extender los brazos hasta que queden estirados completamente.\n " +
                        "\n- Posteriormente llevar las mancuernas paralelamente con tu frente.\n " +
                        "\n- Extender de nuevo hasta la posición inicial.");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20mancuernas%2F20210306_121025.jpg?alt=media&token=443ab4fd-91fa-42f6-b76c-e5fa5f98a988")
                        .into(switcher);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.radioButton43:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20mancuernas%2F20210306_121025.jpg?alt=media&token=443ab4fd-91fa-42f6-b76c-e5fa5f98a988")
                                        .into(switcher);
                                break;
                            case R.id.radioButton44:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20mancuernas%2F20210306_121026.jpg?alt=media&token=a41238af-4a41-4230-97a3-d968d0484d1f")
                                        .into(switcher);
                                break;
                            case R.id.radioButton57:
                                Picasso.get()
                                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20mancuernas%2F20210306_121027.jpg?alt=media&token=332ac1c8-ff42-4d26-be21-97e2c7e9aee1")
                                        .into(switcher);
                                break;
                        }
                    }
                });
                break;





        } //fin del switch case ejercicio










    }//fin del oncreate

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();

                return true;

        }

        return super.onOptionsItemSelected(item);
    }


    public void onDestroy() { super.onDestroy(); }



}
package com.korellia.korelliaclubapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ejerciciosecundario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ejerciciosecundario extends Fragment {

    View vista;
    ImageView imageView, imageView2, imageView3;
    TextView nombre, nombre2, nombre3;
    Button boton1;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ejerciciosecundario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ejerciciosecundario.
     */
    // TODO: Rename and change types and number of parameters
    public static ejerciciosecundario newInstance(String param1, String param2) {
        ejerciciosecundario fragment = new ejerciciosecundario();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_ejerciciosecundario, container, false);

        boton1 = (Button) vista.findViewById(R.id.button612);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

       //1
        imageView = (ImageView) vista.findViewById(R.id.imageView7);
        nombre = (TextView) vista.findViewById(R.id.textView110);
        //2
        imageView2 = (ImageView) vista.findViewById(R.id.imageView71);
        nombre2 = (TextView) vista.findViewById(R.id.textView1101);
        //3
        imageView3 = (ImageView) vista.findViewById(R.id.imageView72);
        nombre3 = (TextView) vista.findViewById(R.id.textView1102);

        //recupera nombre del ejercicio de la activity semanal anterior
        String ejercicios = getActivity().getIntent().getStringExtra("ej");



        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), bibliotecadeejercicios.class);
                startActivity(intent);

            }
        });




        switch (ejercicios) {

            //------------pectorales 17
            case "Press inclinado con barra":
                nombre.setText("Press inclinado con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20inclinado%2F20210131_110516.jpg?alt=media&token=7f8b9290-cfba-436c-91d7-625fb87ca2d9")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Press inclinado en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20en%20smith%2F20211210_114936.jpg?alt=media&token=c7657baa-792e-47e0-8582-63cce1afb5f6")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press horizontal con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20con%20barra%2F20211211_133124.jpg?alt=media&token=4d662706-8d37-4cc3-aab8-26862f028dab")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Press inclinado en smith":
                nombre.setText("Press inclinado con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20inclinado%2F20210131_110516.jpg?alt=media&token=7f8b9290-cfba-436c-91d7-625fb87ca2d9")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Press horizontal en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20plano%20en%20smith%2F20211210_115046.jpg?alt=media&token=a9b0d2be-ec51-4eab-b881-bc522bd339f5")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press inclinado con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20con%20barra%2F20210306_111438.jpg?alt=media&token=66760c33-7ecf-44ef-95d2-c63525c3df3c")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Press horizontal con barra":
                nombre.setText("Press horizontal con smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20plano%20en%20smith%2F20211210_115046.jpg?alt=media&token=a9b0d2be-ec51-4eab-b881-bc522bd339f5")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Press inclinado con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20con%20barra%2F20210306_111438.jpg?alt=media&token=66760c33-7ecf-44ef-95d2-c63525c3df3c")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press horizontal con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20plano%2F20210131_110719.jpg?alt=media&token=cd04d5f7-5a11-4358-85a8-5c63b759acf7")
                        .fit().centerCrop()
                        .into(imageView3);

                break;




            case "Press plano en smith":
                nombre.setText("Press inclinado en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20en%20smith%2F20211210_114936.jpg?alt=media&token=c7657baa-792e-47e0-8582-63cce1afb5f6")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Press horizontal en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20en%20maquina%2F20210306_114640.jpg?alt=media&token=592af745-5d25-4185-806f-5d1b5613a52b")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press horizontal con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20plano%2F20210131_110719.jpg?alt=media&token=cd04d5f7-5a11-4358-85a8-5c63b759acf7")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Aperturas con mancuernas en banco plano":
                nombre.setText("Aperturas con mancuernas en banco inclinado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20inclinado%2F20211210_114004.jpg?alt=media&token=25ecdbcf-9c21-4995-bb73-ce3fde443e07")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Aperturas en peck deck");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20en%20peck%20deck%2F20211210_115417.jpg?alt=media&token=8de8c9ce-f0fd-4c16-8920-ef88c6604962")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Aperturas en crossover (polea nivel medio)");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20nivel%20medio%2F20211210_114521.jpg?alt=media&token=abfa285f-c3c0-41cb-961e-6ffef1bcebdb")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Aperturas con mancuernas en banco inclinado":
                nombre.setText("Aperturas con mancuernas en banco horizontal");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20plano%2F20210131_110935.jpg?alt=media&token=2fed102e-3ac9-4e3d-a8a8-f0800ae5e909")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Aperturas en peck deck");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20en%20peck%20deck%2F20211210_115417.jpg?alt=media&token=8de8c9ce-f0fd-4c16-8920-ef88c6604962")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Aperturas en crossover (polea nivel bajo)");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20baja%2F20211210_114546.jpg?alt=media&token=c25f7dfd-5d14-45b0-ae18-6b7a1b72b154")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Aperturas en peck deck":
                nombre.setText("Aperturas con mancuernas en banco horizontal");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20plano%2F20210131_110935.jpg?alt=media&token=2fed102e-3ac9-4e3d-a8a8-f0800ae5e909")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Aperturas en crossover (polea nivel medio)");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20nivel%20medio%2F20211210_114521.jpg?alt=media&token=abfa285f-c3c0-41cb-961e-6ffef1bcebdb")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Aperturas con mancuernas en banco inclinado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20inclinado%2F20211210_114004.jpg?alt=media&token=25ecdbcf-9c21-4995-bb73-ce3fde443e07")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Fondos":
                nombre.setText("Aperturas en crossover (polea nivel alto)");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20alta%2F20211210_114343.jpg?alt=media&token=11de1927-abef-4c49-8b37-a304f6f2fbe5")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Lagartijas o flexiones");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Flagartijas%2F20211210_115202.jpg?alt=media&token=26209733-4ac6-41f1-8e6c-13b47862dba5")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Aperturas en peck deck");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20en%20peck%20deck%2F20211210_115417.jpg?alt=media&token=8de8c9ce-f0fd-4c16-8920-ef88c6604962")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Press con mancuernas en banco inclinado":
                nombre.setText("Press con mancuernas en banco horizontal");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20plano%2F20210131_110719.jpg?alt=media&token=cd04d5f7-5a11-4358-85a8-5c63b759acf7")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Press de pectorales en máquina hammer");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20de%20pectorales%20en%20maquina%20hammer%2F20210205_112023.jpg?alt=media&token=59f3486d-abb5-49e6-8319-3081f3789efa")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press inclinado en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20inclinado%20en%20smith%2F20211210_114936.jpg?alt=media&token=c7657baa-792e-47e0-8582-63cce1afb5f6")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Press de pectorales en máquina hammer":
                nombre.setText("Press horizontal en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20en%20maquina%2F20210306_114640.jpg?alt=media&token=592af745-5d25-4185-806f-5d1b5613a52b")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Fondos");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Ffondos%2F20211210_114650.jpg?alt=media&token=48053b12-28ba-4b01-bc3e-bc70b798e5a3")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press horizontal en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20plano%20en%20smith%2F20211210_115046.jpg?alt=media&token=a9b0d2be-ec51-4eab-b881-bc522bd339f5")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Press con mancuernas en banco plano":
                nombre.setText("Press horizontal con máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20en%20maquina%2F20210306_114640.jpg?alt=media&token=592af745-5d25-4185-806f-5d1b5613a52b")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Press de pectorales en máquina hammer");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20de%20pectorales%20en%20maquina%20hammer%2F20210205_112023.jpg?alt=media&token=59f3486d-abb5-49e6-8319-3081f3789efa")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press declinado con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20declinado%20con%20mancuernas%2FIMG_0308.jpg?alt=media&token=4fa254f7-3be4-4b2b-a604-5d8a2ca6de89")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Lagartijas":
                nombre.setText("Fondos");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Ffondos%2F20211210_114650.jpg?alt=media&token=48053b12-28ba-4b01-bc3e-bc70b798e5a3")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Press horizontal con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20plano%2F20210131_110719.jpg?alt=media&token=cd04d5f7-5a11-4358-85a8-5c63b759acf7")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press horizontal en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20horizontal%20en%20maquina%2F20210306_114640.jpg?alt=media&token=592af745-5d25-4185-806f-5d1b5613a52b")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Press de pectorales en maquina":
                nombre.setText("Press de pectorales en máquina hammer");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20de%20pectorales%20en%20maquina%20hammer%2F20210205_112023.jpg?alt=media&token=59f3486d-abb5-49e6-8319-3081f3789efa")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Lagartijas o flexiones");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Flagartijas%2F20211210_115202.jpg?alt=media&token=26209733-4ac6-41f1-8e6c-13b47862dba5")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press declinado con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20declinado%20con%20mancuernas%2FIMG_0308.jpg?alt=media&token=4fa254f7-3be4-4b2b-a604-5d8a2ca6de89")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Press declinado con mancuernas":
                nombre.setText("Fondos");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Ffondos%2F20211210_114650.jpg?alt=media&token=48053b12-28ba-4b01-bc3e-bc70b798e5a3")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Aperturas en crossover (polea nivel alto)");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20alta%2F20211210_114343.jpg?alt=media&token=11de1927-abef-4c49-8b37-a304f6f2fbe5")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press horizontal con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20con%20mancuernas%20en%20banco%20plano%2F20210131_110719.jpg?alt=media&token=cd04d5f7-5a11-4358-85a8-5c63b759acf7")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Aperturas en crossover (polea a nivel medio)":
                nombre.setText("Aperturas en peck deck");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20en%20peck%20deck%2F20211210_115417.jpg?alt=media&token=8de8c9ce-f0fd-4c16-8920-ef88c6604962")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Aperturas con mancuernas en banco plano");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20plano%2F20210131_110935.jpg?alt=media&token=2fed102e-3ac9-4e3d-a8a8-f0800ae5e909")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Aperturas en crossover (polea nivel bajo)");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20polea%20baja%2F20211210_114546.jpg?alt=media&token=c25f7dfd-5d14-45b0-ae18-6b7a1b72b154")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Aperturas en crossover (polea a nivel bajo)":
                nombre.setText("Aperturas con mancuernas en banco inclinado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20inclinado%2F20211210_114004.jpg?alt=media&token=25ecdbcf-9c21-4995-bb73-ce3fde443e07")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Aperturas en crossover (polea nivel medio)");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fcrossover%20nivel%20medio%2F20211210_114521.jpg?alt=media&token=abfa285f-c3c0-41cb-961e-6ffef1bcebdb")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Aperturas en peck deck");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20en%20peck%20deck%2F20211210_115417.jpg?alt=media&token=8de8c9ce-f0fd-4c16-8920-ef88c6604962")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Aperturas en crossover (polea a nivel alto)":
                nombre.setText("Aperturas con mancuernas en banco horizontal");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Faperturas%20con%20mancuernas%20en%20banco%20plano%2F20210131_110935.jpg?alt=media&token=2fed102e-3ac9-4e3d-a8a8-f0800ae5e909")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Fondos");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Ffondos%2F20211210_114650.jpg?alt=media&token=48053b12-28ba-4b01-bc3e-bc70b798e5a3")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press con mancuernas en banco declinado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpecho%2Fpress%20declinado%20con%20mancuernas%2FIMG_0308.jpg?alt=media&token=4fa254f7-3be4-4b2b-a604-5d8a2ca6de89")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


                //------------ abdomen 14



            case "Crunch abdominal en maquina":
                nombre.setText("Crunch abdominal");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121917.jpg?alt=media&token=6a7354cf-d38a-4931-ae6d-3bd5a0a6f1a1")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Crunch abdominal con cuerda en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20maquina%20con%20cuerda%2F20210203_122804.jpg?alt=media&token=5610e8cf-9d23-4185-a2d3-d29e8e1b6b10")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Crunch hincado con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112933.jpg?alt=media&token=914478f7-ce1a-4b1d-9a5d-53442fc27ef3")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Crunch abdominal en maquina con cuerda":
                nombre.setText("Crunch abdominal hincado con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112933.jpg?alt=media&token=914478f7-ce1a-4b1d-9a5d-53442fc27ef3")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Rodillo abdominal");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112445.jpg?alt=media&token=65fbc2e2-c04e-4300-af76-36ba341c3a1b")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Crunch abdominal");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121917.jpg?alt=media&token=6a7354cf-d38a-4931-ae6d-3bd5a0a6f1a1")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Rodillo abdominal":
                nombre.setText("Crunch abdominal con flexión de piernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20con%20flexi%C3%B3n%20de%20piernas%2F20211210_113340.jpg?alt=media&token=063a87c6-0413-4e4f-b103-8e1892a93987")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Crunch hincado con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112933.jpg?alt=media&token=914478f7-ce1a-4b1d-9a5d-53442fc27ef3")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Crunch abdominal en banco declinado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113144.jpg?alt=media&token=6eb25b94-4d87-47ae-b9c0-4e83c61a0472")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Crunch abdominal hincado con cuerda":
                nombre.setText("Crunch abdominal en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123642.jpg?alt=media&token=e0da9abd-59d8-4237-8a60-f8a89033a7c7")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Crunch abdominal en banco declinado con balón por detrás");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113217.jpg?alt=media&token=a6ad17e7-d218-41c7-9412-b26ffd74fc38")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevación de piernas acostado en banco");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854(0).jpg?alt=media&token=afbbdb91-e4a0-461e-836a-d89f76b69082")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Crunch tipo bicicleta":
                nombre.setText("Crunch abdominal lateral");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113437.jpg?alt=media&token=eccbfefe-6820-4879-b370-0ccb1454573e")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Crunch abdominal lateral con polea alta");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113704.jpg?alt=media&token=8843cf7c-b618-421d-95cf-162aeaf6088b")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Toques al talón");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113834.jpg?alt=media&token=3521bce4-bbd0-4936-9994-1df7bd3f72d4")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Crunch abdominal en banco declinado con balon en la nuca":
                nombre.setText("Crunch abdominal en banco declinado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113144.jpg?alt=media&token=6eb25b94-4d87-47ae-b9c0-4e83c61a0472")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Crunch abdominal hincado con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112933.jpg?alt=media&token=914478f7-ce1a-4b1d-9a5d-53442fc27ef3")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Crunch abdominal");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121917.jpg?alt=media&token=6a7354cf-d38a-4931-ae6d-3bd5a0a6f1a1")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevaciones de piernas acostado en banco":
                nombre.setText("Elevación de piernas en silla romana");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112604.jpg?alt=media&token=a27b1953-a16e-419b-b206-ad01ebf5138d")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Rodillo abdominal");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112445.jpg?alt=media&token=65fbc2e2-c04e-4300-af76-36ba341c3a1b")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Crunch tipo bicicleta");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevaciones de piernas en silla romana":
                nombre.setText("Crunch abdominal en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123642.jpg?alt=media&token=e0da9abd-59d8-4237-8a60-f8a89033a7c7")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevación de piernas acostado en banco");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854(0).jpg?alt=media&token=afbbdb91-e4a0-461e-836a-d89f76b69082")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Rodillo abdominal");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112445.jpg?alt=media&token=65fbc2e2-c04e-4300-af76-36ba341c3a1b")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Crunch lateral con polea alta":
                nombre.setText("Crunch lateral");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113437.jpg?alt=media&token=eccbfefe-6820-4879-b370-0ccb1454573e")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Toques al talón");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Ftoques%20al%20talon%2F20211210_113834.jpg?alt=media&token=3521bce4-bbd0-4936-9994-1df7bd3f72d4")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Crunch tipo bicileta");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Crunch abdominal en banco declinado":
                nombre.setText("Crunch abdominal en banco declinado con balón en la nuca");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%20con%20balon%20por%20detras%2F20211210_113217.jpg?alt=media&token=a6ad17e7-d218-41c7-9412-b26ffd74fc38")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Crunch abdominal con cuerda en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20maquina%20con%20cuerda%2F20210203_122804.jpg?alt=media&token=5610e8cf-9d23-4185-a2d3-d29e8e1b6b10")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Crunch abdominal hincado con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20hincado%20con%20cuerda%2F20211210_112933.jpg?alt=media&token=914478f7-ce1a-4b1d-9a5d-53442fc27ef3")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Crunch abdominal":
                nombre.setText("Crunch abdominal en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominale%20en%20maquina%2F20210213_123642.jpg?alt=media&token=e0da9abd-59d8-4237-8a60-f8a89033a7c7")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevación de piernas en silla romana");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaci%C3%B3n%20de%20piernas%20en%20silla%20romana%2F20211210_112604.jpg?alt=media&token=a27b1953-a16e-419b-b206-ad01ebf5138d")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Crunch abdominal en banco declinado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113144.jpg?alt=media&token=6eb25b94-4d87-47ae-b9c0-4e83c61a0472")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Toques al talón":
                nombre.setText("Crunch tipo bicicleta");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Crunch lateral con polea alta");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113704.jpg?alt=media&token=8843cf7c-b618-421d-95cf-162aeaf6088b")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Crunch lateral");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20lateral%2F20211210_113437.jpg?alt=media&token=eccbfefe-6820-4879-b370-0ccb1454573e")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Crunch acostado en flexión de piernas":
                nombre.setText("Crunch abdominal");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%2F20210205_121917.jpg?alt=media&token=6a7354cf-d38a-4931-ae6d-3bd5a0a6f1a1")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Crunch abdominal en banco declinado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20abdominal%20en%20banco%20declinado%2F20211210_113144.jpg?alt=media&token=6eb25b94-4d87-47ae-b9c0-4e83c61a0472")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Rodillo abdominal");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Frodillo%20abdominal%2F20211210_112445.jpg?alt=media&token=65fbc2e2-c04e-4300-af76-36ba341c3a1b")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Crunch lateral":
                nombre.setText("Crunch tipo bicicleta");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20tipo%20bicicleta%2F20211210_112731.jpg?alt=media&token=567ec56c-4c6b-469c-a45e-856e496ba14e")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Crunch lateral en polea alta");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Fcrunch%20lateral%20con%20polea%20alta%2F20211210_113704.jpg?alt=media&token=8843cf7c-b618-421d-95cf-162aeaf6088b")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevación de piernas acostado en banco");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fabdomen%2Felevaciones%20de%20piernas%20acostado%20en%20banco%2F20211215_110854(0).jpg?alt=media&token=afbbdb91-e4a0-461e-836a-d89f76b69082")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


                //-------- laterales y posteriores  12
            case "Remo al mentón con barra":
                nombre.setText("Remo al mentón con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20mancuernas%2F20211210_120546.jpg?alt=media&token=c2160078-997f-46da-8464-35955cd1f23e")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Remo al mentón con polea baja");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem3.jpg.jpg?alt=media&token=b302e29e-81ff-429f-9daa-56c84b18ce6d")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Facepull con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120826.jpg?alt=media&token=dad7d426-1561-4435-aac6-7c7cf954eb73")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevaciones laterales con mancuernas":
                nombre.setText("Elevación lateral con mancuerna a 45 grados");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112606.jpg?alt=media&token=224d744f-9b85-4ea0-b50a-333667af2f9a")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevación lateral con mancuerna acostado en banco declinado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120233.jpg?alt=media&token=a40ae582-7b39-4ccd-927b-d64da79c55b8")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevación lateral con polea baja");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20polea%20baja%2F20210313_121731.jpg?alt=media&token=5248be4d-3506-4e15-8134-f5f4e06e2c8a")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevación lateral con mancuernas acostado en banco inclinado de perfil":
                nombre.setText("Elevación lateral con polea baja");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20polea%20baja%2F20210313_121731.jpg?alt=media&token=5248be4d-3506-4e15-8134-f5f4e06e2c8a")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevación lateral con mancuerna a 45 grados");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112606.jpg?alt=media&token=224d744f-9b85-4ea0-b50a-333667af2f9a")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevaciones laterales con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaciones%20laterales%20con%20mancuernas%2F20210131_105249.jpg?alt=media&token=2ffa2e63-ca3c-4b91-900d-2a3b938a3932")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Remo al mentón con mancuernas":
                nombre.setText("Remo  al mentón con polea baja");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem3.jpg.jpg?alt=media&token=b302e29e-81ff-429f-9daa-56c84b18ce6d")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Remo al mentón con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20barra%2Frem2.jpg?alt=media&token=d9843316-dd2f-43a3-a8a1-7f7168069624")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Facepull con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120826.jpg?alt=media&token=dad7d426-1561-4435-aac6-7c7cf954eb73")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Elevación lateral con polea baja por detrás":
                nombre.setText("Elevación lateral con polea baja por delante");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20polea%20baja%2F20210313_121731.jpg?alt=media&token=5248be4d-3506-4e15-8134-f5f4e06e2c8a")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevación lateral con mancuerna a 45 grados");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112606.jpg?alt=media&token=224d744f-9b85-4ea0-b50a-333667af2f9a")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevación lateral con mancuerna acostado en banco inclinado de perfil");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120233.jpg?alt=media&token=a40ae582-7b39-4ccd-927b-d64da79c55b8")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Flys invertidos en peck deck":
                nombre.setText("Flys invertidos cruzados con poleas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Flys agachado con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20agachados%2F20211210_120455.jpg?alt=media&token=3b398377-2569-4d55-9062-fb9e2011eaf5")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Facepull con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120826.jpg?alt=media&token=dad7d426-1561-4435-aac6-7c7cf954eb73")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Flys agachado con mancuernas":
                nombre.setText("Flys invertidos en peck deck");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20en%20peck%20deck%2Fflye3.jpg?alt=media&token=6c84d085-2518-4319-8e27-444114709d9f")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Flys invertidos cruzados");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20cruzados%2F20211210_120047.jpg?alt=media&token=45216d8c-32bb-4dc2-b98e-58b4008d5375")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Facepull con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120826.jpg?alt=media&token=dad7d426-1561-4435-aac6-7c7cf954eb73")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Elevacion lateral con mancuerna a 45°":
                nombre.setText("Elevación lateral con polea baja por detrás");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115743.jpg?alt=media&token=d75af285-55fc-499e-84cc-c13f86539e5c")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevaciones laterales con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaciones%20laterales%20con%20mancuernas%2F20210131_105249.jpg?alt=media&token=2ffa2e63-ca3c-4b91-900d-2a3b938a3932")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Remo al mentón con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20barra%2Frem2.jpg?alt=media&token=d9843316-dd2f-43a3-a8a1-7f7168069624")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevación lateral con polea baja":
                nombre.setText("Elevación lateral con polea baja por detrás");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20por%20detras%2F20211210_115743.jpg?alt=media&token=d75af285-55fc-499e-84cc-c13f86539e5c")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevación lateral con mancuerna acostado en banco inclinado de perfil");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20con%20mancuerna%20acostado%20en%20banco%20inclinado%2F20211210_120233.jpg?alt=media&token=a40ae582-7b39-4ccd-927b-d64da79c55b8")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Remo al mentón con polea baja");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20polea%20baja%2Freem3.jpg.jpg?alt=media&token=b302e29e-81ff-429f-9daa-56c84b18ce6d")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Remo al mentón con polea baja":
                nombre.setText("Remo al mentón con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20barra%2Frem2.jpg?alt=media&token=d9843316-dd2f-43a3-a8a1-7f7168069624")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Remo al mentón con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20mancuernas%2F20211210_120546.jpg?alt=media&token=c2160078-997f-46da-8464-35955cd1f23e")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Facepull con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120826.jpg?alt=media&token=dad7d426-1561-4435-aac6-7c7cf954eb73")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Facepull con cuerda":
                nombre.setText("Elevación lateral con mancuerna a 45 grados");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Felevaci%C3%B3n%20lateral%20a%2045%C2%B0%20con%20mancuerna%2F20211215_112606.jpg?alt=media&token=224d744f-9b85-4ea0-b50a-333667af2f9a")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Remo al mentón con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fremo%20al%20menton%20con%20mancuernas%2F20211210_120546.jpg?alt=media&token=c2160078-997f-46da-8464-35955cd1f23e")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Flys agachados con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20agachados%2F20211210_120455.jpg?alt=media&token=3b398377-2569-4d55-9062-fb9e2011eaf5")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Flys cruzados con poleas":
                nombre.setText("Flys agachado con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20agachados%2F20211210_120455.jpg?alt=media&token=3b398377-2569-4d55-9062-fb9e2011eaf5")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Flys invertidos en peck deck");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Fflyes%20invertidos%20en%20peck%20deck%2Fflye3.jpg?alt=media&token=6c84d085-2518-4319-8e27-444114709d9f")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Facepull con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoides%20laterales%2Ffacepull%20con%20cuerda%2F20211210_120826.jpg?alt=media&token=dad7d426-1561-4435-aac6-7c7cf954eb73")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


                // -------- trapecios
            case "Encogimiento de hombros con mancuernas":
                nombre.setText("Encogimiento de hombros con barra por delante");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombro%20con%20barra%20por%20delante%2F20211210_121408.jpg?alt=media&token=843e16cf-f877-4258-b469-4a5861f5f943")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Encogimiento de hombros en smith por delante");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%2F20210313_122556.jpg?alt=media&token=b4c8eda0-ddeb-4106-b317-aef34b5cfb21")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Paseo del granjero");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fpaseo%20del%20granjero%2F20211210_121740.jpg?alt=media&token=b6ce6f51-a478-4317-8363-44c56ba6483b")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Encogimiento de hombros en smith por delante":
                nombre.setText("Encogimiento de hombros con barra por detrás");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20barra%20por%20detr%C3%A1s%2F20211210_121425.jpg?alt=media&token=a0c3e606-31d7-43d1-92b2-0667fdc3c141")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Encogimiento de hombros con barra por delante");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombro%20con%20barra%20por%20delante%2F20211210_121408.jpg?alt=media&token=843e16cf-f877-4258-b469-4a5861f5f943")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Encogimiento de hombros con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20mancuernas%2F20211210_121545.jpg?alt=media&token=2d7e3c24-1a61-4cbb-938b-b8bec0156fa2")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Encogimiento de hombros con barra por delante":
                nombre.setText("Encogimiento de hombros en smith por delante");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%2F20210313_122556.jpg?alt=media&token=b4c8eda0-ddeb-4106-b317-aef34b5cfb21")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Encogimiento de hombros en smith por detrás");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%20por%20detr%C3%A1s%2F20211210_121229.jpg?alt=media&token=0212d310-f21b-4e7f-a4d0-885e467c52ff")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Encogimiento de hombros con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20mancuernas%2F20211210_121545.jpg?alt=media&token=2d7e3c24-1a61-4cbb-938b-b8bec0156fa2")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Paseo del granjero":
                nombre.setText("Encogimiento de hombros con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20mancuernas%2F20211210_121545.jpg?alt=media&token=2d7e3c24-1a61-4cbb-938b-b8bec0156fa2")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Encogimiento de hombros con barra por delante");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombro%20con%20barra%20por%20delante%2F20211210_121408.jpg?alt=media&token=843e16cf-f877-4258-b469-4a5861f5f943")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Encogimiento de hombros con barra por detrás");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20barra%20por%20detr%C3%A1s%2F20211210_121425.jpg?alt=media&token=a0c3e606-31d7-43d1-92b2-0667fdc3c141")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Encogimiento de hombros con barra por detrás":
                nombre.setText("Encogimiento de hombros en smith por detrás");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20en%20smith%20por%20detr%C3%A1s%2F20211210_121229.jpg?alt=media&token=0212d310-f21b-4e7f-a4d0-885e467c52ff")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Encogimiento de hombros con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20mancuernas%2F20211210_121545.jpg?alt=media&token=2d7e3c24-1a61-4cbb-938b-b8bec0156fa2")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Paseo del granjero");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fpaseo%20del%20granjero%2F20211210_121740.jpg?alt=media&token=b6ce6f51-a478-4317-8363-44c56ba6483b")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Encogimiento de hombros con smith por detrás":
                nombre.setText("Encogimiento de hombros con barra por detrás");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20barra%20por%20detr%C3%A1s%2F20211210_121425.jpg?alt=media&token=a0c3e606-31d7-43d1-92b2-0667fdc3c141")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Encogimiento de hombros con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombros%20con%20mancuernas%2F20211210_121545.jpg?alt=media&token=2d7e3c24-1a61-4cbb-938b-b8bec0156fa2")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Encogimiento de hombros con barra por delante");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftrapecios%2Fencogimiento%20de%20hombro%20con%20barra%20por%20delante%2F20211210_121408.jpg?alt=media&token=843e16cf-f877-4258-b469-4a5861f5f943")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

                // ------- deltoide frontal  14



            case "Press militar con barra":
                nombre.setText("Press militar en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20smith%2F20211211_132934.jpg?alt=media&token=94407db1-bee5-432c-8fae-1a220731e14b")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Press militar con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111216.jpg?alt=media&token=0e0f1768-1d9f-4c39-9308-aa87eaa0ee04")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press Arnold");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20arnold%2F20211211_132627.jpg?alt=media&token=eda53e9d-00f2-4ba1-b902-2474a8b84ba6")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Press militar con mancuernas":
                nombre.setText("Press militar en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20smith%2F20211211_132934.jpg?alt=media&token=94407db1-bee5-432c-8fae-1a220731e14b")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Push press");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpush%20press%2F20211211_133418.jpg?alt=media&token=22afdd1a-9c3d-4c1e-8dd8-39df98392dfe")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press militar en máquina agarre neutro");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20en%20maquina%20agarre%20neutro%2F20210205_115518.jpg?alt=media&token=53c0e6cc-746f-406c-a941-580436c6c340")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Push press":
                nombre.setText("Press militar con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20barra%2F20210310_112109.jpg?alt=media&token=d62a5dc5-03d9-4ba1-8d58-7dcf7e3944fb")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Press militar en máquina agarre prono");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20maquina%20agarre%20prono%2F20211211_132215.jpg?alt=media&token=df5728a1-9469-4318-9d37-084b4b8f057d")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevación frontal con mancuernas agarre supino");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevacion%20frontal%20supino%20con%20mancuernas%2FIMG_0324.jpg?alt=media&token=5dd18c89-36e4-4d2d-91a8-8ec99515eaec")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Press militar en smith":
                nombre.setText("Press militar con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20barra%2F20210310_112109.jpg?alt=media&token=d62a5dc5-03d9-4ba1-8d58-7dcf7e3944fb")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Press militar con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111216.jpg?alt=media&token=0e0f1768-1d9f-4c39-9308-aa87eaa0ee04")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Push press");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpush%20press%2F20211211_133418.jpg?alt=media&token=22afdd1a-9c3d-4c1e-8dd8-39df98392dfe")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Press en máquina agarre prono":
                nombre.setText("Press en máquina agarre neutro");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20en%20maquina%20agarre%20neutro%2F20210205_115518.jpg?alt=media&token=53c0e6cc-746f-406c-a941-580436c6c340")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Press Arnold");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20arnold%2F20211211_132627.jpg?alt=media&token=eda53e9d-00f2-4ba1-b902-2474a8b84ba6")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevación frontal con mancuernas agarre neutro");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20neutro%2F20211211_131609.jpg?alt=media&token=cf4ebe11-fc55-4cec-8970-d1b53dbb4195")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Press en máquina agarre neutro":
                nombre.setText("Press militar con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20con%20mancuernas%2F20210303_111216.jpg?alt=media&token=0e0f1768-1d9f-4c39-9308-aa87eaa0ee04")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevación frontal con cuerda en polea baja a 1 brazo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20cuerda%20a%201%20brazo%20en%20polea%20baja%2F20211211_132025.jpg?alt=media&token=95b8ce8f-f9d2-4522-8142-49b5f9c5f76c")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press militar en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20smith%2F20211211_132934.jpg?alt=media&token=94407db1-bee5-432c-8fae-1a220731e14b")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Press Arnold":
                nombre.setText("Press militar en máquina agarre prono");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20maquina%20agarre%20prono%2F20211211_132226.jpg?alt=media&token=9e4300d1-5f77-4afc-bf57-10f289e42992")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevación frontal con disco");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20disco%2F20211211_131729.jpg?alt=media&token=c2870d17-6559-437b-b8c9-f570915987a4")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Push press");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpush%20press%2F20211211_133418.jpg?alt=media&token=22afdd1a-9c3d-4c1e-8dd8-39df98392dfe")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevaciones frontales con mancuernas agarre prono":
                nombre.setText("Elevaciones frontales con mancuernas agarre supino");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevacion%20frontal%20supino%20con%20mancuernas%2FIMG_0324.jpg?alt=media&token=5dd18c89-36e4-4d2d-91a8-8ec99515eaec")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevaciones frontales con cuerda en polea baja");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20cuerda%20en%20polea%20bjaa%2F20211211_131930.jpg?alt=media&token=28ead862-adde-434f-894f-14a0b5252e7d")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevacioón frontal con disco");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20disco%2F20211211_131729.jpg?alt=media&token=c2870d17-6559-437b-b8c9-f570915987a4")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevaciones frontales con mancuernas agarre neutro":
                nombre.setText("Elevaciones frontales con cuerda en polea baja");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20cuerda%20en%20polea%20bjaa%2F20211211_131930.jpg?alt=media&token=28ead862-adde-434f-894f-14a0b5252e7d")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevaciones frontales con disco");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20disco%2F20211211_131729.jpg?alt=media&token=c2870d17-6559-437b-b8c9-f570915987a4")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press en máquina agarre neutro");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20en%20maquina%20agarre%20neutro%2F20210205_115518.jpg?alt=media&token=53c0e6cc-746f-406c-a941-580436c6c340")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevaciones frontales con mancuerna agarre supino":
                nombre.setText("Elevaciones frontales con mancuernas agarre neutro");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20neutro%2F20211211_131609.jpg?alt=media&token=cf4ebe11-fc55-4cec-8970-d1b53dbb4195")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevación frontal con cuerda en polea baja a 1 brazo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20cuerda%20a%201%20brazo%20en%20polea%20baja%2F20211211_132025.jpg?alt=media&token=95b8ce8f-f9d2-4522-8142-49b5f9c5f76c")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevación frontal con mancuernas agarre prono");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20prono%2F20211211_131542.jpg?alt=media&token=2d239b78-cc91-42f4-9082-5aa6c65d7269")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevaciones frontales con polea baja a 1 brazo":
                nombre.setText("Elevaciones frontales con mancuernas agarre neutro");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20neutro%2F20211211_131609.jpg?alt=media&token=cf4ebe11-fc55-4cec-8970-d1b53dbb4195")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevación frontal con disco");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20disco%2F20211211_131729.jpg?alt=media&token=c2870d17-6559-437b-b8c9-f570915987a4")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Press militar en máquina agarre prono");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20militar%20en%20maquina%20agarre%20prono%2F20211211_132226.jpg?alt=media&token=9e4300d1-5f77-4afc-bf57-10f289e42992")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevaciones frontales con disco":
                nombre.setText("Elevación frontal con cuerda en polea baja a 1 brazo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20cuerda%20a%201%20brazo%20en%20polea%20baja%2F20211211_132025.jpg?alt=media&token=95b8ce8f-f9d2-4522-8142-49b5f9c5f76c")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevación frontal con mancuerna agarre supino");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevacion%20frontal%20supino%20con%20mancuernas%2FIMG_0324.jpg?alt=media&token=5dd18c89-36e4-4d2d-91a8-8ec99515eaec")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevaciones frontales con mancuernas agarre neutro");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20neutro%2F20211211_131609.jpg?alt=media&token=cf4ebe11-fc55-4cec-8970-d1b53dbb4195")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevaciones frontal con cuerda en polea baja":
                nombre.setText("Elevación frontal con mancuerna agarre supino");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevacion%20frontal%20supino%20con%20mancuernas%2FIMG_0324.jpg?alt=media&token=5dd18c89-36e4-4d2d-91a8-8ec99515eaec")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Press militar en máquina agarre neutro");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Fpress%20en%20maquina%20agarre%20neutro%2F20210205_115518.jpg?alt=media&token=53c0e6cc-746f-406c-a941-580436c6c340")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevación frontal con mancuerna agarre prono");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fdeltoide%20frontal%2Felevaci%C3%B3n%20frontal%20con%20mancuernas%20agarre%20prono%2F20211211_131542.jpg?alt=media&token=2d239b78-cc91-42f4-9082-5aa6c65d7269")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



                //--------- triceps  14



            case "Press cerrado con barra":
                nombre.setText("Press cerrado en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20en%20smith%2F20211211_134402.jpg?alt=media&token=9a7ffe73-2ae0-4faf-b15f-28ee306c1c2a")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Copa con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%2F20211211_133811.jpg?alt=media&token=3292c999-28d4-4ba7-b9d2-c30e1f91b060")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Rompecraneos con barra z");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20barra%20z%2F20211211_133613.jpg?alt=media&token=51f761d5-a7bb-4d06-9c2b-7b4c109ebdb5")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Press cerrado en smith":
                nombre.setText("Press cerrado con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20con%20barra%2FIMG_0333.jpg?alt=media&token=e8337d1e-5160-400c-8923-b771369ef950")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Rompecranes con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20mancuernas%2F20210306_121025.jpg?alt=media&token=443ab4fd-91fa-42f6-b76c-e5fa5f98a988")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Copa con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20barra%2F20210310_113434.jpg?alt=media&token=2248759f-65be-4c94-951d-9a51ea67fdd0")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Rompecraneos con barra z":
                nombre.setText("Rompecraneos con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20mancuernas%2F20210306_121025.jpg?alt=media&token=443ab4fd-91fa-42f6-b76c-e5fa5f98a988")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Fondos en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Ffondos%20en%20maquina%2F20210131_104422.jpg?alt=media&token=4a2f6161-b9b0-47d0-a718-d1b4a5f02100")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Copa con barra z");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20barra%2F20210310_113434.jpg?alt=media&token=2248759f-65be-4c94-951d-9a51ea67fdd0")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Rompecraneos con mancuernas":
                nombre.setText("Rompecraneos con barra z");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20barra%20z%2F20211211_133613.jpg?alt=media&token=51f761d5-a7bb-4d06-9c2b-7b4c109ebdb5")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Fondos en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Ffondos%20en%20maquina%2F20210131_104422.jpg?alt=media&token=4a2f6161-b9b0-47d0-a718-d1b4a5f02100")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Copa con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%2F20211211_133811.jpg?alt=media&token=3292c999-28d4-4ba7-b9d2-c30e1f91b060")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Copa con barra":
                nombre.setText("Copa con mancuerna a 1 brazo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%20a%201%20brazo%2F20211211_134148.jpg?alt=media&token=da45daae-a3b3-4cc5-8e3e-0eefd4573f1a")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Press cerrado en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpress%20cerrado%20en%20smith%2F20211211_134402.jpg?alt=media&token=9a7ffe73-2ae0-4faf-b15f-28ee306c1c2a")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Rompecraneos con barra z");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Frompecraneos%20con%20barra%20z%2F20211211_133613.jpg?alt=media&token=51f761d5-a7bb-4d06-9c2b-7b4c109ebdb5")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Copa con mancuerna sentado":
                nombre.setText("Copa con mancuerna a 1 brazo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%20a%201%20brazo%2F20211211_134148.jpg?alt=media&token=da45daae-a3b3-4cc5-8e3e-0eefd4573f1a")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Copa con barra z");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20barra%2F20210310_113434.jpg?alt=media&token=2248759f-65be-4c94-951d-9a51ea67fdd0")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("fFondos en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Ffondos%20en%20maquina%2F20210131_104422.jpg?alt=media&token=4a2f6161-b9b0-47d0-a718-d1b4a5f02100")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Copa con mancuerna a 1 brazo":
                nombre.setText("Copa con barra ");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20barra%2F20210310_113434.jpg?alt=media&token=2248759f-65be-4c94-951d-9a51ea67fdd0")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Patada para tríceps con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20triceps%20a%201%20brazo%2F20210131_105749.jpg?alt=media&token=3edb47a6-91f3-4fdd-b9ef-7ed86bcb22fc")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Extensiones de triceps en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20maquina%2F20210131_104124.jpg?alt=media&token=9b6efd0c-3bed-48ed-b96f-893a06879207")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Extensiones de tríceps en máquina":
                nombre.setText("Extensiones de tríceps con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20con%20cuerda%2F20210131_104718.jpg?alt=media&token=16b1f8b0-ef5a-45f5-b4de-a0d5a289ca59")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Extensiones de triceps con polea a 1 brazo agarre supino");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20a%201%20brazo%20agarre%20supino%2F20210306_120236.jpg?alt=media&token=8cbdc0b6-9c3a-4e32-9a77-5aadeaef1f85")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Copa con mancuerna a 1 brazo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%20a%201%20brazo%2F20211211_134148.jpg?alt=media&token=da45daae-a3b3-4cc5-8e3e-0eefd4573f1a")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Fondos en máquina":
                nombre.setText("Extensiones de triceps en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20maquina%2F20210131_104124.jpg?alt=media&token=9b6efd0c-3bed-48ed-b96f-893a06879207")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Extensiones de triceps con polea a 1 brazo agarre supino");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20a%201%20brazo%20agarre%20supino%2F20210306_120236.jpg?alt=media&token=8cbdc0b6-9c3a-4e32-9a77-5aadeaef1f85")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Copa con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%2F20211211_133811.jpg?alt=media&token=3292c999-28d4-4ba7-b9d2-c30e1f91b060")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Extensiones de tríceps en polea alta con maneral recto":
                nombre.setText("Extensiones de triceps con cuerda en polea alta");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20con%20cuerda%2F20210131_104718.jpg?alt=media&token=16b1f8b0-ef5a-45f5-b4de-a0d5a289ca59")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Patada para tríceps con polea baja a 1 brazo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20tr%C3%ADceps%20con%20polea%2F20210303_120303.jpg?alt=media&token=c1821599-0a85-4254-b855-4e14d909d198")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Extensiones de triceps con polea alta a 1 brazo agarre supino");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20a%201%20brazo%20agarre%20supino%2F20210306_120236.jpg?alt=media&token=8cbdc0b6-9c3a-4e32-9a77-5aadeaef1f85")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Extensiones de tríceps a 1 brazo agarre supino":
                nombre.setText("Extensiones de triceps en polea alta con maneral recto");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20polea%20alta%20con%20manera%20recto%2F20211211_134008.jpg?alt=media&token=d3a079cf-e0d6-40b2-b8de-3b8c2ed75cdd")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Extensiones de triceps en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20maquina%2F20210131_104124.jpg?alt=media&token=9b6efd0c-3bed-48ed-b96f-893a06879207")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Extensiones de tríceps con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20con%20cuerda%2F20210131_104718.jpg?alt=media&token=16b1f8b0-ef5a-45f5-b4de-a0d5a289ca59")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Patada para tríceps a 1 brazo":
                nombre.setText("Patada para tríceps con polea baja a 1 brazo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20tr%C3%ADceps%20con%20polea%2F20210303_120303.jpg?alt=media&token=c1821599-0a85-4254-b855-4e14d909d198")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Extensiones de triceps con polea alta a 1 brazo agarre supino");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20a%201%20brazo%20agarre%20supino%2F20210306_120236.jpg?alt=media&token=8cbdc0b6-9c3a-4e32-9a77-5aadeaef1f85")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Copa con mancuerna a 1 brazo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fcopa%20con%20mancuerna%20a%201%20brazo%2F20211211_134148.jpg?alt=media&token=da45daae-a3b3-4cc5-8e3e-0eefd4573f1a")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Extensiones de tríceps con cuerda":
                nombre.setText("Extensiones de tríceps en polea alta con maneral recto");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20polea%20alta%20con%20manera%20recto%2F20211211_134008.jpg?alt=media&token=d3a079cf-e0d6-40b2-b8de-3b8c2ed75cdd")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Patada para tríceps con polea baja a 1 brazo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fpatada%20para%20tr%C3%ADceps%20con%20polea%2F20210303_120303.jpg?alt=media&token=c1821599-0a85-4254-b855-4e14d909d198")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Fondos en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Ffondos%20en%20maquina%2F20210131_104422.jpg?alt=media&token=4a2f6161-b9b0-47d0-a718-d1b4a5f02100")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Patada para tríceps con polea":
                nombre.setText("Extensiones de tríceps en polea alta con maneral recto");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20polea%20alta%20con%20manera%20recto%2F20211211_134008.jpg?alt=media&token=d3a079cf-e0d6-40b2-b8de-3b8c2ed75cdd")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Extensiones de tríceps en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20en%20maquina%2F20210131_104124.jpg?alt=media&token=9b6efd0c-3bed-48ed-b96f-893a06879207")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Extensiones de tríceps con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ftriceps%2Fextensiones%20de%20tr%C3%ADceps%20con%20cuerda%2F20210131_104718.jpg?alt=media&token=16b1f8b0-ef5a-45f5-b4de-a0d5a289ca59")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


                //------------ biceps  15

            case "Curl martillo con barra romana":
                nombre.setText("Curl martillo con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20mancuernas%2F20210131_105535.jpg?alt=media&token=755313e9-1b5f-4978-a93e-0877a2014486")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl martillo con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20cuerda%2F20210131_104948.jpg?alt=media&token=067d2853-afc8-4153-a2ea-ced6d9e7440a")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl con mancuernas alternando");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20alternado%2F20210131_105406.jpg?alt=media&token=70a4cc94-6c7c-4b29-9f3c-c4048898d032")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Curl de biceps a 90° con barra":
                nombre.setText("Curl con mancuernas acostado en banco inclinado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20acostado%20en%20banco%20inclinado%2F20210131_105854.jpg?alt=media&token=e78dbb5b-f7be-477e-852f-8f02151ba446")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl concentrado a 1 brazo recargado en muslo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20concentrado%20a%201%20brazo%20recargado%20en%20muslo%2F20210303_114508.jpg?alt=media&token=f20b8b01-f121-4691-ae60-03dc6c22b05a")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl spider con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20barra%2F20210310_114725.jpg?alt=media&token=351c3add-a23d-4886-a883-6385aaaac4f1")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Curl predicador con barra z":
                nombre.setText("Curl predicador con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20predicador%20con%20mancuernas%2F20210306_112834.jpg?alt=media&token=c968f4fa-a132-4861-b6f3-5ebe1cea2882")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl de biceps a 90 grados con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%2090%C2%B0%20con%20barra%2F20210224_120221.jpg?alt=media&token=39c9069c-bc1d-4d80-890c-702f6ca05aeb")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl de biceps a 1 brazo con polea altura media");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%201%20brazo%20con%20polea%20altura%20media%2F20211215_111010.jpg?alt=media&token=1fedfb25-dd3f-46f6-b7e7-ae210f38900f")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Curl concentrado a 1 brazo recargado en muslo":
                nombre.setText("Curl spider con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20mancuernas%2F20210303_113052.jpg?alt=media&token=47e0564e-f136-49f2-818c-985f0baa3437")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl de biceps a 1 brazo con polea altura media");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%201%20brazo%20con%20polea%20altura%20media%2F20211215_111010.jpg?alt=media&token=1fedfb25-dd3f-46f6-b7e7-ae210f38900f")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl de biceps alternado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20alternado%2F20210131_105406.jpg?alt=media&token=70a4cc94-6c7c-4b29-9f3c-c4048898d032")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Curl de biceps acostado en banco inclinado":
                nombre.setText("Curl martillo con barra romana");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20barra%20romana%2F20211211_134610.jpg?alt=media&token=6f342336-8476-4ef8-8351-c91f37376cfd")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl concentrado a 1 brazo recargado en muslo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20concentrado%20a%201%20brazo%20recargado%20en%20muslo%2F20210303_114508.jpg?alt=media&token=f20b8b01-f121-4691-ae60-03dc6c22b05a")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl de biceps con polea maneral recto");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20polea%20maneral%20recto%2F20210203_120715.jpg?alt=media&token=64be5b68-847f-4488-a3a5-79bcaca678ac")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Curl de biceps con barra z":
                nombre.setText("Curl predicador con barra z");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20predicador%20con%20barra%20z%2F20210303_120226.jpg?alt=media&token=0fb392d5-9219-4a39-870f-47674d9f4738")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl spider con barra z");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20barra%2F20210310_114725.jpg?alt=media&token=351c3add-a23d-4886-a883-6385aaaac4f1")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl de biceps a 90 grados con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%2090%C2%B0%20con%20barra%2F20210224_120221.jpg?alt=media&token=39c9069c-bc1d-4d80-890c-702f6ca05aeb")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Curl martillo con mancuernas":
                nombre.setText("Curl martillo con barra romana");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20barra%20romana%2F20211211_134610.jpg?alt=media&token=6f342336-8476-4ef8-8351-c91f37376cfd")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl martillo con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20cuerda%2F20210131_104950.jpg?alt=media&token=4a66bc51-e51c-44b4-a9fe-77f702f7b88a")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl de biceps acostado en banco inclinado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20acostado%20en%20banco%20inclinado%2F20210131_105859.jpg?alt=media&token=4b0b61b2-fc8f-4a1c-90d7-c1613c4c7a8b")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Curl de biceps alternado":
                nombre.setText("Curl de biceps con barra z");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20barra%20z%2F20210131_103318.jpg?alt=media&token=09b97ea4-167a-4113-8331-5ca12f9350f3")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl predicador con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20predicador%20con%20mancuernas%2F20210306_112834.jpg?alt=media&token=c968f4fa-a132-4861-b6f3-5ebe1cea2882")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl con polea baja maneral recto");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20polea%20maneral%20recto%2F20210203_120715.jpg?alt=media&token=64be5b68-847f-4488-a3a5-79bcaca678ac")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Curl spider con barra":
                nombre.setText("Curl spider con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20mancuernas%2F20210303_113052.jpg?alt=media&token=47e0564e-f136-49f2-818c-985f0baa3437")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl de biceps en maquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20maquina%2F20210131_104013.jpg?alt=media&token=1c5845cd-1d67-4647-b2a1-80bd06bfb7fb")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl de biceps a 90 grados con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%2090%C2%B0%20con%20barra%2F20210224_120221.jpg?alt=media&token=39c9069c-bc1d-4d80-890c-702f6ca05aeb")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Curl de bíceps en predicador con mancuernas":
                nombre.setText("Curl de biceps acostado en banco inclinado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20acostado%20en%20banco%20inclinado%2F20210131_105859.jpg?alt=media&token=4b0b61b2-fc8f-4a1c-90d7-c1613c4c7a8b")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl predicador con barra z");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20predicador%20con%20barra%20z%2F20210303_120226.jpg?alt=media&token=0fb392d5-9219-4a39-870f-47674d9f4738")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl de biceps con barra z");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20barra%20z%2F20210131_103318.jpg?alt=media&token=09b97ea4-167a-4113-8331-5ca12f9350f3")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Curl martillo con cuerda":
                nombre.setText("Curl martillo con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20mancuernas%2F20210131_105535.jpg?alt=media&token=755313e9-1b5f-4978-a93e-0877a2014486")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl martillo con barra romana");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20barra%20romana%2F20211211_134610.jpg?alt=media&token=6f342336-8476-4ef8-8351-c91f37376cfd")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl spider con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20mancuernas%2F20210303_113057.jpg?alt=media&token=0f783a08-b8b8-458a-bd1b-33ed4f671fb3")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Curl de biceps con polea maneral recto":
                nombre.setText("Curl de biceps a 1 brazo con polea altura media");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20a%201%20brazo%20con%20polea%20altura%20media%2F20211215_111010.jpg?alt=media&token=1fedfb25-dd3f-46f6-b7e7-ae210f38900f")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl de biceps en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20maquina%2F20210131_104013.jpg?alt=media&token=1c5845cd-1d67-4647-b2a1-80bd06bfb7fb")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl martillo con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20cuerda%2F20210131_104950.jpg?alt=media&token=4a66bc51-e51c-44b4-a9fe-77f702f7b88a")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Curl de biceps en máquina":
                nombre.setText("Curl concentrado a 1 brazo recargado en muslo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20concentrado%20a%201%20brazo%20recargado%20en%20muslo%2F20210303_114508.jpg?alt=media&token=f20b8b01-f121-4691-ae60-03dc6c22b05a")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl de biceps con polea maneral recto");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20polea%20maneral%20recto%2F20210203_120715.jpg?alt=media&token=64be5b68-847f-4488-a3a5-79bcaca678ac")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl de biceps acostado en banco inclinado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20acostado%20en%20banco%20inclinado%2F20210131_105859.jpg?alt=media&token=4b0b61b2-fc8f-4a1c-90d7-c1613c4c7a8b")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Curl de biceps con polea altura media a 1 brazo":
                nombre.setText("Curl de biceps con polea maneral recto");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20polea%20maneral%20recto%2F20210203_120715.jpg?alt=media&token=64be5b68-847f-4488-a3a5-79bcaca678ac")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl de biceps en predicador con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20predicador%20con%20mancuernas%2F20210306_112834.jpg?alt=media&token=c968f4fa-a132-4861-b6f3-5ebe1cea2882")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl de biceps en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20en%20maquina%2F20210131_104013.jpg?alt=media&token=1c5845cd-1d67-4647-b2a1-80bd06bfb7fb")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Curl spider con mancuernas":
                nombre.setText("Curl spider con barra z");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20spider%20con%20barra%2F20210310_114725.jpg?alt=media&token=351c3add-a23d-4886-a883-6385aaaac4f1")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl martillo con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20martillo%20con%20mancuernas%2F20210131_105535.jpg?alt=media&token=755313e9-1b5f-4978-a93e-0877a2014486")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl de biceps con barra z");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fbiceps%2Fcurl%20de%20biceps%20con%20barra%20z%2F20210131_103318.jpg?alt=media&token=09b97ea4-167a-4113-8331-5ca12f9350f3")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            // ----------------- pantorrillas  6
            case "Elevación de talón parado en máquina":
                nombre.setText("Elevación de talón en prensa a 1 pierna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20a%201%20pierna%2F20210215_130011.jpg?alt=media&token=d3f4cafe-26f6-4cd2-a862-d02e29ff75ba")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevación de talón en costurera");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20costurera%2F20210220_123439.jpg?alt=media&token=cd5d5a75-3dfc-46ce-8b24-1b366faa38ee")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevaciones de talón parado con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20parado%20con%20mancuerna%2F20210310_120558.jpg?alt=media&token=3d5edaad-c045-4256-aea7-34d967faef76")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevación de talón en prensa 45°":
                nombre.setText("Elevaciones de talón en sentadilla perfecta");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20sentadilla%20perfecta%2F20211215_113308.jpg?alt=media&token=8ebb1b76-9791-414a-8965-b6504b4b2d7b")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevaciones de talón en prensa horizontal");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20horizontal%2F20211215_111104.jpg?alt=media&token=65f55792-18ee-4e71-bfd3-68788892af40")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevaciones de talón parado con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20parado%20con%20mancuerna%2F20210310_120558.jpg?alt=media&token=3d5edaad-c045-4256-aea7-34d967faef76")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevaciones de talón en prensa a 1 pierna":
                nombre.setText("Elevaciones de talón en costurera");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20costurera%2F20210220_123439.jpg?alt=media&token=cd5d5a75-3dfc-46ce-8b24-1b366faa38ee")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevación de talón en prensa a 45 grados");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaci%C3%B3n%20de%20tal%C3%B3n%20en%20prensa%2045%C2%B0%2FIMG_0369.jpg?alt=media&token=1f2c4ccf-7cf9-4dd2-bd92-7bab13bc3539")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevación de talón en sentadilla perfecta");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20sentadilla%20perfecta%2F20211215_113308.jpg?alt=media&token=8ebb1b76-9791-414a-8965-b6504b4b2d7b")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevación de talón parado con mancuernas":
                nombre.setText("Elevaciones de talón en sentadilla perfecta");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20sentadilla%20perfecta%2F20211215_113308.jpg?alt=media&token=8ebb1b76-9791-414a-8965-b6504b4b2d7b")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevaciones de talón en prensa horizontal");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20horizontal%2F20211215_111104.jpg?alt=media&token=65f55792-18ee-4e71-bfd3-68788892af40")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevación de talón en prensa 45 grados");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaci%C3%B3n%20de%20tal%C3%B3n%20en%20prensa%2045%C2%B0%2FIMG_0369.jpg?alt=media&token=1f2c4ccf-7cf9-4dd2-bd92-7bab13bc3539")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevaciones de talón en costurera":
                nombre.setText("Elevaciones de talón en prensa a 1 pierna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20a%201%20pierna%2F20210215_130011.jpg?alt=media&token=d3f4cafe-26f6-4cd2-a862-d02e29ff75ba")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevaciones de talón parado con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20parado%20con%20mancuerna%2F20210310_120558.jpg?alt=media&token=3d5edaad-c045-4256-aea7-34d967faef76")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevaciones de talón en prensa horizontal");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20prensa%20horizontal%2F20211215_111104.jpg?alt=media&token=65f55792-18ee-4e71-bfd3-68788892af40")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevación de talón en prensa horizontal":
                nombre.setText("Elevaciones de talón en prensa a 45 grados");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaci%C3%B3n%20de%20tal%C3%B3n%20en%20prensa%2045%C2%B0%2FIMG_0369.jpg?alt=media&token=1f2c4ccf-7cf9-4dd2-bd92-7bab13bc3539")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevaciones de talón en sentadilla perfecta");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20sentadilla%20perfecta%2F20211215_113308.jpg?alt=media&token=8ebb1b76-9791-414a-8965-b6504b4b2d7b")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevacions de talón en costurera");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fpantorrillas%2Felevaciones%20de%20tal%C3%B3n%20en%20costurera%2F20210220_123439.jpg?alt=media&token=cd5d5a75-3dfc-46ce-8b24-1b366faa38ee")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            // -------------------- gluteos y aductores  15

            case "Hip thrust con barra":
                nombre.setText("Puente con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20con%20mancuerna%2F20210131_113131.jpg?alt=media&token=5207ad4d-8bbc-4d2a-9ca6-6abdfdfd013f")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Patada para glúteos en máquina de pie");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%20de%20pie%2F20210202_123925.jpg?alt=media&token=09e3e5ff-2478-4f3d-aa0c-c210a296761b")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Peso muerto tipo sumo con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20barra%2F20210210_112935.jpg?alt=media&token=b2d84e57-45a6-4bf5-8a8b-8d671513cd8f")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Peso muerto tipo sumo con barra":
                nombre.setText("Sentadilla smith tipo sumo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fsentadilla%20Smith%20tipo%20sumo%2F20210310_114633.jpg?alt=media&token=50fb2cd4-d99a-4852-b0d6-1e379903c736")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Peso muerto tipo sumo con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20mancuerna%2F20210131_113330.jpg?alt=media&token=f79ca688-ba30-4d65-a328-ee456f27013e")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Hip thrust con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fhip%20thrust%20con%20barra%2F20210210_112152(0).jpg?alt=media&token=bd04b0c5-7956-4fc3-bc6f-8be7b3e79d65")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Patada para glúteos con máquina de pie":
                nombre.setText("Patada para glúteos en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%2F20210131_111648.jpg?alt=media&token=e014fed1-f7cd-49f9-b683-3a5620b0b029")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Patada para glúteos con polea");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20polea%2F20210308_125718.jpg?alt=media&token=0a3efb37-3fb0-4e36-8763-667328359769")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Puente a 1 pierna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20a%201%20pierna%2F20210131_113159.jpg?alt=media&token=bcabdcb0-892f-4e4a-bc08-7f696e3fce95")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Sentadilla smith tipo sumo":
                nombre.setText("Peso muerto tipo sumo con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20barra%2F20210210_112935.jpg?alt=media&token=b2d84e57-45a6-4bf5-8a8b-8d671513cd8f")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Hip thrust con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fhip%20thrust%20con%20barra%2F20210210_112152(0).jpg?alt=media&token=bd04b0c5-7956-4fc3-bc6f-8be7b3e79d65")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Peso muerto tipo sumo con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20mancuerna%2F20210131_113330.jpg?alt=media&token=f79ca688-ba30-4d65-a328-ee456f27013e")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Aducciones de cadera en polea":
                nombre.setText("Aducciones de cadera en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20en%20maquina%2F20210224_120014.jpg?alt=media&token=10f79db9-a51a-4c7f-b345-bbf315bd89f4")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Peso muerto tipo sumo con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20mancuerna%2F20210131_113330.jpg?alt=media&token=f79ca688-ba30-4d65-a328-ee456f27013e")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Sentadilla smith tipo sumo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fsentadilla%20Smith%20tipo%20sumo%2F20210310_114633.jpg?alt=media&token=50fb2cd4-d99a-4852-b0d6-1e379903c736")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Aducciones de cadera en máquina":
                nombre.setText("Aducciones de cadera con polea");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Faducciones%20de%20cadera%20con%20polea%2F20211215_111652.jpg?alt=media&token=0053076b-978b-4884-95a1-8257be3c0ba4")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Peso muerto tipo sumo con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20mancuerna%2F20210131_113330.jpg?alt=media&token=f79ca688-ba30-4d65-a328-ee456f27013e")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Sentadilla smith tipo sumo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fsentadilla%20Smith%20tipo%20sumo%2F20210310_114633.jpg?alt=media&token=50fb2cd4-d99a-4852-b0d6-1e379903c736")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Peso muerto tipo sumo con mancuerna":
                nombre.setText("Peso muerto tipo sumo con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20barra%2F20210210_112935.jpg?alt=media&token=b2d84e57-45a6-4bf5-8a8b-8d671513cd8f")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Goblet squat");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgoblet%20squat%2F20211210_111428.jpg?alt=media&token=a8cb7d1d-d535-4868-b03b-f443a1e70a87")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Sentadilla smith tipo sumo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fsentadilla%20Smith%20tipo%20sumo%2F20210310_114633.jpg?alt=media&token=50fb2cd4-d99a-4852-b0d6-1e379903c736")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Goblet squat":
                nombre.setText("Peso muerto tipo sumo con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20barra%2F20210210_112935.jpg?alt=media&token=b2d84e57-45a6-4bf5-8a8b-8d671513cd8f")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Sentadilla smith tipo sumo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fsentadilla%20Smith%20tipo%20sumo%2F20210310_114633.jpg?alt=media&token=50fb2cd4-d99a-4852-b0d6-1e379903c736")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Peso muerto tipo sumo con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20mancuerna%2F20210131_113330.jpg?alt=media&token=f79ca688-ba30-4d65-a328-ee456f27013e")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Abducciones de cadera en polea":
                nombre.setText("Abducciones de cadera en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20en%20maquina%2F20210204_115303.jpg?alt=media&token=e084e65f-c8a9-4c94-8214-da08cf419e6d")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Goblet squat");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgoblet%20squat%2F20211210_111428.jpg?alt=media&token=a8cb7d1d-d535-4868-b03b-f443a1e70a87")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Puente a 1 pierna con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20a%201%20pierna%2F20210131_113159.jpg?alt=media&token=bcabdcb0-892f-4e4a-bc08-7f696e3fce95")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Abducciones de cadera en máquina":
                nombre.setText("Abducciones de cadera con polea");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20con%20polea%2F20211215_111506.jpg?alt=media&token=f0fbf440-fcb5-4999-9695-bdf92f032cf1")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Goblet squat");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgoblet%20squat%2F20211210_111428.jpg?alt=media&token=a8cb7d1d-d535-4868-b03b-f443a1e70a87")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Peso muerto tipo sumo con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpeso%20muerto%20tipo%20sumo%20con%20mancuerna%2F20210131_113330.jpg?alt=media&token=f79ca688-ba30-4d65-a328-ee456f27013e")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Patada para glúteo con polea":
                nombre.setText("Patada para glúteos con máquina de pie");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%20de%20pie%2F20210202_123925.jpg?alt=media&token=09e3e5ff-2478-4f3d-aa0c-c210a296761b")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Patada para glúteo con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20mancuerna%2F20210210_113919.jpg?alt=media&token=9ecbd1ff-9b5e-4314-9d18-6e5ef6297ba9")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Puente con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20con%20mancuerna%2F20210131_113131.jpg?alt=media&token=5207ad4d-8bbc-4d2a-9ca6-6abdfdfd013f")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Patada para glúteos en máquina":
                nombre.setText("Puente a 1 pierna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20a%201%20pierna%2F20210131_113159.jpg?alt=media&token=bcabdcb0-892f-4e4a-bc08-7f696e3fce95")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Patada para glúteos con polea");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20polea%2F20210308_125718.jpg?alt=media&token=0a3efb37-3fb0-4e36-8763-667328359769")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Puente con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20con%20mancuerna%2F20210131_113131.jpg?alt=media&token=5207ad4d-8bbc-4d2a-9ca6-6abdfdfd013f")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Puente a 1 pierna":
                nombre.setText("Puente con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20con%20mancuerna%2F20210131_113131.jpg?alt=media&token=5207ad4d-8bbc-4d2a-9ca6-6abdfdfd013f")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Hip trust con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fhip%20thrust%20con%20barra%2F20210210_112152(0).jpg?alt=media&token=bd04b0c5-7956-4fc3-bc6f-8be7b3e79d65")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Abducciones de cadera con polea");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20con%20polea%2F20211215_111506.jpg?alt=media&token=f0fbf440-fcb5-4999-9695-bdf92f032cf1")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Puente con mancuerna":
                nombre.setText("Puente a 1 pierna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpuente%20a%201%20pierna%2F20210131_113159.jpg?alt=media&token=bcabdcb0-892f-4e4a-bc08-7f696e3fce95")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Patada para glúteos con polea");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20polea%2F20210308_125718.jpg?alt=media&token=0a3efb37-3fb0-4e36-8763-667328359769")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Patada para glúteos en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%2F20210131_111648.jpg?alt=media&token=e014fed1-f7cd-49f9-b683-3a5620b0b029")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Patada para glúteo con mancuerna":
                nombre.setText("Patada para glúteos en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gl%C3%BAteos%20en%20maquina%2F20210131_111648.jpg?alt=media&token=e014fed1-f7cd-49f9-b683-3a5620b0b029")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Patada para glúteos con polea");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fpatada%20para%20gluteo%20con%20polea%2F20210308_125718.jpg?alt=media&token=0a3efb37-3fb0-4e36-8763-667328359769")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Abducciones de cadera en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fgl%C3%BAteos%20y%20cadera%2Fabducciones%20de%20cadera%20en%20maquina%2F20210204_115303.jpg?alt=media&token=e084e65f-c8a9-4c94-8214-da08cf419e6d")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


                // --------------- femorales 10


            case "Peso muerto con piernas rigidas con barra":
                nombre.setText("Peso muerto en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20en%20smith%2F20211211_135441.jpg?alt=media&token=7788cc84-8a01-4bb4-8c6e-258a26be9a98")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Peso muerto con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20mancuernas%2F20210131_113529.jpg?alt=media&token=af2e3ef5-0983-418b-8ccf-94b0f39a5510")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Peso muerto con mancuerna a 1 pierna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20a%201%20pierna%2F20210131_113706.jpg?alt=media&token=01c3e97b-bc16-4bd3-be7e-2328716e9188")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Peso muerto con mancuernas":
                nombre.setText("Peso muerto con piernas rígidas con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20piernas%20r%C3%ADgidas%20con%20barra%2F20210308_120010.jpg?alt=media&token=92155ace-9f79-4981-b5ff-8f6dbe9d9783")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Peso muerto en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20en%20smith%2F20211211_135441.jpg?alt=media&token=7788cc84-8a01-4bb4-8c6e-258a26be9a98")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Elevación de cadera a 1 pierna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Felevaci%C3%B3n%20de%20cadera%20a%201%20pierna%2F20211211_135110.jpg?alt=media&token=acbc4c3f-9615-440c-bdff-28ebfc54a1ae")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Peso muerto en smith":
                nombre.setText("Peso muerto con piernas rígidas con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20piernas%20r%C3%ADgidas%20con%20barra%2F20210308_120010.jpg?alt=media&token=92155ace-9f79-4981-b5ff-8f6dbe9d9783")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Peso muerto con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20mancuernas%2F20210131_113529.jpg?alt=media&token=af2e3ef5-0983-418b-8ccf-94b0f39a5510")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl sentado en máquina para isquiosurales");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20sentado%20en%20maquina%20para%20isquiosurales%2F20210131_103833.jpg?alt=media&token=408960ec-40e6-4a2b-8fb5-8548347d77c5")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Peso muerto a 1 pierna":
                nombre.setText("Curl acostado en máquina a 1 pierna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20acostado%2FIMG_0329.jpg?alt=media&token=5d343027-f296-4d87-80af-1baf493da47f")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevación de cadera a 1 pierna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Felevaci%C3%B3n%20de%20cadera%20a%201%20pierna%2F20211211_135110.jpg?alt=media&token=acbc4c3f-9615-440c-bdff-28ebfc54a1ae")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Peso muerto en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20en%20smith%2F20211211_135441.jpg?alt=media&token=7788cc84-8a01-4bb4-8c6e-258a26be9a98")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Curl femoral acostado en máquina":
                nombre.setText("Curl femoral a 1 pierna parado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122852.jpg?alt=media&token=59d7e392-1aad-4c52-a71d-faf7a1224d05")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl sentado en máquina para isquiosurales");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20sentado%20en%20maquina%20para%20isquiosurales%2F20210131_103833.jpg?alt=media&token=408960ec-40e6-4a2b-8fb5-8548347d77c5")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl acostado con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20acostado%20con%20mancuerna%2F20210308_122433.jpg?alt=media&token=93a79028-afb8-4b92-93d5-23cc097ca721")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Curl femoral acostado en máquina a 1 pierna":
                nombre.setText("Curl femorla acostado en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20acostado%20en%20maquina%2F20210202_121632.jpg?alt=media&token=7cb5375f-ee3c-4a14-bf57-ed8aa27dbcf3")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl femoral a 1 pierna parado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122852.jpg?alt=media&token=59d7e392-1aad-4c52-a71d-faf7a1224d05")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl acostado con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20acostado%20con%20mancuerna%2F20210308_122433.jpg?alt=media&token=93a79028-afb8-4b92-93d5-23cc097ca721")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Curl femoral sentado en máquina":
                nombre.setText("Curl femoral acostado en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20acostado%20en%20maquina%2F20210202_121632.jpg?alt=media&token=7cb5375f-ee3c-4a14-bf57-ed8aa27dbcf3")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl femoral a 1 pierna acostado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20acostado%2FIMG_0329.jpg?alt=media&token=5d343027-f296-4d87-80af-1baf493da47f")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl acostado con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20acostado%20con%20mancuerna%2F20210308_122433.jpg?alt=media&token=93a79028-afb8-4b92-93d5-23cc097ca721")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Curl femoral parado a 1 pierna en máquina":
                nombre.setText("Curl femoral a 1 pierna acostado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20acostado%2FIMG_0329.jpg?alt=media&token=5d343027-f296-4d87-80af-1baf493da47f")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Elevación de cadera a 1 pierna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Felevaci%C3%B3n%20de%20cadera%20a%201%20pierna%2F20211211_135110.jpg?alt=media&token=acbc4c3f-9615-440c-bdff-28ebfc54a1ae")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Curl femoral acostado en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20acostado%20en%20maquina%2F20210202_121632.jpg?alt=media&token=7cb5375f-ee3c-4a14-bf57-ed8aa27dbcf3")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Curl acostado con mancuerna":
                nombre.setText("Curl sentado en máquina para isquiosurales");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20sentado%20en%20maquina%20para%20isquiosurales%2F20210131_103833.jpg?alt=media&token=408960ec-40e6-4a2b-8fb5-8548347d77c5")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl femoral a 1 pierna parado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122852.jpg?alt=media&token=59d7e392-1aad-4c52-a71d-faf7a1224d05")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Peso muerto con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20con%20mancuernas%2F20210131_113529.jpg?alt=media&token=af2e3ef5-0983-418b-8ccf-94b0f39a5510")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

            case "Elevación de cadera a una pierna":
                nombre.setText("Curl sentado en máquina para isquiosurales");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20sentado%20en%20maquina%20para%20isquiosurales%2F20210131_103833.jpg?alt=media&token=408960ec-40e6-4a2b-8fb5-8548347d77c5")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Curl femoral a 1 pierna parado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fcurl%20femoral%20a%201%20pierna%20parado%2F20210202_122852.jpg?alt=media&token=59d7e392-1aad-4c52-a71d-faf7a1224d05")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Peso muerto a 1 pierna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Ffemorales%2Fpeso%20muerto%20a%201%20pierna%2F20210131_113706.jpg?alt=media&token=01c3e97b-bc16-4bd3-be7e-2328716e9188")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


                // --------- espalda  16
            case "Peso muerto convencional":
                nombre.setText("Remo pendlay");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20pendlay%2F20211211_140452.jpg?alt=media&token=e4b7abc2-f336-4e24-b1b4-dbc59582418a")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Dominadas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fdominadas%2F20210206_111210.jpg?alt=media&token=326cfd3e-3f68-49b6-a97e-3634449c32cb")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Hiperextensiones de espalda en banco");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fhiperextensiones%20de%20espalda%20en%20banco%2F20210220_122848(0).jpg?alt=media&token=73814040-ec25-4e37-bc37-c216e04fb912")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Remo pendlay":
                nombre.setText("Remo horizontal con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20con%20barra%2F20211211_140452.jpg?alt=media&token=11a3cc3d-6295-4816-afb5-92c40c947a5e")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Remo horizontal en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20en%20smith%2F20211211_135827.jpg?alt=media&token=4224d3f7-5719-40c8-88b4-f60630d7ddc9")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Dominadas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fdominadas%2F20210206_111210.jpg?alt=media&token=326cfd3e-3f68-49b6-a97e-3634449c32cb")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Remo horizontal con barra":
                nombre.setText("Remo con mancuerna a 1 brazo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20con%20mancuerna%20a%201%20brazo%2F20210131_111215.jpg?alt=media&token=639b0747-09be-465c-aa49-2694c36d87bf")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Remo horizontal en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20en%20smith%2F20211211_135827.jpg?alt=media&token=4224d3f7-5719-40c8-88b4-f60630d7ddc9")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Remo en máquina agarre en pronación");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20agarre%20en%20pronacion%2F20210205_114828.jpg?alt=media&token=1e436109-0721-4bee-93fd-7af17dd3e4fd")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Remo horizontal con smith":
                nombre.setText("Remo pendlay");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20pendlay%2F20211211_140452.jpg?alt=media&token=e4b7abc2-f336-4e24-b1b4-dbc59582418a")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Remo en máquina hammer");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20hammer%2F20210203_115946.jpg?alt=media&token=ccd18a99-b86b-4e61-8832-5f068da3cd93")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Remo sentado en polea con triangulo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20sentado%20en%20polea%20con%20triangulo%2F20210205_113845.jpg?alt=media&token=b7fe38d0-55b9-4ea5-b954-d4eb9fcf6f9b")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Dominadas":
                nombre.setText("Jalón frontal con agarre abierto");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20agarre%20abierto%2F20210309_114753.jpg?alt=media&token=22e93bd8-14bc-4d0c-9334-d6632177cd8c")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Jalón frontal con agarre abierto");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20cerrado%20con%20polea%20alta%2FIMG_0361.jpg?alt=media&token=b87f8de8-fb4f-4715-ae41-b44d1e772386")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Pullover con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20mancuerna%2F20211215_112001.jpg?alt=media&token=733de5cb-5cea-4215-99cc-f25486c7bdb7")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Remo con mancuerna a 1 brazo":
                nombre.setText("Remo en máquina hammer");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20hammer%2F20210203_115946.jpg?alt=media&token=ccd18a99-b86b-4e61-8832-5f068da3cd93")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Remo en máquina agarre en pronación");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20agarre%20en%20pronacion%2F20210205_114828.jpg?alt=media&token=1e436109-0721-4bee-93fd-7af17dd3e4fd")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Pullover con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20cuerda%2F20210309_192655.jpg?alt=media&token=65077967-f462-4761-84a2-5065cb8ad567")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Pullover con mancuerna":
                nombre.setText("Remo en máquina hammer");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20hammer%2F20210203_115946.jpg?alt=media&token=ccd18a99-b86b-4e61-8832-5f068da3cd93")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Pullover con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20cuerda%2F20210309_192655.jpg?alt=media&token=65077967-f462-4761-84a2-5065cb8ad567")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Jalón frontal con triangulo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20triangulo%2F20210306_115552.jpg?alt=media&token=1a46beab-baac-4b4e-a7d5-7d65b3bd9181")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Remo en máquina agarre en pronación":
                nombre.setText("Remo a 1 mano con polea baja");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20a%201%20mano%20con%20polea%20baja%2F20210219_121000.jpg?alt=media&token=0f10920c-75e6-4138-885e-0aa7d9774d84")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Remo horizontal en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20en%20smith%2F20211211_135827.jpg?alt=media&token=4224d3f7-5719-40c8-88b4-f60630d7ddc9")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Jalón frontal abierto con agarre cerrado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20cerrado%20con%20polea%20alta%2FIMG_0361.jpg?alt=media&token=b87f8de8-fb4f-4715-ae41-b44d1e772386")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Remo en máquina hammer":
                nombre.setText("Remo sentado en polea con triangulo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20sentado%20en%20polea%20con%20triangulo%2F20210205_113845.jpg?alt=media&token=b7fe38d0-55b9-4ea5-b954-d4eb9fcf6f9b")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Remo horizontal con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20horizontal%20con%20barra%2F20211211_140452.jpg?alt=media&token=11a3cc3d-6295-4816-afb5-92c40c947a5e")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Remo en máquina agarre en pronación");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20agarre%20en%20pronacion%2F20210205_114828.jpg?alt=media&token=1e436109-0721-4bee-93fd-7af17dd3e4fd")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Jalon frontal con agarre cerrado":
                nombre.setText("Jalon frontal con agarre abierto");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20agarre%20abierto%2F20210309_114753.jpg?alt=media&token=22e93bd8-14bc-4d0c-9334-d6632177cd8c")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Jalón frontal con triangulo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20triangulo%2F20210306_115552.jpg?alt=media&token=1a46beab-baac-4b4e-a7d5-7d65b3bd9181")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Pullover con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20mancuerna%2F20211215_112001.jpg?alt=media&token=6b4394b9-7476-4a48-a4cc-bdaabbf6f958")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Pullover con cuerda":
                nombre.setText("Jalón frontal cerrado con polea alta");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20cerrado%20con%20polea%20alta%2FIMG_0361.jpg?alt=media&token=b87f8de8-fb4f-4715-ae41-b44d1e772386")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Jalón frontal con triangulo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20triangulo%2F20210306_115552.jpg?alt=media&token=1a46beab-baac-4b4e-a7d5-7d65b3bd9181")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Pullover con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20mancuerna%2F20211215_112001.jpg?alt=media&token=6b4394b9-7476-4a48-a4cc-bdaabbf6f958")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Jalon frontal con triangulo":
                nombre.setText("Jalón frontal con agarre cerrado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20cerrado%20con%20polea%20alta%2FIMG_0361.jpg?alt=media&token=b87f8de8-fb4f-4715-ae41-b44d1e772386")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Remo sentado en polea con triangulo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20sentado%20en%20polea%20con%20triangulo%2F20210205_113845.jpg?alt=media&token=b7fe38d0-55b9-4ea5-b954-d4eb9fcf6f9b")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Pullover con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20cuerda%2F20210309_192655.jpg?alt=media&token=65077967-f462-4761-84a2-5065cb8ad567")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Jalón frontal con agarre abierto":
                nombre.setText("Jalón frontal con agarre cerrado");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20cerrado%20con%20polea%20alta%2FIMG_0361.jpg?alt=media&token=b87f8de8-fb4f-4715-ae41-b44d1e772386")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Jalón frontal con triangulo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fjalon%20frontal%20con%20triangulo%2F20210306_115552.jpg?alt=media&token=1a46beab-baac-4b4e-a7d5-7d65b3bd9181")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Dominadas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fdominadas%2F20210206_111212.jpg?alt=media&token=f386a2a6-3d86-49fe-9a54-2a3af7aed772")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Hiperextensiones de espalda baja":
                nombre.setText("Peso muerto convencional");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpeso%20muerto%20convencional%2F20211215_113104.jpg?alt=media&token=31966e27-2675-4af8-982d-7a6357c5719f")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Pullover con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20cuerda%2F20210309_192655.jpg?alt=media&token=65077967-f462-4761-84a2-5065cb8ad567")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Remo a 1 mano con polea baja");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20a%201%20mano%20con%20polea%20baja%2F20210219_121000.jpg?alt=media&token=0f10920c-75e6-4138-885e-0aa7d9774d84")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Remo a 1 mano con polea baja":
                nombre.setText("Remo sentado en polea con triangulo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20sentado%20en%20polea%20con%20triangulo%2F20210205_113845.jpg?alt=media&token=b7fe38d0-55b9-4ea5-b954-d4eb9fcf6f9b")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Remo con mancuerna a 1 brazo");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20con%20mancuerna%20a%201%20brazo%2F20210131_111215.jpg?alt=media&token=639b0747-09be-465c-aa49-2694c36d87bf")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Hiperextensiones de espalda baja en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fhiperextensiones%20de%20espalda%20en%20banco%2F20210220_122848(0).jpg?alt=media&token=73814040-ec25-4e37-bc37-c216e04fb912")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Remo sentado en polea con triangulo":
                nombre.setText("Pullover con cuerda");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fpullover%20con%20cuerda%2F20210309_192655.jpg?alt=media&token=65077967-f462-4761-84a2-5065cb8ad567")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Remo en máquina hammer");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20en%20maquina%20hammer%2F20210203_115946.jpg?alt=media&token=ccd18a99-b86b-4e61-8832-5f068da3cd93")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Remo a 1 mano con polea baja");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fespalda%2Fremo%20a%201%20mano%20con%20polea%20baja%2F20210219_121000.jpg?alt=media&token=0f10920c-75e6-4138-885e-0aa7d9774d84")
                        .fit().centerCrop()
                        .into(imageView3);

                break;

                // ------------ cuadriceps  14
            case "Sentadilla frontal con barra":
                nombre.setText("Goblet squat");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcalentamiento%2Fgoblet%20squat%2F20211210_111428.jpg?alt=media&token=a8cb7d1d-d535-4868-b03b-f443a1e70a87")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Sentadilla frontal en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20en%20smith%2F20211211_135602.jpg?alt=media&token=e1b0c3c9-2b6e-446a-9f05-d0651ba1da89")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Sentadilla smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135922.jpg?alt=media&token=ddd7e42b-797b-4103-a384-0b9208546141")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Sentadilla smith profunda":
                nombre.setText("Sentadilla bulgara con mancuerna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112831.jpg?alt=media&token=273285a7-7376-4960-a28b-252e1ae4236a")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Sentadilla libre");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20con%20barra%2F20210206_111054.jpg?alt=media&token=7bb9cf31-7d1f-46b9-aef2-3f92d0d662aa")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Sentadilla en máquina perfecta");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20en%20maquina%20perfecta%2F20210204_120342.jpg?alt=media&token=30659f89-9cf0-4183-97f8-1022479b30ab")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Sentadilla con barra":
                nombre.setText("Prensa a 45 grados");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115038.jpg?alt=media&token=f8264fd9-f7e9-440b-8557-00aac5fec37d")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Sentadilla smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135922.jpg?alt=media&token=ddd7e42b-797b-4103-a384-0b9208546141")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Sentadilla bulgara con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112831.jpg?alt=media&token=273285a7-7376-4960-a28b-252e1ae4236a")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Sentadilla frontal en smith":
                nombre.setText("Prensa a 1 pierna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112525.jpg?alt=media&token=9288507d-1f03-4147-b0d4-b89d491dbc60")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Sentadilla a 90 grados en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20a%2090%20grados%20en%20smith%2FIMG_0338.jpg?alt=media&token=5a256969-7282-4b20-a9f4-e6801d322f68")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Sentadilla frontal con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%2FIMG_0347.jpg?alt=media&token=257a95fe-9f3d-45e5-af92-eafb7c7a87ee")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Sentadlla smith a 90°":
                nombre.setText("Prensa horizontal en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20horizontal%20en%20maquina%2F20210202_115706.jpg?alt=media&token=71099f4e-277a-44f4-9d54-9b86509400a7")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Sentadilla frontal con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113031.jpg?alt=media&token=b7055a35-bb96-4797-a082-7fb395bbfee3")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Extensiones de cuadriceps en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111311.jpg?alt=media&token=fbafd51a-6f5b-48a2-a252-40a61c84f09d")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Sentadilla bulgara con mancuernas":
                nombre.setText("Sentadilla frontal con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%2FIMG_0347.jpg?alt=media&token=257a95fe-9f3d-45e5-af92-eafb7c7a87ee")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Desplantes con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fdesplantes%20con%20mancuernas%2F20210131_112942.jpg?alt=media&token=2b6b25b6-e5c6-4057-be69-bd2cad0c2af6")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Extensiones de cuadriceps en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111311.jpg?alt=media&token=fbafd51a-6f5b-48a2-a252-40a61c84f09d")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Prensa a 45°":
                nombre.setText("Prensa a 1 pierna");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%201%20pierna%2F20210206_112525.jpg?alt=media&token=9288507d-1f03-4147-b0d4-b89d491dbc60")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Sentadilla smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135922.jpg?alt=media&token=ddd7e42b-797b-4103-a384-0b9208546141")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Sentadilla con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20con%20barra%2F20210206_111054.jpg?alt=media&token=7bb9cf31-7d1f-46b9-aef2-3f92d0d662aa")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Prensa a 1 pierna":
                nombre.setText("Prensa a 45 grados");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115038.jpg?alt=media&token=f8264fd9-f7e9-440b-8557-00aac5fec37d")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Extensiones de cuadriceps en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111311.jpg?alt=media&token=fbafd51a-6f5b-48a2-a252-40a61c84f09d")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Sentadilla a 90 grados en smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20a%2090%20grados%20en%20smith%2FIMG_0338.jpg?alt=media&token=5a256969-7282-4b20-a9f4-e6801d322f68")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Desplantes con mancuernas":
                nombre.setText("Sentadilla bulgara con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112831.jpg?alt=media&token=273285a7-7376-4960-a28b-252e1ae4236a")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Sentadilla frontal con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113031.jpg?alt=media&token=b7055a35-bb96-4797-a082-7fb395bbfee3")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Sentadilla en máquina perfecta");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20en%20maquina%20perfecta%2F20210204_120342.jpg?alt=media&token=30659f89-9cf0-4183-97f8-1022479b30ab")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Prensa horizontal en máquina":
                nombre.setText("Extensiones de cuadriceps en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111311.jpg?alt=media&token=fbafd51a-6f5b-48a2-a252-40a61c84f09d")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Prensa a 45 grados");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20a%2045%C2%B0%2F20210308_115038.jpg?alt=media&token=f8264fd9-f7e9-440b-8557-00aac5fec37d")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Sentadilla frontal con smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20en%20smith%2F20211211_135602.jpg?alt=media&token=e1b0c3c9-2b6e-446a-9f05-d0651ba1da89")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Sentadilla en máquina perfecta":
                nombre.setText("Sentadilla bulgara con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20bulgara%20con%20mancuernas%2F20211215_112831.jpg?alt=media&token=273285a7-7376-4960-a28b-252e1ae4236a")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Sentadilla smith");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20smith%2F20211211_135922.jpg?alt=media&token=ddd7e42b-797b-4103-a384-0b9208546141")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Sentadilla frontal con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%2FIMG_0347.jpg?alt=media&token=257a95fe-9f3d-45e5-af92-eafb7c7a87ee")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Extensiones de cuadriceps en máquina":
                nombre.setText("Sentadilla frontal con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113031.jpg?alt=media&token=b7055a35-bb96-4797-a082-7fb395bbfee3")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Desplantes con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fdesplantes%20con%20mancuernas%2F20210131_112942.jpg?alt=media&token=2b6b25b6-e5c6-4057-be69-bd2cad0c2af6")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Sentadilla");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%2F20210131_112757.jpg?alt=media&token=2a0af82c-6b74-4d3f-9be7-a8bc9ea3af44")
                        .fit().centerCrop()
                        .into(imageView3);

                break;


            case "Sentadilla":
                nombre.setText("Sentadilla frontal con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20frontal%20con%20mancuernas%2F20210131_113031.jpg?alt=media&token=b7055a35-bb96-4797-a082-7fb395bbfee3")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Sentadilla con barra");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20con%20barra%2F20210206_111054.jpg?alt=media&token=7bb9cf31-7d1f-46b9-aef2-3f92d0d662aa")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Sentadilla smith a 90 grados");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fsentadilla%20a%2090%20grados%20en%20smith%2FIMG_0338.jpg?alt=media&token=5a256969-7282-4b20-a9f4-e6801d322f68")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



            case "Sentadilla frontal con mancuernas":
                nombre.setText("Prensa horizontal en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fprensa%20horizontal%20en%20maquina%2F20210202_115706.jpg?alt=media&token=71099f4e-277a-44f4-9d54-9b86509400a7")
                        .fit().centerCrop()
                        .into(imageView);

                nombre2.setText("Desplantes con mancuernas");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fdesplantes%20con%20mancuernas%2F20210131_112942.jpg?alt=media&token=2b6b25b6-e5c6-4057-be69-bd2cad0c2af6")
                        .fit().centerCrop()
                        .into(imageView2);

                nombre3.setText("Extensiones de cuadriceps en máquina");
                Picasso.get()
                        .load("https://firebasestorage.googleapis.com/v0/b/korellia-club-16586.appspot.com/o/ejercicios%2Fcuadriceps%2Fextensiones%20de%20cu%C3%A1driceps%20en%20maquina%2F20211215_111311.jpg?alt=media&token=fbafd51a-6f5b-48a2-a252-40a61c84f09d")
                        .fit().centerCrop()
                        .into(imageView3);

                break;



        }

                return vista;
    }





   // public void onDestroy() { super.onDestroy(); }


}
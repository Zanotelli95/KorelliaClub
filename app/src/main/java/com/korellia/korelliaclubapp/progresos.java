package com.korellia.korelliaclubapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.korellia.korelliaclubapp.databinding.FragmentHomeBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link progresos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class  progresos extends Fragment {

    View vista;
    Button calendario, brazorelajado, brazocontraccion, torax, umbilical, cintura, cadera, muslo, muslomedio, pantorrillas, pesocorporal, hidratacion, grasa;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public progresos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment progresos.
     */
    // TODO: Rename and change types and number of parameters
    public static progresos newInstance(String param1, String param2) {
        progresos fragment = new progresos();
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
        vista = inflater.inflate(R.layout.fragment_progresos, container, false);

        hidratacion = (Button) vista.findViewById(R.id.button13);
        calendario = (Button) vista.findViewById(R.id.button12);
        brazorelajado = (Button) vista.findViewById(R.id.button3);
        brazocontraccion = (Button) vista.findViewById(R.id.button4);
                torax = (Button) vista.findViewById(R.id.button5);
        grasa = (Button) vista.findViewById(R.id.button2);
                cintura = (Button) vista.findViewById(R.id.button7);
        cadera = (Button) vista.findViewById(R.id.button8);
                muslo = (Button) vista.findViewById(R.id.button9);
        muslomedio = (Button) vista.findViewById(R.id.button10);
                pantorrillas = (Button) vista.findViewById(R.id.button11);
                pesocorporal = (Button) vista.findViewById(R.id.button);

        calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), suscripcion.class);

                startActivity(intent);
            }
        });


        brazorelajado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), brazorelajado.class);


                startActivity(intent);


            }
        });

        grasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), suscripcion.class);

                startActivity(intent);

            }
        });

        brazocontraccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), brazocontraido.class);

                startActivity(intent);

            }
        });

        torax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), torax.class);

                startActivity(intent);
            }
        });


        cintura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), cintura.class);

                startActivity(intent);
            }
        });

        cadera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), cadera.class);

                startActivity(intent);
            }
        });


        muslo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), muslo.class);

                startActivity(intent);
            }
        });

        muslomedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), muslomedio.class);

                startActivity(intent);
            }
        });

        pantorrillas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), pantorrillas.class);

                startActivity(intent);
            }
        });

        pesocorporal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), pesocorporal.class);

                startActivity(intent);
            }
        });

            hidratacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), suscripcion.class);
                    startActivity(intent);
                }
            });

        return vista;
    }



}
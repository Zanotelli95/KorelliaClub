package com.korellia.korelliaclubapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link me#newInstance} factory method to
 * create an instance of this fragment.
 */
public class me extends Fragment {

    Button cerrarsesion;
    FirebaseAuth mAuth;
    TextView textnombre;
    TextView textapellido;
    TextView textpeso;
    TextView textalt;
    TextView textimc;
    TextView entrenos;
    private static final int gallery = 1;
    private ProgressDialog dialogo;

    DatabaseReference mRootReference;
    DatabaseReference mDatabase;
    TextView textobjetivo;
    ImageView perfil;
    StorageReference storage;

    Button ajustes;
    View vista;

    Button misdatos;

    //subir imagen
    private Uri mImageUri;
    private static final int PICK_IMAGE_REQUEST = 1;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public me() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment me.
     */
    // TODO: Rename and change types and number of parameters
    public static me newInstance(String param1, String param2) {
        me fragment = new me();
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
        vista = inflater.inflate(R.layout.fragment_me, container, false);
        perfil = (ImageView) vista.findViewById(R.id.imageView3);
        ajustes = (Button) vista.findViewById((R.id.button25));
        misdatos = (Button) vista.findViewById(R.id.button24);
        cerrarsesion = (Button) vista.findViewById(R.id.cerrarsesionboton);
        mAuth = FirebaseAuth.getInstance();


        mRootReference = FirebaseDatabase.getInstance().getReference();

        storage = FirebaseStorage.getInstance().getReference();
        entrenos = (TextView) vista.findViewById(R.id.textView267);
        dialogo = new ProgressDialog(getActivity());
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String id = mAuth.getCurrentUser().getUid();

        textobjetivo = (TextView) vista.findViewById(R.id.textobjetivorespuesta);
        textnombre = (TextView) vista.findViewById(R.id.textView41);
        textapellido = (TextView) vista.findViewById(R.id.textView410);
        textalt = (TextView) vista.findViewById(R.id.textView12);
        textpeso = (TextView) vista.findViewById(R.id.textView11);
        textimc = (TextView) vista.findViewById(R.id.textView13);


        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if (datasnapshot.exists()) {
                    String objetivo = datasnapshot.child("objetivo").getValue().toString();
                    String nombre = datasnapshot.child("name").getValue().toString();
                    String altura = datasnapshot.child("centimetros").getValue().toString();
                    String peso = datasnapshot.child("kilogramos").getValue().toString();
                    String apellido = datasnapshot.child("apellido").getValue().toString();
                    String entrenamientos = datasnapshot.child("diasentrenados").getValue().toString();

                    String sexo = datasnapshot.child("sexo").getValue().toString();

                    if (sexo.equals("Femenino")){

                        perfil.setImageResource(R.drawable.caritados);
                    } else {

                        perfil.setImageResource(R.drawable.carita);

                    }

                    textobjetivo.setText(objetivo);
                    textnombre.setText(nombre);
                    textapellido.setText(apellido);
                    textalt.setText(altura);
                    textpeso.setText(peso);
                    entrenos.setText(entrenamientos);

                    //formula imc = peso/altura * altura
                    //cambiar a int

                    float pesoimc = Float.parseFloat(peso);
                    float alturaimc = Float.parseFloat(altura);
                    float altura2 = alturaimc / 100;
                    float metros = altura2 * altura2;
                    float imc = pesoimc / metros;
                    imc = Math.round(imc * 1) / 1;
                    String imcfinal = Float.toString(imc);
                    textimc.setText(imcfinal);

                    String id = mAuth.getCurrentUser().getUid();

                    Map<String, Object> me = new HashMap<>();
                    me.put("IMC", imcfinal);


                    mRootReference.child("Users").child(id).updateChildren(me);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        cerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(getActivity(), inicio.class));
                getActivity().finish();
            }
        });

        ajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Ajustes.class);
                startActivity(intent);
            }
        });


        misdatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), misdatos.class);
                startActivity(intent);
            }
        });

        return vista;
    }


}



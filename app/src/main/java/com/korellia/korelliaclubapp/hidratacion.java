package com.korellia.korelliaclubapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.Arrays;

public class hidratacion extends AppCompatActivity {

    private ProgressBar progressBar;
    Button mas, menos;
    EditText agua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidratacion);

        Toolbar toolbar = findViewById(R.id.toolbarhidratacion);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Agua");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        progressBar = findViewById(R.id.progressBar);
        mas = findViewById(R.id.button15);
        menos = findViewById(R.id.button14);
        agua = findViewById(R.id.editTextNumber);
        int num = 0;
        final int[] num2 = {0};
        int incremento = 100;
        int intArray[] = {};


        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // int totalsuma = incremento + num;
                int incremento2 = num + incremento;
                num2[0] = intArray[incremento2];

                agua.setText(Arrays.toString(num2));


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
}
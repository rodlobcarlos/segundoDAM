package com.example.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
        Bundle b = new Bundle(getIntent().getExtras());
        Log.i("Datos", b.getString("Surname"));
        TextView miTexto = (TextView) findViewById(R.id.texto);
        miTexto.setText(("Nuevo texto para mostrar"));
        Typeface miFuente = Typeface.createFromAsset((getAssets()),"fonts/karla.ttf");


    }
}

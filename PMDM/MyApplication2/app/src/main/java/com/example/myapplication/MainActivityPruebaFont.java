package com.example.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPruebaFont extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedIns) {
        super.onCreate(savedIns);
        setContentView(R.layout.activity_prueba_font);  // Llamada al XML

        TextView tvMensaje = (TextView) findViewById(R.id.texto2);
        tvMensaje.setText("Nuevo texto para mostrar");
    }

    // Método para el botón con android:onClick
    public void cambiarTextoXML(View view) {
        TextView tvMensaje = (TextView) findViewById(R.id.texto2);
        tvMensaje.setText("Texto cambiado desde XML");
    }
}

package com.example.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPruebaFont extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_font);
        Bundle b = new Bundle(getIntent().getExtras());
        Log.i("Datos", b.getString("Surname"));
        TextView miTexto = (TextView) findViewById(R.id.texto2);
        miTexto.setText(("Nuevo texto para mostrar"));
        miTexto.setTextColor(getResources().getColor(R.color.principal));
        Animation miAnimacion = AnimationUtils.loadAnimation(this,R.anim.animacion);
        miAnimacion.setRepeatMode(Animation.RESTART);
        miAnimacion.setRepeatCount(20);
        miTexto.startAnimation(miAnimacion);
     }
}

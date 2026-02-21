package com.example.livetasks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MonitoreoActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_monitoreo);
        // 1. Buscamos la barra que pusimos en el XML
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_tareas);

        // 2. Le decimos a la App que esta es la "ActionBar" oficial
        setSupportActionBar(toolbar);

        // 1. Vincular con el XML
        progressBar = findViewById(R.id.barraProgreso);

        // 2. Cambiar el valor manualmente
        progressBar.setProgress(50);
        
        Button btnTarea = findViewById(R.id.btn_tareas);
        btnTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MonitoreoActivity.this, TareasActivity.class);
                startActivity(intent);
            }
        });

        Button btnCalendario = findViewById(R.id.btn_calendario);
        btnCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MonitoreoActivity.this, CalendarioActivity.class);
                startActivity(intent);
            }
        });

        Button btnNotas = findViewById(R.id.btn_notas);
        btnNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MonitoreoActivity.this, NotasActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("menus",item.toString());
        int id = item.getItemId();

        if (id == R.id.acount) {
            // Aquí es donde conectas la acción
            Intent intent = new Intent(MonitoreoActivity.this, CuentaActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.example.livetasks;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TareasActivity extends AppCompatActivity {

    private ScrollView scrollContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tareas);

        scrollContent = findViewById(R.id.scroll_tareas);

        scrollContent.post(() -> scrollContent.fullScroll(ScrollView.FOCUS_UP));

        // 1. Buscamos la barra que pusimos en el XML
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_tareas);

        // 2. Le decimos a la App que esta es la "ActionBar" oficial
        setSupportActionBar(toolbar);

        Button btnCalendario = findViewById(R.id.btn_calendario);
        btnCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TareasActivity.this, CalendarioActivity.class);
                startActivity(intent);
            }
        });

        Button btnMonitoreo = findViewById(R.id.btn_monitoreo);
        btnMonitoreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TareasActivity.this, MonitoreoActivity.class);
                startActivity(intent);
            }
        });

        Button btnNotas = findViewById(R.id.btn_notas);
        btnNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TareasActivity.this, NotasActivity.class);
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
            Intent intent = new Intent(TareasActivity.this, CuentaActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
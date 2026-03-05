package com.example.livetasks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalendarioActivity extends AppCompatActivity {

    private ScrollView scrollContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calendario);

        scrollContent = findViewById(R.id.scroll_content);

        scrollContent.post(() -> scrollContent.fullScroll(ScrollView.FOCUS_UP));

        // 1. Buscamos la barra que pusimos en el XML
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_tareas);

        // 2. Le decimos a la App que esta es la "ActionBar" oficial
        setSupportActionBar(toolbar);

        CalendarView calendarView = findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                // El mes (month) empieza en 0 (Enero es 0, Diciembre es 11)
                String fechaSeleccionada = dayOfMonth + "/" + (month + 1) + "/" + year;
            }
        });

        Button btnTarea = findViewById(R.id.btn_tareas);
        btnTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarioActivity.this, TareasActivity.class);
                startActivity(intent);
            }
        });

        Button btnMonitoreo = findViewById(R.id.btn_monitoreo);
        btnMonitoreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarioActivity.this, MonitoreoActivity.class);
                startActivity(intent);
            }
        });

        Button btnNotas = findViewById(R.id.btn_notas);
        btnNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarioActivity.this, NotasActivity.class);
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
            Intent intent = new Intent(CalendarioActivity.this, CuentaActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
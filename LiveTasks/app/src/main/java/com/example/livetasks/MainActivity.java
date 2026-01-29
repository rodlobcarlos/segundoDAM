package com.example.livetasks;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuelemento, menu);
    }

    // Capturamos las opciones
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Log.i("menus",item.toString());
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("menus",item.toString());
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Datos> datos = new ArrayList<Datos>();
        datos.add(new Datos("Cosas importantes", "Ahorrar para una casa y coche, pagar cosas."));
        datos.add(new Datos("Mandados", "Comprar el pan, limpiar la casa, ir de compras."));
        datos.add(new Datos("Cosas a comprar en el futuro", "Mueble, tele nueva, móvil, renovar colchón."));

        ListView listado = (ListView) findViewById(R.id.miLista);
        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);
        registerForContextMenu(listado);
    }
}
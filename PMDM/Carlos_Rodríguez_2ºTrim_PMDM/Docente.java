package android.ejemplo.examencarlosrodriguez;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Docente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_docente);

        ArrayList<Datos> datos = new ArrayList<Datos>();
        datos.add(new Datos("Juan López", "1ºDAM"));
        datos.add(new Datos("Manuela Romero", "1ºDAM"));
        datos.add(new Datos("Angela García", "1ºDAM"));
        datos.add(new Datos("Ana Sanz", "1ºDAM"));
        datos.add(new Datos("Raúl Raminez", "2ºDAM"));

        ListView listado = (ListView) findViewById(R.id.listaAlumnos);
        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);

        listado.setAdapter(miAdaptador);
        registerForContextMenu(listado);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Pulsado", "Elemento pulsado: "+ position);
                Log.i("Pulsado", "Elemento pulsado: "+(Datos) parent.getItemAtPosition(position));
            }
        });

        Button btnAcceso = findViewById(R.id.añadir);
        btnAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Docente.this, "Alumno añadido", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.docentemenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("menus",item.toString());
        return super.onOptionsItemSelected(item);
    }
}
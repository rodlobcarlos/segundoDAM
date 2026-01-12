package android.ejemplo.segundotrimestre;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        /**
        String[] opciones = {"Ford mustang", "Maclaren", "Mercedes", "Toyota", "Mazda", "Honda", "Jeep", "Seat"};
        AutoCompleteTextView textoLeido = (AutoCompleteTextView) findViewById(R.id.miTexto);
        ArrayAdapter<String> adapador = new ArrayAdapter<String> (this, android.R.layout.simple_dropdown_item_1line, opciones);
        textoLeido.setAdapter(adapador);
**/

        /**
        SeekBar miControl = (SeekBar) findViewById(R.id.miSeekBar);
        miControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("MiBar","volumen:"+ seekBar.getProgress());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i("MiBar","volumen inicial:"+ seekBar.getProgress());
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i("MiBar","volumen final:"+ seekBar.getProgress());
            }
        });
         **/

/**
        RatingBar controlRating =  (RatingBar) findViewById(R.id.myRating);
        controlRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.i("Rating","Valor de rating: "+rating);
            }
        });
 **/

/**
        ListView listado = (ListView) findViewById(R.id.miLista);
        final String[] datos = new String[]{"Tulipan", "Margarita", "Margarita", "Rosa", "Clavel", "Gardenia", "Girasol","Jazmin"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        listado.setAdapter(adaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Pulsado", "Flor pulsada (posicion): "+position);
                Log.i("Pulsado", "Flor pulsada: "+(String) parent.getItemAtPosition(position));
            }
        });
**/

/**
        GridView listado = (GridView) findViewById(R.id.miGrid);
        final String[] datos = new String[]{"Casa", "Coche", "Garaje", "Mesa", "Jardin", "Piscina","Cesped","Fachada"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        listado.setAdapter(adaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Pulsado", "Elemento de casa pulsado (posicion): "+position);
                Log.i("Pulsado", "Elemento de casa pulsado: "+(String) parent.getItemAtPosition(position));
            }
        });

**/

/**
        Spinner listaSpinner = (Spinner) findViewById(R.id.miSpinner);
        final String[] datosSpinner = new String[]{"LaLiga", "NBA", "NFL", "Hockey", "Golf"};
        ArrayAdapter<String> adaptadorSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datosSpinner);
        listaSpinner.setAdapter(adaptadorSpinner);

        listaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Pulsado", "Deporte pulsado (posicion): "+position);
                Log.i("Pulsado", "Deporte pulsado: "+(String) parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
**/

        Datos[] datos = new Datos[]{
                new Datos("Campo", "field"),
                new Datos("Coche", "Car"),
                new Datos("Lapiz", "Pen"),
                new Datos("Amor", "Love"),
                new Datos("Piña", "Pineapple")  
        };
        ListView listado = (ListView) findViewById(R.id.miLista);
        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);
    }
}
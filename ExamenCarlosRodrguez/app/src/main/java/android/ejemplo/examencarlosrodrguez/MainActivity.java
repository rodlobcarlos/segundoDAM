package android.ejemplo.examencarlosrodrguez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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


        Button miBoton = (Button) findViewById(R.id.boton1);

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cliente = new Intent(MainActivity.this, ActividadCliente.class);
                startActivity(cliente);
            }
        });

        Button miBoton2 = (Button) findViewById(R.id.boton2);

        miBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent peluqueria = new Intent(MainActivity.this, ActividadPeluqueria.class);
                startActivity(peluqueria);
            }
        });
    }
}
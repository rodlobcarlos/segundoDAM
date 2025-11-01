package android.ejemplo.es;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class Actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        Intent ejemplo= new Intent(Intent.ACTION_VIEW);
        ejemplo.setData(Uri.parse("https://www.google.es"));
        startActivity(ejemplo);

    }
}
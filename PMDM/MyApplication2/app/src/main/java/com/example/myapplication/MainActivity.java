package com.example.myapplication;

import static android.Manifest.permission.CALL_PHONE;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    /*
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
    }


    int permisionCheck = ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.CAMERA);

    @Override
    public void onRequestPermissionResult(int requestCode, String permission[], int[] grantResults) {
        switch (requestCode){
            case MY_PERMISSIONS_CAMARA: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    System.out.println("Accept.");
                }else {
                    System.out.println("Error.");
                }
                return;
            }
     */
    /*

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
        Intent ejemplo = new Intent(this, MainActivity2.class);
        startActivity(ejemplo);
        Intent ejemplo2 = new Intent(Intent.ACTION_VIEW);
        ejemplo2.setData(Uri.parse("https://blogsaverroes.juntadeandalucia.es/iestorrredelosguzmanes/"));
        startActivity(ejemplo2);
    }

     */

    /*
    private static final int REQUEST_CAMERA_PERMISSION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        Intent ejemplo1 = new Intent(this, MainActivity2.class);
        startActivity(ejemplo1);

        Intent ejemplo3 = new Intent(Intent.ACTION_CALL);
        ejemplo3.setData(Uri.parse("tel:621059723"));
        startActivity(ejemplo3);

        Intent ejemplo2 = new Intent(this, MainActivity2.class);
        startActivity(ejemplo2);

        super.onStart();
        setContentView(R.layout.activity_actividad1);
        // Verificar si el permiso de cámara está concedido
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            // Si ya tiene permiso, abrir la cámara
            abrirCamara();
        } else {
            // Si no tiene permiso, solicitarlo
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.CAMERA},
                    REQUEST_CAMERA_PERMISSION);
        }
    }

    private void abrirCamara() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); // Acción para abrir la cámara
        startActivity(intent);  // Lanzar la actividad de la cámara

    }

     */


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onStart() {

        super.onStart();
        Intent ejemplo = new Intent(this, MainActivityPruebaFont.class);
        ejemplo.putExtra("Surname", "Rodríguez");
        startActivity(ejemplo);
    }



}

package android.ejemplo.examencarlosrodriguez;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        EditText etUsuario = findViewById(R.id.usuario);
        EditText etContraseña = findViewById(R.id.contraseña);
        Button btnAcceso = findViewById(R.id.btn_acceso);

        btnAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userText = etUsuario.getText().toString();
                String passText = etContraseña.getText().toString();

                if (userText.equals("docente") && passText.equals("docente")) {
                    Intent intent = new Intent(LoginActivity.this, Docente.class);
                    startActivity(intent);
                }
                else if (userText.equals("estudiante") && passText.equals("estudiante")) {
                    Intent intent = new Intent(LoginActivity.this, Estudiante.class);
                    startActivity(intent);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Usuario o contraseña incorrecta")
                            .setTitle("Vuelve a intentarlo.")
                            .setIcon(R.mipmap.ic_launcher)
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Log.i("Elegido","Aceptar");
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }
}
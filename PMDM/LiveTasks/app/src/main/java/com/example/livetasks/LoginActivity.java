package com.example.livetasks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnCliente = findViewById(R.id.btn_cliente);
        btnCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, PlanActivity.class);
                startActivity(intent);
            }
        });

        Button btnAdmin = findViewById(R.id.btn_admin);
        btnAdmin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Iniciado como administrador", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                startActivity(intent);            }
        });

        Button btnGoogle = findViewById(R.id.btn_google);
        btnGoogle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Iniciado con Google", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, TareasActivity.class);
                startActivity(intent);
            }
        });
    }
}
package com.example.livetasks;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class PlanActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "canal_basico_1";
    private static final int NOTIFICATION_ID = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_plan);

        // Verificamos si la versión es Android 13 (API 33) o superior
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {

                // Solicita el permiso al usuario
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
            }
        }

        createNotificationChannel();

        Button btnPro = findViewById(R.id.btn_pro);
        btnPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, PlanProActivity.class);
                startActivity(intent);
            }
        });

        // 1. Crear el canal de notificaciones (Solo necesario en Android 8.0+)

        Button btnFree = findViewById(R.id.btn_free);
        btnFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, TareasActivity.class);
                lanzarNotificacion();
                startActivity(intent);
            }
        });
    };

    private void createNotificationChannel() {
        // Solo se crea el canal si la versión es Android 8.0 (API 26) o superior
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notificaciones Básicas";
            String description = "Canal para aprender notificaciones";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Registrar el canal en el sistema
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    private void lanzarNotificacion() {

        Intent intent = new Intent(this, TareasActivity.class);

        // Esto sirve para que al dar atrás, no vuelvas a la notificación, sino que se maneje la pila de apps
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        // 2. Crear el PendingIntent
        // IMPORTANTE: Desde Android 12 (API 31) es obligatorio especificar MUTABLE o IMMUTABLE
        int flags = PendingIntent.FLAG_UPDATE_CURRENT;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            flags |= PendingIntent.FLAG_IMMUTABLE;
        }

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, flags);

        // 3. Construir la notificación con el .setContentIntent
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("¡¡Bienvenido a tu plan gratutito de Live&Tasks!!")
                .setContentText("Disfruta de tu experiencia con esta mágnifica aplicación de gestión de tareas con IA.")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                // AQUI conectamos el PendingIntent:
                .setContentIntent(pendingIntent)
                // AQUI decimos que la notificación desaparezca al tocarla:
                .setAutoCancel(true);

        // 4. Mostrar la notificación (esto sigue igual)
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
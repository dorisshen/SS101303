package com.example.student.ss101303;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private NotificationManager nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void click1(View view) {
        Notification.Builder builder = new Notification.Builder(MainActivity.this);
        Intent it = new Intent(MainActivity.this, MainActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_SINGLE_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TOP);
        int requestCode = 1;
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,
                requestCode, it, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentTitle("Test1")
                .setContentText("This is a test")
                .setSmallIcon(R.drawable.images)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        Notification notification = builder.build();
        nm.notify(123, notification);
    }
}

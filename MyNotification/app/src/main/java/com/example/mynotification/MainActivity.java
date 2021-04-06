package com.example.mynotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.DialogFragment;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationManager nm;
    PendingIntent pi;
    Intent i;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createMyNotificationchannel();

        i=new Intent(this,MainActivity.class);
        pi=PendingIntent.getActivity(this,23,i,PendingIntent.FLAG_CANCEL_CURRENT);

    }

    private void createMyNotificationchannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel nc=new NotificationChannel("MYID","MYCHANNEL",
                    NotificationManager.IMPORTANCE_HIGH);
            nc.enableLights(true);
            nc.setLightColor(Color.BLUE);
            nc.enableVibration(true);
            nm.createNotificationChannel(nc);




        }
    }

    public void showNotification(View view) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"MYID");
        builder.setContentTitle("My Notification");
        builder.setContentText("This is our own notification");
        builder.setSmallIcon(R.drawable.ic_notifications_black_24dp);
        builder.setPriority(Notification.PRIORITY_HIGH);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        builder.addAction(R.drawable.ic_reply_black_24dp,"Reply",pi);
        nm.notify(1,builder.build());





    }
}

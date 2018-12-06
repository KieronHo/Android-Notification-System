package com.example.notificationsystem;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    static final String CHANNEL_ID = "default";
    static final int importance = NotificationManager.IMPORTANCE_HIGH;
    static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpNotificationChannel();
    }


    private NotificationChannel setUpNotificationChannel(){

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                    getString(R.string.channel_name), importance);
            channel.setDescription(getString(R.string.channel_description));
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            return channel;
        }
        else
        return null;
    }


    public void sendNotificationAction(View view){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID);
        mBuilder.setSmallIcon(R.drawable.ic_stat_onesignal_default);
        mBuilder.setContentTitle("Default Notification Alert");
        mBuilder.setContentText("More Detailed Message Text");
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
}

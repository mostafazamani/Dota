package com.ba.dota;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;

import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Timer;
import java.util.TimerTask;

public class ChestNotification extends Service {
    Timer timer;
    TimerTask timerTask;


    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

       // Toast.makeText(this, "start", Toast.LENGTH_SHORT).show();

        startTimer();

        return START_STICKY;
    }


    @Override
    public void onCreate() {
       // Toast.makeText(this, "create", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {

       // Toast.makeText(this, "destroy", Toast.LENGTH_SHORT).show();
        stoptimertask();
        super.onDestroy();


    }

    final Handler handler = new Handler();


    public void startTimer() {

        timer = new Timer();

        initializeTimerTask();

        timer.schedule(timerTask, 86400000, 86400000);
    }

    public void stoptimertask() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void initializeTimerTask() {

        timerTask = new TimerTask() {
            public void run() {

                handler.post(new Runnable() {
                    public void run() {

                        final String url = "https://www.dropbox.com/s/hq81xgaqdzwrxvm/checknotification.txt?dl=1";


                        RequestQueue requestQueue = Volley.newRequestQueue(ChestNotification.this);
                        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                               // Toast.makeText(ChestNotification.this, "" + response, Toast.LENGTH_SHORT).show();

                                if (("new").equals(response))chestAlarm(ChestNotification.this);

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {



                            }
                        });

                        requestQueue.add(request);



                    }
                });
            }
        };

    }

    private void chestAlarm(Context ctx) {
        Intent intent = new Intent(ctx, Chest.class);
        PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder b = new NotificationCompat.Builder(ctx);

        b.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.chest)
                .setTicker("Hearty365")
                .setContentTitle("صندوق های شانس بروز شدن")
                .setContentText("وقتشه ی نگاهی به صندوق های شانس بندازی،آیتم جدید اوردیم")
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND)
                .setContentIntent(contentIntent)
                .setContentInfo("Info");


        NotificationManager notificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(1, b.build());


    }




}

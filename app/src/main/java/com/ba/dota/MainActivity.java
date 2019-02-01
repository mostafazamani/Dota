package com.ba.dota;

import android.app.ActivityManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ba.dota.hero.agility.AntiMage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button store, btn, heros_bio, about_us,exit;
    DbUtil dbUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        store = (Button) findViewById(R.id.store);
        heros_bio = (Button) findViewById(R.id.bio);
        about_us = (Button) findViewById(R.id.about_us);
        exit = (Button) findViewById(R.id.exit);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.main_layout);




        try {
            final int versionCode = (MainActivity.this).getPackageManager()
                    .getPackageInfo((MainActivity.this).getPackageName(), 0).versionCode;


            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);


            JsonRequest jsonRequest = new JsonRequest(Request.Method.GET, "http://www.prodall.ir/myupload/version.json", null, new Response.Listener() {
                @Override
                public void onResponse(Object response) {

                    try {
                        JSONArray jsonArray = new JSONArray(response.toString());

                        JSONObject jsonObject = jsonArray.getJSONObject(0);

                        if (!(versionCode == jsonObject.getInt("verapp"))) {


                            if (jsonObject.getBoolean("force")) {

                                new AlertDialog.Builder(MainActivity.this)
                                        .setTitle("UpDate request")
                                        .setMessage("ایا میخواهید برنام را بروز رسانی کنید؟ ")
                                        .setPositiveButton("بله", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.prodall.ir"));
                                                startActivity(myIntent);

                                            }
                                        })
                                        .setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                finishAffinity();
                                                System.exit(0);
                                            }
                                        })
                                        .setCancelable(false)
                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .show();

                            } else {


                                new AlertDialog.Builder(MainActivity.this)
                                        .setTitle("UpDate request")
                                        .setMessage("ایا میخواهید برنام را بروز رسانی کنید؟ ")
                                        .setPositiveButton("بله", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.prodall.ir"));
                                                startActivity(myIntent);
                                                dialog.dismiss();

                                            }
                                        })
                                        .setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .setCancelable(false)
                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .show();

                            }

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();

                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {


                }
            }) {
                @Override
                protected Response parseNetworkResponse(NetworkResponse response) {
                    try {
                        String jsonString = new String(response.data,
                                HttpHeaderParser.parseCharset(response.headers));
                        return Response.success(new JSONArray(jsonString),
                                HttpHeaderParser.parseCacheHeaders(response));
                    } catch (UnsupportedEncodingException e) {
                        return Response.error(new ParseError(e));
                    } catch (JSONException je) {
                        return Response.error(new ParseError(je));
                    }
                }

                @Override
                public int compareTo(@NonNull Object o) {
                    return 0;
                }
            };
            requestQueue.add(jsonRequest);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }




        dbUtil = new DbUtil(this);

        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));

            }
        });

        heros_bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HerosBio.class));
            }
        });
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Store.class));
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("")
                        .setMessage("ایا میخواهید خارج شوید؟ ")
                        .setPositiveButton("بله", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finishAffinity();
                                System.exit(0);
                            }
                        })
                        .setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setCancelable(false)
                        .setIcon(android.R.drawable.stat_sys_warning)
                        .show();
            }
        });


        if (isAppRunning()) dbUtil.EmptyTable();

    }

    private boolean isAppRunning() {
        ActivityManager m = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfoList = m.getRunningTasks(10);
        Iterator<ActivityManager.RunningTaskInfo> itr = runningTaskInfoList.iterator();
        int n = 0;
        while (itr.hasNext()) {
            n++;
            itr.next();
        }
        if (n == 1) { // App is killed
            return false;
        }

        return true; // App is in background or foreground
    }


    public static void update(Context ctx) {
        String urlup = "http://prodall.ir/?p=39";


        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlup));
        PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder b = new NotificationCompat.Builder(ctx);

        b.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("Hearty365")
                .setContentTitle("Update")
                .setContentText("UpDate")
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND)
                .setContentIntent(contentIntent)
                .setContentInfo("Info");


        NotificationManager notificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(1, b.build());


    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("")
                .setMessage("ایا میخواهید خارج شوید؟ ")
                .setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                        System.exit(0);
                    }
                })
                .setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(false)
                .setIcon(android.R.drawable.stat_sys_warning)
                .show();

    }
}

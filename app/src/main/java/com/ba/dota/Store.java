package com.ba.dota;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class Store extends AppCompatActivity {
    Button st, ag, in, cart, chest , tra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);


        tra = (Button) findViewById(R.id.go_training);
        st = (Button) findViewById(R.id.go_st);
        ag = (Button) findViewById(R.id.go_ag);
        in = (Button) findViewById(R.id.go_int);
        chest = (Button) findViewById(R.id.go_chest);
        cart = (Button) findViewById(R.id.go_store);

        try {
            final int versionCode = (Store.this).getPackageManager()
                    .getPackageInfo((Store.this).getPackageName(), 0).versionCode;


            RequestQueue requestQueue = Volley.newRequestQueue(Store.this);


            JsonRequest jsonRequest = new JsonRequest(Request.Method.GET, "http://www.prodall.ir/myupload/version.json", null, new Response.Listener() {
                @Override
                public void onResponse(Object response) {

                    try {
                        JSONArray jsonArray = new JSONArray(response.toString());

                        JSONObject jsonObject = jsonArray.getJSONObject(0);

                        if (!(versionCode == jsonObject.getInt("verapp"))) {


                            if (jsonObject.getBoolean("force")) {

                                new AlertDialog.Builder(Store.this)
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
                                                System.exit(0);
                                            }
                                        })
                                        .setCancelable(false)
                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .show();

                            } else {


                               MainActivity.update(Store.this);

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


        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Store.this, StrengthStore.class));

            }
        });
        ag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Store.this, AgilityStore.class));

            }
        });

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Store.this, InteligenceStore.class));

            }
        });
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Store.this, Chest.class));

            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Store.this, ShowList.class));

            }
        });

        tra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Store.this, Training.class));

            }
        });


    }


}

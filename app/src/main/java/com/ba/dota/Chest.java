package com.ba.dota;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.ba.dota.hero.agility.AntiMage;
import com.ba.dota.hero.agility.ArcWarden;
import com.ba.dota.hero.agility.Bloodseeker;
import com.ba.dota.hero.agility.BountyHunter;
import com.ba.dota.hero.agility.Broodmother;
import com.ba.dota.hero.agility.Clinkz;
import com.ba.dota.hero.agility.DrowRanger;
import com.ba.dota.hero.agility.EmberSpirit;
import com.ba.dota.hero.agility.FacelessVoid;
import com.ba.dota.hero.agility.Gyrocopter;
import com.ba.dota.hero.agility.Juggernaut;
import com.ba.dota.hero.agility.LoneDruid;
import com.ba.dota.hero.agility.Luna;
import com.ba.dota.hero.agility.Medusa;
import com.ba.dota.hero.agility.Meepo;
import com.ba.dota.hero.agility.Mirana;
import com.ba.dota.hero.agility.MonkeyKing;
import com.ba.dota.hero.agility.Morphling;
import com.ba.dota.hero.agility.NagaSiren;
import com.ba.dota.hero.agility.NyxAssassin;
import com.ba.dota.hero.agility.Pangolier;
import com.ba.dota.hero.agility.PhantomAssassin;
import com.ba.dota.hero.agility.PhantomLancer;
import com.ba.dota.hero.agility.Razor;
import com.ba.dota.hero.agility.Riki;
import com.ba.dota.hero.agility.ShadowFiend;
import com.ba.dota.hero.agility.Slark;
import com.ba.dota.hero.agility.Sniper;
import com.ba.dota.hero.agility.Spectre;
import com.ba.dota.hero.agility.TemplarAssassin;
import com.ba.dota.hero.agility.Terrorblade;
import com.ba.dota.hero.agility.TrollWarlord;
import com.ba.dota.hero.agility.Ursa;
import com.ba.dota.hero.agility.VengefulSpirit;
import com.ba.dota.hero.agility.Venomancer;
import com.ba.dota.hero.agility.Viper;
import com.ba.dota.hero.agility.Weaver;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Chest extends AppCompatActivity {

    Button text_dis, pay_chest_1, pay_chest_2, pay_chest_3;
    ImageView chest_11, chest_21, chest_31, chest_41, chest_51; //chest one
    ImageView chest_12, chest_22, chest_32, chest_42, chest_52; //chest two
    ImageView chest_13, chest_23, chest_33, chest_43, chest_53; //chest three

   static String url = "https://www.dropbox.com/s/thrr531fu7k5wu5/Chest%201.json?dl=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        pay_chest_1 = (Button) findViewById(R.id.pay_chest_1);
        pay_chest_2 = (Button) findViewById(R.id.pay_chest_2);
        pay_chest_3 = (Button) findViewById(R.id.pay_chest_3);

        chest_11 = (ImageView) findViewById(R.id.chest_11); //aks aval radif aval
        chest_21 = (ImageView) findViewById(R.id.chest_21);
        chest_31 = (ImageView) findViewById(R.id.chest_31);
        chest_41 = (ImageView) findViewById(R.id.chest_41);
        chest_51 = (ImageView) findViewById(R.id.chest_51);

        setImagechest(url,0,chest_11);
        setImagechest(url,1,chest_21);
        setImagechest(url,2,chest_31);
        setImagechest(url,3,chest_41);
        setImagechest(url,4,chest_51);


        chest_12 = (ImageView) findViewById(R.id.chest_12); //aks aval radif dovom
        chest_22 = (ImageView) findViewById(R.id.chest_22);
        chest_32 = (ImageView) findViewById(R.id.chest_32);
        chest_42 = (ImageView) findViewById(R.id.chest_42);
        chest_52 = (ImageView) findViewById(R.id.chest_52);

        setImagechest(url,0,chest_12);
        setImagechest(url,1,chest_22);
        setImagechest(url,2,chest_32);
        setImagechest(url,3,chest_42);
        setImagechest(url,4,chest_52);



        chest_13 = (ImageView) findViewById(R.id.chest_13); //aks aval radif seyom :)
        chest_23 = (ImageView) findViewById(R.id.chest_23);
        chest_33 = (ImageView) findViewById(R.id.chest_33);
        chest_43 = (ImageView) findViewById(R.id.chest_43);
        chest_53 = (ImageView) findViewById(R.id.chest_53);

        setImagechest(url,0,chest_13);
        setImagechest(url,1,chest_23);
        setImagechest(url,2,chest_33);
        setImagechest(url,3,chest_43);
        setImagechest(url,4,chest_53);





        startService(new Intent(this, ChestNotification.class));



        pay_chest_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chest.this, ChestPay.class);
                intent.putExtra("number", 1);
                startActivity(intent);
            }
        });

        pay_chest_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chest.this, ChestPay.class);
                intent.putExtra("number", 2);
                startActivity(intent);
            }
        });
        pay_chest_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chest.this, ChestPay.class);
                intent.putExtra("number", 3);
                startActivity(intent);
            }
        });
    }

    public void setImagechest(String url, final int pos, final ImageView image){


        final String[] imagechest = {null};

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());


        JsonRequest jsonRequest = new JsonRequest(Request.Method.GET, url, null, new Response.Listener() {
            @Override
            public void onResponse(Object response) {


                imagechest[0] = JsonChestItem.Item(response.toString()).get(pos).getUri_image();

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                final ImageRequest request = new ImageRequest(imagechest[0], new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        image.setImageBitmap(response);

                    }
                }, 160, 160, ImageView.ScaleType.FIT_CENTER, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                requestQueue.add(request);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                imagechest[0] =null;
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

    }



}

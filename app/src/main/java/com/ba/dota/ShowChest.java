package com.ba.dota;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;

public class ShowChest extends AppCompatActivity {

    ImageView open_image;
    Button open_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_chest);

        open_btn = (Button) findViewById(R.id.open_btn);
        open_image = (ImageView) findViewById(R.id.open_image);

        open_image.setVisibility(View.INVISIBLE);

        int chest = getIntent().getIntExtra("numberchest",0);
        int pos = getIntent().getIntExtra("numberitem",6);

        setOpen_images(Chest.url,pos,open_image);





        open_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_image.setVisibility(View.VISIBLE);
                open_image.startAnimation(AnimationUtils.loadAnimation(ShowChest.this,R.anim.chest_anim));

            }
        });

    }



    public void setOpen_images(String url, final int pos, final ImageView image){

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

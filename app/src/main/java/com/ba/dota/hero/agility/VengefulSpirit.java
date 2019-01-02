package com.ba.dota.hero.agility;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.ba.dota.Agilitylistitem;
import com.ba.dota.JsonAgilityItem;
import com.ba.dota.ListStoreAgility;
import com.ba.dota.R;
import com.ba.dota.ShowList;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Vahid Aali on 10/5/2018.
 */

public class VengefulSpirit extends AppCompatActivity {

    ListView listView;
    List<Agilitylistitem> list;
    ListStoreAgility agility;
    TextView textView;

    public static final String url = "https://www.dropbox.com/s/md2a59hdi4r2l46/Vengeful%20Spirit.json?dl=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_item);

        listView = (ListView) findViewById(R.id.list_hshop);
        Button button = (Button) findViewById(R.id.btn_hlist);
        textView = (TextView) findViewById(R.id.text_hlist);
        final ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar_hero_item);


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());


        JsonRequest jsonRequest = new JsonRequest(Request.Method.GET, url, null, new Response.Listener() {
            @Override
            public void onResponse(Object response) {

                bar.setVisibility(View.INVISIBLE);

                String json = response.toString();
                list = JsonAgilityItem.Item(json);
                agility = new ListStoreAgility(list, getApplicationContext(),VengefulSpirit.this);
                listView.setAdapter(agility);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

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



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VengefulSpirit.this, ShowList.class));
                finish();

            }
        });
    }

}

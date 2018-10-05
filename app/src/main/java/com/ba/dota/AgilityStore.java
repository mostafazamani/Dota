package com.ba.dota;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
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

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class AgilityStore extends AppCompatActivity {

    ListView listView;
    List<Hero> list;
    HeroSAdapte strength;


    public static final String url = "https://www.dropbox.com/s/e8hjpjbqs071y2l/Agility.json?dl=1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agility_store);
        listView = (ListView) findViewById(R.id.list_shopa);

        Button button = (Button) findViewById(R.id.btn_alist);


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());


        JsonRequest jsonRequest = new JsonRequest(Request.Method.GET, url, null, new Response.Listener() {
            @Override
            public void onResponse(Object response) {


                String json = response.toString();
                list = JsonHero.Item(json);
                strength = new HeroSAdapte(list,getApplicationContext());
                listView.setAdapter(strength);


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (list.get(position).getName()){

                            case("Anti Mage"):

                                startActivity(new Intent(AgilityStore.this, ShowList.class));
                                break;
                            case ("Arc Warden"):

                                break;
                            case ("Bloodseeker"):

                                break;
                            case ("Bounty Hunter"):

                                break;
                            case ("Broodmother"):

                                break;
                            case ("Clinkz"):

                                break;
                            case ("Drow Ranger"):

                                break;
                            case ("Ember Spirit"):

                                break;
                            case ("Faceless Void"):

                                break;
                            case ("Gyrocopter"):

                                break;
                            case ("Juggernaut"):

                                break;
                            case ("Lone Druid"):

                                break;
                            case ("Luna"):

                                break;
                            case ("Medusa"):

                                break;
                            case ("Meepo"):

                                break;
                            case ("Mirana"):

                                break;
                            case ("Monkey King"):

                                break;
                            case ("Morphling"):

                                break;
                            case ("Naga Siren"):

                                break;
                            case ("Nyx Assassin"):

                                break;
                            case ("Pangolier"):

                                break;
                            case ("Phantom Assassin"):

                                break;
                            case ("Phantom Lancer"):

                                break;
                            case ("Razor"):

                                break;
                            case ("Riki"):

                                break;
                            case ("Shadow Fiend"):

                                break;
                            case ("Slark"):

                                break;
                            case ("Sniper"):

                                break;
                            case ("Spectre"):

                                break;
                            case ("Templar Assassin"):

                                break;
                            case ("Terrorblade"):

                                break;
                            case ("Troll Warlord"):

                                break;
                            case ("Ursa"):

                                break;
                            case ("Vengeful Spirit"):

                                break;
                            case ("Venomancer"):

                                break;
                            case ("Viper"):

                                break;
                            case ("Weaver"):

                                break;

                            default:
                                break;

                        }



                    }
                });




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
                startActivity(new Intent(AgilityStore.this, ShowList.class));
            }
        });


    }
}

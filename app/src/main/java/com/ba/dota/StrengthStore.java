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
import com.ba.dota.hero.strength.Abaddon;
import com.ba.dota.hero.strength.Axe;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class StrengthStore extends AppCompatActivity {

    ListView listView;
    List<Hero> list;
    HeroSAdapte heroAdapte;
    public static String url = "https://www.dropbox.com/s/6mcrnjcohrovcei/Strength.json?dl=1";
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strength_store);
        listView = (ListView) findViewById(R.id.list_shop);
        button = (Button) findViewById(R.id.btn_slist);



        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());


        JsonRequest jsonRequest = new JsonRequest(Request.Method.GET, url, null, new Response.Listener() {
            @Override
            public void onResponse(Object response) {


                String json = response.toString();
                list = JsonHero.Item(json);
                heroAdapte = new HeroSAdapte(list,getApplicationContext());
                listView.setAdapter(heroAdapte);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        switch (list.get(position).getName()){

                            case("Abaddon"):

                                startActivity(new Intent(StrengthStore.this, Abaddon.class));
                                    break;

                            case ("Alchemist"):

                            break;

                            case ("Beastmaster"):

                                break;

                            case ("Brewmaster"):

                                break;

                            case ("Bristleback"):

                                break;

                            case ("Centaur Warrunner"):

                                break;

                            case ("Chaos Knight"):

                                break;
                            case ("Clockwerk"):

                                break;
                            case ("Doom"):

                                break;
                            case ("Dragon Knight"):

                                break;
                            case ("Earthshaker"):

                                break;
                            case ("Earth Spirit"):

                                break;
                            case ("Elder Titan"):

                                break;
                            case ("Huskar"):

                                break;
                            case ("IO"):

                                break;
                            case ("Kunkka"):

                                break;
                            case ("Legion Commander"):

                                break;
                            case ("Lifestealer"):

                                break;
                            case ("Lycan"):

                                break;
                            case ("Magnus"):

                                break;
                            case ("Night Stalker"):

                                break;
                            case ("Omniknight"):

                                break;
                            case ("Phoenix"):

                                break;
                            case ("Pudge"):

                                break;
                            case ("Sand King"):

                                break;
                            case ("Slardar"):

                                break;
                            case ("Spirit Breaker"):

                                break;
                            case ("Sven"):

                                break;
                            case ("Tidehunter"):

                                break;
                            case ("Timbersaw"):

                                break;
                            case ("Tiny"):

                                break;
                            case ("Treant Protector"):

                                break;
                            case ("Tusk"):

                                break;
                            case ("Underlord"):

                                break;
                            case ("Undying"):

                                break;
                            case ("Wraith King"):

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
            startActivity(new Intent(StrengthStore.this, ShowList.class));
        }
    });

    }
}

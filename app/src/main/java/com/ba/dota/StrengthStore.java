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
import com.ba.dota.hero.strength.Alchemist;
import com.ba.dota.hero.strength.Axe;
import com.ba.dota.hero.strength.Beastmaster;
import com.ba.dota.hero.strength.Brewmaster;
import com.ba.dota.hero.strength.Bristleback;
import com.ba.dota.hero.strength.CentaurWarrunner;
import com.ba.dota.hero.strength.ChaosKnight;
import com.ba.dota.hero.strength.Clockwerk;
import com.ba.dota.hero.strength.Doom;
import com.ba.dota.hero.strength.DragonKnight;
import com.ba.dota.hero.strength.EarthSpirit;
import com.ba.dota.hero.strength.Earthshaker;
import com.ba.dota.hero.strength.ElderTitan;
import com.ba.dota.hero.strength.Huskar;
import com.ba.dota.hero.strength.IO;
import com.ba.dota.hero.strength.Kunkka;
import com.ba.dota.hero.strength.LegionCommander;
import com.ba.dota.hero.strength.Lifestealer;
import com.ba.dota.hero.strength.Lycan;
import com.ba.dota.hero.strength.Magnus;
import com.ba.dota.hero.strength.NightStalker;
import com.ba.dota.hero.strength.Omniknight;
import com.ba.dota.hero.strength.Phoenix;
import com.ba.dota.hero.strength.Pudge;
import com.ba.dota.hero.strength.SandKing;
import com.ba.dota.hero.strength.Slardar;
import com.ba.dota.hero.strength.SpiritBreaker;
import com.ba.dota.hero.strength.Sven;
import com.ba.dota.hero.strength.Tidehunter;
import com.ba.dota.hero.strength.Timbersaw;
import com.ba.dota.hero.strength.Tiny;
import com.ba.dota.hero.strength.TreantProtector;
import com.ba.dota.hero.strength.Tusk;
import com.ba.dota.hero.strength.Underlord;
import com.ba.dota.hero.strength.Undying;
import com.ba.dota.hero.strength.WraithKing;

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
                                startActivity(new Intent(StrengthStore.this, Alchemist.class));

                            break;

                            case ("Axe"):
                                startActivity(new Intent(StrengthStore.this, Axe.class));

                                break;

                            case ("Beastmaster"):
                                startActivity(new Intent(StrengthStore.this, Beastmaster.class));

                                break;

                            case ("Brewmaster"):
                                startActivity(new Intent(StrengthStore.this, Brewmaster.class));

                                break;

                            case ("Bristleback"):
                                startActivity(new Intent(StrengthStore.this, Bristleback.class));


                                break;

                            case ("Centaur Warrunner"):
                                startActivity(new Intent(StrengthStore.this, CentaurWarrunner.class));

                                break;

                            case ("Chaos Knight"):
                                startActivity(new Intent(StrengthStore.this, ChaosKnight.class));

                                break;
                            case ("Clockwerk"):
                                startActivity(new Intent(StrengthStore.this, Clockwerk.class));

                                break;
                            case ("Doom"):
                                startActivity(new Intent(StrengthStore.this, Doom.class));

                                break;
                            case ("Dragon Knight"):
                                startActivity(new Intent(StrengthStore.this, DragonKnight.class));

                                break;
                            case ("Earthshaker"):
                                startActivity(new Intent(StrengthStore.this, Earthshaker.class));

                                break;
                            case ("Earth Spirit"):
                                startActivity(new Intent(StrengthStore.this, EarthSpirit.class));

                                break;
                            case ("Elder Titan"):
                                startActivity(new Intent(StrengthStore.this, ElderTitan.class));

                                break;
                            case ("Huskar"):
                                startActivity(new Intent(StrengthStore.this, Huskar.class));

                                break;
                            case ("IO"):
                                startActivity(new Intent(StrengthStore.this, IO.class));

                                break;
                            case ("Kunkka"):
                                startActivity(new Intent(StrengthStore.this, Kunkka.class));

                                break;
                            case ("Legion Commander"):
                                startActivity(new Intent(StrengthStore.this, LegionCommander.class));

                                break;
                            case ("Lifestealer"):
                                startActivity(new Intent(StrengthStore.this, Lifestealer.class));

                                break;
                            case ("Lycan"):
                                startActivity(new Intent(StrengthStore.this, Lycan.class));

                                break;
                            case ("Magnus"):
                                startActivity(new Intent(StrengthStore.this, Magnus.class));

                                break;
                            case ("Night Stalker"):
                                startActivity(new Intent(StrengthStore.this, NightStalker.class));

                                break;
                            case ("Omniknight"):
                                startActivity(new Intent(StrengthStore.this, Omniknight.class));

                                break;
                            case ("Phoenix"):
                                startActivity(new Intent(StrengthStore.this, Phoenix.class));


                                break;
                            case ("Pudge"):
                                startActivity(new Intent(StrengthStore.this, Pudge.class));

                                break;
                            case ("Sand King"):
                                startActivity(new Intent(StrengthStore.this, SandKing.class));

                                break;
                            case ("Slardar"):
                                startActivity(new Intent(StrengthStore.this, Slardar.class));

                                break;
                            case ("Spirit Breaker"):
                                startActivity(new Intent(StrengthStore.this, SpiritBreaker.class));

                                break;
                            case ("Sven"):
                                startActivity(new Intent(StrengthStore.this, Sven.class));

                                break;
                            case ("Tidehunter"):
                                startActivity(new Intent(StrengthStore.this, Tidehunter.class));

                                break;
                            case ("Timbersaw"):
                                startActivity(new Intent(StrengthStore.this, Timbersaw.class));

                                break;
                            case ("Tiny"):
                                startActivity(new Intent(StrengthStore.this, Tiny.class));

                                break;
                            case ("Treant Protector"):
                                startActivity(new Intent(StrengthStore.this, TreantProtector.class));

                                break;
                            case ("Tusk"):
                                startActivity(new Intent(StrengthStore.this, Tusk.class));

                                break;
                            case ("Underlord"):
                                startActivity(new Intent(StrengthStore.this, Underlord.class));

                                break;
                            case ("Undying"):
                                startActivity(new Intent(StrengthStore.this, Undying.class));

                                break;
                            case ("Wraith King"):
                                startActivity(new Intent(StrengthStore.this, WraithKing.class));

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

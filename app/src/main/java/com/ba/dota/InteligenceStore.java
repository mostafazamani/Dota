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
import com.ba.dota.hero.intelligence.AncientApparition;
import com.ba.dota.hero.intelligence.Bane;
import com.ba.dota.hero.intelligence.Batrider;
import com.ba.dota.hero.intelligence.Chen;
import com.ba.dota.hero.intelligence.CrystalMaiden;
import com.ba.dota.hero.intelligence.DarkSeer;
import com.ba.dota.hero.intelligence.DarkWillow;
import com.ba.dota.hero.intelligence.Dazzle;
import com.ba.dota.hero.intelligence.DeathProphet;
import com.ba.dota.hero.intelligence.Disruptor;
import com.ba.dota.hero.intelligence.Enchantress;
import com.ba.dota.hero.intelligence.Enigma;
import com.ba.dota.hero.intelligence.Grimstroke;
import com.ba.dota.hero.intelligence.Invoker;
import com.ba.dota.hero.intelligence.Jakiro;
import com.ba.dota.hero.intelligence.KeeperOfTheLight;
import com.ba.dota.hero.intelligence.Leshrac;
import com.ba.dota.hero.intelligence.Lich;
import com.ba.dota.hero.intelligence.Lina;
import com.ba.dota.hero.intelligence.Lion;
import com.ba.dota.hero.intelligence.NatureProphet;
import com.ba.dota.hero.intelligence.Necrophos;
import com.ba.dota.hero.intelligence.OgreMagi;
import com.ba.dota.hero.intelligence.Oracle;
import com.ba.dota.hero.intelligence.OutworldDevourer;
import com.ba.dota.hero.intelligence.Puck;
import com.ba.dota.hero.intelligence.Pugna;
import com.ba.dota.hero.intelligence.QueenOfPain;
import com.ba.dota.hero.intelligence.Rubick;
import com.ba.dota.hero.intelligence.ShadowDemon;
import com.ba.dota.hero.intelligence.ShadowShaman;
import com.ba.dota.hero.intelligence.Silencer;
import com.ba.dota.hero.intelligence.SkywrathMage;
import com.ba.dota.hero.intelligence.StormSpirit;
import com.ba.dota.hero.intelligence.Techies;
import com.ba.dota.hero.intelligence.Tinker;
import com.ba.dota.hero.intelligence.Visage;
import com.ba.dota.hero.intelligence.Warlock;
import com.ba.dota.hero.intelligence.Windranger;
import com.ba.dota.hero.intelligence.WinterWyvern;
import com.ba.dota.hero.intelligence.WitchDoctor;
import com.ba.dota.hero.intelligence.Zeus;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class InteligenceStore extends AppCompatActivity {

    ListView listView;
    List<Hero> list;
    HeroSAdapte strength;

    public static final String url = "https://www.dropbox.com/s/kgnfs1pw9em7tq4/Intelligence.json?dl=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inteligence_store);

        listView = (ListView) findViewById(R.id.list_ishop);
        Button button= (Button) findViewById(R.id.btn_ilist);


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());


        JsonRequest jsonRequest = new JsonRequest(Request.Method.GET, url, null, new Response.Listener() {
            @Override
            public void onResponse(Object response) {


                String json = response.toString();
                list = JsonHero.Item(json);
                strength = new HeroSAdapte(list, getApplicationContext());
                listView.setAdapter(strength);


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (list.get(position).getName()) {

                            case ("Ancient Apparition"):
                                startActivity(new Intent(InteligenceStore.this, AncientApparition.class));
                                break;

                            case ("Bane"):
                                startActivity(new Intent(InteligenceStore.this, Bane.class));

                                break;
                            case ("Batrider"):
                                startActivity(new Intent(InteligenceStore.this, Batrider.class));

                                break;
                            case ("Chen"):
                                startActivity(new Intent(InteligenceStore.this, Chen.class));

                                break;
                            case ("Crystal Maiden"):
                                startActivity(new Intent(InteligenceStore.this, CrystalMaiden.class));

                                break;
                            case ("Dark Seer"):
                                startActivity(new Intent(InteligenceStore.this, DarkSeer.class));

                                break;
                            case ("Dark Willow"):
                                startActivity(new Intent(InteligenceStore.this, DarkWillow.class));

                                break;
                            case ("Dazzle"):
                                startActivity(new Intent(InteligenceStore.this, Dazzle.class));

                                break;
                            case ("Death Prophet"):
                                startActivity(new Intent(InteligenceStore.this, DeathProphet.class));

                                break;
                            case ("Disruptor"):
                                startActivity(new Intent(InteligenceStore.this, Disruptor.class));

                                break;
                            case ("Enchantress"):
                                startActivity(new Intent(InteligenceStore.this, Enchantress.class));

                                break;
                            case ("Enigma"):
                                startActivity(new Intent(InteligenceStore.this, Enigma.class));

                                break;
                            case ("Grimstroke"):
                                startActivity(new Intent(InteligenceStore.this, Grimstroke.class));

                                break;
                            case ("Invoker"):
                                startActivity(new Intent(InteligenceStore.this, Invoker.class));

                                break;
                            case ("Jakiro"):
                                startActivity(new Intent(InteligenceStore.this, Jakiro.class));

                                break;
                            case ("Keeper Of The Light"):
                                startActivity(new Intent(InteligenceStore.this, KeeperOfTheLight.class));

                                break;
                            case ("Leshrac"):
                                startActivity(new Intent(InteligenceStore.this, Leshrac.class));

                                break;
                            case ("Lich"):
                                startActivity(new Intent(InteligenceStore.this, Lich.class));

                                break;
                            case ("Lina"):
                                startActivity(new Intent(InteligenceStore.this, Lina.class));

                                break;
                            case ("Lion"):
                                startActivity(new Intent(InteligenceStore.this, Lion.class));

                                break;
                            case ("Nature Prophet"):
                                startActivity(new Intent(InteligenceStore.this, NatureProphet.class));

                                break;
                            case ("Necrophos"):
                                startActivity(new Intent(InteligenceStore.this, Necrophos.class));

                                break;
                            case ("Ogre Magi"):
                                startActivity(new Intent(InteligenceStore.this, OgreMagi.class));

                                break;
                            case ("Oracle"):
                                startActivity(new Intent(InteligenceStore.this, Oracle.class));

                                break;
                            case ("Outworld Devourer"):
                                startActivity(new Intent(InteligenceStore.this, OutworldDevourer.class));

                                break;
                            case ("Pugna"):
                                startActivity(new Intent(InteligenceStore.this, Pugna.class));

                                break;
                            case ("Puck"):
                                startActivity(new Intent(InteligenceStore.this, Puck.class));

                                break;
                            case ("Queen Of Pain"):
                                startActivity(new Intent(InteligenceStore.this, QueenOfPain.class));

                                break;
                            case ("Rubick"):
                                startActivity(new Intent(InteligenceStore.this, Rubick.class));

                                break;
                            case ("Shadow Demon"):
                                startActivity(new Intent(InteligenceStore.this, ShadowDemon.class));

                                break;
                            case ("Shadow Shaman"):
                                startActivity(new Intent(InteligenceStore.this, ShadowShaman.class));

                                break;
                            case ("Silencer"):
                                startActivity(new Intent(InteligenceStore.this, Silencer.class));

                                break;
                            case ("Skywrath Mage"):
                                startActivity(new Intent(InteligenceStore.this, SkywrathMage.class));

                                break;
                            case ("Storm Spirit"):
                                startActivity(new Intent(InteligenceStore.this, StormSpirit.class));

                                break;
                            case ("Techies"):
                                startActivity(new Intent(InteligenceStore.this, Techies.class));

                                break;
                            case ("Tinker"):
                                startActivity(new Intent(InteligenceStore.this, Tinker.class));

                                break;
                            case ("Visage"):
                                startActivity(new Intent(InteligenceStore.this, Visage.class));

                                break;
                            case ("Warlock"):
                                startActivity(new Intent(InteligenceStore.this, Warlock.class));

                                break;
                            case ("Windranger"):
                                startActivity(new Intent(InteligenceStore.this, Windranger.class));

                                break;
                            case ("Winter Wyvern"):
                                startActivity(new Intent(InteligenceStore.this, WinterWyvern.class));

                                break;
                            case ("Witch Doctor"):
                                startActivity(new Intent(InteligenceStore.this, WitchDoctor.class));

                                break;
                            case ("Zeus"):
                                startActivity(new Intent(InteligenceStore.this, Zeus.class));

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
                startActivity(new Intent(InteligenceStore.this, ShowList.class));
            }
        });

    }
}

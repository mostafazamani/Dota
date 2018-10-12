package com.ba.dota;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
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

import java.io.UnsupportedEncodingException;
import java.util.List;

public class AgilityStore extends AppCompatActivity {

    ListView listView;
    List<Hero> list;
    HeroSAdapte strength;
    ProgressBar bar;

    public static final String url = "https://www.dropbox.com/s/e8hjpjbqs071y2l/Agility.json?dl=1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agility_store);
        listView = (ListView) findViewById(R.id.list_shopa);
        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.l_storeagility);
        Button button = (Button) findViewById(R.id.btn_alist);


        bar = (ProgressBar) findViewById(R.id.progressBar_a);


        bar.setVisibility(View.VISIBLE);

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());


        JsonRequest jsonRequest = new JsonRequest(Request.Method.GET, url, null, new Response.Listener() {
            @Override
            public void onResponse(Object response) {


                bar.setVisibility(View.GONE);

                String json = response.toString();
                list = JsonHero.Item(json);
                strength = new HeroSAdapte(list,getApplicationContext());
                listView.setAdapter(strength);


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (list.get(position).getName()){

                            case("Anti Mage"):

                                startActivity(new Intent(AgilityStore.this, AntiMage.class));
                                break;
                            case ("Arc Warden"):
                                startActivity(new Intent(AgilityStore.this, ArcWarden.class));

                                break;
                            case ("Bloodseeker"):
                                startActivity(new Intent(AgilityStore.this, Bloodseeker.class));

                                break;
                            case ("Bounty Hunter"):
                                startActivity(new Intent(AgilityStore.this, BountyHunter.class));

                                break;
                            case ("Broodmother"):
                                startActivity(new Intent(AgilityStore.this, Broodmother.class));

                                break;
                            case ("Clinkz"):
                                startActivity(new Intent(AgilityStore.this, Clinkz.class));

                                break;
                            case ("Drow Ranger"):
                                startActivity(new Intent(AgilityStore.this, DrowRanger.class));

                                break;
                            case ("Ember Spirit"):
                                startActivity(new Intent(AgilityStore.this, EmberSpirit.class));

                                break;
                            case ("Faceless Void"):
                                startActivity(new Intent(AgilityStore.this, FacelessVoid.class));

                                break;
                            case ("Gyrocopter"):
                                startActivity(new Intent(AgilityStore.this, Gyrocopter.class));

                                break;
                            case ("Juggernaut"):
                                startActivity(new Intent(AgilityStore.this, Juggernaut.class));

                                break;
                            case ("Lone Druid"):
                                startActivity(new Intent(AgilityStore.this, LoneDruid.class));

                                break;
                            case ("Luna"):
                                startActivity(new Intent(AgilityStore.this, Luna.class));

                                break;
                            case ("Medusa"):
                                startActivity(new Intent(AgilityStore.this, Medusa.class));

                                break;
                            case ("Meepo"):
                                startActivity(new Intent(AgilityStore.this, Meepo.class));

                                break;
                            case ("Mirana"):
                                startActivity(new Intent(AgilityStore.this, Mirana.class));

                                break;
                            case ("Monkey King"):
                                startActivity(new Intent(AgilityStore.this, MonkeyKing.class));

                                break;
                            case ("Morphling"):
                                startActivity(new Intent(AgilityStore.this, Morphling.class));

                                break;
                            case ("Naga Siren"):
                                startActivity(new Intent(AgilityStore.this, NagaSiren.class));

                                break;
                            case ("Nyx Assassin"):
                                startActivity(new Intent(AgilityStore.this, NyxAssassin.class));

                                break;
                            case ("Pangolier"):
                                startActivity(new Intent(AgilityStore.this, Pangolier.class));

                                break;
                            case ("Phantom Assassin"):
                                startActivity(new Intent(AgilityStore.this, PhantomAssassin.class));

                                break;
                            case ("Phantom Lancer"):
                                startActivity(new Intent(AgilityStore.this, PhantomLancer.class));

                                break;
                            case ("Razor"):
                                startActivity(new Intent(AgilityStore.this, Razor.class));

                                break;
                            case ("Riki"):
                                startActivity(new Intent(AgilityStore.this, Riki.class));

                                break;
                            case ("Shadow Fiend"):
                                startActivity(new Intent(AgilityStore.this, ShadowFiend.class));

                                break;
                            case ("Slark"):
                                startActivity(new Intent(AgilityStore.this, Slark.class));

                                break;
                            case ("Sniper"):
                                startActivity(new Intent(AgilityStore.this, Sniper.class));

                                break;
                            case ("Spectre"):
                                startActivity(new Intent(AgilityStore.this, Spectre.class));

                                break;
                            case ("Templar Assassin"):
                                startActivity(new Intent(AgilityStore.this, TemplarAssassin.class));

                                break;
                            case ("Terrorblade"):
                                startActivity(new Intent(AgilityStore.this, Terrorblade.class));

                                break;
                            case ("Troll Warlord"):
                                startActivity(new Intent(AgilityStore.this, TrollWarlord.class));

                                break;
                            case ("Ursa"):
                                startActivity(new Intent(AgilityStore.this, Ursa.class));

                                break;
                            case ("Vengeful Spirit"):
                                startActivity(new Intent(AgilityStore.this, VengefulSpirit.class));

                                break;
                            case ("Venomancer"):
                                startActivity(new Intent(AgilityStore.this, Venomancer.class));

                                break;
                            case ("Viper"):
                                startActivity(new Intent(AgilityStore.this, Viper.class));

                                break;
                            case ("Weaver"):
                                startActivity(new Intent(AgilityStore.this, Weaver.class));

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

                bar.setVisibility(View.GONE);

                Snackbar snackbar =Snackbar.make(layout,"Connection Failed...",Snackbar.LENGTH_INDEFINITE);
                View sbview = snackbar.getView();
                sbview.setBackgroundColor(0xffff4334);
                snackbar.setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        recreate();
                    }
                });


                snackbar.show();


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

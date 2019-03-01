package com.ba.dota;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.ba.dota.SetSender.uri;

public class SetsenderChest extends DialogFragment {

    TextView text;
    Button btn_ok, btn_ref;
    ProgressBar prog;


    public static SetsenderChest chestinstance(String name, String trade, String number, int numberchest, String refid, int x, int i) {
        SetsenderChest chest = new SetsenderChest();
        Bundle bundle = new Bundle();
        bundle.putInt("numberchest", numberchest);
        bundle.putString("refid", refid);
        bundle.putInt("x", x);
        bundle.putString("name", name);
        bundle.putString("tradelink", trade);
        bundle.putString("numberphone", number);
        bundle.putInt("i", i);

        chest.setArguments(bundle);

        return chest;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.set_sender, container, false);

        text = (TextView) view.findViewById(R.id.txt_sender);
        btn_ok = (Button) view.findViewById(R.id.ok_sender);
        btn_ref = (Button) view.findViewById(R.id.ref_sender);
        prog = (ProgressBar) view.findViewById(R.id.prog_sender);

        btn_ref.setVisibility(View.INVISIBLE);
        prog.setVisibility(View.INVISIBLE);

        final int numberchest = getArguments().getInt("numberchest");
        final String refid = getArguments().getString("refid");
        final String name = getArguments().getString("name");
        final String tradelink = getArguments().getString("tradelink");
        final String numberphone = getArguments().getString("numberphone");
        final int numberitem = getArguments().getInt("x");
        final int[] i = {getArguments().getInt("i")};

        final String url = "http://prodall.ir/myupload/chestdota.php";

        final RequestQueue queue = Volley.newRequestQueue(getActivity());
        text.setText("درحال تکمیل خرید....");

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                text.setText("خرید تکمیل شد" +
                        "\n" +
                        "کدرهگیری:" +
                        response);
                btn_ok.setVisibility(View.VISIBLE);
                prog.setVisibility(View.INVISIBLE);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                text.setText("connection failed...");
                btn_ref.setVisibility(View.VISIBLE);
                prog.setVisibility(View.INVISIBLE);


            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> p = new HashMap<String, String>();

                p.put("name", name);
                p.put("chest", String.valueOf(numberchest));
                p.put("tradelink", tradelink);
                p.put("numberphone", numberphone);
                p.put("refid", refid);
                p.put("chestitem", String.valueOf(numberitem));

                return p;
            }
        };

        queue.add(request);


        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShowChest.class);
                intent.putExtra("chestnumber", numberchest);
                intent.putExtra("numberitem", numberitem);


                startActivity(intent);


            }
        });

        btn_ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i[0]++;

                text.setText("درحال تکمیل خرید....");

                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        text.setText("خرید تکمیل شد" +
                                "\n" +
                                "کدرهگیری:" +
                                response);
                        btn_ok.setVisibility(View.VISIBLE);
                        prog.setVisibility(View.INVISIBLE);


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        text.setText("connection failed...");
                        if (i[0] > 2) {

                            text.setText("connection failed\n" +
                                    "کد زیر را به تلگرام بفرستید" +
                                    "\n" +
                                    refid);
                            btn_ref.setVisibility(View.INVISIBLE);
                            btn_ok.setVisibility(View.VISIBLE);
                            prog.setVisibility(View.INVISIBLE);


                        } else {
                            btn_ref.setVisibility(View.VISIBLE);
                            prog.setVisibility(View.INVISIBLE);
                        }

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> p = new HashMap<String, String>();


                        p.put("name", name);
                        p.put("chest", String.valueOf(numberchest));
                        p.put("tradelink", tradelink);
                        p.put("numberphone", numberphone);
                        p.put("refid", refid);
                        p.put("chestitem", String.valueOf(numberitem));


                        return p;
                    }
                };

                queue.add(request);


            }
        });


        return view;
    }

    public int setrandom() {
        Random random = new Random();
        int x = random.nextInt(100);


        if (x == 13 || x == 21 || x == 67 || x == 93) {
            return 4;
        } else if (x == 2 || x == 5 || x == 7 || x == 35 || x == 42 || x == 53 || x == 64 || x == 75 || x == 86 || x == 97) {
            return 3;
        } else if (x == 1 || x == 3 || x == 7 || x == 9 || x == 11 || x == 23 || x == 29 || x == 32 || x == 39 || x == 41 || x == 52 || x == 59 || x == 60 || x == 70 || x == 80 || x == 90 || x == 99 || x == 100 || x == 85 || x == 73 || x == 65) {
            return 2;
        } else {
            if (random.nextInt(2) == 2) {
                return 1;
            } else {
                return 0;
            }
        }


    }


}

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
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SetsenderChest extends DialogFragment {

    TextView text;
    Button btn_ok, btn_ref;
    ProgressBar prog;


    public static SetsenderChest chestinstance(int numberchest, String refid, int x) {
        SetsenderChest chest = new SetsenderChest();
        Bundle bundle = new Bundle();
        bundle.putInt("numberchest", numberchest);
        bundle.putString("refid", refid);
        bundle.putInt("x", x);

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

        final int numberitem = getArguments().getInt("x") ;


        final RequestQueue queue = Volley.newRequestQueue(getActivity());

        final Map<String, String> param = new HashMap<String, String>();

        param.put("numberchest", String.valueOf(numberchest));
        param.put("numberitem", String.valueOf(numberitem));
        param.put("refid", refid);
/*
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(param), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                text.setText("خرید تکمیل شد");
                prog.setVisibility(View.INVISIBLE);
                btn_ok.setVisibility(View.VISIBLE);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                text.setText("خطا در تکمیل خرید");
                prog.setVisibility(View.INVISIBLE);

                if (x[0] < 3) {
                    btn_ref.setVisibility(View.VISIBLE);
                } else {
                    btn_ok.setVisibility(View.VISIBLE);
                }

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        queue.add(request);

*/
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShowChest.class);
                intent.putExtra("numberchest",numberchest);
                intent.putExtra("numberitem",numberitem);

                startActivity(intent);




            }
        });

        btn_ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                text.setText("درحال تکمیل خرید....");

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "", new JSONObject(param), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        text.setText("خرید تکمیل شد");
                        prog.setVisibility(View.INVISIBLE);
                        btn_ok.setVisibility(View.VISIBLE);
                        btn_ref.setVisibility(View.INVISIBLE);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        text.setText("خطا در تکمیل خرید");
                        prog.setVisibility(View.INVISIBLE);


                    }
                }) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("Content-Type", "application/json; charset=utf-8");
                        return headers;
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

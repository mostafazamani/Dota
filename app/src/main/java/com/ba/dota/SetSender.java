package com.ba.dota;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class SetSender extends DialogFragment {

    TextView text;
    Button btn_ok, btn_ref;
    ProgressBar prog;
    int x = 0;
    public static final String uri = "";

    public static SetSender newinstance(String name, String itemname, String tradelink, String numberphone, String refid) {

        SetSender sender = new SetSender();

        Bundle bundle = new Bundle();

        bundle.putString("n", name);
        bundle.putString("i", itemname);
        bundle.putString("t", tradelink);
        bundle.putString("np", numberphone);
        bundle.putString("ri", refid);

        sender.setArguments(bundle);


        return sender;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.set_sender, container, false);

        text = (TextView) view.findViewById(R.id.txt_sender);
        btn_ok = (Button) view.findViewById(R.id.ok_sender);
        btn_ref = (Button) view.findViewById(R.id.ref_sender);
        prog = (ProgressBar) view.findViewById(R.id.prog_sender);

        btn_ok.setVisibility(View.INVISIBLE);
        btn_ref.setVisibility(View.INVISIBLE);
        prog.setVisibility(View.VISIBLE);

        String name = getArguments().getString("n");
        String itemname = getArguments().getString("i");
        String tradelink = getArguments().getString("t");
        String numberphone = getArguments().getString("np");
        String refid = getArguments().getString("ri");


        final RequestQueue queue = Volley.newRequestQueue(getActivity());

        final Map<String, String> param = new HashMap<String, String>();

        param.put("name", name);
        param.put("itemname", itemname);
        param.put("tradelink", tradelink);
        param.put("numberphone", numberphone);
        param.put("refid", refid);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, uri, new JSONObject(param), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                prog.setVisibility(View.INVISIBLE);
                btn_ok.setVisibility(View.VISIBLE);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                prog.setVisibility(View.INVISIBLE);

                if (x < 3) {
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


        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),MainActivity.class));

            }
        });

        btn_ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, uri, new JSONObject(param), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        x++;
                        prog.setVisibility(View.INVISIBLE);
                        btn_ok.setVisibility(View.VISIBLE);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        prog.setVisibility(View.INVISIBLE);

                        if (x < 3) {
                            btn_ref.setVisibility(View.VISIBLE);
                        } else {
                            btn_ok.setVisibility(View.VISIBLE);
                            btn_ref.setVisibility(View.INVISIBLE);
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


            }
        });


        return view;
    }
}

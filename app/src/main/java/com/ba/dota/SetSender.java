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
import android.widget.Toast;

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

public class SetSender extends DialogFragment {

    TextView text;
    Button btn_ok, btn_ref;
    ProgressBar prog;

    public static final String uri = "http://prodall.ir/myupload/dota.php";

    public static SetSender newinstance(String name, String itemname, String tradelink, String numberphone, String refid,int x) {

        SetSender sender = new SetSender();

        Bundle bundle = new Bundle();

        bundle.putString("n", name);
        bundle.putString("i", itemname);
        bundle.putString("t", tradelink);
        bundle.putString("np", numberphone);
        bundle.putString("ri", refid);
        bundle.putInt("x",x);

        sender.setArguments(bundle);


        return sender;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.set_sender, container, false);

        final int[] i = {0};

        text = (TextView) view.findViewById(R.id.txt_sender);
        btn_ok = (Button) view.findViewById(R.id.ok_sender);
        btn_ref = (Button) view.findViewById(R.id.ref_sender);
        prog = (ProgressBar) view.findViewById(R.id.prog_sender);


        btn_ok.setVisibility(View.INVISIBLE);
        btn_ref.setVisibility(View.INVISIBLE);
        prog.setVisibility(View.VISIBLE);

        final String name = getArguments().getString("n");
        final String itemname = getArguments().getString("i");
        final String tradelink = getArguments().getString("t");
        final String numberphone = getArguments().getString("np");
        final String refid = getArguments().getString("ri");
        final int[] x = {getArguments().getInt("x")};



        final RequestQueue queue = Volley.newRequestQueue(getActivity());



        StringRequest request = new StringRequest(Request.Method.POST, uri, new Response.Listener<String>() {
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
        }){
            @Override
            protected Map<String, String> getParams() {
                 Map<String, String> p = new HashMap<String, String>();

                p.put("name", name);
                p.put("itemname", itemname);
                p.put("tradelink", tradelink);
                 p.put("numberphone", numberphone);
                  p.put("refid", refid);

                return p;
            }
        };

        queue.add(request);





        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),MainActivity.class));
                getActivity().finish();


            }
        });

        btn_ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x[0]++;

                text.setText("درحال تکمیل خرید....");


                StringRequest request = new StringRequest(Request.Method.POST, uri, new Response.Listener<String>() {
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
                        text.setText("connection failed....");
                        if (x[0] >2){

                            text.setText("connection failed\n" +
                                    "کد زیر را به تلگرام بفرستید" +
                                    "\n" +
                                    refid);
                            btn_ref.setVisibility(View.INVISIBLE);
                            btn_ok.setVisibility(View.VISIBLE);
                            prog.setVisibility(View.INVISIBLE);


                        }else {
                            btn_ref.setVisibility(View.VISIBLE);
                            prog.setVisibility(View.INVISIBLE);
                        }

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> p = new HashMap<String, String>();

                        p.put("name", name);
                        p.put("itemname", itemname);
                        p.put("tradelink", tradelink);
                        p.put("numberphone", numberphone);
                        p.put("refid", refid);

                        return p;
                    }
                };

                queue.add(request);




            }
        });


        return view;
    }
}

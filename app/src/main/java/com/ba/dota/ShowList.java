package com.ba.dota;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ListView;
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

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ShowList extends AppCompatActivity {

    ListView listView;
    List<Items> list;
    SList slist;
    DbUtil d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        listView = (ListView) findViewById(R.id.show_list);
        Button button = (Button) findViewById(R.id.btn_pay);
        TextView textView = (TextView) findViewById(R.id.text_all_cast);


        d = new DbUtil(getApplicationContext());

        list = d.getItem();

        if (list == null) list = new ArrayList<>();
        slist = new SList(list, getApplicationContext());
        listView.setAdapter(slist);

        textView.setText(String.valueOf(gh(list)));



    }

    public int gh(List<Items> lc) {
        int c = 0;
        for (int i = 0; i < (lc.size());i++) {

            c = c + Integer.parseInt((String.valueOf(lc.get(i).getCast())).replaceAll("[\\D]", ""));

        }
        return c;
    }
}

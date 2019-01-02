package com.ba.dota;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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
        final Button button = (Button) findViewById(R.id.btn_pay);
        final TextView textView = (TextView) findViewById(R.id.text_all_cast);

        d = new DbUtil(getApplicationContext());

        list = d.getItem();

        if (list == null) list = new ArrayList<>();
        slist = new SList(list, getApplicationContext());
        listView.setAdapter(slist);

        textView.setText(String.valueOf(gh(list)));

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (("0").equals(textView.getText())){

                    button.setClickable(false);
                }
            }
        },1000);



        LocalBroadcastManager.getInstance(this).registerReceiver(msg,
                new IntentFilter("custom-event-name"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ShowList.this,PayPage.class);
                intent.putExtra("name",na(list));
                intent.putExtra("gh",gh(list));

                startActivity(intent);

                finish();


            }
        });

    }

    public int gh(List<Items> lc) {
        int c = 0;
        for (int i = 0; i < (lc.size()); i++) {

            c = c + Integer.parseInt((String.valueOf(lc.get(i).getCast())).replaceAll("[\\D]", ""));

        }
        return c;
    }

    public String na(List<Items> n){
        String name="";

        for (int i = 0; i < (n.size()); i++) {

            name = name + n.get(i).getItem_text()+" ,\n ";

        }

        return name;
    }

    private BroadcastReceiver msg = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, " lol", Toast.LENGTH_SHORT).show();
            recreate();
        }
    };




}

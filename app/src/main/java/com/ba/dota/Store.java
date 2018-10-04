package com.ba.dota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Store extends AppCompatActivity {
    Button st, ag, in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);


        st = (Button) findViewById(R.id.go_st);
        ag = (Button) findViewById(R.id.go_ag);
        in = (Button) findViewById(R.id.go_int);




        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Store.this, StrengthStore.class));

            }
        });
        ag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Store.this, AgilityStore.class));

            }
        });

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Store.this, InteligenceStore.class));

            }
        });




    }
}

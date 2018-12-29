package com.ba.dota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Chest extends AppCompatActivity {

    Button text_dis, pay_chest_1, pay_chest_2, pay_chest_3;
    ImageView chest_11, chest_21, chest_31, chest_41, chest_51; //chest one
    ImageView chest_12, chest_22, chest_32, chest_42, chest_52; //chest two
    ImageView chest_13, chest_23, chest_33, chest_43, chest_53; //chest three

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        pay_chest_1 = (Button) findViewById(R.id.pay_chest_1);
        pay_chest_2 = (Button) findViewById(R.id.pay_chest_2);
        pay_chest_3 = (Button) findViewById(R.id.pay_chest_3);

        chest_11 = (ImageView) findViewById(R.id.chest_11); //aks aval radif aval
        chest_21 = (ImageView) findViewById(R.id.chest_21);
        chest_31 = (ImageView) findViewById(R.id.chest_31);
        chest_41 = (ImageView) findViewById(R.id.chest_41);
        chest_51 = (ImageView) findViewById(R.id.chest_51);

        chest_12 = (ImageView) findViewById(R.id.chest_12); //aks aval radif dovom
        chest_22 = (ImageView) findViewById(R.id.chest_22);
        chest_32 = (ImageView) findViewById(R.id.chest_32);
        chest_42 = (ImageView) findViewById(R.id.chest_42);
        chest_52 = (ImageView) findViewById(R.id.chest_52);

        chest_13 = (ImageView) findViewById(R.id.chest_13); //aks aval radif seyom :)
        chest_23 = (ImageView) findViewById(R.id.chest_23);
        chest_33 = (ImageView) findViewById(R.id.chest_33);
        chest_43 = (ImageView) findViewById(R.id.chest_43);
        chest_53 = (ImageView) findViewById(R.id.chest_53);

        pay_chest_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chest.this, ChestPay.class);
                intent.putExtra("number", 1);
                startActivity(intent);
            }
        });

        pay_chest_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chest.this, ChestPay.class);
                intent.putExtra("number", 2);
                startActivity(intent);
            }
        });
        pay_chest_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chest.this, ChestPay.class);
                intent.putExtra("number", 3);
                startActivity(intent);
            }
        });
    }
}

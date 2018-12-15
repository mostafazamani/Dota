package com.ba.dota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chest extends AppCompatActivity {

    Button chest_pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        chest_pay = (Button) findViewById(R.id.chest_pay);

                chest_pay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Chest.this,ChestPay.class));
                    }
                });
    }
}

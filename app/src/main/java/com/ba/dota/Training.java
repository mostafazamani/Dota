package com.ba.dota;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


/**
 * Created by Vahid Aali on 1/12/2019.
 */

public class Training extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_layout);

        ImageView image_trade = (ImageView) findViewById(R.id.image_trade_link);
        ImageView inventory = (ImageView) findViewById(R.id.inventory);






        image_trade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://steamcommunity.com/profiles/76561198360706389/tradeoffers/privacy"));
                startActivity(browserIntent);

            }
        });


        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://steamcommunity.com/profiles/76561198360706389/edit/settings"));
                startActivity(browserIntent);
            }
        });

    }
}

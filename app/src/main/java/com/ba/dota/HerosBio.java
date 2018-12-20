package com.ba.dota;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class HerosBio extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heros_bio);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

       viewPager.setAdapter(new BioAdapter(getSupportFragmentManager()));

    }
}

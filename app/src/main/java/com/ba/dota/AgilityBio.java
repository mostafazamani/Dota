package com.ba.dota;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AgilityBio extends Fragment implements View.OnClickListener {

    public static final AgilityBio agistanc() {
        AgilityBio agilityBio = new AgilityBio();


        return agilityBio;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.agility_bio, container, false);

        view.findViewById(R.id.anti).setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.anti:
                DialogHeroBio d = DialogHeroBio.instance(R.drawable.anti_mage, "Anti Mage", 1, 2);
                d.show(getFragmentManager(),"Oops");

        }


    }
}

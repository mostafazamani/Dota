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
                 DialogHeroBio.instance(R.drawable.anti_mage, "Anti Mage", R.raw.a).show(getFragmentManager(),"oops");
/*
            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Arc Warden", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Bloodseeker", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Bounty Hunter", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Brood Mother", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Clinkz", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Drow Ranger", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Ember Spirit", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Faceless Void", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Gyrocopter", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Juggernaut", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Lone Druid", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Luna", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Medusa", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Meepo", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Mirana", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Monkey King", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Morphling", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Nagasiren", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Nyx Assassin", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Pangolier", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Phantom Assassin", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Phantom Lancer", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Razor", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Riki", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Shadow Fiend", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Slark", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Sniper", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Spectre", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Templar Assassin", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Terrorblade", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Troll Warlord", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Ursa", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Vengeful Spirit", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Venomancer", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Viper", 2).show(getFragmentManager(),"oops");

            case R.id.:
                DialogHeroBio.instance(R.drawable.anti_mage, "Weaver", 2).show(getFragmentManager(),"oops");

                */
default:

        }


    }
}

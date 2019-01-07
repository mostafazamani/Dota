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
                 DialogHeroBio.instance(R.drawable.anti_mage, "Anti Mage", R.raw.antimage).show(getFragmentManager(),"oops");

            case R.id.arcwarden:
                DialogHeroBio.instance(R.drawable.arc_warden, "Arc Warden", R.raw.arcwarden).show(getFragmentManager(),"oops");

            case R.id.bloodseeker:
                DialogHeroBio.instance(R.drawable.bloodseeker, "Bloodseeker", R.raw.bloodseeker).show(getFragmentManager(),"oops");

            case R.id.bountyhunter:
                DialogHeroBio.instance(R.drawable.bounty_hunter, "Bounty Hunter", R.raw.bountyhunter).show(getFragmentManager(),"oops");

            case R.id.broodmother:
                DialogHeroBio.instance(R.drawable.broodmother, "Brood Mother", R.raw.broodmother).show(getFragmentManager(),"oops");

            case R.id.clinkz:
                DialogHeroBio.instance(R.drawable.clinkz, "Clinkz", R.raw.clinkz).show(getFragmentManager(),"oops");

            case R.id.drowranger:
                DialogHeroBio.instance(R.drawable.drow_ranger, "Drow Ranger", R.raw.drowranger).show(getFragmentManager(),"oops");

            case R.id.ember:
                DialogHeroBio.instance(R.drawable.ember_spirit, "Ember Spirit", R.raw.emberspirit).show(getFragmentManager(),"oops");

            case R.id.faceless:
                DialogHeroBio.instance(R.drawable.faceless_void, "Faceless Void", R.raw.facelessvoid).show(getFragmentManager(),"oops");

            case R.id.gyrocopter:
                DialogHeroBio.instance(R.drawable.gyrocopter, "Gyrocopter", R.raw.gyrocopter).show(getFragmentManager(),"oops");

            case R.id.juggermaut:
                DialogHeroBio.instance(R.drawable.juggernaut, "Juggernaut", R.raw.juggernaut).show(getFragmentManager(),"oops");

            case R.id.lonedruid:
                DialogHeroBio.instance(R.drawable.lone_druid, "Lone Druid", R.raw.lonedruid).show(getFragmentManager(),"oops");

            case R.id.luna:
                DialogHeroBio.instance(R.drawable.luna, "Luna", R.raw.luna).show(getFragmentManager(),"oops");

            case R.id.medusa:
                DialogHeroBio.instance(R.drawable.anti_mage, "Medusa", 2).show(getFragmentManager(),"oops");

            case R.id.meepo:
                DialogHeroBio.instance(R.drawable.meepo, "Meepo", R.raw.meepo).show(getFragmentManager(),"oops");

            case R.id.mirana:
                DialogHeroBio.instance(R.drawable.mirana, "Mirana", R.raw.mirana).show(getFragmentManager(),"oops");

            case R.id.monkeyking:
                DialogHeroBio.instance(R.drawable.monkey_king, "Monkey King", R.raw.monkeyking).show(getFragmentManager(),"oops");

            case R.id.morph:
                DialogHeroBio.instance(R.drawable.morphling, "Morphling", R.raw.morphiling).show(getFragmentManager(),"oops");

            case R.id.naga:
                DialogHeroBio.instance(R.drawable.naga_siren, "Nagasiren", R.raw.nagasiren).show(getFragmentManager(),"oops");

            case R.id.nyx:
                DialogHeroBio.instance(R.drawable.nyx_assassin, "Nyx Assassin", R.raw.nyxassassin).show(getFragmentManager(),"oops");

            case R.id.pangolier:
                DialogHeroBio.instance(R.drawable.pangolier, "Pangolier", R.raw.pangolier).show(getFragmentManager(),"oops");

            case R.id.phantomassassin:
                DialogHeroBio.instance(R.drawable.phantom_assassin, "Phantom Assassin", R.raw.phantomassassin).show(getFragmentManager(),"oops");

            case R.id.phantomlancer:
                DialogHeroBio.instance(R.drawable.phantom_lancer, "Phantom Lancer", R.raw.phantomlancer).show(getFragmentManager(),"oops");

            case R.id.razor:
                DialogHeroBio.instance(R.drawable.razor, "Razor", R.raw.razor).show(getFragmentManager(),"oops");

            case R.id.riki:
                DialogHeroBio.instance(R.drawable.riki, "Riki", R.raw.riki).show(getFragmentManager(),"oops");

            case R.id.shadowfiend:
                DialogHeroBio.instance(R.drawable.shadow_fiend, "Shadow Fiend", R.raw.shadowfiend).show(getFragmentManager(),"oops");

            case R.id.slark:
                DialogHeroBio.instance(R.drawable.slark, "Slark", R.raw.slark).show(getFragmentManager(),"oops");

            case R.id.sniper:
                DialogHeroBio.instance(R.drawable.sniper, "Sniper", R.raw.sniper).show(getFragmentManager(),"oops");

            case R.id.spectre:
                DialogHeroBio.instance(R.drawable.spectre, "Spectre", R.raw.spectre).show(getFragmentManager(),"oops");

            case R.id.templar:
                DialogHeroBio.instance(R.drawable.templar_assassin, "Templar Assassin", R.raw.templarassassin).show(getFragmentManager(),"oops");

            case R.id.terrorblade:
                DialogHeroBio.instance(R.drawable.terrorblade, "Terrorblade", R.raw.terrorblade).show(getFragmentManager(),"oops");

            case R.id.trollwarlord:
                DialogHeroBio.instance(R.drawable.troll_warlord, "Troll Warlord", R.raw.trollwarlord).show(getFragmentManager(),"oops");

            case R.id.ursa:
                DialogHeroBio.instance(R.drawable.ursa, "Ursa", R.raw.ursa).show(getFragmentManager(),"oops");

            case R.id.vengefulspirit:
                DialogHeroBio.instance(R.drawable.anti_mage, "Vengeful Spirit", R.raw.vengefulspirit).show(getFragmentManager(),"oops");

            case R.id.venomancer:
                DialogHeroBio.instance(R.drawable.venomancer, "Venomancer", R.raw.venomancer).show(getFragmentManager(),"oops");

            case R.id.viper:
                DialogHeroBio.instance(R.drawable.viper, "Viper", R.raw.viper).show(getFragmentManager(),"oops");

            case R.id.weaver:
                DialogHeroBio.instance(R.drawable.weaver, "Weaver", R.raw.weaver).show(getFragmentManager(),"oops");


default:

        }


    }
}

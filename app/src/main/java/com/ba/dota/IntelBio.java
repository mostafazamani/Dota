package com.ba.dota;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class IntelBio extends Fragment implements View.OnClickListener{


    public static final IntelBio ininstanc(){
        IntelBio intelBio = new IntelBio();



        return intelBio;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.intel_bio,container,false);

        view.findViewById(R.id.ancient).setOnClickListener(this);
        view.findViewById(R.id.bane).setOnClickListener(this);
        view.findViewById(R.id.batrider).setOnClickListener(this);
        view.findViewById(R.id.chen).setOnClickListener(this);
        view.findViewById(R.id.crystal).setOnClickListener(this);
        view.findViewById(R.id.darkseer).setOnClickListener(this);
        view.findViewById(R.id.darkwillow).setOnClickListener(this);
        view.findViewById(R.id.dazzle).setOnClickListener(this);
        view.findViewById(R.id.death).setOnClickListener(this);
        view.findViewById(R.id.disrupter).setOnClickListener(this);
        view.findViewById(R.id.enchantress).setOnClickListener(this);
        view.findViewById(R.id.enigma).setOnClickListener(this);
        view.findViewById(R.id.grimstroker).setOnClickListener(this);
        view.findViewById(R.id.invoker).setOnClickListener(this);
        view.findViewById(R.id.jakiro).setOnClickListener(this);
        view.findViewById(R.id.keeper).setOnClickListener(this);
        view.findViewById(R.id.leshrac).setOnClickListener(this);
        view.findViewById(R.id.lich).setOnClickListener(this);
        view.findViewById(R.id.lina).setOnClickListener(this);
        view.findViewById(R.id.lion).setOnClickListener(this);
        view.findViewById(R.id.natures).setOnClickListener(this);
        view.findViewById(R.id.necrophos).setOnClickListener(this);
        view.findViewById(R.id.ogremagi).setOnClickListener(this);
        view.findViewById(R.id.oracle).setOnClickListener(this);
        view.findViewById(R.id.outworld).setOnClickListener(this);
        view.findViewById(R.id.puck).setOnClickListener(this);
        view.findViewById(R.id.pugna).setOnClickListener(this);
        view.findViewById(R.id.queen).setOnClickListener(this);
        view.findViewById(R.id.rubick).setOnClickListener(this);
        view.findViewById(R.id.shadowdemon).setOnClickListener(this);
        view.findViewById(R.id.shadowshaman).setOnClickListener(this);
        view.findViewById(R.id.silencer).setOnClickListener(this);
        view.findViewById(R.id.skywrath).setOnClickListener(this);
        view.findViewById(R.id.stormspirit).setOnClickListener(this);
        view.findViewById(R.id.techies).setOnClickListener(this);
        view.findViewById(R.id.tinker).setOnClickListener(this);
        view.findViewById(R.id.visage).setOnClickListener(this);
        view.findViewById(R.id.warlock).setOnClickListener(this);
        view.findViewById(R.id.windranger).setOnClickListener(this);
        view.findViewById(R.id.winterwyvern).setOnClickListener(this);
        view.findViewById(R.id.witch).setOnClickListener(this);
        view.findViewById(R.id.zeus).setOnClickListener(this);







        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case( R.id.ancient):
                DialogHeroBio.instance(R.drawable.ancient_apparition, "Ancient Apparition", R.raw.ancientapparition).show(getFragmentManager(), "oops");
                break;
            case (R.id.bane):
                DialogHeroBio.instance(R.drawable.bane, "Bane", R.raw.bane).show(getFragmentManager(), "oops");
                break;
            case R.id.batrider:
                DialogHeroBio.instance(R.drawable.batrider, "Batrider", R.raw.batrider).show(getFragmentManager(), "oops");
                break;
            case R.id.chen:
                DialogHeroBio.instance(R.drawable.chen, "Chen", R.raw.chen).show(getFragmentManager(), "oops");
                break;
            case R.id.crystal:
                DialogHeroBio.instance(R.drawable.crystal_maiden, "Crystal Maiden", R.raw.crystalmaiden).show(getFragmentManager(), "oops");
                break;
            case R.id.darkseer:
                DialogHeroBio.instance(R.drawable.dark_seer, "Dark Seer", R.raw.darkseer).show(getFragmentManager(), "oops");
                break;
            case R.id.darkwillow:
                DialogHeroBio.instance(R.drawable.dark_willow, "Dark Willow", R.raw.darkwillow).show(getFragmentManager(), "oops");
                break;
            case R.id.dazzle:
                DialogHeroBio.instance(R.drawable.dazzle, "Dazzle", R.raw.dazzle).show(getFragmentManager(), "oops");
                break;
            case R.id.death:
                DialogHeroBio.instance(R.drawable.death_prophet, "Death Prophet", R.raw.deathprophet).show(getFragmentManager(), "oops");
                break;
            case R.id.disrupter:
                DialogHeroBio.instance(R.drawable.disruptor, "Disruptor", R.raw.disruptor).show(getFragmentManager(), "oops");
                break;
            case R.id.enchantress:
                DialogHeroBio.instance(R.drawable.enchantress, "Enchantress", R.raw.enchantress).show(getFragmentManager(), "oops");
                break;
            case R.id.enigma:
                DialogHeroBio.instance(R.drawable.enigma, "Enigma", R.raw.enigma).show(getFragmentManager(), "oops");
                break;
            case R.id.grimstroker:
                DialogHeroBio.instance(R.drawable.grimstroke, "Grimstroke", R.raw.grimstroke).show(getFragmentManager(), "oops");
                break;
            case R.id.invoker:
                DialogHeroBio.instance(R.drawable.invoker, "Invoker", R.raw.invoker).show(getFragmentManager(), "oops");
                break;
            case R.id.jakiro:
                DialogHeroBio.instance(R.drawable.jakiro, "Jakiro", R.raw.jakiro).show(getFragmentManager(), "oops");
                break;
            case R.id.keeper:
                DialogHeroBio.instance(R.drawable.keeper_of_the_light, "Keeper Of The Light", R.raw.keeperofthelight).show(getFragmentManager(), "oops");
                break;
            case R.id.leshrac:
                DialogHeroBio.instance(R.drawable.leshrac, "Leshrac", R.raw.leshrac).show(getFragmentManager(), "oops");
                break;
            case R.id.lich:
                DialogHeroBio.instance(R.drawable.lich, "Lich", R.raw.lich).show(getFragmentManager(), "oops");
                break;
            case R.id.lina:
                DialogHeroBio.instance(R.drawable.lina, "Lina", R.raw.lina).show(getFragmentManager(), "oops");
                break;
            case R.id.lion:
                DialogHeroBio.instance(R.drawable.lion, "Lion", R.raw.lion).show(getFragmentManager(), "oops");
                break;
            case R.id.natures:
                DialogHeroBio.instance(R.drawable.natures_prophet, "Natures Prophet", R.raw.natureprophet).show(getFragmentManager(), "oops");
                break;
            case R.id.necrophos:
                DialogHeroBio.instance(R.drawable.necrophos, "Necrophos", R.raw.necrophos).show(getFragmentManager(), "oops");
                break;
            case R.id.ogremagi:
                DialogHeroBio.instance(R.drawable.ogre_magi, "Ogre Magi", R.raw.phantomlancer).show(getFragmentManager(), "oops");
                break;
            case R.id.oracle:
                DialogHeroBio.instance(R.drawable.oracle, "Oracle", R.raw.oracle).show(getFragmentManager(), "oops");
                break;
            case R.id.outworld:
                DialogHeroBio.instance(R.drawable.outworld_devourer, "Outworld_Devourer", R.raw.outworlddevourer).show(getFragmentManager(), "oops");
                break;
            case R.id.puck:
                DialogHeroBio.instance(R.drawable.puck, "Puck", R.raw.puck).show(getFragmentManager(), "oops");
                break;
            case R.id.pugna:
                DialogHeroBio.instance(R.drawable.pugna, "Pugna", R.raw.pugna).show(getFragmentManager(), "oops");
                break;
            case R.id.queen:
                DialogHeroBio.instance(R.drawable.queen_of_pain, "Queen Of Pain", R.raw.queenofpain).show(getFragmentManager(), "oops");
                break;
            case R.id.rubick:
                DialogHeroBio.instance(R.drawable.rubick, "Rubick", R.raw.rubick).show(getFragmentManager(), "oops");
                break;
            case R.id.shadowdemon:
                DialogHeroBio.instance(R.drawable.shadow_demon, "Shadow Demon", R.raw.shadowdemon).show(getFragmentManager(), "oops");
                break;
            case R.id.shadowshaman:
                DialogHeroBio.instance(R.drawable.shadow_shaman, "Shadow Shaman", R.raw.shadowshaman).show(getFragmentManager(), "oops");
                break;
            case R.id.silencer:
                DialogHeroBio.instance(R.drawable.silencer, "Silencer", R.raw.silencer).show(getFragmentManager(), "oops");
                break;
            case R.id.skywrath:
                DialogHeroBio.instance(R.drawable.skywrath_mage, "Skywrath Mage", R.raw.skywrathmage).show(getFragmentManager(), "oops");
                break;
            case R.id.stormspirit:
                DialogHeroBio.instance(R.drawable.storm_spirit, "Storm Spirit", R.raw.stormspirit).show(getFragmentManager(), "oops");
                break;
            case R.id.techies:
                DialogHeroBio.instance(R.drawable.techies, "Techies", R.raw.techies).show(getFragmentManager(), "oops");
                break;
            case R.id.tinker:
                DialogHeroBio.instance(R.drawable.tinker, "Tinker", R.raw.tinker).show(getFragmentManager(), "oops");
                break;
            case R.id.visage:
                DialogHeroBio.instance(R.drawable.visage, "Visage", R.raw.visage).show(getFragmentManager(), "oops");
                break;
            case R.id.warlock:
                DialogHeroBio.instance(R.drawable.warlock, "Warlock", R.raw.warlock).show(getFragmentManager(), "oops");
                break;
            case R.id.windranger:
                DialogHeroBio.instance(R.drawable.windranger, "Windranger", R.raw.windranger).show(getFragmentManager(), "oops");
                break;
            case R.id.winterwyvern:
                DialogHeroBio.instance(R.drawable.winter_wyvern, "Winter Wyvern", R.raw.winterwyvern).show(getFragmentManager(), "oops");
                break;
            case R.id.witch:
                DialogHeroBio.instance(R.drawable.witch_doctor, " Witch Doctor", R.raw.witchdoctor).show(getFragmentManager(), "oops");
                break;
            case R.id.zeus:
                DialogHeroBio.instance(R.drawable.zeus, "Zeus", R.raw.zeus).show(getFragmentManager(), "oops");
                break;

            default:

        }


    }
}

package com.ba.dota;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StrengthBio extends Fragment implements View.OnClickListener {

public static final StrengthBio stinstanc(){
    StrengthBio strengthBio = new StrengthBio();



    return strengthBio;
}


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.strength_bio,container,false);

        view.findViewById(R.id.abaddon).setOnClickListener(this);
        view.findViewById(R.id.alchemist).setOnClickListener(this);
        view.findViewById(R.id.axe).setOnClickListener(this);
        view.findViewById(R.id.beastmaster).setOnClickListener(this);
        view.findViewById(R.id.brisrleback).setOnClickListener(this);
        view.findViewById(R.id.brewmaster).setOnClickListener(this);
        view.findViewById(R.id.centaur).setOnClickListener(this);
        view.findViewById(R.id.chaosknight).setOnClickListener(this);
        view.findViewById(R.id.clockwerk).setOnClickListener(this);
        view.findViewById(R.id.doom).setOnClickListener(this);
        view.findViewById(R.id.dragonknight).setOnClickListener(this);
        view.findViewById(R.id.earthshaker).setOnClickListener(this);
        view.findViewById(R.id.earth).setOnClickListener(this);
        view.findViewById(R.id.elder).setOnClickListener(this);
        view.findViewById(R.id.huskar).setOnClickListener(this);
        view.findViewById(R.id.io).setOnClickListener(this);
        view.findViewById(R.id.kunkka).setOnClickListener(this);
        view.findViewById(R.id.legion).setOnClickListener(this);
        view.findViewById(R.id.lifestealer).setOnClickListener(this);
        view.findViewById(R.id.lycan).setOnClickListener(this);
        view.findViewById(R.id.magnus).setOnClickListener(this);
        view.findViewById(R.id.night).setOnClickListener(this);
        view.findViewById(R.id.omniknight).setOnClickListener(this);
        view.findViewById(R.id.phoenix).setOnClickListener(this);
        view.findViewById(R.id.pudge).setOnClickListener(this);
        view.findViewById(R.id.sandking).setOnClickListener(this);
        view.findViewById(R.id.slardar).setOnClickListener(this);
        view.findViewById(R.id.spiritbreaker).setOnClickListener(this);
        view.findViewById(R.id.sven).setOnClickListener(this);
        view.findViewById(R.id.tidehunter).setOnClickListener(this);
        view.findViewById(R.id.timbersaw).setOnClickListener(this);
        view.findViewById(R.id.tiny).setOnClickListener(this);
        view.findViewById(R.id.treantprotector).setOnClickListener(this);
        view.findViewById(R.id.tusk).setOnClickListener(this);
        view.findViewById(R.id.underlord).setOnClickListener(this);
        view.findViewById(R.id.undying).setOnClickListener(this);
        view.findViewById(R.id.wraithking).setOnClickListener(this);







        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case( R.id.abaddon):
                DialogHeroBio.instance(R.drawable.abaddon, "Abaddon", R.raw.abaddon).show(getFragmentManager(), "oops");
                break;
            case (R.id.alchemist):
                DialogHeroBio.instance(R.drawable.alchemist, "Alchemist ", R.raw.alchemist).show(getFragmentManager(), "oops");
                break;
            case R.id.axe:
                DialogHeroBio.instance(R.drawable.axe, "Axe", R.raw.axe).show(getFragmentManager(), "oops");
                break;
            case R.id.beastmaster:
                DialogHeroBio.instance(R.drawable.beastmaster, "Beastmaster", R.raw.beastmaster).show(getFragmentManager(), "oops");
                break;
            case R.id.brewmaster:
                DialogHeroBio.instance(R.drawable.brewmaster, "Brewmaster", R.raw.brewmaster).show(getFragmentManager(), "oops");
                break;
            case R.id.brisrleback:
                DialogHeroBio.instance(R.drawable.bristleback, "Bristleback", R.raw.bristleback).show(getFragmentManager(), "oops");
                break;
            case R.id.centaur:
                DialogHeroBio.instance(R.drawable.centaur_warrunner, "Centaur Warrunner", R.raw.centaurwarrunner).show(getFragmentManager(), "oops");
                break;
            case R.id.chaosknight:
                DialogHeroBio.instance(R.drawable.chaos_knight, "Chaos Knight", R.raw.chaosknight).show(getFragmentManager(), "oops");
                break;
            case R.id.clockwerk:
                DialogHeroBio.instance(R.drawable.clockwerk, "Clockwerk", R.raw.clockwerk).show(getFragmentManager(), "oops");
                break;
            case R.id.doom:
                DialogHeroBio.instance(R.drawable.doom, "Doom", R.raw.doom).show(getFragmentManager(), "oops");
                break;
            case R.id.dragonknight:
                DialogHeroBio.instance(R.drawable.dragon_knight, "Dragon Knight", R.raw.dragonknight).show(getFragmentManager(), "oops");
                break;
            case R.id.earthshaker:
                DialogHeroBio.instance(R.drawable.earthshaker, "Earth Shaker", R.raw.earthshaker).show(getFragmentManager(), "oops");
                break;
            case R.id.earth:
                DialogHeroBio.instance(R.drawable.earth_spirit, "Earth Spirit", R.raw.earthspirit).show(getFragmentManager(), "oops");
                break;
            case R.id.elder:
                DialogHeroBio.instance(R.drawable.elder_titan, "Elder Titan", R.raw.eldertitan).show(getFragmentManager(), "oops");
                break;
            case R.id.huskar:
                DialogHeroBio.instance(R.drawable.huskar, "Huskar", R.raw.huskar).show(getFragmentManager(), "oops");
                break;
            case R.id.io:
                DialogHeroBio.instance(R.drawable.io, "Io", R.raw.io).show(getFragmentManager(), "oops");
                break;
            case R.id.kunkka:
                DialogHeroBio.instance(R.drawable.kunkka, "Kunkka", R.raw.kunkka).show(getFragmentManager(), "oops");
                break;
            case R.id.legion:
                DialogHeroBio.instance(R.drawable.legion_commander, "Legion Commander", R.raw.legioncommander).show(getFragmentManager(), "oops");
                break;
            case R.id.lifestealer:
                DialogHeroBio.instance(R.drawable.lifestealer, "Lifestealer", R.raw.lifestealer).show(getFragmentManager(), "oops");
                break;
            case R.id.lycan:
                DialogHeroBio.instance(R.drawable.lycan, "Lycan", R.raw.lycan).show(getFragmentManager(), "oops");
                break;
            case R.id.magnus:
                DialogHeroBio.instance(R.drawable.magnus, "Magnus", R.raw.magnus).show(getFragmentManager(), "oops");
                break;
            case R.id.night:
                DialogHeroBio.instance(R.drawable.night_stalker, "Night Stalker", R.raw.nightstalker).show(getFragmentManager(), "oops");
                break;
            case R.id.omniknight:
                DialogHeroBio.instance(R.drawable.omniknight, "Omniknight", R.raw.omniknight).show(getFragmentManager(), "oops");
                break;
            case R.id.phoenix:
                DialogHeroBio.instance(R.drawable.phoenix, "Phoenix", R.raw.phoenix).show(getFragmentManager(), "oops");
                break;
            case R.id.pudge:
                DialogHeroBio.instance(R.drawable.pudge, "Pudge", R.raw.pudge).show(getFragmentManager(), "oops");
                break;
            case R.id.sandking:
                DialogHeroBio.instance(R.drawable.sand_king, "Sand King", R.raw.sandking).show(getFragmentManager(), "oops");
                break;
            case R.id.slardar:
                DialogHeroBio.instance(R.drawable.slardar, "Slarder", R.raw.slardar).show(getFragmentManager(), "oops");
                break;
            case R.id.spiritbreaker:
                DialogHeroBio.instance(R.drawable.spirit_breaker, "Spirit Breaker", R.raw.spectre).show(getFragmentManager(), "oops");
                break;
            case R.id.sven:
                DialogHeroBio.instance(R.drawable.sven, "Sven", R.raw.sven).show(getFragmentManager(), "oops");
                break;
            case R.id.tidehunter:
                DialogHeroBio.instance(R.drawable.tidehunter, "Tidehunter", R.raw.tidehunter).show(getFragmentManager(), "oops");
                break;
            case R.id.timbersaw:
                DialogHeroBio.instance(R.drawable.timbersaw, "Timbersaw", R.raw.timbersaw).show(getFragmentManager(), "oops");
                break;
            case R.id.tiny:
                DialogHeroBio.instance(R.drawable.tiny, "Tiny", R.raw.tiny).show(getFragmentManager(), "oops");
                break;
            case R.id.treantprotector:
                DialogHeroBio.instance(R.drawable.treant_protector, "Treant Protector", R.raw.treantprotector).show(getFragmentManager(), "oops");
                break;
            case R.id.tusk:
                DialogHeroBio.instance(R.drawable.tusk, "Tusk", R.raw.tusk).show(getFragmentManager(), "oops");
                break;
            case R.id.underlord:
                DialogHeroBio.instance(R.drawable.underlord, "Underlord", R.raw.underlord).show(getFragmentManager(), "oops");
                break;
            case R.id.undying:
                DialogHeroBio.instance(R.drawable.undying, "Undying", R.raw.undying).show(getFragmentManager(), "oops");
                break;
            case R.id.wraithking:
                DialogHeroBio.instance(R.drawable.wraith_king, "Wraith King", R.raw.wraithking).show(getFragmentManager(), "oops");
                break;

            default:

        }


    }
}

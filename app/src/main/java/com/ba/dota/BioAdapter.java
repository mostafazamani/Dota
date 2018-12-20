package com.ba.dota;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class BioAdapter extends FragmentPagerAdapter {

    String title[]= {"Strength", "Agility", "Intelligence"} ;

    public BioAdapter(FragmentManager fm) {
        super(fm);
    }




    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                return StrengthBio.stinstanc();
            case 1:
                return  AgilityBio.agistanc();
            case 2:
                return  IntelBio.ininstanc();
            default:
                return null;
        }
    }



    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}

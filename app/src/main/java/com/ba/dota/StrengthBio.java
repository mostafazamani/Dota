package com.ba.dota;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StrengthBio extends Fragment {

public static final StrengthBio stinstanc(){
    StrengthBio strengthBio = new StrengthBio();



    return strengthBio;
}


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.strength_bio,container,false);



        return view;
    }
}

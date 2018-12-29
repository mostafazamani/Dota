package com.ba.dota;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class IntelBio extends Fragment {


    public static final IntelBio ininstanc(){
        IntelBio intelBio = new IntelBio();



        return intelBio;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.intel_bioi,container,false);



        return view;
    }


}

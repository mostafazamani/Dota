package com.ba.dota;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogHeroBio extends DialogFragment {

public static DialogHeroBio instance(int id_image, String name_hero , int id_text_hero){
    DialogHeroBio bio = new DialogHeroBio();
    Bundle bundle = new Bundle();

    bundle.putInt("image",id_image);
    bundle.putString("name",name_hero);

    bundle.putInt("text",id_text_hero);

    bio.setArguments(bundle);

    return bio;
}



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hero_bio,container,false);

        Button close = (Button) view.findViewById(R.id.btn_bastan);
        ImageView imageView = (ImageView) view.findViewById(R.id.profile_hero);
        TextView name = (TextView) view.findViewById(R.id.bio_name);
        TextView text_bio = (TextView) view.findViewById(R.id.text_bio);

        imageView.setImageResource(getArguments().getInt("image"));
        name.setText(getArguments().getString("name"));
        text_bio.setText(getArguments().getInt("text"));




        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return view;
    }
}

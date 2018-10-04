package com.ba.dota;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

/**
 * Created by Mostafa on 9/30/2018.
 */

public class HeroSAdapte extends BaseAdapter {

    List<Hero> heroList;
    Context context;

    public HeroSAdapte(List<Hero> heroList, Context context) {
        this.heroList = heroList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return heroList.size();
    }

    @Override
    public Object getItem(int position) {
        return heroList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context,R.layout.list_hero,null);

        TextView textView = (TextView) v.findViewById(R.id.name_hero);
        final ImageView imageView = (ImageView) v.findViewById(R.id.image_hero);

        textView.setText(heroList.get(position).getName());




        RequestQueue requestQueue = Volley.newRequestQueue(context);
        ImageRequest request = new ImageRequest(heroList.get(position).getImage(), new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

                imageView.setImageBitmap(response);


            }
        }, 160, 160, ImageView.ScaleType.FIT_CENTER, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "check network", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);


        return v;
    }
}

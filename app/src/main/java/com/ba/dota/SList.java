package com.ba.dota;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

/**
 * Created by Mostafa on 9/29/2018.
 */

public class SList extends BaseAdapter {
    List<Items> slist;
    Context context;

    DbUtil dbUtil;

    public SList(List<Items> slist, Context context) {
        this.slist = slist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return slist.size();
    }

    @Override
    public Object getItem(int position) {
        return slist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = View.inflate(context,R.layout.s_list,null);

        TextView textView = (TextView) view.findViewById(R.id.text_s);
        final ImageView imageView = (ImageView) view.findViewById(R.id.image_s);
        Button button = (Button) view.findViewById(R.id.btn_s);
        dbUtil = new DbUtil(context);



        textView.setText(slist.get(position).getItem_text());



        RequestQueue requestQueue = Volley.newRequestQueue(context);
        ImageRequest request = new ImageRequest(slist.get(position).getUri_image(), new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

                imageView.setImageBitmap(response);


            }
        }, 160, 160, ImageView.ScaleType.FIT_CENTER, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbUtil.DleteItem(slist.get(position).getId());
                slist.remove(position);
                notifyDataSetChanged();


            }
        });

        return view;
    }
}

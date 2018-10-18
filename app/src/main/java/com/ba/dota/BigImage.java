package com.ba.dota;

import android.app.DialogFragment;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class BigImage extends DialogFragment {

    public static BigImage newInstace(String url){

        BigImage bigImage = new BigImage();
        Bundle bundle = new Bundle();
        bundle.putString("url",url);
        bigImage.setArguments(bundle);

        return bigImage;
    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.big_image,container,false);

        String url = getArguments().getString("url");

        final RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.layout_big_image);
       final ImageView imageView = (ImageView) view.findViewById(R.id.big_item_image);
        Button button = (Button) view.findViewById(R.id.big_item_btn);
       final ProgressBar bar = (ProgressBar) view.findViewById(R.id.big_bar);

        bar.setVisibility(View.VISIBLE);

        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        final ImageRequest request = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                bar.setVisibility(View.GONE);
                imageView.setImageBitmap(response);

                Bitmap bitmap = Blurry.blur(getActivity(),response);
                layout.setBackground(new BitmapDrawable(getResources(),bitmap));



            }
        }, 160, 160, ImageView.ScaleType.FIT_CENTER, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                bar.setVisibility(View.GONE);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        view.invalidate();
                    }
                });


            }
        });
        requestQueue.add(request);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }
}

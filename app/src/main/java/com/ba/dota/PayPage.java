package com.ba.dota;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class PayPage extends AppCompatActivity {
    TextView amount , payer_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_page);

        final ImageView imageView = (ImageView) findViewById(R.id.image_info);
        amount = (TextView) findViewById(R.id.amount_show);
        payer_name = (TextView) findViewById(R.id.payer_name);
        String name = getIntent().getStringExtra("name");
        int gh = getIntent().getIntExtra("gh",0);

        payer_name.setText(name);
        amount.setText(String.valueOf(gh));
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        View view = inflater.inflate(R.layout.popup_info, null);
        final PopupWindow popupWindow = new PopupWindow(view, width, height, true);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.showAtLocation(imageView, Gravity.CENTER, 0, 0);

            }
        });
    }


}

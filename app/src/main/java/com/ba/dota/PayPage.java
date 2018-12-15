package com.ba.dota;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.zarinpal.ewallets.purchase.OnCallbackRequestPaymentListener;
import com.zarinpal.ewallets.purchase.OnCallbackVerificationPaymentListener;
import com.zarinpal.ewallets.purchase.PaymentRequest;
import com.zarinpal.ewallets.purchase.ZarinPal;

public class PayPage extends AppCompatActivity {
    TextView amount, payer_name, trade, number;
    Button btn_pay,btn_cancel;
    SharedPreferences per;
    DbUtil dbUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_page);

        final ImageView imageView = (ImageView) findViewById(R.id.image_info);
        amount = (TextView) findViewById(R.id.amount_show);
        payer_name = (TextView) findViewById(R.id.payer_name);
        trade = (TextView) findViewById(R.id.trade_link);
        btn_pay = (Button) findViewById(R.id.pay_next_btn);
        btn_cancel = (Button) findViewById(R.id.pay_cancel);
        number = (TextView) findViewById(R.id.payer_number);

        dbUtil = new DbUtil(this);

        String item_name = getIntent().getStringExtra("name");
        final int gh = getIntent().getIntExtra("gh", 0);


        per = getPreferences(MODE_PRIVATE);
        final SharedPreferences.Editor editor = per.edit();

        Uri data = getIntent().getData();
        ZarinPal.getPurchase(this).verificationPayment(data, new OnCallbackVerificationPaymentListener() {
            @Override
            public void onCallbackResultVerificationPayment(boolean isPaymentSuccess, String refID, PaymentRequest paymentRequest) {

                if (isPaymentSuccess){


                }else {


                }

            }
        });


        amount.setText(String.valueOf(gh));
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);


        payer_name.setText(per.getString("payername", null));
        trade.setText(per.getString("tradelink", null));
        number.setText(per.getString("number", null));

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

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("payername", payer_name.getText().toString().trim());
                editor.putString("tradelink", trade.getText().toString().trim());
                editor.putString("number", number.getText().toString().trim());
                editor.apply();

                paysetting(gh);


            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbUtil.EmptyTable();
            }
        });

    }

    public void paysetting(long amount) {

        ZarinPal zarinPal = ZarinPal.getPurchase(this);
        PaymentRequest request = ZarinPal.getPaymentRequest();

        request.setMerchantID("");
        request.setAmount(amount);
        request.setDescription("خرید آیتم DotA2");
        request.setCallbackURL("return://dotapaypage");

        zarinPal.startPayment(request, new OnCallbackRequestPaymentListener() {
            @Override
            public void onCallbackResultPaymentRequest(int status, String authority, Uri paymentGatewayUri, Intent intent) {
                if (status == 100) {
                    startActivity(intent);
                } else {
                    Toast.makeText(PayPage.this, "wrong...", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }


}

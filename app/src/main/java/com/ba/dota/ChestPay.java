package com.ba.dota;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.util.Random;
import java.util.logging.Handler;

public class ChestPay extends AppCompatActivity {
    SharedPreferences per;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chest_pay);

        TextView amount = (TextView) findViewById(R.id.chest_amount_show);
        final Button pay = (Button) findViewById(R.id.chest_pay_next_btn);
        Button cancel = (Button) findViewById(R.id.chest_pay_cancel);
        final TextView payer_name = (TextView) findViewById(R.id.chest_payer_name);
        final TextView trade = (TextView) findViewById(R.id.chest_trade_link);
        final TextView number = (TextView) findViewById(R.id.chest_payer_number);
        final ImageView info = (ImageView) findViewById(R.id.chest_image_info);

        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);


        pay.setClickable(true);
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;


        View view = inflater.inflate(R.layout.popup_info, null);
        TextView cl = (TextView) view.findViewById(R.id.info_moreinfo);
        final PopupWindow popupWindow = new PopupWindow(view, width, height, true);

        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.showAtLocation(info, Gravity.CENTER, 0, 0);

            }
        });

        final int am;
        String des = null;


        final int random = setrandom();

        final int x = getIntent().getIntExtra("number", 0);

        if (x == 1) {
            am = 5000;
            amount.setText("5000");
            des = "chest 1 %1%2%4%" + random + "%8%a%l%k%i";

        } else if (x == 2) {
            amount.setText("8000");
            am = 8000;
            des = "chest 2 %1%2%4%" + random + "%8%a%l%k%i";

        } else if (x == 3) {
            amount.setText("10000");
            am = 10000;
            des = "chest 3 %1%2%4%" + random + "%8%a%l%k%i";

        } else {
            amount.setText("0");
            am = 0;
        }
        final String g = des;

        per = getPreferences(MODE_PRIVATE);
        final SharedPreferences.Editor editor = per.edit();


        Uri data = getIntent().getData();
        ZarinPal.getPurchase(this).verificationPayment(data, new OnCallbackVerificationPaymentListener() {
            @Override
            public void onCallbackResultVerificationPayment(boolean isPaymentSuccess, String refID, PaymentRequest paymentRequest) {
                if (isPaymentSuccess) {
                    SetsenderChest sc = SetsenderChest.chestinstance(per.getString("payer_name","customer"),
                            per.getString("trade",null),per.getString("number",null),per.getInt("nc",0), refID, per.getInt("random",6),3);

                    sc.show((ChestPay.this).getFragmentManager(), "ff");

                } else {
                    Toast.makeText(ChestPay.this, "خطا در خرید", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(ChestPay.this,MainActivity.class));


                }


            }
        });


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pay.setClickable(false);

                if (payer_name.getText().toString().matches("")||trade.getText().toString().matches("")||
                        number.getText().toString().matches("")){
                    Toast.makeText(ChestPay.this, "فیلد هارا پر کنید", Toast.LENGTH_SHORT).show();

                }else {
                    editor.putString("payer_name" , payer_name.getText().toString());
                    editor.putString("number",number.getText().toString());
                    editor.putString("trade",trade.getText().toString());
                    editor.putInt("random", random);
                    editor.putInt("nc", x);
                    editor.apply();

                    paysetting(am, g,trade.getText().toString(),number.getText().toString());
                }

                final android.os.Handler handler = new android.os.Handler();
               handler.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       pay.setClickable(true);
                   }
               },3000);

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void paysetting(long amount, String itemname,String tradlink,String numb) {

        ZarinPal zarinPal = ZarinPal.getPurchase(this);
        PaymentRequest request = ZarinPal.getPaymentRequest();

        request.setMerchantID("ba319298-2385-11e9-b774-005056a205be");
        request.setAmount(amount);
        request.setDescription("DotA 2 Items :\n" +
                itemname+"\n------- trade link:"+tradlink
        +"\n----- phone number:"+numb);
        request.setCallbackURL("ches://ches");

        zarinPal.startPayment(request, new OnCallbackRequestPaymentListener() {
            @Override
            public void onCallbackResultPaymentRequest(int status, String authority, Uri paymentGatewayUri, Intent intent) {
                if (status == 100) {
                    startActivity(intent);
                } else {
                    Toast.makeText(ChestPay.this, "wrong...", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    public int setrandom() {
        Random random = new Random();
        int x = random.nextInt(100);


        if (x == 13 || x == 21 || x == 67 || x == 93) {
            return 4;
        } else if (x == 2 || x == 5 || x == 7 || x == 42 || x == 53 || x == 64 || x == 75 || x == 86 || x == 97) {
            return 3;
        } else if (x == 1 || x == 3 || x == 7 || x == 9 || x == 11 || x == 23 || x == 29 || x == 32 || x == 39 || x == 41 || x == 52 || x == 59 || x == 60 || x == 70 || x == 80 || x == 90 || x == 99 || x == 100 || x == 85 || x == 73 || x == 65) {
            return 2;
        } else {
            if (random.nextInt(2) == 2) {
                return 1;
            } else {
                return 0;
            }
        }


    }

    @Override
    public void onBackPressed() {
        return;
    }
}

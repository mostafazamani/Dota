package com.ba.dota;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.database.DatabaseUtilsCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mostafa on 9/29/2018.
 */

public class DbUtil extends SQLiteOpenHelper {
    Context context;

    View view;
    private static final String DBname = "ListItem";
    private static final String TB_NAME = "tb_Item";

    private static final String CMD = "CREATE TABLE " + TB_NAME + " ("
            + Items.Key_Id + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + Items.KEY_TEXT + " TEXT, "
            + Items.KEY_IMAGE + " TEXT, "
            + Items.KEY_CAST + " TEXT" +
            ");";


    private static final String[] allColumns = {Items.Key_Id, Items.KEY_TEXT, Items.KEY_IMAGE, Items.KEY_CAST};


    public DbUtil(Context context) {
        super(context, DBname, null, 1);
        this.context = context;
    }

    public DbUtil(Context context, View view) {
        super(context, DBname, null, 1);
        this.context = context;
        this.view = view;


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CMD);
        Toast.makeText(context, "created", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF NOT EXISTS " + TB_NAME);
        onCreate(db);

    }

    public void AddItem(Items items) {

        SQLiteDatabase sd = this.getWritableDatabase();
        long insertId = sd.insert(TB_NAME, null, items.getContentValues());

        if (insertId == -1) {

            Snackbar snackbar = Snackbar.make(view, "Failed", Snackbar.LENGTH_LONG);
            View sbview = snackbar.getView();
            sbview.setBackgroundColor(0xffff4334);
            snackbar.show();

        } else {

            Snackbar snackbar = Snackbar.make(view, " Item Added ", Snackbar.LENGTH_LONG);
            View sbview = snackbar.getView();
            sbview.setBackgroundColor(0xff4cff51);
            snackbar.show();
        }


        if (sd.isOpen()) sd.close();


    }

    public List<Items> getItem() {

        SQLiteDatabase db = getReadableDatabase();
        List<Items> lsl = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TB_NAME, null);


        if (cursor.moveToFirst()) {
            do {

                Items sl = new Items();

                sl.setItem_text(cursor.getString(cursor.getColumnIndex(Items.KEY_TEXT)));
                sl.setUri_image(cursor.getString(cursor.getColumnIndex(Items.KEY_IMAGE)));
                sl.setCast(cursor.getString(cursor.getColumnIndex(Items.KEY_CAST)));
                sl.setId(cursor.getInt(cursor.getColumnIndex(Items.Key_Id)));

                lsl.add(sl);
            } while (cursor.moveToNext());
        }
        cursor.close();
        if (db.isOpen()) db.close();
        return lsl;

    }

    public void DleteItem(int id) {

        SQLiteDatabase db = getReadableDatabase();

        db.delete(TB_NAME, Items.Key_Id + " = " + id + ";", null);

        Snackbar snackbar = Snackbar.make(view, " Item Deleted ", Snackbar.LENGTH_LONG);
        View sbview = snackbar.getView();
        sbview.setBackgroundColor(0xff782278);
        snackbar.show();



        Intent intent = new Intent("custom-event-name");
        intent.putExtra("message", "update!");
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);


        if (db.isOpen()) db.close();


    }

    public boolean CheckItem(String i) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TB_NAME + " WHERE " + Items.KEY_TEXT + "='" + i + "'", null);

        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }


    }


}



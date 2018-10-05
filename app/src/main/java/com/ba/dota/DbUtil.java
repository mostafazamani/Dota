package com.ba.dota;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mostafa on 9/29/2018.
 */

public class DbUtil extends SQLiteOpenHelper {
    Context context;
    List<Items> itemses;
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
            Log.i("ff", "data insertion failed. (item : " + items.toString() + ")");
            Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();

        } else {
            Log.i("ff", "data inserted with id : " + insertId);
            Toast.makeText(context, "added:" + items.getCast(), Toast.LENGTH_SHORT).show();

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


                lsl.add(sl);
            } while (cursor.moveToNext());
        }
        cursor.close();
        if (db.isOpen()) db.close();
        return lsl;

    }

    public void DleteItem(int id) {

        SQLiteDatabase db = getReadableDatabase();


        db.delete(TB_NAME, Items.Key_Id + " = " + id, null);
        Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();


        if (db.isOpen()) db.close();


    }

    public boolean CheckItem() {

        SQLiteDatabase db = getReadableDatabase();
        List<Items> cil = new ArrayList<>();
   //    Cursor cursor = db.rawQuery("SELECT * FROM "+TB_NAME+" WHERE "+Items.KEY_TEXT+" LIKE 'gg'" ,null);
/*
        //  Cursor cursor = db.query(TB_NAME, allColumns, Items.KEY_TEXT + " = '%" + i + "%'" , null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Items ci = new Items();

                ci.setItem_text(cursor.getString(cursor.getColumnIndex(Items.KEY_TEXT)));
                ci.setUri_image(cursor.getString(cursor.getColumnIndex(Items.KEY_IMAGE)));
                ci.setCast(cursor.getString(cursor.getColumnIndex(Items.KEY_CAST)));
                ci.setId(cursor.getInt(cursor.getColumnIndex(Items.Key_Id)));

                cil.add(ci);

            } while (cursor.moveToNext());
        }
        cursor.close();
        if (db.isOpen()) db.close();
/*
        if (cil.size()>1) {
        return true;

        }else {

        return false;
        }*/
        return true;

    }


}



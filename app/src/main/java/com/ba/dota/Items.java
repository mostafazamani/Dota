package com.ba.dota;

import android.content.ContentValues;

/**
 * Created by Mostafa on 9/29/2018.
 */

public class Items {
    public static final String Key_Id = "Id";
    public static final String KEY_TEXT = "item_text";
    public static final String KEY_IMAGE = "uri_image";
    public static final String KEY_CAST = "cast";


    String item_text;
    String uri_image;
    String cast;
    int Id;

    public String getItem_text() {
        return item_text;
    }

    public void setItem_text(String item_text) {
        this.item_text = item_text;
    }

    public String getUri_image() {
        return uri_image;
    }

    public void setUri_image(String uri_image) {
        this.uri_image = uri_image;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();

        values.put(KEY_TEXT, getItem_text());
        values.put(KEY_IMAGE, getUri_image());
        values.put(KEY_CAST, getCast());


        return values;


    }





}

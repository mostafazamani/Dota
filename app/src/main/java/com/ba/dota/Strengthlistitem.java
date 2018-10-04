package com.ba.dota;

import android.content.ContentValues;
import android.graphics.Bitmap;

/**
 * Created by Mostafa on 9/27/2018.
 */

public class Strengthlistitem {



    String item_text;
    String uri_image;
    String cast;
    int Id;



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

    public String getItem_text() {
        return item_text;
    }

    public void setItem_text(String item_text) {
        this.item_text = item_text;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}

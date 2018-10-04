package com.ba.dota;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mostafa on 9/30/2018.
 */

public class JsonHero {




    public static List<Hero> Item(String json) {

        List<Hero> list = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < json.length(); i++) {
                JSONObject jsonobject = jsonArray.getJSONObject(i);
                Hero sli = new Hero();

                sli.setName(new String(jsonobject.getString("Name").getBytes("UTF-8")));
                sli.setImage(jsonobject.getString("Image"));
                sli.setId(jsonobject.getInt("id"));


                list.add(sli);
            }
        } catch (JSONException |UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return list;
    }


}

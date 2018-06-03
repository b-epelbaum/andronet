package com.example.davids.minitabletapp.logics.network;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class ResponseJsonSerializer implements JsonSerializer<ServerResponse> {

    @Override
    public JsonElement serialize(ServerResponse res, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();

        int testNumber = res.getTest();

        object.addProperty("test", testNumber);
        object.addProperty("cmd", res.getCmd());
        object.addProperty("ptime", res.getPtime());
        object.addProperty("lang", res.getLangCode());

        switch (testNumber) {
            case 503://up scroll
            case 504://down scroll
            case 502:
                object.addProperty("textOne", res.getTextOne());
                object.addProperty("textTwo", res.getTextTwo());
                object.addProperty("ac1", res.getAc1());
                object.addProperty("ac2", res.getAc2());
                break;
        }

        return object;
    }

}

/**
 * @SerializedName("opto") private int		_opto;
 * @SerializedName("dist") private String	_dist;
 * @SerializedName("rSymbols") private String	_rSymbols;
 * @SerializedName("ptime") private long	_ptime;
 * @SerializedName("test") private int		_test;
 * @SerializedName("inv") private int		_inv;
 * @SerializedName("cmd") private String	_cmd;
 * @SerializedName("vSymbols") private String	_vSymbols;
 * @SerializedName("ac1") private String	_ac1;
 * @SerializedName("ac2") private String	_ac2;
 * @SerializedName("ac3") private String	_ac3;
 * @SerializedName("rg") private int		_rg;
 * @SerializedName("mode") private int		_mode;
 * @SerializedName("maxRows") private int		_maxRows;
 * @SerializedName("nbCols") private int		_nbCols;
 * @SerializedName("maxCols") private int		_maxCols;
 * @SerializedName("nbRows") private int		_nbRows;
 * @SerializedName("_err") private int		_err;
 * @SerializedName("contrast") private int		_contrast;
 * @SerializedName("orientation") private int _orientation;
 */

package com.example.davids.minitabletapp.Helpers;

import android.content.SharedPreferences;

import com.example.davids.minitabletapp.NearVisionApplication;


/**
 * Created by Anton on 1/4/2017.
 */

public class PrefHelper {

     static int PRIVATE_MODE = 0;
    private static final String KEY_VXLAN_VALUES = "KEY_VXLAN_VALUES";
     private static final String PREF_NAME = "NearVisionPanel";

        // All Shared Preferences Keys

    private static final String KEY_LANGUAGE = "language";
    private static SharedPreferences pref;




    public static  void setLanguage(String token) {
        SharedPreferences pref = NearVisionApplication.getContext().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        SharedPreferences.Editor editor= pref.edit();
        editor.putString(KEY_LANGUAGE, token);
        editor.commit();
    }

    public static String getLanguage() {
        SharedPreferences pref = NearVisionApplication.getContext().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        return pref.getString(KEY_LANGUAGE, "en");
    }

    public static void setVxLan(String token) {
        pref = NearVisionApplication.getContext().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        SharedPreferences.Editor editor= pref.edit();
        editor.putString(KEY_VXLAN_VALUES, token);
        editor.commit();
    }
    public static String getVxLan() {
        SharedPreferences pref = NearVisionApplication.getContext().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        return pref.getString(KEY_VXLAN_VALUES, "Other");
    }

}

package com.stmikbanisaleh.smart_md.Model_Ok.Login2.Common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class UserPreferense {


    private static SharedPreferences preferences;

    public  static  boolean isLogin(Context context){
       preferences = PreferenceManager.getDefaultSharedPreferences(context);
       return  preferences.getBoolean("login", false);

    }


    public static void hasLogin(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putBoolean("login", true).apply();
    }

    public static void logout(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().clear().apply();
    }

    public static String getTokeUser(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("token", "");
    }

    public static void setTokenUser(Context context, String token) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putString("token", token).apply();
    }

    public static String getUserId(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("id", "");
    }

    public static void setUserId(Context context, String userId) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putString("id", userId).apply();
    }
}

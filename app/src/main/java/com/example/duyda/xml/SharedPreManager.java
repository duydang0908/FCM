package com.example.duyda.xml;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreManager {
    private static final String SHARED_PREF_NAME = "fcmsharedprefdemo";
    private static final String KEY_ACCESS_TOKEN = "token";

    private static Context mCtx;
    private static SharedPreManager mInstance;

    private SharedPreManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPreManager getmInstance(Context context) {
        if (mInstance == null)
            mInstance = new SharedPreManager(context);
        return mInstance;
    }

    public boolean storeToken(String token) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ACCESS_TOKEN, token);
        editor.apply();
        return true;
    }

    public String getToken() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_ACCESS_TOKEN, null);
    }

}

package com.winto.develop.wages;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

public class MainApplication extends Application {
    private static MainApplication application;
    private SharedPreferences preferences = null;

    public final static String TOKEN = "token";
    public final static String USER_NAME = "userName";

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        preferences = getSharedPreferences("Wages", MODE_PRIVATE);
    }

    public static MainApplication getContext() {
        return application;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public String getToken() {
        return preferences.getString(TOKEN, "");
    }

    public void setToken(@NonNull String token) {
        preferences.edit().putString(TOKEN, token).apply();
    }

    public String getUserName() {
        return preferences.getString(USER_NAME, "");
    }

    public void setUserName(@NonNull String userName) {
        preferences.edit().putString(USER_NAME, userName).apply();
    }
}

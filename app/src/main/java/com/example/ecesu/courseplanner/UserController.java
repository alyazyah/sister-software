package com.example.ecesu.courseplanner;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

public class UserController {
    private static final String FOLDERNAME = "days";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public UserController(Context context){
        sharedPreferences = context.getSharedPreferences(FOLDERNAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }
    public void saveDay(View view){
        editor.putBoolean("m", true);
        editor.putBoolean("t", true);
        editor.putBoolean("w", true);
        editor.putBoolean("r", true);
        editor.putBoolean("f", true);
        editor.commit();
    }
}

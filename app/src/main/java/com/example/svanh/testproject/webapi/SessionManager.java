package com.example.svanh.testproject.webapi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


/**
 * Created by svanh on 30-6-2017.
 */

public class SessionManager {
    SharedPreferences session;
    //editor for shared Preferences (android sessie)
    Editor editor;
    //opslaan context
    Context context;
    public static final String KEY_EMAIL = "email";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_NAME = "name";

    public void MakeLoginSession(String Email){

    }

}

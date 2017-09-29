package com.example.svanh.testproject.Login_Logout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.view.*;

import com.example.svanh.testproject.MainActivity;
import com.example.svanh.testproject.R;
import com.example.svanh.testproject.profiel.EditProfile;
import com.example.svanh.testproject.testclasses.CommonActivity;
import com.example.svanh.testproject.webapi.ApiFunctions;
import com.google.android.gms.common.api.Api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends CommonActivity implements CommonActivity.HandleBroadCastResult{
    Button   mButton;
    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);


    }

    public void Inloggen(View view) {
        final EditText email = (EditText)findViewById(R.id.Username);
        final EditText password = (EditText)findViewById(R.id.Password);

        String emailadres = email.getText().toString();
        String wachtwoord = password.getText().toString();
        ApiFunctions.login(this, emailadres, wachtwoord);

    }
    public void LostPassword(View v){
        Intent intent = new Intent(this, LostPassword.class);
        startActivity(intent);

    }
    @Override
    public void processJson() {
        Intent main = new Intent(this, MainActivity.class);
        String userid= "";
        String valid = "";

        try {
            valid = ApiFunctions.getArrayData(broadcastResult, "valid");
            if (valid.equals("true")) {
                userid = ApiFunctions.getArrayData(broadcastResult, "user");
                Storedata(Integer.parseInt(userid), main);
            } else {
                Toast.makeText(getApplicationContext(), "Inloggegevens zijn niet correct.", Toast.LENGTH_LONG).show();
            }



        }catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Server niet bereikbaar.", Toast.LENGTH_LONG).show();
            BacktoMain(main);
        }


//        if (!userid.equals("E01")) {
//
//        } else {
//
//            Toast.makeText(getApplicationContext(), "Server niet bereikbaar.", Toast.LENGTH_LONG).show();
//            BacktoMain(main);
//        }
//        Log.d("Object:", userid + "");



    }

    private void Storedata(int userid, Intent intent) {
        SharedPreferences mSharedPreferences = getSharedPreferences("Userdata", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putInt("ID", userid);
        mEditor.putInt("loggedin", 1);
        mEditor.apply();
        Toast.makeText(getApplicationContext(), "U bent succesvol ingelogd!", Toast.LENGTH_LONG).show();
        BacktoMain(intent);
    }
    public void BacktoMain(Intent intent) {

        startActivity(intent);
    }

}

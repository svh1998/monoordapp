package com.example.svanh.testproject.Login_Logout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.svanh.testproject.R;
import com.example.svanh.testproject.testclasses.CommonActivity;
import com.example.svanh.testproject.webapi.ApiFunctions;

public class LostPassword extends CommonActivity implements CommonActivity.HandleBroadCastResult {
    String emailadres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_password);
    }

    public void Checktoken(View v) {
        final EditText email = (EditText) findViewById(R.id.email);
         emailadres = email.getText().toString();
        ApiFunctions.checkEmail(this,emailadres);
//        SharedPreferences mSharedPreferences = getSharedPreferences("Userdata", MODE_PRIVATE);
//        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
//        mEditor.putString("email", emailadres);
//        mEditor.apply();
    }

    @Override
    public void processJson() {
        String valid = "";
        String email = "";
        try {
            valid = ApiFunctions.getArrayData(broadcastResult, "valid");
            if (valid.equals("true")) {
                // start next activity
                Intent intent = new Intent(this, EnterToken.class);
                intent.putExtra("email", emailadres);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "E-mailadres is niet bekend bij ons. Nog geen account? Registreer nu.", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Server niet bereikbaar.", Toast.LENGTH_LONG).show();

        }
    }
}

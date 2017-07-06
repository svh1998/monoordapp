package com.example.svanh.testproject.Login_Logout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.view.*;

import com.example.svanh.testproject.R;
import com.example.svanh.testproject.testclasses.CommonActivity;
import com.example.svanh.testproject.webapi.ApiFunctions;

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
    @Override
    public void processJson() {
        Log.d("Ingelogd:", broadcastResult);
    }
}

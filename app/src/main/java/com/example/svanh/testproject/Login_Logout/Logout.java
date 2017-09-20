package com.example.svanh.testproject.Login_Logout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.svanh.testproject.MainActivity;
import com.example.svanh.testproject.R;

public class Logout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
    }
    public void Logout(View view) {
        SharedPreferences mSharedPreferences = getSharedPreferences("Userdata", MODE_PRIVATE);
        mSharedPreferences.edit().clear().apply();
        Back(view);
    }
    public void Back (View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}

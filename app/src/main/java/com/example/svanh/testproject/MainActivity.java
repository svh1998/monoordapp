package com.example.svanh.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.svanh.testproject.profiel.EditPassword;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ChangePW(View view) {
        Intent intent = new Intent(this, EditPassword.class);
        startActivity(intent);
    }
}

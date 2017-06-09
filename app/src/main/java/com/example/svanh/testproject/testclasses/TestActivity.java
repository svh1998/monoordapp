package com.example.svanh.testproject.testclasses;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.svanh.testproject.R;
import com.example.svanh.testproject.webapi.Driver;

public class TestActivity extends MyAppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

    }

    @Override
    public void onBackPressed() {
        st = null;
        Toast.makeText(TestActivity.this,"Thanks for using application!!",Toast.LENGTH_SHORT).show();
//
        Intent i = new Intent(this, Driver.class);
        stopService(i);
        finish();
        return;
    }

}

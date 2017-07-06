package com.example.svanh.testproject.testclasses;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.hardware.camera2.TotalCaptureResult;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.svanh.testproject.R;
import com.example.svanh.testproject.webapi.ApiFunctions;
import com.example.svanh.testproject.webapi.Driver;
import com.google.android.gms.common.api.Api;

public class TestActivity extends CommonActivity implements CommonActivity.HandleBroadCastResult{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

    }

    @Override
    public void onBackPressed() {
        String oudww = "admin123";
        String nieuwww = "test123";
        String confirmww = "test123";
        ApiFunctions.login(this, "admin@admin.nl", "admin123");
    }

    @Override
    public void processJson() {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(broadcastResult);
        Log.d("test","HEllo World");
     }
}

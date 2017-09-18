package com.example.svanh.testproject.testclasses;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.svanh.testproject.webapi.Driver;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by svanh on 6/16/2017.
 */

public class CommonActivity extends AppCompatActivity{


    private BroadcastReceiver broadcastReceiver;
    protected String broadcastResult;
    protected String bc;
    private HandleBroadCastResult handleBroadCastResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleBroadCastResult = (HandleBroadCastResult)this;
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String responseString = intent.getStringExtra(Driver.RESPONSE_STRING);
                broadcastResult = intent.getStringExtra(Driver.RESPONSE_MESSAGE);
//                Toast.makeText(getApplicationContext(),"intern resultaat"  + bc, Toast.LENGTH_LONG).show();
                handleBroadCastResult.processJson();
            }
        };

    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter("BERICHT"));
    }

    public interface HandleBroadCastResult{
        public void processJson();
    }
}

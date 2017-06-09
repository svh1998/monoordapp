package com.example.svanh.testproject.testclasses;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.svanh.testproject.webapi.Driver;

/**
 * Created by svanh on 6/9/2017.
 */

public class MyAppCompatActivity extends AppCompatActivity implements ServiceConnection {

    protected Driver st;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent service = new Intent(getApplicationContext(), Driver.class);
        bindService(service, this, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder binder) {
        Driver.MyBinder b = (Driver.MyBinder) binder;
        st = b.getService();
        Toast.makeText(this, "SERVICE CONNECTED", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        st = null;
        Intent i = new Intent(this, Driver.class);
        stopService(i);

    }
}

package com.example.svanh.testproject.webapi;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class ApiDriver extends Service {
    private final IBinder mBinder = new MyBinder();
    public ApiDriver() {
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_NOT_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class MyBinder extends Binder {
        ApiDriver getService() {return ApiDriver.this;}
    }
}

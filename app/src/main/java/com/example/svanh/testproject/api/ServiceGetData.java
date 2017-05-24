package com.example.svanh.testproject.api;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ServiceGetData extends Service {
    public ServiceGetData() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

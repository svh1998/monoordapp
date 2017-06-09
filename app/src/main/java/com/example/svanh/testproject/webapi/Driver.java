package com.example.svanh.testproject.webapi;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Driver extends Service {
    public void setJson_url(String json_url) {
        this.json_url = json_url;
    }

    public String getJson_result() {
        return json_result;
    }

    private final IBinder mBinder = new MyBinder();
    private int counter = 1;
    private String json_url;
    private String json_result;
    ApiFunctions apis = new ApiFunctions();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {

        return mBinder;
    }

    public class MyBinder extends Binder {
        public Driver getService() {
            return Driver.this;
        }
    }


    public String getdata() {
        try {
            URL url = new URL(this.json_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine())!= null)
            {
                stringBuilder.append(line+"\n");
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            this.json_result = stringBuilder.toString().trim();

        } catch (MalformedURLException e) {
            e.printStackTrace();
            this.json_result = "Foute url";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.json_result;
    }
}

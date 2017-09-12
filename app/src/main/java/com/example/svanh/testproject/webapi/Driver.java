package com.example.svanh.testproject.webapi;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.support.v4.content.LocalBroadcastManager;
import android.text.format.DateFormat;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver extends IntentService {
    public static final String REQUEST_STRING = "myRequest";
    public static final String RESPONSE_STRING = "myResponse";
    public static final String RESPONSE_MESSAGE = "myResponseMessage";
    public String json_result = "jemoeder";
    private int counter = 1;
    public static String json_url;
    protected String weburl;

    public void setJson_url(String json_url) {
        this.json_url = json_url;
    }

    public Driver(){
        super("Driver");
    }

    public void setWebURL(String WebURL){
        this.weburl = WebURL;
    }

    public String getJson_result() {
        return json_result;
    }

    public String getJson_url() {
        return json_url;
    }

    @Override
    protected void onHandleIntent(Intent intent) {        String requestString = intent.getStringExtra(REQUEST_STRING);
        String responseString = requestString + " " + DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());
        String responseMessage = "";
        String url = intent.getStringExtra("url");
       getdata(url);
    }

    public String getdata(String weburl) {
        String responseString =  " " + DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());
        String responseMessage = "";
        try {
            URL url = new URL(weburl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            json_result = stringBuilder.toString().trim();
            Log.d("test driver", "Resultaat: " + json_result);
            responseMessage = json_result;


        } catch (MalformedURLException e) {
            e.printStackTrace();
            this.json_result = "Foute url";
        } catch (IOException e) {
            e.printStackTrace();
        }

        Intent broadcastIntent = new Intent("BERICHT");
        broadcastIntent.putExtra(RESPONSE_STRING, responseString);
        broadcastIntent.putExtra(RESPONSE_MESSAGE, responseMessage);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(broadcastIntent);
        return json_result;
    }

    public class MyBinder extends Binder {
        public Driver getService() {return Driver.this;}
    }
}
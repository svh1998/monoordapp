package com.example.svanh.testproject.api;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import com.example.svanh.testproject.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by svanh on 5/19/2017.
 */

public class BackgroundTask extends AsyncTask<Void, Void, String> {
    String json_url;
    String json_result = "";
    BackgroundTaskListener owner;
    public String getJson_url() {
        return json_url;
    }

    public void setJson_url(String json_url) {
        this.json_url = json_url;
    }

    public BackgroundTask(Object owner, String HttpURL){
        this.owner = (BackgroundTaskListener) owner;
        this.setJson_url(HttpURL);
    }

    public String getJson_result() {
        return json_result;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(Void... params) {

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
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(String result) {
        owner.onTaskComplete();
    }
}
package com.example.svanh.testproject.api;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.svanh.testproject.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;

public class ApiTest extends AppCompatActivity implements BackgroundTaskListener{
    private String json_result;
    private BackgroundTask backgroundtask;
    public String getJson_Result(){
        return json_result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apitest);
    }
    public void getJSON (View view) {
        backgroundtask = (BackgroundTask) new BackgroundTask(this, "http://api.hostdalem.nl/json_get_data.php?table=migrations").execute();
    }

    @Override
    public void onTaskComplete(){
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(backgroundtask.getJson_result());
    }

    public void parseJSON(View view){

        if(json_result != null){
            Intent intent = new Intent(this,DisplayListView.class);
            intent.putExtra("json_data", json_result);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "First Get the JSON with the Get JSON Button!" , Toast.LENGTH_LONG).show();
        }
    }

    public void setJsonString(String result) {
        json_result = result;
    }


}



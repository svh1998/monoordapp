package com.example.svanh.testproject.Reserveringen;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.svanh.testproject.MainActivity;
import com.example.svanh.testproject.testclasses.CommonActivity;
import com.example.svanh.testproject.webapi.ApiFunctions;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class LoadJSONTask extends CommonActivity implements CommonActivity.HandleBroadCastResult{
    String JSON = "";

    @Override
    public void processJson() {
        Intent main = new Intent(this, MainActivity.class);
        String Start_Datum = "";
        String Eind_Datum = "";
        String Room_ID = "";
        String test = "";

        JSON = broadcastResult;
        Log.d("json", JSON);
        try {

            Start_Datum = ApiFunctions.getArrayData(broadcastResult, "reservation_time_start");
            Eind_Datum = ApiFunctions.getArrayData(broadcastResult, "reservation_time_end");
            Room_ID = ApiFunctions.getArrayData(broadcastResult, "room_id");
            Log.d("start", Start_Datum);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Server niet bereikbaar.", Toast.LENGTH_LONG).show();
        }
    }

    public LoadJSONTask(Listener listener) {
        mListener = listener;
    }

    public interface Listener {

        void onLoaded(List<Reservation> androidList);

        void onError();
    }

    private Listener mListener;


    protected Response doInBackground(String... strings) {
        try {

            String stringResponse = JSON;
            Gson gson = new Gson();

            return gson.fromJson(stringResponse, Response.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void onPostExecute(Response response) {

        if (response != null) {

            mListener.onLoaded(response.getAndroid());

        } else {

            mListener.onError();
        }
    }


}

package com.example.svanh.testproject.Reserveringen;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.List;

public class LoadJSONTask extends AsyncTask<String, Void, Response> {


    public LoadJSONTask(Listener listener) {
        mListener = listener;
        Log.d("stage", "LoadJSONTask");
    }

    public interface Listener {
        void onLoaded(List<AndroidVersion> androidList);

        void onError();
    }

    private Listener mListener;

    @Override
    protected Response doInBackground(String... strings) {
        Log.d("stage", "Do in Background");
        try {

            String stringResponse = loadJSON(strings[0]);
            Log.d("stage", stringResponse);
            Gson gson = new Gson();
            return gson.fromJson(stringResponse, Response.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Response response) {
        Log.d("stage", "OnpostExecute");
        if (response != null) {

            mListener.onLoaded(response.getAndroid());

        } else {

            mListener.onError();
        }
    }

    private String loadJSON(String jsonURL) throws IOException {
        Log.d("stage", "LoadJSON From Website");
        return "{'server_response':[{'id':'2','room_id':'5','reservation_time_start':'2017-07-07 13:00:00','reservation_time_end':'2017-07-07 13:30:00'},{'id':'3','room_id':'7','reservation_time_start':'2017-09-09 14:00:00','reservation_time_end':'2017-09-09 14:50:00'}]}";
    }
}

package com.example.svanh.testproject.Reserveringen;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Response {

    private List<AndroidVersion> server_response = new ArrayList<AndroidVersion>();

    public List<AndroidVersion> getAndroid() {
        Log.d("stage", "getAndroid");
        return server_response;
    }
}

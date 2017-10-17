package com.example.svanh.testproject.Reserveringen;

import android.util.Log;

public class AndroidVersion {

    private String id;
    private String room_id;
    private String reservation_time_start;
    private String reservation_time_end;

    public String get_id() {
        Log.d("stage", "get id");
        return id;
    }

    public String getRoom_id() {
        Log.d("stage", "get room");
        return room_id;
    }

    public String getReservation_time_start() {
        Log.d("stage", "get start time");
        return reservation_time_start;
    }

    public String getReservation_time_end() {
        Log.d("stage", "get end time");
        return reservation_time_end;
    }
}
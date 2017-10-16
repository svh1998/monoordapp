package com.example.svanh.testproject.Reserveringen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.svanh.testproject.MainActivity;
import com.example.svanh.testproject.R;
import com.example.svanh.testproject.testclasses.CommonActivity;
import com.example.svanh.testproject.webapi.ApiFunctions;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

import static java.sql.Types.NULL;

public class Mijn_Reserveringen extends AppCompatActivity {




    private ListView mListView;

    private List<HashMap<String, String>> mAndroidMapList = new ArrayList<>();
    private String JSON = "";
    private String Result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mijn__reserveringen);
        ApiFunctions.getReservations(this, 4);


        mListView = (ListView) findViewById(R.id.list_view);

        try {

            String stringResponse = "";
            Gson gson = new Gson();
            Log.d("Status", "Start FromJson");
            //gson.fromJson(stringResponse, Result);
            Log.d("Status", "End FromJson");
        } catch (JsonSyntaxException e) {
            e.printStackTrace();

        }

        new LoadJSONTask((LoadJSONTask.Listener) this);

    }

    private static final String KEY_START = "Start Tijd";
    private static final String KEY_END = "Eind Tijd";
    private static final String KEY_Zaal = "Tijd";
    private static final String Key_Band = "Band";
    private static final String Key_Res_NR = "ResNR";

    public void onLoaded(List<Reservation> androidList) {

        for (Reservation Reservation : androidList) {
            HashMap<String, String> map = new HashMap<>();

            map.put(KEY_START, Reservation.getBegintijd());
            map.put(KEY_END, Reservation.getEindtijd());
            map.put(KEY_Zaal, Reservation.getZaal());
            map.put(Key_Band, Reservation.getBand());
            map.put(Key_Res_NR, Reservation.getReserveringsnummer());

            mAndroidMapList.add(map);
        }

        loadListView();
    }


    public void onError() {
        Toast.makeText(this, "Error !", Toast.LENGTH_SHORT).show();
    }


    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, mAndroidMapList.get(i).get(Key_Res_NR),Toast.LENGTH_LONG).show();
    }

    private void loadListView() {

        ListAdapter adapter = new SimpleAdapter(Mijn_Reserveringen.this, mAndroidMapList, R.layout.list_item,
                new String[] { KEY_START, KEY_END, KEY_Zaal, Key_Band, Key_Res_NR },
                new int[] { R.id.Date_Time_Start,R.id.Ruimte, R.id.Band, R.id.Date_Time_End });

        mListView.setAdapter(adapter);

    }

}


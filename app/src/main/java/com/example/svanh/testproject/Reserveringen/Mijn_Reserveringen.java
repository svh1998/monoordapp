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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

import static java.sql.Types.NULL;

public class Mijn_Reserveringen extends CommonActivity implements CommonActivity.HandleBroadCastResult{

    @Override
    public void processJson() {
        Intent main = new Intent(this, MainActivity.class);
        String Start_Datum = "";
        String Eind_Datum = "";
        String Room_ID = "";

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


    private ListView mListView;

    private List<HashMap<String, String>> mAndroidMapList = new ArrayList<>();
    private String JSON = "";

    private static final String KEY_DATUM = "Datum";
    private static final String KEY_Ruimte = "Ruimte";
    private static final String KEY_TIJD = "Tijd";
    private static final String Key_Band = "Band";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mijn__reserveringen);
        ApiFunctions.getReservations(this, 4);

        mListView = (ListView) findViewById(R.id.list_view);

        JSON = broadcastResult;

        Gson gson = new Gson();
        Type type = new TypeToken<List<ContactModel>>(){}.getType();
        List<ContactModel> contactList = gson.fromJson(jsonString, type);
        for (ContactModel contact : contactList){
            Log.i("Contact Details", contact.id + "-" + contact.name + "-" + contact.email);
        }
    }

    public void onLoaded(List<AndroidVersion> androidList) {

        for (AndroidVersion android : androidList) {
            HashMap<String, String> map = new HashMap<>();

            map.put(KEY_DATUM, android.get_Datum());
            map.put(KEY_Ruimte, android.get_Ruimte());
            map.put(KEY_TIJD, android.get_Tijd());
            map.put(Key_Band, android.get_Band());

            mAndroidMapList.add(map);
        }

        loadListView();
    }


    public void onError() {
        Toast.makeText(this, "Error !", Toast.LENGTH_SHORT).show();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, mAndroidMapList.get(i).get(KEY_DATUM),Toast.LENGTH_LONG).show();
    }

    private void loadListView() {
        ListAdapter adapter = new SimpleAdapter(Mijn_Reserveringen.this, mAndroidMapList, R.layout.list_item,
                new String[] { KEY_DATUM, KEY_Ruimte, Key_Band, KEY_TIJD },
                new int[] { R.id.Datum,R.id.Ruimte, R.id.Band, R.id.Tijd });
        mListView.setAdapter(adapter);

    }
}

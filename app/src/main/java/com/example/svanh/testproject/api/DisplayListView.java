package com.example.svanh.testproject.api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.svanh.testproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContactAdapter contactAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);
        contactAdapter = new ContactAdapter(this,R.layout.row_layout);
        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(contactAdapter);
        json_string = getIntent().getExtras().getString("json_data");
        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("server_response");
            int count = 0;
            String naam,id;
            while (count < jsonArray.length()) {
                JSONObject JO = jsonArray.getJSONObject(count);
                naam = JO.getString("name");
                id =  JO.getString("id");
                Contacts contacts = new Contacts(naam,id);
                contactAdapter.add(contacts);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

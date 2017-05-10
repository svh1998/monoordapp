package com.example.svanh.testproject.api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.svanh.testproject.R;

public class DisplayListView extends AppCompatActivity {
    String json_string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);
        json_string = getIntent().getExtras().getString("json_data");
    }
}

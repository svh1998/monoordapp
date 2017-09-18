package com.example.svanh.testproject.profiel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.svanh.testproject.MainActivity;
import com.example.svanh.testproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class changemessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changemessage);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(EditPassword.eindmessage);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView17);

        if (message.equals("True")) {
            textView.setText("Your password is succesfully Changed!");
            Intent intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);
        }


    }
}

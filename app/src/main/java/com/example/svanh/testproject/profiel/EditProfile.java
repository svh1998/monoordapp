package com.example.svanh.testproject.profiel;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.svanh.testproject.R;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profiel);
    }
    public void onlick(View view) {
        Context context = getApplicationContext();

        final EditText input = (EditText)findViewById(R.id.editText6);
        final EditText input2 = (EditText)findViewById(R.id.editText3);
        final EditText input3 = (EditText)findViewById(R.id.editText8);
        final EditText input4 = (EditText)findViewById(R.id.editText7);


        String text = input.getText().toString() + ", " +  input2.getText().toString() + ", " + input3.getText().toString() + ", " +  input4.getText().toString();
        int duration = Toast.LENGTH_SHORT;

        final Toast toast = Toast.makeText(context, text, duration);
        final Button button = (Button)findViewById(R.id.button2);
        String url = "";
        String output;
        toast.show();
    }
}

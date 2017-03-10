package com.example.svanh.testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public int jemoeder = 1;
    public int david = 0;
    public int david2 = 2;
    public int sanderthegamer14 = 7711;

    private EditText favcolor;
    private TextView textout;


    public void buttonOnClick(View v){
        Button button=(Button) v;
        favcolor = (EditText) findViewById(R.id.txtColor);
        textout = (TextView) findViewById(R.id.txtOutput);
        textout.setText(favcolor.getText());
    }
}

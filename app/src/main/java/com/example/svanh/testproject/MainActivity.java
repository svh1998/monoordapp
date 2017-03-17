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

        Button b = (Button) findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText favcolor = (EditText) findViewById(R.id.txtColor);
                TextView textout = (TextView) findViewById(R.id.txtOutput);
                textout.setText(favcolor.getText());
            }
        });
    }

    public int david = 0;
    public int david2 = 2;
    public int sanderthegamer14 = 771221;
    public int sanderalleskwijt = 0;

}

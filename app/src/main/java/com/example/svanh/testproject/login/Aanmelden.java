package com.example.svanh.testproject.login;

/**
 * Created by tedvanes on 10-03-17.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.svanh.testproject.R;


public class Aanmelden extends AppCompatActivity{
    @Override
    public void onCreate(Bundle  savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ted);

        Button  Aanmelden = (Button)findViewById(R.id.Aanmelden);
        Aanmelden.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "Bezig met Aanmelden", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Bezig met Aanmelden", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void Check(char User, char Pass) {

    }
}
package com.example.svanh.testproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.svanh.testproject.Login_Logout.Login;
import com.example.svanh.testproject.Login_Logout.Logout;
import com.example.svanh.testproject.profiel.EditPassword;
import com.example.svanh.testproject.profiel.EditProfile;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int ingelogd = getData();
        if (ingelogd == (1)){
            Toast.makeText(getApplicationContext(),"User ingelogd: JA", Toast.LENGTH_LONG).show();
            final Button button = (Button) findViewById(R.id.button3);
            button.setText("Uitloggen");
            Spinner spinner = (Spinner) findViewById(R.id.bandlist);
            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.planets_array, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            spinner.setAdapter(adapter);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Uitloggen(v);
                }
            });

        } else {
            Spinner spinner = (Spinner) findViewById(R.id.bandlist);
            spinner.setVisibility(View.GONE);
        }
    }

    public void ChangePW(View view) {
        Intent intent = new Intent(this, EditPassword.class);
        startActivity(intent);
    }
    private int getData() {
        SharedPreferences mSharedPreferences = getSharedPreferences("Userdata", MODE_PRIVATE);
        int loggedin = mSharedPreferences.getInt("loggedin", 0);
        return loggedin;
    }

    public void ChangeProfile(View view) {
        Intent intent = new Intent(this, EditProfile.class);
        startActivity(intent);
    }

    public void inloggen (View view) {
        Intent intent = new Intent (this, Login.class);
        startActivity(intent);
    }

    public void Uitloggen (View v) {
        Intent intent = new Intent (this, Logout.class);
        startActivity(intent);
    }

}

package com.example.svanh.testproject.profiel;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.svanh.testproject.MainActivity;
import com.example.svanh.testproject.R;
import com.example.svanh.testproject.testclasses.CommonActivity;
import com.example.svanh.testproject.webapi.ApiFunctions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EditPassword extends CommonActivity implements CommonActivity.HandleBroadCastResult {
    protected static final String eindmessage = ".";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);

    }


    public void changePassword(View view){

        Context context = getApplicationContext();
        final EditText currentpw = (EditText)findViewById(R.id.currentpw);
        final EditText newpw = (EditText)findViewById(R.id.newpw);
        final EditText confirmpw = (EditText)findViewById(R.id.confirmpw);
        String huidigpw = currentpw.getText().toString();
        String nieuwpw = newpw.getText().toString();
        String nieuwpw2 = confirmpw.getText().toString();
        if(nieuwpw.equals(nieuwpw2)){
            ApiFunctions.ChangePassword(this, 1, huidigpw, nieuwpw, nieuwpw2);
        } else {
            int duration = Toast.LENGTH_SHORT;
            final Toast toast = Toast.makeText(context, "De wachtwoorden komen niet overeen. Controleer het wachtwoord.", duration);
            final Button button = (Button) findViewById(R.id.button2);
        }

    }

    @Override
    public void processJson() {
        Toast.makeText(getApplicationContext(),broadcastResult, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        JSONObject jObject = null;
        JSONArray jArray = null;
        try {
            jObject = new JSONObject(broadcastResult);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            jArray = jObject.getJSONArray("server_response");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i=0; i < jArray.length(); i++)
        {
            try {
                JSONObject oneObject = jArray.getJSONObject(i);
                // Pulling items from the array
                bc = oneObject.getString("Changed");
            } catch (JSONException e) {
                // Oops
            }
        }
        if (bc.equals("True")) {
            Toast.makeText(getApplicationContext(),"Het wachtwoord is succesvol veranderd!", Toast.LENGTH_LONG).show();
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"Het huidige wachtwoord is onjuist. Probeer het opnieuw!", Toast.LENGTH_LONG).show();
        }




    }

}

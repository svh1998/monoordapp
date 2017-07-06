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

import com.example.svanh.testproject.R;
import com.example.svanh.testproject.testclasses.CommonActivity;
import com.example.svanh.testproject.webapi.ApiFunctions;

public class EditPassword extends CommonActivity implements CommonActivity.HandleBroadCastResult {
    protected static final String eindmessage = "";
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
            Log.d("gelijk", "ja");
            int duration = Toast.LENGTH_SHORT;
            final Toast toast = Toast.makeText(context, "TRUE", duration);
            final Button button = (Button)findViewById(R.id.button2);
            String url = "";
            String output;
            toast.show();
            Log.d("nieuw ww: ", nieuwpw);
            ApiFunctions.ChangePassword(this, 1, huidigpw, nieuwpw, nieuwpw2);
        } else {
            Log.d("gelijk", "nee");
            int duration = Toast.LENGTH_SHORT;
            final Toast toast = Toast.makeText(context, "De wachtwoorden komen niet overeen. Controleer het wachtwoord.", duration);
            final Button button = (Button)findViewById(R.id.button2);
            String url = "";
            String output;
            toast.show();
        }


    }

    @Override
    public void processJson() {
        Intent intent = new Intent(this, changemessage.class);
        String checkmessage = "Wachtwoord gewijzigd! Nieuw wachtwoord";
        if(broadcastResult.equals(checkmessage)){
            intent.putExtra(eindmessage, checkmessage);
            startActivity(intent);
        } else {
            intent.putExtra(eindmessage, broadcastResult);
            startActivity(intent);
        }


    }

}

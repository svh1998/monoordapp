package com.example.svanh.testproject.profiel;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.svanh.testproject.R;

public class EditPassword extends AppCompatActivity {

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
        String nieuwpw = newpw.getText().toString();
        String nieuwpw2 = confirmpw.getText().toString();
        Log.d("ww", nieuwpw + " " + nieuwpw2);
        if(nieuwpw == nieuwpw2){
            Log.d("gelijk", "ja");
            int duration = Toast.LENGTH_SHORT;
            final Toast toast = Toast.makeText(context, "TRUE", duration);
            final Button button = (Button)findViewById(R.id.button2);
            String url = "";
            String output;
            toast.show();
        } else {

        String text = currentpw.getText().toString() + ", " +  newpw.getText().toString() + ", " + confirmpw.getText().toString();

        int duration = Toast.LENGTH_SHORT;

        final Toast toast = Toast.makeText(context, text, duration);
        final Button button = (Button)findViewById(R.id.button2);
        String url = "";
        String output;
        toast.show(); }


    }
}

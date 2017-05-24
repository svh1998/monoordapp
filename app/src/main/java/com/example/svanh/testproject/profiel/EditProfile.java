package com.example.svanh.testproject.profiel;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.svanh.testproject.MainActivity;
import com.example.svanh.testproject.R;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profiel);
    }
    public void onlick(View view) {
        /*EditText wachtwoord = (EditText) findViewById(R.id.editText5);
        wachtwoord.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            public boolean onEditorAction(TextView textview, int i, KeyEvent keyEvent){
                boolean handled = false;
                if(i == EditorInfo.IME_ACTION_NEXT){
                    TextView textView =
                    String inputText = textView.getText().tosString();
                    Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
                }
            }*/

        Context context = getApplicationContext();
        Context elsebericht = getApplicationContext();
        final EditText input = (EditText)findViewById(R.id.editText6);
        final EditText input2 = (EditText)findViewById(R.id.editText3);
        final EditText input3 = (EditText)findViewById(R.id.editText8);
        final EditText input4 = (EditText)findViewById(R.id.editText7);

        String text = input.getText().toString() + ", " +  input2.getText().toString() + ", " + input3.getText().toString() + ", " +  input4.getText().toString();
        int duration = Toast.LENGTH_SHORT;

        final Toast toast = Toast.makeText(context, text, duration);
        final Button button = (Button)findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
//          if(isEmail = 1, isTelefoon = 1){
//                    toast.show();
//                }
//                else{
//                    String tekst = "niet alle velden zijn correct ingevuld";
//                    int bericht = Toast.LENGTH_SHORT;
//
//                    final Toast message = Toast.makeText(elsebericht,tekst,bericht);
//                    message.show();
//                }


            }
        });
    }
}

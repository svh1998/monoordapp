package com.example.svanh.testproject.Login_Logout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

import com.example.svanh.testproject.R;

public class Login extends AppCompatActivity {
    Button   mButton;
    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        mButton = (Button)findViewById(R.id.Aanmelden);
        mEdit   = (EditText)findViewById(R.id.Username);

        mButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        
                    }
                });
    }
}

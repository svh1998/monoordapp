package com.example.svanh.testproject.Login_Logout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.svanh.testproject.MainActivity;
import com.example.svanh.testproject.R;
import com.example.svanh.testproject.testclasses.CommonActivity;
import com.example.svanh.testproject.webapi.ApiFunctions;

public class Registreren extends CommonActivity implements CommonActivity.HandleBroadCastResult {
    private EditText voornaam, tussenvoegsel, achternaam, straat, huisnummer, toevoeging, postcode, postcode2,  woonplaats, telefoon2, telefoon, email, wachtwoord, bevestigwachtwoord;
    private String v_voornaam, v_tussenvoegsel, v_achternaam, v_straat, v_huisnummer, v_toevoeging, v_postcode, v_postcode2, v_woonplaats, v_telefoon, v_telefoon2,  v_email, v_wachtwoord, v_bevestigwachtwoord;
    private Button knop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registreren);
        voornaam = (EditText) findViewById(R.id.fld_name);
        tussenvoegsel = (EditText) findViewById(R.id.fld_tussenvoegsel);
        achternaam = (EditText) findViewById(R.id.fld_achternaam);
        straat = (EditText) findViewById(R.id.fld_street);
        huisnummer = (EditText) findViewById(R.id.fld_nr);
        toevoeging = (EditText) findViewById(R.id.fld_nrext);
        postcode = (EditText) findViewById(R.id.fld_zipcodenr);
        postcode2 = (EditText) findViewById(R.id.fld_zipcode);
        woonplaats = (EditText) findViewById(R.id.fld_city);
        telefoon = (EditText) findViewById(R.id.fld_netnumber);
        telefoon2 = (EditText) findViewById(R.id.fld_number);
        email = (EditText) findViewById(R.id.fld_email);
        wachtwoord = (EditText) findViewById(R.id.fld_passwd);
        bevestigwachtwoord = (EditText) findViewById(R.id.fld_passwdconf);
        knop = (Button) findViewById(R.id.submit);
        knop.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                register();
            }




        });



    }
    public void register(){
        initialize();
        if(!validate()){
            Toast.makeText(this, "registratie mislukt",Toast.LENGTH_SHORT).show();
            finalregister();
        }
        else{
            onSignupSuccess();
        }

    }
    public void onSignupSuccess(){
        Toast.makeText(this, "gvgvggvgvg", Toast.LENGTH_SHORT).show();

    }
    public boolean validate(){
        boolean valid = true;
        if(v_voornaam.isEmpty()||v_voornaam.length()>32 ){
            voornaam.setError("valideer je naam");
            valid = false;
        }
        if(v_email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(v_email).matches()){
            email.setError("valideer email");
            valid = false;
        }
        if(v_wachtwoord.isEmpty()){
            wachtwoord.setError("valideer wachtwoord");
            valid = false;
        }
        if(v_bevestigwachtwoord.isEmpty()){
            bevestigwachtwoord.setError("vul het goede wachtwoord in");
            valid = false;
        }
        if(v_telefoon.isEmpty()){
            telefoon.setError("valideer telefoonnummer");
            valid = false;
        }
        return valid;
    }
    public void initialize(){
        v_voornaam = voornaam.getText().toString().trim();
        v_tussenvoegsel = tussenvoegsel.getText(). toString() . trim();
        v_achternaam = achternaam.getText(). toString() . trim();
        v_straat = straat.getText(). toString(). trim();
        v_huisnummer = huisnummer.getText(). toString(). trim();
        v_toevoeging = toevoeging.getText(). toString(). trim();
        v_postcode = postcode.getText().toString().trim();
        v_postcode2 = postcode2.getText().toString().trim();
        v_woonplaats = woonplaats.getText().toString().trim();
        v_telefoon = telefoon.getText().toString().trim();
        v_telefoon2 = telefoon2.getText().toString().trim();
        v_email = email.getText().toString().trim();
        v_wachtwoord = wachtwoord.getText().toString().trim();
        v_bevestigwachtwoord = bevestigwachtwoord.getText().toString().trim();









    }

    public void finalregister() {
        String email = v_email;
        String password = v_wachtwoord;
        String firstname = v_voornaam;
        String lastname = v_tussenvoegsel + v_achternaam;
        String streetname = v_straat;
        Integer housenumber = Integer.parseInt(v_huisnummer);
        String housenrext = v_toevoeging;
        String zipcode = v_postcode + v_postcode2;
        String city = v_woonplaats;
        Integer netmumber = Integer.parseInt(v_telefoon);
        Integer phonenumber = Integer.parseInt(v_telefoon2);
        ApiFunctions.Register(this, email, password, firstname, lastname, streetname, housenumber, housenrext, zipcode, city, netmumber, phonenumber);

    }

    @Override
    public void processJson() {
        String valid = "";

        try {
            valid = ApiFunctions.getArrayData(broadcastResult, "valid");
            if (valid.equals("true")) {
                Intent intent = new Intent(this, MainActivity.class);
                Toast.makeText(getApplicationContext(), "Succesvol geregistreerd!", Toast.LENGTH_LONG).show();
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Registreren mislukt.", Toast.LENGTH_LONG).show();
            }



        }catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Server niet bereikbaar.", Toast.LENGTH_LONG).show();
        }
    }
}

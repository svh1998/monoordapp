package com.example.svanh.testproject.webapi;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;

/**
 * Created by svanh on 6/8/2017.
 */

public class ApiFunctions {

    public ApiFunctions() {
    }

    public boolean checklogin(String email, String wachtwoord){
        Driver driver = new Driver();
        driver.setJson_url("http://api.hostdalem.nl/validate.php?email="+email+ "&password="+wachtwoord);
        driver.getdata();
        driver.getJson_result();

        return true;
    }



}

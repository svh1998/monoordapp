package com.example.svanh.testproject.webapi;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;


public class ApiFunctions {


    static String weburl = "https://sandhoofd.nl/api/";


    // user functions


    public static void login(Context context, String email, String wachtwoord){
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl + "validate.php?email="+email+"&password="+wachtwoord);
        context.startService(intent);
    }

    public static void getUserData(Context context, String email) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl + "getuserdata.php?email="+email);
        context.startService(intent);
    }

    public static void Register(Context context,
                                String email, String password, String firstname, String lastname, String streetname, int housenumber,
                                String housenrext, String zipcode, String City, int netnumber, int phonenumber) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl+"register.php?email="+email+"&password="+password+"&firstname="+firstname+"&lastname="+lastname+
                "&streetname="+streetname+"&housenumber="+housenumber+"&nrext="+housenrext+"&zipcode="+zipcode+"&city="+City+
                "&phone="+netnumber+"-"+phonenumber);
        context.startService(intent);
    }

    public static void ChangePassword(Context context, int userid, String currentpw, String newpw, String confirmpw) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl+"changepassword.php?user="+userid+"&currentpw="+currentpw+"&newpw="+newpw+"&confirmpw="+confirmpw);
        context.startService(intent);
    }

    public static void checkEmail(Context context, String email){
        Intent intent = new Intent(context, Driver.class);
        Log.d("emailadres: " , email);
        intent.putExtra("url", weburl + "checkemail.php?email="+email);
        context.startService(intent);
    }

    public static void askRecovery(Context context, String email) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl + "recover.php?email="+email);
        context.startService(intent);
    }

    public static void checkToken(Context context, String email, String token) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl + "checktoken.php?token="+token + "&email="+email);
        context.startService(intent);
    }

    public static void resetPassword(Context context, String password, String passwordconfirm) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl + "resetpassword.php?password="+password+"&confirmpw="+passwordconfirm);
        context.startService(intent);
    }


    // band functions


    public static void getBands(Context context, int userid) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl+"getbands.php?user="+userid);
        context.startService(intent);
    }

    public static void Addband(Context c, String bandname, String notes) {
        Intent intent = new Intent(c, Driver.class);
        intent.putExtra("url", weburl+"addband.php?bandname="+bandname+"&notes="+notes);
    }


    // reservation functions



    public static void getPaymentMethods(Context context) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl+"getallpaymentmethods.php");
        context.startService(intent);
    }
    public static void getReservations(Context context, int band) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl+"getreservation.php?band_id=4");
        context.startService(intent);
    }

    public static void AddReservation(Context context, int bandid, String paymentmethod, int roomid, String datum, String begintijd, String eindtijd) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl + "addreservation.php?bandid="+bandid + "&paymentmethod="+paymentmethod);
        context.startService(intent);
    }

    public static void getRooms(Context context) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl+"getrooms.php");
        context.startService(intent);
    }

    public static void CheckAvailability(Context c, int roomid) {
        Intent intent = new Intent(c, Driver.class);
        intent.putExtra("url", weburl+"checkroomavailability.php?id="+roomid);
        c.startService(intent);
    }



// parse array


    public static String getArrayData(String broadcastResult, String veld){
        JSONObject jObject = null;
        JSONArray jArray = null;
        String arraydata= "";
        try {
            jObject = new JSONObject(broadcastResult);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            jArray = jObject.getJSONArray("server_response");
        } catch (JSONException e) {
            e.printStackTrace();
            arraydata = "E01";
        }catch (NumberFormatException nfe){
            arraydata = "E01";
        } catch (Exception e){
            arraydata = "E01";
        }

        for (int i=0; i < jArray.length(); i++)
        {
            try {
                JSONObject oneObject = jArray.getJSONObject(i);
                // Pulling items from the array
                arraydata = oneObject.getString(veld);
            } catch (JSONException e) {
                // Oops
            }
        }
        return arraydata;
    }

}


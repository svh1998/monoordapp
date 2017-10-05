package com.example.svanh.testproject.webapi;

        import android.app.ActivityManager;
        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.content.IntentFilter;
        import android.os.Build;
        import android.os.SystemClock;
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

/**
 * Created by svanh on 6/8/2017.
 */

public class ApiFunctions {
    static String weburl = "https://sandhoofd.nl/api/";

    public static void login(Context context, String email, String wachtwoord){
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl + "validate.php?email="+email+"&password="+wachtwoord);
        context.startService(intent);

    }

    public static void ChangePassword(Context context, int userid, String currentpw, String newpw, String confirmpw) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl+"changepassword.php?user="+userid+"&currentpw="+currentpw+"&newpw="+newpw+"&confirmpw="+confirmpw);
        context.startService(intent);
    }

    public static void getBands(Context context, int userid) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl+"getbands.php?user="+userid);
        context.startService(intent);
    }

    public static void createReservation(Context context){
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl + "addreservation.php");
        context.startService(intent);
    }

    public static void askRecovery(Context context) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl + "recover.php");
        context.startService(intent);
    }

    public static void checkToken(Context context, String token) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl + "checktoken.php?token="+token);
        context.startService(intent);
    }

    public static void recoverPassword(Context context, String password, String passwordconfirm) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl + "resetpassword.php?password="+password+"&confirmpw="+passwordconfirm);
        context.startService(intent);
    }

    public static void checkEmail(Context context, String email){
        Intent intent = new Intent(context, Driver.class);
        Log.d("emailadres: " , email);
        intent.putExtra("url", weburl + "checkemail.php?email="+email);
        context.startService(intent);
    }

    public static void getRooms(Context context) {
        
    }

    public static void getReservations(Context context, int band) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl+"getReservation.php?band_id=4");
        context.startService(intent);
    }


    public ArrayList<String> setData(String broadcastResult) {
        ArrayList<String> arrayList = new ArrayList<String>();
        JSONObject jObject = null;
        JSONArray jsonArray= null;
        try {
            jObject = new JSONObject(broadcastResult);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            jsonArray = new JSONArray(jObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        List<String> list = new ArrayList<String>();
//        for(int i=0; i <jsonArray.length(); i++) {
//            product.setId(??);
//            product.setName(??);
//            list.add(??);
//        }
        Log.d("Array: ", ""+arrayList);
        return arrayList;
    }

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


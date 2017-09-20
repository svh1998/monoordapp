package com.example.svanh.testproject.webapi;

        import android.app.ActivityManager;
        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.content.IntentFilter;
        import android.os.SystemClock;
        import android.support.v4.content.LocalBroadcastManager;
        import android.util.Log;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.lang.reflect.Array;
        import java.net.MalformedURLException;

/**
 * Created by svanh on 6/8/2017.
 */

public class ApiFunctions {
    static String weburl = "http://api.hostdalem.nl/";

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


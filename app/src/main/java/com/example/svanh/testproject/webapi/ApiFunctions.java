package com.example.svanh.testproject.webapi;

        import android.app.ActivityManager;
        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.content.IntentFilter;
        import android.os.SystemClock;
        import android.support.v4.content.LocalBroadcastManager;
        import android.util.Log;

/**
 * Created by svanh on 6/8/2017.
 */

public class ApiFunctions {
    static String weburl = "http://api.hostdalem.nl/";

    public static String login(Context context, String email, String wachtwoord){
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl + "validate.php?email="+email+"&password="+wachtwoord);
        context.startService(intent);
        return "hello";
    }

    public static void ChangePassword(Context context, int userid, String currentpw, String newpw, String confirmpw) {
        Intent intent = new Intent(context, Driver.class);
        intent.putExtra("url", weburl+"changepassword.php?user="+userid+"&currentpw="+currentpw+"&newpw="+newpw+"&confirmpw="+confirmpw);
        context.startService(intent);
    }

}


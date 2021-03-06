package com.fyber.offerstutorial.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by muhammadkorany on 10/9/16.
 */

public class ActionUtils {

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static boolean isInternetConnected(Context context) {
        ConnectivityManager connectivityMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connectivityMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        // Check if wifi or mobile network is available or not. If any of them is
        // available or connected then it will return true, otherwise false;
        if (wifi != null) {
            if (wifi.isConnected()) {
                return true;
            }
        }

        if (mobile != null) {
            if (mobile.isConnected()) {
                return true;
            }
        }
        return false;
    }
}

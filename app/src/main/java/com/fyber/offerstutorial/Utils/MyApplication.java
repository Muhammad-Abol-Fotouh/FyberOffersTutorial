package com.fyber.offerstutorial.Utils;

import android.app.Application;

/**
 * Created by muhammadkorany on 10/4/16.
 */

public class MyApplication extends Application {

    private static String API_KEY = "1c915e3b5d42d05136185030892fbb846c278927";
    private static String APP_ID = "2070";
    private static String UID = "spiderman";
    private static String LOCALE = "en";
    private static String IP = "196.147.154.83";
    private static String GOOGLE_AD_ID = "b8871030-8fac-439f-82e5-1ad2090d68fa";
//    private static String PS_TIME = "1312211903";

//    public static String getPsTime() {
//        return PS_TIME;
//    }




    public static String getGoogleAdId() {
        return GOOGLE_AD_ID;
    }

    public static String getApiKey() {
        return API_KEY;
    }

    public static String getAppId() {
        return APP_ID;
    }

    public static String getUID() {
        return UID;
    }

    public static String getLOCALE() {
        return LOCALE;
    }

    public static String getIP() {
        return IP;
    }
}

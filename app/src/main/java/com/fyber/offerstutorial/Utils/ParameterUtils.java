package com.fyber.offerstutorial.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by muhammadkorany on 10/4/16.
 */

public class ParameterUtils {

    public static long unixTimestamp(){
        return System.currentTimeMillis() / 1000L;
    }

    public static String sha1Hash(String params) throws NoSuchAlgorithmException {

        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(params.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

}

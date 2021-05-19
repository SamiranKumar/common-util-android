package com.skh.hkhr.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import timber.log.Timber;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 1/02/2017.
 */
public class AppInfo {

    public static final String getVersionName(Context context) {
        String versionName = "";
        try {
            versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Timber.e("versionName Not Found");
        }
        return versionName;
    }


    //==============================================================================================
    public static void generateHashKey(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Timber.e("printHashKey() Hash Key: " + hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Timber.e("printHashKey():" + e);
        } catch (Exception e) {
            Timber.e("printHashKey():" + e);
        }


        /** Release Apk hash key

         Go jdk bin dir then open cmd
         keytool -exportcert -alias key -keystore G:\keystore.jks | openssl sha1 -binary | openssl base64
         keytool -exportcert -alias key -keystore G:\keystore.jks | C:\Users\Samiran\Desktop\openssl-0.9.8d_X64\bin\openssl sha1 -binary | C:\Users\Samiran\Desktop\openssl-0.9.8d_X64\bin\openssl base64
         keytool -exportcert -alias key -keystore G:\keystore.jks sha1 -binary  base64

         keytool -exportcert -alias key0 -keystore G:\keystore.jks sha1 -binary base64

         Go jdk bin dir then open cmd
         C:\Program Files\Java\jdk-9.0.1\bin>keytool -exportcert -alias androiddebugkey -keystore "C:\Users\Samiran\.android\debug.keystore" | "C:\Users\Samiran\Desktop\openssl-0.9.8d_X64\bin\openssl" sha1 -binary | "C:\Users\Samiran\Desktop\openssl-0.9.8d_X64\bin\openssl" base64


         //Download openssl
         N.B: https://code.google.com/archive/p/openssl-for-windows/downloads
         **/

    }


}

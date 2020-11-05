package com.skh.hkhr.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import timber.log.Timber;

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
         keytool -exportcert -alias cinematickey -keystore G:\keystore.jks | openssl sha1 -binary | openssl base64
         keytool -exportcert -alias cinematickey -keystore G:\keystore.jks sha1 -binary  base64
         **/
    }


}

package com.skh.hkhr.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import timber.log.Timber;

public interface DateTimeUtil {

    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy, HH:mm:ss a"); ////10/23/2019, 11:21:56 AM
    SimpleDateFormat referenceCodeFormat = new SimpleDateFormat("yyyyMMddHHmmssS"); // 201908270426222


    static long getTime(String time) {
        Date date = new Date();
        try {
            date = formatter.parse(time);
            Timber.d("Date is: " + date);
        } catch (ParseException e) {
            Timber.e("Error:" + e.toString());
        }
        return date.getTime();
    }


    static String getReferenceCode() {
        Date date = new Date();
        String referenceCode;

        referenceCode = referenceCodeFormat.format(date);

        return referenceCode;
    }

}


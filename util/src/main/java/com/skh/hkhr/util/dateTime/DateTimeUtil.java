package com.skh.hkhr.util.dateTime;

import com.skh.hkhr.util.NullRemoveUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import timber.log.Timber;

public class DateTimeUtil {

    static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy, HH:mm:ss a"); ////10/23/2019, 11:21:56 AM
    static SimpleDateFormat referenceCodeFormat = new SimpleDateFormat("yyyyMMddHHmmssS"); // 201908270426222
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm a"); // 27 Jun 2020, 08:22 PM


    public static String getTime1(String time) {
        Date date = new Date();
        try {
            date = formatter.parse(time);
            String time1 = dateFormat.format(date);
            Timber.d("Date is: " + time1);
            return NullRemoveUtil.getNotNull(time1);

        } catch (ParseException e) {
            Timber.e("Error:" + e.toString());
        }
        return time;
    }


    public static long getTime(String time) {
        Date date = new Date();
        try {
            date = formatter.parse(time);
            Timber.d("Date is: " + date);
        } catch (ParseException e) {
            Timber.e("Error:" + e.toString());
        }
        return date.getTime();
    }


    public static String getReferenceCode() {
        Date date = new Date();
        String referenceCode;

        referenceCode = referenceCodeFormat.format(date);

        return referenceCode;
    }

}


package com.skh.hkhr.util.dateTime;

import com.skh.hkhr.util.NullRemoveUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import timber.log.Timber;

public class DateTimeUtil {


    public static String TIME_FORMAT_1 = "yyyy-MM-dd HH:mm:ss";
    public static String TIME_FORMAT_2 = "yyyy-MM-dd hh:mm:ss";
    public static String TIME_FORMAT_3 = "yyyy/MM/dd";
    public static String TIME_FORMAT_4 = "yyyy.MM.dd";
    public static String TIME_FORMAT_5 = "MM.dd";
    public static String TIME_FORMAT_7 = "hh:mm";

    static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy, HH:mm:ss a"); ////10/23/2019, 11:21:56 AM
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm a"); // 27 Jun 2020, 08:22 PM

    static SimpleDateFormat referenceCodeFormat = new SimpleDateFormat("yyyyMMddHHmmssS"); // 201908270426222


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




    //==============================================================================================
    static String differentTime(long startMilliseconds, long endMilliseconds) {

        long milliseconds = endMilliseconds - startMilliseconds;

        int seconds = (int) (milliseconds / 1000) % 60;
        int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
        int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);

        String hoursText = getFormatNumber(hours, true);
        String minutesText = getFormatNumber(minutes, false);
        String secondsText = getFormatNumber(seconds, false);

        hoursText = hoursText.isEmpty() ? "" : hoursText + ":";

        return hoursText + minutesText + ":" + secondsText;
    }


    static String getFormatNumber(int number, boolean zeroCheck) {
        if (number == 0 && zeroCheck) {
            return "";
        }
        return number > 9 ? "" + number : "0" + number;
    }

}


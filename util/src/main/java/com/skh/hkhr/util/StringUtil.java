package com.skh.hkhr.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import timber.log.Timber;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 15/07/2019.
 */
public interface StringUtil {


    //==============================================================================================
    static String getCapitalizeSentences(String beforeSentences) {
        String text = beforeSentences == null ? "" : beforeSentences;
        int pos = 0;
        boolean capitalize = true;
        StringBuilder sb = new StringBuilder(text);
        while (pos < sb.length()) {
            if (sb.charAt(pos) == '.') {
                capitalize = true;
            } else if (capitalize && !Character.isWhitespace(sb.charAt(pos))) {
                sb.setCharAt(pos, Character.toUpperCase(sb.charAt(pos)));
                capitalize = false;
            }
            pos++;
        }
        String sentences = sb.toString();

        return sentences;
    }

    //==============================================================================================
    static String getFirstWord(String beforeSentences) {
        String text = beforeSentences == null ? "" : beforeSentences;
        return text.split(" ")[0];
    }

    //==============================================================================================
    static String getCamelCase(String beforeText) {
        String text = beforeText == null ? "" : beforeText;

        if (text.isEmpty()) {
            return text;
        }

        StringBuilder builder = new StringBuilder(text);

        boolean isLastSpace = true;

        // Iterate String from beginning to end.
        for (int i = 0; i < builder.length(); i++) {
            char ch = builder.charAt(i);

            if (isLastSpace && ch >= 'a' && ch <= 'z') {
                // Character need to be converted to uppercase
                builder.setCharAt(i, (char) (ch + ('A' - 'a')));
                isLastSpace = false;
            } else if (ch != ' ')
                isLastSpace = false;
            else
                isLastSpace = true;
        }

        return builder.toString();
    }

    //==============================================================================================
    static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }

    //==============================================================================================
    static List<String> getListFromString(String data, String split) {
        data = data + "".trim();
        // data = data.replace("\\\"", "\"");
        return Arrays.asList(data.split(split));
    }

    //==============================================================================================
    static boolean isValidURL(String urlStr) {
        try {
            URL url = new URL(urlStr);
            return true;
        } catch (MalformedURLException e) {
            Timber.e("Error:" + e.toString());
            return false;
        }
    }

    //==============================================================================================
    static String replaceChar(String str) {
        String newString = str.replaceAll(" ", "");
        //Timber.e("Old String;; "+str);
        //Timber.e("Replace String:: "+newString);
        return newString;
    }

    //==============================================================================================
    static String replaceAllChar(String str, String replace) {
        return str.replaceAll(" ", replace);
    }


    //==============================================================================================
    static String getNotNullString(String data) {
        return data == null ? "" : data;
    }


    //==============================================================================================
    static String replaceChar(String str, String c) {
        String newString = str.replaceAll(c, "");
        return newString;
    }

    //==============================================================================================
    static String capitalizeFirstWord(String type) {
        if (type.isEmpty() || type == null) {
            return type;
        }

        return type.substring(0, 1).toUpperCase() + type.substring(1);
    }
}
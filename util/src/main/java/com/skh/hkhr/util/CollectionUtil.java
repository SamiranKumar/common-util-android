package com.skh.hkhr.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 1/02/2017.
 */
public class CollectionUtil {

    public static <T> boolean listEqualsIgnoreOrder(List<T> list1, List<T> list2) {
        return new HashSet<>(list1).equals(new HashSet<>(list2));
    }


    public static <T> boolean isListDifferent(List<T> previousList, List<T> newList) {

        int sizePrevoisList = -1;
        int sizeNewList = -1;

        if (previousList != null && !previousList.isEmpty()) {
            sizePrevoisList = previousList.size();
        }
        if (newList != null && !newList.isEmpty()) {
            sizeNewList = newList.size();
        }

        if ((sizePrevoisList == -1) && (sizeNewList == -1)) {
            return false;
        }

        if (sizeNewList != sizePrevoisList) {
            return true;
        }

        List n_prevois = new ArrayList(previousList);
        List n_new = new ArrayList(newList);

        try {
            Collections.sort(n_prevois);
            Collections.sort(n_new);
        } catch (ClassCastException exp) {
            return true;
        }

        for (int i = 0; i < sizeNewList; i++) {
            Object obj_prevois = n_prevois.get(i);
            Object obj_new = n_new.get(i);
            if (obj_new.equals(obj_prevois)) {
                // Object are same
            } else {
                return true;
            }
        }

        return false;
    }

}

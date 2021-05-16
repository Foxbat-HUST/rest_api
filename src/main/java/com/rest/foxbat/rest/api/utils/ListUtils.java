package com.rest.foxbat.rest.api.utils;

import java.util.List;

public class ListUtils {
    /**
     * check a list is null or has length = 0
     * @param list
     * @param <T>
     * @return
     */
    public static <T> boolean isEmpty(List<T> list){
        if(list == null || list.size() == 0){
            return true;
        }

        return false;
    }

    /**
     * check if a list has length > 0
     * @param list
     * @param <T>
     * @return
     */
    public static <T> boolean isNotEmpty(List<T> list){
        return !isEmpty(list);
    }
}

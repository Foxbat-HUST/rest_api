package com.rest.foxbat.rest.api.utils;

public class StringUtils {
    /**
     * check String is null or size = 0
     * @param s
     * @return
     */
    public static boolean isEmpty(String s){
        if(s == null || s.isEmpty()){
            return true;
        }

        return false;
    }

    /**
     * check if string has length > 0
     * @param s
     * @return
     */
    public static boolean isNotEmpty(String s){
        return !isEmpty(s);
    }
}

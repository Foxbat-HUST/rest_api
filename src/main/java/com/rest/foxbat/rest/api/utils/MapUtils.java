package com.rest.foxbat.rest.api.utils;

import java.util.Map;

public class MapUtils {
    public static boolean isEmpty(Map map){
        if(map == null || map.isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(Map map){
        return !isEmpty(map);
    }
}

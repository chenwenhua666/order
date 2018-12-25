package com.plm.order.utils;

import java.util.Random;

/**
 * chenwenhua
 * 2018\11\11
 */
public class KeyUtil {

    public static synchronized String getUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}

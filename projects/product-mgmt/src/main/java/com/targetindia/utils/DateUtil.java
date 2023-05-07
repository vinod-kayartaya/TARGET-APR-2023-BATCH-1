package com.targetindia.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {
    private DateUtil() {
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static String toString(Date dt) {
        return sdf.format(dt);
    }

    public static Date toDate(String input) {
        try {
            return sdf.parse(input);
        } catch (ParseException e) {
            return null;
        }
    }
}

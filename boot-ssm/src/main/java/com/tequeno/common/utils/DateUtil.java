package com.tequeno.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private final static String DEFAULT_PATTERN = "yyyy-MM-dd";

    private final static SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);

    public static Date parseDate(String dateString) throws Exception {
        return sdf.parse(dateString);
    }

    public static Date parseDate(String dateString, String pattern) throws Exception {
        sdf.applyPattern(pattern);
        return sdf.parse(dateString);
    }

    public static String parseString(Date date) throws Exception {
        return sdf.format(date);
    }

    public static String parseString(Date date, String pattern) throws Exception {
        sdf.applyPattern(pattern);
        return sdf.format(date);
    }
}

package ru.kpfu.it.shorturl.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ayrat on 15.06.2014.
 */
public class DateUtil {
    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}

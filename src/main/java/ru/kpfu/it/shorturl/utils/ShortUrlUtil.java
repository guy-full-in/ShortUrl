package ru.kpfu.it.shorturl.utils;

/**
 * Created by Ayrat on 14.06.2014.
 */
public class ShortUrlUtil {

    public static String getShortCodeFromUrlId(Long id) {
        Double num = Double.valueOf(id);
        String charSet = "23456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ";
        Integer length = charSet.length();
        String encodeString = new String();
        while (num > length) {
            encodeString = charSet.charAt(num.intValue() % length) + encodeString;
            num = Math.ceil(new Double(num / length) - 1);
        }
        encodeString = charSet.charAt(num.intValue()) + encodeString;

        return "x"+encodeString;
    }

}

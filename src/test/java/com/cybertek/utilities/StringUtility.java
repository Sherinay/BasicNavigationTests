package com.cybertek.utilities;

public class StringUtility {
    public static boolean verifyEquals(String expected, String actual) {
        return expected.equals(actual) ? true : false;

    }

    public static boolean verifyContains(String expected, String actual) {
         boolean result = expected.contains(actual) ? true : false;
        return result;
    }
}

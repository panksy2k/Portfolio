package com.financial.ledger.util;

public class Strings {

    public static boolean isNullOrBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNumeric(String str) {
        if(isNullOrBlank(str)) return false;

        for(int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}

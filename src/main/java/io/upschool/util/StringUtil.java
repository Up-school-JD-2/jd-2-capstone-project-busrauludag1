package io.upschool.util;

public class StringUtil {
    private StringUtil() {

    }

    public static String cleanCreditCard(String creditCard) {
        return creditCard.replaceAll("[^0-9]", "");
    }

    public static String maskCreditCard(String creditCard) {
        return creditCard.replaceAll("(?<=.{6}).*(?=.{4})", "***");
    }
}

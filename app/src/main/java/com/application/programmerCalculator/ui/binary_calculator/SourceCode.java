package com.application.programmerCalculator.ui.binary_calculator;

public class SourceCode {
    public static String and(String num1, String num2) throws NumberFormatException {
        String result = "";

        if(num1.length() != num2.length()){
            throw new NumberFormatException();
        }

        for (int i = 0; i < num1.length(); i++) {
            char temp1 = num1.charAt(num1.length() - i - 1);
            char temp2 = num2.charAt(num2.length() - i - 1);
            if (temp1 == '1' && temp2 == '1') {
                result = "1" + result;
            } else {
                result = "0" + result;
            }
        }
        return result;
    }

    public static String or(String num1, String num2) throws NumberFormatException {
        String result = "";

        if(num1.length() != num2.length()){
            throw new NumberFormatException();
        }

        for (int i = 0; i < num1.length(); i++) {
            char temp1 = num1.charAt(num1.length() - i - 1);
            char temp2 = num2.charAt(num2.length() - i - 1);
            if (temp1 == '1' || temp2 == '1') {
                result = "1" + result;
            } else {
                result = "0" + result;
            }
        }
        return result;
    }

    public static String not(String num1) throws NumberFormatException {
        String result = "";
        for (int i = 0; i < num1.length(); i++) {
            char temp = num1.charAt(num1.length() - i - 1);
            if (temp == '0') {
                result = "1" + result;
            } else if (temp == '1') {
                result = "0" + result;
            }
        }
        return result;
    }

    public static String xor(String num1, String num2) throws NumberFormatException {
        String result = "";
        if(num1.length() != num2.length()){
            throw new NumberFormatException();
        }

        for (int i = 0; i < num1.length(); i++) {
            char temp1 = num1.charAt(num1.length() - i - 1);
            char temp2 = num2.charAt(num2.length() - i - 1);
            if (temp1 == '1' && temp2 == '1') {
                result = "0" + result;
            } else if (temp1 == '0' && temp2 == '0') {
                result = "0" + result;
            } else if (temp1 == '1' || temp2 == '1') {
                result = "1" + result;
            }
        }
        return result;
    }

    public static String nand(String num1, String num2) throws NumberFormatException {

        return not(and(num1, num2));
    }

    public static String nor(String num1, String num2) throws NumberFormatException {

        return not(or(num1, num2));
    }
}
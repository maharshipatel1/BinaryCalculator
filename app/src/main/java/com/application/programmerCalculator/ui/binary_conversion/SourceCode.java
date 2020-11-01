package com.application.programmerCalculator.ui.binary_conversion;

import java.util.ArrayDeque;

public class SourceCode {
    public static int hex2Dec(String hexString) throws NumberFormatException {
        int string = 0;
        if(hexString.length() == 1) {
            try {
                string = Integer.parseInt(hexString, 16) * (int) (Math.pow(16, 0));
            }
            catch(NumberFormatException e){
                throw new NumberFormatException();
            }
            return string;
        }
        else{
            String current = hexString.substring(hexString.length() - 1);
            return hex2Dec(hexString.substring(0,hexString.length() - 1)) + Integer.parseInt(current,16) * (int)(Math.pow(16,hexString.length() - 1)) ;
        }
    }

    public static String reverse(String hexString) {
        String result = "";
        for(int i = hexString.length() - 1; i >= 0 ; i--) {
            result = result + hexString.charAt(i);
        }
        return result;
    }

    public static String hex2Bin(String hexString) throws NumberFormatException {
        String result = "";
        for(int i = 0; i < hexString.length(); i++) {
            char temp = hexString.charAt(i);
            if(temp == '0') {
                result = result + "0000";
            }
            else if(temp == '1') {
                result = result + "0001";
            }
            else if(temp == '2') {
                result = result + "0010";
            }
            else if(temp == '3') {
                result = result + "0011";
            }
            else if(temp == '4') {
                result = result + "0100";
            }
            else if(temp == '5') {
                result = result + "0101";
            }
            else if(temp == '6') {
                result = result + "0110";
            }
            else if(temp == '7') {
                result = result + "0111";
            }
            else if(temp == '8') {
                result = result + "1000";
            }
            else if(temp == '9') {
                result = result + "1001";
            }
            else if(temp == 'A') {
                result = result + "1010";
            }
            else if(temp == 'B') {
                result = result + "1011";
            }
            else if(temp == 'C') {
                result = result + "1100";
            }
            else if(temp == 'D') {
                result = result + "1101";
            }
            else if(temp == 'E') {
                result = result + "1110";
            }
            else if(temp == 'F') {
                result = result + "1111";
            }
            else {
                throw new NumberFormatException();
            }
        }
        return result;
    }

    public static int bin2Dec(String binStr) throws NumberFormatException {
        int result = 0;

        for(int i = 0; i < binStr.length(); i++) {
            if(binStr.charAt(binStr.length() - i - 1) == '1') {
                result = result + (int)Math.pow(2, i);
            }
        }
        if(binStr.equals("")){
            return -1;
        }
        return result;
    }

    public static String bin2Hex(String binStr) {
        String result = "";

        if(binStr.length() % 4 != 0){
            throw new NumberFormatException();
        }

        for(int i = 0; i < binStr.length(); i = i + 4) {
            String temp = binStr.substring(i, i + 4);
            if(temp.equals("0000")) {
                result = result + "0";
            }
            else if(temp.equals("0001")) {
                result = result + "1";
            }
            else if(temp.equals("0010")) {
                result = result + "2";
            }
            else if(temp.equals("0011")) {
                result = result + "3";
            }
            else if(temp.equals("0100")) {
                result = result + "4";
            }
            else if(temp.equals("0101")) {
                result = result + "5";
            }
            else if(temp.equals("0110")) {
                result = result + "6";
            }
            else if(temp.equals("0111")) {
                result = result + "7";
            }
            else if(temp.equals("1000")) {
                result = result + "8";
            }
            else if(temp.equals("1001")) {
                result = result + "9";
            }
            else if(temp.equals("1010")) {
                result = result + "A";
            }
            else if(temp.equals("1011")) {
                result = result + "B";
            }
            else if(temp.equals("1100")) {
                result = result + "C";
            }
            else if(temp.equals("1101")) {
                result = result + "D";
            }
            else if(temp.equals("1110")) {
                result = result + "E";
            }
            else if(temp.equals("1111")) {
                result = result + "F";
            }
            else {
                throw new NumberFormatException();
            }
        }
        return result;
    }

    public static String dec2Bin(int dec) {
        ArrayDeque<Integer> number = new ArrayDeque<Integer>();

        while(dec > 0) {
            number.push(dec % 2);
            dec = dec / 2;
        }

        String result = "";

        while(!number.isEmpty()) {
            result = result + number.pop().toString();
        }
        return result;
    }

    public static String dec2Hex(int dec) {
        ArrayDeque<Character> number = new ArrayDeque<Character>();
        int temp = 0;
        while(dec > 0) {
            temp = dec % 16;
            if(temp < 10) number.push((char)(temp + 48));
            else number.push((char)(temp + 55));
            dec = dec / 16;
        }

        String result = "";

        while(!number.isEmpty()) {
            result = result + number.pop().toString();
        }
        return result;
    }
    
}

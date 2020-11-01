package com.application.programmerCalculator.ui.all_conversion;

import java.util.ArrayDeque;

public class SourceCode {
    public static String result(String number, int base) throws NumberFormatException{
        BaseConverter num = new BaseConverter();
        try{
            Integer.parseInt(number);
        }
        catch(NumberFormatException e){
            throw new NumberFormatException();
        }
        num.setNumber(Integer.parseInt(number), base);
        return BaseConverter.convert(num.getNumber());
    }
}

class BaseConverter {

    private class BaseNumber{
        private long number;
        private long base;

        //Post Condition: Method returns the number
        public long getNumber() {
            return number;
        }

        //Post Condition: Method returns the base
        public long getBase() {
            return base;
        }

        //Post Condition: The number is now set to the new number
        public void setNumber(long number) {
            this.number = number;
        }

        //Post Condition: The base is now set to the new base
        public void setBase(long base) {
            this.base = base;
        }
    }

    private BaseNumber number;

    public BaseConverter() {
        number = new BaseNumber();
    }

    //Method to get the BaseNumber object
    //Post Condition: The number is returned
    public BaseNumber getNumber() {
        return number;
    }

    //Method to set the BaseNumber
    //Post Condition: The BaseNumber object has the new values
    public void setNumber(long num, long base) {
        this.number.setNumber(num);
        this.number.setBase(base);
    }

    //Method to convert a baseNumber to a converted String
    //Post Condition: A converted number String is returned
    public static String convert(BaseNumber number) {
        String result = convertAll(new String());
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        long num = number.getNumber();
        long base = number.getBase();
        while(num != 0) {
            stack.push((int)(num % base));
            num = num / base;
        }
        while(!stack.isEmpty()) {
            result = result + stack.peek();
            stack.pop();
        }
        return result;
    }

    //Method to instantiate a String object
    public static String convertAll(String obj) {
        obj = "";
        return obj;
    }

    //Method to print the BaseNumber
    public String toString() {
        return "" + number.getNumber();
    }

    //Method to process and print the converted String
    public void processAndPrint(BaseConverter num) {
        String result = convert(num.number);
        System.out.println(result);
    }
}


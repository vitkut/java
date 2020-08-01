package com.company;

import java.util.regex.Pattern;

public class MobileChecker {

    public static boolean checkMobile(String inputNumber){
        StringBuffer mobileNumber = new StringBuffer(inputNumber);
        try {
            if(mobileNumber.length() != 13){
                throw new IncorrectNumberException("MobileChecker/Code 1", "Too small string: " + inputNumber);
            }
            if(!Pattern.matches("\\+375", mobileNumber.substring(0, 4))){
                throw new IncorrectNumberException("MobileChecker/Code 2", "Incorrect mobile number: " + inputNumber);
            }
            mobileNumber.delete(0, 4);
            if(!Pattern.matches("2?9|3?3|2?5", mobileNumber.substring(0, 2))){
                throw new IncorrectNumberException("MobileChecker/Code:3", "Incorrect mobile number: " + inputNumber);
            }
            mobileNumber.delete(0, 2);
            if(!Pattern.matches("\\d{7}", mobileNumber.toString())){
                throw new IncorrectNumberException("MobileChecker/Code:4", "Incorrect mobile number: " + inputNumber);
            }
            System.out.println(inputNumber + " is correct mobile number");
        } catch (IncorrectNumberException ex){
            System.out.println(ex.getParameter());
            return false;
        }
        return true;
    }


}

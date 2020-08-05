package com.company;

import java.util.regex.Pattern;

public class MobileChecker {

    public static boolean checkMobile(String inputNumber){
        StringBuffer mobileNumber = new StringBuffer(inputNumber);
        try {
            if (!Pattern.matches("^((\\+?375)(29|33|25)(\\d{7}))$", mobileNumber)){
                throw new IncorrectNumberException("MobileChecker/Code 1", "Incorrect mobile number: " + inputNumber);
            }
            System.out.println(inputNumber + " is correct mobile number");
        } catch (IncorrectNumberException ex){
            System.out.println(ex.getParameter());
            return false;
        }
        return true;
    }


}

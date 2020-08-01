package com.company;

import java.util.regex.Pattern;

public class HomePhoneChecker {

    public static boolean checkHomePhone(String inputNumber){
        StringBuffer homePhoneNumber = new StringBuffer(inputNumber);
        try {
            if(homePhoneNumber.length() != 13){
                throw new IncorrectNumberException("HomePhoneChecker/Code:1", "Too small string: " + inputNumber);
            }
            if(!Pattern.matches("\\+375|8?0", homePhoneNumber.substring(0, 4))){
                throw new IncorrectNumberException("HomePhoneChecker/Code:1", "Incorrect home phone number: " + inputNumber);
            }
            homePhoneNumber.delete(0, 4);
            if(!Pattern.matches("1?5|1?6|1?7|2?1|2?2", homePhoneNumber.substring(0, 2))){
                throw new IncorrectNumberException("HomePhoneChecker/Code:3", "Incorrect home phone number: " + inputNumber);
            }
            homePhoneNumber.delete(0, 2);
            if(!Pattern.matches("\\d{7}", homePhoneNumber.toString())){
                throw new IncorrectNumberException("HomePhoneChecker/Code:4", "Incorrect home phone number: " + inputNumber);
            }
            System.out.println(inputNumber + " is correct home phone number");
        } catch (IncorrectNumberException ex){
            System.out.println(ex.getParameter());
            return false;
        }
        return true;
    }
}

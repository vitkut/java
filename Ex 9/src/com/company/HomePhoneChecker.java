package com.company;

import java.util.regex.Pattern;

public class HomePhoneChecker {

    public static boolean checkHomePhone(String inputNumber){
        StringBuffer homePhoneNumber = new StringBuffer(inputNumber);
        try {
            if(!Pattern.matches("^((\\+?375|80)(15|16|17|21|22)(\\d{7}))$", homePhoneNumber)){
                throw new IncorrectNumberException("HomePhoneChecker/Code:1", "Incorrect home phone number: " + inputNumber);
            }
            System.out.println(inputNumber + " is correct home phone number");
        } catch (IncorrectNumberException ex){
            System.out.println(ex.getParameter());
            return false;
        }
        return true;
    }
}

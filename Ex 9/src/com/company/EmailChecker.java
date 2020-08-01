package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailChecker {

    public static boolean checkEmail(String inputEmail){
        StringBuffer email = new StringBuffer(inputEmail);
        try {
            StringBuilder emailLogin;
            StringBuilder emailDomain;
            Pattern pattern = Pattern.compile("\\@{1}");
            Matcher matcher = pattern.matcher(email);
            if(matcher.find()){
                emailLogin = new StringBuilder(email.substring(0, matcher.start()));
                emailDomain = new StringBuilder(email.substring(matcher.end(), email.length()));
            } else {
                throw new IncorrectEmailException("EmailChecker/Code:1", "Incorrect email: " + inputEmail);
            }
            pattern = Pattern.compile("[a-zA-Z\\d!#$%&'*+\\-/=?^_`{|}~]++");
            matcher = pattern.matcher(emailLogin);
            if(!matcher.matches()){
                pattern = Pattern.compile("\\..+?|.+?\\.|.+?\\.\\..+?|\\.+");
                matcher = pattern.matcher(emailLogin);
                if(matcher.matches() || emailLogin.length() == 0){
                    throw new IncorrectEmailException("EmailChecker/Code:2", "Incorrect email: " + inputEmail);
                }
            }
            pattern = Pattern.compile(".+\\..+");
            matcher = pattern.matcher(emailDomain);
            if(matcher.matches()){
                pattern = Pattern.compile("\\..+?|.+?\\.|.+?\\.\\..+?|\\.+");
                matcher = pattern.matcher(emailDomain);
                if(matcher.matches() || emailDomain.length() == 0){
                    throw new IncorrectEmailException("EmailChecker/Code:3", "Incorrect email: " + inputEmail);
                }
                pattern = Pattern.compile("[a-z\\d\\-\\.]+");
                matcher = pattern.matcher(emailDomain);
                if(!matcher.matches()){
                    throw new IncorrectEmailException("EmailChecker/Code:4", "Incorrect email: " + inputEmail);
                }
            }
            System.out.println(inputEmail + " is correct email");
            return true;
        } catch (IncorrectEmailException ex){
            System.out.println(ex.getParameter());
            return false;
        }
    }
}

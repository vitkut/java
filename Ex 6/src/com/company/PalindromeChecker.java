package com.company;

public class PalindromeChecker {

    public static void palCheck(StringBuffer stringBuffer){
        System.out.println("<Palindrome check>");
        int lenght = stringBuffer.length();
        try {
            if(lenght == 0){
                throw new WrongSymbolException("Empty string");
            }
            for (int i = 0; i < lenght/2; i++){
                if(stringBuffer.charAt(i) != stringBuffer.charAt(lenght-i-1)){
                    throw new WrongSymbolException("Not a palindrome");
                }
            }
            System.out.println("It is palindrome");
        } catch (WrongSymbolException ex){
            System.out.println(ex.getParameter());
        }
    }


}

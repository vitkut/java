package com.company;

public class PalindromeChecker {

    public static void palCheck(String inputString){
        System.out.println("<Palindrome check>");
        inputString = inputString.toLowerCase();
        StringBuffer stringBuffer = new StringBuffer(inputString);
        for (int i = 0; i < stringBuffer.length(); i++){
            if(stringBuffer.charAt(i) == ' '){
                stringBuffer.deleteCharAt(i);
                i--;
            }
        }
        int length = stringBuffer.length();
        try {
            if(length == 0){
                throw new WrongSymbolException("Empty string");
            }
            for (int i = 0; i < length/2; i++){
                if(stringBuffer.charAt(i) != stringBuffer.charAt(length-i-1)){
                    throw new WrongSymbolException("Not a palindrome");
                }
            }
            System.out.println("It is palindrome");
        } catch (WrongSymbolException ex){
            System.out.println(ex.getParameter());
        }
    }


}

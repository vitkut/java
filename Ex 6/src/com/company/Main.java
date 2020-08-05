package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(32);
        System.out.println("Enter string (max " + stringBuffer.capacity() + "):");
        stringBuffer.append(scanner.nextLine());
        symbolsCheck(stringBuffer, "*", "/");
        SymbolsReplace.symbReplace(stringBuffer);
        PalindromeChecker.palCheck(stringBuffer.toString());;
        Reverse.reverse(stringBuffer);
        Division.div();
    }

    private static void symbolsCheck(StringBuffer stringBuffer, String lastSymb, String firstSymb){
        System.out.println("<Symbols check>");
        StringBuffer chars = new StringBuffer(lastSymb);
        try {
            stringBuffer.reverse();
            chars.reverse();
            if (stringBuffer.length() == 0){
                throw new WrongSymbolException("Empty string");
            }
            for(int i = 0; i < chars.length(); i++){
                if(stringBuffer.charAt(i) != chars.charAt(i)){
                    throw new WrongSymbolException("Wrong last symb");
                }
            }


        } catch (WrongSymbolException ex){
            System.out.println(ex.getParameter());
        } finally {
            stringBuffer.reverse();
            chars.reverse();
        }
        chars.replace(0, chars.length(), firstSymb);
        try {
            if (stringBuffer.length() == 0){
                throw new WrongSymbolException("Empty string");
            }
            for(int i = 0; i < chars.length(); i++){
                if(stringBuffer.charAt(i) != chars.charAt(i)){
                    throw new WrongSymbolException("Wrong first symb");
                }
            }
        } catch (WrongSymbolException ex){
            System.out.println(ex.getParameter());
        }
        Scanner scanner = new Scanner(System.in);
        StringBuffer subStringBuffer = new StringBuffer();
        subStringBuffer.ensureCapacity(32);
        System.out.println("Enter sub string (max " + subStringBuffer.capacity() + "):");
        subStringBuffer.append(scanner.nextLine());
        StringBuffer buffer = new StringBuffer();
        int pointSubstring = -1;
        try {
            if (stringBuffer.length() == 0 || subStringBuffer.length() == 0){
                throw new WrongSymbolException("Empty string");
            }
            for(int i = 0; i+subStringBuffer.length() <= stringBuffer.length(); i++){
                buffer.append(stringBuffer.substring(i, i+subStringBuffer.length()));
                if(buffer.toString().equals(subStringBuffer.toString())){
                    pointSubstring = i;
                    break;
                } else {
                    buffer.delete(0, buffer.length());
                }
            }
            if (pointSubstring == -1){
                throw new WrongSymbolException("Sub string don't contained");
            } else {
                int pointExit = subStringBuffer.length()+pointSubstring-1;
                System.out.println("Done [" + pointSubstring + ", " + pointExit + "]");
            }
        } catch (WrongSymbolException ex){
            System.out.println(ex.getParameter());
        }
    }
}

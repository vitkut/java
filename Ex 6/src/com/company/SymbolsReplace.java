package com.company;

import java.util.Scanner;

public class SymbolsReplace {

    public static void symbReplace(StringBuffer stringBuffer){
        System.out.println("<Symbols replace>");
        System.out.println("Enter replaceable symbol:");
        Scanner scanner = new Scanner(System.in);
        String bufferString = scanner.next();
        char prevSymb = bufferString.charAt(0);
        System.out.println("Replaceable symbol [" + prevSymb + "]");
        System.out.println("Enter new symbol:");
        bufferString = scanner.next();
        char newSymb = bufferString.charAt(0);
        System.out.println("New symbol [" + newSymb + "]");
        try {
            if(stringBuffer.length() == 0){
                throw new WrongSymbolException("Empty string");
            }
            for(int i = 0; i < stringBuffer.length(); i++){
                if(prevSymb == stringBuffer.charAt(i)){
                    stringBuffer.deleteCharAt(i);
                    stringBuffer.insert(i, newSymb);
                }
            }
        } catch (WrongSymbolException ex){
            System.out.println(ex.getParameter());
        } finally {
            System.out.println("New string: " + stringBuffer);
        }
    }
}

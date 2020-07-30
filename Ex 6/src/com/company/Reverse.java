package com.company;

public class Reverse {

    public static void reverse(StringBuffer stringBuffer){
        System.out.println("<Reverse>");
        try {
            if (stringBuffer.length() == 0){
                throw new WrongSymbolException("Empty string");
            }
            System.out.println("Using the command: ");
            stringBuffer.reverse();
            System.out.println(stringBuffer);
            System.out.println("Without using the command: ");
            stringBuffer.reverse();
            StringBuffer newStringBuffer = new StringBuffer();
            for(int i = stringBuffer.length(); i > 0; i--){
                newStringBuffer.append(stringBuffer.charAt(i-1));
            }
            System.out.println(newStringBuffer);
            stringBuffer.reverse();
        } catch (WrongSymbolException ex){
            System.out.println(ex.getParameter());
        }

    }

}

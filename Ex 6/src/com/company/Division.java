package com.company;

public class Division {

    public static void div(){
        System.out.println("<Division>");
        String str = "Hello, hello, hello";
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i = 0; i < stringBuffer.length(); i++){
            if(stringBuffer.charAt(i) == ' '){
                stringBuffer.deleteCharAt(i);
                i--;
            }
        }
        String[] newArrayString = stringBuffer.toString().split(",");
        for (String s:newArrayString){
            System.out.println(s);
        }
    }
}

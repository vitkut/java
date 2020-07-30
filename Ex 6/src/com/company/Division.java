package com.company;


public class Division {

    public static void div(){
        System.out.println("<Division>");
        String str = "Hello, hello, hello";
        int numOfDiv = 0;
        for(int i = 0; i < str.length(); i++){
            if(',' == str.charAt(i)){
                numOfDiv++;
            }
        }
        String[] strArray = new String[numOfDiv+1];
        int j = 0, positionOfSymb = 0;
        for(int i = 0; i < str.length(); i++){
            if(',' == str.charAt(i)){
                strArray[j] = str.substring(positionOfSymb, i);
                positionOfSymb = i+2;
                j++;
            }
        }
        strArray[j] = str.substring(positionOfSymb);
        for (int i = 0; i <= numOfDiv; i++){
            System.out.println(strArray[i]);
        }
    }
}

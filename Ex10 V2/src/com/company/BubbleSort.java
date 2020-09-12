package com.company;

import java.util.Date;

public class BubbleSort {

    public static long time;
    public static String[] strings;

    public static void sort(String[] stringsInput){
        strings = stringsInput.clone();
        Date date1 = new Date();
        StringBuilder stringBuffer = new StringBuilder();
        int countOfOperations = 0;
        for(int i = 0; i < strings.length; i++){
            for(int j = 1; j < strings.length; j++){
                if(strings[j].length() < strings[j-1].length()){
                    stringBuffer.delete(0, stringBuffer.length());
                    stringBuffer.append(strings[j-1]);
                    strings[j-1] = strings[j];
                    strings[j] = stringBuffer.toString();
                }
                countOfOperations++;
            }
        }

        Date date2 = new Date();

        /*for(String i:strings){
            System.out.println(i);
        }*/
        time = date2.getTime()-date1.getTime();
        /*System.out.println("Working time: " + time + " ms");
        System.out.println("Operations: [" + countOfOperations + "]");*/
    }
}

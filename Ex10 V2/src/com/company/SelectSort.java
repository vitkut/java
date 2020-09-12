package com.company;

import java.util.Date;

public class SelectSort {

    public static long time;
    public static String[] strings;

    public  static void sort(String[] stringsInput){
        Date date1 = new Date();
        strings = stringsInput.clone();
        StringBuilder minString = new StringBuilder();
        StringBuilder buffString = new StringBuilder();
        int countOfOperations = 0;
        for (int i = 0; i < strings.length; i++){
            minString.replace(0, minString.length(), strings[i]);
            for(int j = i; j < strings.length; j++){
                if(minString.length() > strings[j].length()){
                    minString.replace(0, minString.length(), strings[j]);
                    buffString.append(strings[j]);
                    strings[j] = strings[i];
                    strings[i] = buffString.toString();
                    j = i;
                    buffString.delete(0, buffString.length());
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

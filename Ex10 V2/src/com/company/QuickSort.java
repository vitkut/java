package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {

    private static int countOfOperations = 0;
    public static long time;
    public static String[] strings;
    public static ArrayList<String> stringArrayList;

    public static void input(String[] stringsInput){
        Date date1 = new Date();
        strings = stringsInput.clone();
        stringArrayList = new ArrayList<>(Arrays.asList(strings));

        stringArrayList = sort(stringArrayList);

        Date date2 = new Date();
        /*for(String i:stringArrayList){
            System.out.println(i);
        }*/
        time = date2.getTime()-date1.getTime();
        /*System.out.println("Working time: " + time + " ms");
        System.out.println("Operations: [" + countOfOperations + "]");*/
    }

    private static ArrayList<String> sort(ArrayList<String> strings){
        if(strings.size() <= 1){
            return strings;
        }
        String supportElement = strings.get(strings.size()/2);
        ArrayList<String> isBigger = new ArrayList<>();
        ArrayList<String> isLower = new ArrayList<>();
        for (String i:strings){
            if (i.length() > supportElement.length()){
                isBigger.add(i);
                countOfOperations++;

            }
            if(i.length() < supportElement.length()){
                isLower.add(i);
                countOfOperations++;
            }
        }
        isBigger = sort(isBigger);
        isLower = sort(isLower);
        isLower.add(supportElement);
        for(String i:isBigger){
            isLower.add(i);
        }
        return isLower;
    }


}

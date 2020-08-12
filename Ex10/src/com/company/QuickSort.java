package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

    private static int countOfOperations = 0;

    public static void input(String[] strings){
        long workingTime = System.currentTimeMillis();
        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList(strings));

        stringArrayList = sort(stringArrayList);
        for(String i:stringArrayList){
            System.out.println(i);
        }
        workingTime = System.currentTimeMillis()-workingTime;
        System.out.println("Working time: " + workingTime + " ms");
        System.out.println("Operations: [" + countOfOperations + "]");
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

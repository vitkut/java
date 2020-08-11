package com.company;

public class SelectSort {

    public  static void sort(String[] strings){
        long workingTime = System.currentTimeMillis();
        StringBuilder minString = new StringBuilder();
        int countOfOperations = 0;
        for (int i = 0; i < strings.length; i++){
            minString.replace(0, minString.length(), strings[i]);
            for(int j = i; j < strings.length; j++){
                if(minString.length() > strings[j].length()){
                    minString.replace(0, minString.length(), strings[j]);
                }
                countOfOperations++;
            }
            strings[i] = minString.toString();
        }

        for(String i:strings){
            System.out.println(i);
        }
        workingTime = System.currentTimeMillis()-workingTime;
        System.out.println("Working time: " + workingTime + " ms");
        System.out.println("Operations: [" + countOfOperations + "]");
    }
}

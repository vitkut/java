package com.company;

public class BubbleSort {

    public static void sort(String[] strings){
        long workingTime = System.currentTimeMillis();
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

        for(String i:strings){
            System.out.println(i);
        }
        workingTime = System.currentTimeMillis()-workingTime;
        System.out.println("Working time: " + workingTime + " ms");
        System.out.println("Operations: [" + countOfOperations + "]");
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Versions {

    private static ArrayList<String> arrayList = new ArrayList<>();
    private static int count = 0;

    public static void start(String string){
        sort(string, string.length());
        Collections.sort(arrayList);
        cleaning();
        for(String str:arrayList){
            System.out.println(str);
        }
        System.out.println("Count: "+count);
    }

    private static void cleaning(){
        for(int i = 0; i < arrayList.size(); i++){
            for(int j = i+1; j < arrayList.size(); j++){
                if(arrayList.get(i).equals(arrayList.get(j))){
                    arrayList.remove(j);
                    j = i;
                    count--;
                }
            }
        }
    }

    private static void sort(String string, int num){
        if(num == 1){
            arrayList.add(string);
            count++;
        } else {
            for(int i = 0; i < num; i++){
                String newString = getRedactedString(string, i, num-1);
                sort(newString, num-1);
            }
        }
    }

    private static String getRedactedString(String string, int first, int second){
        char firstChar = string.charAt(first);
        char secondChar = string.charAt(second);
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.setCharAt(second, firstChar);
        stringBuilder.setCharAt(first, secondChar);
        return stringBuilder.toString();
    }
}

package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private  static File file = new File("array.txt");
    private static int countOfStrings;
    public static String[] strings;

    public static void main(String[] args) {
        System.out.println("Generate? (y/n):");
        Scanner scanner = new Scanner(System.in);
        if(scanner.next().equals("y")){
            generate();
        } else {
            setCountOfStrings();
        }
        strings = add(countOfStrings);
        System.out.println("Input:\n");
        for (String i:strings){
            System.out.println(i);
        }

        BubbleThread bubbleThread = new BubbleThread();
        SelectThread selectThread = new SelectThread();
        QuickThread quickThread = new QuickThread();
        bubbleThread.start();
        selectThread.start();
        quickThread.start();

        try{
            bubbleThread.join();
            selectThread.join();
            quickThread.join();
        } catch (InterruptedException ex){}


        System.out.println("\nBubble sort:\n");
        for(String i:BubbleSort.strings){
            System.out.println(i);
        }
        System.out.println("\nSelect sort:\n");
        for(String i:SelectSort.strings){
            System.out.println(i);
        }
        System.out.println("\nQuick sort\n");
        for(String i:QuickSort.stringArrayList){
            System.out.println(i);
        }
        System.out.println("***");
        System.out.println("Bubble sort time: "+BubbleSort.time);
        System.out.println("Select sort time: "+SelectSort.time);
        System.out.println("Quick sort time: "+QuickSort.time);
        System.out.println("***");

    }

    private static String[] add(int countOfStrings){


        try {

            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            String[] strings = new String[countOfStrings];
            int i = 0;
            while (scanner.hasNextLine()){
                strings[i] = scanner.nextLine();
                i++;
            }
            return strings;

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return new String[1];
    }

    private static void setCountOfStrings() {
        try{
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()){
                scanner.nextLine();
                countOfStrings++;
            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }


    }

    public static int getCountOfStrings() {
        return countOfStrings;
    }

    public static void generate(){
        Scanner scanner = new Scanner(System.in);
        try{
            FileWriter fileWriter = new FileWriter(file, false);

            System.out.println("Enter count of strings (Max 20_000):");
            countOfStrings = scanner.nextInt();

            Date date1 = new Date();

            Integer[] randInts = shuffle();
            StringBuilder stringBufferArrayList = new StringBuilder();


            for(int i = 0; i < countOfStrings; i++){
                stringBufferArrayList.append("[").append(randInts[i]).append("]");
                for(int j = 3; j < randInts[i]; j++){
                    stringBufferArrayList.append("*");
                }
                stringBufferArrayList.append("\n");
            }
            fileWriter.write(stringBufferArrayList.toString());
            fileWriter.flush();

            Date date2 = new Date();
            System.out.println("** "+(date2.getTime()-date1.getTime())+" ms **");
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static Integer[] shuffle(){
        Integer[] out = new Integer[Main.getCountOfStrings()];
        for (int i = 0; i < Main.getCountOfStrings(); i++){
            out[i] = i+3;
        }
        Collections.shuffle(Arrays.asList(out));

        return out;
    }

}

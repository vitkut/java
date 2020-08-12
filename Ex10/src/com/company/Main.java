package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private  static File file = new File("array.txt");
    private static int countOfStrings;

    public static void main(String[] args) {
        System.out.println("Generate? (y/n):");
        Scanner scanner = new Scanner(System.in);
        if(scanner.next().equals("y")){
            generate();
        } else {
            setCountOfStrings();
        }
        String[] strings = add(countOfStrings);
        System.out.println("Input:\n");
        for (String i:strings){
            System.out.println(i);
        }

        System.out.println("\nBubble sort:\n");
        //BubbleSort.sort(strings);
        System.out.println("\nSelect sort:\n");
        //SelectSort.sort(strings);
        System.out.println("\nQuick sort\n");
        QuickSort.input(strings);

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

    private static void generate(){
        Scanner scanner = new Scanner(System.in);
        try{
            FileWriter fileWriter = new FileWriter(file, false);

            System.out.println("Enter count of strings:");
            countOfStrings = scanner.nextInt();
            int[] randInts = randInt(countOfStrings);
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
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }

    private static int[] randInt(int count){
        int[] out = new int[count];
        int buff;
        for(int i = 0; i < count; i++){
            out[i] = i+3;
        }
        System.out.print("Generate outRandInt\n-------------------\n");
        int waiting = 0;
        for (int i = 0; i < count*count; i++){
            for (int j = 0; j < count; j++){
                if(Math.random() > 0.6d && j != count-1){
                    buff = out[j];
                    out[j] = out[j+1];
                    out[j+1] = buff;
                }
                if(Math.random() < 0.4d && j != 0){
                    buff = out[j];
                    out[j] = out[j-1];
                    out[j-1] = buff;
                }
            }
            if(waiting < count*count/20){
                waiting++;
            } else {
                System.out.print(".");
                waiting = 0;
            }
        }
        System.out.println("\nRandInt is generated");
        return out;
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
}

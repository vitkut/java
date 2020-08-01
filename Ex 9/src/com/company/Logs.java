package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logs {

    private static int strNumber = 1;
    private static final String VERSION = "0.1.1";
    private static File file = new File("log.txt");

    public static void start(){
        Date date = new Date();
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            String startString = String.format("Start> Version: %s> Date: %tc%n", VERSION, date);
            fileWriter.write(startString);
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void finish(boolean isSuccessful){
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("Successful: " + isSuccessful + "\n");
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void errLogs(String message, String parameter){
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            String newString = String.format("%d) Message: %s; Parameter: %s%n", strNumber, message, parameter);
            fileWriter.write(newString);
            fileWriter.flush();
            strNumber++;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

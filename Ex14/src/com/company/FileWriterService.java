package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterService extends Thread{

    @Override
    public void run(){
        File file = new File("protocol.txt");
        try{
            FileWriter fileWriter = new FileWriter(file, false);
            StringBuilder stringBuilder = StringMaking.make();
            fileWriter.write(stringBuilder.toString());
            fileWriter.flush();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}

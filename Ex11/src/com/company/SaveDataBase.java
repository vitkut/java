package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveDataBase {

    private static File fileStudent = new File("data.txt");
    private static File fileFaculty = new File("dataFaculty.txt");
    private static File fileUniversity = new File("dataUniversity.txt");

    public static void save(){
        saveUniversity();
        saveFaculty();
        saveStudent();
        System.out.println("Saved.");
    }

    private static void saveUniversity(){
        try{
            FileWriter fileWriter = new FileWriter(fileUniversity);
            for(University i:Main.getUniversities()){
                fileWriter.write(i.getUniversityName()+"\n");
            }
            fileWriter.close();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void saveFaculty(){
        try{
            FileWriter fileWriter = new FileWriter(fileFaculty);
            for(University i:Main.getUniversities()){
                for (Faculty j:i.getFaculties()){
                    fileWriter.write(j.getFacultyName() + " " + i.getUniversityName() + "\n");
                }
            }
            fileWriter.close();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void saveStudent(){
        try{
            FileWriter fileWriter = new FileWriter(fileStudent);
            for(University i:Main.getUniversities()){
                for (Faculty j:i.getFaculties()){
                    for (Student s:j.getStudents()){
                        fileWriter.write(s.getLastName()+", "+s.getFirstName()+", "+i.getUniversityName()+
                                ", "+j.getFacultyName()+", "+s.getCourse()+", "+s.getScore()+"\n");
                    }
                }
            }
            fileWriter.close();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

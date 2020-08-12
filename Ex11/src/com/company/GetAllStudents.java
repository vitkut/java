package com.company;

import java.util.ArrayList;

public class GetAllStudents {

    public static ArrayList<Student> getAll(){
        ArrayList<Student> allStudents = new ArrayList<>();
        for(University i:Main.getUniversities()){
            for(Faculty j:i.getFaculties()){
                for (Student s:j.getStudents()){
                    allStudents.add(s);
                }
            }
        }
        return allStudents;
    }
}

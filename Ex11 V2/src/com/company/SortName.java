package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class SortName{

    public static ArrayList<Student> sort(){
        ArrayList<Student> allStudents = GetAllStudents.getAll();
        ArrayList<String> nameStudents = new ArrayList<>();
        for(Student i:allStudents){
            nameStudents.add(i.getLastName());
        }
        Collections.sort(nameStudents);
        Student buffStudent;
        for(int i = 0; i < allStudents.size(); i++){
            for(int j = i; j < allStudents.size(); j++){
                if(nameStudents.get(i).equals(allStudents.get(j).getLastName())){
                    buffStudent = allStudents.get(j);
                    allStudents.set(j, allStudents.get(i));
                    allStudents.set(i, buffStudent);
                    break;
                }
            }
        }
        return allStudents;
    }
}

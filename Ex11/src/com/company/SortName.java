package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class SortName{

    public static ArrayList<Student> sort(){
        ArrayList<Student> allStudents = GetAllStudents.getAll();
        ArrayList<String> firstNameStudents = new ArrayList<>();
        for(Student i:allStudents){
            firstNameStudents.add(i.getFirstName());
        }
        Collections.sort(firstNameStudents);
        Student buffStudent;
        for(int i = 0; i < allStudents.size(); i++){
            for(int j = i; j < allStudents.size(); j++){
                if(firstNameStudents.get(i).equals(allStudents.get(j).getFirstName())){
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

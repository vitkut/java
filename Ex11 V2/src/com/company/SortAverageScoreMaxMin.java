package com.company;

import java.util.ArrayList;

public class SortAverageScoreMaxMin {

    public static ArrayList<Student> sort(){
        ArrayList<Student> allStudents = GetAllStudents.getAll();
        Student bufferStudent;
        Student max;
        for(int i = 0; i < allStudents.size(); i++){
            max = allStudents.get(i);
            for(int j = i; j < allStudents.size(); j++){
                if(max.getAverageScore() < allStudents.get(j).getAverageScore()){
                    max = allStudents.get(j);
                    bufferStudent = allStudents.get(j);
                    allStudents.set(j, allStudents.get(i));
                    allStudents.set(i, bufferStudent);
                    j = i;
                }
            }
        }
        return allStudents;
    }

}

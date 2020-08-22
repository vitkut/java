package com.company;

import java.util.ArrayList;

public class SortAverageScoreMinMax {

    public static ArrayList<Student> sort(){
        ArrayList<Student> allStudents = GetAllStudents.getAll();
        Student min;
        Student bufferStudent;
        for(int i = 0; i < allStudents.size(); i++){
            min = allStudents.get(i);
            for(int j = i; j < allStudents.size(); j++){
                if(min.getAverageScore() > allStudents.get(j).getAverageScore()){
                    min = allStudents.get(j);
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

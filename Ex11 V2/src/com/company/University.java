package com.company;

import java.util.ArrayList;

public class University {

    private String universityName;
    private ArrayList<Faculty> faculties = new ArrayList<>();

    public University(){}

    public University(String universityName, ArrayList<Faculty> faculties){
        this.universityName = universityName;
        this.faculties = faculties;
    }

    public University(String universityName){
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void addFaculty(Faculty faculty){
        this.faculties.add(faculty);
    }

    public int getCountOfStudents(){
        int count = 0;
        for (Faculty fa:getFaculties()){
            for(Student st:fa.getStudents()){
                count++;
            }
        }
        return count;
    }

    public double getAverageScore(){
        int countOfStudents = getCountOfStudents();
        double averageScore = 0;
        for (Faculty fa:getFaculties()){
            for(Student st:fa.getStudents()){
                averageScore += st.getAverageScore();
            }
        }
        averageScore /= countOfStudents;
        return averageScore;
    }
}

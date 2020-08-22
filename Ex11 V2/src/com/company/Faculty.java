package com.company;

import java.util.ArrayList;

public class Faculty {

    private String facultyName;
    private ArrayList<Student> students = new ArrayList<>();

    public Faculty(){}

    public Faculty(String facultyName){
        this.facultyName = facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void delStudent(Student student){
        this.students.remove(student);
    }

    public int getCountOfStudents(){
        int count = 0;
        for(Student st:getStudents()){
            count++;
        }
        return count;
    }

    public double getAverageScore(){
        double score = 0;
        for(Student st:getStudents()){
            score += st.getAverageScore();
        }
        score /= getCountOfStudents();
        return score;
    }
}

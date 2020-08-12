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
}

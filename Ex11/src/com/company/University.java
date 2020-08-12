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
}

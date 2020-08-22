package com.company;

import java.util.ArrayList;

public class Main {

    private static ArrayList<University> universities = new ArrayList<>();

    public static void main(String[] args) {
        GetDataBase.get();
        System.out.println("(To read help message enter /help)");
        Gui.startGui();
        //Menu.menu();
    }

    public static Faculty getFacultyByName(String facultyName){
        for(University un:universities){
            for(Faculty fa:un.getFaculties()){
                if(fa.getFacultyName().equals(facultyName)){
                    return fa;
                }
            }
        }
        return null;
    }

    public static Student getStudentByName(String lastNameAndFirstName){
        //studentData[0] -> lastName; studentData[1] -> firstName
        String[] studentData = lastNameAndFirstName.split(" ", 2);
        for(University un:universities){
            for(Faculty fa:un.getFaculties()){
                for(Student st:fa.getStudents()){
                    if(st.getLastName().equals(studentData[0]) && st.getFirstName().equals(studentData[1])){
                        return st;
                    }
                }
            }
        }
        return null;
    }

    public static University getUniversityByName(String universityName){
        for (University un:universities){
            if(un.getUniversityName().equals(universityName)){
                return un;
            }
        }
        return null;
    }

    public static ArrayList<University> getUniversities() {
        return universities;
    }

    public static void setUniversities(ArrayList<University> universities) {
        Main.universities = universities;
    }
}

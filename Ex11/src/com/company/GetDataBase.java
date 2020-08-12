package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GetDataBase {

    private static File fileStudent = new File("data.txt");
    private static File fileFaculty = new File("dataFaculty.txt");
    private static File fileUniversity = new File("dataUniversity.txt");

    public static void get(){
        getUniversities();
        getFaculties();
        getStudents();
    }

    private static void getUniversities(){
        try{
            FileReader fileReader = new FileReader(fileUniversity);
            Scanner scanner = new Scanner(fileReader);
            ArrayList<University> universityArrayList = new ArrayList<>();
            while (scanner.hasNextLine()){
                University university = new University(scanner.nextLine());
                universityArrayList.add(university);
            }
            Main.setUniversities(universityArrayList);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void getFaculties(){
        try{
            FileReader fileReader = new FileReader(fileFaculty);
            Scanner scanner = new Scanner(fileReader);
            StringBuilder facultyName = new StringBuilder();
            StringBuilder universityName = new StringBuilder();
            while (scanner.hasNextLine() && scanner.hasNext()){
                facultyName.append(scanner.next());
                universityName.append(scanner.next());
                Faculty faculty = new Faculty(facultyName.toString());
                for(University i:Main.getUniversities()){
                    if(i.getUniversityName().equals(universityName.toString())){
                        i.addFaculty(faculty);
                    }
                }
                facultyName.delete(0, facultyName.length());
                universityName.delete(0, universityName.length());
            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void getStudents(){
        try{
            FileReader fileReader = new FileReader(fileStudent);
            Scanner scanner = new Scanner(fileReader);
            StringBuilder lastName = new StringBuilder();
            StringBuilder firstName = new StringBuilder();
            StringBuilder university = new StringBuilder();
            StringBuilder faculty = new StringBuilder();
            StringBuilder course = new StringBuilder();
            StringBuilder score = new StringBuilder();
            while (scanner.hasNextLine()){
                lastName.replace(0, lastName.length(), scanner.next());
                firstName.replace(0, lastName.length(), scanner.next());
                university.replace(0, lastName.length(), scanner.next());
                faculty.replace(0, lastName.length(), scanner.next());
                course.replace(0, lastName.length(), scanner.next());
                score.replace(0, lastName.length(), scanner.nextLine());

                lastName.deleteCharAt(lastName.length()-1);
                firstName.deleteCharAt(firstName.length()-1);
                university.deleteCharAt(university.length()-1);
                faculty.deleteCharAt(faculty.length()-1);
                course.deleteCharAt(course.length()-1);

                Student newStudent = new Student(lastName.toString(), firstName.toString(), Integer.parseInt(course.toString()));
                score.delete(0, 2);
                score.deleteCharAt(score.length()-1);
                String[] strings = score.toString().split(", ");
                for(String s:strings){
                    newStudent.addScore(Integer.parseInt(s));
                }

                for(University i: Main.getUniversities()){
                    if(i.getUniversityName().equals(university.toString())){
                        for (Faculty j:i.getFaculties()){
                            if(j.getFacultyName().equals(faculty.toString())){
                                j.addStudent(newStudent);
                            }
                        }
                    }
                }

                lastName.delete(0, lastName.length());
                firstName.delete(0, firstName.length());
                university.delete(0, university.length());
                faculty.delete(0, faculty.length());
                course.delete(0, course.length());
                score.delete(0, score.length());

            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

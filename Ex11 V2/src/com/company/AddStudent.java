package com.company;

import java.util.Scanner;

public class AddStudent {

    public static void add(){
        System.out.println("Add student>>");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chose university:");
        for(int i = 0; i < Main.getUniversities().size(); i++){
            System.out.println(i+1+") "+Main.getUniversities().get(i).getUniversityName());
        }
        University university = Main.getUniversities().get(scanner.nextInt()-1);
        scanner.nextLine();
        System.out.println("Chose faculty:");
        for(int i = 0; i < university.getFaculties().size(); i++){
            System.out.println(i+1+") "+university.getFaculties().get(i).getFacultyName());
        }
        Faculty faculty = university.getFaculties().get(scanner.nextInt()-1);
        scanner.nextLine();
        System.out.println("Chose course: (1, 2, 3, 4)");
        int course = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        Student newStudent = new Student(lastName, firstName, course);
        faculty.addStudent(newStudent);
        System.out.println("Done");
    }
}

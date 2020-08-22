package com.company;

import java.util.Scanner;

public class ViewStudents {

    public static void view(){
        System.out.println("View students>>");
        Scanner scanner = new Scanner(System.in);
        System.out.println("All students? (y/n)");
        if(scanner.nextLine().equals("y")){
            for(University i:Main.getUniversities()){
                System.out.println("\n#"+i.getUniversityName()+"#");
                for(Faculty j:i.getFaculties()){
                    System.out.println("\n"+j.getFacultyName()+":");
                    System.out.printf("   %-30s %-30s %-30s %-30s%n", "First name", "Last name", "Course", "Average score");
                    for(int k = 0; k < j.getStudents().size(); k++){
                        Student student = j.getStudents().get(k);
                        System.out.printf(k+1+") %-30s %-35s %-18s %20.2f%n", student.getFirstName(), student.getLastName(),
                                student.getCourse(), student.getAverageScore());
                    }
                }
            }
        } else {
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
            System.out.println(faculty.getFacultyName()+":");
            System.out.printf("   %-30s %-30s %-30s %-30s%n", "First name", "Last name", "Course", "Average score");
            for(int k = 0; k < faculty.getStudents().size(); k++){
                Student student = faculty.getStudents().get(k);
                System.out.printf(k+1+") %-30s %-35s %-18s %20.2f%n", student.getFirstName(), student.getLastName(),
                        student.getCourse(), student.getAverageScore());
            }
            System.out.println();
        }
    }
}

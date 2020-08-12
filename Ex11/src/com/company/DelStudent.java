package com.company;

import java.util.Scanner;

public class DelStudent {

    public static void delStudent(){
        System.out.println("Delete student>>");
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
        System.out.println("Enter last name");
        String lastName = scanner.nextLine();
        boolean existStudent = false;
        for(Student i:faculty.getStudents()){
            if(i.getLastName().equals(lastName)){
                System.out.println("This is needful student? (y/n)");
                System.out.printf("   %-30s %-30s %-30s %-30s%n", "First name", "Last name", "Course", "Average score");
                System.out.printf(1+") %-30s %-35s %-18s %20.2f%n", i.getFirstName(), i.getLastName(),
                        i.getCourse(), i.getAverageScore());
                if(scanner.nextLine().equals("y")){
                    faculty.delStudent(i);
                    existStudent = true;
                    break;
                }
            }
        }
        if(!existStudent){
            System.out.println("This student isn't exist");
        } else {
            System.out.println("Done");
        }
    }

}

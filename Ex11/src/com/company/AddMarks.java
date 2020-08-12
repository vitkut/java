package com.company;

import java.util.Scanner;

public class AddMarks {

    public static void add(){
        System.out.println("Add marks>>");
        Scanner scanner = new Scanner(System.in);
        Student needfulStudent = new Student();
        System.out.println("Enter last name of student:");
        String lastName = scanner.nextLine();
        boolean existStudent = false;
        for(University i:Main.getUniversities()){
            for (Faculty j:i.getFaculties()){
                for(Student s:j.getStudents()){
                    if(s.getLastName().equals(lastName)){
                        System.out.println("This is needful student? (y/n)");
                        System.out.printf("   %-30s %-30s %-30s %-30s%n", "First name", "Last name", "Course", "Average score");
                        System.out.printf(1+") %-30s %-35s %-18s %20.2f%n", s.getFirstName(), s.getLastName(),
                                s.getCourse(), s.getAverageScore());
                        if(scanner.nextLine().equals("y")){
                            needfulStudent = s;
                            existStudent = true;
                            break;
                        }
                    }
                }

            }
        }

        if(!existStudent){
            System.out.println("This student isn't exist");
            return;
        }
        System.out.println("Enter marks: (Example: 1 5 6 3 7 4[Enter])");
        String[] score = scanner.nextLine().split(" ");
        for(String s:score){
            if(Integer.parseInt(s) > 10 || Integer.parseInt(s) < 1){
                System.out.println("Wrong marks!");
                return;
            } else{
                needfulStudent.addScore(Integer.parseInt(s));
            }
        }
        System.out.println("Done");
    }

}

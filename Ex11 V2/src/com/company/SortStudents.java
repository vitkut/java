package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class SortStudents {

    public static void sort(){
        System.out.println("Sort student>>");
        System.out.println("Sort students by name(1) or by average score min-max(2) or max-min(3) or not sort(4)? (1/2/3/4)");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> allStudents = new ArrayList<>();
        switch (scanner.nextInt()){
            case 1:{
                System.out.println("Sorted by name");
                allStudents = SortName.sort();
                break;
            }
            case 2:{
                System.out.println("Sorted by average score min-max");
                allStudents = SortAverageScoreMinMax.sort();
                break;
            }
            case 3:{
                System.out.println("Sorted by average score max-min");
                allStudents = SortAverageScoreMaxMin.sort();
                break;
            }
            case 4:{
                System.out.println("Not sorted");
                allStudents = GetAllStudents.getAll();
                break;
            }
        }
        scanner.nextLine();

        System.out.printf("   %-30s %-30s %-30s %-30s%n", "First name", "Last name", "Course", "Average score");
        for(int k = 0; k < allStudents.size(); k++){
            Student student = allStudents.get(k);
            System.out.printf(k+1+") %-30s %-35s %-18s %20.2f%n", student.getFirstName(), student.getLastName(),
                    student.getCourse(), student.getAverageScore());
        }
        System.out.println();
    }

}

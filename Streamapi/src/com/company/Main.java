package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        GetDatabase.getDatabase();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\n\t<<Menu>>");
            System.out.println("1. Sort\n2. Min salary\n3. Max salary\n4. Group by specialization\n5. Salary check");

            switch (scanner.nextInt()){
                case 1:{
                    Sort.sort(persons.stream());
                    break;
                }
                case 2:{
                    MinSalary.printMinSalary(persons.stream());
                    break;
                }
                case 3:{
                    MaxSalary.printMaxSalary(persons.stream());
                    break;
                }
                case 4:{
                    GroupBySpecialization.group();
                    break;
                }
                case 5:{
                    CheckSalary.check(persons.stream());
                    break;
                }
                default:{
                    System.out.println("Unknown command!");
                }
            }
            System.out.println("Stop? (y/n)");
            scanner.nextLine();
            if(scanner.nextLine().equals("y")){
                break;
            }
        }

    }



}

package com.company;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sort {

    public static void sort(Stream<Person> personStream){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sort by\n1. First name\n2. Last name\n3. Year of birth\n4. Salary\n5. Specialization");
        switch (scanner.nextInt()){
            case 1:{
                System.out.println(personStream.sorted((o1, o2) ->
                        o1.getFirstName().compareTo(o2.getFirstName())).collect(Collectors.toList()));
                break;
            }
            case 2:{
                System.out.println(personStream.sorted((o1, o2) ->
                        o1.getLastName().compareTo(o2.getLastName())).collect(Collectors.toList()));
                break;
            }
            case 3:{
                System.out.println(personStream.sorted((o1, o2) ->
                        o1.toInteger(o1.getYearOfBirth()).compareTo(o2.toInteger(o2.getYearOfBirth()))).collect(Collectors.toList()));
                break;
            }
            case 4:{
                System.out.println(personStream.sorted((o1, o2) ->
                        o1.toInteger(o1.getSalary()).compareTo(o2.toInteger(o2.getSalary()))).collect(Collectors.toList()));
                break;
            }
            case 5:{
                System.out.println(personStream.sorted((o1, o2) ->
                        o1.getSpecialization().compareTo(o2.getSpecialization())).collect(Collectors.toList()));
                break;
            }
            default:{
                System.out.println("Unknown command!");
            }
        }
    }
}

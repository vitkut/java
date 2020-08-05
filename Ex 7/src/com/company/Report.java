package com.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Report {

    public static void generateReport(ArrayList<Person> workers){
        sortReport(workers);
        for (Person i:workers){
            System.out.printf("%-30s %20.2f%n", i.getFullname(), i.getSalary());
        }


    }

    private static void sortReport(ArrayList<Person> workers){
        workers.sort(new PersonComparator());
    }
}

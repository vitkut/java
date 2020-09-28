package com.company;

import java.util.Scanner;
import java.util.stream.Stream;

public class CheckSalary {

    public static void check(Stream<Person> personStream){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter checked salary:");
        int checkedSalary = scanner.nextInt();
        if(personStream.allMatch((o) -> o.getSalary()>checkedSalary)){
            System.out.println("All persons have more higher salary than "+checkedSalary);
        } else {
            System.out.println("Not all persons have more higher salary than "+checkedSalary);
        }
    }
}

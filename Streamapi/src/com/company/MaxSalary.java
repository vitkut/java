package com.company;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class MaxSalary {

    public static void printMaxSalary(Stream<Person> personStream){
        System.out.println("Max salary = "+personStream.max(Comparator.comparing(Person::getSalary)).orElseThrow(NoSuchElementException::new));

    }
}

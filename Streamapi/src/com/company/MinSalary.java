package com.company;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class MinSalary {

    public static void printMinSalary(Stream<Person> personStream){
        System.out.println("Min salary = "+personStream.min(Comparator.comparing(Person::getSalary)).orElseThrow(NoSuchElementException::new));

    }

}

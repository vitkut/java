package com.company;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    public int compare(Person p1, Person p2){
        if(p1.getSalary() > p2.getSalary()){
            return 1;
        }
        if(p1.getSalary() < p2.getSalary()){
            return -1;
        }
        return 0;
    }
}

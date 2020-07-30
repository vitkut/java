package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Report.generateReport(createDataBase());
    }

    public static ArrayList<Person> createDataBase(){
        Person person1 = new Person("Peter Daniel", 1024.391f);
        Person person2 = new Person("Jack Preston", 1002.809f);
        Person person3 = new Person("Matthew Griffin", 965.497f);
        Person person4 = new Person("Blake Lucas", 1018.73f);
        Person person5 = new Person("Olivia Pitts", 1264.656f);
        Person person6 = new Person("Felicity Marsh", 1369.983f);
        Person person7 = new Person("Maude Blankenship", 920.525f);

        ArrayList<Person> workers = new ArrayList<>();
        workers.add(person1);
        workers.add(person2);
        workers.add(person3);
        workers.add(person4);
        workers.add(person5);
        workers.add(person6);
        workers.add(person7);
        return workers;
    }
}

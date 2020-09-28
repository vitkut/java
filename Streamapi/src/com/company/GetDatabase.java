package com.company;

public class GetDatabase {

    public static void getDatabase(){
        Main.persons.add(new Person("Nick", "Jonson", 2000, 1500, "Doctor"));
        Main.persons.add(new Person("Tom", "Devil", 1998, 1000, "Teacher"));
        Main.persons.add(new Person("Kim", "Jo", 2001, 1200, "Boxer"));
        Main.persons.add(new Person("Anna", "Filter", 1989, 2000, "Doctor"));
        Main.persons.add(new Person("Boris", "Oreshkin", 1985, 1000, "Blogger"));
    }

}

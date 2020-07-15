package com.company;

public class User {

    private String firstName;
    private String lastName;
    private int age;

    public User(){
        setFirstName("-");
        setLastName("-");
        setAge(99);
    }

    public User(String firstName, String lastName, int age){
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            System.out.println("Wrong age! Try again.");
        }
    }

    public void method(){
        System.out.println("User::Method");
    }

}

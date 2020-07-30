package com.company;

public class Person {

    private String fullname;
    private float salary;

    public Person(){

    }

    public Person(String fullname, float salary){
        setFullname(fullname);
        setSalary(salary);
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public String getFullname() {
        return fullname;
    }

}

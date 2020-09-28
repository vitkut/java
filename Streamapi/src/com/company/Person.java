package com.company;

public class Person {

    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private int salary;
    private String specialization;

    public Person(String firstName, String lastName, int yearOfBirth, int salary, String specialization){
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.salary = salary;
        this.specialization = specialization;
    }

    @Override
    public String toString(){
        return "\n{\n firstName = "+firstName+",\n lastName = "+lastName+",\n yearOfBirth = "+yearOfBirth
                +",\n salary = "+salary+",\n specialization = "+specialization+"\n}";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public Integer toInteger(int integer){
        return new Integer(integer);
    }

    public int getSalary() {
        return salary;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}

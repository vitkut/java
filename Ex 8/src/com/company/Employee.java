package com.company;

public class Employee {

    private String firstName;
    private String lastName;
    private String workingPosition;
    private int salary;

    public Employee(){

    }

    public Employee(String firstName, String lastName, String workingPosition, int salary){
        setFirstName(firstName);
        setLastName(lastName);
        setWorkingPosition(workingPosition);
        setSalary(salary);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setWorkingPosition(String workingPosition) {
        this.workingPosition = workingPosition;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getWorkingPosition() {
        return workingPosition;
    }

    public int getSalary() {
        return salary;
    }
}

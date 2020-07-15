package com.company;

public class Admin extends User {

    private String specialty;

    public Admin(){
        super();
        setSpecialty("-");
    }

    public Admin(String firstName, String lastName, int age, String specialty){
        super(firstName, lastName, age);
        setSpecialty(specialty);
    }

    public String getSpecialty(){
        return specialty;
    }

    public void setSpecialty(String specialty){
        this.specialty = specialty;
    }

    @Override
    public void method(){
        System.out.println("Admin::Method");
    }

    public void methodAdmin(){
        System.out.println("method::Admin");
    }

}

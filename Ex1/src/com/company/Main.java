package com.company;

public class Main {

    public static void main(String[] args) {
        User user1 = new User();
        outUser(user1);
        User user2 = new User("name", "lastname", 15);
        outUser(user2);
        Admin admin = new Admin("name", "lastname", 20, "specialty");
        outAdmin(admin);
        user2.method();
        admin.method();
        admin.methodAdmin();
        User admin1 = new Admin();
        admin1.method();
        ((Admin) admin1).methodAdmin();
    }

    private static void outUser(User user){
        System.out.println("===User===");
        System.out.println("First name: " + user.getFirstName());
        System.out.println("Last name: " + user.getLastName());
        System.out.println("Age: " + user.getAge()+"\n");
    }

    private static void outAdmin(Admin admin){
        System.out.println("===Admin===");
        System.out.println("First name: " + admin.getFirstName());
        System.out.println("Last name: " + admin.getLastName());
        System.out.println("Age: " + admin.getAge());
        System.out.println("Specialty: " + admin.getSpecialty()+"\n");
    }

}

package com.company;

import java.io.File;
import java.util.Scanner;

public class Menu {

    File file = new File("file.txt");

    public void menu(){
        System.out.println("<Menu>");
        System.out.println("1. Write employee to file");
        System.out.println("2. Read employee from file");
        System.out.println("0. Exit");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        scanner.nextLine();
        switch (key){
            case 0:{
                System.exit(0);
            }
            case 1:{
                EmployeeWriter employeeWriter = new EmployeeWriter();
                employeeWriter.employeeWriter(file);
                break;
            }
            case 2:{
                EmployeeReader employeeReader = new EmployeeReader();
                employeeReader.employeeReader(file);
            }
        }
        menu();
    }
}

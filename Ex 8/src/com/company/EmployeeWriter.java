package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeWriter {

    public void employeeWriter(File file){
        Scanner scanner = new Scanner(System.in);
        StringBuffer dataBase = deleter(file);
        file.delete();
        System.out.println("Employee>");
        Employee newEmployee = new Employee();
        System.out.println("First name:");
        newEmployee.setFirstName(scanner.nextLine());
        System.out.println("Last name:");
        newEmployee.setLastName(scanner.nextLine());
        System.out.println("Working position:");
        newEmployee.setWorkingPosition(scanner.nextLine());
        System.out.println("Salary:");
        newEmployee.setSalary(scanner.nextInt());
        scanner.nextLine();
        try(FileWriter fileWriter = new FileWriter(file, false)){
            fileWriter.write(dataBase+newEmployee.getLastName()+", "+newEmployee.getFirstName()
                    +", "+newEmployee.getWorkingPosition()+": "+newEmployee.getSalary()+".\n");
            fileWriter.flush();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private StringBuffer deleter(File file){
        StringBuffer dataBase = new StringBuffer();
        dataBase.ensureCapacity(256);
        try(FileReader fileReader = new FileReader(file)){
            Scanner fileScanner = new Scanner(fileReader);
            while (fileScanner.hasNextLine()){
                dataBase.append(fileScanner.nextLine());
                dataBase.append("\n");
            }
            dataBase.replace(dataBase.length()-2, dataBase.length(), ";\n");
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        return dataBase;
    }
}

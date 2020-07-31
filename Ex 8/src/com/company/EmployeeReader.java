package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeReader {

    public void employeeReader(File file){
        System.out.println("<Reading employees>");
        ArrayList<Employee> emloyeeArrayList = new ArrayList<>();
        try(FileReader fileReader = new FileReader(file)){
            StringBuffer stringBuffer = new StringBuffer();
            Scanner fileScanner = new Scanner(fileReader);
            while (fileScanner.hasNextLine()){
                stringBuffer.replace(0, stringBuffer.length(), fileScanner.nextLine());
                Employee employee = employeeRecognizer(stringBuffer);
                emloyeeArrayList.add(employee);
            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        } finally {
            viewEmployees(emloyeeArrayList);
        }
    }

    private Employee employeeRecognizer(StringBuffer stringBuffer){
        Employee employee = new Employee();
        int lastNameNumber = 0;
        while (stringBuffer.charAt(lastNameNumber) != ','){
            lastNameNumber++;
        }
        employee.setLastName(stringBuffer.substring(0, lastNameNumber));
        int firstNameNumber = lastNameNumber+2;
        while (stringBuffer.charAt(firstNameNumber) != ','){
            firstNameNumber++;
        }
        employee.setFirstName(stringBuffer.substring(lastNameNumber+2, firstNameNumber));
        int workingPositionNumber = firstNameNumber+2;
        while (stringBuffer.charAt(workingPositionNumber) != ':'){
            workingPositionNumber++;
        }
        employee.setWorkingPosition(stringBuffer.substring(firstNameNumber+2, workingPositionNumber));
        int salaryNumber = workingPositionNumber+2;
        while (stringBuffer.charAt(salaryNumber) != ';'){
            if(stringBuffer.charAt(salaryNumber) == '.'){
                break;
            }
            salaryNumber++;
        }
        employee.setSalary(Integer.parseInt(stringBuffer.substring(workingPositionNumber+2, salaryNumber)));
        stringBuffer.delete(0, stringBuffer.length());
        return employee;
    }

    private void viewEmployees(ArrayList<Employee> employeeArrayList){
        for (Employee i:employeeArrayList){
            if (i.equals(employeeArrayList.get(employeeArrayList.size()-1))){
                System.out.println(i.getFirstName()+", "+i.getLastName()+", "+i.getWorkingPosition()+": "+i.getSalary()+".");
            } else {
                System.out.println(i.getFirstName()+", "+i.getLastName()+", "+i.getWorkingPosition()+": "+i.getSalary()+";");
            }
        }
    }
}

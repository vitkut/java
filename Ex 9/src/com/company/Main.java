package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Logs.start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter mobile number:");
        boolean correctMobileNumber = MobileChecker.checkMobile(scanner.nextLine());
        System.out.println(correctMobileNumber);
        System.out.println("Enter home phone number:");
        boolean correctHomePhoneNumber = HomePhoneChecker.checkHomePhone(scanner.nextLine());
        System.out.println(correctHomePhoneNumber);
        System.out.println("Enter email:");
        boolean correctEmail = EmailChecker.checkEmail(scanner.nextLine());
        System.out.println(correctEmail);
        System.out.println("Is work of program successful? (y/n)");
        boolean isSuccessful = false;
        if (scanner.next().equals("y")){
            isSuccessful = true;
        }
        Logs.finish(isSuccessful);
    }
}

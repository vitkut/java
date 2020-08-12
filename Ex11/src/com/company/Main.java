package com.company;

import java.util.ArrayList;

public class Main {

    private static ArrayList<University> universities = new ArrayList<>();

    public static void main(String[] args) {
        GetDataBase.get();
        System.out.println("(To read help message enter /help)");
        Menu.menu();
    }

    public static ArrayList<University> getUniversities() {
        return universities;
    }

    public static void setUniversities(ArrayList<University> universities) {
        Main.universities = universities;
    }
}

package com.company;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.getDataBase();
        Gui.user = Menu.getUser(0);
        Gui.startFromMain();
    }


}

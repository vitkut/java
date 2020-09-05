package com.company;

import java.util.Date;

public class Main {

    public static int count = 0;

    public static void main(String[] args) {
        System.out.println("Count at start = "+count);
        Adder firstStream = new Adder();
        Adder secondStream = new Adder();

        firstStream.start();
        secondStream.start();

        try{
            firstStream.join();
            secondStream.join();
        } catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("Count at finish = "+count);
    }
}

package com.company;

public class Adder extends Thread {

    @Override
    public void run(){

        Main.count += 100_000;
        System.out.println(getName()+" is done");
    }
}

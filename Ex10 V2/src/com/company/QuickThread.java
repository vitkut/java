package com.company;

public class QuickThread extends Thread {

    @Override
    public void run(){
        QuickSort.input(Main.strings);
    }
}

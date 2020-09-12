package com.company;

public class BubbleThread extends Thread {

    @Override
    public void run(){
        BubbleSort.sort(Main.strings);
    }
}

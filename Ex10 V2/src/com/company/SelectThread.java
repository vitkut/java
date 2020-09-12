package com.company;

public class SelectThread extends Thread {

    @Override
    public void run(){
        SelectSort.sort(Main.strings);
    }
}

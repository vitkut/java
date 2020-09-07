package com.company;

public class StateOfThreads {

    private static int countOfWorkingThreads = 0;

    public synchronized void increment(){
        countOfWorkingThreads++;
    }

    public synchronized void decrement(){
        countOfWorkingThreads--;
    }

    public synchronized int getCountOfWorkingThreads(){
        return countOfWorkingThreads;
    }

}

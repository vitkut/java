package com.company;

public class MacBook extends NoteBook {

    public MacBook(){
        super(1000);
    }

    @Override
    public void launch(){
        System.out.println("Mac is launched");
    }

    public void methodMacBook(){
        int price = getPrice();
        System.out.println("My price is " + price);
    }

}

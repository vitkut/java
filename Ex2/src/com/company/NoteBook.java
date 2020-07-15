package com.company;

public abstract class NoteBook {

    private int price;

    public NoteBook(){
        setPrice(0);
    }

    public NoteBook(int price){
        setPrice(price);
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public abstract void launch();

    public void shutDown(){
        System.out.println("Shut Down...");
    }

}

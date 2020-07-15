package com.company;

public class PixelBook extends NoteBook {

    public PixelBook(){
        super(200);
    }

    @Override
    public void launch(){
        System.out.println("Pix is launched");
    }

    public void methodPixelBook(){
        int price = getPrice();
        System.out.println("My price is " + price);
    }

}

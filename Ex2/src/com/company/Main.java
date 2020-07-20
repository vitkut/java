package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MacBook mac = new MacBook();
        PixelBook pix = new PixelBook();
        ArrayList<NoteBook> noteBookArrayList = new ArrayList<>();
        noteBookArrayList.add(mac);
        noteBookArrayList.add(pix);

        for(NoteBook iterator:noteBookArrayList){
            method(iterator);
        }
    }

    public static void method(NoteBook noteBook){
        noteBook.launch();
        noteBook.shutDown();
    }

}

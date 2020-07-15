package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MacBook mac = new MacBook();
        PixelBook pix = new PixelBook();
        ArrayList<NoteBook> noteBookArrayList = new ArrayList<>();
        noteBookArrayList.add(mac);
        noteBookArrayList.add(pix);
        method(noteBookArrayList.get(0));
        mac.methodMacBook();
        method(noteBookArrayList.get(1));
        pix.methodPixelBook();
    }

    public static void method(NoteBook noteBook){
        noteBook.launch();
        noteBook.shutDown();
    }

}

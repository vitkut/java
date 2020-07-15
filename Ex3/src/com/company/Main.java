package com.company;

public class Main {

    public static void main(String[] args) {
        Jet jet = new Jet();
        Helicopter helicopter = new Helicopter();
        jet.fly();
        helicopter.fly();
        method(jet);
        method(helicopter);
    }

    public static void method(Jet jet){
        jet.fly();
    }

    public static void method(Helicopter helicopter){
        helicopter.fly();
    }

}

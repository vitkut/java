package com.company;

public class Laptop extends Device {

    private int weight;

    public Laptop(){
        super();
        setWeight(0);
    }

    public Laptop(String name, int price, String country, int weight){
        super(name, price, country);
        setWeight(weight);
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}

package com.company;

import java.util.ArrayList;

public class Category {

    private String name;
    private ArrayList<Device> devises;

    public Category(){

    }

    public Category(String name, ArrayList<Device> devices){
        setName(name);
        setDevises(devices);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDevises(ArrayList<Device> devises) {
        this.devises = devises;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Device> getDevises() {
        return devises;
    }

    public  void addDevises(Device device) { this.devises.add(device); }
}

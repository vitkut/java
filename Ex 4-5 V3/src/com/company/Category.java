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

    public Category(String name){
        setName(name);
        devises = new ArrayList<>();
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

    public  void addDevises(Device device) {
        boolean bool = false;
        for(Device i:devises){
            if(!i.equals(device)){
                bool = true;
                break;
            }
        }
        if(!bool){
            this.devises.add(device);
        }
    }
}

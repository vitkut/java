package com.company;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Device> devices = new ArrayList<>();
    private ArrayList<Category> categories = new ArrayList<>();

    public void setDevices(ArrayList<Device> devices) {
        this.devices = devices;
    }

    public void addCategories(Category category) {
        for (Category i:categories){
            if (i.equals(category)){
                this.categories.add(category);
            }
        }
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void addDevice(Device device) {
        for (Device i:devices){
            if (i.equals(device)){
                this.devices.add(device);
            }
        }
    }
}

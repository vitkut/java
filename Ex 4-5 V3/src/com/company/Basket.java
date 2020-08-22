package com.company;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Device> devices = new ArrayList<>();
    private ArrayList<Category> categories = new ArrayList<>();

    public void setDevices(ArrayList<Device> devices) {
        this.devices = devices;
    }

    public void addCategories(Category category) {
        boolean bool = false;
        for (Category i:categories){
            if (i.equals(category)){
                bool = true;
                break;
            }
        }
        if(!bool){
            this.categories.add(category);
        }
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void addDevice(Device device) {
        boolean bool = false;
        for (Device i:devices){
            if (i.equals(device)){
                bool = true;
                break;
            }
        }
        if(!bool){
            this.devices.add(device);
        }
    }

    public void delDevice(Device device){
        this.devices.remove(device);
    }

    public void delCategory(Category category){
        this.categories.remove(category);
    }
}

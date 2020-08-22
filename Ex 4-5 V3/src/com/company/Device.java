package com.company;

public class Device {

    private String name;
    private int price;
    private String country;

    public Device(){
        setName("-");
        setPrice(9999);
        setCountry("-");
    }

    public Device(String name, int price, String country){
        setName(name);
        setPrice(price);
        setCountry(country);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCountry() {
        return country;
    }

    public void setInternetConnection(boolean internetConnection){}

    public boolean getInternetConnection() { return false; }

    public void setWeight(int weight) {    }

    public int getWeight() {
        return 0;
    }

    public void setCpu(String cpu) {    }

    public void setGpu(String gpu) {    }

    public void setRam(String ram){    }

    public String getCpu() {
        return "";
    }

    public String getGpu() {
        return "";
    }

    public String getRam() {
        return "";
    }

}

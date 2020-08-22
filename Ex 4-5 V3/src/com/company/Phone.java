package com.company;

public class Phone extends Device {

    private boolean internetConnection;

    public Phone(){
        super();
        setInternetConnection(false);
    }

    public Phone(String name, int price, String country, boolean internetConnection){
        super(name, price, country);
        setInternetConnection(internetConnection);
    }

    @Override
    public void setInternetConnection(boolean internetConection) {
        this.internetConnection = internetConection;
    }

    @Override
    public boolean getInternetConnection(){
        return internetConnection;
    }
}

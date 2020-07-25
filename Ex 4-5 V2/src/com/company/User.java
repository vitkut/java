package com.company;

public class User {

    private int id;
    private static int numOfUsers = 0;
    private String username;
    private String password;
    private Basket basket = new Basket();

    public User(){

    }

    public User(String username, String password){
        setId(numOfUsers);
        setUsername(username);
        setPassword(password);
        numOfUsers++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Basket getBasket() {
        return basket;
    }

    public void addBasket(Device device) { this.basket.addDevice(device); }

    public void addBasket(Category category) { this.basket.addCategories(category);}

}

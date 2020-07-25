package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Category> phones = new ArrayList<>();
    private ArrayList<Category> laptops = new ArrayList<>();
    private ArrayList<Category> computers = new ArrayList<>();

    public void start(){
        System.out.println("Do you registered? (y/n)");
        User user;
        if (scanner.next().equals("y")){
            user = login();
        } else {
            user = register();
            userList.add(user);
        }
        do {
            System.out.println("=============");
            System.out.println("Welcome!");
            System.out.println("1. Add new device");
            System.out.println("2. Add new category");
            System.out.println("3. Add device to category");
            System.out.println("4. Buy device");
            System.out.println("5. View basket");
            System.out.println("6. View users");
            System.out.println("7. Restart");
            System.out.println("8. Test");
            System.out.println("0. Exit");
            System.out.println("=============");
            switch (scanner.nextInt()){
                case 0:{
                    System.exit(0);
                    break;
                }
                case 1:{
                    addNewDevice();
                    break;
                }
                case 2:{
                    addNewCategory();
                    break;
                }
                case 3:{
                    addDeviceToCategory();
                    break;
                }
                case 4:{
                    buyDevice(user);
                    break;
                }
                case 5:{
                    viewBasket(user);
                    break;
                }
                case 6:{
                    viewUsers();
                    break;
                }
                case 7:{
                    start();
                    break;

                }
                case 8:{
                    test();
                    break;
                }
            }
        } while (true);
    }

    public void getDataBase(){
        Device iphoneX = new Phone("Iphone X", 1000, "USA", true);
        Device xiaomi5 = new Phone("Xiaomi 5", 300, "China", true);
        Device nokia3310 = new Phone("Nokia 3310", 20, "Finland", false);
        Device philipsE109 = new Phone("Philips E109", 20, "China", true);
        Device dellRed = new Laptop("Dell red", 900, "China", 1000);
        Device dellBlue = new Laptop("Dell blue", 900, "China", 1000);
        Device hpRed = new Laptop("HP red", 500, "China", 800);
        Device hpBlue = new Laptop("HP blue", 500, "China", 800);
        Device intel = new Computer("Intel", 600, "USA", "IntelCore i5", "NVidia GTX 1050", "8 GB");
        Device amd = new Computer("AMD", 600, "USA", "AMD Ryzen 5", "AMD Radeon RX570X", "8 GB");

        ArrayList<Device> smartphonesList = new ArrayList<>();
        smartphonesList.add(iphoneX);
        smartphonesList.add(xiaomi5);

        ArrayList<Device> cellPhonesList = new ArrayList<>();
        cellPhonesList.add(nokia3310);
        cellPhonesList.add(philipsE109);

        ArrayList<Device> redLaptposList = new ArrayList<>();
        redLaptposList.add(dellRed);
        redLaptposList.add(hpRed);

        ArrayList<Device> blueLaptopsList = new ArrayList<>();
        blueLaptopsList.add(dellBlue);
        blueLaptopsList.add(hpBlue);

        ArrayList<Device> personalComputersList = new ArrayList<>();
        personalComputersList.add(intel);
        personalComputersList.add(amd);

        Category smartphone = new Category("Smatrphones", smartphonesList);
        Category cellPhone = new Category("Cell phones", cellPhonesList);
        Category redLaptop = new Category("Red laptops", redLaptposList);
        Category blueLaptop = new Category("Blue laptops", blueLaptopsList);
        Category personalComputer = new Category("Personal computers", personalComputersList);

        this.phones = new ArrayList<>();
        this.laptops = new ArrayList<>();
        this.computers = new ArrayList<>();

        phones.add(smartphone);
        phones.add(cellPhone);
        laptops.add(redLaptop);
        laptops.add(blueLaptop);
        computers.add(personalComputer);

        User user = new User("vit", "kut");
        userList.add(user);
    }

    private void addNewDevice(){

        System.out.println("-----------");
        System.out.println("Chose category:");
        String nameCategory = nameCategories();
        ArrayList<Category> categoryDevise = getCategories(nameCategory);
        ArrayList<Device> deviceList = getDeviceList(categoryDevise);
        System.out.println("--------");
        scanner.nextLine();
        System.out.println("Enter device name:");
        String name = scanner.nextLine();
        System.out.println("Enter device price:");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter device country: ");
        String country = scanner.nextLine();
        if (nameCategory.equals("Phones")){
            System.out.println("Internet connection (y/n):");
            if (scanner.next().equals("y")){
                Device phone = new Phone(name, price, country, true);
                deviceList.add(phone);
            } else {
                Device phone = new Phone(name, price, country, false);
                deviceList.add(phone);
            }
        }
        if (nameCategory.equals("Laptops")){
            System.out.println("Enter weight: ");
            int weight = scanner.nextInt();
            System.out.println();
            Device laptop = new Laptop(name, price, country, weight);
            deviceList.add(laptop);
        }
        if (nameCategory.equals("Computers")){
            scanner.nextLine();
            System.out.println("Enter CPU:");
            String cpu = scanner.nextLine();
            System.out.println("Enter GPU:");
            String gpu = scanner.nextLine();
            System.out.println("Enter RAM:");
            String ram = scanner.nextLine();
            Device computer = new Computer(name, price, country, cpu, gpu, ram);
            deviceList.add(computer);
        }
        System.out.println("Done\n---------");
    }

    private void addNewCategory(){
        ArrayList<Category> categories = getCategories();
        System.out.println("----------");
        System.out.println("Enter name of new category:");
        scanner.nextLine();
        String nameCategory = scanner.nextLine();
        ArrayList<Device> devices = new ArrayList<>();
        Category newCategory = new Category(nameCategory, devices);
        categories.add(newCategory);
        System.out.println("Done\n---------");
    }

    private void addDeviceToCategory(){
        System.out.println("----------");
        System.out.println("Chose device:");
        String nameCategory = nameCategories();
        ArrayList<Category> categories = getCategories(nameCategory);
        ArrayList<Device> devices = getDeviceList(categories);
        Device device = getDevice(devices);
        System.out.println("----------");
        System.out.println("Chose category:");
        ArrayList<Device> newDevices = getDeviceList(categories);
        newDevices.add(device);
        System.out.println("Done\n---------");
    }

    private void buyDevice(User user){
        System.out.println("----------");
        ArrayList<Category> categories = getCategories();
        Category category = getCategory(categories);
        ArrayList<Device> devices = category.getDevises();
        showDeviceList(devices);
        System.out.println("0. Add this category");
        int scanInt = scanner.nextInt()-1;
        if(scanInt == -1){
            Category basketCategory = category;
            user.addBasket(basketCategory);
        } else {
            Device device = devices.get(scanInt);
            showDevice(device);
            user.addBasket(device);
        }
        System.out.println("Done\n----------");
    }

    private void viewBasket(User user){
        System.out.println("----------");
        System.out.println("Your basket:");
        Basket basket = user.getBasket();
        if(basket.getDevices().size() != 0){
            System.out.println("Devices: ");
            ArrayList<Device> devices = basket.getDevices();
            for(Device i:devices){
                showDevice(i);
            }
        } else {
            System.out.println("Devices is empty");
        }
        if(basket.getCategories().size() != 0){
            System.out.println("Categories: ");
            ArrayList<Category> categories = basket.getCategories();
            for (Category i:categories){
                System.out.println(i.getName() + ": ");
                showDeviceList(i.getDevises());
            }
        } else {
            System.out.println("Categories is empty");
        }
        System.out.println("Done\n----------");
    }

    private void viewUsers(){
        System.out.println("----------");
        System.out.println("Users: ");
        for(User i:userList){
            System.out.println("Id: " + i.getId() + " Username: " + i.getUsername());
        }
        System.out.println("Done\n----------");
    }

    private String nameCategories(){
        System.out.println("-----------");
        System.out.println("1. Phones\n2. Laptops\n3. Computers");
        switch (scanner.nextInt()){
            case 1:{
                return "Phones";
            }
            case 2:{
                return "Laptops";
            }
            case 3:{
                return "Computers";
            }
        }
        return "";
    }

    private ArrayList<Category> getCategories(){
        switch (nameCategories()){
            case "Phones":{
                return phones;
            }
            case "Laptops":{
                return laptops;
            }
            case "Computers":{
                return computers;
            }
        }
        ArrayList<Category> newList = new ArrayList<>();
        return newList;
    }

    private ArrayList<Category> getCategories(String nameCategories){
        switch (nameCategories){
            case "Phones":{
                return phones;
            }
            case "Laptops":{
                return laptops;
            }
            case "Computers":{
                return computers;
            }
        }
        ArrayList<Category> newList = new ArrayList<>();
        return newList;
    }

    private ArrayList<Device> getDeviceList(ArrayList<Category> categoryDevice){
        System.out.println("----------");
        for(int i = 0; i < categoryDevice.size(); i++){
            System.out.println(i+1 + ". " + categoryDevice.get(i).getName());
        }
        return categoryDevice.get(scanner.nextInt()-1).getDevises();
    }

    private Category getCategory(ArrayList<Category> categories){
        System.out.println("----------");
        for(int i = 0; i < categories.size(); i++){
            System.out.println(i+1 + ". " + categories.get(i).getName());
        }
        return categories.get(scanner.nextInt()-1);
    }

    private void showDeviceList(ArrayList<Device> deviceList){
        for (int i = 0; i < deviceList.size(); i++){
            System.out.println(i+1 + ". " + deviceList.get(i).getName());
        }
    }

    private Device getDevice(ArrayList<Device> deviceList){
        for (int i = 0; i < deviceList.size(); i++){
            System.out.println(i+1 + ". " + deviceList.get(i).getName());
        }
        return deviceList.get(scanner.nextInt()-1);
    }

    private void showDevice(Device device){
        System.out.print("Device> Name: " + device.getName() + " Price: " + device.getPrice() + " Country: " + device.getCountry());
        if (device instanceof Phone){
            System.out.print(" Internet connection: " + device.getInternetConnection());
        }
        if (device instanceof Laptop){
            System.out.print(" Weight: " + device.getWeight());
        }
        if (device instanceof Computer){
            System.out.print(" CPU: " + device.getCpu() + " GPU: " + device.getGpu() + " RAM: " + device.getRam());
        }
        System.out.println(" ");
    }

    private void test(){
        System.out.println("<Test>");

        System.out.println("1.Phones");
        for(int i = 0; i < phones.size(); i++){
            System.out.println(i+1 + ". " + phones.get(i).getName());
            System.out.println("---");
            showDeviceList(phones.get(i).getDevises());
            for (Device device:phones.get(i).getDevises()){
                showDevice(device);
            }
            System.out.println("---");
        }
        System.out.println("***");
        System.out.println("2.Laptops");
        for(int i = 0; i < laptops.size(); i++){
            System.out.println(i+1 + ". " + laptops.get(i).getName());
            System.out.println("---");
            showDeviceList(laptops.get(i).getDevises());
            for (Device device:laptops.get(i).getDevises()){
                showDevice(device);
            }
            System.out.println("---");
        }
        System.out.println("***");
        System.out.println("3.Computers");
        for(int i = 0; i < computers.size(); i++){
            System.out.println(i+1 + ". " + computers.get(i).getName());
            System.out.println("---");
            showDeviceList(computers.get(i).getDevises());
            for (Device device:computers.get(i).getDevises()){
                showDevice(device);
            }
            System.out.println("---");
        }
        System.out.println("Users:");
        for(User i:userList){
            System.out.println("Id: " + i.getId() + " Username: " + i.getUsername() + " Password: " + i.getPassword());
            viewBasket(i);
        }
        System.out.println("***");
    }

    private User login(){
        System.out.println("Enter username:");
        scanner.nextLine();
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        try{
            int id = confirmLog(username, password);
            if (id != -1){
                User user = userList.get(id);
                return user;
            } else {
                System.out.println("Try again");
            }
        } catch (WrongUsernameException | WrongPasswordException ex){
            System.out.println("Try again");
        }
        start();
        User user = new User();
        return user;
    }

    private User register(){
        System.out.println("Enter username:");
        scanner.nextLine();
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        System.out.println("Confirm password:");
        String confirmPassword = scanner.nextLine();
        try{
            boolean bool = confirmReg(username, password, confirmPassword);
            if(bool){
                User user = new User(username, password);
                return user;
            }
        } catch (WrongUsernameException | WrongPasswordException ex){
            System.out.println("Try again");
        }
        start();
        User user = new User();
        return user;
    }

    private int confirmLog(String username, String password) throws WrongUsernameException, WrongPasswordException{
        try{
            for (User i:userList){
                if (username.equals(i.getUsername())){
                    try{
                        if(password.equals(i.getPassword())){
                            return i.getId();
                        } else {
                            throw new WrongPasswordException("Wrong password", "Wrong password");
                        }
                    } catch (WrongPasswordException exc){
                        System.out.println(exc.getParameter());
                    }
                }
            }
            throw new WrongUsernameException("Wrong username", "This user isn't exist");
        } catch (WrongUsernameException ex){
            System.out.println(ex.getParameter());
        }
        return -1;
    }

    private static boolean confirmReg(String username, String password, String confirmPassword) throws WrongUsernameException, WrongPasswordException{
        try{
            if(username.length() > 15){
                throw new WrongUsernameException("Bigger than 15 symb", "Very big username");
            }
            if(username.length() < 5){
                throw new WrongUsernameException("Less than 5 symb", "Very short username");
            }
            boolean bool = Pattern.matches("\\W*", username);
            if(bool){
                throw new WrongUsernameException("Not correct symb", "Not correct symb username");
            }
            try{
                if(password.length() > 25){
                    throw new WrongPasswordException("Bigger than 25 symb", "Very big password");
                }
                boolean bool1 = Pattern.matches("[a-zA-Z]*", password);
                boolean bool2 = Pattern.matches("\\d*", password);
                if(!bool1 && !bool2){
                    throw new WrongPasswordException("Not correct symb", "Not correct symb username");
                }
                if(!confirmPassword.equals(password)){
                    throw new WrongPasswordException("Not correct confirmPassword", "Not correct confirmPassword");
                }
                return true;
            } catch (WrongPasswordException exc){
                System.out.println(exc.getParameter());
            }
        } catch (WrongUsernameException ex) {
            System.out.println(ex.getParameter());
        }
        return false;
    }

}

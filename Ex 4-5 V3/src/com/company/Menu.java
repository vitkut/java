package com.company;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Menu {

    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Category> phones = new ArrayList<>();
    public static ArrayList<Category> laptops = new ArrayList<>();
    public static ArrayList<Category> computers = new ArrayList<>();

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

        phones = new ArrayList<>();
        laptops = new ArrayList<>();
        computers = new ArrayList<>();

        phones.add(smartphone);
        phones.add(cellPhone);
        laptops.add(redLaptop);
        laptops.add(blueLaptop);
        computers.add(personalComputer);

        User user = new User("vit", "kut");
        userList.add(user);
    }

    public static User getUser(int id){
        return userList.get(id);
    }

    public static void addUser(User user){
        userList.add(user);
    }

    public static int confirmLog(String username, String password){
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

    public static String confirmReg(String username, String password, String confirmPassword){
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
                return "";
            } catch (WrongPasswordException exc){
                System.out.println(exc.getParameter());
                return exc.getParameter();
            }
        } catch (WrongUsernameException ex) {
            System.out.println(ex.getParameter());
            return ex.getParameter();
        }
    }

    public static ArrayList<String> getNameOfCategories(ArrayList<Category> categories){
        ArrayList<String> names = new ArrayList<>();
        for(Category i:categories){
            names.add(i.getName());
        }
        return names;
    }

    public static Category getCategoryByName(String name){
        for (Category i:phones){
            if(i.getName().equals(name)){
                return i;
            }
        }
        for (Category i:laptops){
            if(i.getName().equals(name)){
                return i;
            }
        }
        for (Category i:computers){
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }

    public static Device getDeviceByName(String name){
        for(Category i:phones){
            for (Device j:i.getDevises()){
                if(name.equals(j.getName())){
                    return j;
                }
            }
        }
        for(Category i:laptops){
            for (Device j:i.getDevises()){
                if(name.equals(j.getName())){
                    return j;
                }
            }
        }
        for(Category i:computers){
            for (Device j:i.getDevises()){
                if(name.equals(j.getName())){
                    return j;
                }
            }
        }
        return null;
    }

    public static boolean isFromOneCategories(Device device, Category category){
        //return true if device and category from one categories
        //return false if device and category from different categories
        String categoriesOfCategory = "";//Phones || Laptops || Computers
        //for category
        for (Category i:phones){
            if(i.equals(category)){
                categoriesOfCategory = "Phones";
            }
        }
        for (Category i:laptops){
            if(i.equals(category)){
                categoriesOfCategory = "Laptops";
            }
        }
        for (Category i:computers){
            if(i.equals(category)){
                categoriesOfCategory = "Computers";
            }
        }
        String categoriesOfDevice = "";//Phones || Laptops || Computers
        //for device
        for(Category i:phones){
            for (Device j:i.getDevises()){
                if(j.equals(device)){
                    categoriesOfDevice = "Phones";
                }
            }
        }
        for(Category i:laptops){
            for (Device j:i.getDevises()){
                if(j.equals(device)){
                    categoriesOfDevice = "Laptops";
                }
            }
        }
        for(Category i:computers){
            for (Device j:i.getDevises()){
                if(j.equals(device)){
                    categoriesOfDevice = "Computers";
                }
            }
        }
        return categoriesOfCategory.equals(categoriesOfDevice) && !categoriesOfCategory.equals("");
    }

    public static String getCategoriesByDevice(Device device){
        for(Category i:phones){
            for (Device j:i.getDevises()){
                if(j.equals(device)){
                    return "Phone";
                }
            }
        }
        for(Category i:laptops){
            for (Device j:i.getDevises()){
                if(j.equals(device)){
                    return "Laptop";
                }
            }
        }
        for(Category i:computers){
            for (Device j:i.getDevises()){
                if(j.equals(device)){
                    return "Computer";
                }
            }
        }
        return "";
    }
}

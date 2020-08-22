package com.company;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AddNewDevice extends Gui {

    public static void add(GridPane central){

        //messageBox
        Label messageLabel = new Label();
        Button addButton = new Button("Add");


        //categoryBox
        Label categoryLabel = new Label("Chose category:");
        ChoiceBox categoryChoiceBox = new ChoiceBox();
        categoryChoiceBox.setItems(FXCollections.observableArrayList(Menu.getNameOfCategories(Menu.phones)));
        categoryChoiceBox.setValue(Menu.getNameOfCategories(Menu.phones).get(0));

        //nameBox
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();


        //priceBox
        Label priceLabel = new Label("Price:");
        TextField priceField = new TextField();

        //countryBox
        Label countryLabel = new Label("Country:");
        TextField countryField = new TextField();


        //phoneBox
        Label hasInternetConnectionLabel = new Label("Internet:");
        ToggleGroup secondToggleGroup = new ToggleGroup();
        RadioButton trueButton = new RadioButton("Yes");
        RadioButton falseButton = new RadioButton("No");
        trueButton.setToggleGroup(secondToggleGroup);
        falseButton.setToggleGroup(secondToggleGroup);
        falseButton.setSelected(true);

        //laptopBox
        Label weightLabel = new Label("Weight:");
        TextField weightField = new TextField();

        //computerGroup
        Label cpuLabel = new Label("CPU:");
        Label gpuLabel = new Label("GPU:");
        Label ramLabel = new Label("RAM:");
        TextField cpuField = new TextField();
        TextField gpuField = new TextField();
        TextField ramField = new TextField();


        //Phone | Laptop | Computer
        ToggleGroup firstToggleGroup = new ToggleGroup();
        RadioButton phoneButton = new RadioButton("Phone");
        RadioButton laptopButton = new RadioButton("Laptop");
        RadioButton computerButton = new RadioButton("Computer");
        phoneButton.setToggleGroup(firstToggleGroup);
        laptopButton.setToggleGroup(firstToggleGroup);
        computerButton.setToggleGroup(firstToggleGroup);
        phoneButton.setSelected(true);

        firstToggleGroup.selectedToggleProperty().addListener(event ->{
            GridPane.clearConstraints(hasInternetConnectionLabel);
            GridPane.clearConstraints(trueButton);
            GridPane.clearConstraints(falseButton);
            GridPane.clearConstraints(weightLabel);
            GridPane.clearConstraints(weightField);
            GridPane.clearConstraints(cpuLabel);
            GridPane.clearConstraints(cpuField);
            GridPane.clearConstraints(gpuLabel);
            GridPane.clearConstraints(gpuField);
            GridPane.clearConstraints(ramLabel);
            GridPane.clearConstraints(ramField);
            central.getChildren().removeAll(hasInternetConnectionLabel, trueButton, falseButton, weightLabel, weightField,
                    cpuLabel, cpuField, gpuLabel, gpuField, ramLabel, ramField);
            if(phoneButton.isSelected()){
                categoryChoiceBox.setItems(FXCollections.observableArrayList(Menu.getNameOfCategories(Menu.phones)));
                categoryChoiceBox.setValue(Menu.getNameOfCategories(Menu.phones).get(0));
                GridPane.setConstraints(hasInternetConnectionLabel, 0, 6);
                GridPane.setConstraints(trueButton, 1, 6);
                GridPane.setConstraints(falseButton, 2, 6);

                central.getChildren().addAll(hasInternetConnectionLabel, trueButton, falseButton);
            }
            if(laptopButton.isSelected()){
                categoryChoiceBox.setItems(FXCollections.observableArrayList(Menu.getNameOfCategories(Menu.laptops)));
                categoryChoiceBox.setValue(Menu.getNameOfCategories(Menu.laptops).get(0));
                GridPane.setConstraints(weightLabel, 0, 6);
                GridPane.setConstraints(weightField, 1, 6);

                central.getChildren().addAll(weightLabel, weightField);
            }
            if(computerButton.isSelected()){
                categoryChoiceBox.setItems(FXCollections.observableArrayList(Menu.getNameOfCategories(Menu.computers)));
                categoryChoiceBox.setValue(Menu.getNameOfCategories(Menu.computers).get(0));
                GridPane.setConstraints(cpuLabel, 0, 6);
                GridPane.setConstraints(cpuField, 1, 6);
                GridPane.setConstraints(gpuLabel, 0, 7);
                GridPane.setConstraints(gpuField, 1, 7);
                GridPane.setConstraints(ramLabel, 0, 8);
                GridPane.setConstraints(ramField, 1, 8);

                central.getChildren().addAll(cpuLabel, cpuField, gpuLabel, gpuField, ramLabel, ramField);

            }
        });

        addButton.setOnAction(event -> {
            if(!nameField.getText().isEmpty() || !priceField.getText().isEmpty() || !countryField.getText().isEmpty()){
                String name = nameField.getText();
                int price = Integer.parseInt(priceField.getText());
                String country = countryField.getText();
                Category category = Menu.getCategoryByName(categoryChoiceBox.getValue().toString());

                if(phoneButton.isSelected()){
                    boolean hasInternetConnection = false;
                    if(trueButton.isSelected()){
                        hasInternetConnection = true;
                    }
                    Device newDevice = new Phone(name, price, country, hasInternetConnection);
                    category.addDevises(newDevice);
                }

                if(laptopButton.isSelected()){
                    int weight = Integer.parseInt(weightField.getText());
                    Device newDevice = new Laptop(name, price, country, weight);
                    category.addDevises(newDevice);
                }

                if(computerButton.isSelected()){
                    String cpu = cpuField.getText();
                    String gpu = gpuField.getText();
                    String ram = ramField.getText();
                    Device newDevice = new Computer(name, price, country, cpu, gpu, ram);
                    category.addDevises(newDevice);
                }

                messageLabel.setText("Done!");
            } else {
                messageLabel.setText("Some lines are empty!");
            }


        });

        GridPane.setConstraints(messageLabel, 0, 0);
        GridPane.setConstraints(addButton, 3, 0);
        GridPane.setConstraints(phoneButton, 0, 1);
        GridPane.setConstraints(laptopButton, 1, 1);
        GridPane.setConstraints(computerButton, 2, 1);
        GridPane.setConstraints(categoryLabel, 0, 2);
        GridPane.setConstraints(categoryChoiceBox, 1, 2);
        GridPane.setConstraints(nameLabel, 0, 3);
        GridPane.setConstraints(nameField, 1, 3);
        GridPane.setConstraints(priceLabel, 0, 4);
        GridPane.setConstraints(priceField, 1, 4);
        GridPane.setConstraints(countryLabel, 0, 5);
        GridPane.setConstraints(countryField, 1, 5);
        GridPane.setConstraints(hasInternetConnectionLabel, 0, 6);
        GridPane.setConstraints(trueButton, 1, 6);
        GridPane.setConstraints(falseButton, 2, 6);

        central.getChildren().addAll(hasInternetConnectionLabel, trueButton, falseButton);
        central.getChildren().addAll(messageLabel, addButton, phoneButton, laptopButton, computerButton,
                categoryLabel, categoryChoiceBox, nameLabel, nameField, priceLabel, priceField,
                countryLabel, countryField);
    }
}

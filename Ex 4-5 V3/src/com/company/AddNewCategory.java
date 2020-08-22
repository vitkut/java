package com.company;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class AddNewCategory extends Gui {

    public static void add(GridPane central){

        //messageBox
        Label messageLabel = new Label();
        Button addButton = new Button("Add");

        //nameBox
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        //Phone | Laptop | Computer
        ToggleGroup firstToggleGroup = new ToggleGroup();
        RadioButton phoneButton = new RadioButton("Phone");
        RadioButton laptopButton = new RadioButton("Laptop");
        RadioButton computerButton = new RadioButton("Computer");
        phoneButton.setToggleGroup(firstToggleGroup);
        laptopButton.setToggleGroup(firstToggleGroup);
        computerButton.setToggleGroup(firstToggleGroup);
        phoneButton.setSelected(true);

        addButton.setOnAction(event -> {
            if(!nameField.getText().isEmpty()){
                String name = nameField.getText();
                Category newCategory = new Category(name);
                if(phoneButton.isSelected()){
                    Menu.phones.add(newCategory);
                }
                if(laptopButton.isSelected()){
                  Menu.laptops.add(newCategory);
                }
                if(computerButton.isSelected()){
                    Menu.computers.add(newCategory);
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
        GridPane.setConstraints(nameLabel, 0, 2);
        GridPane.setConstraints(nameField, 1, 2);

        central.getChildren().addAll(messageLabel, addButton, phoneButton, laptopButton, computerButton, nameLabel, nameField);
    }
}

package com.company;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class AddDeviceIntoCategory extends Gui {

    public static void add(GridPane central){

        //messageBox
        Label messageLabel = new Label();
        Button addButton = new Button("Add");
        Label warningLabel = new Label();

        //arrowsBox
        Button rightArrowButton = new Button(">");
        Button leftArrowButton = new Button("<");
        VBox arrowBox = new VBox(10, rightArrowButton, leftArrowButton);
        arrowBox.setAlignment(Pos.CENTER);

        //oldDeviceBox
        TreeView<String> oldDevicesTree = new TreeView<>();
        oldDevicesTree.setPrefSize(300, 400);
        TreeItem<String> devicesOld = new TreeItem<>("Device");
        oldDevicesTree.setRoot(devicesOld);

        TreeItem<String> phonesOld = new TreeItem<>("Phones");
        TreeItem<String> laptopsOld = new TreeItem<>("Laptop");
        TreeItem<String> computersOld = new TreeItem<>("Computers");
        devicesOld.getChildren().addAll(phonesOld, laptopsOld, computersOld);
        for(Category i:Menu.phones){
            TreeItem<String> child = new TreeItem<>(i.getName());
            phonesOld.getChildren().add(child);
            for(Device j:i.getDevises()){
                child.getChildren().add(new TreeItem<>(j.getName()));
            }
        }
        for(Category i:Menu.laptops){
            TreeItem<String> child = new TreeItem<>(i.getName());
            laptopsOld.getChildren().add(child);
            for(Device j:i.getDevises()){
                child.getChildren().add(new TreeItem<>(j.getName()));
            }
        }
        for(Category i:Menu.computers){
            TreeItem<String> child = new TreeItem<>(i.getName());
            computersOld.getChildren().add(child);
            for(Device j:i.getDevises()){
                child.getChildren().add(new TreeItem<>(j.getName()));
            }
        }
        oldDevicesTree.getSelectionModel().select(devicesOld);

        //newDeviceBox
        TreeView<String> newDevicesTree = new TreeView<>();
        newDevicesTree.setPrefSize(300, 400);
        TreeItem<String> devicesNew = new TreeItem<>("To category");
        newDevicesTree.setRoot(devicesNew);

        TreeItem<String> phonesNew = new TreeItem<>("Phones");
        TreeItem<String> laptopsNew = new TreeItem<>("Laptop");
        TreeItem<String> computersNew = new TreeItem<>("Computers");
        devicesNew.getChildren().addAll(phonesNew, laptopsNew, computersNew);
        for(Category i:Menu.phones){
            TreeItem<String> child = new TreeItem<>(i.getName());
            phonesNew.getChildren().add(child);
        }
        for(Category i:Menu.laptops){
            TreeItem<String> child = new TreeItem<>(i.getName());
            laptopsNew.getChildren().add(child);
        }
        for(Category i:Menu.computers){
            TreeItem<String> child = new TreeItem<>(i.getName());
            computersNew.getChildren().add(child);
        }
        newDevicesTree.getSelectionModel().select(devicesNew);
        //rightArrowButton action
        ArrayList<String> actions = new ArrayList<>();//List of action -> decryption -> add device into category
        //example action -> "Iphone X > Smartphone"

        rightArrowButton.setOnAction(event -> {
            Device deviceFrom = Menu.getDeviceByName(oldDevicesTree.getSelectionModel().getSelectedItem().getValue());
            Category categoryTo = Menu.getCategoryByName(newDevicesTree.getSelectionModel().getSelectedItem().getValue());

            if(deviceFrom != null){

                if(categoryTo != null){
                    if(Menu.isFromOneCategories(deviceFrom, categoryTo)){
                        newDevicesTree.getSelectionModel().getSelectedItem().getChildren().add(new TreeItem<>(deviceFrom.getName()));
                        actions.add(deviceFrom.getName()+" > "+categoryTo.getName());
                    } else {
                        warningLabel.setText("Select device and category from one categories(Phones, Laptops, Computers)");
                    }
                } else {
                    warningLabel.setText("Category is not selected");
                }
            } else {
                warningLabel.setText("Device is not selected");
            }

        });

        //leftArrowButton action
        leftArrowButton.setOnAction(event -> {
            Device deviceFrom = Menu.getDeviceByName(newDevicesTree.getSelectionModel().getSelectedItem().getValue());
            Category categoryFrom = Menu.getCategoryByName(
                    newDevicesTree.getSelectionModel().getSelectedItem().getParent().getValue()
            );
            if(deviceFrom != null){
                actions.remove(deviceFrom+" > "+categoryFrom);
                newDevicesTree.getSelectionModel().getSelectedItem().getParent().getChildren().remove(
                        newDevicesTree.getSelectionModel().getSelectedItem()
                );
            } else {
                warningLabel.setText("Device is not selected");
            }
        });

        //addButton action
        addButton.setOnAction(event -> {
            addDevToCat(actions);
            messageLabel.setText("Done!");
        });


        GridPane.setConstraints(messageLabel, 0, 0);
        GridPane.setConstraints(addButton, 2, 0);
        GridPane.setConstraints(oldDevicesTree, 0, 1);
        GridPane.setConstraints(newDevicesTree, 2, 1);
        GridPane.setConstraints(arrowBox, 1, 1);
        GridPane.setConstraints(warningLabel, 0, 2, 3, 1);
        central.getChildren().addAll(messageLabel, addButton, oldDevicesTree, newDevicesTree, arrowBox, warningLabel);
    }

    private static void addDevToCat(ArrayList<String> actions){
        for(String i:actions){
            String[] deviceAndCategory = i.split(" > ", 2);
            Device device = Menu.getDeviceByName(deviceAndCategory[0]);
            Category category = Menu.getCategoryByName(deviceAndCategory[1]);
            category.addDevises(device);
        }
    }


}

package com.company;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class BuyDevice extends Gui {

    public static void buy(GridPane central, User user){
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

        //basketBox
        TreeView<String> basketTree = new TreeView<>();
        basketTree.setPrefSize(300, 400);
        TreeItem<String> basketInTree = new TreeItem<>("Basket");
        TreeItem<String> devicesBasket = new TreeItem<>("Devices");
        TreeItem<String> categoryBasket = new TreeItem<>("Categories");
        basketTree.setRoot(basketInTree);
        basketInTree.getChildren().addAll(devicesBasket, categoryBasket);

        //rightArrowButton action
        ArrayList<String> actions = new ArrayList<>();//List of action -> decryption -> add device into basket

        rightArrowButton.setOnAction(event -> {
            Device device = Menu.getDeviceByName(oldDevicesTree.getSelectionModel().getSelectedItem().getValue());
            if(device != null){
                actions.add(device.getName()+" > Device");
                devicesBasket.getChildren().add(oldDevicesTree.getSelectionModel().getSelectedItem());

            } else {
                Category category = Menu.getCategoryByName(oldDevicesTree.getSelectionModel().getSelectedItem().getValue());
                if(category != null){
                    actions.add(category.getName()+" > Category");
                    categoryBasket.getChildren().add(oldDevicesTree.getSelectionModel().getSelectedItem());
                } else {
                    warningLabel.setText("Select device or category");
                }
            }
        });

        //addButton action
        addButton.setOnAction(event -> {
            addToBasket(actions, user);
            messageLabel.setText("Done!");
        });


        GridPane.setConstraints(messageLabel, 0, 0);
        GridPane.setConstraints(addButton, 2, 0);
        GridPane.setConstraints(oldDevicesTree, 0, 1);
        GridPane.setConstraints(basketTree, 2, 1);
        GridPane.setConstraints(arrowBox, 1, 1);
        GridPane.setConstraints(warningLabel, 0, 2, 3, 1);
        central.getChildren().addAll(messageLabel, addButton, oldDevicesTree, basketTree, arrowBox, warningLabel);

    }

    private static void addToBasket(ArrayList<String> actions, User user){
        for(String i:actions){
            String[] strings = i.split(" > ", 2);
            if(strings[1].equals("Device")){
                Device device = Menu.getDeviceByName(strings[0]);
                user.addBasket(device);
            }
            if(strings[1].equals("Category")){
                Category category = Menu.getCategoryByName(strings[0]);
                user.addBasket(category);
            }
        }
    }
}

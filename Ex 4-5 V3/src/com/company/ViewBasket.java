package com.company;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ViewBasket extends Gui {

    public static void view(GridPane central, User user){
        //messageBox
        Label messageLabel = new Label();
        Button delButton = new Button("Delete");
        Button viewButton = new Button("View");
        Label warningLabel = new Label();

        //Device dataLabels

        Label nameLabel = new Label("Name:");
        Label priceLabel = new Label("Price:");
        Label countryLabel = new Label("Country");

        //Device subDataLabels
        Label hasInternetConnectionLabel = new Label("Internet:");
        Label weightLabel = new Label("Weight:");
        Label cpuLabel = new Label("CPU:");
        Label gpuLabel = new Label("GPU:");
        Label ramLabel = new Label("RAM:");

        VBox vBoxLabel = new VBox(10);

        //Device data

        Label name = new Label();
        Label price = new Label();
        Label country = new Label();

        //Device subData
        Label hasInternetConnection = new Label();
        Label weight = new Label();
        Label cpu = new Label();
        Label gpu = new Label();
        Label ram = new Label();

        VBox vBoxData = new VBox(10);

        //basketBox
        TreeView<String> basketTree = new TreeView<>();
        basketTree.setPrefSize(300, 400);
        TreeItem<String> basketInTree = new TreeItem<>("Basket");
        TreeItem<String> devicesBasket = new TreeItem<>("Devices");
        TreeItem<String> categoryBasket = new TreeItem<>("Categories");
        basketTree.setRoot(basketInTree);
        basketInTree.getChildren().addAll(devicesBasket, categoryBasket);

        //add devises from basket
        for(Device i:user.getBasket().getDevices()){
            TreeItem<String> child = new TreeItem<>(i.getName());
            devicesBasket.getChildren().add(child);
        }

        //add category from basket
        for(Category i:user.getBasket().getCategories()){
            TreeItem<String> child = new TreeItem<>(i.getName());
            categoryBasket.getChildren().add(child);
            for(Device j:i.getDevises()){
                child.getChildren().add(new TreeItem<>(j.getName()));
            }
        }

        //delButton action
        delButton.setOnAction(event -> {
            Device device = Menu.getDeviceByName(basketTree.getSelectionModel().getSelectedItem().getValue());
            if(device != null){
                user.getBasket().delDevice(device);
                basketTree.getSelectionModel().getSelectedItem().getParent().getChildren().remove(
                        basketTree.getSelectionModel().getSelectedItem()
                );
                messageLabel.setText("Deleted!");
            } else {
                Category category = Menu.getCategoryByName(basketTree.getSelectionModel().getSelectedItem().getValue());
                if(category != null){
                    user.getBasket().delCategory(category);
                    basketTree.getSelectionModel().getSelectedItem().getParent().getChildren().remove(
                            basketTree.getSelectionModel().getSelectedItem()
                    );
                    messageLabel.setText("Deleted!");
                } else {
                    warningLabel.setText("Select device or category");
                }
            }
        });

        //viewButton action
        viewButton.setOnAction(event -> {
            Device device = Menu.getDeviceByName(basketTree.getSelectionModel().getSelectedItem().getValue());
            vBoxLabel.getChildren().removeAll(nameLabel, priceLabel, countryLabel,
                    hasInternetConnectionLabel, weightLabel, cpuLabel, gpuLabel, ramLabel);
            vBoxData.getChildren().removeAll(name, price, country, hasInternetConnection, weight, cpu, gpu, ram);
            if(device != null){
                String categoriesName = Menu.getCategoriesByDevice(device);
                name.setText(device.getName());
                price.setText(String.format("%d", device.getPrice()));
                country.setText(device.getCountry());

                vBoxLabel.getChildren().addAll(nameLabel, priceLabel, countryLabel);
                vBoxData.getChildren().addAll(name, price, country);
                if(categoriesName.equals("Phone")){
                    if(device.getInternetConnection()){
                        hasInternetConnection.setText("Yes");
                    } else {
                        hasInternetConnection.setText("No");
                    }
                    vBoxLabel.getChildren().addAll(hasInternetConnectionLabel);
                    vBoxData.getChildren().addAll(hasInternetConnection);
                }
                if(categoriesName.equals("Laptop")){
                    weight.setText(String.format("%d", device.getWeight()));
                    vBoxLabel.getChildren().addAll(weightLabel);
                    vBoxData.getChildren().addAll(weight);
                }
                if(categoriesName.equals("Computer")){
                    cpu.setText(device.getCpu());
                    gpu.setText(device.getGpu());
                    ram.setText(device.getRam());
                    vBoxLabel.getChildren().addAll(cpuLabel, gpuLabel, ramLabel);
                    vBoxData.getChildren().addAll(cpu, gpu, ram);
                }
            } else {
                warningLabel.setText("Select device");
            }
        });

        GridPane.setConstraints(messageLabel, 0, 0);
        GridPane.setConstraints(delButton, 1, 0);
        GridPane.setConstraints(viewButton, 2, 0);
        GridPane.setConstraints(basketTree, 0, 1);
        GridPane.setConstraints(warningLabel, 0, 2, 3, 1);
        GridPane.setConstraints(vBoxLabel, 1, 1);
        GridPane.setConstraints(vBoxData, 2, 1);


        central.getChildren().addAll(messageLabel, delButton, viewButton, basketTree, vBoxLabel, vBoxData, warningLabel);
    }
}

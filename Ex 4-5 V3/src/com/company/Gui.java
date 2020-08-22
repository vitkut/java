package com.company;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Gui extends Application {

    public static User user;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Device shop");
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        SignIn.startSignIn(primaryStage);
        primaryStage.show();
    }

    public static void startFromMain(){
        launch();
    }

    public static void menuGui(Stage primaryStage, User thisUser){
        user = thisUser;
        BorderPane root = new BorderPane();

        HBox hBox = new HBox(10);
        VBox vBox = new VBox(10);

        GridPane central = new GridPane();
        central.setPadding(new Insets(5));
        central.setHgap(10);
        central.setVgap(10);

        root.setCenter(central);
        root.setLeft(vBox);
        root.setTop(hBox);

        //Create background vBox and hBox
        BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background vBoxBackground = new Background(backgroundFill);

        //hBox
        ChoiceBox menuChoiceBox = new ChoiceBox();
        menuChoiceBox.setItems(FXCollections.observableArrayList(
                "Menu", "Add new device", "Add new category", "Add device into category", "Buy device", "View users", "View basket"
        ));
        menuChoiceBox.setValue("Menu");
        menuChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov, Number old_val, Number new_val)->{
                    clearCenter(central);
                    switch (new_val.intValue()){
                        case 0:{
                            break;
                        }
                        case 1:{
                            AddNewDevice.add(central);
                            break;
                        }
                        case 2:{
                            AddNewCategory.add(central);
                            break;
                        }
                        case 3:{
                            AddDeviceIntoCategory.add(central);
                            break;
                        }
                        case 4:{
                            BuyDevice.buy(central, user);
                            break;
                        }
                        case 5:{
                            ViewUsers.view(central, user);
                            break;
                        }
                        case 6:{
                            ViewBasket.view(central, user);
                            break;
                        }
                    }
                }
        );

        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(menuChoiceBox);
        hBox.setBackground(vBoxBackground);

        //vBox
        Label usernameLabel = new Label("Username:\n  "+user.getUsername());
        Label idLabel = new Label("Id:\n  "+user.getId());
        Button signOutButton = new Button("SignOut");
        Button exitButton = new Button("Exit");
        vBox.getChildren().addAll(usernameLabel, idLabel, signOutButton, exitButton);
        vBox.setBackground(vBoxBackground);

        signOutButton.setOnAction(event -> {
            SignIn.startSignIn(primaryStage);
        });

        exitButton.setOnAction(event -> {
            primaryStage.close();
            System.exit(0);
        });

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    private static void clearCenter(GridPane central){
        central.getColumnConstraints().clear();
        central.getRowConstraints().clear();
        central.getChildren().clear();
    }
}

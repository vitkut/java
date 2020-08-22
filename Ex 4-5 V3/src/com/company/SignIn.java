package com.company;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SignIn extends Gui {

    public static void startSignIn(Stage primaryStage){
        GridPane root = new GridPane();
        root.setPadding(new Insets(5));
        root.setVgap(80);
        root.setHgap(10);
        root.setAlignment(Pos.TOP_CENTER);

        Label login = new Label("Login");
        Font font = Font.font("Arial Black", 24);
        login.setFont(font);
        Label register = new Label("Register");
        register.setFont(font);

        //loginBox
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");


        TextField username = new TextField();
        PasswordField password = new PasswordField();

        VBox loginBox = new VBox(10, usernameLabel, username, passwordLabel, password);
        Background loginBG = new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY));
        loginBox.setBackground(loginBG);

        //registerBox
        Label usernameLabelReg = new Label("Username:");
        Label passwordLabelReg = new Label("Password:");
        Label confirmPasswordLabel = new Label("Confirm:");
        TextField usernameReg = new TextField();
        username.setPrefSize(200, 20);
        PasswordField passwordReg = new PasswordField();
        PasswordField confirmPasswordReg = new PasswordField();

        VBox registerBox = new VBox(10, usernameLabelReg, usernameReg, passwordLabelReg,
                passwordReg, confirmPasswordLabel, confirmPasswordReg);

        Background regBG = new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY));
        registerBox.setBackground(regBG);

        //enterButton
        Button enterButton = new Button("Enter");
        enterButton.setFont(font);
        Label warningLabel = new Label();

        enterButton.setOnAction(event -> {
            if(!username.getText().isEmpty() && !password.getText().isEmpty()){
                int id = Menu.confirmLog(username.getText(), password.getText());
                if(id != -1){
                    User user = Menu.getUser(id);
                    menuGui(primaryStage, user);
                }
            } else {
                if(!usernameReg.getText().isEmpty() && !passwordReg.getText().isEmpty() && !confirmPasswordReg.getText().isEmpty()){
                    String message = Menu.confirmReg(usernameReg.getText(), passwordReg.getText(), confirmPasswordReg.getText());
                    if(message.equals("")){
                        User user = new User(usernameReg.getText(), passwordReg.getText());
                        Menu.addUser(user);
                        menuGui(primaryStage, user);
                    } else {
                        warningLabel.setText(message);
                    }
                } else {
                    warningLabel.setText("Some lines are empty");
                }
            }
        });

        GridPane.setHalignment(register, HPos.CENTER);
        GridPane.setHalignment(login, HPos.CENTER);
        GridPane.setHalignment(enterButton, HPos.CENTER);
        GridPane.setHalignment(warningLabel, HPos.CENTER);

        GridPane.setConstraints(login, 0, 0);
        GridPane.setConstraints(register, 1, 0);
        GridPane.setConstraints(loginBox, 0, 1);
        GridPane.setConstraints(registerBox, 1, 1);
        GridPane.setConstraints(enterButton, 0, 2, 2, 1);
        GridPane.setConstraints(warningLabel, 0, 3, 2, 1);

        root.getChildren().addAll(login, register, loginBox, registerBox, enterButton, warningLabel);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }
}

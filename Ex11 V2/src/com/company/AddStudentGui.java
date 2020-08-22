package com.company;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddStudentGui extends Gui {

    public static void addSt(TreeItem<String> rootOfTree, VBox leftVBox, Faculty faculty){
        //Labels
        Label lastNameLabel = new Label("Last name:");
        Label firstNameLabel = new Label("First name:");
        Label courseLabel = new Label("Course:");

        //Fields
        TextField lastNameField = new TextField();
        TextField firstNameField = new TextField();

        //ChoiceBox
        ChoiceBox courseChoiceBox = new ChoiceBox();
        courseChoiceBox.setItems(FXCollections.observableArrayList("1", "2", "3", "4"));
        courseChoiceBox.setValue("1");

        //Buttons
        Button addButton = new Button("Add");
        Button backButton = new Button("Back");
        HBox buttons = new HBox(5, addButton, backButton);

        //warningLabel
        Label warningLabel = new Label();

        //events
        addButton.setOnAction(event -> {
            if(!lastNameField.getText().isEmpty() && !firstNameField.getText().isEmpty()){
                String lastName = lastNameField.getText();
                String firstName = firstNameField.getText();
                int course = courseChoiceBox.getSelectionModel().getSelectedIndex()+1;
                Student newStudent = new Student(lastName, firstName, course);
                faculty.addStudent(newStudent);
                leftVBox.getChildren().clear();
                treeRefresh(rootOfTree);
            } else {
                warningLabel.setText("Some lines are empty");
            }
        });

        backButton.setOnAction(event -> {
            leftVBox.getChildren().clear();
            treeRefresh(rootOfTree);
        });

        leftVBox.getChildren().addAll(lastNameLabel, lastNameField, firstNameLabel, firstNameField,
                courseLabel, courseChoiceBox, buttons, warningLabel);
    }
}

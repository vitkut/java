package com.company;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddMarksGui extends Gui {

    public static void addM(VBox leftVBox, Student student){
        //Labels
        Label marksLabel = new Label("Marks:\nExample: 1 5 3 7");

        //Fields
        TextField marksField = new TextField();

        //Buttons
        Button addButton = new Button("Add");
        Button backButton = new Button("Back");
        HBox buttons = new HBox(20, addButton, backButton);

        //warningLabel
        Label warningLabel = new Label();

        //events
        addButton.setOnAction(event -> {
            if(!marksField.getText().isEmpty()){
                String[] score = marksField.getText().split(" ");
                try{
                    int[] marks = new int[score.length];
                    for(int i = 0; i < score.length; i++){
                        int mark = Integer.parseInt(score[i]);
                        if(mark < 10 && mark > 0){
                            marks[i] = mark;
                        } else {
                            throw new Exception("Wrong mark");
                        }
                    }
                    for(int mark:marks){
                        student.addScore(mark);
                    }
                    leftVBox.getChildren().clear();
                } catch (Exception ex){
                    warningLabel.setText("Wrong input data");
                }
            } else {
                warningLabel.setText("Some lines is empty");
            }
        });

        leftVBox.getChildren().addAll(marksLabel, marksField, buttons);
    }
}

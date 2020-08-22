package com.company;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Students data");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(500);
        primaryStage.show();
        menu(primaryStage);
    }

    public static void startGui(){
        launch();
    }

    public static void menu(Stage primaryStage){
        VBox root = new VBox(5);

        //topHBox
        Button saveButton = new Button("Save");
        Button goToNewCourseButton = new Button("Go to new course");
        ChoiceBox sortBox = new ChoiceBox();
        sortBox.setItems(FXCollections.observableArrayList("Without sorting", "Sort by name",
                "Sort by average score Min -> Max", "Sort by average score Max -> Min"));
        sortBox.setValue("Without sorting");
        Button addStudentButton = new Button("Add student");
        Button delStudentButton = new Button("Delete student");
        Button addMarksButton = new Button("Add marks");
        Button viewInfo = new Button("View info");
        Button exitButton = new Button("Exit");

        HBox topHBox = new HBox(5);
        topHBox.getChildren().addAll(saveButton, goToNewCourseButton, sortBox,
                addStudentButton, delStudentButton, addMarksButton, viewInfo, exitButton);

        //warningLabel
        Label warningLabel = new Label();

        //centralHBox
        TreeView<String> viewStudentsTree = new TreeView<>();
        viewStudentsTree.setPrefSize(primaryStage.getWidth()/2, primaryStage.getHeight()-200);
        TreeItem<String> rootOfTree = new TreeItem<>("");
        viewStudentsTree.setRoot(rootOfTree);
        getTreeWithoutSort(rootOfTree);

        VBox leftBox = new VBox(5);


        HBox centralHBox = new HBox(5);
        centralHBox.getChildren().addAll(viewStudentsTree, leftBox);

        //infoLabel
        Label infoLabel = new Label("Info:");

        //events
        sortBox.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
                    switch (new_val.intValue()){
                        case 0:{//Without sorting
                            getTreeWithoutSort(rootOfTree);
                            break;
                        }
                        case 1:{//Sorted by name
                            getTreeNameSort(rootOfTree);
                            break;
                        }
                        case 2:{//Sorted by average score min max
                            getTreeMinMaxSort(rootOfTree);
                            break;
                        }
                        case 3:{//Sorted by average score max min
                            getTreeMaxMinSort(rootOfTree);
                            break;
                        }
                    }
                }
        );

        exitButton.setOnAction(event -> {
            SaveDataBase.save();
            primaryStage.close();
            System.exit(0);
        });

        saveButton.setOnAction(event -> {
            SaveDataBase.save();
            warningLabel.setText("Saved.");
        });

        goToNewCourseButton.setOnAction(event -> {
            GoToNewCourse.go();
            treeRefresh(rootOfTree);
        });

        addStudentButton.setOnAction(event -> {
            leftBox.getChildren().clear();
            try{
                Faculty faculty = Main.getFacultyByName(viewStudentsTree.getSelectionModel().getSelectedItem().getValue());
                if(faculty != null){
                    AddStudentGui.addSt(rootOfTree, leftBox, faculty);
                } else {
                    throw new Exception("No faculty");
                }
            } catch (Exception ex){
                warningLabel.setText("Select faculty");
            }
        });

        delStudentButton.setOnAction(event -> {
            try{
                Student student = Main.getStudentByName(viewStudentsTree.getSelectionModel().getSelectedItem().getValue());
                if(student != null){
                    Faculty faculty = Main.getFacultyByName(viewStudentsTree.getSelectionModel().getSelectedItem().getParent().getValue());
                    faculty.delStudent(student);
                    treeRefresh(rootOfTree);
                } else {
                    throw new Exception("No student");
                }
            } catch (Exception ex){
                warningLabel.setText("Select student");
            }

        });

        addMarksButton.setOnAction(event -> {
            leftBox.getChildren().clear();
            try{
                Student student = Main.getStudentByName(viewStudentsTree.getSelectionModel().getSelectedItem().getValue());
                if(student != null){
                    AddMarksGui.addM(leftBox, student);
                } else {
                    throw new Exception("No student");
                }
            } catch (Exception ex){
                warningLabel.setText("Select student");
            }

        });

        viewInfo.setOnAction(event -> {
            University university = Main.getUniversityByName(viewStudentsTree.getSelectionModel().getSelectedItem().getValue());
            if(university != null){
                StringBuilder faculties = new StringBuilder();
                for(int i = 0; i < university.getFaculties().size(); i++){
                    if(i == university.getFaculties().size()-1){
                        faculties.append(university.getFaculties().get(i).getFacultyName());
                    } else {
                        faculties.append(university.getFaculties().get(i).getFacultyName()+", ");
                    }
                }
                infoLabel.setText(String.format("Info:%nUniversity name: %-10sFaculties: %s%n" +
                        "Count of students: %-10dAverage score of students: %.2f",
                        university.getUniversityName(), faculties.toString(), university.getCountOfStudents(),
                        university.getAverageScore()));
            } else {
                Faculty faculty = Main.getFacultyByName(viewStudentsTree.getSelectionModel().getSelectedItem().getValue());
                if(faculty != null){
                    infoLabel.setText(String.format("Info:%nFaculty name: %s%n" +
                            "Count of students: %-10dAverage score of students: %.2f",
                            faculty.getFacultyName(), faculty.getCountOfStudents(), faculty.getAverageScore()));
                } else {
                    Student student = Main.getStudentByName(viewStudentsTree.getSelectionModel().getSelectedItem().getValue());
                    if(student != null){
                        infoLabel.setText(String.format("Info:%nLast name: %-10sFirst name: %s%n" +
                                        "Course: %-10dAverage score: %-10.2fScore: %s", student.getLastName(), student.getFirstName(),
                                student.getCourse(), student.getAverageScore(), student.getScore()));
                    } else {
                        warningLabel.setText("Select university or faculty or student");
                    }
                }
            }
        });



        root.getChildren().addAll(topHBox, warningLabel, centralHBox, infoLabel);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public static void treeRefresh(TreeItem<String> rootOfTree){
        switch (rootOfTree.getValue()){
            case "Students without sorting":{
                getTreeWithoutSort(rootOfTree);
                break;
            }
            case "Students sorted by name":{
                getTreeNameSort(rootOfTree);
                break;
            }
            case "Students sorted by average score Min -> Max":{
                getTreeMinMaxSort(rootOfTree);
                break;
            }
            case "Students sorted by average score Max -> Min":{
                getTreeMaxMinSort(rootOfTree);
                break;
            }
        }
    }

    private static void getTreeWithoutSort(TreeItem<String> rootOfTree){
        rootOfTree.getChildren().clear();
        rootOfTree.setValue("Students without sorting");
        for(University un:Main.getUniversities()){
            TreeItem<String> university = new TreeItem<>(un.getUniversityName());
            rootOfTree.getChildren().add(university);
            for(Faculty fa:un.getFaculties()){
                TreeItem<String> faculty = new TreeItem<>(fa.getFacultyName());
                university.getChildren().add(faculty);
                for(Student st:fa.getStudents()){
                    TreeItem<String> student = new TreeItem<>(String.format("%s %s",
                            st.getLastName(), st.getFirstName()));
                    faculty.getChildren().add(student);
                }
            }
        }


    }

    private static void getTreeNameSort(TreeItem<String> rootOfTree){
        rootOfTree.getChildren().clear();
        rootOfTree.setValue("Students sorted by name");
        ArrayList<Student> allStudents = SortName.sort();
        for(Student st:allStudents){
            TreeItem<String> student = new TreeItem<>(st.getLastName()+" "+st.getFirstName());
            rootOfTree.getChildren().add(student);
        }
    }

    private static void getTreeMinMaxSort(TreeItem<String> rootOfTree){
        rootOfTree.getChildren().clear();
        rootOfTree.setValue("Students sorted by average score Min -> Max");
        ArrayList<Student> allStudents = SortAverageScoreMinMax.sort();
        for(Student st:allStudents){
            TreeItem<String> student = new TreeItem<>(st.getLastName()+" "+st.getFirstName());
            rootOfTree.getChildren().add(student);
        }
    }

    private static void getTreeMaxMinSort(TreeItem<String> rootOfTree){
        rootOfTree.getChildren().clear();
        rootOfTree.setValue("Students sorted by average score Max -> Min");
        ArrayList<Student> allStudents = SortAverageScoreMaxMin.sort();
        for(Student st:allStudents){
            TreeItem<String> student = new TreeItem<>(st.getLastName()+" "+st.getFirstName());
            rootOfTree.getChildren().add(student);
        }
    }

}

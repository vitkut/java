package com.company;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ViewUsers extends Gui {

    public static void view(GridPane central, User user){
        Label users = new Label();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Users:\n");
        for (User i:Menu.userList){
            stringBuilder.append("Id: "+i.getId()+"; Username: "+i.getUsername());
            if(i.equals(user)){
                stringBuilder.append(" <- You");
            }
            stringBuilder.append("\n");
        }

        users.setText(stringBuilder.toString());
        GridPane.setConstraints(users, 0, 0);
        central.getChildren().add(users);
    }
}

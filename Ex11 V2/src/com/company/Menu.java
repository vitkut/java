package com.company;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    public static void menu(){
        System.out.println("Command>");
        StringBuffer stringBuffer = new StringBuffer(scanner.nextLine());
        decoder(stringBuffer);
        menu();
    }

    private static void decoder(StringBuffer stringBuffer){
        boolean isCompleted = false;
        if(Pattern.matches("/help", stringBuffer)){
            Help.help();
            isCompleted = true;
        }
        if(Pattern.matches("/addst", stringBuffer)){
            AddStudent.add();
            isCompleted = true;
        }
        if(Pattern.matches("/delst", stringBuffer)){
            DelStudent.delStudent();
            isCompleted = true;
        }
        if(Pattern.matches("/view", stringBuffer)){
            ViewStudents.view();
            isCompleted = true;
        }
        if(Pattern.matches("/exit", stringBuffer)){
            SaveDataBase.save();
            System.exit(0);
        }
        if(Pattern.matches("/save", stringBuffer)){
            SaveDataBase.save();
            isCompleted = true;
        }
        if(Pattern.matches("/sort", stringBuffer)){
            SortStudents.sort();
            isCompleted = true;
        }
        if(Pattern.matches("/go", stringBuffer)){
            GoToNewCourse.go();
            isCompleted = true;
        }
        if(Pattern.matches("/addm", stringBuffer)){
            AddMarks.add();
            isCompleted = true;
        }
        if(!isCompleted){
            System.out.println("Can't resolve the command. Try again");
        }
    }

}

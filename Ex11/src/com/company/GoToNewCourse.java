package com.company;

public class GoToNewCourse {

    public static void go(){
        for(University i:Main.getUniversities()){
            for(Faculty j:i.getFaculties()){
                for (int s = 0; s < j.getStudents().size(); s++){
                    if(j.getStudents().get(s).getAverageScore() < 4 || j.getStudents().get(s).getCourse() == 4){
                        j.delStudent(j.getStudents().get(s));
                    } else {
                        j.getStudents().get(s).setCourse(j.getStudents().get(s).getCourse()+1);
                    }
                }
            }
        }
        System.out.println("Done");
    }
}

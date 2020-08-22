package com.company;

import java.util.ArrayList;

public class Student {

    private String lastName;
    private String firstName;
    private int course;
    private double averageScore;
    private ArrayList<Integer> score = new ArrayList<>();

    public Student(){

    }

    public Student(String lastName, String firstName, int course){
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setAverageScore() {
        int summaryScore = 0;
        double averageScore = 0;
        for(Integer i:score){
            summaryScore += i;
        }
        averageScore +=summaryScore;
        averageScore = averageScore/score.size();
        this.averageScore = averageScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public String getScore(){
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < score.size(); i++){
            stringBuilder.append(score.get(i));
            if(i != score.size()-1){
                stringBuilder.append(", ");
            } else {
                stringBuilder.append("]");
            }
        }
        return stringBuilder.toString();
    }

    public void addScore(int mark){
        score.add(mark);
        setAverageScore();
    }

    public void setCourse(int course) {
        this.course = course;
    }
}

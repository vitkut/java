package com.company;

public class WrongPasswordException extends Exception {

    private String parameter;

    public WrongPasswordException(){}

    public WrongPasswordException(String message, String parameter){
        super(message);
        setParameter(parameter);
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}

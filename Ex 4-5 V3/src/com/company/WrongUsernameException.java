package com.company;

public class WrongUsernameException extends Exception {

    private String parameter;

    public WrongUsernameException(){}

    public WrongUsernameException(String message, String parameter){
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

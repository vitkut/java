package com.company;

public class IncorrectEmailException extends Exception {

    private String parameter;

    public IncorrectEmailException(){}

    public IncorrectEmailException(String message, String parameter){
        super(message);
        setParameter(parameter);
        Logs.errLogs(message, parameter);
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}
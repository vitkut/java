package com.company;

public class IncorrectNumberException extends Exception {

    private String parameter;

    public IncorrectNumberException(){}

    public IncorrectNumberException(String message, String parameter){
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

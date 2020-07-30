package com.company;

public class WrongSymbolException extends Exception {

    private String parameter;

    public WrongSymbolException(){}

    public WrongSymbolException(String message, String parameter){
        super(message);
        setParameter(parameter);
    }

    public WrongSymbolException(String message){
        super(message);
        setParameter(message);
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}

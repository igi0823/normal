package com.example.demo.exc;

public class SentryException extends RuntimeException {

    public SentryException(){
        super();
    }

    public SentryException(String msg){
        super(msg);

    }
}

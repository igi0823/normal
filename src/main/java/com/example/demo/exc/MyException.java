package com.example.demo.exc;


public class MyException extends RuntimeException {


    public MyException(){
        super();
    }

    public MyException(String msg){
        super(msg);

    }
}

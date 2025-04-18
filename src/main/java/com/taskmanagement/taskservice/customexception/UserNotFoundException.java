package com.taskmanagement.taskservice.customexception;

public class UserNotFoundException extends RuntimeException{
    String msg;

    public UserNotFoundException(String msg){
        super(msg);
    }
}

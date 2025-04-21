package com.taskmanagement.taskservice.customexception;

public class TaskNotFoundException extends RuntimeException{

    String msg;

    public TaskNotFoundException(String msg){
        super(msg);
    }

}

package com.devlil0.todolist.todolist.exception;



public class ApiException extends RuntimeException {

    public ApiException(String msg){
        super(msg);
    }
}

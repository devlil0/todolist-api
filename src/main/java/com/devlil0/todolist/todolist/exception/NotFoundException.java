package com.devlil0.todolist.todolist.exception;


public class NotFoundException extends RuntimeException {

    public NotFoundException(Long id){
        super("TAKS WITH ID + " + id + " NOT FOUND");
    }
}

package com.example.demo.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String str) {
        super(str);
    }
}

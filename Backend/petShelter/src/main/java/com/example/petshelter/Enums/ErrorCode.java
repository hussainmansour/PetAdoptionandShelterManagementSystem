package com.example.petshelter.Enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    LOGIN_FAILED(1 , "Incorrect username or password"),
    USERNAME_ALREADY_EXIST(2, "Username already exists");



    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

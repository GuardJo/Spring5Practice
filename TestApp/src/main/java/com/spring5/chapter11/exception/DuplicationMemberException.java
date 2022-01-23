package com.spring5.chapter11.exception;

public class DuplicationMemberException extends RuntimeException {
    public DuplicationMemberException(String message) {
        super(message);
    }
}

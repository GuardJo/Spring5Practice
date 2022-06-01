package com.spring5.chapter16.controller;

import com.spring5.chapter11.exception.MemberNotFoundException;
import com.spring5.chapter16.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestMemberControllerAdvice {
    private final static Logger log = LoggerFactory.getLogger(RestMemberControllerAdvice.class);

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoData() {
        log.warn("[Test] Advice Response");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member"));
    }
}

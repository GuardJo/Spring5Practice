package com.spring5.chapter14.controller;

import com.spring5.chapter11.exception.MemberNotFoundException;
import com.spring5.chapter16.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.spring5")
public class CommonExceptionController {
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException exception, Model model) {
        model.addAttribute("exception", exception.getMessage());
        return "error/commonException";
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoData() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member"));
    }
}
